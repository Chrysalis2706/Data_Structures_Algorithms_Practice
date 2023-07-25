package Stacks;

import java.util.Stack;

public class DuplicateParanthesis {
    public static void main(String[] args) {
        String exp1 = "((a+b)+(c+d))"; // false
        String exp2 = "((a+b))"; // true
        System.out.println(duplicateParanthesis(exp1));
        System.out.println(duplicateParanthesis(exp2));
    }

    private static boolean duplicateParanthesis(String s) {
        Stack <Character> stack = new Stack<>();
        int n = s.length();
        for (int i=0; i<n; i++){
            char ch = s.charAt(i);
            if (ch == ')'){
                int count = 0;
                while (stack.peek() != '('){
                    count++;
                    stack.pop();
                }
                if (count < 1) return true;
                else stack.pop();
            }else{
                stack.push(ch);
            }
        }
        return false;
    }
}
