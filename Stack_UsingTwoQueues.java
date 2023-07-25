package Queue;

import java.util.LinkedList;
import java.util.Queue;

public class Stack_UsingTwoQueues {

    private static class Stackmaker {
        static Queue<Integer> q1 = new LinkedList<>();
        static Queue<Integer> q2 = new LinkedList<>();

        // empty stack
        private static boolean isEmpty() {
            return q1.isEmpty() && q2.isEmpty();
        }

        // push
        private static void push(int data) {
            if (!q1.isEmpty()) {
                q1.add(data);
            } else {
                q2.add(data);
            }
        }

        // pop
        private static int pop() {
            if (isEmpty()) {
                System.out.println("Empty queue");
                return -1;
            }

            int top = -1;
            if (!q1.isEmpty()) {
                while (!q1.isEmpty()) {
                    top = q1.remove();
                    if (q1.isEmpty()) break;
                    q2.add(top);
                }
            } else {
                while (!q2.isEmpty()) {
                    top = q2.remove();
                    if (q2.isEmpty()) break;
                    q1.add(top);
                }
            }

            return top;
        }

        private static int peek(){
            if (isEmpty()) {
                System.out.println("Empty queue");
                return -1;
            }

            int top = -1;
            if (!q1.isEmpty()) {
                while (!q1.isEmpty()) {
                    top = q1.remove();
//                    if (q1.isEmpty()) break;
                    q2.add(top);
                }
            } else {
                while (!q2.isEmpty()) {
                    top = q2.remove();
//                    if (q2.isEmpty()) break;
                    q1.add(top);
                }
            }

            return top;
        }

    }

    public static void main(String[] args) {
        Stackmaker stack1 = new Stackmaker();
        stack1.push(1);
        stack1.push(2);
        stack1.push(3);
        stack1.push(4);

        while (!stack1.isEmpty()){
            System.out.print(stack1.peek() + " ");
            stack1.pop();
        }

    }
}
