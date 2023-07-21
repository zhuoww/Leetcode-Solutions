//DFS
class Solution {
    HashMap<String, List<String>> map = new HashMap<>();
    HashSet<String> visited = new HashSet<>();

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        // step 1: build the graph of email connections
        for (List<String> acc : accounts) {
            String firstEmail = acc.get(1);
            for (int j = 2; j < acc.size(); j++) {
                String email = acc.get(j);
                // update the connections in the map(bidirectional relationship 双向关系)
                map.computeIfAbsent(firstEmail, k -> new ArrayList<String>()).add(email);
                map.computeIfAbsent(email, k -> new ArrayList<String>()).add(firstEmail);
            }
        }

        List<List<String>> res = new ArrayList<>();
        for (List<String> acc : accounts) {
            String name = acc.get(0);
            String firstEmail = acc.get(1);
            if (!visited.contains(firstEmail)) {
                // perform Depth-First Search to merge accounts
                List<String> merge = new ArrayList<>();
                merge.add(name);
                dfs(merge, firstEmail);// start DFS from the first email of the account
                Collections.sort(merge.subList(1, merge.size()));// sort the email(excluding the account name)
                res.add(merge);
            }
        }
        return res;

    }

    // DFS method to traverse connected emails
    public void dfs(List<String> merge, String email) {
        visited.add(email);
        merge.add(email);

        // if current email is not present in the graph, return(base case for resursion)
        if (!map.containsKey(email))
            return;
        // traverse all connected emails in the graph and recursively perform DFS on
        // unvisited emails
        for (String nei : map.get(email)) {
            if (!visited.contains(nei)) {
                dfs(merge, nei);
            }
        }
    }
}
