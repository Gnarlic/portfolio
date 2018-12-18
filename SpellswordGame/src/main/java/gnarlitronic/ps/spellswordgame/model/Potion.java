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
public class Potion {
    
    private int potionId;
    private int healthRestored;
    private int manaRestored;

    public int getPotionId() {
        return potionId;
    }

    public void setPotionId(int potionId) {
        this.potionId = potionId;
    }

    public int getHealthRestored() {
        return healthRestored;
    }

    public void setHealthRestored(int healthRestored) {
        this.healthRestored = healthRestored;
    }

    public int getManaRestored() {
        return manaRestored;
    }

    public void setManaRestored(int manaRestored) {
        this.manaRestored = manaRestored;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + this.potionId;
        hash = 17 * hash + this.healthRestored;
        hash = 17 * hash + this.manaRestored;
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
        final Potion other = (Potion) obj;
        if (this.potionId != other.potionId) {
            return false;
        }
        if (this.healthRestored != other.healthRestored) {
            return false;
        }
        if (this.manaRestored != other.manaRestored) {
            return false;
        }
        return true;
    }
    
}
