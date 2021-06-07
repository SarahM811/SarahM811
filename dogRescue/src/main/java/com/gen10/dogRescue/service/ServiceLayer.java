/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gen10.dogRescue.service;

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
import com.gen10.dogRescue.repositories.RoleRepository;
import com.gen10.dogRescue.repositories.SizeRepository;
import com.gen10.dogRescue.repositories.SpecialRepository;
import com.gen10.dogRescue.repositories.StateRepository;
import com.gen10.dogRescue.repositories.TrainLevelRepository;
import com.gen10.dogRescue.repositories.UserRepository;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
//import java.sql.Date;
import java.util.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
//import javax.validation.Path;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author sakim
 */
@Service
public class ServiceLayer {

    private String upload_folder = "C:\\Users\\sakim\\Documents\\bitbucket\\sarah-melvin-individual-work\\dogRescue\\src\\main\\resources\\static\\images";

    @Autowired
    AdoptionRepository adoptions;

    @Autowired
    BreedRepository breeds;

    @Autowired
    ContactRepository contacts;

    @Autowired
    DogRepository dogs;

    @Autowired
    LifeStageRepository lifeStages;

    @Autowired
    PaymentTypeRepository paymentTypes;

    @Autowired
    SizeRepository sizes;

    @Autowired
    SpecialRepository specials;

    @Autowired
    StateRepository states;

    @Autowired
    TrainLevelRepository trainLevels;

    @Autowired
    UserRepository users;

    @Autowired
    RoleRepository roles;

    public List<Dog> searchByLifeStage(int lifeStageId) {
        List<Dog> availableDogs = new ArrayList<>();

        if (lifeStageId == 0) {
            List<Dog> allDogs = dogs.findAll();

            for (Dog dog : allDogs) {
                if (dog.isIsavailable() == true) {
                    availableDogs.add(dog);
                }
            }
        } else {
            LifeStage ls = lifeStages.findById(lifeStageId).get();
            //  List<Dog> dogs  = ls.getDogs().stream().filter(dog -> dog.isIsavailable()).collect(Collectors.toList());
            availableDogs = ls.getDogs().stream().filter(dog -> dog.isIsavailable()).collect(Collectors.toList());
            // return dogs;

//            List<Dog> listByls = dogs.findByLifeStage(ls);
//            for (int i = 0; i < listByls.size(); i++) {
//                Dog dog = listByls.get(i);
//                if (dog.isIsavailable() == true) {
//                    availableDogs.add(dog);
//                }
//            }
        }

        return availableDogs;
        //  return ls.getDogs();
    }

    public List<Dog> findAllDogsByLifeStage(int lifestageid) {
        LifeStage lifeStage = lifeStages.findById(lifestageid).get();

        List<Dog> dogs = lifeStage.getDogs();
        return dogs;
        // return dogs.findByLifeStage(lifeStage);
    }

    public List<Dog> findAll() {
        return dogs.findAll();
    }

    public Dog save(Dog dog) {
        return dogs.save(dog);
    }

    public void deleteById(int id) {
        dogs.deleteById(id);
    }

    public Dog findById(int id) {
        return dogs.findById(id).orElse(null);
    }

    public List<Special> findAllSpecials() {
        return specials.findAll();
    }

    public Special saveSpecial(Special special) {
        return specials.save(special);
    }

    public void deleteSpecialById(int id) {
        specials.deleteById(id);
    }

    public List<Adoption> findAllAdoptions() {
        return adoptions.findAll();
    }

    public Adoption saveAdoption(Adoption adoption) {
        LocalDate ld = LocalDate.now();

        Date date = java.sql.Date.valueOf(ld);
        String formatted = ld.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        // Date date = Date.;

        adoption.setDate(date);
        return adoptions.save(adoption);
    }

    public List<Breed> findAllBreeds() {
        return breeds.findAll();
    }

    public Breed saveBreed(Breed breed) {
        LocalDate ld = LocalDate.now();
        String date = ld.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        breed.setDate(date);
        return breeds.save(breed);
    }

    public List<TrainLevel> findAllTrainLevels() {
        return trainLevels.findAll();
    }

    public TrainLevel saveTrainLevel(TrainLevel tl) {
        LocalDate ld = LocalDate.now();
        String date = ld.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        tl.setDate(date);
        return trainLevels.save(tl);
    }

    public List<User> findAllUsers() {
        return users.findAll();
    }

    public List<User> findActiveUsers() {
        return users.findByActiveTrue();
    }

    public User saveUser(User user) {
        return users.save(user);
    }

    public Size findSizeById(int id) {
        return sizes.findById(id).orElse(null);
    }

    public LifeStage findLifeStageById(int id) {
        return lifeStages.findById(id).orElse(null);
    }

    public Breed findBreedById(int id) {
        return breeds.findById(id).orElse(null);
    }

    public TrainLevel findTrainLevelById(int id) {
        return trainLevels.findById(id).orElse(null);
    }

    public List<Contact> findAllContacts() {
        return contacts.findAll();
    }

    public Contact saveContact(Contact contact) {
        return contacts.save(contact);
    }

//    public List<Dog> findDogBySearch(String name) {
//        return dogs.findByNameOrBreedContaining(name);
//    }
    public List<Dog> findFeaturedDogs() {
        return dogs.findByFeaturedTrue();
    }

//    public List<Dog> findByNameSearch(String name) {
//        return dogs.findByNameLike(name);
//    }
    public PaymentType findPaymentTypeById(int id) {
        return paymentTypes.findById(id).orElse(null);
    }

    public State findStateById(int id) {
        return states.findById(id).orElse(null);
    }

    public User findUserById(int id) {
        return users.findById(id).orElse(null);
    }

    public List<PaymentType> findAllPaymentTypes() {
        return paymentTypes.findAll();
    }

    public List<State> findAllState() {
        return states.findAll();
    }

    public List<Dog> searchByLifeStageAllDogs(int lifestageId) {
        LifeStage ls = lifeStages.getOne(lifestageId);
        return dogs.findByLifeStage(ls);
    }

    public List<Size> findAllSize() {
        return sizes.findAll();
    }

    public List<LifeStage> findAllLifeStages() {
        return lifeStages.findAll();
    }

    public List<Dog> findDogsByNameAndBreed(String userinput) {
        List<Dog> findByName = dogs.findByNameContainingIgnorecase(userinput);
        List<Dog> findByBreed = dogs.findByBreedContainingIgnorecase(userinput);

        Set<Dog> combined = new HashSet<>();

        for (int i = 0; i < findByName.size(); i++) {
            if (findByName.get(i).isIsavailable() == true) {
                combined.add(findByName.get(i));
            }
        }
        for (int i = 0; i < findByBreed.size(); i++) {

            if (findByBreed.get(i).isIsavailable() == true) {
                combined.add(findByBreed.get(i));
            }
        }
        return combined.stream().collect(Collectors.toList());
    }

//for finding available dogs
    public List<Dog> findDogsByAllSearch(String userinput, int lifestageid) {
        List<Dog> finalList = new ArrayList<>();

        if (userinput == "") {
            finalList = searchByLifeStage(lifestageid);
        } else {
            List<Dog> searchByBreedName = findDogsByNameAndBreed(userinput);
            for (int i = 0; i < searchByBreedName.size(); i++) {
                if (searchByBreedName.get(i).getLifeStage().getId() == lifestageid || lifestageid == 0) {
                    finalList.add(searchByBreedName.get(i));
                }
            }
        }

        return finalList;
    }
//for admin, showing all available/not available dogs

    public List<Dog> findDogsByAllSearchAdmin(String userinput, int lifestageid) {
        List<Dog> finalList = new ArrayList<>();

        if (userinput == "") {
            finalList = searchByLifeStageAdmin(lifestageid);
        } else {
            List<Dog> searchByBreedName = findDogsByNameAndBreedAdmin(userinput);
            for (int i = 0; i < searchByBreedName.size(); i++) {
                if (searchByBreedName.get(i).getLifeStage().getId() == lifestageid || lifestageid == 0) {
                    finalList.add(searchByBreedName.get(i));
                }
            }
        }

        return finalList;
    }

    private List<Dog> searchByLifeStageAdmin(int lifestageid) {
        List<Dog> allDogList = new ArrayList<>();

        if (lifestageid == 0) {
            allDogList = dogs.findAll();
        } else {
            LifeStage ls = lifeStages.findById(lifestageid).get();
            List<Dog> dogs = ls.getDogs().stream().filter(dog -> dog.isIsavailable()).collect(Collectors.toList());
            //  return dogs;
            //  LifeStage ls = lifeStages.getOne(lifestageid);

            allDogList = ls.getDogs();

        }

        return allDogList;
    }

    private List<Dog> findDogsByNameAndBreedAdmin(String userinput) {
        List<Dog> findByName = dogs.findByNameContainingIgnorecase(userinput);
        List<Dog> findByBreed = dogs.findByBreedContainingIgnorecase(userinput);

        Set<Dog> combined = new HashSet<>();

        for (int i = 0; i < findByName.size(); i++) {
            combined.add(findByName.get(i));
        }
        for (int i = 0; i < findByBreed.size(); i++) {
            combined.add(findByBreed.get(i));
        }
        return combined.stream().collect(Collectors.toList());
    }

    public List<Role> findAllRoles() {
        return roles.findAll();
    }

    public List<Adoption> findAdoptionsByUser(User user) {
        return adoptions.findByUser(user);
    }

    public List<Adoption> findAdoptionByDate(Date fromdate, Date todate) {
        return adoptions.findByDateBetween(fromdate, todate);
    }

    public List<Adoption> findAdoptionWithIdAndDatesNoNull(int userid, Date fromdate, Date todate) {
        List<Adoption> allList = adoptions.findAll();
        List<Adoption> dateList = adoptions.findByDateBetween(fromdate, todate);
        User user = users.findById(userid).orElse(null);

        List<Adoption> finalList = new ArrayList<>();
        Set<Adoption> set = new HashSet<>();

        if (userid == 0) {
            finalList = dateList;
        } else {
            List<Adoption> byUser = adoptions.findByUser(user);
            for (Adoption ad : byUser) {
                set.add(ad);
            }
            List<Adoption> dateList2 = adoptions.findByDateBetween(fromdate, todate);
            for (Adoption adt : dateList2) {
                if (adt.getUser() == user) {
                    set.add(adt);
                }

            }
            finalList = set.stream().collect(Collectors.toList());
        }

        return finalList;
    }

    public List<Adoption> findAdoptionByAllSearch(int userid, String fromdate, String todate) throws ParseException {
        SimpleDateFormat dateform = new SimpleDateFormat("yyyy-MM-dd");

        java.util.Date startDateForm = dateform.parse(fromdate);
        java.util.Date endDateForm = dateform.parse(todate);

        Date startDate = new Date(startDateForm.getTime());
        Date endDate = new Date(endDateForm.getTime());

        List<Adoption> resultList = new ArrayList<>();

        if (fromdate == "" && todate == "") {
            User usr = users.findById(userid).orElse(null);
            if (userid == 0) {
                resultList = adoptions.findAll();
            } else {
                resultList = findAdoptionsByUser(usr);
            }

        } else if (fromdate == "") {
            Date startdate1 = new Date(dateform.parse("2010-01-01").getDate());
            resultList = findAdoptionWithIdAndDatesNoNull(userid, startdate1, endDate);
        } else if (todate == "") {
            LocalDate ld = LocalDate.now();
            Date date = java.sql.Date.valueOf(ld);
            String formatted = ld.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));

            resultList = findAdoptionWithIdAndDatesNoNull(userid, startDate, date);
        } else {
            resultList = findAdoptionWithIdAndDatesNoNull(userid, startDate, endDate);
        }

        return resultList;
    }

    public String uploadFile(MultipartFile file, int dogid) throws IOException {

        // Normalize file name
        //  String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        String imgName = file.getOriginalFilename();

        int indexOfFileType = imgName.lastIndexOf(".");
        String fileType = imgName.substring(indexOfFileType);
        String revisedFileName = "\\dogImage_" + dogid + fileType;

        byte[] fileBytes = file.getBytes();

        Path path = Paths.get(upload_folder, revisedFileName);

        Files.write(path, fileBytes);

        return upload_folder + revisedFileName;

    }

    public String uploadFileEditDog(MultipartFile file, int dogid) throws IOException {
        Path path = Paths.get(upload_folder, "\\dogImage_" + dogid + ".jpg");
        Dog dog = dogs.findById(dogid).orElse(null);
        String revisedFileName = "";
        String dogImgPath = dog.getImagepath();
        String finalImgPath = upload_folder + revisedFileName;

//        if (dog.getImagepath() != null || dog.getImagepath() != "") {
        if (dogImgPath != null) {
            Files.delete(path);
            dog.setImagepath("");

            String uploadedImgName = file.getOriginalFilename();
            int indexFT = uploadedImgName.lastIndexOf(".");
            String ft = uploadedImgName.substring(indexFT);
            String filename = "\\dogImage_" + dogid + ft;

            byte[] newfileBytes = file.getBytes();
            Path path0 = Paths.get(upload_folder, filename);
            Files.write(path0, newfileBytes);

            revisedFileName = filename;
            
            finalImgPath = upload_folder + revisedFileName;

        } else if (dog.getImagepath() == null || dog.getImagepath() == "") {
            String imgName = file.getOriginalFilename();

            int indexOfFileType = imgName.lastIndexOf(".");
            String fileType = imgName.substring(indexOfFileType);
            revisedFileName = "\\dogImage_" + dogid + fileType;

            byte[] fileBytes = file.getBytes();

            Path path1 = Paths.get(upload_folder, revisedFileName);

            Files.write(path1, fileBytes);
            finalImgPath = upload_folder + revisedFileName;
        } else if (file == null) {
            String noFile = dog.getImagepath();
            finalImgPath = noFile;
        }

        return finalImgPath;

    }
    
    public String noFileEdit(int id) {
        Dog dog = dogs.findById(id).orElse(null);
        String imgpath = dog.getImagepath();
        
        return upload_folder+ imgpath;
    }
    
    public String login(String username, String password) {
        List<User> userList = users.findAll();
        String page = "";
        
        for(int i=0; i<userList.size();i++) {
            User user = userList.get(i);
            
            if(user.getEmail().equalsIgnoreCase(username) && user.getPassword().equals(password)) {
                Role role = user.getRole();
                int roleId = role.getId();
                switch(roleId) {
                    case 1:
                        page="/adminDogs";
                        break;
                    case 2:
                        page="/adoption";
                        break;
                    default:
                        page="/loginFail";
                        break;
                    
                }
            }
            else if (user.getEmail().equalsIgnoreCase(username) && !user.getPassword().equals(password)) {
                page="/loginFail";
            }
        }
        
//        for (User user: userList) {
//            if (user.getEmail().equalsIgnoreCase(username) && user.getPassword().equals(password)) {
//                Role role = user.getRole();
//                if(role.getId()==1) {
//                    page = "/adminDogs";
//                } else if (role.getId()==2) {
//                    page= "/adoption";
//                } 
//            } else {
//                page = "/loginFail";
//            }
//        }
        
        return page;
    }
    
    public void setPassword(String pw) {
        
    }

}
