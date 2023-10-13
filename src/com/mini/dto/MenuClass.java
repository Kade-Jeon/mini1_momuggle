package com.mini.dto;

public class MenuClass {
	
	private String rName;
	private String mName;
	private String mCat;
	private int wTime;
	private int mPrice;
	private int vPrice;
	

	public MenuClass() {
		
	}
	
	public void setrName(String rName) {
		this.rName = rName;
	}

	public void setmName(String mName) {
		this.mName = mName;
	}

	public void setmCat(String mCat) {
		this.mCat = mCat;
	}

	public void setwTime(int wTime) {
		this.wTime = wTime;
	}

	public void setmPrice(int mPrice) {
		this.mPrice = mPrice;
	}

	public void setvPrice(int vPrice) {
		this.vPrice = vPrice;
	}


	public String getrName() {
		return rName;
	}

	public String getmName() {
		return mName;
	}

	public String getmCat() {
		return mCat;
	}

	public int getwTime() {
		return wTime;
	}

	public int getmPrice() {
		return mPrice;
	}

	public int getvPrice() {
		return vPrice;
	}

	public MenuClass(String rName, String mName, String mCat, int wTime, int mPrice) {
		this.rName = rName;
		this.mName = mName;
		this.mCat = mCat;
		this.wTime = wTime;
		this.mPrice = mPrice;
	}

	@Override
	public String toString() {
		return "MenuClass [rName=" + rName + ", mName=" + mName + ", mCat=" + mCat + ", wTime=" + wTime + ", mPrice="
				+ mPrice + "]";
	}
	
}
