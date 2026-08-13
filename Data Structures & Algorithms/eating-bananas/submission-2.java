class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int i = 1;
        int j = 1_000_000_000;
        int ans = 0;

        while(i <= j) {
            int mid = (i + j) / 2;
            if(helper(piles, mid, h)) {
                ans = mid;
                j = mid - 1;
            } else {
                i = mid + 1;
            }
        }

        return ans;
    }
    public boolean helper(int[] p, int k, int h) {
        long req = 0;
        int n = p.length;

        for(int i = 0; i < n; i++) {
             req += (p[i] + (k - 1)) / k;
        }

        return req <= h;
    }
}
