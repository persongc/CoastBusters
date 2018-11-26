package coastbusters;

public class Access {
	
	private Boolean bike;
	private Boolean pass;
	private Boolean dog;
	private Boolean horse;

	public Access(Boolean bike, Boolean pass, Boolean dog, Boolean horse){
		this.bike = bike;
		this.pass = pass;
		this.dog = dog;
		this.horse = horse;
	}

	public Boolean getBike(){
		return bike;
	}

	public Boolean getPass(){
		return pass;
	}

	public Boolean getDog(){
		return dog;
	}

	public Boolean getHorse(){
		return horse;
	}
}
