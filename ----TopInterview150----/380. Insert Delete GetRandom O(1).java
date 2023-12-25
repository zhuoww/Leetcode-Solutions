/*
 * medium
 * time:O(1);space:O(n)
 */

class RandomizedSet {
    HashMap<Integer, Integer> map;// store index
    List<Integer> list;// store value,
                       // list的时间复杂度是O(N)，所以需要map去的到要删除的元素的下边，然后将list最后一个元素替换到该下标下，然后删除list最后一个元素，这样可以达到O(1)
    Random random;

    public RandomizedSet() {
        map = new HashMap<>();
        list = new ArrayList<>();
        random = new Random();
    }

    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        }
        list.add(val);
        map.put(val, list.size() - 1);
        return true;
    }

    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }
        int index = map.get(val);
        int lastIndex = list.size() - 1;
        if (index != lastIndex) {
            int lastValue = list.get(lastIndex);
            list.set(index, lastValue);
            map.put(lastValue, index);
        }
        list.remove(lastIndex);
        map.remove(val);
        return true;
    }

    public int getRandom() {
        int randomNumber = random.nextInt(list.size());
        return list.get(randomNumber);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
