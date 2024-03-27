import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class LeetCode_127 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        wordList.add(beginWord);
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        var map = new HashMap<String, Integer>();
        int index = 0;
        for (var gene : wordList) {
            graph.add(new ArrayList<>());
            map.put(gene, index++);
        }
        for(int i = 0; i < wordList.size(); i++) {
            var word1 = wordList.get(i);
            for (int j = i + 1; j < wordList.size(); j++) {
                var word2 = wordList.get(j);
                if(compare(word1, word2)) {
                    graph.get(map.get(word1)).add(map.get(word2));
                    graph.get(map.get(word2)).add(map.get(word1));
                }
            }
        }
        var result = new HashMap<Integer, Integer>();
        var visited = new HashSet<>();
        var queue = new LinkedList<Integer>();
        result.put(map.get(beginWord), 1);
        queue.add(map.get(beginWord));
        while (!queue.isEmpty()) {
            var curr = queue.poll();
            if(visited.contains(curr))
                continue;
            visited.add(curr);
            for (var i : graph.get(curr)) {
                if (!visited.contains(i)) {
                    queue.add(i);
                    result.put(i, Math.min(result.getOrDefault(i, Integer.MAX_VALUE), result.get(curr) + 1));
                }
            }
        }
        return result.getOrDefault(map.get(endWord), 0);
    }

    private boolean compare(String word1, String word2) {
        int diff = 0;
        for (int i = 0; i < word1.length(); i++) {
            if(word1.charAt(i) != word2.charAt(i)) {
                diff++;
                if(diff > 1)
                    return false;
            }
        }
        return diff == 1;
    }
}
