import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author yanliu
 * @create 2022-09-10-8:35 PM
 */
public class BrowserHistory {
    private Deque<String> history;
    private Deque<String> future;

    public BrowserHistory(String homepage) {
        history = new ArrayDeque<>();
        future = new ArrayDeque<>();

        history.push(homepage);
        future.clear();
    }

    public void visit(String url) {
        history.push(url);
        future.clear();
    }

    public String back(int steps) {
        while (steps > 0 && history.size() > 1) {
            future.push(history.pop());
            steps--;
        }

        return history.peek();
    }

    public String forward(int steps) {
        while (steps > 0 && future.size() > 0) {
            history.push(future.pop());
            steps--;
        }

        return history.peek();
    }
}
