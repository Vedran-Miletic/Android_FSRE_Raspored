package com.example.zavrsni3.Racunarstvo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.zavrsni3.MainActivity;
import com.example.zavrsni3.R;

public class racunarstvo extends AppCompatActivity {

    private Button racunarstvo1;
    private Button racunarstvo2;
    private Button racunarstvo3;
    private Button racunarstvoPIIS1;
    private Button racunarstvoPIIS2;
    private Button racunarstvoRSIM1;
    private Button racunarstvoRSIM2;
    private ImageView pocetna;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_racunarstvo);

        racunarstvo1= (Button) findViewById(R.id.RAC1);
        racunarstvo1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openRacunarstvo1();
            }
        });

        racunarstvo2= (Button) findViewById(R.id.RAC2);
        racunarstvo2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openRacunarstvo2();
            }
        });

        racunarstvo3= (Button) findViewById(R.id.RAC3);
        racunarstvo3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openRacunarstvo3();
            }
        });

        pocetna=(ImageView)findViewById(R.id.imageView7);
        pocetna.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openPocetna();
            }
        });

        racunarstvoPIIS1= (Button) findViewById(R.id.PIIS1);
        racunarstvoPIIS1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openRacunarstvoPIIS1();
            }
        });

        racunarstvoPIIS2= (Button) findViewById(R.id.PISS2);
        racunarstvoPIIS2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openRacunarstvoPIIS2();
            }
        });

        racunarstvoRSIM1= (Button) findViewById(R.id.RSIM1);
        racunarstvoRSIM1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openRacunarstvoRSIM1();
            }
        });

        racunarstvoRSIM2= (Button) findViewById(R.id.RSIM2);
        racunarstvoRSIM2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openRacunarstvoRSIM2();
            }
        });



    }

    public void openPocetna(){
        Intent intent= new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void openRacunarstvo1(){
        Intent intent= new Intent(this, racunarstvo1.class);
        startActivity(intent);
    }

    public void openRacunarstvo2(){
        Intent intent= new Intent(this, racunarstvo2.class);
        startActivity(intent);
    }

    public void openRacunarstvo3(){
        Intent intent= new Intent(this, racunarstvo3.class);
        startActivity(intent);
    }

    public void openRacunarstvoPIIS1(){
        Intent intent= new Intent(this, racunarstvoPIIS1.class);
        startActivity(intent);
    }

    public void openRacunarstvoPIIS2(){
        Intent intent= new Intent(this, racunarstvoPIIS2.class);
        startActivity(intent);
    }

    public void openRacunarstvoRSIM1    (){
        Intent intent= new Intent(this, racunarstvoRSIM1.class);
        startActivity(intent);
    }

    public void openRacunarstvoRSIM2    (){
        Intent intent= new Intent(this, racunarstvoRSIM2.class);
        startActivity(intent);
    }
}
