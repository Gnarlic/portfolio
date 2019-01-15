/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gnarlitronic.ps.spellswordgame.controller;

import gnarlitronic.ps.spellswordgame.model.PlayerCharacter;
import gnarlitronic.ps.spellswordgame.service.GameplayService;
import gnarlitronic.ps.spellswordgame.service.GameplayServiceImpl;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
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
        gService.initialize();
        model.addAttribute("enemyHealth", gService.getEnemyHealth());
        model.addAttribute("playerHealth", gService.getPlayerHealth());
        model.addAttribute("weaponName", gService.getEquippedWeapon());
        model.addAttribute("magicName", gService.getEquippedMagic());
        return "/index";
    }

    @RequestMapping(value = "/play/attack", method = RequestMethod.GET)
    public String attack(HttpServletRequest request, Model model) {
        if (gService.getEnemyHealth() <= 0) {
            gService.initialize();
            model.addAttribute("playerHealth", gService.getPlayerHealth());
            model.addAttribute("enemyHealth", gService.getEnemyHealth());
        } else if (gService.getPlayerHealth() <= 0) {
            gService.initialize();
            model.addAttribute("playerHealth", gService.getPlayerHealth());
            model.addAttribute("enemyHealth", gService.getEnemyHealth());
        } else {
            gService.attack();
            int enemyHealth = gService.getEnemyHealth();
            int health = gService.getPlayerHealth();
            model.addAttribute("playerHealth", health);
            model.addAttribute("enemyHealth", enemyHealth);
            if (gService.getEnemyHealth() <= 0) {
                model.addAttribute("enemyHealth", "0");
                model.addAttribute("gameover", "You Win!");
                gService.initialize();
            } else if (gService.getPlayerHealth() <= 0) {
                model.addAttribute("gameover", "You Lose!");
                model.addAttribute("playerHealth", "0");
                gService.initialize();
            }
        }
        model.addAttribute("weaponName", gService.getEquippedWeapon());
        model.addAttribute("magicName", gService.getEquippedMagic());
        return "/index";
    }

    @CrossOrigin
    @RequestMapping(value = "/attack", method = RequestMethod.GET)
    @ResponseBody
    public CombatInfo nextRound() {
        CombatInfo info = new CombatInfo();
        if (gService.getPlayerHealth() <= 0) {
            gService.initialize();
            info.setPlayerHealth(gService.getPlayerHealth());
            info.setEnemyHealth(gService.getEnemyHealth());
            info.setGameStatus("You Lose!");
        } else if (gService.getEnemyHealth() <= 0) {
            gService.initialize();
            info.setEnemyHealth(gService.getEnemyHealth());
            info.setPlayerHealth(gService.getPlayerHealth());
            info.setGameStatus("You Win!");
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
