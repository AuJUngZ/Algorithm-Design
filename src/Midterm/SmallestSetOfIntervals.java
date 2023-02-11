package Midterm;

import java.util.ArrayList;
public class SmallestSetOfIntervals {
    public static ArrayList<String> smallestSetOfIntervals(double[] x) {
        ArrayList<String> intervals = new ArrayList<String>();
        int start = 0;
        for (int i = 1; i < x.length; i++) {
            if (Math.abs(x[i] - x[start]) == 1.0) {
                intervals.add(x[start] + " " + x[i]);
                start = i + 1;
                i++;
            }else if(Math.abs(x[i] - x[start]) > 1.0){
                intervals.add(x[start] + " " + (x[start]+1));
                start = i;
            }
            if(i == x.length-1){
                intervals.add(x[start] + " " + (x[start]+1));
            }
        }
        return intervals;
    }
}
