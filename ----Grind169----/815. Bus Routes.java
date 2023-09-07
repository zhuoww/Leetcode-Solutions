class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        if (source == target)
            return 0;
        // 1. create graph -> buses mapping to the bus index
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < routes.length; i++) {
            for (int stop : routes[i]) {
                map.putIfAbsent(stop, new ArrayList<>());
                map.get(stop).add(i);
            }
        }

        if (!map.containsKey(target))
            return -1;

        Queue<Integer> q = new LinkedList<>();// Queue for BFS
        boolean[] visitedBuses = new boolean[routes.length];
        Set<Integer> visitedStops = new HashSet<>();
        int count = 0;
        q.add(source);
        visitedStops.add(source);

        while (!q.isEmpty()) {
            int curStops = q.size();
            while (curStops-- > 0) {
                int cur = q.poll();
                // find buses going through that bus stop
                for (int bus : map.get(cur)) {
                    if (!visitedBuses[bus]) {
                        visitedBuses[bus] = true;
                        // add all stops that bus goes through if it's not already visited to queue
                        for (int stop : routes[bus]) {
                            if (!visitedStops.contains(stop)) {
                                if (stop == target)
                                    return count + 1;
                                visitedStops.add(stop);
                                q.add(stop);
                            }
                        }
                    }
                }
            }
            count++;
        }
        return -1;
    }
}