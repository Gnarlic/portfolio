/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gnarlitronic.ps.spellswordgame.dao;

import gnarlitronic.ps.spellswordgame.model.PlayerCharacter;

/**
 *
 * @author Elnic
 */
public interface PlayerCharacterDao {
    
    public PlayerCharacter getPc();
    
    public void setPc(PlayerCharacter pc);
    
}
