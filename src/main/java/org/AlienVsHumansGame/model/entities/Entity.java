package org.AlienVsHumansGame.model.entities;

public abstract class Entity {


    private String name;
    private int health;
    private int attackDamage;


    public Entity(String name) {
        this.name = name;
        this.health = 100;
        this.attackDamage = 10;

    }


    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        if (health < 0) {
            this.health = 0;
        } else if (health > 100) {
            this.health = 100;
        } else {
            this.health = health;
        }
    }

    public int getAttackDamage() {
        return attackDamage;
    }

    public void setAttackDamage(int attackDamage) {
        this.attackDamage = attackDamage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public void modifyHealth(int healthAmount) {
        this.health += healthAmount;
        if (this.health < 0) {
            this.health = 0;
        }
        if (this.health > 100) {
            this.health = 100;
        }
    }


    public void attack(Entity entity){
        entity.modifyHealth(-(this.getAttackDamage()));

    }

}

