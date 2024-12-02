package org.AlienVsHumansGame.model.entities;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EntityTest {

    private Entity entityHuman;
    private Entity entityAlien;

    @BeforeEach
    void setUp() {
        // Initialize human and alien objects before each test
        entityHuman = new Human("John");
        entityAlien = new Alien("Zorg");
    }

    // Constructor test
    @Test
    void testConstructor() {
        // Check if the entity's health is set correctly (it should be base health 100)
        assertEquals(100, entityHuman.getHealth(), "Health should be initialized to 100");
        assertEquals(100, entityAlien.getHealth(), "Health should be initialized to 100");

        // Check if the entity's attack damage is set correctly (it should be base attack 10)
        assertEquals(10, entityHuman.getAttackDamage(), "Attack damage should be initialized to 10");
        assertEquals(10, entityAlien.getAttackDamage(), "Attack damage should be initialized to 10");

    }

    @Test
    public void testDefaultName() {
        System.out.println("Testing name...");
        assertEquals("John", entityHuman.getName(), "Name should be John by default");
        assertEquals("Zorg", entityAlien.getName(), "Name should be Zorg by default");
        System.out.println("Successful");
        System.out.println();
    }

    @Test
    public void testDefaultHealth() {
        System.out.println("Testing health...");
        assertEquals(100, entityHuman.getHealth(), "Health should be 100 by default");
        assertEquals(100, entityAlien.getHealth(), "Health should be 100 by default");
        System.out.println("Successful");
        System.out.println();
    }

    @Test
    public void testDefaultAttack() {
        System.out.println("Testing damage...");
        assertEquals(10, entityHuman.getAttackDamage(), "Attack should be 10 by default");
        assertEquals(10, entityAlien.getAttackDamage(), "Attack should be 10 by default");
        System.out.println("Successful");
        System.out.println();
    }

    @Test
    public void testSetHealth() {
        System.out.println("Testing setting health...");

        entityHuman.setHealth(80);
        entityAlien.setHealth(80);
        assertEquals(80, entityHuman.getHealth(), "Health should be 80");
        assertEquals(80, entityAlien.getHealth(), "Health should be 80");

        entityHuman.setHealth(2000);
        entityAlien.setHealth(2000);
        assertEquals(100, entityHuman.getHealth(), "Health cannot exceed " + 100);
        assertEquals(100, entityAlien.getHealth(), "Health cannot exceed " + 100);

        entityHuman.setHealth(-100);
        entityAlien.setHealth(-100);
        assertEquals(0, entityHuman.getHealth(), "Health cannot fall under 0");
        assertEquals(0, entityAlien.getHealth(), "Health cannot fall under 0");

        System.out.println("Successful");
        System.out.println();
    }

    @Test
    public void testModifyHealth() {
        System.out.println("Testing modifying health...");

        entityHuman.modifyHealth(-10);
        entityAlien.modifyHealth(-10);
        assertEquals(90, entityHuman.getHealth(), "Health should be 90");
        assertEquals(90, entityAlien.getHealth(), "Health should be 90");

        entityHuman.modifyHealth(10);
        entityAlien.modifyHealth(10);
        assertEquals(100, entityHuman.getHealth(), "Health should be 100");
        assertEquals(100, entityAlien.getHealth(), "Health should be 100");

        entityHuman.modifyHealth(-200);
        entityAlien.modifyHealth(-200);
        assertEquals(0, entityHuman.getHealth(), "Health cannot go below 0");
        assertEquals(0, entityAlien.getHealth(), "Health cannot go below 0");

        entityHuman.modifyHealth(+1000);
        entityAlien.modifyHealth(+1000);
        assertEquals(100, entityHuman.getHealth(), "Health cannot exceed " + 100);
        assertEquals(100, entityAlien.getHealth(), "Health cannot exceed " + 100);

        int initialHealth = entityHuman.getHealth();
        entityHuman.modifyHealth(0);
        entityAlien.modifyHealth(0);
        assertEquals(initialHealth, entityHuman.getHealth(), "Health should be unchanged");
        assertEquals(initialHealth, entityAlien.getHealth(), "Health should be unchanged");

        System.out.println("Successful");
        System.out.println();
    }

    @Test
    public void testAttacking(){
        System.out.println("Testing attacking...");
        entityHuman.attack(entityAlien);
        entityAlien.attack(entityHuman);
        assertEquals(90, entityAlien.getHealth(), "Should have done 10 damage and reduce health to 90");
        assertEquals(90, entityHuman.getHealth(), "Should have done 10 damage and reduce health to 90");

        System.out.println("Success");
        System.out.println();
    }

    @AfterAll
    public static void tearDown() {
        // Optionally, you can log, release resources, or reset states here
        System.out.println("Test completed and resources cleaned up.");
    }
}
