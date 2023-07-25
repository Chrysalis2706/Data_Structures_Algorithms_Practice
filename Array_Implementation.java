package Queue;

public class Array_Implementation {

    public static class Queue{
        static int size;
        static int[] arr;
        static int rear;

        public Queue(int n){
            arr = new int[n];
            size = n;
            rear = -1;
        }

        // Empty function
        public static boolean isEmpty(){
            return rear == -1;
        }

        // add at end
        public static void add(int data){
            if (rear == size-1){
                System.out.println("Full Queue!");
                return;
            }
            rear = rear + 1;
            arr[rear] = data;
        }

        // remove from front
        public static int remove(){
            if (isEmpty()){
                return -1;
            }

            int front = arr[0];
            for (int i=0; i<rear; i++){
                arr[i] = arr[i+1];
            }
            rear = rear-1;
            return front;
        }

        // peek the first element
        public static int peek(){
            if (isEmpty()) return -1;

            return arr[0];
        }

        // display
        public static void display(){
            if (isEmpty()) {
                System.out.println("Empty Queue");
                return;
            }
            System.out.print("front -> ");
            for (int i=0; i<=rear; i++){
                System.out.print(arr[i] + " -> ");
            }
            System.out.print("End");
        }
    }

    public static void main(String[] args) {
        int n = 5;
        Queue que = new Queue(n);

        que.display();

        que.add(1);
        que.add(2);
        que.add(3);
        que.add(4);
        que.add(5);
        que.add(6); // full queue

        que.display();
    }
}
