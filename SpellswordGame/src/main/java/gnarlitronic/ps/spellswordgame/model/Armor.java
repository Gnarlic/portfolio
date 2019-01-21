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
public class Armor {
    
    
    
    private int armorId;
    private String name;
    private String elementalResist;
    private String elementalWeakness;
    private int dmgReduction;
    private int maxDurability;
    private int durability;

    public int getArmorId() {
        return armorId;
    }

    public void setArmorId(int armorId) {
        this.armorId = armorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getElementalResist() {
        return elementalResist;
    }

    public void setElementalResist(String elementalResist) {
        this.elementalResist = elementalResist;
    }

    public String getElementalWeakness() {
        return elementalWeakness;
    }

    public void setElementalWeakness(String elementalWeakness) {
        this.elementalWeakness = elementalWeakness;
    }

    public int getDmgReduction() {
        return dmgReduction;
    }

    public void setDmgReduction(int dmgReduction) {
        this.dmgReduction = dmgReduction;
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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + this.armorId;
        hash = 29 * hash + Objects.hashCode(this.name);
        hash = 29 * hash + Objects.hashCode(this.elementalResist);
        hash = 29 * hash + Objects.hashCode(this.elementalWeakness);
        hash = 29 * hash + this.dmgReduction;
        hash = 29 * hash + this.maxDurability;
        hash = 29 * hash + this.durability;
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
        final Armor other = (Armor) obj;
        if (this.armorId != other.armorId) {
            return false;
        }
        if (this.dmgReduction != other.dmgReduction) {
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
        if (!Objects.equals(this.elementalResist, other.elementalResist)) {
            return false;
        }
        if (!Objects.equals(this.elementalWeakness, other.elementalWeakness)) {
            return false;
        }
        return true;
    }
    
}
