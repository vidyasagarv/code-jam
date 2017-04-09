import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

// Problem

// Last year, the Infinite House of Pancakes introduced a new kind of pancake. 

// It has a happy face made of chocolate chips on one side (the "happy side"), 

// and nothing on the other side (the "blank side"). You are the head cook on duty. 

// The pancakes are cooked in a single row over a hot surface. As part of its infinite 

// efforts to maximize efficiency, the House has recently given you an oversized pancake 

// flipper that flips exactly K consecutive pancakes. That is, in that range of K pancakes, 

// it changes every happy-side pancake to a blank-side pancake, and vice versa; 

// it does not change the left-to-right order of those pancakes. 

// You cannot flip fewer than K pancakes at a time with the flipper, 

// even at the ends of the row (since there are raised borders on both sides of the cooking surface). 

// For example, you can flip the first K pancakes, but not the first K - 1 pancakes.

// Your apprentice cook, who is still learning the job, just used the old-fashioned 

// single-pancake flipper to flip some individual pancakes and then ran to the restroom with it, 

// right before the time when customers come to visit the kitchen. You only have the oversized pancake flipper left, 

// and you need to use it quickly to leave all the cooking pancakes happy side up, so that the customers leave feeling happy with their visit.

// Given the current state of the pancakes, calculate the minimum number of uses of the oversized pancake flipper 

// needed to leave all pancakes happy side up, or state that there is no way to do it.


public class OversizedPancakeFlipper {

	public static int pancakeFlipper(String pancakeStack, int numOfPancakes) {
		
		//char[] pancakes = pancakeStack.toCharArray();
		int count = 0;
		StringBuilder pancakes = new StringBuilder(pancakeStack);

		for (int i = pancakes.length() - numOfPancakes; i>=0; --i){
            if (pancakes.charAt(i + numOfPancakes - 1) == '-'){
                for (int j = i; j < i + numOfPancakes; ++j){
                    if (pancakes.charAt(j) == '-')
                        pancakes.setCharAt(j, '+');
                    else{
                        pancakes.setCharAt(j, '-');     
                    }
                    
                }
                count++;
            }
        }
        for (int j = 0; j < pancakes.length(); ++j){
            if (pancakes.charAt(j) == '-'){
                count = -1;
                break;
            }
        }
		return count;
	}
	


    public static void main(String[] args) throws FileNotFoundException {
        Scanner r = new Scanner(new File("A-large.in"));
        PrintStream out = new PrintStream(new FileOutputStream("A-large.out"));

        int t = r.nextInt();
        r.nextLine();
        int result = 0;
        String defaultResult = "IMPOSSIBLE";

        for(int i = 1; i <= t; i++){
            String line = r.nextLine();
            String[] words = line.split(" ");
            String pancakeStack = words[0];
            int numOfPancakes = Integer.parseInt(words[1]);
            result = pancakeFlipper(pancakeStack, numOfPancakes);
            if(result >= 0){
            	out.println("Case #" + i + ": " + result);
            } else{
            	out.println("Case #" + i + ": " + defaultResult);
            }
        }
    }
}