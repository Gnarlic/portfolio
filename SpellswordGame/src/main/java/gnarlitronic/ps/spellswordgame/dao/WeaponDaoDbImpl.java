/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gnarlitronic.ps.spellswordgame.dao;

import gnarlitronic.ps.spellswordgame.model.Weapon;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Elnic
 */
public class WeaponDaoDbImpl implements WeaponDao {
    
    private Weapon sword = new Weapon();
    private Weapon axe = new Weapon();
    private Weapon activeWeapon = new Weapon();
    
    private Map<Integer, Weapon> itemMap = new HashMap<>();

    public WeaponDaoDbImpl() {
        sword.setWeaponId(1);
        sword.setName("Excalibrrr");
        sword.setCriticalStrikeModifier(10);
        sword.setMinDmg(5);
        sword.setMaxDmg(15);
        sword.setCritDmg(25);
        sword.setMaxDurability(150);
        sword.setDurability(150);
        sword.setElementalType("Ice");
        this.itemMap.put(sword.getWeaponId(), sword);
        activeWeapon = itemMap.get(1);
        
        axe.setWeaponId(2);
        axe.setName("Treefeller");
        axe.setCriticalStrikeModifier(13);
        axe.setMinDmg(2);
        axe.setMaxDmg(10);
        axe.setCritDmg(35);
        axe.setMaxDurability(100);
        axe.setDurability(100);
        axe.setElementalType("none");
        this.itemMap.put(axe.getWeaponId(), axe);
    }

    @Override
    public Weapon getWeapon() {
        return this.activeWeapon;
    }

    @Override
    public void setWeapon(Weapon weapon) {
        this.sword = weapon;
    }

    @Override
    public void reset() {
        
        sword.setWeaponId(1);
        sword.setName("Excalibrrr");
        sword.setCriticalStrikeModifier(10);
        sword.setMinDmg(5);
        sword.setMaxDmg(15);
        sword.setCritDmg(25);
        sword.setMaxDurability(150);
        sword.setDurability(150);
        sword.setElementalType("Ice");
    
    }

    @Override
    public List<Weapon> allWeapons() {
        
        return new ArrayList(itemMap.values());
    
    }

    @Override
    public Weapon getWeapon(String id) {
        
        activeWeapon = itemMap.get(Integer.parseInt(id));
        return itemMap.get(Integer.parseInt(id));
        
    }
    
    
    
    
    
}
