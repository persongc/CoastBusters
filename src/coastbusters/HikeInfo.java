package coastbusters;

import java.util.ArrayList;

public class HikeInfo //should make use of weather and reviews class
{
	private String name;
	private Boolean bathrooms;
	private Boolean water;
	private String location;
	private Access access;
	private Difficulty difficulty;
	private Features features;
	private Hours hours;
	
	public HikeInfo(String name, Boolean bathrooms, Boolean water) {
		this.name = name;
		this.bathrooms = bathrooms;
		this.water = water;
	}

	public String getName(){
		return name;
	}

	public Boolean getBathrooms(){
		return bathrooms;
	}

	public Boolean getWater(){
		return water;
	}

	public String getLocation(){
		return location;
	}

	public void setAccess(Access access){
		this.access = access;
	}

	public Access getAccess(){
		return access;
	}

	public void setDifficulty(Difficulty diff){
		this.difficulty = diff;
	}

	public Difficulty getDifficulty(){
		return difficulty;
	}

	public void setFeatures(Features features){
		this.features = features;
	}

	public Features getFeatures(){
		return features;
	}

	public void setHours(Hours hours){
		this.hours = hours;
	}

	public Hours getHours(){
		return hours;
	}
}