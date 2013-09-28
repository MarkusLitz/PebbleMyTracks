package org.meulenhoff.pebblemytracks;

import android.app.Application;

//import org.acra.*;
//import org.acra.annotation.*;

//@ReportsCrashes(
//		formKey = "", // will not be used
//        mailTo = "pieter@meulenhoff.org",
//        mode = ReportingInteractionMode.SILENT,
//        customReportContent = { ReportField.LOGCAT },     
//        logcatArguments = { "-t", "200", "-v", "long", "ActivityManager:I", "PebbleMyTracks:V", "TrackRecordingService:V", "*:S" }
//)

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        // The following line triggers the initialization of ACRA
//        ACRA.init(this);
//    	SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());    
//    	if ( preferences.getBoolean("debug",false) ) {
//    		Toast.makeText(getApplicationContext(), "PebbleMyTracks created", Toast.LENGTH_LONG).show();
//    	}

    }
}




