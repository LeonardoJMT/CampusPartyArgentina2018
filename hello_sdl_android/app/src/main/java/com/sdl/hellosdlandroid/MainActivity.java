package com.sdl.hellosdlandroid;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
	private static final String TAG = "MainActivity";

	LinearLayout l1,l2;
	Animation uptodown,downtoup;

	public void loadAnimationFirst(){
		l1 = (LinearLayout) findViewById(R.id.l1);
		l2 = (LinearLayout) findViewById(R.id.l2);
		uptodown = AnimationUtils.loadAnimation(this,R.anim.uptodown);
		downtoup = AnimationUtils.loadAnimation(this,R.anim.downtoup);
		l1.setAnimation(uptodown);
		l2.setAnimation(downtoup);
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		//If we are connected to a module we want to start our SdlService
		if(BuildConfig.TRANSPORT.equals("MBT")) {

			//For MANTICORE connection, comment:
			SdlReceiver.queryForConnectedService(this);

			//For MANTICORE connection, uncomment:
			//Intent sdlServiceIntent = new Intent(this, SdlService.class); // used for TCPstartService(sdlServiceIntent);

		}else if(BuildConfig.TRANSPORT.equals("TCP") || BuildConfig.TRANSPORT.equals("LBT")) {
			Intent proxyIntent = new Intent(this, SdlService.class);
			startService(proxyIntent);
		}
		loadAnimationFirst();
		final int MILISEGUNDOS = 3000;
		new Handler().postDelayed(new Runnable(){
			@Override
			public void run() {
				Intent i = new Intent(MainActivity.this, MainMenu.class);
				MainActivity.this.startActivity(i);
			}
		}, MILISEGUNDOS);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
