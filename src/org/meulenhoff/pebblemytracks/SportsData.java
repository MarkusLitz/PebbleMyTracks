package org.meulenhoff.pebblemytracks;

public class SportsData {
	// all variables are in units in m and ms 
	public static final double MPS_TO_KMH = 3.6;
	public static final double MPS_TO_MPH = 2.2369;
	public static final double M_TO_KM = 0.001;
	public static final double M_TO_MILE = 0.000621371;
	public static final double M_TO_FEET = 3.28084;
	public static final double KM_TO_MILES = 0.621371;

	private boolean gpsstatus;

	public boolean getGpsStatus() {
		return gpsstatus;
	}


	public void setGpsStatus(boolean gpsstatus) {
		this.gpsstatus = gpsstatus;
	}
	private long fakeStartTime;
	private long locationTime;
	private double heading;
	public double getHeading() {
		return heading;
	}


	public void setHeading(double heading) {
		this.heading = heading;
	}
	private double elevationGain;	
	private double distanceToStart;
	private long startTime;
	private long stopTime;	
	private long totalTimeFromStart;
	private double altspeed;
	private double altspeed2;
	private double speed; // current speed in m/s
	private double distance; // trip distance in m
	private long totaltime; // total trip time in ms
	private long totalmovingtime; // total trip moving time in ms;
	private double avgspeed; // trip average speed
	private double avgmovingspeed; // trip average moving speed
	private double maxspeed; // maximum speed
	private double altitude; // current altitude
	private double bearing; // bearing
	private double maxaltitude; // max trip altitude
	private double totalelevation; // total trip elevation
	
	
	
	public long getFakeStartTime() {
		return fakeStartTime;
	}


	public void setFakeStartTime(long fakeStartTime) {
		this.fakeStartTime = fakeStartTime;
	}


	public long getTotalTimeFromStart() {
		return totalTimeFromStart;
	}


	public void setTotalTimeFromStart(long totalTimeFromStart) {
		this.totalTimeFromStart = totalTimeFromStart;
	}


	public double getAltspeed() {
		return altspeed;
	}
	

	public double getAltspeed2() {
		return altspeed2;
	}

	public void setAltspeed2(double altspeed2) {
		this.altspeed2 = altspeed2;
	}

	public void setAltspeed(double altspeed) {
		this.altspeed = altspeed;
	}
	private double odometer;
	
	public double getOdometer() {
		return odometer;
	}
	public void setOdometer(double odometer) {
		this.odometer = odometer;
	}
	public long getStartTime() {
		return startTime;
	}
	public void setStartTime(long startTime) {
		this.startTime = startTime;
	}
	public long getStopTime() {
		return stopTime;
	}
	public void setStopTime(long stopTime) {
		this.stopTime = stopTime;
	}
	public double getSpeed() {
		return speed;
	}
	public void setSpeed(double speed) {
		this.speed = speed;
	}
	public double getDistance() {
		return distance;
	}
	public void setDistance(double distance) {
		this.distance = distance;
	}
	public long getTotaltime() {
		return totaltime;
	}
	public void setTotaltime(long totaltime) {
		this.totaltime = totaltime;
	}
	public long getTotalmovingtime() {
		return totalmovingtime;
	}
	public void setTotalmovingtime(long totalmovingtime) {
		this.totalmovingtime = totalmovingtime;
	}
	public double getAvgspeed() {
		return avgspeed;
	}
	public void setAvgspeed(double avgspeed) {
		this.avgspeed = avgspeed;
	}
	public double getAvgmovingspeed() {
		return avgmovingspeed;
	}
	public void setAvgmovingspeed(double avgmovingspeed) {
		this.avgmovingspeed = avgmovingspeed;
	}
	public double getMaxspeed() {
		return maxspeed;
	}
	public void setMaxspeed(double maxspeed) {
		this.maxspeed = maxspeed;
	}
	public double getAltitude() {
		return altitude;
	}
	public void setAltitude(double altitude) {
		this.altitude = altitude;
	}
	public double getBearing() {
		return bearing;
	}
	public void setBearing(double bearing) {
		this.bearing = bearing;
	}
	public double getMaxaltitude() {
		return maxaltitude;
	}
	public void setMaxaltitude(double maxaltitude) {
		this.maxaltitude = maxaltitude;
	}
	public double getTotalelevation() {
		return totalelevation;
	}
	public void setTotalelevation(double totalelevation) {
		this.totalelevation = totalelevation;
	}
	public double getElevationGain() {
		return elevationGain;
	}

	public void setElevationGain(double elevationGain) {
		this.elevationGain = elevationGain;
	}

	public SportsData() {
		locationTime = 0;
	}
	
	public long getLocationTime() {
		return locationTime;
	}
	public void setLocationTime(long locationTime) {
		this.locationTime = locationTime;
	}
	
	public double getDistanceToStart() {
		return distanceToStart;
	}
	public void setDistanceToStart(double distanceToStart) {
		this.distanceToStart = distanceToStart;
	}

}
