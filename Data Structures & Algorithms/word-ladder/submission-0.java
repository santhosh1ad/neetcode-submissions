
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (beginWord.length() != endWord.length()) return 0;

        Set<String> set = new HashSet<>(wordList);
        if (!set.contains(endWord)) return 0;

        Queue<String> q = new LinkedList<>();
        q.add(beginWord);

        Set<String> vis = new HashSet<>();
        vis.add(beginWord);

        int steps = 1;

        while (!q.isEmpty()) {
            int sz = q.size();

            for (int i = 0; i < sz; i++) {
                String word = q.poll();

                if (word.equals(endWord)) return steps;

                for (int j = 0; j < word.length(); j++) {
                    String pattern =
                        word.substring(0, j) + "*" + word.substring(j + 1);

                    for (String ch : set) {
                        if (!vis.contains(ch) && ch.length() == word.length()) {
                            String candidate =
                                ch.substring(0, j) + "*" + ch.substring(j + 1);

                            if (pattern.equals(candidate)) {
                                vis.add(ch);
                                q.add(ch);
                            }
                        }
                    }
                }
            }

            steps++;
        }

        return 0;
    }
}
