/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nt.application.alphabetizer.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import nt.application.alphabetizer.dao.InputStringPersistenceException;
import nt.application.alphabetizer.model.InputString;
import nt.application.alphabetizer.service.AlphabetizerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 *
 * @author Elnic
 */
@Controller
public class HomeController {
    
    @Inject
    AlphabetizerService svc;
    
    @RequestMapping(value="/", method=RequestMethod.GET)
    public String Home(Model model) {
        model.addAttribute("inputString", new InputString());
        return "/index";
    }
    
    @RequestMapping(value="/submit", method=RequestMethod.POST)
    public String submit(@Valid @ModelAttribute("inputString") InputString inputString, BindingResult result, Model model) throws InputStringPersistenceException{
        svc.saveInputString(inputString);
        model.addAttribute("results", svc.returnResults(inputString.getString()));
        model.addAttribute("inputString", new InputString());
        model.addAttribute("letterCount", svc.countLetters(inputString.getString()));
        return "/index";
    }
    
}
