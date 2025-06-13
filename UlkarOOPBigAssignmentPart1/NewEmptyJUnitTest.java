/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package javaapplication25;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class NewEmptyJUnitTest {
    private Library lib;
    private Member member1;
    private Member member2;
    private Thesis thesis;
    private Book book;
    private ResearchPaper research;
    
    @Before
    public void setUp(){
        lib = new Library(0);
        member1 = new Member("12", "Ulkar Chobanova", "wq1c71@inf.elte.hu", cat.Student, 0, 3, new ArrayList<>(), 3);
        member2 = new Member("13", "Ulus", "wdjl@inf.elte.hu", cat.Alumni, 0, 3, new ArrayList<>(), 3);
        thesis = new Thesis("111", "Machine Learning", "Ulk", 345, "Data Science", 0, 1, "None");
        book = new Book("001", "Development", "Krist", 678, "Psychology", 0, 3, "None");
        research = new ResearchPaper("003", "Experiment", "Thomas", 678, "Science", 0, 3, "None");
        lib.addMember(member1);
        lib.addMember(member2);
        lib.addItem(book);
        lib.addItem(thesis);
        lib.addItem(research);
    }
    
    @Test
    public void testAddMember()
    {
        assertEquals(1, lib.getMembers().size());
    }
    
    @Test
    public void testAddItem()
    {
        assertEquals(3, lib.getCollection().size());
    }
    
    @Test
    public void testMostPopularItem()
    {
        book.setBorrowTimes(10);
        assertEquals(book, lib.mostPopularItem());
    }
    
    @Test
    public void testMostActiveMember()
    {
        member1.setTotalBorrowed(20);
        member2.setTotalBorrowed(30);
        assertEquals(member2, lib.mostActiveMember());
    }
    
    @Test
    public void testSearchByTitle()
    {
        Item found = lib.searchByTitle("Machine Learning");
        assertEquals(thesis, found);
    }
    
    @Test
    public void testSearchByAuthor()
    {
        Item found = lib.searchByAuthor("Krist");
        assertEquals(book, found);
    }
    
    @Test 
    public void testRemoveToArchive()
    {
        thesis.setDamageLevel("Severe");
        lib.removeToArchive(thesis);
        assertTrue(lib.getArchive().contains(thesis));
    }
    
    @Test
    public void testBorrow()
    {
        member1.borrowItem(thesis);
        boolean borrow = lib.borrowItem(thesis);
        assertEquals(0, book.getCopyCnt());
    }
    
    @Test
    public void testReturn()
    {
        member1.borrowItem(thesis);
        lib.borrowItem(thesis);
        member1.returnItem(thesis);
        boolean returned = lib.returnItem(thesis);
        assertEquals("None", thesis.getDamageLevel());
        assertTrue(returned);
        
    }
    
    
    
}
