/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication18;

/**
 *
 * @author Admin
 */

/**
 * The Potion class represents a potion with its attributes: its name,
 * effect type, potency level, rarity classification, and expiration status.
 */
public class Potion {
    private String name;
    private String effectType;
    private double potencyLevel;
    private String rarityClassification;
    private boolean expired;
    
 /**
  * Constructs a new Potion object with its attributes.
  *
  * @param name name of the potion
  * @param effectType type of the potion 
  * @param potencyLevel potency level of the potion
  * @param rarityClassification the rarity classification of the potion
  * @param expired shows whether the potion has expired or not
 */

    public Potion(String name, String effectType, double potencyLevel, String rarityClassification, boolean expired) {
        this.name = name;
        this.effectType = effectType;
        this.potencyLevel = potencyLevel;
        this.rarityClassification = rarityClassification;
        this.expired = expired;
    }
    
    public String getName()
    {
        return this.name;
    }
    
    public void setName(String name)
    {
        this.name = name;
    }
    
    public String getType()
    {
        return this.effectType;
    }
    
    public void setType(String effectType)
    {
        this.effectType = effectType;
    }
    
    public double getPotencyLevel()
    {
        return this.potencyLevel;
    }
    
    public void setPotencyLevel(double potencyLevel)
    {
        this.potencyLevel = potencyLevel;
    }
    
    public String getRarityClassification()
    {
        return this.rarityClassification;
    }
    
    public void setRarityClassification(String rarityClassification)
    {
        this.rarityClassification = rarityClassification;
    }
    
    public boolean getExpired()
    {
        return this.expired;
    }
    
    public void setExpired(boolean expired)
    {
        this.expired = expired;
    }
}

