package Stacks;

public class ArrayList_Operations {
    public static void main(String[] args) {
        Stacks_BluePrint_ArrayList stack = new Stacks_BluePrint_ArrayList();


        stack.push(1);
        stack.push(2);
        stack.push(3);

        while(stack.isEmpty() == false){
            System.out.print(stack.peek() + " ");
            stack.pop();
        }

    }
}
