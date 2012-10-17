package com.example.colosseum;

import java.util.List;
 
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
 
//testing klasi
public class usedbclass extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);
 
        DatabaseHandler db = new DatabaseHandler(this);
 
        /**
         * CRUD Operations
         * */
        // Inserting Contacts

        Log.d("Insert: ", "Inserting ..");
        
        db.addUser(new DbUser("Ravi", "9100000000"));
        db.addUser(new DbUser("Srinivas", "9199999999"));
        db.addUser(new DbUser("Tommy", "9522222222"));
        db.addUser(new DbUser("Karthik", "9533333333"));
        db.addGame(new DbGame("Space Invader", 10000000));
        db.addGame(new DbGame("Tetris", 10000000));
        db.addScore(new DbScore("Ravi", "Space Invader", 10000000));
        db.addScore(new DbScore("Ravi","Tetris", 10000000));
        db.addScore(new DbScore("Tommy","Tetris", 10000000));
        db.addScore(new DbScore("Arnor","Mylla", 10000000));
 
        // Reading all contacts
        Log.d("Reading: ", "Reading all contacts..");
        List<DbUser> users = db.getAllUsers();  
        List<DbGame> games = db.getAllGames();
        List<DbScore> scores = db.getAllScores();
        
        

        Log.d("Name: ", "kominn");
        for (DbUser u : users) {
            String log = "Id: "+u.getID()+" ,Name: " + u.getUsername() + " ,Phone: " + u.getPassword();
                // Writing Contacts to log
            Log.d("Name: ", log);
        }
        Log.d("Game: ", "kominn");
        for (DbGame g : games) {
            String log2 = "Id: "+g.getID()+" ,Name: " + g.getGamename() + " ,Phone: " + g.getOHScore();
                // Writing Contacts to log    
            	Log.d("Game: ", log2);
        }
        
        Log.d("Score: ", "kominn");
        for (DbScore s : scores) {
            String log3 = "Id: "+s.getID()+" ,Name: " + s.getUsername() + " ,Game: " + s.getGamename() +
            		"  ,Score: " + s.getScore();
                // Writing Contacts to log    
            	Log.d("Score: ", log3);
        }
    }
}