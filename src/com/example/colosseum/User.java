package com.example.colosseum;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class User extends Activity {
	
	// breytur úr activityinu
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
		
		// þegar smellt er á login takkann
		btnLogin.setOnClickListener(new View.OnClickListener(){
			public void onClick(View v){
				// check hvort buid ad setja e-d i textareitina tvo.
	    		if(strUser == null || strPassword == null)
	    			return;
	    		newUser = strUser.getText().toString();
	    		newPassword = strPassword.getText().toString();
	    		
	    		int usrId = db.checkUser(newUser);
	    		
	    		if(usrId != 0){
	    			// ath hvort passw. passar
	    			String passw=db.getPassw(usrId);
	    			if(passw.equals(newPassword)){
	    				// breyta sem inniheldur info um userid thess sem er loggadur inn
	    				Adallvalmynd.usrIdLogdIn = usrId;
	    				Toast.makeText(User.this, newUser + " is now logged in.", Toast.LENGTH_SHORT).show();
	    			}
	    			else{
	    				Toast.makeText(User.this, "Password entered is invalid", Toast.LENGTH_SHORT).show();
	    				return;
	    			}
	    		}
	    		
	    		
	    		
			}
    	});
        
		// þegar smellt er a register takka
        btnRegister.setOnClickListener(new View.OnClickListener(){
	    	public void onClick(View v){
	    		if(strUser == null || strPassword == null)
	    			return;
	    		newUser = strUser.getText().toString();
	    		newPassword = strPassword.getText().toString();
	    		
	    		int chkUsr = db.checkUser(newUser);
	    		if(chkUsr == 0){
	    			db.addUser(new DbUser(newUser, newPassword));
	    			Toast.makeText(User.this, newUser + " has successfully registered.", Toast.LENGTH_SHORT).show();
	    		}
	    		else{
	    			Toast.makeText(User.this, "Error: this username already in use.", Toast.LENGTH_SHORT).show();
	    		}
	    	}

        });
	}	
}
