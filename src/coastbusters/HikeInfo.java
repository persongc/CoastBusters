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

	public void setAccess(Access access){
		this.access = access;
	}

	public void setDifficulty(Difficulty diff){
		this.difficulty = diff;

	}

	public void setHours(Hours hours){
		this.hours = hours;
	}
	
}

/*public int getRating(String) {} */
/*public int getTraffic(String) {} */
/*public void viewComments() {}*/

