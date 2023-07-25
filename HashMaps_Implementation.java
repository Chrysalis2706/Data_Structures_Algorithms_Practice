package Hashing;

import com.sun.jdi.connect.spi.TransportService;

import java.util.ArrayList;
import java.util.LinkedList;

public class HashMaps_Implementation {

    static class HashMap<K,V>{  // <K,V> is for generics of any type in JAVA


        // Node key and value pair
        private class Node {
            K key;
            V value;

            public Node(K key, V value) {
                this.key = key;
                this.value = value;
            }
        }

        private int n; //n
        private int N;
        private LinkedList<Node>[] buckets; //N : buckets length

        public HashMap() {
            this.N = 4;
            this.buckets = new LinkedList[4]; //N = 4
            for (int i=0; i< buckets.length; i++){
                buckets[i] = new LinkedList<>();
            }
        }

        private int hashfunction(K key){
            int hc = key.hashCode(); //returns the hashcode of any value (in built)
            return Math.abs(hc % N); // to get it in between 0 to n , abs to get +ve values
        }

        private int seachInLL(K key, int bi){
            LinkedList<Node> ll = buckets[bi];
            int di = 0;

            for (int i=0; i<ll.size(); i++){
                Node node = ll.get(i);
                if (node.key == key){
                    return di;
                }
                di++;
            }
            return -1;
        }

        public void put (K key, V value ) {
            int bi = hashfunction(key); // bucket index
            int di = seachInLL(key, bi); // data index : valid index or -1

            if (di != -1){
                // update values
                Node node = buckets[bi].get(di);
                node.value = value;
            }else{
                // create new node
                buckets[bi].add(new Node(key, value));
                n++;
            }


            double lambda = (double)n/N;
            if (lambda > 2.0){
                rehash();
            }
        }

        private void rehash(){
            LinkedList<Node> oldbucket[] = buckets;
            buckets = new LinkedList[N*2]; // double the values
            N = 2*N;

            for (int i=0; i< buckets.length; i++){
                buckets[i] = new LinkedList<>();
            }

            // nodes --> add them to new bucket
            for (int i=0 ; i<oldbucket.length; i++){
                LinkedList<Node> ll = oldbucket[i];
                for (int j=0; j<ll.size(); j++){
                    Node node = ll.remove();
                    put(node.key, node.value);
                }
            }

        }

        // Contains Key : just like put
        public boolean containsKey(K key){
            int bi = hashfunction(key);
            int di = seachInLL(key, bi);

            if (di != -1) return true;
            else return false;
        }

        // Get : just like put
        public V get(K key){
            int bi = hashfunction(key);
            int di = seachInLL(key, bi);

            if (di != -1) {
                Node node = buckets[bi].get(di);
                return node.value;
            }
            else {
                return null;
            }
        }

        // Get : just like put
        public V remove(K key){
            int bi = hashfunction(key);
            int di = seachInLL(key, bi);

            if (di != -1) {
                Node node = buckets[bi].remove(di);
                n--;
                return node.value;
            }
            else {
                return null;
            }
        }


        // Key set function
        public ArrayList<K> keySet(){
            ArrayList<K> keys = new ArrayList<>();
            for (int i=0; i<buckets.length; i++){
                LinkedList<Node> ll = buckets[i];
                for (Node n : ll){
                    keys.add(n.key);
                }
            }
            return keys;
        }


        // isEmpty
        public boolean isEmpty(){
            return n == 0;
        }

    }

    public static void main(String[] args) {
        HashMap<String, Integer> hm = new HashMap<>();
        hm.put("ABC", 100);
        hm.put("DEF", 100);
        hm.put("GHI", 100);
    }
}
