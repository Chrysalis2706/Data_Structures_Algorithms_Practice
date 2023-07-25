package Heaps;
import java.util.*;

public class HeapImplementation {
    static class Heap {
        static ArrayList<Integer> arr = new ArrayList<>();

        // Insert in Heap :  logN (number of levels)
        public void insert(int data){
            arr.add(data);

            int ch = arr.size()-1; // child index
            int par = (ch-1)/2; // parent index

            while (arr.get(ch) < arr.get(par)){
                //swap in array
                int temp = arr.get(ch);
                arr.set(ch, arr.get(par));
                arr.set(par, temp);

                ch = par;
                par = (ch-1)/2;
            }
        }

        // Peak in heap : O(1)
        public int peek(){
            return arr.get(0);
        }

        // Delete/Remove in Heap : logN (number of levels)
        public int remove(){
            int data = arr.remove(0);

            // Swap 1st and last
            int temp = arr.get(0);
            arr.set(0, arr.get(arr.size()-1));
            arr.set(arr.size()-1, temp);

            //remove 1st element now
            arr.remove(arr.size()-1);

            // call heapify
            heapify(0);

            return data;
        }

        private void heapify(int i){
            int min = i;
            int left = (2*i+1);
            int right = (2*i+2);

            // check for left and right child
            if (left < arr.size() && arr.get(left) < arr.get(min)){
                min = left;
            }
            if (right < arr.size() && arr.get(right) < arr.get(min)){
                min = right;
            }

            //swap min and i
            if (i != min){
                int temp = arr.get(i);
                arr.set(i, arr.get(min));
                arr.set(min, temp);

                // call again for other elements
                heapify(min);
            }

        }

        // Is empty
        public boolean isEmpty(){
            return arr.size() == 0;
        }
    }

    public static void main(String[] args) {
        Heap hp = new Heap();
        hp.insert(2);
        hp.insert(8);
        hp.insert(4);
        hp.insert(5);
        hp.insert(10);
        hp.insert(6);

//        hp.remove();

        while(!hp.isEmpty()){
            System.out.print(hp.peek() + " ");
            hp.remove();
        }
    }
}
