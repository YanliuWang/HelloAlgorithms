import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.util.*;

/**
 * @author yanliu
 * @create 2021-10-26-3:57 PM
 */
public class StripeOA {
    static class BetaInvites {
        Set<String> bolts = new HashSet<>();
        Map<String, Long> ave = new HashMap<>();
        // User:  <Date without second, req counts>
        Map<String, Map<Date, Integer>> detect = new HashMap<>();
        // User to invite_requested-invite_send-invite_activated
        Map<String, Long[]> status = new HashMap<>();

        public void process_invites(int N, String csvfilepath) throws IOException {
            try (BufferedReader fb = Files.newBufferedReader(Paths.get(csvfilepath))) {
                String line;
                while ((line = fb.readLine()) != null && N-- > 0) {
                    parseLog(line);
                }
                // read line
                System.out.println(handle());
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }

        private void parseLog(String log) throws ParseException {
            String[] l = log.split(",");
            long t = Long.valueOf(l[0]);
            String eventType = l[1], userId = l[2];

            if (bolts.contains(userId)) {
                return;
            }
            status.putIfAbsent(userId, new Long[] {null, null, null});

            if ("invite_requested" == eventType) {
                Calendar calendar = Calendar.getInstance();
                calendar.setTimeInMillis(t);
                calendar.set(Calendar.SECOND, 0);
                Date d = calendar.getTime();

                if (!detect.containsKey(userId)) {
                    detect.put(userId, new HashMap<>());
                    detect.get(userId).put(d, 1);
                } else {
                    Map<Date, Integer> count = detect.get(userId);
                    count.put(d, count.getOrDefault(d, 0) + 1);
                    if (count.get(d) >= 5) {
                        bolts.add(userId);
                    }
                }

                // first time of record
                if (status.get(userId)[0] == null) {
                    status.get(userId)[0] = t;
                }

            } else if ("invite_send" != eventType) {
                if ("invite_activated" != eventType) {
                    return;
                }
                Long a = status.get(userId)[0], b = status.get(userId)[1];
                // put into average
                if (a != null && b != null && a < b && b < t) {
                    ave.put(userId, t - a);
                }
            } else {
                status.get(userId)[1] = t;
            }
        }

        public String handle() throws ParseException {
            if (ave.size() == 0) {
                return "0";
            }

            Long sum = 0L, count = 0L;

            for (Map.Entry<String, Long> e : ave.entrySet()) {
                if (bolts.contains(e.getKey())) {
                    continue;
                }
                sum += e.getValue();
                count++;
            }

            return bolts.size() + " " + sum / count;
        }
    }

    static class Verification {
        private static Map<String, List<String>> categoryRequired = new HashMap<>();

        static {
            List<String> indiUS = Arrays.asList(
                    "first_name",
                    "last_name",
                    "date_of_birth",
                    "social_security_number",
                    "email",
                    "phone");
            categoryRequired.put("individual*US", indiUS);

            List<String> indiJP = Arrays.asList(
                    "first_name",
                    "last_name",
                    "first_name_kana",
                    "last_name_kana",
                    "date_of_birth",
                    "tax_id_number",
                    "email");
            categoryRequired.put("individual*JP", indiJP);

            List<String> indiFR = Arrays.asList(
                    "first_name",
                    "last_name",
                    "tax_id_number",
                    "email",
                    "phone");
            categoryRequired.put("individual*FR", indiFR);

            List<String> comUS = Arrays.asList(
                    "name",
                    "employer_id_number",
                    "support_email",
                    "phone");
            categoryRequired.put("company*US", comUS);

            List<String> comJP = Arrays.asList(
                    "name",
                    "tax_id_number",
                    "phone");
            categoryRequired.put("company*JP", comJP);

            List<String> comFR = Arrays.asList(
                    "name",
                    "director_name",
                    "tax_id_number",
                    "phone");
            categoryRequired.put("company*FR", comFR);

            for (String category : categoryRequired.keySet()) {
                Collections.sort(categoryRequired.get(category));
            }
        }

        public static List<String> verify_merchants(List<String> lines) {
            Map<String, Map<String, String>> infoProvided = new HashMap<>();

            // line : merchant_id + field_name + field_value
            for (String line : lines) {
                String[] parsed = line.split(",");
                infoProvided.putIfAbsent(parsed[0], new HashMap<>());
                infoProvided.get(parsed[0]).put(parsed[1], parsed[2]);
            }

            // sort merchantID
            List<String> merchantIDs = new ArrayList<>(infoProvided.keySet());
            Collections.sort(merchantIDs);

            Map<String, List<String>> merchantMissing = new HashMap<>();

            // check what is missing from merchants
            for (String merchantID : merchantIDs) {
                // check whether it contains individual / country information
                Map<String, String> curr = infoProvided.get(merchantID);
                merchantMissing.put(merchantID, new ArrayList<>());
                List<String> missingFields = merchantMissing.get(merchantID);

                if (!curr.containsKey("business_type")) {
                    missingFields.add("business_type");
                }

                if (!curr.containsKey("country")) {
                    missingFields.add("country");
                }

                if (missingFields.size() == 0) {
                    String category = curr.get("business_type") + "*" + curr.get("country");
                    List<String> requirements = categoryRequired.get(category);
                    for (String req : requirements) {
                        if (!curr.containsKey(req)) {
                            missingFields.add(req);
                        }
                    }
                }
            }

            List<String> res = new ArrayList<>();

            // produce sentences for missing info
            for (String merchantID : merchantIDs) {
                StringBuilder message = new StringBuilder(merchantID);
                message.append(":");

                List<String> currMissing = merchantMissing.get(merchantID);
                if (currMissing.size() == 0) {
                    message.append("VERIFIED");
                } else {
                    message.append("UNVERIFIED:");
                    message.append(String.join(",", currMissing));
                }
                System.out.println(message.toString());
                res.add(message.toString());
            }

            return res;
        }
    }

    static class Capital {
        // merchantId to <loanId, loan_amount>
        Map<String, Map<String, Integer>> merchantRecords;

        public Capital() {
            merchantRecords = new HashMap<>();
        }

        public void createLoan(String merchantId, String loanId, int amount) {
            Map<String, Integer> newRecord = new HashMap<>();
            newRecord.put(loanId, amount);
            merchantRecords.put(merchantId, newRecord);
        }

        public void payLoan(String merchantId, String loanId, int amount) {
            if (!merchantRecords.containsKey(merchantId)) {
                return;
            }

            Map<String, Integer> record = merchantRecords.get(merchantId);

            if (!record.containsKey(loanId)) {
                return;
            }

            int currVal = Math.max(record.get(loanId) - amount, 0);
            record.put(loanId, currVal);
            merchantRecords.put(merchantId, record);
        }

        public void increaseLoan(String merchantId, String loanId, int amount) {
            if (!merchantRecords.containsKey(merchantId)) {
                return;
            }

            Map<String, Integer> record = merchantRecords.get(merchantId);

            if (!record.containsKey(loanId)) {
                return;
            }

            int currVal = record.get(loanId) + amount;
            record.put(loanId, currVal);
            merchantRecords.put(merchantId, record);
        }

        public void transactionProcessed(String merchantId, String loanId, int amount, int repaymentPercentage) {
            if (!merchantRecords.containsKey(merchantId)) {
                return;
            }

            Map<String, Integer> record = merchantRecords.get(merchantId);

            if (!record.containsKey(loanId)) {
                return;
            }

            int currVal = record.get(loanId) - (int)Math.floor(repaymentPercentage * 0.1 / 100 * amount);
            record.put(loanId, currVal);
            merchantRecords.put(merchantId, record);
        }

        public void output() {
            for (String merchantId : merchantRecords.keySet()) {
                Map<String, Integer> loanToAmount = merchantRecords.get(merchantId);

                int sum = 0;

                for (Integer value : loanToAmount.values()) {
                    sum += value;
                }

                System.out.println(merchantId + "," + sum);
            }



        }

        public void parse(List<String> lines) {
            for (String line : lines) {
                String[] parsed = line.split(", ");

                if (parsed[0] == "createLoan") {
                    createLoan(parsed[1], parsed[2], Integer.parseInt(parsed[3]));
                }

                if (parsed[0] == "payLoan") {
                    payLoan(parsed[1], parsed[2], Integer.parseInt(parsed[3]));
                }

                if (parsed[0] == "increaseLoan") {
                    increaseLoan(parsed[1], parsed[2], Integer.parseInt(parsed[3]));
                }

                if (parsed[0] == "transactionProcessed") {
                    transactionProcessed(parsed[1], parsed[2], Integer.parseInt(parsed[3]),Integer.parseInt(parsed[4]));
                }
            }
        }
    }
}
