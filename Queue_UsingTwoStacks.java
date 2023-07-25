package Queue;

import java.util.Stack;

public class Queue_UsingTwoStacks {
    public static class QueueStack{

        static Stack<Integer> s1 = new Stack<>();
        static Stack<Integer> s2 = new Stack<>();
        
        // empty check
        public static boolean isEmpty(){
            return s1.isEmpty();
        }

        // add
        public static void add(int data){
            while (!s1.isEmpty()){
                s2.push(s1.pop());
            }

            s1.push(data);

            while(!s2.isEmpty()){
                s1.push(s2.pop());
            }
        }

        // remove
        public static int remove(){
            if (s1.isEmpty()){
                System.out.println("Queue is empty");
                return -1;
            }

            return s1.pop();
        }

        // peek
        public static int peek(){
            if (s1.isEmpty()){
                System.out.println("Queue is empty");
                return -1;
            }
            return s1.peek();
        }
    }

    public static void main(String[] args) {
        QueueStack que1 = new QueueStack();

        que1.add(1);
        que1.add(2);
        que1.add(3);
        que1.add(4);
        que1.add(5);

        System.out.print("start -> ");
        while (!que1.isEmpty()){
            System.out.print(que1.peek() + " ");
            que1.remove();
        }
        System.out.print("-> end");

    }
}
