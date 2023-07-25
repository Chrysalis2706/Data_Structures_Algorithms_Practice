package Tries;

public class TriesBasics {
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

    public static void main(String[] args) {
        String[] words = {"the", "a", "there", "their", "any", "thee"};

        //inserting
        for (int i=0; i<words.length; i++){
            insert(words[i]);
        }

        //searching
        System.out.println(search("the"));
        System.out.println(search("there"));
        System.out.println(search("abc"));
    }

}
