class Solution {
    public int orientation(int[] p1, int[] p2, int[] p3) {
        //Cross Product (p2-p1)x(p3-p2)
        //(ai+bj) x (ci+dj) = (ad-bc)k  (Vector cross product)
        int a = (p2[0]-p1[0]);
        int b = (p2[1]-p1[1]);
        int c = (p3[0]-p2[0]);
        int d = (p3[1]-p2[1]);
        int area = a*d-b*c;
        return area; //+ve for right orientation, -ve for left oritentation
    }

    public int[] top(Stack<int[]> stack) {
        return stack.get(stack.size()-1);
    }

    public int[] top2(Stack<int[]> stack) {
        return stack.get(stack.size()-2);
    }

    public int[][] outerTrees(int[][] trees) {
        if(trees.length<3){
            return trees;
        } 
        Arrays.sort(trees,(p,q) -> p[1] != q[1]?p[1]-q[1]:p[0]-q[0]); //sort from lowest y
        Stack<int[]> left = new Stack<>();      // Points to the left of bottom most point
        Stack<int[]> right = new Stack<>();     // Points to the right of bottom most point

        for(int[] tree: trees) {
            while(left.size()>=2 && orientation(top2(left),top(left),tree)<0) { //if orientation to left
                left.pop();
            }
            while(right.size()>=2 && orientation(top2(right),top(right),tree)>0) { //if orientation to right
                right.pop();
            }
            left.push(tree);
            right.push(tree);
        }

        Set<int[]> set = new HashSet<>();   //To remove duplicates;
        for(int[] l: left) {
            set.add(l);
        }
        for(int[] r: right) {
            set.add(r);
        }
        int[][] res = new int[set.size()][2];
        int idx = 0;
        for(int[] p: set) {
            res[idx++] = p;
        }
        return res;
    }
}