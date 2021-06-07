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
import java.math.BigDecimal;
import java.text.ParseException;
//import java.sql.Date;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 *
 * @author sakim
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ServiceLayerTest {

    @Autowired
    ServiceLayer service;

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
    PaymentTypeRepository paymentType;

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

    @Autowired
    PaymentTypeRepository paymentTypes;

    Dog dog = new Dog();

    public ServiceLayerTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {

    }

    @After
    public void tearDown() {
        //  service.deleteById(4);

    }

    /**
     * Test of searchBetween method, of class ServiceLayer.
     */
    @Test
    public void testSearchByLifeStage() {
//        System.out.println("searchByLS");
//        int exp = 0;
//        List<Dog> result = service.searchByLifeStage(1);
//        assertEquals(exp, result.size());

//        for (Dog dog : result) {
//            if (dog.getId() == 1) {
//                String resultName = dog.getName();
//                assertEquals("Goldie", resultName);
//            }
//
//        }
//        List<Dog> adultResult = service.searchByLifeStage(2);
//        assertEquals(2, adultResult.size());
//
//        List<Dog> result2 = service.searchByLifeStage(0);
//        assertEquals(2, result2.size());

    }

    @Test
    public void testFindAll() {
//        dog.setAdoptionPrice(BigDecimal.ONE);
//        dog.setAge(2);
//        dog.setName("dog");
//        dog.setLifeStage(lifeStages.findById(2).orElse(null));
//        dog.setSize(sizes.findById(1).orElse(null));
//        dog.setBreed(breeds.findById(1).orElse(null));
//        dog.setDescription("dd");
//        dog.setTrainLevel(trainLevels.findById(1).orElse(null));
//        service.save(dog);
        List<Dog> allDogs = service.findAll();
        int exp = 3;
        int result = allDogs.size();

        assertEquals(exp, result);
    }

    @Test
    public void testSave() {
//
        dog.setAdoptionPrice(BigDecimal.ONE);
        dog.setAge(2);
        dog.setName("dog");
        dog.setLifeStage(lifeStages.findById(2).orElse(null));
        dog.setSize(sizes.findById(1).orElse(null));
        dog.setBreed(breeds.findById(1).orElse(null));
        dog.setDescription("dd");
        dog.setTrainLevel(trainLevels.findById(1).orElse(null));
        Dog result = service.save(dog);
        assertEquals(dog, result);

//        Dog resultFind = service.findById(dog.getId());
//        assertEquals(dog, resultFind);
        service.deleteById(dog.getId());
        assertNull(service.findById(dog.getId()));
    }

    @Test
    public void testDeleteByIdAndFindById() {
        int exp = service.findAll().size();
        dog.setAdoptionPrice(BigDecimal.ONE);
        dog.setAge(2);
        dog.setName("dog");
        dog.setLifeStage(lifeStages.findById(2).orElse(null));
        dog.setSize(sizes.findById(1).orElse(null));
        dog.setBreed(breeds.findById(1).orElse(null));
        dog.setDescription("dd");
        dog.setTrainLevel(trainLevels.findById(1).orElse(null));

        Dog result = service.save(dog);
        List<Dog> resultList = service.findAll();
        assertEquals(exp + 1, resultList.size());

        service.deleteById(dog.getId());
        assertNull(service.findById(dog.getId()));

        Dog resultDog = service.findById(1);
        String resultName = resultDog.getName();
        assertEquals("Goldie", resultName);

    }

    @Test
    public void testFindAllSpecials() {
        List<Special> specialList = service.findAllSpecials();

        assertEquals(2, specialList.size());
    }

    @Test
    public void testSaveSpecial() {
        Special special1 = new Special();
        //special1.setId(1);
        special1.setTitle("title");
        special1.setDescription("description");

        Special result = service.saveSpecial(special1);

        assertEquals(special1, result);
        assertEquals(special1, specials.findById(special1.getId()).orElse(null));

        service.deleteSpecialById(special1.getId());
        assertNull(specials.findById(special1.getId()).orElse(null));

//        List<Special> specialList = service.findAllSpecials();
//        for (int i = 0; i < specialList.size(); i++) {
//            if(specialList.get(i).getId()!=1) {
//                 service.deleteById(specialList.get(i).getId());
//            }
//           
//        }
    }

    @Test
    public void testFindAllAdoptions() {
        int exp = 1;
        List<Adoption> resultList = service.findAllAdoptions();

        assertEquals(exp, resultList.size());
    }

    @Test
    public void testSaveAdoption() {
        List<Adoption> initialList = service.findAllAdoptions();

        Adoption adopt = new Adoption();
        adopt.setName("Mark Smith");
        adopt.setStreet1("123 streed");
        State st = states.findById(1).orElse(null);
        adopt.setState(st);
        adopt.setCity("Huntsville");
        adopt.setZipcode(12345);
        adopt.setEmail("ms@gmail.com");
        adopt.setPhone("1234");
        User user = users.findById(1).orElse(null);
        adopt.setUser(user);
        PaymentType pt = paymentTypes.findById(1).orElse(null);
        adopt.setPaymentType(pt);
        adopt.setPurchaseprice(BigDecimal.ZERO);
        Dog dog = service.findById(1);
        adopt.setDog(dog);

        service.saveAdoption(adopt);
        List<Adoption> resultList = service.findAllAdoptions();
        assertEquals(initialList.size() + 1, resultList.size());

        adoptions.deleteById(adopt.getId());
        assertNull(adoptions.findById(adopt.getId()).orElse(null));

        List<Adoption> resultFinal = service.findAllAdoptions();
        assertEquals(initialList.size(), resultFinal.size());

    }

    @Test
    public void testFindAllBreeds() {
        int exp = 3;
        List<Breed> breedList = service.findAllBreeds();

        assertEquals(exp, breedList.size());
    }

    @Test
    public void testSaveBreed() {
        List<Breed> initialBreedList = service.findAllBreeds();

        Breed newBreed = new Breed();
        newBreed.setName("shiba");
        User user = users.findById(1).orElse(null);
        newBreed.setUser(user);

        service.saveBreed(newBreed);
        List<Breed> afterSave = service.findAllBreeds();

        assertEquals(initialBreedList.size() + 1, afterSave.size());

        breeds.deleteById(newBreed.getId());
        assertNull(breeds.findById(newBreed.getId()).orElse(null));
        List<Breed> afterDelete = service.findAllBreeds();
        assertEquals(initialBreedList.size(), afterDelete.size());

    }

    @Test
    public void testFindAllTrainLevles() {
        int exp = 3;
        List<TrainLevel> tlList = service.findAllTrainLevels();

        assertEquals(3, tlList.size());
    }

    @Test
    public void testSaveTrainLevel() {
        List<TrainLevel> initial = service.findAllTrainLevels();

        TrainLevel tl = new TrainLevel();
        tl.setLevel("good");
        User user = users.findById(1).orElse(null);
        tl.setUser(user);
        service.saveTrainLevel(tl);

        List<TrainLevel> afterSave = service.findAllTrainLevels();
        assertEquals(initial.size() + 1, afterSave.size());

        trainLevels.deleteById(tl.getId());
        assertNull(trainLevels.findById(tl.getId()).orElse(null));

        List<TrainLevel> afterDelete = service.findAllTrainLevels();
        assertEquals(initial.size(), afterDelete.size());

    }

    @Test
    public void testFindAllUsers() {
        int exp = 2;
        List<User> result = service.findAllUsers();

        assertEquals(exp, result.size());
    }

    @Test
    public void testFindActiveUsers() {
        int exp = 2;
        List<User> result = service.findActiveUsers();

        assertEquals(exp, result.size());
    }

    @Test
    public void testSaveUser() {
        List<User> initial = service.findAllUsers();

        User usr = new User();
        usr.setFirstname("Finn");
        usr.setLastname("Melvin");
        usr.setEmail("fn@gmail.com");
        //List<Role> roleList = roles.findAll();
        //usr.setRoles(roleList);
        Role role = roles.findById(1).orElse(null);
        usr.setRole(role);
        usr.setPassword("pw");
        User fromService = service.saveUser(usr);
        assertEquals(usr, fromService);

        List<User> afterSave = service.findAllUsers();
        assertEquals(initial.size() + 1, afterSave.size());

        usr.setActive(false);
        service.saveUser(usr);
        List<User> afterEditActive = service.findActiveUsers();
        assertEquals(initial.size(), afterEditActive.size());

        users.deleteById(usr.getId());
        assertNull(users.findById(usr.getId()).orElse(null));

        List<User> afterDelete = service.findAllUsers();
        assertEquals(initial.size(), afterDelete.size());

    }

    @Test
    public void testFindSizeById() {
        Size size1 = service.findSizeById(1);
        String expSizeType = "small";
        String resultSizeType = size1.getType();

        assertEquals(expSizeType, resultSizeType);

    }

    @Test
    public void testFindLifeStageById() {
        LifeStage ls = service.findLifeStageById(1);
        String expLS = "puppy";
        String result = ls.getStage();

        assertEquals(expLS, result);
    }

    @Test
    public void testFindTrainLevelById() {
        TrainLevel tl = service.findTrainLevelById(1);
        String exp = "Potty Trained";
        String result = tl.getLevel();

        assertEquals(exp, result);
    }

    @Test
    public void testFindAllContacts() {
        int exp = 0;
        List<Contact> contactList = service.findAllContacts();
        int result = contactList.size();

        assertEquals(exp, result);
    }

    @Test
    public void testSaveContact() {
        List<Contact> initial = service.findAllContacts();

        Contact ct = new Contact();
        ct.setMessage("dog");
        ct.setName("Johnson");
        ct.setEmail("email@gmail.com");
        ct.setPhone("980-654-8764");

        Contact fromSave = service.saveContact(ct);
        assertEquals(ct, fromSave);

        List<Contact> afterSave = service.findAllContacts();
        assertEquals(initial.size() + 1, afterSave.size());

        contacts.deleteById(ct.getId());
        assertNull(contacts.findById(ct.getId()).orElse(null));

        List<Contact> afterDelete = service.findAllContacts();
        assertEquals(initial.size(), afterDelete.size());
    }

//    @Test
//    public void testFindByNameSearch() {
//        String exp = "goldie";
//        List<Dog> resultDogList = service.findByNameSearch("gold");
//        for (Dog dog: resultDogList) {
//            String result = dog.getName();
//            assertEquals(exp, result);
//        }
//    }
    @Test
    public void testFindPaymentTypeById() {
        String exp = "Cash";
        PaymentType pt = service.findPaymentTypeById(2);
        String result = pt.getType();

        assertEquals(exp, result);
    }

    @Test
    public void testFindStateById() {
        String exp = "AL";
        State st = service.findStateById(1);
        String result = st.getName();

        assertEquals(exp, result);
    }

    @Test
    public void testFindUserById() {
        String exp = "John";
        User user = service.findUserById(1);
        String result = user.getFirstname();

        assertEquals(exp, result);
    }

    @Test
    public void testFindAllPaymentTypes() {
        int exp = 4;
        List<PaymentType> ptList = service.findAllPaymentTypes();
        int result = ptList.size();

        assertEquals(exp, result);

    }

    @Test
    public void testFindAllStates() {
        int exp = 50;
        List<State> states = service.findAllState();
        int result = states.size();

        assertEquals(exp, result);
    }

    @Test
    public void testSearchByAllSearch() {
        List<Dog> fromService = service.findDogsByAllSearchAdmin("bob", 2);
        //List<Dog> fromService = service.findDogsByNameAndBreed("bob");
        // List<Dog> fromService = dogs.findByBreedContainingIgnorecase("gold");
        // List<Dog> fromService = dogs.findByNameContainingIgnorecase("gold");
        int exp = 1;
        int result = fromService.size();

        assertEquals(exp, result);
    }

    @Test
    public void testSearchAdoptionByAllSearch() throws ParseException {
       List<Adoption> result= service.findAdoptionByAllSearch(1, "2018-01-01", "2018-12-31");
        System.out.println(result);
       assertEquals(1, result.size());
       
    }

}
