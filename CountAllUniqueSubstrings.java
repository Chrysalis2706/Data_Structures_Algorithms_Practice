package Tries;

public class CountAllUniqueSubstrings {
        static class Node {
            Node[] children = new Node[26];
            boolean endOfWord = false;

            Node() {
                for (int i = 0; i < 26; i++) {
                    // by default these are null values
                    children[i] = null;
                }
            }
        }
        // declaring empty Root node
        public static Node root = new Node();

        // Insert into trie
        public static void insert(String word){ //O[L]
            Node curr = root;
            for (int level = 0; level <word.length(); level++){
                int index = word.charAt(level) - 'a';
                if (curr.children[index] == null){
                    // create node : if does not exist
                    curr.children[index] = new Node();
                }
                curr = curr.children[index];
            }
            curr.endOfWord = true;
        }

        // Search into trie
        public static boolean search(String key){
            Node curr = root;
            for (int level=0; level<key.length(); level++){
                int index = key.charAt(level) - 'a';
                if (curr.children[index] == null){
//                    last condition
                    return false;
                }
                curr = curr.children[index];
            }
            if (curr.endOfWord == true) return true;
            else return false;
        }

        public static int countSubs(Node root){
            if (root == null) return 0;
            int count = 0;
            for (int i=0; i<26; i++){
                if (root.children[i] != null){
                    count += countSubs(root.children[i]);
                }
            }
            return count+1;
        }

        public static void main(String[] args) {
            String str = "ababa";

            //inserting all suffixes
            for (int i=0; i<str.length(); i++){
                String suffix = str.substring(i);
                insert(suffix);
            }

            System.out.println(countSubs(root));

        }
}
