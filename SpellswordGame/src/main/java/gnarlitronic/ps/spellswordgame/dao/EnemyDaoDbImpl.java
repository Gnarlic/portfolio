/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gnarlitronic.ps.spellswordgame.dao;

import gnarlitronic.ps.spellswordgame.model.Enemy;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;
import javax.inject.Inject;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author Elnic
 */
public class EnemyDaoDbImpl implements EnemyDao {

    private JdbcTemplate jdbc;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbc = jdbcTemplate;
    }

    Enemy enemy = new Enemy();

    @Override
    public Enemy getEnemy() {

        return enemy;
    }

    @Override
    public void setEnemy(Enemy enemy) {
        this.enemy = enemy;
    }

    @Override
    public void reset(int pcLvl) {
        this.enemy = jdbc.queryForObject("select * from EnemyGeneration where Id = 1", new EnemyMapper());
        Random ran = new Random();
        enemy.setLevel((ran.nextInt(10))+pcLvl+1);
        if(enemy.getLevel() <= 0) {
            enemy.setLevel(1);
        }
        int minDmg = ran.nextInt((enemy.getLevel() * 2) + 1);
        int maxDmg = ran.nextInt(enemy.getLevel() * 5) + minDmg;
        enemy.setDamageRange(new int[]{minDmg, maxDmg});
        enemy.setCriticalDmg(minDmg + maxDmg);
        int health = enemy.getHealth() * enemy.getLevel();
        enemy.setMaxHealth(health);
        enemy.setHealth(health);
    }

    private static final class EnemyMapper implements RowMapper<Enemy> {

        @Override
        public Enemy mapRow(ResultSet rs, int i) throws SQLException {
            Enemy enemy = new Enemy();
            Random ran = new Random();
            enemy.setEnemyId(rs.getInt("Id"));
            int health = ran.nextInt(rs.getInt("Health"))+11;
            enemy.setMaxHealth(health);
            enemy.setHealth(health);
            enemy.setCriticalStrikeChance(rs.getInt("CriticalStrikeModifier"));
            
            enemy.setEnemyName("Troll");
            return enemy;
        }

    }

}
