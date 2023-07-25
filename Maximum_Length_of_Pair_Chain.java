package Greedy_Algorithm_Problems;

import java.util.Arrays;
import java.util.*;

public class Maximum_Length_of_Pair_Chain {
    public static int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, Comparator.comparingDouble(o -> o[1]));

        int chainEnd = pairs[0][1];
        int chainLen = 0;
        for (int i=1; i<pairs.length; i++){
            if (pairs[i][0] >= chainEnd ){
                chainLen++;
                chainEnd = pairs[i][1];
            }
        }

        return chainLen;
    }

    public static void main(String[] args) {
        int[][] pairs = {
                {1,2},
                {3,4},
                {4,5}
        };
        System.out.println(findLongestChain(pairs));
    }
}
