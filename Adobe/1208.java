// https://leetcode.com/problems/get-equal-substrings-within-budget/
class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        int l = 0, r = 0;
        int len = 0;
        int cost = 0;
        while(r < s.length()){
            cost += Math.abs(s.charAt(r)-t.charAt(r));

            while(cost > maxCost){
                cost -= Math.abs(s.charAt(l)-t.charAt(l));
                l++;
            }

            len  = Math.max(len, r-l+1);
            r++;
        }
        return len;
    }
}