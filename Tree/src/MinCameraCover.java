/**
 * LC968
 * @author yanliu
 * @create 2021-01-25-21:09
 */
public class MinCameraCover {
    static class Solution {
        enum State {
            NOT_MONITORED, MONITORED_NO_CAMERA, MONITORED_WITH_CAMERA;
        }

        class Status {
            State state;
            int camera;

            public Status(int camera, State state) {
                this.camera = camera;
                this.state = state;
            }
        }

        public int minCameraCover(TreeNode root) {
            Status status = getMinCamera(root);

            if (status.state == State.NOT_MONITORED) {
                status.camera++;
            }

            return status.camera;
        }

        private Status getMinCamera(TreeNode node) {
            if (node == null) {
                return new Status(0, State.MONITORED_NO_CAMERA);
            }

            Status left = getMinCamera(node.left);
            Status right = getMinCamera(node.right);

            Status curr = new Status(left.camera + right.camera, State.NOT_MONITORED);

            if (left.state == State.NOT_MONITORED || right.state == State.NOT_MONITORED) {
                curr.camera++;
                curr.state = State.MONITORED_WITH_CAMERA;
            } else if (left.state == State.MONITORED_WITH_CAMERA || right.state == State.MONITORED_WITH_CAMERA) {
                curr.state = State.MONITORED_NO_CAMERA;
            }

            return curr;
        }
    }
}
