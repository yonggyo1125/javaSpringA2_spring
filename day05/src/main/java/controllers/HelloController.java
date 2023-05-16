package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {

    /**
    public ModelAndView hello() {

        ModelAndView mv = new ModelAndView();
        mv.setViewName("hello");
        return mv;
    }
     */

    /**
    @GetMapping("/hello")
    public String hello(String name, int num1, int num2, boolean agree) {
        System.out.println(name);
        System.out.println(num1 + num2);
        System.out.println(agree);
        return "hello";
    }
    */
    @GetMapping("/hello")
    public String hello(@RequestParam(name="nm", required=false) String name) {
        System.out.println(name);

        return "hello";
    }
}
