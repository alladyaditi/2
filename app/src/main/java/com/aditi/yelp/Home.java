package com.aditi.yelp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;


import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;



public class Home extends AppCompatActivity {

    EditText searchField;
    ImageButton search, map;
    private HashSet<JsonObjectRequest> queue;
    Map<String, String> params;
    //YelpAPI yelpAPI;

    DataBase db;
    public double lat = 0, lg = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);

        db = new DataBase(this);
        queue = new HashSet<>();
        searchField = findViewById(R.id.search);

       /*  apiFactory = new YelpFusionApiFactory();
        YelpFusionApi yelpFusionApi = apiFactory.createAPI(apiKey);
        yelpAPI = apiFactory.createAPI();
        params = new HashMap<>();*/



    }

/*

    public void userInitSearch(View view){
        params.put("term", searchField.getText().toString());
        params.put("limit", "3");
        params.put("lang", "en");

        Call<SearchResponse> call = yelpAPI.search("USA", params);

        Callback<SearchResponse> callback = new Callback<SearchResponse>() {


            @Override
            public void onResponse(Call<SearchResponse> call, retrofit2.Response<SearchResponse> response) {
                SearchResponse searchResponse = response.body();


                lat = searchResponse.region().center().latitude();
                lg  = searchResponse.region().center().longitude();




            }

            @Override
            public void onFailure(Call<SearchResponse> call, Throwable t) {
                // HTTP error happened, do something to handle it.
            }
        };

        call.enqueue(callback);

    }
*/


    public class Favourite extends RecyclerView.ViewHolder{

        TextView fav;

        public Favourite(@NonNull View itemView) {
            super(itemView);
            fav = itemView.findViewById(R.id.fav);
        }
    }


    public class FavouriteAdapter extends RecyclerView.Adapter<Favourite>{

        Context c;
        ArrayList<String> data;
        public FavouriteAdapter(Context c, ArrayList<String> data){
             this.c  = c;
             this.data = data;

        }


        @NonNull
        @Override
        public Favourite onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(c).inflate(R.layout.one_row_fav, parent, false);
            return new Favourite(view);
        }

        @Override
        public void onBindViewHolder(@NonNull Favourite holder, int position) {

            holder.fav.setText(data.get(position));
        }

        @Override
        public int getItemCount() {
            return data.size();
        }
    }


}
