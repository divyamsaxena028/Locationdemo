package com.example.locationdemo;

import android.app.Activity;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class MainActivity extends Activity implements LocationListener {
	TextView txt1,txt2;
	LocationManager lm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        txt1=(TextView)findViewById(R.id.textView1);
        txt2=(TextView)findViewById(R.id.textView3);
        
        
        lm=(LocationManager)getSystemService(LOCATION_SERVICE);
        
        Criteria cr=new Criteria();
        String provider=(lm.getBestProvider(cr,true));
        lm.requestLocationUpdates(provider,0,0, this);
    }
    

	@Override
	public void onLocationChanged(Location location) {
		// TODO Auto-generated method stub
		if(location!=null)
		{
			double lat=location.getLatitude();
			double lng=location.getLongitude();
			txt1.setText(""+lat);
			txt2.setText(""+lng);
			lm.removeUpdates(this);
		}
			
		
	}

	@Override
	public void onProviderDisabled(String provider) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onProviderEnabled(String provider) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStatusChanged(String provider, int status, Bundle extras) {
		// TODO Auto-generated method stub
		
	}
}
