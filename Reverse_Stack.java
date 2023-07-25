package Stacks;

import java.util.*;

public class Reverse_Stack {

    public static void pushAtBottom(Stack<Integer> stack, int data){
        if (stack.isEmpty()) {
            stack.push(data);
            return;
        }
        int top = stack.pop();
        pushAtBottom(stack, data);
        stack.push(top);
    }

    public static void reverseStack(Stack<Integer> stack){
        if (stack.isEmpty()) return;

        int top = stack.pop();
        reverseStack(stack);
        pushAtBottom(stack, top);
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        while (!stack.isEmpty()){
            System.out.println("-> "+ stack.peek());
            stack.pop();
        }

        System.out.println("\nReverse Stack");

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        reverseStack(stack);

        while (!stack.isEmpty()){
            System.out.println("-> "+ stack.peek());
            stack.pop();
        }


    }

}
