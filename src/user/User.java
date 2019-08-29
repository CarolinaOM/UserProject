package user;

import java.time.OffsetDateTime;

public class User implements Comparable<User>{
    
    private String name;
    private String surname;
    private boolean active;
    private String email;
    private String city;
    private OffsetDateTime creationDate;
     
    
    public User (String name, String surname, boolean active, String email, String city, OffsetDateTime creationDate){

        this.name = name;
        this.surname = surname;
        this.active = active;
        this.email = email;
        this.city = city;
        this.creationDate = creationDate;
        
    }   
    
    @Override
    public int compareTo(User u) {
        if (this.creationDate == null || u.creationDate == null)
            return 0;
        return this.creationDate.compareTo(u.creationDate);
    }
     
    public boolean isActive(){
        return this.active;
    }
     
    public void showData(){
        System.out.println("name: " +  this.name);
        System.out.println("surname: " +  this.surname);
        System.out.println("email: " +  this.email);
        System.out.println("city: " +   this.city);
        System.out.println("creationDate: " +  this.creationDate);
        System.out.println();
    }
       
    public String getCity(){
        return this.city;
    }
    
}
