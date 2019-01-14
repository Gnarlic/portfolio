/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gnarlitronic.ps.spellswordgame.service;

import gnarlitronic.ps.spellswordgame.model.Enemy;
import gnarlitronic.ps.spellswordgame.model.Magic;
import gnarlitronic.ps.spellswordgame.model.PlayerCharacter;
import gnarlitronic.ps.spellswordgame.model.Sword;
import java.util.HashMap;
import java.util.Random;

/**
 *
 * @author Elnic
 */
public class GameplayServiceImpl implements GameplayService {

    private Enemy enemy = new Enemy();

    private void setupEnemy() {
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

    private Sword sword = new Sword();

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

    private PlayerCharacter pc = new PlayerCharacter();

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
        pc.setUnarmedDmg(2);
        pc.setExperience(0);
        pc.setCriticalStrikeChance(2);
    }

    private Magic magic = new Magic();

    private void newMagic() {
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
    public void initialize() {
        newCharacter();
        newSword();
        setupEnemy();
        newMagic();
    }

    @Override
    public int attack() {
        int attackDamage = pc.getUnarmedDmg() + sword.getMaxDmg() + magic.getMaxDmg();
        int criticalStrikeRequirement = 100 - (pc.getCriticalStrikeChance() + sword.getCriticalStrikeModifier() + magic.getCriticalStrikeModifier());
        Random ran = new Random();
        int attackChance = ran.nextInt(100) + 1;
        if (attackChance >= criticalStrikeRequirement) {
            enemy.setHealth(enemy.getHealth() - (sword.getCritDmg() + magic.getCritDmg()));
        } else if (attackChance > 65) {
            int actualAttackDamage = ran.nextInt(attackDamage) + 1;
            enemy.setHealth(enemy.getHealth() - actualAttackDamage);
        } else {
            int[] enemyAttack = enemy.getDamageRange();
            int actualEnemyAttack
                    = ran.nextInt((enemyAttack[1] - enemyAttack[0]) + 1) + enemyAttack[0];
            pc.setHealth(pc.getHealth() - actualEnemyAttack);
        }
        return enemy.getHealth();

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

    @Override
    public PlayerCharacter returnPC() {
        return pc;
    }

    @Override
    public Enemy returnEnemy() {
        return enemy;
    }

    @Override
    public int getPlayerHealth() {
        return pc.getHealth();
    }

    @Override
    public int getEnemyHealth() {
        return enemy.getHealth();
    }

    @Override
    public String getEquippedWeapon() {
        return sword.getName();
    }

    @Override
    public String getEquippedMagic() {
        return magic.getName();
    }

}
