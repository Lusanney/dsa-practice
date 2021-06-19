public class MinNumOfChairs {
    private static int solve(ArrayList<Integer> S, ArrayList<Integer> E){
        HashMap<Integer, Integer> timeframe = new HashMap<>();

        for(int start : S){
            timeframe.put(start, timeframe.getOrDefault(start, 0) + 1);
        }
        for(int end : E){
            timeframe.put(end, timeframe.getOrDefault(end, 0) - 1);
        }

        List<Integer> startKeys = new ArrayList<>(timeframe.keySet());
        startKeys.sort(Comparator.comparingInt(start -> start));

        int count = 0;
        int maxCount = 0;
        for(Integer time : startKeys){
            count += timeframe.get(time);
            maxCount = Math.max(maxCount, count);
        }

        return maxCount;
    }
}
