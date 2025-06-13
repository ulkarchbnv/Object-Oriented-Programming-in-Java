/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javaapplication25;
import java.io.*;
import java.util.*;


/**
 *
 * @author Ulkar Chobanova, WQ1C71
 */
public class JavaApplication25 {

    /**
     * main class for the simulation and reading files
     * @param args the command line arguments
     */
    public static void main(String[] args){
        Library lib = new Library(0);
        readItems(lib);
        readMembers(lib);
        trySim(lib);
        others(lib);
    }
    
    /**
     * method to read items from items.txt
     * @param lib 
     */
    public static void readItems(Library lib)
    {
        try{
            Scanner scanner = new Scanner(new File("items.txt"));
            
            while(scanner.hasNextLine())
            {
                String[] itemInfo = scanner.nextLine().split(" ");
                String id = itemInfo[0];
                String title = itemInfo[1];
                String author = itemInfo[2];
                int pageCnt = Integer.parseInt(itemInfo[3]);
                String topic = itemInfo[4];
                String type = itemInfo[5];
                int copyCnt = Integer.parseInt(itemInfo[6]);
                String advisor = itemInfo[7];
                String defenseYear = itemInfo[8];
                
                Item item;
                if(type == "Book")
                {
                    item = new Book(id,title,author,pageCnt,topic,0, copyCnt, "None");
                    
                }
                else if(type == "Thesis")
                {
                    item = new Thesis(id,title,author,pageCnt,topic,0,copyCnt, "None", advisor, defenseYear);
                    
                }
                else
                {
                    item = new ResearchPaper(id,title,author,pageCnt,topic,0,copyCnt,"None");
                }
                
                item.addDigitalCopy();
                
                lib.addItem(item);
            }
            scanner.close();
            } catch(Exception exc){
                System.out.println("Couldn't read items file");
        }
    }
    
    /**
     * method to read members from members.txt
     * @param lib 
     */
    public static void readMembers(Library lib)
    {
        try {
            Scanner scan = new Scanner(new File("members.txt"));
            while(scan.hasNextLine())
            {
                String[] memberInfo = scan.nextLine().split(" ");
                String id = memberInfo[0];
                String name = memberInfo[1];
                String email = memberInfo[2];
                String type = memberInfo[3];
                
                cat category;
                if(type == "Student")
                {
                    category = cat.Student;
                }
                
                else if(type == "Faculty")
                {
                    category = cat.Faculty;
                }
                
                else
                {
                    category = cat.Alumni;
                }
                
                Member member = new Member(id, name, email, category, 0, 3, new ArrayList<>(), 3);
                lib.addMember(member);
            }
            scan.close();
        } catch(Exception ex)
        {
            System.out.println("Couldnt read members file");
            
        }
    }
    
    /**
     * method for the simulation
     * @param lib 
     */
    public static void trySim(Library lib)
    {
        List<Member> members = lib.getMembers();
        List<Item> collection = lib.getCollection();
        
        System.out.println("Borrow");
        for(int i = 0; i < members.size() && i < collection.size(); i++)
        {
            Member member = members.get(i);
            Item item = collection.get(i);
            if(item.canBeBorrowed() && member.getCurrentBorroweds().size() < member.getAllowedNum())
            {
            member.borrowItem(item);
            item.setCopyCnt(item.getCopyCnt()-1);
            item.setBorrowTimes(item.getBorrowTimes()+1);
            System.out.println(member.getName()+ "borrowed" + item.getTitle());
            }
        }
        
        System.out.println("Return");
        for(int i = 0; i < members.size(); i++)
        {
            Member member = members.get(i);
            List<Item> currentBorrows = member.getCurrentBorroweds();
            if (!currentBorrows.isEmpty())
            {
                Item item = currentBorrows.get(0);
                item.setDamageLevel("None");
                member.returnItem(item);
                System.out.println(member.getName()+"returned" + item.getTitle());
            }
        }
        
        System.out.println("Digital Copy");
        for(int i = 0; i < collection.size() && i < members.size(); i++)
        {
            Item item = collection.get(i);
            Member member = members.get(i);
            if(item.getHasDigitalCopy() == true)
            {
                item.getDigitalCopy().view();
                System.out.println(item.getTitle() + "viewed");
                item.getDigitalCopy().download();
                System.out.println(item.getTitle() + "downloaded");
                
                
            }
        }
      System.out.println("Repair");
      int repairCnt = 0;
      for(Item item : collection)
      {
         if(item.isDamaged())
         {
             item.repair();
             repairCnt++;
             System.out.println(item.getTitle() + "repaired");
         }
      }
      lib.setRepairedCnt(lib.getRepairedCnt() + repairCnt);
    }
    
    /**
     * method for other functions in library class 
     * @param lib 
     */
    public static void others(Library lib)
    {
        Member mostActive = lib.mostActiveMember();
        if(mostActive!=null)
        {
            System.out.println("Most active member is" + mostActive.getName());
            
        }
        
        Item mostPopular = lib.mostPopularItem();
        if(mostPopular!= null)
        {
            System.out.println("Most popular item is" + mostPopular.getTitle());
            
        }
        
        Item mostPopularDigital = lib.mostPopularDigitalItem();
        if(mostPopularDigital != null && mostPopularDigital.getHasDigitalCopy())
        {
            System.out.println("Most popular digital item is" + mostPopularDigital.getTitle());
            
        }
        
        System.out.println("Archives item count is" + lib.getArchive().size());
        System.out.println("Repaired item count is" + lib.getRepairedCnt());
    }
    
      }
        
        
        
    
    
