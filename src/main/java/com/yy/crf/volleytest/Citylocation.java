package com.yy.crf.volleytest;

/**
 * Created by crf on 2017/5/22.
 * company:逸辰
 * qq:952786280
 * feature:
 */
/*{"lon":120.58531,"level":2,"address":"","cityName":"","alevel":4,"lat":31.29888}*/
public class Citylocation {
	private double lon;
	private int level;

	@Override
	public String toString() {
		return "Citylocation{" +
				"lon=" + lon +
				", level=" + level +
				", address='" + address + '\'' +
				", cityName='" + cityName + '\'' +
				", alevel=" + alevel +
				", lat=" + lat +
				'}';
	}

	public double getLon() {
		return lon;
	}

	public void setLon(double lon) {
		this.lon = lon;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public int getAlevel() {
		return alevel;
	}

	public void setAlevel(int alevel) {
		this.alevel = alevel;
	}

	public double getLat() {
		return lat;
	}

	public void setLat(double lat) {
		this.lat = lat;
	}

	private String address;
	private String cityName;
	private int alevel;
	private double lat;



}
