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
public class EnemyDaoDbImpl implements EnemyDao {

    Enemy enemy = new Enemy();

    public EnemyDaoDbImpl() {

        enemy.setEnemyId(1);
        enemy.setEnemyName("Troll");
        int[] dmgRange = {1, 10};
        enemy.setDamageRange(dmgRange);
        enemy.setLevel(1);
        enemy.setMaxHealth(350);
        enemy.setHealth(350);
        enemy.setElementalResistance("Water");
        enemy.setElementalWeakness("Fire");
        enemy.setCriticalStrikeChance(10);
        enemy.setLootChance(200);
        enemy.setPoints(25);
    }

    @Override
    public Enemy getEnemy() {
        return this.enemy;
    }

    @Override
    public void setEnemy(Enemy enemy) {
        this.enemy = enemy;
    }

}
