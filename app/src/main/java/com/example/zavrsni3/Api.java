package com.example.zavrsni3;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {

        String BASE_URL="http://212.39.115.102:5000/termini/";

        @GET("studiji")
        Call<List<Studiji>> getStudiji(); /*racunarstvo 1*/

        @GET("1")
        Call<List<Termini>> getrac1();

        @GET("2")
        Call<List<Termini>> getRac2();

        @GET("3")
        Call<List<Termini>> getRac3();

        @GET("4")
        Call<List<Termini>> getRac4RSM();

        @GET("5")
        Call<List<Termini>> getRac5RSM();

        @GET("6")
        Call<List<Termini>> getRac4PIIS();

        @GET("7")
        Call<List<Termini>> getRac5PIIS();

        @GET("8")
        Call<List<Termini>> getEle1();

        @GET("9")
        Call<List<Termini>> getEle2();

        @GET("10")
        Call<List<Termini>> getEle3();

        @GET("11")
        Call<List<Termini>> getStr1();

        @GET("12")
        Call<List<Termini>> getStr2();

        @GET("13")
        Call<List<Termini>> getStr3KIRP();

        @GET("14")
        Call<List<Termini>> getStr3PI();

        @GET("15")
        Call<List<Termini>> getStr3M();

        @GET("16")
        Call<List<Termini>> getStr4KIRP();

        @GET("17")
        Call<List<Termini>> getStr4PI();

        @GET("18")
        Call<List<Termini>> getStr4M();

        @GET("19")
        Call<List<Termini>> getStr5KIRP();

        @GET("20")
        Call<List<Termini>> getStr5PI();

        @GET("21")
        Call<List<Termini>> getStr5M();

        @GET("22")
        Call<List<Termini>> getEle4EE();

        @GET("23")
        Call<List<Termini>> getEle4SUA();




}
