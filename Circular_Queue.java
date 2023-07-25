//package Queue;
//
//public class Circular_Queue {
//
//    public static class Queue{
//        static int size;
//        static int[] arr;
//        static int rear;
//        static int front;
//
//        public Queue(int n){
//            arr = new int[n];
//            size = n;
//            rear = -1;
//            front = -1;
//        }
//
//        // Empty function
//        public static boolean isEmpty(){
//            return rear == -1 && front == -1;
//        }
//
//        // Full function
//        public static boolean isFull(){
//            return (rear+1)%size == front;
//        }
//
//        // add at end
//        public static void add(int data){
//            if (isFull()){
//                System.out.println("Full Queue!");
//                return;
//            }
//            rear = (rear + 1)%size;
//            arr[rear] = data;
//        }
//
//        // remove from front
//        public static int remove(){
//            if (isEmpty()){
//                return -1;
//            }
//
//            int start = arr[front];
//            if (front == rear){
//                front = -1;
//                rear = -1;
//            }else {
//                front = (front + 1) % size;
//            }
//            return start;
//        }
//
//        // peek the first element
//        public static int peek(){
//            if (isEmpty()) return -1;
//
//            return arr[front];
//        }
//
//        // display
//        public static void display(){
//            if (isEmpty()) {
//                System.out.println("Empty Queue");
//                return;
//            }
//            System.out.print("front -> ");
//            for (int i=0; i<=rear; i++){
//                System.out.print(arr[i] + " -> ");
//            }
//            System.out.print("End");
//        }
//    }
//
//    public static void main(String[] args) {
//        int n = 5;
//        Queue.Array_Implementation.Queue que = new Queue.Array_Implementation.Queue(n);
//
//        que.display();
//
//        que.add(1);
//        que.add(2);
//        que.add(3);
//        que.add(4);
//        que.add(5);
//        que.add(6); // full queue
//
//        que.display();
//    }
//}
