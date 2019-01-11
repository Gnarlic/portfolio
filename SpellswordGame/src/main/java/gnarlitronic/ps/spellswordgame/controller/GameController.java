/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gnarlitronic.ps.spellswordgame.controller;

import gnarlitronic.ps.spellswordgame.service.GameplayService;
import gnarlitronic.ps.spellswordgame.service.GameplayServiceImpl;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Elnic
 */
@Controller
public class GameController {
    
    GameplayService gService = new GameplayServiceImpl();
    
    @RequestMapping(value="/play", method=RequestMethod.GET)
    public String playGame(HttpServletRequest request, Model model) {
        gService.initialize();
        return "/play";
    }
    
    @RequestMapping(value="/play/attack", method=RequestMethod.GET)
    public String attack(HttpServletRequest request, Model model) {
        gService.attack();
        
        return "/play";
    }
    
}
