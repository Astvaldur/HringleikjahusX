package com.example.colosseum;

import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class User extends Activity {
	
	Button btnLogin;
	Button btnRegister;
	EditText strUser;
	EditText strPassword;
	String newUser;
	String newPassword;
	
	
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_view);
        
        
        // databasehandling 
        final DatabaseHandler db = new DatabaseHandler(this);
        
        //data úr glugga
        btnLogin = (Button) findViewById(R.id.btnLogin);
        btnRegister = (Button) findViewById(R.id.btnRegister);
		strUser = (EditText) findViewById(R.id.txtUser);
		strPassword = (EditText) findViewById(R.id.txtPassword);
		
		
		btnLogin.setOnClickListener(new View.OnClickListener(){
			public void onClick(View v){
	        	int a = 1;
			}
    	});
        
        
        btnRegister.setOnClickListener(new View.OnClickListener(){
	    	public void onClick(View v){
	    		Log.d("Register: ", "kominn inn i register");
	    		newUser = strUser.getText().toString();
	    		newPassword = strPassword.getText().toString();
	    		Log.d("newUser", newUser);
	    		Log.d("newPassword", newPassword);
	    		db.addUser(new DbUser(newUser, newPassword));
	    		Log.d("newUser", newUser);
	    		Log.d("newPassword", newPassword);
	    		//aukadót meðan verið er að vinna í db
	    		List<DbUser> users = db.getAllUsers();
	    		
	    		Log.d("Name: ", "kominn");
	    		for (DbUser u : users) {
	    			String log = "Id: "+u.getID()+" ,Name: " + u.getUsername() + " ,Phone: " + u.getPassword();
	                // Writing Contacts to log
	    			Log.d("Name: ", log);
	    		}
	    	}

        });
	}	
}
