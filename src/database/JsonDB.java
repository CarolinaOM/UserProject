package database;

import user.User;
import gsonfile.CustomDateSerializer;
import gsonfile.CustomDateDeserializer;

import java.util.ArrayList;
import java.lang.reflect.Type;
import java.time.OffsetDateTime;

//I/O library
import java.util.Scanner;
import java.io.FileReader;
import java.io.FileWriter;

//Gson library
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

//Exceptions library
import java.io.FileNotFoundException;
import java.io.IOException;


public class JsonDB extends DB {
    
    private String nameFile;
    
        @Override
    public void readDB(){
        
        Scanner s = new Scanner(System.in);
        System.out.print("Write database name: ");
        this.nameFile = s.nextLine();
        
        try{

            //Read file
            FileReader file = new FileReader(this.nameFile);
             
            //Convert file to Json Element
            JsonParser parser = new JsonParser();
            JsonElement data = parser.parse(file);
            
            GsonBuilder gsonBuilder = new GsonBuilder();
            gsonBuilder.registerTypeAdapter(OffsetDateTime.class, new CustomDateDeserializer());
        
            Gson gson = gsonBuilder.create();

            //Type for class configuration
            Type listType =  new TypeToken<ArrayList<User>>() {}.getType();
            //Extract and create each object from the json element
            this.users = gson.fromJson(data,listType);
            
        }catch(FileNotFoundException ex){
            System.out.println("Error " + ex.getMessage());
        }

    }
    
    
    @Override
    public void writeDB(){
   
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(OffsetDateTime.class, new CustomDateSerializer());
        
        Gson gson = gsonBuilder.setPrettyPrinting().create();
        
        //Convert user list into its equivalent Json representation
        String usersJson = gson.toJson(this.users);
        
        try{
            
            //Overwrite file
            FileWriter file = new FileWriter(this.nameFile);
            file.write(usersJson);
            file.close();
            
        }catch(IOException ex){
            System.out.println("Error " + ex.getMessage());
        }
        
    }
    
    @Override
    public void addUser(){
        super.addUser();
        writeDB();
    }
    
}
