package Greedy_Algorithm_Problems;

import java.util.*;

public class FractionalKnapsack {
    public static void main(String[] args) {
        int[] val = {60, 100, 120};
        int[] weight = {10, 20, 30};
        int W = 50;
        System.out.println(fractionalKnapsack(val, weight, W));
    }

    private static int fractionalKnapsack(int[] val, int[] weight, int W) {
        int ans = 0;

        double[][] ratios = new double[val.length][2];
        for (int i=0; i< ratios.length; i++){
            ratios[i][0] = i;
            ratios[i][1] = val[i]/(double)weight[i];
        }

        // sorting the array in ascending order
        Arrays.sort(ratios, Comparator.comparingDouble(o -> o[1]));

        //to get max ratio first loop reverse
        for (int i=ratios.length-1; i>=0; i--){
            int index = (int)ratios[i][0];
            if (W >= weight[index]){
                ans += val[index];
                W -= weight[index];
            }else{
                ans += ratios[i][1] * W;
                W = 0;
                break;
            }
        }

        return ans;
    }
}
