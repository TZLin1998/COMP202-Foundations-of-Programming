public class JudgeScore {
	public static void main(String[] args) {
	
		/*
		Tianze Lin 260762008
		*/	
	
		//Declaring the variables for storing the judges scores.
		int judge1, judge2, judge3, judge4;
		judge1 = Integer.valueOf(args[0]);
		judge2 = Integer.valueOf(args[1]);
		judge3 = Integer.valueOf(args[2]);
		judge4 = Integer.valueOf(args[3]);
		
		//Your code Starts here
		int a;
		int b;
		if(judge1>=judge2&&judge1>=judge3&&judge1>=judge4) {
			if(judge2>=judge4&&judge3>=judge4) {
				 a=judge3;
				 b=judge2;
				 double averageScore=(a+b)/2.0;
				 System.out.println(averageScore);
			}else if(judge2>=judge3&&judge4>=judge3) {
				 a=judge4;
				 b=judge2;
				 double averageScore=(a+b)/2.0;
				 System.out.println(averageScore);
			}else{
				 a=judge3;
				 b=judge4;
				 double averageScore=(a+b)/2.0;
				 System.out.println(averageScore);
			}
		}else if(judge2>=judge1&&judge2>=judge3&&judge2>=judge4) {
			if(judge3>=judge1&&judge4>=judge1) {
				 a=judge3;
				 b=judge4;
				 double averageScore=(a+b)/2.0;
				 System.out.println(averageScore);
			}else if(judge1>=judge3&&judge4>=judge3) {
				 a=judge4;
				 b=judge1;
				 double averageScore=(a+b)/2.0;
				 System.out.println(averageScore);
			}else{
				 a=judge3;
				 b=judge1;
				 double averageScore=(a+b)/2.0;
				 System.out.println(averageScore);
			}
		}else if(judge3>=judge2&&judge3>=judge1&&judge3>=judge4) {
			if(judge2>=judge1&&judge4>=judge1) {
				 a=judge4;
				 b=judge2;
				 double averageScore=(a+b)/2.0;
				 System.out.println(averageScore);
			}else if(judge1>=judge2&&judge4>=judge2) {
				 a=judge4;
				 b=judge1;
				 double averageScore=(a+b)/2.0;
				 System.out.println(averageScore);
			}else{
				 a=judge1;
				 b=judge2;
				 double averageScore=(a+b)/2.0;
				 System.out.println(averageScore);
			}
		}else{
			if(judge2>=judge1&&judge3>=judge1) {
				 a=judge3;
				 b=judge2;
				 double averageScore=(a+b)/2.0;
				 System.out.println(averageScore);
			}else if(judge1>=judge2&&judge3>=judge2) {
				 a=judge1;
				 b=judge3;
				 double averageScore=(a+b)/2.0;
				 System.out.println(averageScore);
			}else{
				 a=judge1;
				 b=judge2;
				 double averageScore=(a+b)/2.0;
				 System.out.println(averageScore);
			}
		}
		
		
		//Your code Ends here
		
	}
}