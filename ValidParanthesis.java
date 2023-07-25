package Stacks;

import java.util.Stack;

public class ValidParanthesis {

    public static void main(String[] args) {
        String s = "()[]{}";
        System.out.println(validParanthesis(s));
    }

    public static boolean validParanthesis(String s) {
        int n = s.length();
        if (n == 1) return true;
        Stack<Character> stack = new Stack<>();
        for (int i=0; i<n; i++){
            char curr = s.charAt(i);
            if (curr == '(' || curr == '{' || curr == '['){
                stack.push(curr);
            }else{
                if (stack.isEmpty()) return false; //"))))"
                if ((curr == ')' && stack.peek() == '(')  ||
                        (curr == '}' && stack.peek() == '{') ||
                        (curr == ']' && stack.peek() == '[')) {
                    stack.pop();
                }else{
                    return false;
                }
            }
         }

        return stack.isEmpty();
    }
}
