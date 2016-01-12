package com.lisbonpocket.code.kawakuti.lisbonpocket;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;

public class ServicesArround extends AppCompatActivity {

    TextView curr_address;


    private String[] listOfServices = {
            "Services",
            "Restaurants",
            "Lounge",
            "Shopping",
            "Transports"
    };

    private int[] mThumbIds = {
            R.drawable.services,
            R.drawable.restaurant,
            R.drawable.lazer,
            R.drawable.shoopings,
            R.drawable.transports
    };

    private String[] servicesNames = {
            "Atm",
            "Bank",
            "Church",
            "Embassy",
            "Hotel", //lodging
            "Health",
            "Hospital",
            "Post Office", //post_office
            "Parking",
            "Pharmacy",
            "Police",
            "School",
            "University",
    };

    private int[] servicesIcons = {
            R.drawable.atm,
            R.drawable.bank,
            R.drawable.hotels,
            R.drawable.embassy,
            R.drawable.hotels,
            R.drawable.health,
            R.drawable.hospital,
            R.drawable.mailpost,
            R.drawable.parking,
            R.drawable.pharmacy,
            R.drawable.police,
            R.drawable.schools,
            R.drawable.university
    };

    private String[] restaurantsNames = {
            "Bakery",
            "Coffee", //cafe
            "Restaurant"
    };

    private int[] restaurantsIcons = {
            R.drawable.cakesshop,
            R.drawable.coffeeshop,
            R.drawable.restaurants,
    };
    private String[] shoppingNames = {
            "Store",
            "Shopping Mall",
            "GSupermarket",
            "Liquor Store" //liquor_store
    };

    private int[] shoopingIcons = {
            R.drawable.bank,
            R.drawable.shoopings,
            R.drawable.grossery,
            R.drawable.liquor
    };

    private String[] transportsNames = {
            "Airport",
            "Bus Station",      //bus_station
            "Subway Station", //subway_station
            "Train Station",   //train_station
            "Taxi Stand"       ////taxi_stand


    };

    private int[] transportIcons = {
            R.drawable.airport,
            R.drawable.transports,
            R.drawable.metro,
            R.drawable.transports,
            R.drawable.transports
    };

    private String[] loungeNames = {
            "Bar",
            "Night Club",      //night_club
            "Movie rental",   //movie_rental
            "Movie theater", //movie_theater
            "Park"
    };

    private int[] loungeIcons = {
            R.drawable.bars,
            R.drawable.discos,
            R.drawable.movierent,
            R.drawable.movietheater,
            R.drawable.park,
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_services);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        curr_address = (TextView) findViewById(R.id.current_address);

        //we check the saved instancestate if in case you save the state of the application in a bundle,
        // when the activity activity needs to be recreated (e.g., orientation change)

        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if (extras != null) {
                curr_address.setText(extras.getString("Current_Address"));
            } else {
                curr_address.setText(null);
            }
        } else {
            curr_address.setText((String) savedInstanceState.getSerializable("Current_Address"));
        }


        GridView gridView = (GridView) findViewById(R.id.gridview);
        gridView.setAdapter(new CustomGridViewAdapter(ServicesArround.this, mThumbIds, listOfServices));
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                startIntentChoosed(position, (String) curr_address.getText());


            }
        });
    }

    //we check the saved instancestate if in case you save the state of the application in a bundle,
    // when the activity activity needs to be recreated (e.g., orientation change)


    public void startIntentChoosed(int choosed, String address) {

        switch (choosed) {
            case 0:

                Intent localServices = new Intent(this, ServiceChoosed.class);
                localServices.putExtra("LOCATION", address);
                localServices.putExtra("CURRENT_SERVICES", servicesNames);
                localServices.putExtra("CURRENT_ICONS", servicesIcons);
                startActivity(localServices);
                break;
            case 1:

                Intent restaurantsServices = new Intent(this, ServiceChoosed.class);
                restaurantsServices.putExtra("LOCATION", address);
                restaurantsServices.putExtra("CURRENT_SERVICES", restaurantsNames);
                restaurantsServices.putExtra("CURRENT_ICONS", restaurantsIcons);
                startActivity(restaurantsServices);
                break;
            case 2:

                Intent loungeServices = new Intent(this, ServiceChoosed.class);
                loungeServices.putExtra("LOCATION", address);
                loungeServices.putExtra("CURRENT_SERVICES", loungeNames);
                loungeServices.putExtra("CURRENT_ICONS", loungeIcons);
                startActivity(loungeServices);

                break;
            case 3:

                Intent shoppingServices = new Intent(this, ServiceChoosed.class);
                shoppingServices.putExtra("LOCATION", address);
                shoppingServices.putExtra("CURRENT_SERVICES", shoppingNames);
                shoppingServices.putExtra("CURRENT_ICONS", shoopingIcons);
                startActivity(shoppingServices);

                break;
            case 4:

                Intent transportServices = new Intent(this, ServiceChoosed.class);
                transportServices.putExtra("LOCATION", address);
                transportServices.putExtra("CURRENT_SERVICES", transportsNames);
                transportServices.putExtra("CURRENT_ICONS", transportIcons);
                startActivity(transportServices);

                break;

            default:
                break;

        }
    }


}


