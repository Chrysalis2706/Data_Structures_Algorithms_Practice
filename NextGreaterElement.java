package Stacks;

import java.util.Stack;

public class NextGreaterElement {

    public static void main(String[] args) {
        int[] arr = {6,8,0,1,3};
        int[] ans = nextGreater(arr);
        for (int i=0; i<arr.length; i++){
            System.out.print(ans[i] + " ");
        }
     }

    public static int[] nextGreater(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int n = arr.length;
        int[] ans = new int[n];
        for (int i=n-1; i>=0; i--){
            int curr = arr[i];
            while (!stack.isEmpty() && curr >= arr[stack.peek()]){
                stack.pop();
            }
            if (stack.isEmpty()) {
                ans[i] = -1;
            }else {
                ans[i] = arr[stack.peek()];
            }
            stack.push(i);
        }
        return ans;
    }
}
