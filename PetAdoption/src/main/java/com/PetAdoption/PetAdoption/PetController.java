package com.PetAdoption.PetAdoption;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

@Controller
public class PetController {
String jdbcurl="jdbc:mysql://localhost:3306/pet";
    @GetMapping("/login")
    public String login(){
        return "login";
    }
    @GetMapping("/signup")
    public String signup(){
        return "signup";
    }
   @GetMapping("/dashboard")
    public String dashboard(){
        return "dashboard";
   }
    @GetMapping("/pet")
    public String Pets(){
        return "pet";
    }
   @PostMapping("/jay")
        public String dash(@RequestParam("username") String name,@RequestParam("password") String pass){
           return "dashboard";
   }

   @GetMapping("/Adopt")
   public String adopt(){
        return "Adopt";
   }@GetMapping("/log")
    public String log(){
        return "log";
    }

@PostMapping("/signup")
    public String SIGNUP(@RequestParam("username") String username,@RequestParam("email") String userId,@RequestParam("password") String password, @RequestParam("confirm-password") String address){
        System.out.println("Inside signup method");
    System.out.println("The attributes are "+ username+" "+userId+" "+password+" "+address);
    Connection connection =null;
    try{

        connection = DriverManager.getConnection(jdbcurl,"root","admin");
        String sql= "insert into users values(?,?,?,?)";
        PreparedStatement pstatement = connection.prepareStatement(sql);
        pstatement.setString(1,username);
        pstatement.setString(2,userId);
        pstatement.setString(3,password);
        pstatement.setString(4,address);
        pstatement.execute();
        System.out.println("Database updated successfully");
        connection.close();
    }
    catch(Exception e){
        System.out.println("The exception occured is "+e);
    }
    return "login";
}
}
