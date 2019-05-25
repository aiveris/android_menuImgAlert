package com.example.menuimgalert;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    Button btn1,btn2;
    String[] games ={"Tank", "Snake", "Pacman", "Contra", "Mario"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        btn1 = findViewById(R.id.button1);
        btn2 = findViewById(R.id.button2);
    }

    public void Ok_Click(View v){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Are You Ready ?");
        builder.setCancelable(true);

        builder.setPositiveButton(
                "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Log.e("FROM ALERT", "You clicked OK");
                        dialog.cancel();
                    }
                });

        AlertDialog myAlert = builder.create();
        myAlert.show();
    }

    public void AgreeCancel_Click(View v){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Do you Agree to the Rules.");
        builder.setCancelable(true);

        builder.setPositiveButton(
                "AGREE",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Log.e("FROM ALERT", "You pressed AGREED");
                        dialog.cancel();
                    }
                });

        builder.setNegativeButton(
                "CANCEL",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Log.e("FROM ALERT", "You pressed CANCEL");
                        dialog.cancel();
                    }
                });

        AlertDialog myAlert = builder.create();
        myAlert.show();
    }

    public void AlertList(View v){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Choose a Game");
        builder.setIcon(R.mipmap.pacman);

        builder.setItems(games, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int index) {
                switch (index) {
                    case 0: commonMethod(index); break;
                    case 1: commonMethod(index); break;
                    case 2: commonMethod(index); break;
                    case 3: commonMethod(index); break;
                    case 4: commonMethod(index); break;

                    default: break;
                }
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    private void commonMethod(int index) {
        Toast.makeText(this, "You Selected: " + games[index], Toast.LENGTH_SHORT).show();
    }
}