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
        this._ohscore = ohscore;    
    }
 
    // constructor
    public DbGame(String gamename, long ohscore){
        this._gamename = gamename;
        this._ohscore = ohscore;  
    }
    // getting ID
    public int getID(){
        return this._id;
    }
 
    // setting id
    public void setID(int id){
        this._id = id;
    }
 
    // getting gamename
    public String getGamename(){
        return this._gamename;
    }
 
    // setting gamename
    public void setGamename(String gamename){
        this._gamename = gamename;
    }
 
    // getting overall highscore
    public long getOHScore(){
        return this._ohscore;
    }
 
    // setting overall highscore
    public void setOHScore(long ohscore){
        this._ohscore = ohscore;
    }
    
}

