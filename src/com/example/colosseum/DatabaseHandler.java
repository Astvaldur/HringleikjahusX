package com.example.colosseum;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

// klasi sem s�r um a� b�a til, lesa, uppf�ra og ey�a �r gagnagrunnunum.
public class DatabaseHandler extends SQLiteOpenHelper {
	
    // All Static variables
    // Database Version
    private static final int DATABASE_VERSION = 13;  //ekki 1 �me�an vi� vinnum
 
    // Database Name
    private static final String DATABASE_NAME = "UsersScoresAndGames";
 
    // Create table name
    private static final String TABLE_USERS = "users";
    private static final String TABLE_GAMES = "games";
    private static final String TABLE_SCORES = "scores";
 
    // Users Table Columns names
    private static final String KEY_ID = "id";
    private static final String KEY_USERNAME = "username";
    private static final String KEY_PASSWORD = "password";
 
    // Games Table Columns names
    private static final String KEY_GAMENAME = "gamename";
    private static final String KEY_OHSCORE = "ohscore";
    
    // Scores Table Columns names
    private static final String KEY_SCORE = "score";
    private static final String KEY_USERID = "userid";
    private static final String KEY_GAMEID = "gameid";
    
    
    // constructor 
    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
 
    // Creating All Three Tables
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_USERS_TABLE = "CREATE TABLE " + TABLE_USERS + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_USERNAME + " TEXT UNIQUE NOT NULL,"
                + KEY_PASSWORD + " TEXT" + ")";
        db.execSQL(CREATE_USERS_TABLE);
        
        String CREATE_GAMES_TABLE = "CREATE TABLE " + TABLE_GAMES + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_GAMENAME + " TEXT UNIQUE NOT NULL,"
                + KEY_OHSCORE + " INTEGER NOT NULL" + ")";
        db.execSQL(CREATE_GAMES_TABLE);
        
        // foreign keys?
        String CREATE_TABLE_SCORE = "CREATE TABLE " + TABLE_SCORES + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_USERID + " INTEGER NOT NULL,"
                + KEY_GAMEID + " INTEGER NOT NULL," + KEY_SCORE + " INTEGER NOT NULL" + ")";  
                db.execSQL(CREATE_TABLE_SCORE);
    }
 
    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USERS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_GAMES);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_SCORES);
 
        // Create tables again
        onCreate(db);
    }
    

    
    //
    //FYRIR USER DATABASE
    //
    
    // Adding new user
    public void addUser(DbUser user) {
    	SQLiteDatabase db = this.getWritableDatabase();
	  
	    ContentValues values = new ContentValues();
	    //values.putNull(KEY_ID);
	    values.put(KEY_USERNAME, user.getUsername()); 
	    values.put(KEY_PASSWORD, user.getPassword()); 
	 
	    // Inserting Row
	    db.insert(TABLE_USERS, null, values);
	    db.close(); // Closing database connection
    }
     
    // Getting single user
    public DbUser getUser(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        
        Cursor cursor = db.query(TABLE_USERS, new String[] { KEY_ID,
                KEY_USERNAME, KEY_PASSWORD }, KEY_ID + "=?",
                new String[] { String.valueOf(id) }, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();
     
        DbUser user = new DbUser(Integer.parseInt(cursor.getString(0)),
                cursor.getString(1), cursor.getString(2));
        // return user
        return user;
    }
     
    // Getting All Users
    public List<DbUser> getAllUsers() {
    	
	   List<DbUser> usersList = new ArrayList<DbUser>();
	    // Select All Query
	    String selectQuery = "SELECT  * FROM " + TABLE_USERS;
	 
	    SQLiteDatabase db = this.getWritableDatabase();
	    Cursor cursor = db.rawQuery(selectQuery, null);
	 
	    // looping through all rows and adding to list
	    if (cursor.moveToFirst()) {
	        do {
	            DbUser user = new DbUser();
	            user.setID(Integer.parseInt(cursor.getString(0)));
	            user.setUsername(cursor.getString(1));
	            user.setPassword(cursor.getString(2));
	            // Adding user to list
	            usersList.add(user);
	        } while (cursor.moveToNext());
	    }
	 
	    // return user list
	    return usersList;
    }
     
    // Getting users Count
    public int getUsersCount() {
	    String countQuery = "SELECT  * FROM " + TABLE_USERS;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();
 
        // return count
        return cursor.getCount();
    }
    // Updating user 
    public int updateUser(DbUser user) {
        SQLiteDatabase db = this.getWritableDatabase();
        
        ContentValues values = new ContentValues();
        values.put(KEY_USERNAME, user.getUsername());
        values.put(KEY_PASSWORD, user.getPassword());
     
        // updating row
        return db.update(TABLE_USERS, values, KEY_ID + " = ?",
                new String[] { String.valueOf(user.getID()) });
    }
     
    // Deleting single user
    public void deleteUser(DbUser user) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_USERS, KEY_ID + " = ?",
                new String[] { String.valueOf(user.getID()) });
        db.close();
    }
    
    // check if user med username er loggadur inn
    public int checkUser(String username){
        SQLiteDatabase db = this.getReadableDatabase();
        
        Cursor cursor = db.query(TABLE_USERS, new String[] { KEY_ID,
                KEY_USERNAME, KEY_PASSWORD }, KEY_USERNAME + "=?",
                new String[] { username }, null, null, null, null);
        if (cursor != null && cursor.moveToFirst()){
            cursor.moveToFirst();
        	int a=Integer.parseInt(cursor.getString(0));
        	cursor.close();
        	return a;
        }
    	else{
    		return 0;
    	}
	}
        
    
    // na i password fyrir tiltekinn user
    public String getPassw(int userid){
        SQLiteDatabase db = this.getReadableDatabase();
        
        Cursor cursor = db.query(TABLE_USERS, new String[] { KEY_ID,
                KEY_USERNAME, KEY_PASSWORD }, KEY_ID + "=?",
                new String[] { String.valueOf(userid) }, null, null, null, null);
        if (cursor != null){
            cursor.moveToFirst();
        	String a=cursor.getString(2);
        	cursor.close();
        	return a;
        }
    	else
    		return null;
    }
    
    
    //
    //FYRIR GAME DATABASE
    //
    
    // Adding new game
    public void addGame(DbGame game) {
    	SQLiteDatabase db = this.getWritableDatabase();
	  
	    ContentValues values = new ContentValues();
	    //values.putNull(KEY_ID);
	    values.put(KEY_GAMENAME, game.getGamename());
	    values.put(KEY_OHSCORE, game.getOHScore()); 
	 
	    // Inserting Row
	    db.insert(TABLE_GAMES, null, values);
	    db.close(); // Closing database connection
    }
     
    // Getting single game
    public DbGame getGame(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        
        Cursor cursor = db.query(TABLE_GAMES, new String[] { KEY_ID,
                KEY_GAMENAME, KEY_OHSCORE }, KEY_ID + "=?",
                new String[] { String.valueOf(id) }, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();
     
        DbGame game = new DbGame(Integer.parseInt(cursor.getString(0)),
                cursor.getString(1), Long.parseLong(cursor.getString(2)));
        // return game
        return game;
    }
     
    // Getting All Games
    public List<DbGame> getAllGames() {
    	
	   List<DbGame> gamesList = new ArrayList<DbGame>();
	    // Select All Query
	    String selectQuery = "SELECT  * FROM " + TABLE_GAMES;
	 
	    SQLiteDatabase db = this.getWritableDatabase();
	    Cursor cursor = db.rawQuery(selectQuery, null);
	 
	    // looping through all rows and adding to list
	    if (cursor.moveToFirst()) {
	        do {
	            DbGame game = new DbGame();
	            game.setID(Integer.parseInt(cursor.getString(0)));
	            game.setGamename(cursor.getString(1));
	            game.setOHScore(Long.parseLong(cursor.getString(2)));
	            // Adding game to list
	            gamesList.add(game);
	        } while (cursor.moveToNext());
	    }
	 
	    // return game list
	    return gamesList;
    }
     
    // Getting games Count
    public int getGamesCount() {
	    String countQuery = "SELECT  * FROM " + TABLE_GAMES;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();
 
        // return count
        return cursor.getCount();
    }
    // Updating game 
    public int updateGame(DbGame game) {
        SQLiteDatabase db = this.getWritableDatabase();
        
        ContentValues values = new ContentValues();
        values.put(KEY_USERNAME, game.getGamename());
        values.put(KEY_OHSCORE, game.getOHScore());
     
        // updating row
        return db.update(TABLE_GAMES, values, KEY_ID + " = ?",
                new String[] { String.valueOf(game.getID()) });
    }
     
    // Deleting single game
    public void deleteGame(DbGame game) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_GAMES, KEY_ID + " = ?",
                new String[] { String.valueOf(game.getID()) });
        db.close();
    }
    
    
    //
    //FYRIR SCORE DATABASE
    //
    
    // Adding new score
    public void addScore(DbScore score) {
    	SQLiteDatabase db = this.getWritableDatabase();
	  
	    ContentValues values = new ContentValues();
	    values.put(KEY_USERID, score.getUserid());
	    values.put(KEY_GAMEID, score.getGameid ()); 
	    values.put(KEY_SCORE, score.getScore()); 
	 
	    // Inserting Row
	    db.insert(TABLE_SCORES, null, values);
	    db.close(); // Closing database connection
    }
     
    // Getting single score
    public DbScore getScore(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        
        Cursor cursor = db.query(TABLE_SCORES, new String[] { KEY_ID, KEY_USERID,
                KEY_GAMEID, KEY_SCORE}, KEY_ID + "=?",
                new String[] { String.valueOf(id) }, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();
     
        DbScore score = new DbScore(Integer.parseInt(cursor.getString(0)),
        		Integer.parseInt(cursor.getString(1)), Integer.parseInt(cursor.getString(2))
        		, Long.parseLong(cursor.getString(3)));
        // return score
        return score;
    }
     
    // Getting All Scores
    public List<DbScore> getAllScores() {
    	
	   List<DbScore> scoresList = new ArrayList<DbScore>();
	    // Select All Query
	    String selectQuery = "SELECT  * FROM " + TABLE_SCORES;
	 
	    SQLiteDatabase db = this.getWritableDatabase();
	    Cursor cursor = db.rawQuery(selectQuery, null);
	 
	    // looping through all rows and adding to list
	    if (cursor.moveToFirst()) {
	        do {
	            DbScore score = new DbScore();
	            score.setID(Integer.parseInt(cursor.getString(0)));
	            score.setUserid(Integer.parseInt(cursor.getString(1)));
	            score.setGameid(Integer.parseInt(cursor.getString(2)));
	            score.setScore(Long.parseLong(cursor.getString(3)));
	            // Adding score to list
	            scoresList.add(score);
	        } while (cursor.moveToNext());
	    }
	 
	    // return score list
	    return scoresList;
    }
     
    // Getting score Count
    public int getScoresCount() {
	    String countQuery = "SELECT  * FROM " + TABLE_SCORES;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();
 
        // return count
        return cursor.getCount();
    }
    // Updating score
    public int updateScore(DbScore score) {
        SQLiteDatabase db = this.getWritableDatabase();
        
        ContentValues values = new ContentValues();
        values.put(KEY_USERID, score.getUserid());
        values.put(KEY_GAMEID, score.getGameid());
        values.put(KEY_SCORE, score.getScore());
     
        // updating row
        return db.update(TABLE_SCORES, values, KEY_ID + " = ?",
                new String[] { String.valueOf(score.getID()) });
    }
     
    // Deleting single score
    public void deleteScore(DbScore score) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_SCORES, KEY_ID + " = ?",
                new String[] { String.valueOf(score.getID()) });
        db.close();
    }
}
