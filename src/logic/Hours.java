package logic;

public class Hours {
	private String open; /* opening time */
	private String close; /* closing time */
	private double time; /* estimated completion time */

	public Hours(String open, String close, double time){
		this.open = open;
		this.close = close;
		this.time = time;
	}

	public String getOpen(){
		return open;
	}

	public String getClose(){
		return close;
	}

	public double getTime(){
		return time;
	}
}
