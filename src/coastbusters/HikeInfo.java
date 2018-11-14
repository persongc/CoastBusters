package coastbusters;

import java.util.ArrayList;

public class HikeInfo //should make use of weather and reviews class
{
	private String name;
	private ArrayList<Object> hours;
	private Boolean bathrooms;
	private Boolean water;
	private int avgTraffic;
	private String location;
	
	/*public int getRating(String) {} */
	/*public int getTraffic(String) {} */
	/*public void viewComments() {}*/
	
	private class Access
	{
		public Boolean bike;
		public Boolean pass;
		public Boolean pet;
		public Boolean horse;
		public Boolean vehicle;
	}
	
	private class Hours
	{
		public String day;
		public String open;
		public String close;
	}
	
	private class Difficulty
	{
		public int length;
		public int elevGain;
		public int diffRating;
	}
	
	private class Features
	{
		public Boolean waterfall;
		public Boolean viewpoint;
		//public Object picture. not sure how it works in java :P
	}
}
