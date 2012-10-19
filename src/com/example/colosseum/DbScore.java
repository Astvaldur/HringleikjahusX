package com.example.colosseum;

public class DbScore {
 
    //private variables
    int _id;
    int _userid;
    int _gameid; 
    long _score;
 
    // Empty constructor
    public DbScore(){}
    
    // constructor
    public DbScore(int id, int userid, int gameid, long score){
        this._id = id;
        this._userid = userid;
        this._gameid = gameid;
        this._score = score;
    }
 
    // constructor
    public DbScore(int userid, int gameid, long score){
        this._userid = userid;
        this._gameid = gameid;
        this._score = score;
    }
    // getting id
    public int getID(){
        return this._id;
    }
 
    // setting id
    public void setID(int id){
        this._id = id;
    }
 
    // getting userid
    public int getUserid(){
        return this._userid;
    }
 
    // setting userid
    public void setUserid(int userid){
        this._userid = userid;
    }
 
    // getting gameid 
    public int getGameid(){
        return this._gameid;
    }
 
    // setting gameid
    public void setGameid(int gameid){
        this._gameid = gameid;
    }
    
    // setting score
    public long getScore(){
        return this._score;
    }
 
    // setting score 
    public void setScore(long score){
        this._score = score;
    }
    
}

