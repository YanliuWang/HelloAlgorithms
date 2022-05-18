import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author yanliu
 * @create 2022-05-17-9:38 AM
 */
public class FlattenLinkedList {
    class Node {
        int val;
        Node next;
        Node down;
    }

    public List<Integer> flatten(Node start) {
        List<Integer> res = new LinkedList<>();

        if (start == null) {
            return res;
        }

        Node curr = start;
        Deque<Node> stack = new ArrayDeque<>();

        while (curr != null) {
            if (curr.down == null) {
                res.add(curr.val);

                if (curr.next != null) {
                    curr = curr.next;

                } else {
                    if (stack.isEmpty()) {
                        break;
                    }

                    curr = stack.pop();
                }

            } else {
                if (curr.next != null) {
                    stack.push(curr.next);
                }

                curr = curr.down;
            }
        }

        return res;
    }
}
