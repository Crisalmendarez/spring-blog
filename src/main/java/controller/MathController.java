package controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class MathController {

    @GetMapping("/add/{num1}/and/{num2}")
    @ResponseBody
    public String addition(@PathVariable int num1, @PathVariable int num2) {
        return "The sum of " + num1 +  " and " + num2 + " = "  + (num1 + num2);
    }

    @GetMapping("/subtract/{num1}/from/{num2}")
    @ResponseBody
    public int subtract(@PathVariable int num1, @PathVariable int num2) {
        return num1 - num2;
    }

    @GetMapping("/multiply/{num1}/and/{num2}")
    @ResponseBody
    public int multiply(@PathVariable int num1, @PathVariable int num2) {
        return num1 * num2;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/divide/{num1}/by/{num2}")
//    @GetMapping("/divide/{num1}/by/{num2}")
    @ResponseBody
    public double quotient(@PathVariable double num1, @PathVariable double num2) {
        return num1 / num2;
    }
}
