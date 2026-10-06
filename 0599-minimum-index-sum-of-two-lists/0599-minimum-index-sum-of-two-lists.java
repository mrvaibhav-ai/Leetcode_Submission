import java.util.*;

class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> map = new HashMap<>();
        // Store all elements from list1 with their index
        for (int i = 0; i < list1.length; i++) {
            map.put(list1[i], i);
        }

        List<String> result = new ArrayList<>();
        int minSum = Integer.MAX_VALUE;

        // Iterate through list2 to find common elements
        for (int j = 0; j < list2.length; j++) {
            if (map.containsKey(list2[j])) {
                int sum = j + map.get(list2[j]);

                if (sum < minSum) {
                    minSum = sum;
                    result.clear(); // Found a smaller index sum, discard previous elements
                    result.add(list2[j]);
                } else if (sum == minSum) {
                    result.add(list2[j]); // Same index sum, add to results
                }
            }
        }

        return result.toArray(new String[0]);
    }
}