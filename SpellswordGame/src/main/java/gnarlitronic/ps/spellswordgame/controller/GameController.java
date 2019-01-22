/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gnarlitronic.ps.spellswordgame.controller;

import gnarlitronic.ps.spellswordgame.model.Armor;
import gnarlitronic.ps.spellswordgame.model.Enemy;
import gnarlitronic.ps.spellswordgame.model.Magic;
import gnarlitronic.ps.spellswordgame.model.PlayerCharacter;
import gnarlitronic.ps.spellswordgame.model.Potion;
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

        PlayerCharacter playerCharacter;
        Enemy enemy;
        Weapon weapon;
        Magic magic;
        Armor armor;
        Potion potion;
        String gameStatus = "";

        public PlayerCharacter getPlayerCharacter() {
            return playerCharacter;
        }

        public void setPlayerCharacter(PlayerCharacter playerCharacter) {
            this.playerCharacter = playerCharacter;
        }

        public Enemy getEnemy() {
            return enemy;
        }

        public void setEnemy(Enemy enemy) {
            this.enemy = enemy;
        }

        public Weapon getWeapon() {
            return weapon;
        }

        public void setWeapon(Weapon weapon) {
            this.weapon = weapon;
        }

        public Magic getMagic() {
            return magic;
        }

        public void setMagic(Magic magic) {
            this.magic = magic;
        }

        public Armor getArmor() {
            return armor;
        }

        public void setArmor(Armor armor) {
            this.armor = armor;
        }

        public Potion getPotion() {
            return potion;
        }

        public void setPotion(Potion potion) {
            this.potion = potion;
        }

        public String getGameStatus() {
            return gameStatus;
        }

        public void setGameStatus(String gameStatus) {
            this.gameStatus = gameStatus;
        }
        
        

    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String playGame(HttpServletRequest request, Model model) {
        gService.reset();
        model.addAttribute("enemy", gService.getEnemy());
        model.addAttribute("player", gService.getPlayer());
        model.addAttribute("weaponName", gService.getEquippedWeapon());
        model.addAttribute("magicName", gService.getEquippedMagic());
        return "/index";
    }

    @CrossOrigin
    @RequestMapping(value = "/listWeapons", method = RequestMethod.GET)
    @ResponseBody
    public List<Weapon> availableWeapons() {

        return gService.loadWeapons();

    }

    @CrossOrigin
    @RequestMapping(value = "/selectWeapon/{id}", method = RequestMethod.GET)
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
            info.setPlayerCharacter(gService.getPlayer());
            info.setEnemy(gService.getEnemy());
        } else if (gService.getEnemyHealth() <= 0) {
            gService.reset();
            info.setPlayerCharacter(gService.getPlayer());
            info.setEnemy(gService.getEnemy());
        } else {
            gService.attack();
            if (gService.getEnemyHealth() <= 0) {
                info.enemy.setHealth(0);
                info.playerCharacter.setHealth(gService.getPlayerHealth());
                info.setGameStatus("You Win!");
            } else if (gService.getPlayerHealth() <= 0) {
                info.playerCharacter.setHealth(0);
                info.enemy.setHealth(gService.getEnemyHealth());
                info.setGameStatus("You Lose!");
            } else {
                info.setPlayerCharacter(gService.getPlayer());
                info.setEnemy(gService.getEnemy());
            }
        }

        return info;
    }

}
