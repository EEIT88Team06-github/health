package org.iiiedu.eeit88.health.recommand.service;





public class BMICalculateService {


//	public String functionBMI(int id){  //回傳過輕/適中/過胖
	public String functionBMI(float height,float weight,String gender){  //回傳過輕/適中/過胖
		String result = null;
		
		
//		if(){  //有登入字串
//			height = member.select(id).getHeight();
//			weight = member.select(id).getWeights();
//			gender = member.select(id).getGender();
//		}else if(){  //沒登入字串
//			height = //從表單取回來的值
//			weight = //從表單取回來的值
//			gender = //從表單取回來的值
//		}

		float bmi = weight / ((height / 100) * (height / 100));
		
	
		if(gender.equals("男")){  //男生M
			if (bmi < 20) {
				result = "過輕";
			} else if (bmi >= 20 && bmi <= 25) {
				result = "適中";
			} else if (bmi > 25) {
				result = "過胖";
			}
		}else if(gender.equals("女")){  //女生F
			if (bmi < 18) {
				result = "過輕";
			} else if (bmi >= 18 && bmi <= 22) {
				result = "適中";
			} else if (bmi > 23) {
				result = "過胖";
			}
		}	
		return result;
	}
	
	
	//for test
	public static void main(String[] args) {
		BMICalculateService service = new BMICalculateService();

	}

}
