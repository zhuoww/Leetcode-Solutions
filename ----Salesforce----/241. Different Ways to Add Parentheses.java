/*
 * medium
 * time:
 */

class Solution {
    HashMap<String, List<Integer>> memo = new HashMap<>();

    public List<Integer> diffWaysToCompute(String expression) {
        if (expression == null || expression.length() == 0)
            return new ArrayList<>();
        if (memo.containsKey(expression)) {
            return memo.get(expression);
        }

        int len = expression.length();
        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < len; i++) {
            char c = expression.charAt(i);
            if (c == '+' || c == '-' || c == '*') {
                String left = expression.substring(0, i);
                String right = expression.substring(i + 1);

                List<Integer> leftResults = diffWaysToCompute(left);
                List<Integer> rightResults = diffWaysToCompute(right);

                for (int l : leftResults) {
                    for (int r : rightResults) {
                        if (c == '+') {
                            res.add(l + r);
                        } else if (c == '-') {
                            res.add(l - r);
                        } else if (c == '*') {
                            res.add(l * r);
                        }
                    }
                }

            }
        }
        if (res.size() == 0) {
            res.add(Integer.valueOf(expression));
        }

        memo.put(expression, res);
        return res;
    }
}