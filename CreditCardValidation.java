import java.util.Scanner;

//declare class
public class CreditCardValidation {
	
	//main
    public static void main(String[] args) {
		//scanner class
        Scanner input = new Scanner(System.in);
		//long variable declaration
		long cardNumber;
		
		//add prompt 
        System.out.print("Enter a credit card number as a long integer: ");
        long cardNumber = input.nextLong();
        
		//calling isValid
        if (isValid(cardNumber)) {
            System.out.println(cardNumber + " is valid");
        } 
		else{
            System.out.println(cardNumber + " is invalid");
        }
    }
//end main
//begin boolean method to check validity
    public static boolean isValid(long number) {
        int total = sumOfDoubleEvenPlace(number) + sumOfOddPlace(number);
        return (total % 10 == 0) && (getSize(number) >= 13 && getSize(number) <= 16) &&
               (prefixMatched(number, 4) || prefixMatched(number, 5) ||
                prefixMatched(number, 37) || prefixMatched(number, 6));
    }
//sum for double even places
    public static int sumOfDoubleEvenPlace(long number) {
        int sum = 0;
        String numStr = Long.toString(number);
        
        for (int i = numStr.length() - 2; i >= 0; i -= 2) {
            int digit = Integer.parseInt(Character.toString(numStr.charAt(i)));
            sum += getDigit(2 * digit);
        }
        //returns sum
        return sum;
    }
//end of even sum

//getDigit method
    public static int getDigit(int number) {
        if (number < 10) {
            return number;
        } else {
            return (number % 10) + (number / 10);
        }
    }
//end of getDigit

//sum of odd digits in card 
    public static int sumOfOddPlace(long number) {
        int sum = 0;
        String numStr = Long.toString(number);
        
        for (int i = numStr.length() - 1; i >= 0; i -= 2) {
            int digit = Integer.parseInt(Character.toString(numStr.charAt(i)));
            sum += digit;
        }
        
        return sum;
    }
//end of method

//prefixMatched method
    public static boolean prefixMatched(long number, int d) {
        return getPrefix(number, getSize(d)) == d;
    }

    public static int getSize(long d) {
        return Long.toString(d).length();
    }

    public static long getPrefix(long number, int k) {
        if (getSize(number) < k) {
            return number;
        } else {
            String numStr = Long.toString(number);
            return Long.parseLong(numStr.substring(0, k));
        }
    }
}
//end of method
