package com.twohlix.tracker;

import java.util.List;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.support.v4.app.NotificationCompat;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.location.LocationManager;
import android.location.Location;
import com.twohlix.tracker.TrackingHandler;

public class MainActivity extends Activity {

	public TrackingHandler tracker;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        this.tracker = new TrackingHandler(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
    
    public void toggleTracking(View v){
    	//set some shit
    	LocationManager locMan = (LocationManager)this.getSystemService(Context.LOCATION_SERVICE);
    	
    	List<String> providers = locMan.getAllProviders();
    	for(int i=0; i<providers.size(); ++i){
    		String prov = providers.get(i);
    		Location curLoc = locMan.getLastKnownLocation(prov);
    		
    		
    		Toast toggle = Toast.makeText(this, prov + ":" + curLoc , Toast.LENGTH_SHORT);
        	toggle.show();
        	
        	TextView lols = (TextView)findViewById(R.id.debugTextView);
        	lols.append(prov + ":" + curLoc + "\n");
        	
        	
        	
        	
        	
    	}
    		
    		
    	
    	//Toast toggle = Toast.makeText(this, locMan.getBestProvider(criteria, false), Toast.LENGTH_SHORT);
    	//toggle.show();
    	
    	

    }
    
}
