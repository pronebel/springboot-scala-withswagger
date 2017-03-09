package com.bob.java.webapi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.List;

/**
 * Created by bob on 17/3/8.
 * http://blog.codeleak.pl/2014/05/spring-mvc-and-thymeleaf-how-to-acess-data-from-templates.html
 */
@Controller
public class ThymeleafController {

    @ModelAttribute("messages")
    List<String> messages() {
        return Arrays.asList("Message 1", "Message 2", "Message 3");
    }

    @GetMapping("/model-attr")
    String modelAttributes(Model model) {
        return "th-objects";
    }

    @GetMapping("/query-params")
    String queryParams() {
        return "redirect:/model-attr?q=My Query";
    }

    @GetMapping("/session-attr")
    String sessionAttributes(HttpSession session) {
        session.setAttribute("mySessionAttribute", "Session Attr 1");
        return "th-objects";
    }
}