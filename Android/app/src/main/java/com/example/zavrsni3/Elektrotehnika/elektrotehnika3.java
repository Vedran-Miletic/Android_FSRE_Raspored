package com.example.zavrsni3.Elektrotehnika;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.zavrsni3.Api;
import com.example.zavrsni3.R;
import com.example.zavrsni3.Termini;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class elektrotehnika3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_elektrotehnika3);

        final ListView listView=(ListView) findViewById(R.id.ele3ispis);

        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(Api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Api api=retrofit.create(Api.class);

        Call<List<Termini>> call= api.getEle3();

        call.enqueue(new Callback<List<Termini>>() {
            @Override
            public void onResponse(Call<List<Termini>> call, Response<List<Termini>> response) {
                List<Termini> termins=response.body();

                String[] terminNaziv =new String[termins.size()];

                String[] termiPocetak =new String[termins.size()];

                for(int i=0;i<termins.size();i++){
                    terminNaziv[i]=(termins.get(i).getDatum()+" "+termins.get(i).getNaslov()+" "+ termins.get(i).getPocetak()+":"+termins.get(i).getKraj());


                }

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
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}