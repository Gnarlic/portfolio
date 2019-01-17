/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gnarlitronic.ps.spellswordgame.dao;

import gnarlitronic.ps.spellswordgame.model.Enemy;

/**
 *
 * @author Elnic
 */
public interface EnemyDao {
    
    public Enemy getEnemy();
    
    public void setEnemy(Enemy enemy);
    
    public void reset();
}
