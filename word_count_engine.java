import java.util.*;

/**
 * Counts word after occurences. If number of occurences is same, retain old order of original string.
 *
 * Solved with Map and Bucket Sort.
 *
 * WordCountEngine
 */
public class WordCounter {

    static String[][] countWords(String document) {
        Map<String, Integer> freqMap = new HashMap<>();
        String[] tokenized = document.toLowerCase().split("\\W+");

        // count frequencies (standard algo)
        for (String word : tokenized) {
            freqMap.put(word, freqMap.getOrDefault(word, 0) + 1);
        }

        // create bucket, max size can only be maximum number of unique elements --> max size = freq.size();
        List<String>[] bucket = new LinkedList[freqMap.size()];

        // Fill bucket in order of how the String was. If bucket already has that element, do not add again.
        for (String word: tokenized) {
            int index = freqMap.get(word);
            if (bucket[index] == null) bucket[index] = new LinkedList<>();
            if (!bucket[index].contains(word)) bucket[index].add(word);
        }

        // Prepare output (main logic is done already).
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
