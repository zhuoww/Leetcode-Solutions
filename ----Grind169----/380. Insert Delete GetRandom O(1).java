import java.util.*;

class RandomizedSet {
    HashMap<Integer, Integer> map;
    List<Integer> list;
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
        int index = map.remove(val);
        int last = list.remove(list.size() - 1);
        if (val != last) {
            list.set(index, last);
            map.put(last, index);
        }
        return true;
    }

    public int getRandom() {
        int randomNum = random.nextInt(list.size());
        return list.get(randomNum);
    }

    public static void main(String[] orgs) {
        RandomizedSet randomSet = new RandomizedSet();
        System.out.println(randomSet.insert(1));
        System.out.println(randomSet.remove(2));
        System.out.println(randomSet.insert(2));
        System.out.println(randomSet.getRandom());
        System.out.println(randomSet.remove(1));
        System.out.println(randomSet.insert(2));
        System.out.println(randomSet.insert(3));
        System.out.println(randomSet.insert(4));
        System.out.println(randomSet.insert(5));
        System.out.println(randomSet.getRandom());

    }

}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */