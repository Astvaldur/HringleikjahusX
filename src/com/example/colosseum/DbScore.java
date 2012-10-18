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
        this._gameid = gameid;    //breytti frá tutorial, tok fra _
        this._score = score;
    }
 
    // constructor
    public DbScore(int userid, int gameid, long score){
        this._userid = userid;
        this._gameid = gameid;// sama og i constructor ad ofan.
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
    public int getUserid(){
        return this._userid;
    }
 
    // setting name
    public void setUserid(int userid){
        this._userid = userid;
    }
 
    // getting password   --->meikar ekki mikinn sens ad thurfa
    public int getGameid(){
        return this._gameid;
    }
 
    // setting password
    public void setGameid(int gameid){
        this._gameid = gameid;
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

