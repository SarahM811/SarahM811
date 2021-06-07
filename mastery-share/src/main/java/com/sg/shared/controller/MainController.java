package com.sg.shared.controller;

import com.sg.shared.service.ServiceLayer;
import com.sg.shared.entities.OurObject;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Valid;
import javax.validation.Validation;
import javax.validation.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author kylerudy
 */
@Controller
public class MainController {

    @Autowired
    ServiceLayer service;

    Validator validate = Validation.buildDefaultValidatorFactory().getValidator();
    Set<ConstraintViolation<OurObject>> violations = new HashSet<>();

    @GetMapping("/inventory")
    public String index(Model model) {
        model.addAttribute("objects", service.findAll());
        return "/inventory";
    }

    @GetMapping("/add")
    public String add() {
        return "add";
    }

    @PostMapping("/add")
    public String addObject(@Valid OurObject ob, BindingResult result, Model model) {
        if (result.hasErrors()) {
            System.out.println("ERRRRROORRRRRRRRRRRRRR");
            System.out.println(result.getFieldErrors());
            model.addAttribute("ourObject", ob);
            return "add";
        }
        service.save(ob);
        return "redirect:/inventory";
    }

    @GetMapping("/edit")
    public String edit(Integer id, Model model) {
        model.addAttribute("ourObject", service.findById(id));
        System.out.println(model.asMap());
        return "edit";
    }

    @PostMapping("/edit")
    public String editObject(@Valid OurObject ob, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("ourObject", ob);
            return "edit";
        }
        service.save(ob);
        return "redirect:/inventory";
    }

//    link for delete should be in the form /deleteObject?id=
    @GetMapping("/delete")
    public String deleteObject(Integer id, Integer obId) {
        service.deleteById(id);
        return "redirect:/inventory";
    }

    @GetMapping("/display")
    public String display(Integer id, Model model) {
        model.addAttribute("object", service.findById(id));
        return "display";
    }

    @GetMapping("/search")
    public ResponseEntity<List<OurObject>> searchBetween(String min, String max) {
        List<OurObject> lst = service.searchBetween(Integer.parseInt(min), Integer.parseInt(max));
        if (lst == null) {
            return new ResponseEntity(null, HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(lst);
    }


    @GetMapping("/")
    public String home() {
        return "redirect:/inventory";
    }
    
    @GetMapping("/login")
    public String login() {
        return "/login";
    }


    @PostMapping("/logout")
    public String handleLogout() {
        return "/";
    }

    @GetMapping("/403")
    public String error403() {
        return "/403";
    }

}
