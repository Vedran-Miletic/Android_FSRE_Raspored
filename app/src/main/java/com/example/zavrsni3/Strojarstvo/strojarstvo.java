package com.example.zavrsni3.Strojarstvo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.zavrsni3.MainActivity;
import com.example.zavrsni3.R;

public class strojarstvo extends AppCompatActivity {

    private Button strojarstvo2;
    private Button strojarstvo1;
    private Button strojarstvokirp3;
    private Button strojarstvomeh3;
    private Button strojarstvopi3;
    private Button strojarstvopi1;
    private Button strojarstvopi2;
    private Button strojarstvokirp1;
    private Button strojarstvokirp2;
    private Button strojarstvomeh1;
    private Button strojarstvomeh2;
    private ImageView pocetna;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_strojarstvo);


        pocetna=(ImageView)findViewById(R.id.imageView7);
        pocetna.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openPocetna();
            }
        });


        strojarstvo1= (Button) findViewById(R.id.getstroj1);
        strojarstvo1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openStrojarstvo1();
            }
        });

        strojarstvo2= (Button) findViewById(R.id.getstroj2); //id dugmeta za strojarstvo 2
        strojarstvo2.setOnClickListener(new View.OnClickListener() { //na klik odvedi me
            @Override
            public void onClick(View v) {
                openStrojarstvo2();
            }
        });

        strojarstvopi3= (Button) findViewById(R.id.PI3);
        strojarstvopi3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openStrojarstvoPI3();
            }
        });


        strojarstvokirp3= (Button) findViewById(R.id.KIRP3);
        strojarstvokirp3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openStrojarstvoKIRP3();
            }
        });

        strojarstvomeh3= (Button) findViewById(R.id.MEH3);
        strojarstvomeh3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openStrojarstvoMEH3();
            }
        });


        strojarstvopi1= (Button) findViewById(R.id.PI1);
        strojarstvopi1.setOnClickListener(new View.OnClickListener() { //na klik odvedi me
            @Override
            public void onClick(View v) {
                openStrojarstvoPI1();
            }
        });

        strojarstvopi2= (Button) findViewById(R.id.PI2);
        strojarstvopi2.setOnClickListener(new View.OnClickListener() { //na klik odvedi me
            @Override
            public void onClick(View v) {
                openStrojarstvoPI2();
            }
        });

        strojarstvomeh1= (Button) findViewById(R.id.MEH1);
        strojarstvomeh1.setOnClickListener(new View.OnClickListener() { //na klik odvedi me
            @Override
            public void onClick(View v) {
                openStrojarstvoMEH1();
            }
        });

        strojarstvomeh2= (Button) findViewById(R.id.MEH2);
        strojarstvomeh2.setOnClickListener(new View.OnClickListener() { //na klik odvedi me
            @Override
            public void onClick(View v) {
                openStrojarstvoMEH2();
            }
        });

        strojarstvokirp1= (Button) findViewById(R.id.KIRP1);
        strojarstvokirp1.setOnClickListener(new View.OnClickListener() { //na klik odvedi me
            @Override
            public void onClick(View v) {
                openStrojarstvoKIRP1();
            }
        });

        strojarstvokirp2= (Button) findViewById(R.id.KIRP2);
        strojarstvokirp2.setOnClickListener(new View.OnClickListener() { //na klik odvedi me
            @Override
            public void onClick(View v) {
                openStrojarstvoKIRP2();
            }
        });




    }

    public void openStrojarstvo2(){ //otvara strojarstvo1
        Intent intent= new Intent(this, strojarstvo2.class);
        startActivity(intent);
    }

    public void openStrojarstvo1(){ //otvara strojarstvo2
        Intent intent= new Intent(this, strojarstvo1.class);
        startActivity(intent);
    }

    public void openStrojarstvoKIRP1(){
        Intent intent= new Intent(this, strojarstvoKIRP1.class);
        startActivity(intent);
    }

    public void openStrojarstvoKIRP2(){
        Intent intent= new Intent(this, strojarstvoKIRP2.class);
        startActivity(intent);
    }

    public void openStrojarstvoKIRP3(){
        Intent intent= new Intent(this, strojarstvoKIRP3.class);
        startActivity(intent);
    }

    public void openStrojarstvoMEH1(){
        Intent intent= new Intent(this, strojarstvoMEH1.class);
        startActivity(intent);
    }

    public void openStrojarstvoMEH2(){
        Intent intent= new Intent(this, strojarstvoMEH2.class);
        startActivity(intent);
    }

    public void openStrojarstvoMEH3(){
        Intent intent= new Intent(this, strojarstvoMEH3.class);
        startActivity(intent);
    }

    public void openStrojarstvoPI1(){
        Intent intent= new Intent(this, strojarstvoPI1.class);
        startActivity(intent);
    }

    public void openStrojarstvoPI2(){
        Intent intent= new Intent(this, strojarstvoPI2.class);
        startActivity(intent);
    }

    public void openStrojarstvoPI3(){
        Intent intent= new Intent(this, strojarstvoPi3.class);
        startActivity(intent);
    }

    public void openPocetna(){
        Intent intent= new Intent(this, MainActivity.class);
        startActivity(intent);
    }

}
