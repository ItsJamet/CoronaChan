package com.magasdown.coronachan.ui;

import android.os.Bundle;
import android.util.Log;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.magasdown.coronachan.R;
import com.magasdown.coronachan.modal.Countries;

import java.util.ArrayList;

public class ActivitykeDua extends AppCompatActivity {

    String /*country,*/ flag, updated, cases, todayCases, deaths, todayDeaths/*, recovered, todayRecovered,
            active, critical, casesPerOneMillion, deathsPerOneMillion, tests, testsPerOneMillion,
            population, continent, oneCasePerPeople, oneDeathPerPeople, oneTestPerPeople, activePerOneMillion,
            recoveredPerOneMillion, criticalPerOneMillion*/;
    String URL = "https://www.worldometers.info/coronavirus/";
    TextView namaNegara, TVupdated, TVcases, TVtodayCases, TVdeaths, TVtodayDeaths;
    WebView myWEB;

    /*RecyclerView Rview;
    GridLayoutManager gl;*/
    ArrayList<Countries> countries;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.detail_semua);

        flag = getIntent().getStringExtra("flag");
        namaNegara = findViewById(R.id.percobaan);

        updated = getIntent().getStringExtra("updated");
        TVupdated = findViewById(R.id.TVupdated);

        //Rview = findViewById(R.id.Rview);

        TVcases = findViewById(R.id.TVcases);
        cases = getIntent().getStringExtra("cases");
        TVtodayCases = findViewById(R.id.TVtodayCases);
        todayCases = getIntent().getStringExtra("todayCases");
        TVdeaths = findViewById(R.id.TVdeaths);
        deaths = getIntent().getStringExtra("deaths");
        TVtodayDeaths = findViewById(R.id.TVtodayDeaths);
        todayDeaths = getIntent().getStringExtra("todayDeaths");
        myWEB = findViewById(R.id.myWeb);

        /*updated = getIntent().getStringExtra("updated");
        cases = getIntent().getStringExtra("cases");
        todayCases = getIntent().getStringExtra("todayCases");*/


        Log.d("flag", flag + "");
        Log.d("updated",updated + "");
        Log.d("cases", cases + "");
        Log.d("todayCases",todayCases + "");
        Log.d("deaths",deaths + "");
        Log.d("todayDeaths", todayDeaths + "");

        /*Countries kontri = new Countries(country, flag, updated, cases, todayCases, deaths, todayDeaths, recovered, todayRecovered,
                active, critical, casesPerOneMillion, deathsPerOneMillion, tests, testsPerOneMillion,
                population, continent, oneCasePerPeople, oneDeathPerPeople, oneTestPerPeople, activePerOneMillion,
                recoveredPerOneMillion, criticalPerOneMillion);*/

        Toast.makeText(getApplicationContext(), "Telah Diklik" + flag, Toast.LENGTH_LONG).show();
        namaNegara.setText(flag);

        /*myWEB.loadData(updated,"text/html", "utf-8");
        myWEB.setWebViewClient(new WebViewClient());*/

        myWEB.loadUrl(URL);
        myWEB.setWebViewClient(new WebViewClient());

        //Nah di bagian TexView ini selalu hasilnya null
        TVupdated.setText(updated);
        TVcases.setText(cases);
        TVtodayCases.setText(cases);
        TVdeaths.setText(deaths);
        TVtodayDeaths.setText(todayDeaths);

        /*countries.add(kontri);
        AdapterCountries adp2 = new AdapterCountries(countries, getApplicationContext());
        gl = new GridLayoutManager(this, 1);
        Rview.setLayoutManager(gl);
        Rview.setAdapter(adp2);*/


    }


}
