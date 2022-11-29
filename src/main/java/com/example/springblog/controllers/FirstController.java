package com.example.springblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
// Controller - informing our compiler that this class contains methods for our URL patterns.
@Controller
public class FirstController {
    // GetMapping - controls get requests made to a specific URL pattern
    @GetMapping("/test")
    // ResponseBody - which returns a string as the response when visiting the URL pattern
    @ResponseBody
    // The method that is executed when visiting the URL Pattern
    public String test() {
        return "Hello from Spring!";
    }

    @RequestMapping(method = RequestMethod.GET, path = "/bubbles")
    @ResponseBody
    public String bubbles() {
        return "bubububub!";
    }

    // Establishing Path Variables in the URL pattern with curly braces
    @GetMapping("/greeting/{name}/{lastName}")
    @ResponseBody
    // PathVariable Annotation used to grab the value of the path variable
    public String greeting(@PathVariable String name, @PathVariable String lastName) {
        // Implementing the path variables via concatenation.
        return "Greetings " + name + " " + lastName + "!";
    }

    @GetMapping("/roll-dice")
    public String showChoices() {
        return "roll-dice";
    }

    // To show results of guess
    @GetMapping("/roll-dice/{n}")
    public String showResults(@PathVariable int n, Model model) {
        // Establish the random number variable
        int randomNum = (int) Math.floor(Math.random() * ((7 - 1) + 1));

        // check if the path variable is equal to the random number

        boolean result = n == randomNum;

        model.addAttribute("result", result);
        model.addAttribute("randomNum", randomNum);

        return "roll-dice";
    }


}


