class TimeMap {

    private HashMap<String, List<Pair>> map;

    static class Pair {
        int timestamp;
        String value;

        Pair(int timestamp, String value) {
            this.timestamp = timestamp;
            this.value = value;
        }
    }

    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        map.computeIfAbsent(key, k -> new ArrayList<>())
           .add(new Pair(timestamp, value));
    }
    
    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) {
            return "";
        }

        List<Pair> list = map.get(key);

        int l = 0;
        int r = list.size() - 1;

        String ans = "";

        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (list.get(mid).timestamp <= timestamp) {
                ans = list.get(mid).value;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return ans;
    }
}