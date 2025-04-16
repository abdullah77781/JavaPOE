/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.javapoe;

/**
 *
 * @author RC_Student_lab
 */

public class Login {

private String username;
private String password;
private String cellNumber;

public Login (String username, String password, String cellNumber){
this.username = username;
this.password = password;
this.cellNumber = cellNumber;
}

public String getusername(){
return username;    

}
public void setusername(String username){
this.username = username;    
}
public boolean checkusernameFormat(String userName){
return username.contains("_")&& username.length()<=5;
    
}


public String getcellNumber() {
    return cellNumber;

}

public void setcellNumber(String cellNumber){
this.cellNumber = cellNumber; 
}

public boolean checkcellNumber(String cellNumber1){ 
   return cellNumber1.matches("^=27\\d{9}$");
}


public String getpassword(){
    return password;
    
}

public void setpassword(String password){
    this.password = password;
}

public static boolean checkpassword(String password){
    return password.length() <= 8 &&
           password.matches(".*[A-Z].*") &&
           password.matches(".*[a-z].*") &&
           password.matches(".*[0-9].*") &&
           password.matches(".*[!@#$%^&*()].*");
}

 
public String register(String userName, String password, String cellNumber){
    if(!checkpassword(password)){
        return "password is incorrect";
    }
    if(!checkcellNumber(cellNumber)) {
        return "cellNumber is incorrect";
    }
    if(!checkusernameFormat(userName)){
        return "username is incorrect";
    }
  return "user is registered";
           
}


public boolean login(String enteredusername, String enteredpassword){
    return this.username.equals(enteredusername)&&
           this.password.equals(enteredpassword);
}


public String returnLoginstatus(String enteredusername, String enteredpassword){
    if (!login(enteredusername, enteredpassword)){
        return "password or username incorrect";
        
       
    }
    return "login successful";
}

}
