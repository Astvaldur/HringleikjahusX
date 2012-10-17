package com.example.colosseum;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class User extends Activity {
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_view);
        
        // databasehandling 
	 }
	
	
	DatabaseHandler db = new DatabaseHandler(this);
	
	public void Login(View btnLogin){
		EditText strUser = (EditText) findViewById(R.id.txtUser);
		EditText strPassword = (EditText) findViewById(R.id.txtPassword);
	}
	
	public void Register(View btnRegister){
		EditText strUser = (EditText) findViewById(R.id.txtUser);
		EditText strPassword = (EditText) findViewById(R.id.txtPassword);
		
		String newUser = strUser.getText().toString();
		String newPassword = strPassword.getText().toString();
		
		db.addUser(new DbUser(newUser, newPassword));
		
	}
	
	}
