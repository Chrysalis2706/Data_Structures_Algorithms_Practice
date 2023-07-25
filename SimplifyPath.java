package Stacks;
import java.util.*;

public class SimplifyPath {

    public static String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        String[] tokens = path.split("/+ ");

        for (int i=0; i<tokens.length; i++){
            if (stack.size() > 0 && stack.peek() == "..") {
                stack.pop();
            }else if (!stack.isEmpty() && (stack.peek() == "." || stack.peek() == "")){
                continue;
            }
            stack.push(tokens[i]);
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()){
            sb.append(stack.pop());
        }

        String ans = sb.reverse().toString();
        if (sb.length() == 0) return "/";
        else return ans;

    }

    public static void main(String[] args) {
        String path = "/home//foo/";
        System.out.println(simplifyPath(path));
    }

}
