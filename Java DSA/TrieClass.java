// Trie implementation in Java with multiple operations
public class TrieClass {

    // ----------------- Node class (represents each character) -----------------
    static class Node {
        Node[] children;   // array of children (a to z)
        boolean eow;       // end of word flag

        public Node() {
            children = new Node[26]; // for 'a' to 'z'
            eow = false;             // initially, no word ends here
        }
    }

    // Root node of Trie (starting point)
    static Node root = new Node();

    // ----------------- Insert a word into Trie -----------------
    public static void insert(String word) {
        Node curr = root; // start from root for each word

        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a'; // map char to index (0-25)

            if (curr.children[idx] == null) {
                // create a new node if it doesn't exist
                curr.children[idx] = new Node();
            }

            // move to the next node
            curr = curr.children[idx];

            // if last character, mark eow = true
            if (i == word.length() - 1) {
                curr.eow = true;
            }
        }
    }

    // ----------------- Search for a word in Trie -----------------
    public static boolean search(String key) {
        Node curr = root;

        for (int i = 0; i < key.length(); i++) {
            int idx = key.charAt(i) - 'a';

            if (curr.children[idx] == null) {
                return false; // if node not found → word not present
            }

            curr = curr.children[idx]; // move forward
        }

        // word exists only if eow == true at the last character
        return curr.eow;
    }

    // ----------------- Word Break Problem -----------------
    // Check if the given string can be segmented into dictionary words
    public static boolean wordBreak(String key) {
        if (key.length() == 0) {
            return true; // base case: empty string is valid
        }

        for (int i = 1; i <= key.length(); i++) {
            // split into two parts: firstPart + secPart
            String firstPart = key.substring(0, i);
            String secPart = key.substring(i);

            // if firstPart is in dictionary and secPart can also be broken → true
            if (search(firstPart) && wordBreak(secPart)) {
                return true;
            }
        }
        return false;
    }

    // ----------------- Count Total Nodes in Trie -----------------
    public static int countNode(Node root) {
        if (root == null) {
            return 0;
        }

        int count = 0;
        for (int i = 0; i < 26; i++) {
            if (root.children[i] != null) {
                count += countNode(root.children[i]);
            }
        }

        return count + 1; // +1 for current node
    }

    // ----------------- Longest Word with All Prefixes Present -----------------
    public static String ans = ""; // store answer

    public static void longestWord(Node root, StringBuilder temp) {
        if (root == null) {
            return;
        }

        // traverse children a-z
        for (int i = 0; i < 26; i++) {
            if (root.children[i] != null && root.children[i].eow == true) {
                // add this character to temp
                temp.append((char) (i + 'a'));

                // update answer if current word is longer
                if (temp.length() > ans.length()) {
                    ans = temp.toString();
                }

                // recursive call
                longestWord(root.children[i], temp);

                // backtrack (remove last character before trying next)
                temp.deleteCharAt(temp.length() - 1);
            }
        }
    }

    // ----------------- Main Function -----------------
    public static void main(String args[]) {
        String words[] = {"the", "a", "there", "their", "any", "thee"};

        // Insert words into Trie
        for (int i = 0; i < words.length; i++) {
            insert(words[i]);
        }

        // Test Search
        System.out.println("Search 'their': " + search("their")); // true
        System.out.println("Search 'these': " + search("these")); // false

        // Test Word Break
        System.out.println("Word Break 'thea': " + wordBreak("thea"));   // true ("the" + "a")
        System.out.println("Word Break 'there': " + wordBreak("there")); // true
        System.out.println("Word Break 'thera': " + wordBreak("thera")); // false

        // Count total nodes in Trie
        System.out.println("Total Trie Nodes: " + countNode(root));

        // Find Longest Word with all prefixes present
        longestWord(root, new StringBuilder());
        System.out.println("Longest Word: " + ans);
    }
}
