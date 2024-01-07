// https://leetcode.com/problems/circle-and-rectangle-overlapping/description/
class Solution {
    private boolean isValid(int cx, int cy, int r, int x, int y){
        if((x-cx)*(x-cx) + (y-cy)*(y-cy) > r*r){
            return true;
        }
        return false;
    }
    public boolean checkOverlap(int radius, int cx, int cy, int lcx, int lcy, int rcx, int rcy) {
        int cright = cx + radius;
        int cleft = cx - radius;
        int ctop = cy + radius;
        int cbottom = cy - radius;
        // check if square lies entirely to right
        if(lcx > cright && rcx > cright){
            return false;
        }
        // check if square lies entirely to left
        if(lcx < cleft && rcx < cleft){
            return false;
        }
        // check if square lies entirely to top
        if(lcy > ctop && rcy > ctop){
            return false;
        }
        // check if square lies entirely to bottom
        if(lcy < cbottom && rcy < cbottom){
            return false;
        }
        // check bottom right corner
        if(lcx < cright && lcx > cx && rcy > cbottom && rcy < cy){
            if(isValid(cx,cy,radius,lcx,rcy)){
                return false;
            }
        }
        // check top right corner
        if(lcx < cright && lcx > cx && lcy < ctop && lcy > cy){
            if(isValid(cx,cy,radius,lcx,lcy)){
                return false;
            }
        }
        // check bottom left right
        if(rcx > cleft && rcx < cx && rcy > cbottom && rcy < cy){
            if(isValid(cx,cy,radius,rcx,rcy)){
                return false;
            }
        }
        // check top left
        if(rcx > cleft && rcx < cx && lcy < ctop && lcy > cy){
            if(isValid(cx,cy,radius,rcx,lcy)){
                return false;
            }
        }
        return true;
    }
}