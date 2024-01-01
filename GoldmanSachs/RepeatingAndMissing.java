class Solve {
    int[] findTwoElement(int arr[], int n) {
        int[] ans = new int[2];
        int xor = 0;
        for(int ele : arr){
            xor ^= ele;
        }
        for(int i=1;i<=n;i++){
            xor ^= i;
        }
        
        int rsb = xor & (-xor);
        int x = 0,y = 0;
        for(int ele:arr){
            if((rsb & ele) == 0){
                x ^= ele;
            }else{
                y ^= ele;
            }
        }
        for(int i=1;i<=n;i++){
            if((rsb & i) == 0){
                x ^= i;
            }
            else{
                y ^= i;
            }
        }
        
        for(int ele:arr){
            if(ele == x){
                ans[0] = x;
                ans[1] = y;
                return ans;
            }
            if(ele == y){
                ans[0] = y;
                ans[1] = x;
                return ans;
            }
        }
        return ans;
    }
}