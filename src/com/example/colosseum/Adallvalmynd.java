package com.example.colosseum;


//Fyrir Listview
import android.app.ListActivity;
import android.content.Intent;
//import android.media.AudioManager; // fyrir mute þegar það virkar
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

// Fyrir Menu, það má kannski sleppa activity
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;
 
public class Adallvalmynd extends ListActivity {
	//boolean mute_button=false;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // storing string resources into Array
        
        String[] Leikir = getResources().getStringArray(R.array.Leikir_val);
 
        // Binding resources Array to ListAdapter
        this.setListAdapter(new ArrayAdapter<String>(this, R.layout.lista_hlutur, R.id.l_hlutur, Leikir));
        ListView lv = getListView();
        
        // listening to single list item on click
        lv.setOnItemClickListener(new OnItemClickListener() 
        {
          public void onItemClick(AdapterView<?> parent, View view,int position, long id) 
          {
 
              // selected item
              String product = ((TextView) view).getText().toString();
 
              // Launching new Activity on selecting single List Item
              Intent i = new Intent(getApplicationContext(), Leikur1.class);
              // sending data to new activity
              i.putExtra("product", product);
              startActivity(i);
 
          }
        });
    }
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.layout.menu, menu);
        return true;
    }
 
    /**
     * Event Handling for Individual menu item selected
     * Identify single menu item by it's id
     * */
    /*
     * COmment fra Astvaldi til arnors
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
 
        switch (item.getItemId())
        {
        case R.id.menu_users:
        	 Intent use = new Intent(getApplicationContext(), User.class);
             // sending data to new activity
             startActivity(use);
             return true;
 
        case R.id.menu_save:
            Toast.makeText(Adallvalmynd.this, "Save is Selected", Toast.LENGTH_SHORT).show();
            return true;
 
        case R.id.menu_connect_other: 
        	Intent co = new Intent(getApplicationContext(), Leikur1.class);
        // sending data to new activity
        startActivity(co);
            return true;
 
        case R.id.menu_share:
            Toast.makeText(Adallvalmynd.this, "Share is Selected", Toast.LENGTH_SHORT).show();
            return true;

        case R.id.menu_mute:
        	Toast.makeText(Adallvalmynd.this, "Silent", Toast.LENGTH_SHORT).show();
            return true;
 
        case R.id.menu_preferences:
            Toast.makeText(Adallvalmynd.this, "Preferences is Selected", Toast.LENGTH_SHORT).show();
            return true;
 
        default:
            return super.onOptionsItemSelected(item);
        }
    }
}
    