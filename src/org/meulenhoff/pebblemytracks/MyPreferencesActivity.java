package org.meulenhoff.pebblemytracks;

import java.util.ArrayList;
//import org.acra.ACRA;
import org.meulenhoff.pebblemytracks.MyAppSettings.ParameterType;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.preference.ListPreference;
import android.preference.Preference;
import android.preference.PreferenceActivity;
import android.preference.PreferenceScreen;
import android.util.Log;


public class MyPreferencesActivity extends PreferenceActivity {
	private final String TAG = "PebbleMyTracks";
	
  @Override
  public void onCreate(Bundle savedInstanceState) {        
      super.onCreate(savedInstanceState);        
      addPreferencesFromResource(R.xml.preferences);
      
      PreferenceScreen screen = (PreferenceScreen)getPreferenceManager().findPreference("alternativePreferenceScreen");

//      Preference button = (Preference)getPreferenceManager().findPreference("button");
//      button.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
//                      @Override
//                      public boolean onPreferenceClick(Preference arg0) { 
//                          //code for what you want it to do   
//                    	  ACRA.getErrorReporter().handleException(null);
//                          return true;
//                      }
//                  });

    Preference button = (Preference)getPreferenceManager().findPreference("button");
    button.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
                    @Override
                    public boolean onPreferenceClick(Preference arg0) { 
                    	//Uri uri = Uri.parse("http://builds.cloudpebble.net/9/e/9e00e4ecfc434c98a284eac8fccc42ff/watchface.pbw");
                    	
                    	Uri uri = Uri.parse("android.resource://org.meulenhoff.pebblemytracks/raw/watchface.pbw");
//                    	Uri uri = Uri.parse("file:///android_res/raw/watchface.pbw");
//                    	Log.i(TAG,getResources().openRawResource(R.raw.watchface).toString());
                        startActivity(new Intent(Intent.ACTION_VIEW, uri));
                    	return true;
                    }
                });

      
      ArrayList<String> entries = new ArrayList<String>();
      ArrayList<String> entryValues = new ArrayList<String>();      
      for (ParameterType parameterType : MyAppSettings.ParameterType.values()) {
    	  entries.add(parameterType.getPreferenceString());
    	  entryValues.add("" + parameterType.toString());
      }
     
      
      for(int i=0;(i<MyAppSettings.numFields);i++) {
    	  String param = "parameter" + i;
    	  
    	  ListPreference listPref = new ListPreference(this);
    	  listPref.setKey(param); //Refer to get the pref value
    	  listPref.setEntries(entries.toArray(new CharSequence[entries.size()]));
    	  listPref.setEntryValues(entryValues.toArray(new CharSequence[entryValues.size()]));
      
    	  listPref.setDialogTitle("Display parameter " + (1 + i)); 
    	  listPref.setTitle("Display parameter " + (1 + i));
    	  listPref.setSummary("Select parameter to display on the Pebble");
    	  
    	  screen.addPreference(listPref);
      }
      
//      
//      Intent service = new Intent(this,PebbleSportsService.class);
//      this.startService(service);   

  }

  
}
