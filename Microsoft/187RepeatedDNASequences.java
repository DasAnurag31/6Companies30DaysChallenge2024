class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        int left = 0;
        int right = 10;
        List<String> result = new ArrayList<>();
        if(s.length() <= 10) return result;
        HashSet<String> registry = new HashSet<>();
        HashSet<String> dublicate = new HashSet<>();
        while(right <= s.length()){
            String item = s.substring(left,right);
            right++;
            left++;
            if(registry.contains(item)){
                dublicate.add(item);
            }
            else{
                registry.add(item);
            }
        }
        for(String ele : dublicate){
            result.add(ele);
        }
        return result;
    }
}

// https://leetcode.com/problems/repeated-dna-sequences/