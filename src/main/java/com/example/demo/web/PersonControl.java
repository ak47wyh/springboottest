package com.example.demo.web;

import com.example.demo.vo.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/6/4.
 */
@Controller
public class PersonControl {

    @RequestMapping("/index")
    public String index(Model model){
        Person person = new Person(1,"aa");

        List<Person> people = new ArrayList<>();
        Person person1 = new Person(2,"w2");
        Person person2 = new Person(3,"y3");
        Person person3 = new Person(4,"h4");
        people.add(person1);
        people.add(person2);
        people.add(person3);
        model.addAttribute("singlePerson",person);
        model.addAttribute("people",people);
        return "index";
    }
}
