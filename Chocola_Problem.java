package Greedy_Algorithm_Problems;

import java.util.*;

public class Chocola_Problem {

    public static void main(String[] args) {
        int[] costVer = {4, 3, 2, 1, 1};
        int[] costHor = {4, 2, 1};

        System.out.println(chocola(costHor, costVer));
    }

    public static int chocola(int[] costHor, int[] costVer) {
        int ans = 0;

        // Sort in descending order
        Arrays.sort(costHor);
        int start = 0;
        int end = costHor.length-1;
        while (start <= end){
            int temp = costHor[start];
            costHor[start] = costHor[end];
            costHor[end] = temp;
            start++;
            end--;
        }

        Arrays.sort(costVer);
        start = 0;
        end = costVer.length-1;
        while (start <= end){
            int temp = costVer[start];
            costVer[start] = costVer[end];
            costVer[end] = temp;
            start++;
            end--;
        }

        // get greedy about maximum cost slice first
        int h = 0, v = 0;
        int hp = 1, vp = 1;
        while (h < costHor.length && v < costVer.length){
            if (costHor[h]<=costVer[v]){
                ans += costVer[v] * hp;
                v++;
                vp++;
            }else{
                ans += costHor[h] * vp;
                h++;
                hp++;
            }
        }

        // left elements in arrays
        while (h < costHor.length){
            ans += costHor[h] * vp;
            h++;
            hp++;
        }

        while(v < costVer.length){
            ans += costVer[v] * hp;
            v++;
            vp++;
        }

        return ans;
    }
}
