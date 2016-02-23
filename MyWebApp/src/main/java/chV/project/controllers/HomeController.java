package chV.project.controllers;


import chV.project.models.Moderators;
import chV.project.models.UploadedFile;

import chV.project.validator.FileValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.support.HttpRequestHandlerServlet;
import org.springframework.web.servlet.ModelAndView;


import java.util.Locale;
import java.util.Random;


@Controller
@SessionAttributes({"moderator", "uploadedFile"})
public class HomeController {

    @Autowired
    FileValidator fileValidator;

    private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

    @RequestMapping(value = {"/", "home"}, method = RequestMethod.GET)
    public ModelAndView home(@RequestParam(value = "error", required = false) String error, Locale locale) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("moderator", new Moderators());
        if (error != null) {
            modelAndView.addObject("error", fileValidator.i18n("home.error", locale));
        }
        modelAndView.setViewName("home");

        return modelAndView;
    }

    @RequestMapping(value = "/dropFile", method = RequestMethod.GET)
    public ModelAndView dropFile() {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("uploadedFile", new UploadedFile());
        modelAndView.setViewName("dropFile");

        return modelAndView;
    }

    @RequestMapping(value = "/moderator", method = RequestMethod.GET)
    public String checkUsers(@ModelAttribute("moderator") Moderators mod, Model model) {

        model.addAttribute("moderator", mod);
        return "moderator";
    }

}