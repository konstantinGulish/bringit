package com.example.bringit.controllers;

import com.example.bringit.models.Item;
import com.example.bringit.models.ItemRepository;
import com.example.bringit.models.Tag;
import com.example.bringit.models.TagRepository;
import com.example.bringit.security.AppUser;
import com.example.bringit.security.SSUD;
import com.example.bringit.security.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.HashSet;
import java.util.List;

@Controller
public class HomeController {

    @Autowired
    ItemRepository itemRepository;

    @Autowired
    UserService userService;

    @Autowired
    TagRepository tagRepository;

    @RequestMapping("/")
    public String showHome () {
        return "index";
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String showRegistrationPage (Model model) {
        model.addAttribute("user", new AppUser());
        return "registration";
    }

    @PostMapping(value = "/register")
    public String processRegistrationPage (
            @ModelAttribute("user") AppUser user,
            Model model) {
        model.addAttribute("user", user);
        userService.saveUser(user);
        model.addAttribute("message",
                "User Account Successfully Created");
        return "index";
    }

    @GetMapping("/add")
    public String showItemForm (Model model) {
        model.addAttribute("item", new Item ());
        model.addAttribute("tags", tagRepository.findAll());
        return "additem";
    }

    @PostMapping("/process")
    public String addItem (Item item){
        itemRepository.save(item);
        return "redirect:/list";
    }

    @RequestMapping("/list")
    public String listItems(Model model){
        model.addAttribute("items", itemRepository.findAll());
        model.addAttribute("unregistereditems", itemRepository.findItemsByItemNumBefore(12));
        return "list";
    }

    @RequestMapping("/login")
    public String login (){
        return "login";
    }

    @PostConstruct
    public void fillRepos() {
        Item item = new Item();
        item.setName("Item 1");
        Tag tag = new Tag ();
        tag.setName("sports");
        item.addTag(tag);
        itemRepository.save(item);

        item = new Item ();
        item.setName("Item 2");
        itemRepository.save(item);

        item = new Item ();
        item.setName("Item 3");
        itemRepository.save(item);

        item = new Item ();
        item.setName("Item 4");
        itemRepository.save(item);

        item = new Item ();
        item.setName("Item 5");
        itemRepository.save(item);

        item = new Item ();
        item.setName("Item 6");
        itemRepository.save(item);

        item = new Item ();
        item.setName("Item 7");
        itemRepository.save(item);

        item = new Item ();
        item.setName("Item 8");
        itemRepository.save(item);

        item = new Item ();
        item.setName("Item 9");
        itemRepository.save(item);

        item = new Item ();
        item.setName("Item 10");
        itemRepository.save(item);

        item = new Item ();
        item.setName("Item 11");
        itemRepository.save(item);

        item = new Item ();
        item.setName("Item 12");
        itemRepository.save(item);

        Tag t = new Tag ();
        t.setName("sports");
        tagRepository.save(t);

        t = new Tag ();
        tag.setName("household");
        tagRepository.save(t);
    }


}
