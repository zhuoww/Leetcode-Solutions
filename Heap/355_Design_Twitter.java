package Heap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;

class Twitter {
    int count;
    HashMap<Integer, List<int[]>> tweetMap; // userId, list of [count, tweetId]
    HashMap<Integer, HashSet<Integer>> followMap; // userId, set of followeeId

    public Twitter() {
        count = 0;
        tweetMap = new HashMap<>();
        followMap = new HashMap<>();
    }

    public void postTweet(int userId, int tweetId) {
        tweetMap.computeIfAbsent(userId, k -> new ArrayList<>());// if the user ID is absent in the map, a new empty
                                                                 // list is created and associated with the user ID
        tweetMap.computeIfPresent(userId, (k, v) -> {
            v.add(new int[] { count, tweetId });
            return v;
        });
        count++;// the count is incremented for each tweet to maintain order
    }

    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res = new ArrayList<>(); // ordered starting from recent
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[0] - a[0]);// store the most recent tweets
        followMap.computeIfAbsent(userId, k -> new HashSet<>());
        followMap.get(userId).add(userId);

        followMap.get(userId).forEach((followeeId) -> {
            if (tweetMap.containsKey(followeeId)) {
                int i = tweetMap.get(followeeId).size() - 1;
                int[] tweet = tweetMap.get(followeeId).get(i);
                maxHeap.offer(new int[] { tweet[0], tweet[1], followeeId, i - 1 });
            }
        });

        while (!maxHeap.isEmpty() && res.size() < 10) {
            int[] cur = maxHeap.poll();
            res.add(cur[1]);

            if (cur[3] >= 0) {
                int[] tweet = tweetMap.get(cur[2]).get(cur[3]);
                maxHeap.offer(new int[] { tweet[0], tweet[1], cur[2], cur[3] - 1 });
            }
        }
        return res;
    }

    public void follow(int followerId, int followeeId) {
        followMap.computeIfAbsent(followerId, k -> new HashSet<>());
        followMap.computeIfPresent(followerId, (k, v) -> {
            v.add(followeeId);
            return v;
        });
    }

    public void unfollow(int followerId, int followeeId) {
        HashSet<Integer> set = followMap.computeIfAbsent(followerId,
                k -> new HashSet<>());
        if (set.contains(followeeId)) {
            set.remove(followeeId);
        }
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */
