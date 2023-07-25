package Greedy_Algorithm_Problems;
import java.util.*;

public class ActivitySelection {

    public static void main(String[] args) {
        int[] start = {1, 3, 0, 5, 8, 5};
        int[] end =   {2, 4, 6, 7, 9, 9};

        avtivitySelection(start, end);
    }

    private static void avtivitySelection(int[] start, int[] end) {
        // check if the end is sorted (if not sorted do this)
        int[][] activities = new int[start.length][3];
        for (int i=0; i<start.length; i++){
            activities[i][0] = i; // index storing
            activities[i][1] = start[i]; // start time storing
            activities[i][2] = end[i]; // end time storing
        }
        Arrays.sort(activities, Comparator.comparingDouble(o -> o[2]));  //sorted according to end column

        ArrayList<Integer> order = new ArrayList<>();

        int maxAct = 1;
//        int s = activities[0][1];
        int e = activities[0][2];
        order.add(0); // storing index in arraylist

        for (int i=1; i<end.length; i++){
            if (activities[i][1] >= e){
                maxAct += 1;
                order.add(i);
                e = activities[i][2];
            }
        }

        System.out.println("Maximum number of activities : " + maxAct);
        for (int i=0; i<order.size(); i++){
            System.out.print("A"+ order.get(i) + " -> ");
        }
        System.out.print("End");

    }
}
