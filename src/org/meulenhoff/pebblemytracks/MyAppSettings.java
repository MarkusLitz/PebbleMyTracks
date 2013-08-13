package org.meulenhoff.pebblemytracks;

public class MyAppSettings {
	public enum ParameterType {
	    SPEED("Speed","SPEED"),

	    TOTALTIME("Total Time","TIME"),
	    TOTALTIMEFROMSTART("Total Time from start","TIME"),
	    TOTALMOVINGTIME("Total Moving Time","TIME"),
	    ETASTART("Estimated Time of Arrival (Start)","ETA"),
	    
	    DISTANCE("Distance","Distance"),
	    DISTANCETOSTART("Distance to start","TO START"),
	    
	    AVGSPEED("Average Speed","AVG"),
	    AVGMOVINGSPEED("Average Moving Speed","AVG"),	    
	    
	    STARTTIME("Start Time","START"),
	    STOPTIME("Stop Time","STOP"),
	    
	    ELEVATIONGAIN("Total Elevation Gain","TTL ELEV"),
	    MINELEVATION("Minimum Elevation","MIN ELEV"),
	    MAXELEVATION("Minimum Elevation","MAX ELEV"),
	    MAXGRADE("Maximum Grade","MAX GRADE"),
	    MINGRADE("Minimum Grade","MIN GRADE"),
	    
	    
	    MAXSPEED("Maximum speed","MAX"),
	    
	    
	    
	    NOTHING("Nothing","NA");
	    
	    private String preferenceString;
	    private String pebbleString;
	    private ParameterType(String preferenceString,String pebbleString) {
	    	this.preferenceString = preferenceString;
	    	this.pebbleString = pebbleString;
	    }

	    public String getPebbleString() {
	    	return this.pebbleString;
	    }
	    
	    public String getPreferenceString() {
	    	return this.preferenceString;
	    }
	   
	}
	
	private ParameterType[] parameter;
	public static final int numFields = 5;
	
	public MyAppSettings() {
		parameter = new ParameterType[numFields];
	}
	
	public void setParameter(int i,ParameterType t) {
		parameter[i] = t;
	}
	
	public ParameterType getParameter(int i) {
		return parameter[i];
	}
 	
}
