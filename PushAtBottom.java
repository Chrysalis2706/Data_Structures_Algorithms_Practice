package Stacks;

import java.util.*;

public class PushAtBottom {

    public static void pushAtBottom(Stack<Integer> stack, int data){

        if (stack.isEmpty()){
            stack.push(data);
            return;
        }

        // store top values
        int top = stack.pop();
        // recursion till empty stack and add element
        pushAtBottom(stack, data);
        // push top elements in the same order
        stack.push(top);
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

        while(!stack.isEmpty()){
            System.out.println("-> " + stack.peek());
            stack.pop();
        }

        System.out.println("\nPush At Bottom");

        pushAtBottom(stack, 10);

        while(!stack.isEmpty()){
            System.out.println("-> " + stack.peek());
            stack.pop();
        }

    }
}
