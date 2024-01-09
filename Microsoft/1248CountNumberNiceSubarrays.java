class Solution {
    public int numberOfSubarrays(int[] arr, int k) {
        int n = arr.length;
        Map<Integer, Integer> mp = new HashMap<>();
        int count = 0;
        int ans = 0;
        for(int cur = 0; cur<n; cur++){
            if(arr[cur] % 2 != 0){
                count++;
            }
            if(count == k){
                ans++;
            }
            int req = count - k;
            if(mp.containsKey(req)){
                ans += mp.get(req);
            }
            mp.put(count, mp.getOrDefault(count, 0)+1);
        }
        return ans;
    }
}
// https://leetcode.com/problems/count-number-of-nice-subarrays/