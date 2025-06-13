/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication25;
import java.util.List;
import java.util.ArrayList;

/**
 *Class to represent a member of the library
 * @author Ulkar Chobanova, WQ1C71
 */
public class Member {
    private String id;
    private String name;
    private String email;
    private cat category;
    private int totalBorrowed;
    private int allowedNum;
    private List<Item> currentBorroweds;
    private int borrowLimit;
/**
 * 
 * Constructor for a member
 */
    public Member(String id, String name, String email, cat category, int totalBorrowed, int allowedNum, List<Item> currentBorroweds, int borrowLimit) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.category = category;
        this.totalBorrowed = 0;
        this.allowedNum = allowedNum;
        this.currentBorroweds = new ArrayList<Item>();
        this.borrowLimit = 3;
    }
    
    public String getID()
    {
        return this.id;
    }
    
    public void setID(String id)
    {
        this.id = id;
    }
    
    public String getName()
    {
        return this.name;
    }
    
    public void setName(String name)
    {
        this.name = name;
    }
    
    public String getEmail()
    {
        return this.email;
    }
    
    public void setEmail(String email)
    {
        this.email = email;
    }
    
    public cat getCat()
    {
        return this.category;
    }
    
    public int getTotalBorrowed()
    {
        return this.totalBorrowed;
    }
    
    public void setTotalBorrowed(int totalBorrowed)
    {
        this.totalBorrowed = totalBorrowed;
    }
    
    public int getAllowedNum()
    {
        return this.allowedNum;
    }
    
    public void setAllowedNum(int allowedNum)
    {
        this.allowedNum = allowedNum;
    }
    
    public List<Item> getCurrentBorroweds()
    {
        return this.currentBorroweds;
    }
    
    public int getBorrowLimit()
    {
        return this.borrowLimit;
    }
    
    
   /**
    * method to borrow an item by member
    * @param item 
    */
    public void borrowItem(Item item)
    {
        if((currentBorroweds.size() < allowedNum) && item.canBeBorrowed() == true)
            currentBorroweds.add(item);
    }
    
    /**
     * method to return an item and update the number of allowed borrows
     * @param item 
     */
    public void returnItem(Item item)
    {
        if(currentBorroweds.remove(item) && item.getDamageLevel().equals("None"))
            totalBorrowed++;
            allowedNum = borrowLimit + (totalBorrowed/3);
    }
    
 
}
