class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        Map<String, Integer> map = new HashMap<>();
        Set<String> banSet = new HashSet<>();
        String mostCommon = "";
        int maxCount = 0;

        String normalized = paragraph
                .toLowerCase()
                .replaceAll("[!?',;.]", " ");
        String[] words = normalized.trim().split("\\s+");

        for(String word: banned) banSet.add(word);
        for(String word: words){
            if(banSet.contains(word)) continue;
            int count = map.getOrDefault(word, 0) + 1;

            map.put(word, count);
            if(count > maxCount){
                maxCount = count;
                mostCommon = word;
            }
        }

        return mostCommon;
    }
}