import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

// Problem

// A certain bathroom has N + 2 stalls in a single row; the stalls on the left and right ends are permanently occupied by the bathroom guards. 

// The other N stalls are for users. Whenever someone enters the bathroom, they try to choose a stall that is as far from other people as possible. 

// To avoid confusion, they follow deterministic rules: For each empty stall S, they compute two values LS and RS, 

// each of which is the number of empty stalls between S and the closest occupied stall to the left or right, respectively. 

// Then they consider the set of stalls with the farthest closest neighbor, that is, those S for which min(LS, RS) is maximal. 

// If there is only one such stall, they choose it; otherwise, they choose the one among those where max(LS, RS) is maximal. 

// If there are still multiple tied stalls, they choose the leftmost stall among those. K people are about to enter the bathroom; 

// each one will choose their stall before the next arrives. Nobody will ever leave. When the last person chooses their stall S, 

// what will the values of max(LS, RS) and min(LS, RS) be?

public class BathroomStalls {

    public static long[] getResult(long capacity, long people){
        long min, max;
        long result = compute(capacity, people);
        if (result % 2 == 0) {
            min = result/2;
            max = min;
        } else {
            min = (result-1)/2;
            max = (result+1)/2;
        }
        long[] results = {max, min};
        return results;
    }

    public static long compute(long capacity, long people){
        if (people == 1) {
            return capacity - 1;
        } else {
            if (people % 2 == 0) {
                return compute(capacity/2, people/2);
            } else {
                if (capacity % 2 == 0) {
                    return compute(capacity/2 - 1, people/2);
                } else {
                    return compute(capacity/2, people/2);
                }
            }
        }
    }


    public static void main(String[] args) throws FileNotFoundException {
        Scanner r = new Scanner(new File("C-small-1-attempt0.in"));
        PrintStream out = new PrintStream(new FileOutputStream("C-small-1-attempt0.out"));

        int t = r.nextInt();

        for (int i = 1; i <= t; i++) {
            long capacity = r.nextLong();
            long people = r.nextLong();
            long[] results = getResult(capacity, people);
            out.println("Case #" + i + ": " + results[0] + " " + results[1]);
        }
    }
}