package com.example.zavrsni3.Strojarstvo;

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

public class strojarstvoPi3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_strojarstvo_pi3);

        final ListView listView=(ListView) findViewById(R.id.stroj3piispis);

        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(Api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Api api=retrofit.create(Api.class);

        Call<List<Termini>> call= api.getStr3PI();

        call.enqueue(new Callback<List<Termini>>() {
            @Override
            public void onResponse(Call<List<Termini>> call, Response<List<Termini>> response) {
                List<Termini> termins=response.body();

                String[] terminNaziv =new String[termins.size()];

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
