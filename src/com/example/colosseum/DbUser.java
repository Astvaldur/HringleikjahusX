package com.example.colosseum;

public class DbUser {
 
    //private variables
    int _id;
    String _username;
    String _password;
 
    // Empty constructor
    public DbUser(){
 
    }
    // constructor
    public DbUser(int id, String username, String password){
        this._id = id;
        this._username = username;
        this._password = password;    //breytti fr� tutorial, tok fra _
    }
 
    // constructor
    public DbUser(String username, String password){
        this._username = username;
        this._password = password;  // sama og i constructor ad ofan.
    }
    // getting ID
    public int getID(){
        return this._id;
    }
 
    // setting id
    public void setID(int id){
        this._id = id;
    }
 
    // getting name
    public String getUsername(){
        return this._username;
    }
 
    // setting name
    public void setUsername(String username){
        this._username = username;
    }
 
    // getting password   --->meikar ekki mikinn sens ad thurfa
    public String getPassword(){
        return this._password;
    }
 
    // setting password
    public void setPassword(String password){
        this._password = password;
    }
    
}
