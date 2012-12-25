package com.twohlix.tracker;

import java.util.List;
import java.util.Queue;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.view.Menu;
import android.view.View;
import android.widget.Toast;
import android.location.GpsStatus;
import android.location.LocationManager;
import android.location.Location;

public class TrackingHandler {
	private LocationManager locMan;
	private List<String> providers;
	private Queue<Location> prevLocs;
	
	
	TrackingHandler(Activity act){
		//set some shit
    	this.locMan = (LocationManager)act.getSystemService(Context.LOCATION_SERVICE);
    	this.providers = locMan.getAllProviders();
	}
	
	/**
	 * getBestLocation
	 * 
	 * returns the best location we know of.
	 * @return android.location.Location
	 */
	public Location getBestLocation(){
    	float accuracy = 0.00f;
		Location bestLoc = null;
    	
		for(int i=0; i<this.providers.size(); ++i){
    		String prov = this.providers.get(i);
    		Location curLoc = this.locMan.getLastKnownLocation(prov);
    		
    		float tempAccuracy = curLoc.getAccuracy();
    		if(tempAccuracy >= accuracy){
    			accuracy = tempAccuracy;
    			bestLoc = curLoc;
    		}
        }
		
		return bestLoc;
    }
}
