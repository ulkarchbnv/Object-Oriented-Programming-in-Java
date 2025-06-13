/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication25;

/**
 * class to represent a Digital Copy of the item
 * @author Ulkar Chobanova, WQ1C71
 */
public class DigitalCopy {
    private String id;
    private String title;
    private int viewCnt;
    private int downloadCnt;

    /**
     * constructor for the digital copy
     * initializing the viewCnt and downloadCnt to 0
     * @param id
     * @param title 
     */
    public DigitalCopy(String id, String title) {
        this.id = id;
        this.title = title;
        this.viewCnt = 0;
        this.downloadCnt = 0;
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
    
    public int getViewCnt()
    {
        return this.viewCnt;
    }
    
    public int getDownloadCnt()
    {
        return this.downloadCnt;
    }
    
    /**
     * updating the view count
     */
    public void view()
    {
        viewCnt++;
    }
    
    /**
     * updating the downloadCnt
     */
    public void download()
    {
        downloadCnt++;
    }
    
    
    
    
}
