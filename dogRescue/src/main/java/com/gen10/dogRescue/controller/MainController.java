/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gen10.dogRescue.controller;

import com.gen10.dogRescue.entities.Adoption;
import com.gen10.dogRescue.entities.Breed;
import com.gen10.dogRescue.entities.Contact;
import com.gen10.dogRescue.entities.Dog;
import com.gen10.dogRescue.entities.LifeStage;
import com.gen10.dogRescue.entities.PaymentType;
import com.gen10.dogRescue.entities.Role;
import com.gen10.dogRescue.entities.Size;
import com.gen10.dogRescue.entities.Special;
import com.gen10.dogRescue.entities.State;
import com.gen10.dogRescue.entities.TrainLevel;
import com.gen10.dogRescue.entities.User;
import com.gen10.dogRescue.repositories.AdoptionRepository;
import com.gen10.dogRescue.repositories.BreedRepository;
import com.gen10.dogRescue.repositories.ContactRepository;
import com.gen10.dogRescue.repositories.DogRepository;
import com.gen10.dogRescue.repositories.LifeStageRepository;
import com.gen10.dogRescue.repositories.PaymentTypeRepository;
import com.gen10.dogRescue.repositories.SizeRepository;
import com.gen10.dogRescue.repositories.SpecialRepository;
import com.gen10.dogRescue.repositories.StateRepository;
import com.gen10.dogRescue.repositories.TrainLevelRepository;
import com.gen10.dogRescue.service.ServiceLayer;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
//import java.sql.Date;
import java.util.Calendar;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.validation.Validation;
import javax.validation.Validator;
import org.springframework.validation.BindingResult;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

/**
 *
 * @author sakim
 */
@Controller
public class MainController {

    @Autowired
    ServiceLayer service;

    @GetMapping("/")
    public String index(Model model) {
        List<Dog> featuredDogs = service.findFeaturedDogs();

        model.addAttribute("dogs", featuredDogs);
        model.addAttribute("breeds", service.findAllBreeds());
        return "index";
    }

    @GetMapping("/puppy")
    public String puppySearch(Model model) {
        List<LifeStage> lsList = service.findAllLifeStages();
        model.addAttribute("lifeStages", lsList);
        return "puppy";
    }

    @GetMapping("/search/{lifestageId}")
    @ResponseBody
    public List<Dog> searchByNameBreedLifeStage(@PathVariable int lifestageId, @RequestParam(required = false) String userinput) {
        String userinput1 = (userinput == null) ? "" : userinput;

        List<Dog> dogs = service.findDogsByAllSearch(userinput1, lifestageId);
        System.out.println(dogs);
        return dogs;
    }

    @GetMapping("adoption/search/{lifestageId}")
    @ResponseBody
    public List<Dog> searchByNameBreedLifeStageAdoption(@PathVariable int lifestageId, @RequestParam String userinput) {
        List<Dog> dogs = service.findDogsByAllSearch(userinput, lifestageId);
        System.out.println(dogs);
        return dogs;
    }

    @GetMapping("/adminDogs")
    public String DogPage(Model model) {
        List<LifeStage> lsList = service.findAllLifeStages();
        model.addAttribute("lifeStages", lsList);
        return "adminDogs";
    }

    @GetMapping("adminDogs/search/{lifestageId}")
    @ResponseBody
    public List<Dog> searchByLifeStageAllDogsAdmin(@PathVariable int lifestageId, @RequestParam String userinput) {

        List<Dog> dogs = service.findDogsByAllSearchAdmin(userinput, lifestageId);
        System.out.println(dogs);
        return dogs;
    }

    @PostMapping("addDog")
    public String addDog(Dog dog, MultipartHttpServletRequest request) throws IOException {
        MultipartFile image = request.getFile("image");
        boolean empty = image.isEmpty();
        if (empty == true) {

            service.save(dog);
        } else {

//            MultipartFile image = request.getFile("image");
            Dog getDogForId = service.save(dog);
            int dogid = getDogForId.getId();
            String imagepath = service.uploadFile(image, dogid);
            int index = imagepath.lastIndexOf("images");
            String imgname = imagepath.substring(index);
            dog.setImagepath(imgname);

            service.save(dog);
        }
        return "redirect:/adminDogs";
    }

    @GetMapping("/display")
    public String display(int id, Model model
    ) {
        Dog dog = service.findById(id);

        model.addAttribute("dog", dog);
        return "display";
    }

    @GetMapping("/specials")
    public String displaySpecial(Model model
    ) {
        List<Special> specials = service.findAllSpecials();

        model.addAttribute("specials", specials);
        return "specials";
    }

    @GetMapping("/contact")
    public String contactPage() {
        return "contact";
    }

    @PostMapping("/addContact")
    public String addContact(@Valid Contact contact, BindingResult result,
             HttpServletRequest request
    ) {
        // int dogId = Integer.parseInt(request.getParameter("dogId"));
        if (result.hasErrors()) {
            return "contact";
        }
        service.saveContact(contact);

        //return "redirect:/viewInventory?id=" + storeId;
        return "redirect:/";
    }

    @GetMapping("/adoption")
    public String adoption(Model model
    ) {
        List<LifeStage> lsList = service.findAllLifeStages();
        model.addAttribute("lifeStages", lsList);
        return "/adoption";
    }

    @GetMapping("/addAdoption")
    public String AdoptionForm(int id, Model model
    ) {

        Dog dog = service.findById(id);

        model.addAttribute("dog", dog);

        List<PaymentType> ptList = service.findAllPaymentTypes();
        List<State> stateList = service.findAllState();
        List<User> userList = service.findAllUsers();

        model.addAttribute("adoption", new Adoption());
        model.addAttribute("paymentTypes", ptList);
        model.addAttribute("states", stateList);
        model.addAttribute("users", userList);

        return "/addAdoption";
    }

    @PostMapping("/addAdoption")
    public String addAdoption(Adoption adoption, Model model,
             HttpServletRequest request
    ) {
//        if (result.hasErrors()) {
//            return "addAdoption";
//        }

        int dogId = Integer.parseInt(request.getParameter("dogId"));
        Dog dog = service.findById(dogId);
        model.addAttribute("dog", dog);
        adoption.setDog(dog);
        int paymentTypeId = Integer.parseInt(request.getParameter("paymentTypeId"));
        PaymentType pt = service.findPaymentTypeById(paymentTypeId);
        adoption.setPaymentType(pt);
        BigDecimal price = new BigDecimal(request.getParameter("price"));
        adoption.setPurchaseprice(price);

        int stateId = Integer.parseInt(request.getParameter("stateId"));
        State st = service.findStateById(stateId);
        adoption.setState(st);

        int userId = Integer.parseInt(request.getParameter("userId"));
        User usr = service.findUserById(userId);
        adoption.setUser(usr);

        service.saveAdoption(adoption);
        dog.setIsavailable(false);
        service.save(dog);

//        List<PaymentType> ptList = service.findAllPaymentTypes();
//        List<State> stateList = service.findAllState();
//        List<User> userList = service.findAllUsers();
//        
//        model.addAttribute("paymentTypes", ptList);
//        model.addAttribute("states", stateList);
//        model.addAttribute("users", userList);
        return "redirect:/adoption";
    }

    @PostMapping("/editDog")
    public String editDog(Dog dog, MultipartHttpServletRequest request) throws IOException {
        MultipartFile image = request.getFile("image");
        boolean empty = image.isEmpty();
        if (empty == true) {
            String originalImg = service.noFileEdit(dog.getId());
            int index = originalImg.lastIndexOf("images");
            String imgname = originalImg.substring(index);
            dog.setImagepath(imgname);
            service.save(dog);
        } else {
            String imagepath = service.uploadFileEditDog(image, dog.getId());
            int index = imagepath.lastIndexOf("images");
            String imgname = imagepath.substring(index);
            dog.setImagepath(imgname);
            service.save(dog);
        }

        //   dog.setImagepath(imagepath);
        // Dog dog = service.findById(id);
        //int breedId = Integer.parseInt(request.getParameter("breedId"));
        //Breed breed = service.findBreedById(breedId);
        //  model.addAttribute("dog", dog);
        return "redirect:/adminDogs";
    }

    @GetMapping("/editDog")
    public String editDogPage(@RequestParam int id, Model model
    ) {
        Dog dog = service.findById(id);
        List<Breed> breeds = service.findAllBreeds();
        List<Size> sizes = service.findAllSize();
        List<LifeStage> lifestages = service.findAllLifeStages();
        List<TrainLevel> trainlevels = service.findAllTrainLevels();

        model.addAttribute("dog", dog);
        model.addAttribute("breeds", breeds);
        model.addAttribute("sizes", sizes);
        model.addAttribute("lifestages", lifestages);
        model.addAttribute("trainlevels", trainlevels);
        return "editDog";
    }

    @GetMapping("/deleteDog")
    public String deleteDog(int id, Model model
    ) {
        service.deleteById(id);
        return "redirect:/adminDogs";
    }

    @GetMapping("/addDog")
    public String addDogPage(Model model
    ) {
        List<Breed> breeds = service.findAllBreeds();
        List<Size> sizes = service.findAllSize();
        List<LifeStage> lifeStages = service.findAllLifeStages();
        List<TrainLevel> trainLevels = service.findAllTrainLevels();

        model.addAttribute("breeds", breeds);
        model.addAttribute("sizes", sizes);
        model.addAttribute("lifestages", lifeStages);
        model.addAttribute("trainlevels", trainLevels);
        model.addAttribute("dog", new Dog());

        return "/addDog";
    }

    @GetMapping("/coordinatorBreed")
    public String getBreedPage(Model model
    ) {
        List<Breed> breeds = service.findAllBreeds();

        model.addAttribute("breeds", breeds);
        model.addAttribute("breed", new Breed());
        return "/coordinatorBreed";
    }

    @PostMapping("/addBreed")
    public String addBreed(Breed breed
    ) {

        User usr = service.findUserById(3);
        breed.setUser(usr);

        service.saveBreed(breed);

        return "redirect:/coordinatorBreed";
    }

    @GetMapping("/adminTrainLevel")
    public String getTrainLevelPage(Model model
    ) {
        List<TrainLevel> trainlevels = service.findAllTrainLevels();

        model.addAttribute("trainlevels", trainlevels);
        model.addAttribute("trainlevel", new TrainLevel());
        return "/adminTrainLevel";
    }

    @PostMapping("/addTrainLevel")
    public String addTrainLevel(TrainLevel tl
    ) {

        User usr = service.findUserById(1);
        tl.setUser(usr);

        service.saveTrainLevel(tl);
        return "redirect:/adminTrainLevel";
    }

    @GetMapping("/user")
    public String userPage(Model model
    ) {
        List<User> users = service.findAllUsers();

        model.addAttribute("users", users);
        return "/user";
    }

    @GetMapping("/addUser")
    public String addUserPage(Model model
    ) {
        List<Role> roles = service.findAllRoles();
        model.addAttribute("roles", roles);
        model.addAttribute("user", new User());

        return "/addUser";

    }

    @PostMapping("/addUser")
    public String addUser(User user, Model model
    ) {
        List<Role> roles = service.findAllRoles();
        model.addAttribute("roles", roles);

        service.saveUser(user);

        return "redirect:/user";

    }

    @GetMapping("/editUser")
    public String editUserPage(@RequestParam int id, Model model
    ) {
        User usr = service.findUserById(id);
        model.addAttribute("user", usr);

        List<Role> roles = service.findAllRoles();
        model.addAttribute("roles", roles);

        return "editUser";
    }
    
    @PostMapping("editUser")
    public String editUser(User user, Model model) {
         List<Role> roles = service.findAllRoles();
        model.addAttribute("roles", roles);

        service.saveUser(user);

        return "redirect:/user";
    }

    @GetMapping("/adminSpecials")
    public String adminSpecialsPage(Model model
    ) {
        List<Special> specials = service.findAllSpecials();
        model.addAttribute("specials", specials);
        model.addAttribute("special", new Special());

        return "/adminSpecials";
    }

    @PostMapping("/addSpecial")
    public String addSpecial(Model model, Special spc
    ) {
        service.saveSpecial(spc);

        return "redirect:/adminSpecials";
    }

    @GetMapping("/deleteSpecial")
    public String deleteSpecial(int id, Model model
    ) {
        service.deleteSpecialById(id);
        return "redirect:/adminSpecials";
    }

    @GetMapping("/report")
    public String reportPage() {
        return "report";
    }

    @GetMapping("/adoptionReport")
    public String adoptionReport(Model model
    ) {
        List<User> users = service.findAllUsers();
        model.addAttribute("users", users);

        return "/adoptionReport";
    }

    @GetMapping("adoptionReport/adoptionReportSearch/{userid}")
    @ResponseBody
    public List<Adoption> adoptionSearch(
            @RequestParam(required = false) String fromdate,
            @RequestParam(required = false) String todate,
            @PathVariable int userid
    ) throws ParseException {
        String fromDate = (fromdate == null) ? "2000-01-01" : fromdate;
        String toDate = (todate == null) ? "2099-12-31" : todate;
        return service.findAdoptionByAllSearch(userid, fromDate, toDate);
    }

    @GetMapping("/dogReport")
    public String dogReport(Model model
    ) {
        List<Dog> puppies = service.findAllDogsByLifeStage(1);
        model.addAttribute("puppies", puppies);
        List<Dog> youngsters = service.findAllDogsByLifeStage(2);
        model.addAttribute("youngsters", youngsters);
        List<Dog> adults = service.findAllDogsByLifeStage(3);
        model.addAttribute("adults", adults);
        List<Dog> seniors = service.findAllDogsByLifeStage(4);
        model.addAttribute("seniors", seniors);

        return "dogReport";
    }

    @GetMapping("/detailContact")
    public String displayDetailContact(int id, Model model
    ) {
        Dog dog = service.findById(id);

        model.addAttribute("dog", dog);
        model.addAttribute("contact", new Contact());
        return "detailContact";
    }

    @PostMapping("/addDetailContact")
    public String addDetailContact(Contact contact, HttpServletRequest request
    ) {
//        if (result.hasErrors()) {
//            return "detailContact";
//        }
//        String dogname = (String) (request.getParameter("dogname"));
//        contact.setDogname(dogname);
        service.saveContact(contact);

        return "redirect:/puppy";
    }

    @GetMapping("contactReport")
    public String contactReport(Model model
    ) {
        List<Contact> contacts = service.findAllContacts();
        model.addAttribute("contacts", contacts);
        return "/contactReport";
    }

//    @PostMapping("/uploadImage")
//    public String uploadImage(@RequestParam MultipartFile image) throws IOException {
//        service.uploadFile(image);
//        return "redirect:/addDog";
//    }
    @GetMapping("/login")
    public String loginPage() {
        return "/login";
    }

    @PostMapping("accessLogin")
    public String login(HttpServletRequest request
    ) {
        String username = request.getParameter("email");
        String password = request.getParameter("password");
        String page = service.login(username, password);

        return page;
    }

    @GetMapping("/adminAdoption")
    public String adminAdoptionPage(Model model
    ) {
        model.addAttribute("lifeStages", service.findAllLifeStages());
        return "/adminAdoption";
    }
    
    @GetMapping("/information")
    public String information() {
        return "/information";
    }
}
