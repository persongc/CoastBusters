package coastbusters;

public class Difficulty {
	
	public double length; /* in miles, roundtrip */
	public double elevGain; /* in feet */
	public double diffRating; /* in scale of 1 - 5 */

	public Difficulty(double length, double elevGain, double diff){
		this.length = length;
		this.elevGain = elevGain;
		this.diffRating = diff;
	}

}
