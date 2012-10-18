package com.example.colosseum;

import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class User extends Activity {
	
	Button btnLogin;
	Button btnRegister;
	EditText strUser;
	EditText strPassword;
	String newUser;
	String newPassword;
	
	public int usrIdLogdIn;
	
	
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_view);
        
        
        // databasehandling 
        final DatabaseHandler db = new DatabaseHandler(this);
        
        //data �r glugga
        btnLogin = (Button) findViewById(R.id.btnLogin);
        btnRegister = (Button) findViewById(R.id.btnRegister);
		strUser = (EditText) findViewById(R.id.txtUser);
		strPassword = (EditText) findViewById(R.id.txtPassword);
		
		// chekca hvort user er til
		// ef til checka hvort user matchar password
		btnLogin.setOnClickListener(new View.OnClickListener(){
			public void onClick(View v){
	    		if(strUser == null || strPassword == null)
	    			return;
	    		newUser = strUser.getText().toString();
	    		newPassword = strPassword.getText().toString();
	    		
	    		int usrId = db.checkUser(newUser);
	    		
	    		if(usrId != 0){
	    			String passw=db.getPassw(usrId);
	    			Log.d("check1", newPassword);
	    			Log.d("check2", passw);
	    			if(passw.equals(newPassword)){
	    				usrIdLogdIn = usrId;
	    				Toast.makeText(User.this, newUser + "is now logged in.", Toast.LENGTH_SHORT).show();
	    				//Log.d("Loggadur inn:", newUser);
	    			}
	    			else{
	    				//s�mulei�is splash screen og stroka �t innskr�� � glugga
	    				Toast.makeText(User.this, "Password entered is invalid", Toast.LENGTH_SHORT).show();
	    				//Log.d("Password: ", "Invalid");
	    				return;
	    			}
	    		}
	    		
	    		
	    		
			}
    	});
        
        btnRegister.setOnClickListener(new View.OnClickListener(){
	    	public void onClick(View v){
	    		if(strUser == null || strPassword == null)
	    			return;
	    		//Log.d("Register: ", "kominn inn i register");
	    		newUser = strUser.getText().toString();
	    		newPassword = strPassword.getText().toString();
	    		
	    		int chkUsr = db.checkUser(newUser);
	    		if(chkUsr == 0){
	    			db.addUser(new DbUser(newUser, newPassword));
	    			//Log.d("Logd in: ", newUser);
	    			Toast.makeText(User.this, newUser + "has successfully registered.", Toast.LENGTH_SHORT).show();
	    		}
	    		else{
	    			//splash screen me� �essum error!!
	    			//Log.d("error", "user exists");
	    			Toast.makeText(User.this, "Error: this username already in use.", Toast.LENGTH_SHORT).show();
	    		}
	    		
	    		
	    		//aukad�t me�an veri� er a� vinna � db
	    		// sko�a users � db
//	    		List<DbUser> users = db.getAllUsers();
	    		
//	    		Log.d("Name: ", "kominn");
//	    		for (DbUser u : users) {
//	    			String log = "Id: "+u.getID()+" ,Name: " + u.getUsername() + " ,Phone: " + u.getPassword();
//	                // Writing Contacts to log
//	    			Log.d("Name: ", log);
//	    		}
	    	}

        });
	}	
}
