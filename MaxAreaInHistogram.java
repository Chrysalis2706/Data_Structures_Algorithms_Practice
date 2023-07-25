package Stacks;
import java.util.*;

public class MaxAreaInHistogram {
    public static int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        Stack<Integer> stack1 = new Stack<>();
        int n = heights.length;
        // next smaller right
        int[] nsr = new int[n];
        for (int i=n-1;i>=0;i--){
            int curr = heights[i];
            while (!stack1.isEmpty() && curr <= heights[stack1.peek()]){
                stack1.pop();
            }
            if(stack1.isEmpty()) {
                nsr[i] = n;
            }else{
                nsr[i] = stack1.peek();
            }
            stack1.push(i);
        }

        Stack<Integer> stack2 = new Stack<>();
        // next smaller left
        int[] nsl = new int[n];
        for (int i=0;i<n;i++){
            int curr = heights[i];
            while (!stack2.isEmpty() && curr <= heights[stack2.peek()]){
                stack2.pop();
            }
            if(stack2.isEmpty()) {
                nsl[i] = -1;
            }else{
                nsl[i] = stack2.peek();
            }
            stack2.push(i);
        }

        // current area calculation
        for (int i=0; i<n; i++){
            int h = heights[i];
            int w = nsr[i] - nsl[i] - 1;
            int currArea = h * w;
            maxArea = Math.max(maxArea, currArea);
        }


        return maxArea;
    }

    public static void main(String[] args) {
        int[] arr = {2,1,5,6,2,3};
        System.out.println(largestRectangleArea(arr));
    }
}
