package com.sdl.hellosdlandroid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

/**
 * Created by leonardo on 22/04/18.
 */

public class MainMenu extends Activity {
    CardView getVehicleDataCard;
    CardView selectedDataCard;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        getVehicleDataCard = (CardView) findViewById(R.id.getVehicleDataCard);
        selectedDataCard = (CardView) findViewById(R.id.selectedDataCard);

        getVehicleDataCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent infoIntent = new Intent(MainMenu.this, VehicleInfoActivity.class);
                startActivity(infoIntent);
            }
        });


    };
    @Override
    public void onBackPressed() {
        this.moveTaskToBack(true);
    }
}
