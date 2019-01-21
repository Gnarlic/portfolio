/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gnarlitronic.ps.spellswordgame.dao;

import gnarlitronic.ps.spellswordgame.model.Magic;
import javax.inject.Inject;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author Elnic
 */
public class MagicDaoDbImpl implements MagicDao{
    
    
    private Magic magic = new Magic();
    
    public MagicDaoDbImpl() {
        magic.setMagicId(1);
        magic.setName("Wanda the Wand");
        magic.setCriticalStrikeModifier(10);
        magic.setMinDmg(3);
        magic.setMaxDmg(17);
        magic.setCritDmg(30);
        magic.setMaxDurability(150);
        magic.setDurability(150);
        magic.setElementalType("Earth");
    }

    
    
    @Override
    public Magic getMagic() {
        return this.magic;
    }

    @Override
    public void setMagic(Magic magic) {
        this.magic = magic;
    }

    @Override
    public void reset() {
    
        magic.setMagicId(1);
        magic.setName("Wanda the Wand");
        magic.setCriticalStrikeModifier(10);
        magic.setMinDmg(3);
        magic.setMaxDmg(17);
        magic.setCritDmg(30);
        magic.setMaxDurability(150);
        magic.setDurability(150);
        magic.setElementalType("Earth");
        
    }
    
}
