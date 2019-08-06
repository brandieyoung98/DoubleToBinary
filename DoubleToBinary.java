public class DoubleToBinary{
 public static void main (String[] args) throws java.lang.Exception{
    	//some miscellaneous test cases
	printBin(72.55); //should produce ERROR
	printBin(72.5); //should produce 1001000.1
	printBin(3.5); //should produce 11.1
	printBin(93838.125); //should produce 10110111010001110.001
  }
  //function to convert a double to binary and print the result
  //first uses integer conversion methods then fractional conversion methods for a clean solution
	public static void printBin(double x){
	  String result = ""; //the string to hold the result
	  int beforeDec = (int) x; //this cast will grab all digits before the decimal
	  String bin = ""; //the string to holde the integer portion--note that it will be little endian format!
	 
    //the process of converting an integer to binary
    while(beforeDec != 0){
		  int rem = beforeDec%2;
		  bin += rem + "";
		  beforeDec = beforeDec/2;
	  }
    
	//converting to big endian to place in our result string
	for(int i = bin.length()-1; i >= 0; i--){
		result += bin.charAt(i);
	}
	
	//and then inserting our decimal place
	result += ".";

	//now to convert the fractional part
	int digitCounter=0;
	double numD = getDecimalOnly(x);
	
	//the process for converting a fraction to binary
	//with the added check that our binary number doesn't have more than 32 places after the decimal
    while(!checkIfInteger(numD) && digitCounter < 32){
        numD = numD * 2.0;
        int n = (int) numD;
        result += n + "";
        numD = getDecimalOnly(numD);
        digitCounter++;
    }
	
	//this prints the number if it didn't get cut off from being too long
    if(!checkIfInteger(numD)){
        System.out.println("ERROR");
    }
    else{
    	System.out.println(result);
    }
}

	//helper method to check if our double is actually an integer number
    public static boolean checkIfInteger(double x){
        int temp = (int)x;
        double tempCheck = (double)temp;
        if(tempCheck == x){
            return true;
        }
        else{
            return false;
        }
    }
	
	//helper method to just get the fractional part of a number
    public static double getDecimalOnly(double x){
        String frac = Double.toString(x).substring(Double.toString(x).indexOf('.'));
	 String num = "0" + frac;
	 return Double.parseDouble(num);
    }
    
}
