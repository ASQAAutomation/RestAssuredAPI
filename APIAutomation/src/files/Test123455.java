package files;

public class Test123455 {
	   /* 
	    *   The class can only be Main
	    */
	  
		public static void main(String []args) {
			String firstname = "AKHILESH";

	        

	        String output = "";
	        for (int i=firstname.length()-1; i>=0;i--){
	            output = output+firstname.charAt(i);

	        }
	        
	        System.out.print(output);
	    }

	}