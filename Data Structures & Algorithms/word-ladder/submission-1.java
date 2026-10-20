
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (beginWord.length() != endWord.length()) return 0;

        Queue<String> q = new LinkedList<>();
        Set<String> vis = new HashSet<>( );
        q.add(beginWord);
        vis.add(beginWord);

        int steps = 1;

        while (!q.isEmpty()) {
            int sz = q.size();

            for (int i = 0; i < sz; i++) {
                String word = q.poll();

                if (word.equals(endWord)) return steps;

                for (String next : wordList) {
                    if (vis.contains(next)) continue;

                    int diff = 0;

                    for (int j = 0; j < word.length(); j++) {
                        if (word.charAt(j) != next.charAt(j)) {
                            diff++;
                        }
                    }

                    if (diff == 1) {
                        vis.add(next);
                        q.add(next);
                    }
                }
            }

            steps++;
        }

        return 0;
    }
}
