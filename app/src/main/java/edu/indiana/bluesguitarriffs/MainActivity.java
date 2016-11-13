/*MainActivity.java
*
*Contains the Java code for the
*Primary Activity in this project
*
*Created by: Alex Totheroh
*Created on: 3/1/15
*Last Modified by: Alex Totheroh
*Last Modified on: 3/6/2015
*Assignment/Project: A290 Android Development Final Project
*Part of: BluesGuitarRiffs, refers to activity_main.xml layout file
**/

package edu.indiana.bluesguitarriffs;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;


public class MainActivity extends Activity {
	
	// this boolean determines whether or not the message asking people to rate the app appears on the
	// home screen
	public static boolean showRateBeg = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button rateBeg = (Button)this.findViewById(R.id.ratebeg);
        final TextView rateDismiss = (TextView)this.findViewById(R.id.dismissRateBeg);
        final Button bgrRockstarLink = (Button)this.findViewById(R.id.goToBGRRockstar);
        
        // load ad
   	 	AdView mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        
        // if user has dismissed rating beg, get rid of the buttons:
        final SharedPreferences prefs = this.getSharedPreferences(
        	      "edu.indiana.bluesguitarriffs", Context.MODE_PRIVATE);
        if (!prefs.contains("rateBeg")) {
        	prefs.edit().putBoolean("rateBeg", true).apply();
        }
        
        showRateBeg = prefs.getBoolean("rateBeg", true);
        
        if (!showRateBeg) {
        	rateBeg.setVisibility(View.GONE);
        	rateDismiss.setVisibility(View.GONE);
        }
        
        // setting an intent to start a new activity.  We will have 10 of these, one for 
        // each riff-specific sub-activity
        final Intent riff1Intent = new Intent(MainActivity.this, Riff1Activity.class);
        
        Button riff1link = (Button)this.findViewById(R.id.riff1button);
        riff1link.setOnClickListener(new OnClickListener(){

            public void onClick(View v) {
            	MainActivity.this.startActivity(riff1Intent); // starts Riff1Activity on click
            }
        });
        
        // this does the same as above, except we're setting this intent to start riff 2 activity
        final Intent riff2Intent = new Intent(MainActivity.this, Riff2Activity.class);
        
        Button riff2link = (Button)this.findViewById(R.id.riff2button);
        riff2link.setOnClickListener(new OnClickListener(){

            public void onClick(View v) {
            	MainActivity.this.startActivity(riff2Intent); // starts Riff2Activity
            }
        });
        
        // see above, establishing intent for riff 3 activity
        final Intent riff3Intent = new Intent(MainActivity.this, Riff3Activity.class);
        
        Button riff3link = (Button)this.findViewById(R.id.riff3button);
        riff3link.setOnClickListener(new OnClickListener(){

            public void onClick(View v) {
            	MainActivity.this.startActivity(riff3Intent); // starts Riff3Activity
            }
        });
        
        // see above, establishing intent for riff 4 activity
        final Intent riff4Intent = new Intent(MainActivity.this, Riff4Activity.class);
        
        Button riff4link = (Button)this.findViewById(R.id.riff4button);
        riff4link.setOnClickListener(new OnClickListener(){

            public void onClick(View v) {
            	MainActivity.this.startActivity(riff4Intent); // starts Riff4Activity
            }
        });
        
        // see above, establishing intent for riff 5 activity
        final Intent riff5Intent = new Intent(MainActivity.this, Riff5Activity.class);
        
        Button riff5link = (Button)this.findViewById(R.id.riff5button);
        riff5link.setOnClickListener(new OnClickListener(){

            public void onClick(View v) {
            	MainActivity.this.startActivity(riff5Intent); // starts Riff5Activity
            }
        });
        
        // see above, establishing intent for riff 3 activity
        final Intent riff6Intent = new Intent(MainActivity.this, Riff6Activity.class);
        
        Button riff6link = (Button)this.findViewById(R.id.riff6button);
        riff6link.setOnClickListener(new OnClickListener(){

            public void onClick(View v) {
            	MainActivity.this.startActivity(riff6Intent); // starts Riff6Activity
            }
        });
        
        // see above, establishing intent for riff 7 activity
        final Intent riff7Intent = new Intent(MainActivity.this, Riff7Activity.class);
        
        Button riff7link = (Button)this.findViewById(R.id.riff7button);
        riff7link.setOnClickListener(new OnClickListener(){

            public void onClick(View v) {
            	MainActivity.this.startActivity(riff7Intent); // starts Riff7Activity
            }
        });
        
        // see above, establishing intent for riff 8 activity
        final Intent riff8Intent = new Intent(MainActivity.this, Riff8Activity.class);
        
        Button riff8link = (Button)this.findViewById(R.id.riff8button);
        riff8link.setOnClickListener(new OnClickListener(){

            public void onClick(View v) {
            	MainActivity.this.startActivity(riff8Intent); // starts Riff8Activity
            }
        });
        
        // see above, establishing intent for riff 9 activity
        final Intent riff9Intent = new Intent(MainActivity.this, Riff9Activity.class);
        
        Button riff9link = (Button)this.findViewById(R.id.riff9button);
        riff9link.setOnClickListener(new OnClickListener(){

            public void onClick(View v) {
            	MainActivity.this.startActivity(riff9Intent); // starts Riff9Activity
            }
        });
        
        // see above, establishing intent for riff 10 activity
        final Intent riff10Intent = new Intent(MainActivity.this, Riff10Activity.class);
        
        Button riff10link = (Button)this.findViewById(R.id.riff10button);
        riff10link.setOnClickListener(new OnClickListener(){

            public void onClick(View v) {
            	MainActivity.this.startActivity(riff10Intent); // starts Riff10Activity
            }
        });
        
        
        // setting up the ability to go to rating page        
        rateBeg.setOnClickListener(new OnClickListener(){

            public void onClick(View v) {
            	final Uri uri = Uri.parse("market://details?id=" + getApplicationContext().getPackageName());
            	final Intent rateAppIntent = new Intent(Intent.ACTION_VIEW, uri);

            	if (getPackageManager().queryIntentActivities(rateAppIntent, 0).size() > 0)
            	{
            	    startActivity(rateAppIntent);
            	}
            	else
            	{
            		Toast.makeText(getApplicationContext(), "Unable to open Marketplace.", Toast.LENGTH_SHORT).show();
            	}
            }
        });
        
        // setting up ability to hide the rate begging stuff       
        rateDismiss.setOnClickListener(new OnClickListener(){

            public void onClick(View v) {
            	prefs.edit().putBoolean("rateBeg", false).apply();
            	rateBeg.setVisibility(View.GONE);
            	rateDismiss.setVisibility(View.GONE);
            }
        });
        
        // setting up ability to go to ROCKSTAR edition download page
        bgrRockstarLink.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                final Uri uri = Uri.parse("market://details?id=edu.indiana.bluesguitarriffsrockstar");
                final Intent goToRockstarEdition = new Intent(Intent.ACTION_VIEW, uri);

                if (getPackageManager().queryIntentActivities(goToRockstarEdition, 0).size() > 0) {
                    startActivity(goToRockstarEdition);
                }
                else {
                    Toast.makeText(getApplicationContext(), "Unable to open Marketplace.", Toast.LENGTH_SHORT).show();
                }
            }
        });
        
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
