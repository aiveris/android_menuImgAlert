package com.example.menuimgalert;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.menu.MenuBuilder;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ImageView imgView;
    Bitmap imgOn, imgOff;
    boolean boolean_On;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imgView = findViewById(R.id.imageView2);

        imgOn = BitmapFactory.decodeResource(getResources(), R.drawable.on);
        imgOff = BitmapFactory.decodeResource(getResources(), R.drawable.off);

    }
        public void img_Click (View v){
            if (boolean_On) {
                imgView.setImageBitmap(imgOff);
                boolean_On = false;
            } else {
                imgView.setImageBitmap(imgOn);
                boolean_On = true;
            }
        }

        public void gotoNext (View v){
            Intent i = new Intent(this, Main2Activity.class);
            startActivity(i);
        }

        @SuppressLint("RestrictedApi")
        @Override
        public boolean onCreateOptionsMenu (Menu menu){
            Log.e("Option Menu()", "111111111111 ");
            MenuInflater inflater = getMenuInflater();
            inflater.inflate(R.menu.menu, menu);

            if (menu instanceof MenuBuilder) {
                MenuBuilder m = (MenuBuilder) menu;
                m.setOptionalIconsVisible(true);
            }

            return true;
        }

        @Override
        public boolean onOptionsItemSelected (MenuItem item){
            switch (item.getItemId()) {
                case R.id.myAccount:
                    Toast.makeText(this, "My Account", Toast.LENGTH_SHORT).show();
                    return true;

                case R.id.logOut:
                    Toast.makeText(this, "Log out!!!", Toast.LENGTH_SHORT).show();
                    return true;

                case R.id.contactUs:
                    Toast.makeText(this, "ContactUs", Toast.LENGTH_SHORT).show();
                    return true;

                case R.id.search:
                    Toast.makeText(this, "Searching... ", Toast.LENGTH_SHORT).show();
                    return true;


                default:
                    return super.onOptionsItemSelected(item);
            }
        }



}