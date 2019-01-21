/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gnarlitronic.ps.spellswordgame.dao;

import gnarlitronic.ps.spellswordgame.model.PlayerCharacter;
import javax.inject.Inject;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author Elnic
 */
public class PlayerCharacterDaoDbImpl implements PlayerCharacterDao{
    
    
    private PlayerCharacter pc = new PlayerCharacter();

    public PlayerCharacterDaoDbImpl() {
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
        pc.setUnarmedDmg(2);
        pc.setExperience(0);
        pc.setCriticalStrikeChance(2);
    }

    @Override
    public PlayerCharacter getPc() {
        return this.pc;
    }

    @Override
    public void setPc(PlayerCharacter pc) {
        this.pc = pc;
    }

    @Override
    public void reset() {
        
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
        pc.setUnarmedDmg(2);
        pc.setExperience(0);
        pc.setCriticalStrikeChance(2);
        
    }
    
}
