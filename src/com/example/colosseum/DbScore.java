package com.example.colosseum;

public class DbScore {
 
    //private variables
    int _id;
    String _username;
    String _gamename; 
    long _score;
 
    // Empty constructor
    public DbScore(){}
    
    // constructor
    public DbScore(int id, String username, String gamename, long score){
        this._id = id;
        this._username = username;
        this._gamename = gamename;    //breytti frá tutorial, tok fra _
        this._score = score;
    }
 
    // constructor
    public DbScore(String username, String gamename, long score){
        this._username = username;
        this._gamename = gamename;// sama og i constructor ad ofan.
        this._score = score;
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
    public String getGamename(){
        return this._gamename;
    }
 
    // setting password
    public void setGamename(String gamename){
        this._gamename = gamename;
    }
    
    // setting password
    public long getScore(){
        return this._score;
    }
 
    // setting password
    public void setScore(long score){
        this._score = score;
    }
    
}

