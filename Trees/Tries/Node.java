package Trees.Tries;

public class Node {
    boolean isEndOfWord;
    Node[] children = new Node[26];

    public Node() {
        this.isEndOfWord = false;
        for (int i = 0; i < 26; i++) {
            this.children[i] = null;
        }
    }
}
