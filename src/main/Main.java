package main;

import database.DB;
import database.JsonDB;

import java.util.Scanner;

public class Main {
    
    public static void main(String args[]){
        
        DB database = new JsonDB();
        database.readDB();
        
        boolean exit = false;
        int option = 0;
        Scanner s = new Scanner (System.in);
        
        do{ 
            System.out.println("Menu");
            System.out.println("1. List active users");
            System.out.println("2. List the cities whose city begins with the letter indicated");
            System.out.println("3. List users by creation date");
            System.out.println("4. Add auser");
            System.out.println("5. Exit");
            System.out.print("option: ");
            
            //Avoid line break with buffer (nextInt)
            try{
                option = Integer.parseInt(s.nextLine());
            }catch(NumberFormatException ex){
                System.out.println("Error " + ex.getMessage());
            }
            
            switch(option){
                case 1: 
                    database.listActiveUsers();
                    break;
                    
                case 2: 
                    String letter;
                    System.out.print("Letter: ");
                    letter = s.nextLine();
                    database.listCityStartBy(letter);
                    break;
                
                case 3: 
                    System.out.println("1. Descending order");
                    System.out.println("2. Ascending order");
                    System.out.print("Option: ");
                    option = Integer.parseInt(s.nextLine());
                    
                    switch(option){
                        case 1:
                            database.listUsersByDate(true);
                            break;
                        case 2:
                            database.listUsersByDate(false);
                            break;
                        default:
                            System.out.println("Invalid option");
                    }
                    break;
                
                case 4:
                    database.addUser();
                    break;
                
                case 5: 
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid option");
            }
            
        }while(!exit);
                 
    }
    
}
