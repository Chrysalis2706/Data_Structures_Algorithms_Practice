package Greedy_Algorithm_Problems;

import java.sql.Array;
import java.util.Arrays;
import java.util.Comparator;

public class MaximumUnitsOnATruck {
    public static void main(String[] args) {
        int[][] first = {
                {1,3},
                {2,2},
                {3,1}
        };
        int truckSize1 = 4;

        int[][] second = {
                {5,10},
                {2,5},
                {4,7},
                {3,9}
        };
        int truckSize2 = 10;

        System.out.println(maximumUnits(first, truckSize1));  //8
        System.out.println(maximumUnits(second, truckSize2)); // 91

    }

    public static int maximumUnits(int[][] boxTypes, int truckSize) {
        int ans = 0;

        double[][] ratio = new double[boxTypes.length][2];
        for (int i=0; i< boxTypes.length; i++){
            ratio[i][0] = i;
            ratio[i][1] = boxTypes[i][1]/(double)boxTypes[i][0];
        }

        Arrays.sort(ratio, Comparator.comparingDouble(o -> o[1]));

        for (int i=ratio.length-1; i>=0; i--){
            int index = (int)ratio[i][0];
            if (truckSize >= boxTypes[index][0]){
                ans += boxTypes[index][1];
                truckSize -= boxTypes[index][0];
            }else{
                ans += truckSize * ratio[i][1];
                truckSize = 0;
                break;
            }
        }
        return ans;
    }
}
