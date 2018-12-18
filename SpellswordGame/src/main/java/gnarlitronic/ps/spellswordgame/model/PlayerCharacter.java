/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gnarlitronic.ps.spellswordgame.model;

/**
 *
 * @author Elnic
 */
public class PlayerCharacter {
    
    private int playerId;
    private String name;
    private int maxHealth;
    private int health;
    private int maxMana;
    private int mana;
    private int level;
    private int magicSkillLvl;
    private int swordSkillLvl;
    private int equippedSwordId;
    private int equippedMagicId;
    private int equippedArmorId;
    private int unarmedDmg;
    private int experience;
    private int criticalStrikeChance;

    public int getPlayerId() {
        return playerId;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getMaxMana() {
        return maxMana;
    }

    public void setMaxMana(int maxMana) {
        this.maxMana = maxMana;
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getMagicSkillLvl() {
        return magicSkillLvl;
    }

    public void setMagicSkillLvl(int magicSkill) {
        this.magicSkillLvl = magicSkill;
    }

    public int getSwordSkillLvl() {
        return swordSkillLvl;
    }

    public void setSwordSkillLvl(int swordSkill) {
        this.swordSkillLvl = swordSkill;
    }

    public int getEquippedSwordId() {
        return equippedSwordId;
    }

    public void setEquippedSwordId(int equippedSwordId) {
        this.equippedSwordId = equippedSwordId;
    }

    public int getEquippedMagicId() {
        return equippedMagicId;
    }

    public void setEquippedMagicId(int equippedMagicId) {
        this.equippedMagicId = equippedMagicId;
    }

    public int getEquippedArmorId() {
        return equippedArmorId;
    }

    public void setEquippedArmorId(int equippedArmorId) {
        this.equippedArmorId = equippedArmorId;
    }

    public int getUnarmedDmg() {
        return unarmedDmg;
    }

    public void setUnarmedDmg(int unarmedDmg) {
        this.unarmedDmg = unarmedDmg;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public int getCriticalStrikeChance() {
        return criticalStrikeChance;
    }

    public void setCriticalStrikeChance(int criticalStrikeChance) {
        this.criticalStrikeChance = criticalStrikeChance;
    }
    
}
