class Solution {
    private boolean hasSub(String s, String w){
        int sl = s.length();
        int wl = w.length();
        int i=0,j=0;
        while(i < sl && j <wl){
            if(s.charAt(i) == w.charAt(j)){
                i++;
                j++;
            }
            else{
                i++;
            }
        }
        if(j == wl){
            return true;
        }
        return false;
    }
    public String findLongestWord(String s, List<String> dictionary) {
        String ans = "";
        int max = 0;
        for(String word:dictionary){
            if(hasSub(s,word)){
                if(word.length() > max){
                    max = word.length();
                    ans = word; 
                }
                if(word.length() == max){
                    if(ans.compareTo(word) > 0){
                        ans = word;
                    }
                }
            }
        }
        return ans;
    }
}