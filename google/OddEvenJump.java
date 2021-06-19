import java.util.*;

public class OddEvenJump {
    public static int solve(int [] steps){
        boolean [] odd = new boolean[steps.length];
        boolean [] even = new boolean[steps.length];
        Arrays.fill(odd, false);
        Arrays.fill(even, false);
        odd[steps.length - 1] = true;
        even[steps.length - 1] = true;

        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        treeMap.put(steps[steps.length - 1], steps.length - 1);

        for(int i=steps.length - 2; i >= 0; i--){
            int v = steps[i];

            // If there are 2 same keys, so it is the only value
            // that we can jump
            if(treeMap.containsKey(v)){
                odd[i] = even[treeMap.get(v)];
                even[i] = odd[treeMap.get(v)];
            }else {
                // Find the greatest smaller key & least higher key
                Integer lower = treeMap.lowerKey(v);
                Integer higher = treeMap.higherKey(v);

                // If there is a lower key, so that we can reach them
                // by even number of jumps, and it depends on if we can
                // reach them by odd number of jumps of that key
                if(lower != null)
                    even[i] = odd[treeMap.get(lower)];

                if(higher != null)
                    odd[i] = even[treeMap.get(higher)];
            }

            treeMap.put(v, i);
        }

        // Only count result if it is Odd number of jumps
        int result = 0;
        for(boolean isPossible: odd){
            if(isPossible)
                result++;
        }

        return result;
    }
}
