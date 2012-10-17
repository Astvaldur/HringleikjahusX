package com.example.colosseum;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Leikur1 extends Activity{
   @Override
   public void onCreate(Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);
       this.setContentView(R.layout.leikur1_view);

       TextView txtProduct = (TextView) findViewById(R.id.Leiks_label);

       Intent i = getIntent();
       
       // getting attached intent data
       String product = i.getStringExtra("product");
       
       // displaying selected product name
       txtProduct.setText(product);

   }
}