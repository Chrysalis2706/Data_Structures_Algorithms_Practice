package Stacks;

import java.util.Stack;

public class Stock_Span_Problem {

    public static void main(String[] args) {
        int[] stock = {100, 80, 60, 70, 60, 85, 100};
        int[] span = new int[stock.length];

        stock_span(stock, span);

        for (int i=0; i< span.length; i++){
            System.out.print(span[i] + " ");
        }
    }

    public static void stock_span(int[] stock, int[] span) {
        Stack<Integer> stack = new Stack<>();
        span[0] = 1;
        stack.push(0);

        for (int i = 1; i< stock.length; i++){
            int curr = stock[i];
            while (!stack.isEmpty() && curr > stock[stack.peek()]){
                stack.pop();
            }
            if (stack.isEmpty()){
                span[i] = i+1;
            }else{
                int prevHighIndex = stack.peek();
                span[i] =  i - prevHighIndex;
            }
            stack.push(i);
        }
    }
}
