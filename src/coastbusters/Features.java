package coastbusters;

public class Features {

	public Boolean waterfall;
	public Boolean viewpoint;
		//public Object picture. not sure how it works in java :P

	public Features(Boolean waterfall, Boolean viewpoint){
		this.waterfall = waterfall;
		this.viewpoint = viewpoint;
	}

	public Boolean getWaterfall(){
		return waterfall;
	}

	public Boolean getViewpoint(){
		return viewpoint;
	}
}
