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

    @RequestMapping(value = "/")
    public String showHomePage(Model model) {
        log.info("Show Home page");
        model.addAttribute("message", "Message from JSP");
        return "home";
    }

}
