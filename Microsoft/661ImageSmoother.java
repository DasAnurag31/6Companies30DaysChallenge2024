// https://leetcode.com/problems/image-smoother/
class Solution {
    private int[] dx = {0,0,1,1,1,-1,-1,-1};
    private int[] dy = {1,-1,0,1,-1,0,1,-1};
    private boolean isValid(int x, int y, int rows, int cols){
        if(x < 0 || y < 0 || x >= rows || y >= cols){
            return false;
        }
        return true;
    }
    private int calc(int[][] img, int x, int y, int rows, int cols){
        int sum = img[x][y];
        int count = 1;
        for(int k = 0;k<8;k++){
            int nx = x + dx[k];
            int ny = y + dy[k];
            if(isValid(nx,ny,rows,cols)){
                count++;
                sum += img[nx][ny];
            }
        }
        return (int)Math.floor(sum/count);
    }
    public int[][] imageSmoother(int[][] img) {
        int rows = img.length;
        int cols = img[0].length;
        int[][] ans = new int[rows][cols];
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                ans[i][j] = calc(img,i,j,rows,cols);
            }
        }
        return ans;
    }
}