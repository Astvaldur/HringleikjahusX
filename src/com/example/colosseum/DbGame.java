package com.example.colosseum;

public class DbGame {
 
    //private variables
    int _id;
    String _gamename;
    long _ohscore; //overall high score
 
    // Empty constructor
    public DbGame(){}
    
    // constructor
    public DbGame(int id, String gamename, long ohscore){
        this._id = id;
        this._gamename = gamename;
        this._ohscore = ohscore;    //breytti frá tutorial, tok fra _
    }
 
    // constructor
    public DbGame(String gamename, long ohscore){
        this._gamename = gamename;
        this._ohscore = ohscore;  // sama og i constructor ad ofan.
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
    public String getGamename(){
        return this._gamename;
    }
 
    // setting name
    public void setGamename(String gamename){
        this._gamename = gamename;
    }
 
    // getting password   --->meikar ekki mikinn sens ad thurfa
    public long getOHScore(){
        return this._ohscore;
    }
 
    // setting password
    public void setOHScore(long ohscore){
        this._ohscore = ohscore;
    }
    
}

