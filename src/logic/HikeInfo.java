package logic;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class HikeInfo //should make use of weather and reviews class
{
	private String name;
	private Boolean bathrooms;
	private Boolean water;
	private String location;
	private Access access;
	private Difficulty difficulty;
	private Hours hours;
	private ImageView imageView;
	private Weather weather;

	public HikeInfo(){
		this.name = "Invalid";
	}

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

	public void setHours(Hours hours){
		this.hours = hours;
	}

	public Hours getHours(){
		return hours;
	}

	public void setImage(String image){
		Image imageTemp = new Image(getClass().getResourceAsStream(image));

		this.imageView = new ImageView(imageTemp);
	}

	public ImageView getImageView(){
		return imageView;
	}

	public void setWeather(Weather weather){
		this.weather = weather;
	}

	public Weather getWeather(){
		return weather;
	}
}