import java.util.*;

/**
 * LeetCode588
 * @author yanliu
 * @create 2022-01-04-8:52 PM
 */
class FileSystem {
    class TrieNode {
        String content;
        boolean isFile;
        Map<String, TrieNode> children;

        public TrieNode() {
            children = new HashMap<>();
        }
    }

    private TrieNode root;

    public FileSystem() {
        root = new TrieNode();
    }

    public List<String> ls(String path) {
        TrieNode curr = root;
        List<String> res = new ArrayList<>();

        String[] pathStr = path.split("/");
        for (int i = 1; i < pathStr.length; i++) {
            curr = curr.children.get(pathStr[i]);
        }

        if (curr.isFile) {
            res.add(pathStr[pathStr.length - 1]);

        } else {
            res.addAll(curr.children.keySet());
            Collections.sort(res);

        }

        return res;
    }

    public void mkdir(String path) {
        getCurrentNode(path);
    }

    public void addContentToFile(String filePath, String content) {
        TrieNode curr = getCurrentNode(filePath);
        curr.isFile = true;

        if (curr.content == null) {
            curr.content = new String(content);

        } else {
            curr.content = curr.content.concat(content);

        }
    }

    public String readContentFromFile(String filePath) {
        TrieNode curr = getCurrentNode(filePath);
        return curr.content;
    }

    private TrieNode getCurrentNode(String path) {
        TrieNode curr = root;
        String[] pathStr = path.split("/");

        for (int i = 1; i < pathStr.length; i++) {
            String currStr = pathStr[i];

            if (!curr.children.containsKey(currStr)) {
                curr.children.put(currStr, new TrieNode());
            }

            curr = curr.children.get(currStr);
        }

        return curr;
    }
}

