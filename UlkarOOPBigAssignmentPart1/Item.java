/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication25;

/**
 *
 * @author Ulkar Chobanova, WQ1C71
 * Class to represent items
 */
public abstract class Item {
    protected String id;
    protected String title;
    protected String author;
    protected int pageCnt;
    protected String topic;
    protected boolean hasDigitalCopy;
    protected int borrowTimes;
    protected int copyCnt;
    protected DigitalCopy digitalCopy;
    protected String damageLevel;

    /**
     * 
     *Constructor for item
     */
    public Item(String id, String title, String author, int pageCnt, String topic, boolean hasDigitalCopy, int borrowTimes, int copyCnt, DigitalCopy digitalCopy, String damageLevel) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.pageCnt = pageCnt;
        this.topic = topic;
        this.hasDigitalCopy = false;
        this.borrowTimes = borrowTimes;
        this.copyCnt = copyCnt;
        this.digitalCopy = digitalCopy;
        this.damageLevel = damageLevel;
    }
    
    public String getID()
    {
        return this.id;
    }
    
    public void setID(String id)
    {
        this.id = id;
    }
    
    public String getTitle()
    {
        return this.title;
    }
    
    public void setTitle(String title)
    {
        this.title = title;
    }
    
    public String getAuthor()
    {
        return this.author;
    }
    
    public void setAuthor(String author)
    {
        this.author = author;
    }
    
    public int getPageCnt()
    {
        return this.pageCnt;
    }
    
    public void setPageCnt(int pageCnt)
    {
        this.pageCnt = pageCnt;
    }
    
    public String getTopic()
    {
        return this.topic;
    }
    
    public void setTopic(String topic)
    {
        this.topic = topic;
    }
    
    public DigitalCopy getDigitalCopy()
    {
        return this.digitalCopy;
    }
    
    public boolean getHasDigitalCopy()
    {
        return this.hasDigitalCopy;
    }
    
    public int getBorrowTimes()
    {
        return this.borrowTimes;
    }
    
    public void setBorrowTimes(int borrowTimes)
    {
        this.borrowTimes = borrowTimes;
    }
    
    public int getCopyCnt()
    {
        return this.copyCnt;
    }
    
    public void setCopyCnt(int copyCnt)
    {
        this.copyCnt = copyCnt;
    }
    
    public String getDamageLevel()
    {
        return this.damageLevel;
    }
    
    public void setDamageLevel(String damageLevel)
    {
        this.damageLevel = damageLevel;
    }

    
    /**
     * method to check if the item can be borrowed 
     * @return 
     */
    public boolean canBeBorrowed(){
        return (copyCnt != 0 || hasDigitalCopy == true);
    }
    /**
     * method to add a digital copy
     */
    
    public void addDigitalCopy()
    {
        if(digitalCopy == null)
        {
            digitalCopy = new DigitalCopy(id, title);
            hasDigitalCopy = true;
        }
    }
    
    /**
     * method to add a physical copy
     */
    public void addCopy()
    {
        copyCnt++;
    }
    
    /**
     * method to inspect if an item is damaged
     * @return 
     */
    
    public boolean isDamaged()
    {
        boolean damaged = false;
        if(damageLevel.equals("None"))
            damaged = false;
        else if(damageLevel.equals("Normal") || damageLevel.equals("Severe"))
                damaged = true;
      return damaged;
    }
    
    /**
     * repairing an item by setting the damage level to "None"
     */
    public void repair()
    {
        damageLevel = "None";
    }
    
}
