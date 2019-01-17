/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gnarlitronic.ps.spellswordgame.controller;

import gnarlitronic.ps.spellswordgame.model.PlayerCharacter;
import gnarlitronic.ps.spellswordgame.model.Weapon;
import gnarlitronic.ps.spellswordgame.service.GameplayService;
import gnarlitronic.ps.spellswordgame.service.GameplayServiceImpl;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Elnic
 */
@Controller
public class GameController {

    @Inject
    GameplayService gService;

    public class CombatInfo {

        int enemyHealth = 0;
        int playerHealth = 0;
        String gameStatus = "";

        public int getEnemyHealth() {
            return enemyHealth;
        }

        public void setEnemyHealth(int enemyHealth) {
            this.enemyHealth = enemyHealth;
        }

        public int getPlayerHealth() {
            return playerHealth;
        }

        public void setPlayerHealth(int playerHealth) {
            this.playerHealth = playerHealth;
        }

        public String getGameStatus() {
            return gameStatus;
        }

        public void setGameStatus(String gameStatus) {
            this.gameStatus = gameStatus;
        }
        
        private PlayerCharacter pc;

        public PlayerCharacter getPc() {
            return pc;
        }

        public void setPc(PlayerCharacter pc) {
            this.pc = pc;
        }

    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String playGame(HttpServletRequest request, Model model) {
        gService.reset();
        model.addAttribute("enemyHealth", gService.getEnemyHealth());
        model.addAttribute("playerHealth", gService.getPlayerHealth());
        model.addAttribute("weaponName", gService.getEquippedWeapon());
        model.addAttribute("magicName", gService.getEquippedMagic());
        return "/index";
    }

    @CrossOrigin
    @RequestMapping(value="/listWeapons", method = RequestMethod.GET)
    @ResponseBody
    public List<Weapon> availableWeapons() {
        
        return gService.loadWeapons();
        
    }
    
    @CrossOrigin
    @RequestMapping(value="/selectWeapon/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Weapon weapon(@PathVariable("id") String id) {
        
        return gService.getWeapon(id);
        
    }
    
    @CrossOrigin
    @RequestMapping(value = "/attack", method = RequestMethod.GET)
    @ResponseBody
    public CombatInfo nextRound() {
        CombatInfo info = new CombatInfo();
        if (gService.getPlayerHealth() <= 0) {
            gService.reset();
            info.setPlayerHealth(gService.getPlayerHealth());
            info.setEnemyHealth(gService.getEnemyHealth());
        } else if (gService.getEnemyHealth() <= 0) {
            gService.reset();
            info.setEnemyHealth(gService.getEnemyHealth());
            info.setPlayerHealth(gService.getPlayerHealth());
        } else {
            gService.attack();
            if (gService.getEnemyHealth() <= 0) {
                info.setEnemyHealth(0);
                info.setPlayerHealth(gService.getPlayerHealth());
                info.setGameStatus("You Win!");
            } else if (gService.getPlayerHealth() <= 0) {
                info.setPlayerHealth(0);
                info.setEnemyHealth(gService.getEnemyHealth());
                info.setGameStatus("You Lose!");
            } else {
                info.setEnemyHealth(gService.getEnemyHealth());
                info.setPlayerHealth(gService.getPlayerHealth());
            }
        }

        return info;
    }

}
