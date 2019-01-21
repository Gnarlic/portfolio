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
    public void reset() {
        this.enemy = jdbc.queryForObject("select * from EnemyGeneration where Id = 1", new EnemyMapper());

    }

    private static final class EnemyMapper implements RowMapper<Enemy> {

        @Override
        public Enemy mapRow(ResultSet rs, int i) throws SQLException {
            Enemy enemy = new Enemy();
            enemy.setEnemyId(rs.getInt("Id"));
            enemy.setLevel(rs.getInt("Lvl"));
            Random ran = new Random();
            int minDmg = ran.nextInt(enemy.getLevel() * 3) + enemy.getLevel();
            int maxDmg = ran.nextInt(enemy.getLevel() * 7) + minDmg;
            enemy.setDamageRange(new int[]{minDmg, maxDmg});
            int health = ran.nextInt(rs.getInt("Health"));
            enemy.setMaxHealth(health);
            enemy.setHealth(health);
            enemy.setCriticalStrikeChance(rs.getInt("CriticalStrikeModifier"));
            enemy.setCriticalDmg(minDmg + maxDmg);
            enemy.setEnemyName("Troll");
            return enemy;
        }

    }

}
