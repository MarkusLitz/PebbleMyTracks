/*
 * Copyright 2011 Google Inc.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package org.meulenhoff.pebblemytracks;

import java.util.Iterator;
import java.util.Set;
import org.json.JSONException;

import com.getpebble.android.kit.Constants;
import com.getpebble.android.kit.PebbleKit;
import com.getpebble.android.kit.util.PebbleDictionary;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class MyTracksReceiver extends BroadcastReceiver {
  public final static String TAG = "PebbleMyTracks";
  
  public static void dumpIntent(Intent i){
	    Bundle bundle = i.getExtras();
	    if (bundle != null) {
	        Set<String> keys = bundle.keySet();
	        Iterator<String> it = keys.iterator();
	        Log.i(TAG,"Dumping Intent start");
	        while (it.hasNext()) {
	            String key = it.next();
	            Log.i(TAG,"[" + key + "=" + bundle.get(key)+"]");
	        }
	        Log.i(TAG,"Dumping Intent end");
	    }
	}
  
  @Override
  public void onReceive(Context context, Intent intent) {
    String action = intent.getAction();
    Log.i(TAG,"onReceive (action = " + action + ")");
	Toast.makeText(context, "Intent action: " + action, Toast.LENGTH_LONG).show();

	
	
//    if ("android.intent.action.BOOT_COMPLETED".equals(intent.getAction())) {  
//      Intent service = new Intent(context,PebbleSportsService.class);
//      context.startService(service);   
//    }  
    
//	SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);    
//	if ( preferences.getBoolean("debug",false) ) {
//		Toast.makeText(context, "Intent action: " + action, Toast.LENGTH_LONG).show();
//	}
    
     if ( action.equals("com.google.android.apps.mytracks.TRACK_STARTED") ) {
      Log.i(TAG,"received TRACK_STARTED");
      
      Intent service = new Intent(context,PebbleSportsService.class);
      service.putExtra("CMD", PebbleSportsService.EVENT_MYTRACKS_STARTED);
      context.startService(service);
     
      
      context.startService(service);   
    } else if ( action.equals("com.google.android.apps.mytracks.TRACK_STOPPED") ) {
      Log.i(TAG,"received TRACK_STOPPED");
      
      Intent service = new Intent(context,PebbleSportsService.class);
      service.putExtra("CMD", PebbleSportsService.EVENT_MYTRACKS_STOPPED);
      context.startService(service);
     
    } else if ( action.equals("com.getpebble.action.app.RECEIVE") ) {
//    	Log.i(TAG,"dumping intent");      
//    	dumpIntent(intent);

    	final int transactionId = intent.getIntExtra(Constants.TRANSACTION_ID, -1);
        final String jsonData = intent.getStringExtra(Constants.MSG_DATA);
        if (jsonData == null || jsonData.length() == 0  ) {
            Log.i(TAG,"jsonData null");
            return;
        }
           
        try {
            final PebbleDictionary data = PebbleDictionary.fromJson(jsonData);
            // do what you need with the data
            PebbleKit.sendAckToPebble(context, transactionId);

            if ( data.contains(0x0) ) {
            	Intent service = new Intent(context,PebbleSportsService.class);
            	service.putExtra("CMD", data.getUnsignedInteger(0x0).intValue());
            	context.startService(service);
            } else if ( data.contains(Constants.SPORTS_STATE_KEY) ) {
            	Intent service = new Intent(context,PebbleSportsService.class);            	
            	service.putExtra("SPORTS_STATE_KEY", data.getUnsignedInteger(Constants.SPORTS_STATE_KEY).intValue());
            	context.startService(service);            	
            } else {
            	dumpIntent(intent);
            }      
        } catch (JSONException e) {
            Log.i(TAG,"failed reived -> dict" + e);
            return;
        }
    
    }
    
  }
}
