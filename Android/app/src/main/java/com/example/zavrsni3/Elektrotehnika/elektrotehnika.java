package com.example.zavrsni3.Elektrotehnika;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.zavrsni3.R;
import com.example.zavrsni3.Racunarstvo.racunarstvo1;

public class elektrotehnika extends AppCompatActivity {

    private Button elektrotehnika1;
    private Button elektrotehnika2;
    private Button elektrotehnika3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_elektrotehnika);


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
}
