import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

class Solution {
    LinkedList<String> res;
    LinkedList<String> path = new LinkedList<>();

    public List<String> findItinerary(List<List<String>> tickets) {
        Collections.sort(tickets, (a, b) -> a.get(1).compareTo(b.get(1)));
        boolean[] visited = new boolean[tickets.size()];
        path.add("JFK");
        backtracking(tickets, visited);
        return res;
    }

    public boolean backtracking(List<List<String>> tickets, boolean[] visited) {
        if (path.size() == tickets.size() + 1) {
            res = new LinkedList(path);
            return true;
        }

        for (int i = 0; i < tickets.size(); i++) {
            if (visited[i] == false && tickets.get(i).get(0).equals(path.getLast())) {
                path.add(tickets.get(i).get(1));
                visited[i] = true;
                if (backtracking(tickets, visited))
                    return true;
                path.removeLast();
                visited[i] = false;
            }
        }
        return false;
    }

}
