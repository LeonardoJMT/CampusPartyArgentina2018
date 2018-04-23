package com.sdl.hellosdlandroid;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

/**
 * Created by leonardo on 22/04/18.
 */

public class MainMenu extends Activity {
    CardView getVehicleDataCard;
    CardView selectedDataCard;
    CardView aboutSdlCard;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        getVehicleDataCard = (CardView) findViewById(R.id.getVehicleDataCard);
        selectedDataCard = (CardView) findViewById(R.id.selectedDataCard);
        aboutSdlCard = (CardView) findViewById(R.id.aboutSdlCard);


        getVehicleDataCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent infoIntent = new Intent(MainMenu.this, VehicleInfoActivity.class);
                startActivity(infoIntent);
            }
        });

        aboutSdlCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = "https://smartdevicelink.com/en/guides/android/getting-started/";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });



    };
    @Override
    public void onBackPressed() {
        this.moveTaskToBack(true);
    }
}
