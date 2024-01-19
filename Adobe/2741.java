class Solution {
    int len;
    HashMap<String,Long> dp;
    
    public int specialPerm(int[] nums) {
        len = nums.length;
        dp = new HashMap<>();
        return (int)helper(nums,0,-1,new boolean[len],0);
    }
    
    public long helper(int[] nums,int ind,int prev, boolean[] used,long mask){
        if(ind == len){
            return 1;
        } 
        String key = String.valueOf(prev)+"."+String.valueOf(mask);
        if(dp.containsKey(key)){
            return dp.get(key);
        } 
        
        long temp = 0;
        for(int i=0;i<len;i++){
            if(used[i]){
                continue;
            } 
            if(prev % nums[i] == 0 || nums[i] % prev == 0){
                used[i] = true;
                int cur = i;
                long one = 1<<cur;
                mask = mask | one;
                temp = (temp + helper(nums,ind+1,nums[i],used,mask))%1000000007;
                mask = mask ^ one;
                used[i] = false;
            }
        }
        dp.put(key,temp);
        return temp;
    }
}