package Greedy_Algorithm_Problems;

import java.util.Arrays;

public class MInimunAbsoluteSumPairs {
    public static int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
        int ans = 0;

        Arrays.sort(nums1);
        Arrays.sort(nums2);


        for (int i=0; i<nums1.length; i++){
            ans += Math.abs(nums1[i]-nums2[i]);
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] nums1 = {4,1,8,7};
        int[] nums2 = {2,3,6,5};
        System.out.println(minAbsoluteSumDiff(nums1, nums2));
    }
}
