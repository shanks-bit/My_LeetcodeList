// leetcode -> https://leetcode.com/problems/coupon-code-validator/description/
class Solution {
    public List<String> validateCoupons(String[] code, String[] businessLine, boolean[] isActive) {
         List<Coupon> validCoupons = new ArrayList<>();

        // Define businessLine priority
        Map<String, Integer> businessPriority = new HashMap<>();
        businessPriority.put("electronics", 0);
        businessPriority.put("grocery", 1);
        businessPriority.put("pharmacy", 2);
        businessPriority.put("restaurant", 3);

        // Step 1: Validate and collect valid coupons
        for (int i = 0; i < code.length; i++) {
            if (!code[i].isEmpty() &&
                code[i].matches("[a-zA-Z0-9_]+") &&
                businessPriority.containsKey(businessLine[i]) &&
                isActive[i]) {

                validCoupons.add(new Coupon(code[i], businessLine[i]));
            }
        }

        // Step 2: Sort by businessLine priority then by code
        validCoupons.sort((c1, c2) -> {
            int p1 = businessPriority.get(c1.businessLine);
            int p2 = businessPriority.get(c2.businessLine);
            if (p1 != p2) {
                return Integer.compare(p1, p2);
            } else {
                return c1.code.compareTo(c2.code);
            }
        });

        // Step 3: Extract codes
        List<String> result = new ArrayList<>();
        for (Coupon c : validCoupons) {
            result.add(c.code);
        }

        return result;
    }

    // Helper class
    static class Coupon {
        String code;
        String businessLine;

        Coupon(String code, String businessLine) {
            this.code = code;
            this.businessLine = businessLine;
        }
    }
    
}
