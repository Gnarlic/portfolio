/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gnarlitronic.ps.spellswordgame.dao;

import gnarlitronic.ps.spellswordgame.model.Weapon;

/**
 *
 * @author Elnic
 */
public class WeaponDaoDbImpl implements WeaponDao {
    
    private Weapon sword = new Weapon();

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
    }

    @Override
    public Weapon getWeapon() {
        return this.sword;
    }

    @Override
    public void setWeapon(Weapon weapon) {
        this.sword = weapon;
    }
    
    
    
    
    
}
