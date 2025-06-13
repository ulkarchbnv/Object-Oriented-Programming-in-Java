/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication25;
import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author Ulkar Chobanova, WQ1C71
 * This class is to build the university library system to
 * deal with actions like searching, borrowing, returning, adding items
 * and adding members.
 */
public class Library {
    private List<Item> collection;
    private List<Member> members;
    private List<Item> archive;
    private int repairedCnt;

/**
 * Constructor for Library
 * @param repairedCnt count of repaired items
 */
    public Library(int repairedCnt) {
        this.collection = new ArrayList<Item>();
        this.members = new ArrayList<Member>();
        this.archive = new ArrayList<Item>();
        this.repairedCnt = repairedCnt;
    }
    
    public List<Item> getCollection()
    {
        return this.collection;
    }
    
    public List<Member> getMembers()
    {
        return this.members;
    }
    
    public List<Item> getArchive()
    {
        return this.archive;
    }
    
    public int getRepairedCnt()
    {
        return this.repairedCnt;
    }
    
    public void setRepairedCnt(int repairedCnt)
    {
        this.repairedCnt = repairedCnt;
    }
    /**
     * Method to search an item by title.
     * @param title title of the item
     * @return found item or null
     */
    public Item searchByTitle(String title)
    {
        for(Item item: collection)
        {
            if(item.getTitle() == title)
            {
                return item;
            }
        }
        return null;
    }
    
    /**
     * Method to search an item by author.
     * @param author author of the item
     * @return found item or null
     */
    public Item searchByAuthor(String author)
    {
        for(Item item: collection)
        {
            if(item.getAuthor() == author)
            {
                return item;
            }
        }
        return null;
    }
    
    /**
     * method to add an item to the collection of the library
     * @param item the item we are looking for
     */
    public void addItem(Item item)
    {
        collection.add(item);
    }
    
    /**
     * method to find the most active
     * member according to the total borrowed count of the members
     * @return the most active member
     */
    public Member mostActiveMember()
    {
        if (members.isEmpty())
                {
                    return null;
                }
       Member mostTotalBorrowed = members.get(0);
       for(Member member: members)
       {
           if(member.getTotalBorrowed() > mostTotalBorrowed.getTotalBorrowed())
           {
               mostTotalBorrowed = member;
           }
       }
       return mostTotalBorrowed;
    }
    /**
     * Method to find the most popular item with 
     * the highest number of digital views
     * @return the item
     */
    
    public Item mostPopularDigitalItem()
    {
        DigitalCopy mostPopularDigital = collection.get(0).getDigitalCopy();
        Item mostPopularDigitalItem = null;
        for(Item item: collection)
        {
            if(item.getDigitalCopy().getViewCnt() > mostPopularDigital.getViewCnt())
            {
                mostPopularDigital = item.getDigitalCopy();
                mostPopularDigitalItem = item;
            }
        }
        return mostPopularDigitalItem;
    }
    
    /**
     * Method to find the most popular item 
     * according the times they have been borrowed.
     * @return the item
     */
    
    public Item mostPopularItem()
    {
        Item mostPopularItem = collection.get(0);
        for(Item item:collection)
        {
            if(item.getBorrowTimes() > mostPopularItem.getBorrowTimes())
            {
                mostPopularItem = item;
            }
        }
       return mostPopularItem;
    }
    
    /**
     * method to add a new member to the library
     * @param member 
     */
    
    public void addMember(Member member)
    {
        members.add(member);
    }
    
    /**
     * method to borrow an item to a member
     * @param item
     * @return true if borrowing happened sucessfully
     */
    
    public void borrowItem(Item item, Member member)
    {
        boolean canBeBorrowed = false;
        if(item.getItemType().equals("Book"))
        {
            if(item.getCopyCnt() >= 1 && member.getCurrentBorroweds().size() < member.getAllowedNum())
            {
                canBeBorrowed = true;
                item.setCopyCnt(item.getCopyCnt()-1);
                item.setBorrowTimes(item.getBorrowTimes()+1);
                member.getCurrentBorroweds().add(item);
            }
            else
            {
                canBeBorrowed = false;
            }
        }
        
        else if(item.getItemType().equals("Thesis"))
        {
            if(item.getCopyCnt() >= 1 && member.getCurrentBorroweds().size() < member.getAllowedNum())
            {
                canBeBorrowed = true;
                System.out.println("Author:" + item.getAuthor() + "Advisor" + item.getAdvisorName() + "Defense Year" + item.getDefenseYear());
            }
            else 
            {
                canBeBorrowed = false;
            }
        }
        
        else if(item.getItemType().equals("Research Paper"))
        {
            String username = "username";
            String passwd = "passwd";
            System.out.println("Here is username and password" + username + passwd);
            canBeBorrowed = true;
            item.getDigitalCopy().setViewCnt(item.getDigitalCopy().getViewCnt() + 1);
            item.getDigitalCopy().setDownloadCnt(item.getDigitalCopy().getDownloadCnt()+1);
        }
    }
    
    /**
     * method to return item by a member to the library
     * @param item
     * @return true if the item is not damaged 
     */
    
    public boolean returnItem(Item item)
    {
        boolean canBeReturned = false;
        if(item.getDamageLevel().equals("None"))
        {
            canBeReturned = true;
        }
        return canBeReturned;
    }
    
    /**
     * method to archive an item if it is severely damaged
     * @param item 
     */
    
    public void removeToArchive(Item item)
    {
        if(item.getDamageLevel().equals("Severe"))
        {
            archive.add(item);
        }
    }
    
    
    
}
