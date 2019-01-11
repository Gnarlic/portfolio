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
public class GameplayServiceImpl implements GameplayService {

    private Enemy enemy;
    
    private void setupEnemy() {
        enemy.setEnemyId(1);
        enemy.setEnemyName("Troll");
        int[] dmgRange = {1,10};
        enemy.setDamageRange(dmgRange);
        enemy.setLevel(1);
        enemy.setMaxHealth(25);
        enemy.setHealth(25);
        enemy.setElementalResistance("Water");
        enemy.setElementalWeakness("Fire");
        enemy.setCriticalStrikeChance(10);
        enemy.setLootChance(200);
        enemy.setPoints(25);
    }
    
    private Sword sword;
    
    private void newSword() {
        sword.setSwordId(1);
        sword.setName("Excalibrrr");
        sword.setCriticalStrikeModifier(10);
        sword.setMinDmg(5);
        sword.setMaxDmg(15);
        sword.setCritDmg(25);
        sword.setMaxDurability(150);
        sword.setDurability(150);
        sword.setElementalType("Ice");
    }
    
    private PlayerCharacter pc;
    
    private void newCharacter() {
        pc.setPlayerId(1);
        pc.setName("Sir Arnold");
        pc.setMaxHealth(100);
        pc.setHealth(100);
        pc.setMaxMana(100);
        pc.setMana(100);
        pc.setLevel(1);
        pc.setMagicSkillLvl(1);
        pc.setSwordSkillLvl(1);
        pc.setEquippedSwordId(1);
        pc.setEquippedMagicId(1);
        pc.setEquippedArmorId(1);
    }
    
    @Override
    public void initialize() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int attack() {
        
    }

    @Override
    public HashMap<Integer, Sword> itemDrop() {
        HashMap swordDrop = new HashMap<Integer, Sword>();
        swordDrop.put(1, sword);
        return swordDrop;
    }

    @Override
    public Enemy generateEnemy() {
        return enemy;
    }
    
}
