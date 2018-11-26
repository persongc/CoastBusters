package coastbusters;

public class Difficulty {
	
	private double length; /* in miles, roundtrip */
	private double elevGain; /* in feet */
	private double diffRating; /* in scale of 1 - 5 */

	public Difficulty(double length, double elevGain, double diff){
		this.length = length;
		this.elevGain = elevGain;
		this.diffRating = diff;
	}

	public double getLength(){
		return length;
	}

	public double getElevGain(){
		return elevGain;
	}

	public double getDiffRating(){
		return diffRating;
	}
}
