package org.iiiedu.eeit88.health.sport.model;

import java.io.Serializable;

//封裝了跑圖表需要的時間跟熱量總和，不會存進資料庫
public class ConsumeChartBean implements Serializable {
	private String date;
	private Float calories;
	
	public ConsumeChartBean(){
		
	}
	public ConsumeChartBean(String date,Float calories){
		this.date = date;
		this.calories = calories;
	}
		
	@Override
	public String toString() {
		return "ConsumeChartBean [date=" + date + ", calories=" + calories + "]";
	}
	
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public Float getCalories() {
		return calories;
	}
	public void setCalories(Float calories) {
		this.calories = calories;
	}
	
	
}
