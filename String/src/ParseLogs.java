import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Amazon OA
 * @author yanliu
 * @create 2022-05-05-3:38 PM
 */
public class ParseLogs {
    static class Solution {
        public List<String> parse(List<String> logs) {
            List<String> res = new ArrayList<>();

            if (logs == null || logs.size() == 0) {
                return res;
            }

            Map<String, String> register = new HashMap<>();
            Map<String, String> login = new HashMap<>();

            for (int i = 0; i < logs.size(); i++) {
                String curr = logs.get(i);
                // arr[0] is operation
                // arr[1] is username
                // arr[2] is password
                String[] arr = curr.split("\\s+");

                String operation = arr[0];

                switch (operation) {
                    case "register":
                        if (register.containsKey(arr[1])) {
                            res.add("Username already exists");

                        } else {
                            res.add("Registered Successfully");
                            register.put(arr[1], arr[2]);
                        }

                    case "login":
                        if (register.containsKey(arr[1])) {
                            if (login.containsKey(arr[1])) {
                                res.add("Login Unsuccessful");

                            } else {
                                if (register.get(arr[1]).equals(arr[2])) {
                                    res.add("Logged In Successfully");
                                    login.put(arr[1], arr[2]);

                                } else {
                                    res.add("Login Unsuccessful");

                                }

                            }

                        } else {
                            res.add("Login Unsuccessful");

                        }

                    case "logout":
                        if (register.containsKey(arr[1])) {
                            if (login.containsKey(arr[1])) {
                                res.add("Logged Out Successfully");
                                login.remove(arr[1]);

                            } else {
                                res.add("Logout Unsuccessful");

                            }

                        } else {
                            res.add("Logout Unsuccessful");

                        }

                    default:
                        throw new IllegalArgumentException("input argument is not valid");

                }
            }

            return res;
        }
    }
}
