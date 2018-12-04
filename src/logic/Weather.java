package logic;

public class Weather {
    private String URL;
    private String forecast;
    private String currTemp;
    private String high;
    private String low;
    private String wind;

    public Weather(String url){
        this.URL = url;
    }

    public String getURL() {
        return URL;
    }

    public String getForecast() {
        return forecast;
    }

    public void setForecast(String forecast) {
        this.forecast = forecast;
    }

    public String getCurrTemp() {
        return currTemp;
    }

    public void setCurrTemp(String currTemp) {
        this.currTemp = currTemp;
    }

    public String getHigh() {
        return high;
    }

    public void setHigh(String high) {
        this.high = high;
    }

    public String getLow() {
        return low;
    }

    public void setLow(String low) {
        this.low = low;
    }

    public String getWind() {
        return wind;
    }

    public void setWind(String wind) {
        this.wind = wind;
    }
}
