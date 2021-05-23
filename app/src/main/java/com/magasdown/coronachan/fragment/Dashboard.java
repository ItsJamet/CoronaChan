package com.magasdown.coronachan.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.magasdown.coronachan.R;
import com.magasdown.coronachan.adapterku.AdapterCountries;
import com.magasdown.coronachan.modal.Countries;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Dashboard extends Fragment {

    View view;
    RequestQueue queue;
    RecyclerView recyclerView;
    GridLayoutManager glm;
    ArrayList<Countries> countries;
    TextView click;
    String country, flag;
    String updated, cases, todayCases, deaths, todayDeaths, recovered, todayRecovered,
            active, critical, casesPerOneMillion, deathsPerOneMillion, tests, testsPerOneMillion,
            population, continent, oneCasePerPeople, oneDeathPerPeople, oneTestPerPeople, activePerOneMillion,
            recoveredPerOneMillion, criticalPerOneMillion;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.dashboard, container, false);

        recyclerView = view.findViewById(R.id.recycle);
        countries = new ArrayList<>();

        click = view.findViewById(R.id.click);

        click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),"Nothing", Toast.LENGTH_LONG).show();
            }

        });

        queue = Volley.newRequestQueue(getActivity());
        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, "https://corona.lmao.ninja/v2/countries?sort=country", null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                try {

                    for (int v = 0; v < response.length(); v++) {

                        JSONObject obj2 = response.getJSONObject(v);

                        cases = obj2.getString("cases");
                        todayCases = obj2.getString("todayCases");
                        deaths = obj2.getString("deaths");
                        todayDeaths = obj2.getString("todayDeaths");
                        recovered = obj2.getString("recovered");
                        todayRecovered = obj2.getString("todayRecovered");
                        active = obj2.getString("active");
                        critical = obj2.getString("critical");
                        casesPerOneMillion = obj2.getString("casesPerOneMillion");
                        deathsPerOneMillion = obj2.getString("deathsPerOneMillion");

                        //Dari test ini ke bawah hasilnya selalu null
                        tests = obj2.getString("test");
                        testsPerOneMillion = obj2.getString("testPerOneMillion");
                        population = obj2.getString("population");
                        continent = obj2.getString("continent");
                        oneCasePerPeople = obj2.getString("oneCasePerPeople");
                        oneDeathPerPeople = obj2.getString("oneDeathPerPeople");
                        oneTestPerPeople = obj2.getString("oneTestPerPeople");
                        activePerOneMillion = obj2.getString("activePerOneMillion");
                        recoveredPerOneMillion = obj2.getString("recoveredPerOneMillion");
                        criticalPerOneMillion = obj2.getString("criticalPerOneMillion");

                    }

                }catch (JSONException ex){
                    ex.printStackTrace();
                }
                for (int k = 0; k < response.length(); k++) {

                    try {
                        JSONObject obj = response.getJSONObject(k);

                        country = obj.getString("country");
                        updated = obj.getString("updated");

                        for (int i = 0; i<obj.length(); i++);{

                            JSONObject obj1 = obj.getJSONObject("countryInfo");

                            flag = obj1.getString("flag");

                            Log.d("flagku", flag + " ");

                        }


                        Log.d("testing", country + "");
                        Log.d("updated", updated + " ");
                        Log.d("cases", cases + " ");
                        Log.d("todayCases", todayCases + " ");
                        Log.d("deaths", deaths+ " ");
                        Log.d("todayDeaths", todayDeaths+ " ");
                        Log.d("recovered",  recovered + " ");
                        Log.d("todayRecovered", todayRecovered + " ");
                        Log.d("active", active + " ");
                        Log.d("critical", critical + " ");
                        Log.d("casesPerOneMillion", casesPerOneMillion + " ");
                        Log.d("deathsPerOneMillion", deathsPerOneMillion + " ");
                        Log.d("test", tests + " ");
                        Log.d("testPerOneMillion", testsPerOneMillion + " ");
                        Log.d("population", population + " ");
                        Log.d("continent", continent+ " ");
                        Log.d("oneCasePerPeople", oneCasePerPeople + " ");
                        Log.d("oneDeathsPerPeople", oneDeathPerPeople + " ");
                        Log.d("oneTestPerPeople", oneTestPerPeople + " ");
                        Log.d("activePerOneMillion", activePerOneMillion + " ");
                        Log.d("recoveredPerOneMillion", recoveredPerOneMillion + " ");
                        Log.d("criticalPerOneMillion", criticalPerOneMillion + " ");

                        Countries contri = new Countries(country, flag, updated, cases, todayCases, deaths, todayDeaths, recovered, todayRecovered,
                                active, critical, casesPerOneMillion, deathsPerOneMillion, tests, testsPerOneMillion,
                                population, continent, oneCasePerPeople, oneDeathPerPeople, oneTestPerPeople, activePerOneMillion,
                                recoveredPerOneMillion, criticalPerOneMillion);

                        countries.add(contri);

                        AdapterCountries adp = new AdapterCountries(countries, getActivity());

                        glm = new GridLayoutManager(getActivity(), 3);
                        recyclerView.setLayoutManager(glm);
                        recyclerView.setAdapter(adp);


                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }
            }

        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        queue.add(request);

        return view;
    }


}
