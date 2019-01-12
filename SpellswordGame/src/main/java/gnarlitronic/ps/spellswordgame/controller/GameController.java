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
    
    @RequestMapping(value="/", method=RequestMethod.GET)
    public String playGame(HttpServletRequest request, Model model) {
        gService.initialize();
        model.addAttribute("enemyHealth", gService.getEnemyHealth());
        model.addAttribute("playerHealth", gService.getPlayerHealth());
        return "/index";
    }
    
    @RequestMapping(value="/play/attack", method=RequestMethod.GET)
    public String attack(HttpServletRequest request, Model model) {
        if (gService.getEnemyHealth() <= 0) {
            model.addAttribute("gameover", "You Win!");
        } else {
        gService.attack();
        int enemyHealth = gService.getEnemyHealth();
        int health = gService.getPlayerHealth();
        model.addAttribute("playerHealth", health);
        model.addAttribute("enemyHealth", enemyHealth);
            if (gService.getEnemyHealth() <=0) {
                model.addAttribute("gameover", "You Win!");
            }
        }
        return "/index";
    }
    
}
