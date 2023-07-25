package Stacks;

public class Stacks_LL_Operations {
    public static void main(String[] args) {
        Stack_Using_LinkedLists stack = new Stack_Using_LinkedLists();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

        while (!stack.isEmpty()){
            System.out.println("-> "+ stack.peek());
            stack.pop();
        }
    }
}
