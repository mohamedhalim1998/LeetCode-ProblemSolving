import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class LeetCode_433 {
    public int minMutation(String startGene, String endGene, String[] bank) {
        HashSet<String> newBank = new HashSet<>(Arrays.asList(bank));
        newBank.add(startGene);
        newBank.add(endGene);
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        var map = new HashMap<String, Integer>();
        int index = 0;
        for (var gene : newBank) {
            graph.add(new ArrayList<>());
            map.put(gene, index++);
        }
        for (var gene1 : newBank) {
            for (var gene2 : newBank) {
                if (compareGenes(gene1, gene2)) {
                    graph.get(map.get(gene1)).add(map.get(gene2));
                }
            }
        }
        var result = new HashMap<Integer, Integer>();
        var visited = new HashSet<>();
        var queue = new LinkedList<Integer>();
        result.put(map.get(startGene), 0);
        queue.add(map.get(startGene));
        while (!queue.isEmpty()) {
            var curr = queue.poll();
            visited.add(curr);
            for (var i : graph.get(curr)) {
                if (!visited.contains(i)) {
                    queue.add(i);
                    result.put(i, Math.min(result.getOrDefault(i, Integer.MAX_VALUE), result.get(curr) + 1));
                }
            }
        }
        return result.getOrDefault(map.get(endGene), -1);
    }

    private boolean compareGenes(String gene1, String gene2) {
        int diff = 0;
        for (int i = 0; i < gene1.length(); i++) {
            if(gene1.charAt(i) != gene2.charAt(i)) {
                diff++;
            }
        }
        return diff == 1;
    }
}
