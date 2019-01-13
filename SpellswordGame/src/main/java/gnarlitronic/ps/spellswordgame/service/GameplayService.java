/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gnarlitronic.ps.spellswordgame.service;

import gnarlitronic.ps.spellswordgame.model.Enemy;
import gnarlitronic.ps.spellswordgame.model.PlayerCharacter;
import gnarlitronic.ps.spellswordgame.model.Sword;
import java.util.HashMap;

/**
 *
 * @author Elnic
 */
public interface GameplayService {
    
    public void initialize();
    
    public int attack();
    
    public HashMap<Integer, Sword> itemDrop();
    
    public Enemy generateEnemy();
    
    public PlayerCharacter returnPC();
    
    public Enemy returnEnemy();
    
    public int getPlayerHealth();
    
    public int getEnemyHealth();
    
    public String getEquippedWeapon();
    
    public String getEquippedMagic();
    
    
    
}
