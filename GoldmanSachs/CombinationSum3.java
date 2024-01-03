class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        backtracking(n, k, ans, list, 1);
        return ans;
    }

    private void backtracking(int remain, int k, List<List<Integer>> ans, List<Integer> list, int start) {
        if(list.size() == k && remain != 0){
            return;
        }
        if (list.size() == k && remain == 0) {
            ans.add(new ArrayList<>(list));
            return;
        }

        for (int i = start; i <= 9; i++) {
            if (i > remain){
                break;
            }
            list.add(i);
            backtracking(remain - i, k, ans, list, i + 1);
            list.remove(list.size() - 1);
        }
    }
}

// https://leetcode.com/problems/combination-sum-iii/description/