class Solution{
    static String printMinNumberForPattern(String s){
        StringBuilder ans = new StringBuilder();
        int cur = 1;
        Stack<Integer> stack = new Stack<>();
        for(char ch : s.toCharArray()){
            if(ch == 'I'){
                ans.append(String.valueOf(cur));
                while(!stack.isEmpty()){
                    ans.append(String.valueOf(stack.pop()));
                }
            }else{
                stack.push(cur);
            }
            cur++;
        }
        ans.append(String.valueOf(cur));
        while(!stack.isEmpty()){
            ans.append(String.valueOf(stack.pop()));
        }
        return ans.toString();
    }
}

// https://www.geeksforgeeks.org/problems/number-following-a-pattern3126/1