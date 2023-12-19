/*
 * medium
 * PriorityQueue, HashMap
 * FoodRatings - O(nlogn), we neeed to add food to cuisine map and sort them
 * changeRating - O(logn), although rating for food obj changes in O(1), we need to rearrange it in pq in cuisine map
 * highestRated - O(1), fetching top element of pq of cuisine map
 * Space complexity: O(n), two maps food & cuisine
 */

class FoodRatings {

    private class Food {
        private String food;
        private String cuisine;
        private int rating;

        public Food(String food, String cuisine, int rating) {
            this.food = food;
            this.cuisine = cuisine;
            this.rating = rating;
        }
    }

    // get Food using food name: <FoodName, Food>
    HashMap<String, Food> foodMap = new HashMap<>();
    // get pq from cuisine name: <cuisine, PriorityQueue<Food>>
    HashMap<String, PriorityQueue<Food>> cuisineMap = new HashMap<>();

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        for (int i = 0; i < foods.length; i++) {
            Food f = new Food(foods[i], cuisines[i], ratings[i]);

            // maxHeap
            cuisineMap.putIfAbsent(cuisines[i], new PriorityQueue<>(
                    (a, b) -> b.rating == a.rating ? a.food.compareTo(b.food) : b.rating - a.rating));

            PriorityQueue<Food> pq = cuisineMap.get(cuisines[i]);
            pq.add(f);
            foodMap.put(foods[i], f);
        }
    }

    public void changeRating(String food, int newRating) {
        Food cur = foodMap.get(food);
        PriorityQueue<Food> pq = cuisineMap.get(cur.cuisine);
        pq.remove(cur);
        cur.rating = newRating;
        pq.add(cur);
    }

    public String highestRated(String cuisine) {
        return cuisineMap.get(cuisine).peek().food;

    }
}

/**
 * Your FoodRatings object will be instantiated and called as such:
 * FoodRatings obj = new FoodRatings(foods, cuisines, ratings);
 * obj.changeRating(food,newRating);
 * String param_2 = obj.highestRated(cuisine);
 */
