package by.azargan.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Aliaksei_Vihuro
 */
@Controller
@Slf4j
public class HomePageController {

    @RequestMapping(value = {"home"})
    public String showThymeleafHome(Model model) {
        log.info("Show Thymeleaf Home Page");
        return "home";
    }

    @RequestMapping(value = {"/"})
    public String showJsp(Model model) {
        log.info("Show JSP page");
        return "index";
    }

}
