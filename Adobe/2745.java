class Solution {
    public int longestString(int x, int y, int z) {
        int longestString = 0;
        
        longestString += z * 2;
        
        int aabbCount =  Math.min(x, y);
        longestString += aabbCount * 4;
        x -= aabbCount;
        y -= aabbCount;
        
        if(x > 0) {
            longestString +=2;
        }
        
        if(y > 0) {
            longestString +=2;
        }
        
        return longestString;
    }
}
