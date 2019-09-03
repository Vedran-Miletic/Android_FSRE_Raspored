package com.example.zavrsni3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.List;

public class MainActivity extends AppCompatActivity {
        private Button strojarstvo;
        private Button racunarstvo;
        private Button elektrotehnika;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        strojarstvo=  (Button) findViewById(R.id.strojarstvo);
        racunarstvo= (Button)  findViewById(R.id.racunarstvo);
        elektrotehnika= (Button)  findViewById(R.id.elektrotehnika);

        strojarstvo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openStrojarstvo();
            }
        });
        racunarstvo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openRacunarstvo();
            }
        });
        elektrotehnika.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openElektrotehnika();
            }
        });



    }



    public void openStrojarstvo(){
        Intent intent= new Intent(this, com.example.zavrsni3.Strojarstvo.strojarstvo.class);
        startActivity(intent);
    }

    public void openRacunarstvo(){
        Intent intent= new Intent(this, com.example.zavrsni3.Racunarstvo.racunarstvo.class);
        startActivity(intent);
    }

    public void openElektrotehnika(){
        Intent intent= new Intent(this, com.example.zavrsni3.Elektrotehnika.elektrotehnika.class);
        startActivity(intent);
    }
}
