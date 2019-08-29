package database;

import user.User;

import java.util.Collections;
import java.util.ArrayList;
import java.time.OffsetDateTime;
        
import java.util.Scanner;

public abstract class DB {
    
    //It is a protected type to be visible from daughter classes
    protected ArrayList<User> users = new ArrayList<User>();
    
    abstract public void readDB();
    abstract public void writeDB();
    
    public void listActiveUsers(){
        for (User u : this.users){
            if(u.isActive())
               u.showData();
        }   
    }
    
    public void listCityStartBy(String letter){
        
        boolean existCity = false;
        letter = letter.toLowerCase();
        
        for(User u: this.users){
            if(u.getCity().toLowerCase().startsWith(letter)){
                System.out.println(u.getCity());
                existCity = true;
            }
                
        }
        
        //There are no cities that begin with that letter
        if(!existCity)
            System.out.println("there is no city by letter: " + letter);
        
    }
    
    public void listUsersByDate(boolean descendingOrder){
        ArrayList<User> usersCopy = new ArrayList<User>(this.users);
        Collections.sort(usersCopy);
        
        //Descending order
        if(descendingOrder)
            Collections.reverse(usersCopy);
        
        for (User u : usersCopy)
            u.showData();
    }
    
    public void addUser(){
        
        Scanner s = new Scanner(System.in);
        
        String name, surname, email, city;
        
        System.out.println("----- New User -----");
        
        System.out.print("Name: ");
        name = s.nextLine();
        System.out.print("Surname: ");
        surname = s.nextLine();
        System.out.print("Email: ");
        email = s.nextLine();
        System.out.print("City: ");
        city = s.nextLine();
        
        User u = new User(name, surname, true, email, city, OffsetDateTime.now());
        u.showData();
        this.users.add(u);
    }
    
}
