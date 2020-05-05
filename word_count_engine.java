import java.util.*;

/**
 * Word Count Engine
 *
 * Counts word after occurences. If number of occurences is same, retain old order of original string.
 *
 * Solved with Map and Bucket Sort.
 *
 * WordCountEngine Pramp
 */
public class WordCounter {

    static String[][] countWords(String document) {
        Map<String, Integer> freqMap = new HashMap<>();
        String[] tokenized = document.toLowerCase().split("\\W+");

        for (String word : tokenized) {
            freqMap.put(word, freqMap.getOrDefault(word, 0) + 1);
        }

        ArrayList<String>[] bucket = new ArrayList[freqMap.size()];

        for (String word: tokenized) {
            int index = freqMap.get(word);
            if (bucket[index] == null) bucket[index] = new ArrayList<>();
            if (!bucket[index].contains(word)) bucket[index].add(word);
        }
        String[][] res = new String[freqMap.size()][2];
        int k = 0;
        for (int i = bucket.length - 1; i >= 0; i--) {
            if (bucket[i] != null) {
                for (int j = 0; j < bucket[i].size(); j++) {
                    res[k][0] = bucket[i].get(j);
                    res[k][1] = String.valueOf(i);
                    k++;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String sample = "Arnold and Arnold, play cricket every evening. They like Arnold and Arnold. They hate cricket but play it.";
        String[][] result = countWords(sample);
        for (String[] pair : result) {
            System.out.println(Arrays.toString(pair));
        }
    }
}
