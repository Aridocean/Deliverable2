import java.util.Scanner;
import java.util.stream.*;

public class MessageEncoder {

	public static void main(String[] args) {
		
		int Checksum;
		String input = null; 
		String message = "";  
		
		Scanner scnr = new Scanner(System.in);
		
		System.out.print("What is your message? ");
		
		input = scnr.nextLine();//scanner input
		
		String inputUpperCase = input.toUpperCase(); // Here we converted the string input to inputUpperCase
		
		
		
		String valueAscii = "";  // This loop computes the inputUpperCase string out into encoded numbers
		for (int i = 0; i < inputUpperCase.length(); ++i) { // but need to convert to Int[] to add together for checksum
		    char Ascii = inputUpperCase.charAt(i);
		    if (!valueAscii.isEmpty()) {
		        valueAscii += ",";// took out - to enable for string split into array 
		    }
		    int n = (int)Ascii; // - (int)'A' + 1; //since solving for upperCase I added 1 to each capital A
		    valueAscii += String.valueOf(n);
		}
		
		
	
		    String[] stringAscii = valueAscii.split(","); // here we split the string
		  
		    
		    
		    int[] numbersAscii = new int[stringAscii.length]; // Here the String Array was parseInt into a Integer Array
		    for(int i = 0;i < stringAscii.length;i++)
		    {
		    numbersAscii[i] = Integer.parseInt(stringAscii[i]);
		    }                                
		    

		    int checksum = IntStream.of(numbersAscii).sum(); // The Integer Array is then summed together through a Stream plugin for the Checksum
		 
		
		for (int i = 0; i < inputUpperCase.length(); ++i) {  //This loop enabled us to take the converted input from uppercase and translate it to the code
		    char ch = inputUpperCase.charAt(i);              // We have uppercase A starting at the value of 1, Z ending at 
		    if (!message.isEmpty()) {
		        message += "-";
		    }
		    int n = (int)ch - (int)'A' + 1; //since solving for upperCase I added 1 to each capital A  //A has a Ascii value of 65
		    message += String.valueOf(n);
		}
			
		
		System.out.println(message);
		System.out.println(checksum);
		
		
		
	}

}
