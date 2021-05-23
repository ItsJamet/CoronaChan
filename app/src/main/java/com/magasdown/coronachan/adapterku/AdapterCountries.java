package com.magasdown.coronachan.adapterku;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.magasdown.coronachan.R;
import com.magasdown.coronachan.modal.Countries;
import com.magasdown.coronachan.ui.ActivitykeDua;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class AdapterCountries extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private ArrayList<Countries> countries;
    private Context context;


    public AdapterCountries(ArrayList<Countries> countries, Context context) {
        this.countries = countries;
        this.context = context;
    }

    class MyAdapterKu extends RecyclerView.ViewHolder {

        TextView negara;
        ImageView image;
        RelativeLayout cover;


        public MyAdapterKu(@NonNull View itemView) {
            super(itemView);
            negara = itemView.findViewById(R.id.negara);
            image = itemView.findViewById(R.id.image);
            cover = itemView.findViewById(R.id.cover);


        }

    }



    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.list_negara, parent, false);

        return new MyAdapterKu(view);

    }



    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int position) {

        ((MyAdapterKu) viewHolder).negara.setText(countries.get(position).getCountry());
        Picasso.get().load(countries.get(position).getFlag()).into(((MyAdapterKu) viewHolder).image);
        ((MyAdapterKu) viewHolder).cover.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Corona~Chan", countries.get(position).getCountry() + " posisi: " + position);
            }
        });
        ((MyAdapterKu) viewHolder).cover.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Telah Diklik " + countries.get(position).getFlag(), Toast.LENGTH_LONG).show();
                Intent intent = new Intent(context, ActivitykeDua.class);
                intent.putExtra("flag", countries.get(position).getCountry());
                //intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });


    }


    @Override
    public int getItemCount() {

        return countries.size();
    }


}
