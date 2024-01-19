class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> res = new ArrayList<>();
        List<int[]> heights = new ArrayList<>();
        // We are using height with different sign as a marker to mark start and end
        for (int[] building : buildings) {
            // Start of Building
            heights.add(new int[] { building[0], -building[2] });
            // End of Building
            heights.add(new int[] { building[1], building[2] });
        }

        Collections.sort(heights, (a, b) -> (
            a[0] == b[0]) ? a[1] - b[1] : a[0] - b[0]
        ); 
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        
        pq.offer(0);
        int prevMax = 0;

        for (int[] height : heights) { 
            if (height[1] < 0){
                pq.offer(-height[1]);
            }     
            else{
                pq.remove(height[1]);    
            }              
            int currMax = pq.peek();
            if (currMax != prevMax) {
                res.add(Arrays.asList(height[0], currMax));
                prevMax = currMax;
            }
        }
        return res;
    }
}