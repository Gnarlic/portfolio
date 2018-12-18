/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gnarlitronic.ps.spellswordgame.controller;

import static javafx.scene.input.KeyCode.M;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Elnic
 */
public class HomeController {
    
    @RequestMapping(value="/", method=RequestMethod.GET)
    public String homePage(Model model) {
        
        return "/index";
    }
    
}
