package com.example.zavrsni3.Strojarstvo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.zavrsni3.Api;
import com.example.zavrsni3.MainActivity;
import com.example.zavrsni3.R;
import com.example.zavrsni3.Termini;

import java.text.DateFormat;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class strojarstvoPI2 extends AppCompatActivity {

    private ImageView pocetna;
    private static final String[] EMPTY_STRING_ARRAY = new String[0];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_strojarstvo_pi2);

        final ListView listView=(ListView) findViewById(R.id.strojP2ispis);

        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(Api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Api api=retrofit.create(Api.class);

        pocetna=(ImageView)findViewById(R.id.imageView7);
        pocetna.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openPocetna();
            }
        });

        Call<List<Termini>> call= api.getStr5PI();

        call.enqueue(new Callback<List<Termini>>() {
            @Override
            public void onResponse(Call<List<Termini>> call, Response<List<Termini>> response) {
                List<Termini> termins=response.body();

                String[] terminNaziv =new String[termins.size()];

                Date today = new Date();
                String FORMAT_DATETIME = "yyyy-MM-dd'T'HH:mm:ss";
                SimpleDateFormat sdf = new SimpleDateFormat(FORMAT_DATETIME);
                sdf.setTimeZone(TimeZone.getTimeZone("GMT+2"));
                Calendar cal2 = Calendar.getInstance();
                cal2.setTime(today);

                String mjesec2= String.valueOf(cal2.get(Calendar.MONTH)+1);
                String dan2= String.valueOf(cal2.get(Calendar.DAY_OF_MONTH));
                String Datum=dan2+"."+mjesec2;

                DateFormat f = new SimpleDateFormat("dd.MM");
                Date d1 = f.parse(Datum, new ParsePosition(0));

                for(int i=0;i<termins.size();i++){
                    String dan3=termins.get(i).getDatum();

                    Date d2 = f.parse(dan3, new ParsePosition(0));

                    if((d1.compareTo(d2))<=0) {
                        terminNaziv[i] = (termins.get(i).getDatum() + " " + termins.get(i).getNaslov() + " " + termins.get(i).getPocetak() + ":" + termins.get(i).getKraj());
                    }

                    else{
                        terminNaziv[i]="0";
                    }
                }
                List<String> list = new ArrayList<>();
                Collections.addAll(list, terminNaziv);
                list.removeAll(Arrays.asList("0"));
                terminNaziv = list.toArray(EMPTY_STRING_ARRAY);

                listView.setAdapter(
                        new ArrayAdapter<String>(
                                getApplicationContext(),
                                R.layout.layout22,
                                terminNaziv

                        )

                );

            }

            @Override
            public void onFailure(Call<List<Termini>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Trenutno nedostupno", Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void openPocetna(){
        Intent intent= new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
