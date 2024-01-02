class Solution {
    public List<String> findHighAccessEmployees(List<List<String>> access_times) {
        Map<String, List<String>> map = new HashMap<>();
        for (List<String> ls : access_times) {
            List<String> x = map.get(ls.get(0));
            if (x == null) {
                x = new ArrayList<>();
                map.put(ls.get(0), x);
            }
            x.add(ls.get(1));
        }

        List<String> result = new ArrayList<>(access_times.size());
        for (Map.Entry<String, List<String>> e : map.entrySet()) {
            List<String> x = e.getValue();
            int m = x.size();
            if (m < 3) {
                continue;
            }

            int[] t = new int[m];
            for (int j = 0; j < m; ++j) {
                String s = x.get(j);
                t[j] = Integer.parseInt(s);
            }
            Arrays.sort(t);

            for (int a = 0, b = 2; b < m; ++a, ++b) {
                if ((t[b] - t[a]) < 100) {
                    result.add(e.getKey());
                    break;
                }
            }
        }
        return result;
    }
}