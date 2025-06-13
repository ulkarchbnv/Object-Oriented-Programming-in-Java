/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication18;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.List;
/**
 *
 * @author Admin
 */

/**
 * The Alchemist class represents an alchemist who has a collection of potions.
 * This class provides methods to perform various potion-related actions.
 */

public class Alchemist {
    private List<Potion> collection = new ArrayList<>();
    private int countBrews = 0; 
    
    /**
     * Constructs a new Alchemist object.
     */
    
    public Alchemist() {
    }
    
    public List<Potion> getCollection()
    {
        return new ArrayList<>(this.collection);
    }
    
     /**
     * Searches for the strongest potion according to potency level.
     * 
     * @return the strongest potion, or null in case the collection is empty
     */
    
    public Potion searchStrongestPotion()
    {
        if(collection.isEmpty())
        {
            return null;
        }
        Potion strongest = collection.get(0);
        
        for(int i = 1; i <= collection.size() - 1; i++)
        {
           if(collection.get(i).getPotencyLevel() > strongest.getPotencyLevel())
           {
               strongest = collection.get(i);
           }
        }
        return strongest;
    }
    
     /**
     * Counts the number of healing potions.
     * 
     * @return the number of healing potions
     */
    
    public int countHealingPotions()
    {
        int cnt = 0;
        for(Potion p: collection)
        {
            if(p.getType().equals("Healing"))
            {
                cnt++;
            }
        }
        return cnt;
    }
    
      /**
     * Finds and returns a list of potions which are either "Rare" or "Legendary".
     * 
     * @return a list of rare or legendary potions
     */
    
    public List<Potion> findRareOrLegendary()
    {
        List<Potion> newList = new ArrayList<>();
        for(Potion p: collection)
        {
            if(p.getRarityClassification().equals("Rare") || p.getRarityClassification().equals("Legendary"))
            {
                newList.add(p);
            }
        }
        return newList;
    }
    
      /**
     * Brews a new potion from the given ingredients. The new potion's attributes are calculated based
     * on the ingredients' attributes.
     * 
     * @param ingredients an array of Potions
     * @return a new Potion 
     * @throws IllegalArgumentException if no ingredients are provided
     */
    
    public Potion brewNewPotion(Potion[] ingredients)
    {
       if (ingredients.length == 0) {
           throw new IllegalArgumentException();
        }
//        ------------------------------------
        HashMap<String, Integer> counter = new HashMap<>();
        for (Potion potion : ingredients) {
            if (!counter.containsKey(potion.getType())) {
                counter.put(potion.getType(), 1);
            } else {
                int previous = counter.get(potion.getType());
                counter.put(potion.getType(), previous + 1);
            }
        }
        
        Entry<String, Integer> maxEntry = null;
        for (Entry<String, Integer> entry : counter.entrySet()) {
            if (maxEntry == null) {
                maxEntry = entry;
            } else {
                if (entry.getValue() > maxEntry.getValue()) {
                    maxEntry = entry;
                }
            }
        }
        
        String effType = maxEntry.getKey();
        //--------------------------------------------------------------------------------------------------------
        
       double maxPotLevel = ingredients[0].getPotencyLevel();
       double sum = 0.0;
       for(Potion p: ingredients)
       {
           sum += p.getPotencyLevel();
           if(p.getPotencyLevel() > maxPotLevel)
           {
               maxPotLevel = p.getPotencyLevel();
           }
       }
       
       double avg = sum / ingredients.length;
       
       double potLevel = maxPotLevel + avg;
       
       String rarity = "Legendary";
       
       boolean expired = false;
       for(Potion p: ingredients)
       {
           if(p.getExpired())
           {
               expired = true;
           }
       }
       
       String name = "New Potion";
       
       countBrews++;
        return new Potion(name, effType, potLevel, rarity, expired);
    }
    
    /**
     * Removes expired potions from the collection.
     * 
     * @return a list of non-expired potions remaining
     */
    
    public List<Potion> removeExpireds()
    {
        List<Potion> unExpired = new ArrayList<>();
        for(Potion p: collection)
        {
            if(!p.getExpired())
            {
                unExpired.add(p);
            }
        }
        collection = unExpired;
        return new ArrayList<>(collection);
    }
    
     /**
     * Returns the total number of potions brewed by the alchemist.
     * 
     * @return the count of brewed potions
     */
    
    public int cntInventory()
    {
       return countBrews;
       
    }
    
     /**
     * Adds a new potion to the alchemist's collection.
     * 
     * @param p the potion to add
     * @return the updated collection
     */
    
    public List<Potion> addPotion(Potion p)
    {
       collection.add(p);
       return collection;
    }
}
