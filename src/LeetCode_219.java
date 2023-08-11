import java.util.ArrayList;
import java.util.HashMap;

public class LeetCode_219 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        var map = arrToFreqMap(nums);
        for(var list : map.values()) {
            for(int i = 0; i < list.size() - 1; i++) {
                if(Math.abs(list.get(i) - list.get(i + 1)) <= k ){
                    return true;
                }
            }
        }
        return false;
    }
    static HashMap<Integer, ArrayList<Integer>> arrToFreqMap(int[] arr) {
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            ArrayList<Integer> list = map.getOrDefault(arr[i], new ArrayList<>());
            list.add(i);
            map.put(arr[i], list);
        }
        return map;
    }
}
