import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.math.BigInteger;

// Problem

// Tatiana likes to keep things tidy. Her toys are sorted from smallest to largest, 

// her pencils are sorted from shortest to longest and her computers from oldest to newest. 

// One day, when practicing her counting skills, she noticed that some integers, 

// when written in base 10 with no leading zeroes, have their digits sorted in non-decreasing order. 

// Some examples of this are 8, 123, 555, and 224488. She decided to call these numbers tidy. 

// Numbers that do not have this property, like 20, 321, 495 and 999990, are not tidy.

// She just finished counting all positive integers in ascending order from 1 to N. 

// What was the last tidy number she counted?

public class TidyNumbers {

    public static BigInteger lastTidyNumber(BigInteger input){
        // base case with single digit
        if(input.compareTo(new BigInteger("10"))== -1) return input;

        String number = String.valueOf(input);
        char[] digits = number.toCharArray();

        int b = 0;
        while(b < digits.length-1 )
        {
            int currentNum = Character.getNumericValue(digits[b]);
            int nextNum = Character.getNumericValue(digits[b+1]);
            if(currentNum > nextNum) break;
            b++;
        }
        if(b == digits.length-1) return input;

        while(b > 0){

            int currentNum = Character.getNumericValue(digits[b]);
            int prevNum = Character.getNumericValue(digits[b-1]);
            if( currentNum != prevNum ) break;
            b--;
        }

        digits[b] = (char) (Character.getNumericValue(digits[b]) +47);
        for(int i = b+1; i < digits.length; i++) digits[i] = '9';
        return new BigInteger(new String(digits));
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner r = new Scanner(new File("B-small.in"));
        PrintStream out = new PrintStream(new FileOutputStream("B-small.out"));

        int t = r.nextInt();

        for(int i = 1; i <= t; i++){
            BigInteger n = r.nextBigInteger();
            out.println("Case #" + i + ": " + lastTidyNumber(n));
        }
    }

}