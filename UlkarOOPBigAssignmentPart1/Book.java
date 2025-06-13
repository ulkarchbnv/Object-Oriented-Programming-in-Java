/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication25;

/**
 * class to represent a book, which is a type of an item
 * @author Ulkar Chobanova, WQ1C71
 */
public class Book extends Item {
    public Book(String id, String title, String author, int pageCnt, String topic, int borrowTimes, int copyCnt, String damageLevel)
    {
        super(id,title,author,pageCnt,topic,false,borrowTimes,copyCnt,null,damageLevel);
    }

}
