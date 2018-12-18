/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gnarlitronic.ps.spellswordgame.model;

import java.util.Objects;

/**
 *
 * @author Elnic
 */
public class Magic {
    
    private int magicId;
    private String name;
    private int criticalStrikeModifier;
    private int minDmg;
    private int maxDmg;
    private int critDmg;
    private int maxDurability;
    private int durability;
    private String elementalType;

    public int getMagicId() {
        return magicId;
    }

    public void setMagicId(int magicId) {
        this.magicId = magicId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCriticalStrikeModifier() {
        return criticalStrikeModifier;
    }

    public void setCriticalStrikeModifier(int criticalStrikeModifier) {
        this.criticalStrikeModifier = criticalStrikeModifier;
    }

    public int getMinDmg() {
        return minDmg;
    }

    public void setMinDmg(int minDmg) {
        this.minDmg = minDmg;
    }

    public int getMaxDmg() {
        return maxDmg;
    }

    public void setMaxDmg(int maxDmg) {
        this.maxDmg = maxDmg;
    }

    public int getCritDmg() {
        return critDmg;
    }

    public void setCritDmg(int critDmg) {
        this.critDmg = critDmg;
    }

    public int getMaxDurability() {
        return maxDurability;
    }

    public void setMaxDurability(int maxDurability) {
        this.maxDurability = maxDurability;
    }

    public int getDurability() {
        return durability;
    }

    public void setDurability(int durability) {
        this.durability = durability;
    }

    public String getElementalType() {
        return elementalType;
    }

    public void setElementalType(String elementalType) {
        this.elementalType = elementalType;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + this.magicId;
        hash = 37 * hash + Objects.hashCode(this.name);
        hash = 37 * hash + this.criticalStrikeModifier;
        hash = 37 * hash + this.minDmg;
        hash = 37 * hash + this.maxDmg;
        hash = 37 * hash + this.critDmg;
        hash = 37 * hash + this.maxDurability;
        hash = 37 * hash + this.durability;
        hash = 37 * hash + Objects.hashCode(this.elementalType);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Magic other = (Magic) obj;
        if (this.magicId != other.magicId) {
            return false;
        }
        if (this.criticalStrikeModifier != other.criticalStrikeModifier) {
            return false;
        }
        if (this.minDmg != other.minDmg) {
            return false;
        }
        if (this.maxDmg != other.maxDmg) {
            return false;
        }
        if (this.critDmg != other.critDmg) {
            return false;
        }
        if (this.maxDurability != other.maxDurability) {
            return false;
        }
        if (this.durability != other.durability) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.elementalType, other.elementalType)) {
            return false;
        }
        return true;
    }
    
}
