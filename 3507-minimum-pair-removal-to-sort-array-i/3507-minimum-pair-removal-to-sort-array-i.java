import java.util.ArrayList;
import java.util.List;

class Solution {
    public int minimumPairRemoval(int[] nums) {
        // Convert array to a List so we can easily perform insertions and deletions
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }

        int operations = 0;

        while (!isSorted(list)) {
            // Find the adjacent pair with the minimum sum (and leftmost in case of ties)
            int minSum = Integer.MAX_VALUE;
            int minIndex = 0;

            for (int i = 0; i < list.size() - 1; i++) {
                int currentSum = list.get(i) + list.get(i + 1);
                if (currentSum < minSum) {
                    minSum = currentSum;
                    minIndex = i;
                }
            }

            // Replace the pair with their sum
            list.set(minIndex, minSum);
            list.remove(minIndex + 1);

            operations++;
        }

        return operations;
    }

    private boolean isSorted(List<Integer> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i) > list.get(i + 1)) {
                return false;
            }
        }
        return true;
    }
}