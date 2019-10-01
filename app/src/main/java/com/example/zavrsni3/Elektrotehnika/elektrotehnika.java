package com.example.zavrsni3.Elektrotehnika;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.zavrsni3.MainActivity;
import com.example.zavrsni3.R;
import com.example.zavrsni3.Racunarstvo.racunarstvo1;

public class elektrotehnika extends AppCompatActivity {

    private Button elektrotehnika1;
    private Button elektrotehnika2;
    private Button elektrotehnika3;
    private ImageView pocetna;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_elektrotehnika);


        pocetna=(ImageView)findViewById(R.id.imageView7);
        pocetna.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openPocetna();
            }
        });

        elektrotehnika1= (Button) findViewById(R.id.ELE1);
        elektrotehnika1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openElektrotehnika1();
            }
        });

        elektrotehnika2= (Button) findViewById(R.id.ELE2);
        elektrotehnika2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openElektrotehnika2();
            }
        });

        elektrotehnika3= (Button) findViewById(R.id.ELE3);
        elektrotehnika3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openElektrotehnika3();
            }
        });


        elektrotehnika1= (Button) findViewById(R.id.EE1);
        elektrotehnika1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openElektrotehnika4EE();
            }
        });


        elektrotehnika1= (Button) findViewById(R.id.SUA1);
        elektrotehnika1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openElektrotehnika4SUA();
            }
        });
    }

    public void openPocetna(){
        Intent intent= new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void openElektrotehnika1(){
        Intent intent= new Intent(this, elektrotehnika1.class);
        startActivity(intent);
    }

    public void openElektrotehnika2(){
        Intent intent= new Intent(this, elektrotehnika2.class);
        startActivity(intent);
    }

    public void openElektrotehnika3(){
        Intent intent= new Intent(this, elektrotehnika3.class);
        startActivity(intent);
    }

    public void openElektrotehnika4EE(){
        Intent intent= new Intent(this, elektrotehnika_EE1.class);
        startActivity(intent);
    }

    public void openElektrotehnika4SUA(){
        Intent intent= new Intent(this, elektrotehnika_SUA1.class);
        startActivity(intent);
    }
}
