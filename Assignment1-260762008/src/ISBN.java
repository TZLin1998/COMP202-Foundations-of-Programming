public class ISBN {

	public static void main(String[] args) {
	
		/*
		Tianze Lin 260762008
		*/
	
		//Declaring the variable to represent the ISBN number
        int n = Integer.parseInt(args[0]);

    	//Your code Starts here
	        int d2=n%10;
	        int d3=n/10%10;
	        int d4=n/100%10;
	        int d5=n/1000%10;
			int d1;
			//d1,d2,d3,d4,d5 represent the value of each digit of n.
			d1=0;
			if((d1+2*d2+3*d3+4*d4+5*d5)%11!=0) {
				d1++;
			}
			if((d1+2*d2+3*d3+4*d4+5*d5)%11!=0) {
				d1++;
			}
			if((d1+2*d2+3*d3+4*d4+5*d5)%11!=0) {
				d1++;
			}
			if((d1+2*d2+3*d3+4*d4+5*d5)%11!=0) {
				d1++;
			}
			if((d1+2*d2+3*d3+4*d4+5*d5)%11!=0) {
				d1++;
			}
			if((d1+2*d2+3*d3+4*d4+5*d5)%11!=0) {
				d1++;
			}
			if((d1+2*d2+3*d3+4*d4+5*d5)%11!=0) {
				d1++;
			}
			if((d1+2*d2+3*d3+4*d4+5*d5)%11!=0) {
				d1++;
			}
			if((d1+2*d2+3*d3+4*d4+5*d5)%11!=0) {
				d1++;
			}
			if((d1+2*d2+3*d3+4*d4+5*d5)%11!=0) {
				d1++;
			}
			//Determine the value of d1.
			if (d1<10) {
				System.out.println(d1);
			}
			if (d1>9) {
				System.out.println("X");
			}
			/*If d1 is 10, we need to output X. 
			Otherwise, we can directly output the number.*/
    	//Your code Ends here
	}

}
