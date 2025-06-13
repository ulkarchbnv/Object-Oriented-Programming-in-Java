/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package javaapplication18;

import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Admin
 */
public class NewEmptyJUnitTest {
    private Alchemist alchemist;
    private Potion healingPotion1, healingPotion2, healingPotion3;
    private Potion poisonPotion1, poisonPotion2, poisonPotion3, poisonPotion4;
    private Potion staminaBoost1, staminaBoost2, staminaBoost3;
    
    public NewEmptyJUnitTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        alchemist = new Alchemist();
        
        healingPotion1 = new Potion("healingPotion1", "Healing", 10.5, "Common", true);
        healingPotion2 = new Potion("healingPotion2", "Healing", 3.1 , "Rare", false);
        healingPotion3 = new Potion("healingPotion3", "Healing", 20.23 , "Legendary", true);
        poisonPotion1 = new Potion("poisonPotion1", "Poison", 23.11, "Common", true);
        poisonPotion2 = new Potion("poisonPotion2", "Poison", 33.12, "Rare", false);
        poisonPotion3 = new Potion("poisonPotion3", "Poison", 49.11, "Legendary", true);
        poisonPotion4 = new Potion("poisonPotion4", "Poison", 11.19, "Common", false);
        staminaBoost1 = new Potion("staminaBoost1", "StaminaBoost", 29.49, "Common", true);
        staminaBoost2 = new Potion("staminaBoost2", "StaminaBoost", 3.3, "Rare", false);
        staminaBoost3 = new Potion("staminaBoost3", "StaminaBoost", 29.49, "Legendary", true);
        
        alchemist.addPotion(healingPotion1);
        alchemist.addPotion(healingPotion2);
        alchemist.addPotion(healingPotion3);
        alchemist.addPotion(poisonPotion1);
        alchemist.addPotion(poisonPotion2);
        alchemist.addPotion(poisonPotion3);
        alchemist.addPotion(poisonPotion4);
        alchemist.addPotion(staminaBoost1);
        alchemist.addPotion(staminaBoost2);
        alchemist.addPotion(staminaBoost3);  
    }
    
    @After
    public void tearDown() {
    }

   @Test
   public void testSearchStrongestPotion()
   {
       Potion strongest = alchemist.searchStrongestPotion();
       assertEquals("Function should return the strongest", poisonPotion3, strongest);
   }
   
   @Test
   public void testHealingPotions()
   {
       assertEquals("Function should return the count", 3, alchemist.countHealingPotions());
   }
   
   @Test
   public void testRareLegend()
   {
       List<Potion> expectedResult = new ArrayList<>(
            List.of(healingPotion2,
        healingPotion3 ,
        poisonPotion2 ,
        poisonPotion3 ,
        staminaBoost2 ,
        staminaBoost3 ));
        
       
       List<Potion> rareAndLegends = alchemist.findRareOrLegendary();
       assertArrayEquals("Return answer should be equal", expectedResult.toArray(), rareAndLegends.toArray());
   }
   
   @Test
   public void testRemoveExpired()
   {
       List<Potion> removedExps = alchemist.removeExpireds();
       assertEquals("Return answer should be equal", alchemist.getCollection(), removedExps);
   }
   
   @Test 
   public void testBrewPotions()
   {
       Potion[] ingredients = {healingPotion1, healingPotion2, staminaBoost1, staminaBoost2, staminaBoost3, poisonPotion1};
       Potion newPotion = alchemist.brewNewPotion(ingredients);
       assertNotNull("Created potion should not be null", newPotion);
       assertEquals("The rarity classification should be legendary", newPotion.getRarityClassification(), "Legendary");
       assertEquals("Type should be the most frequent", newPotion.getType(), "StaminaBoost");
       assertEquals("The name should be \"New Potion\"", newPotion.getName(), "New Potion" ); 
   }
   
   @Test 
   public void testAddPotions()
   {
       Potion poisonPotion5 = new Potion("poisonPotion5", "Poison", 23.12, "Legendary", false);
       alchemist.addPotion(poisonPotion5);
       assertNotNull("Returned list should not be null", alchemist.getCollection());
       assertTrue("Returned list should contain the added potion", alchemist.getCollection().contains(poisonPotion5));
       assertEquals("Size should be 11 after adding one potion", 11, alchemist.getCollection().size());
   }  
}
