class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        if (source == target)
            return 0;
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < routes.length; i++) {
            for (int stop : routes[i]) {
                map.putIfAbsent(stop, new ArrayList<>());
                map.get(stop).add(i);
            }
        }

        if (!map.containsKey(target))
            return -1;

        Queue<Integer> q = new LinkedList<>();
        boolean[] visitedBuses = new boolean[routes.length];
        Set<Integer> visitedStops = new HashSet<>();
        int total = 0;
        q.add(source);
        visitedStops.add(source);

        while (!q.isEmpty()) {
            int curStops = q.size();
            while (curStops-- > 0) {
                int cur = q.poll();
                List<Integer> list = map.get(cur);
                for (int bus : list) {
                    if (!visitedBuses[bus]) {
                        visitedBuses[bus] = true;
                        for (int stop : routes[bus]) {
                            if (!visitedStops.contains(stop)) {
                                if (stop == target)
                                    return total + 1;
                                visitedStops.add(stop);
                                q.add(stop);
                            }
                        }
                    }
                }
            }
            total++;
        }
        return -1;
    }
}
