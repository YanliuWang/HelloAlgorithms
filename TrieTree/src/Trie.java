import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode208
 * @author yanliu
 * @create 2021-12-28-6:28 PM
 */
public class Trie {
    class TrieNode {
        public boolean isWord;
        public Map<Character, TrieNode> childrenMap;

        public TrieNode() {
            childrenMap = new HashMap<>();
        }
    }

    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode curr = root;

        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);

            if (!curr.childrenMap.containsKey(ch)) {
                curr.childrenMap.put(ch, new TrieNode());
            }

            curr = curr.childrenMap.get(ch);
        }

        curr.isWord = true;
    }

    public boolean search(String word) {
        TrieNode curr = root;

        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);

            if (!curr.childrenMap.containsKey(ch)) {
                return false;
            }

            curr = curr.childrenMap.get(ch);
        }

        return curr.isWord;
    }

    public boolean startsWith(String prefix) {
        TrieNode curr = root;

        for (int i = 0; i < prefix.length(); i++) {
            char ch = prefix.charAt(i);

            if (!curr.childrenMap.containsKey(ch)) {
                return false;
            }

            curr = curr.childrenMap.get(ch);
        }

        return true;
    }
}
