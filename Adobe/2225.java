class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        int[] counts = new int[100001];
        Arrays.fill(counts, -1);
        for (int[] match : matches) {
            int winner = match[0];
            int loser = match[1];
            if (counts[winner] == -1) {
                counts[winner] = 0;
            }
            
            if (counts[loser] == -1) {
                counts[loser] = 1;
            } else {
                counts[loser]++;
            }
        }
        
        List<List<Integer>> res = Arrays.asList(new ArrayList<>(), new ArrayList<>());
        for (int i = 1; i < 100001; i++) {
            if (counts[i] == 0) {
                res.get(0).add(i);
            }
            if (counts[i] == 1) {
                res.get(1).add(i);
            }
        }
        
        return res;
        
    }
}