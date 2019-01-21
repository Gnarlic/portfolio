/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gnarlitronic.ps.spellswordgame.service;

import gnarlitronic.ps.spellswordgame.dao.ArmorDao;
import gnarlitronic.ps.spellswordgame.dao.EnemyDao;
import gnarlitronic.ps.spellswordgame.dao.MagicDao;
import gnarlitronic.ps.spellswordgame.dao.PlayerCharacterDao;
import gnarlitronic.ps.spellswordgame.dao.PotionDao;
import gnarlitronic.ps.spellswordgame.dao.WeaponDao;
import gnarlitronic.ps.spellswordgame.model.Enemy;
import gnarlitronic.ps.spellswordgame.model.Magic;
import gnarlitronic.ps.spellswordgame.model.PlayerCharacter;
import gnarlitronic.ps.spellswordgame.model.Weapon;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import javax.inject.Inject;

/**
 *
 * @author Elnic
 */
public class GameplayServiceImpl implements GameplayService {


    private ArmorDao aDao;

    private EnemyDao eDao;

    private MagicDao mDao;

    private PlayerCharacterDao pDao;

    private PotionDao potDao;

    private WeaponDao wDao;
    
    @Inject
    GameplayServiceImpl(ArmorDao aDao, EnemyDao eDao, MagicDao mDao, PlayerCharacterDao pDao, PotionDao potDao, WeaponDao wDao) {
        this.aDao = aDao;
        this.eDao = eDao;
        this.mDao = mDao;
        this.pDao = pDao;
        this.potDao = potDao;
        this.wDao = wDao;
    }

    @Override
    public void initialize() {
        
    }

    @Override
    public int attack() {
        Enemy enemy = eDao.getEnemy();
        PlayerCharacter pc = pDao.getPc();
        Weapon sword = wDao.getWeapon();
        Magic magic = mDao.getMagic();
        int attackDamage = pc.getUnarmedDmg() + sword.getMaxDmg() + magic.getMaxDmg();
        int criticalStrikeRequirement = 100 - (pc.getCriticalStrikeChance() + sword.getCriticalStrikeModifier() + magic.getCriticalStrikeModifier());
        Random ran = new Random();
        int attackChance = ran.nextInt(100) + 1;
        if (attackChance >= criticalStrikeRequirement) {
            enemy.setHealth(enemy.getHealth() - (sword.getCritDmg() + magic.getCritDmg()));
            eDao.setEnemy(enemy);
        } else if (attackChance > 65) {
            int actualAttackDamage = ran.nextInt(attackDamage) + 1;
            enemy.setHealth(enemy.getHealth() - actualAttackDamage);
            eDao.setEnemy(enemy);
        } else {
            int[] enemyAttack = enemy.getDamageRange();
            int actualEnemyAttack
                    = ran.nextInt((enemyAttack[1] - enemyAttack[0]) + 1) + enemyAttack[0];
            pc.setHealth(pc.getHealth() - actualEnemyAttack);
            pDao.setPc(pc);
        }
        return enemy.getHealth();

    }

    @Override
    public HashMap<Integer, Weapon> itemDrop() {
        HashMap swordDrop = new HashMap<Integer, Weapon>();
        swordDrop.put(1, wDao.getWeapon());
        return swordDrop;
    }

    @Override
    public Enemy generateEnemy() {
        return eDao.getEnemy();
    }

    @Override
    public PlayerCharacter returnPC() {
        return pDao.getPc();
    }

    @Override
    public Enemy returnEnemy() {
        return eDao.getEnemy();
    }

    @Override
    public int getPlayerHealth() {
        PlayerCharacter pc = pDao.getPc();
        return pc.getHealth();
    }

    @Override
    public int getEnemyHealth() {
        Enemy enemy = eDao.getEnemy();
        return enemy.getHealth();
    }

    @Override
    public String getEquippedWeapon() {
        Weapon sword = wDao.getWeapon();
        return sword.getName();
    }

    //returns equipped magic item
    @Override
    public String getEquippedMagic() {
        Magic magic = mDao.getMagic();
        return magic.getName();
    }

    //temporary method for restarting game
    @Override
    public void reset() {
        mDao.reset();
        wDao.reset();
        eDao.reset();
        pDao.reset();
    }

    //returns all available weapons
    @Override
    public List<Weapon> loadWeapons() {
        
        return wDao.allWeapons();
        
    }

    //Returns user selected weapon
    @Override
    public Weapon getWeapon(String id) {
        return wDao.getWeapon(id);
    }

    @Override
    public Object getEnemy() {
        
        return eDao.getEnemy();
        
    }
    
    
}
