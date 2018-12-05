package logic;

public class Features {

	private Boolean waterfall;
	private Boolean viewpoint;

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
