class Solution {
    public String[] findRelativeRanks(int[] score) {
        int n = score.length;
        String[] res = new String[n];

        HashMap<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            indexMap.put(score[i], i);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for (int s : score) {
            pq.add(s);
        }

        int rank = 1;
        while (!pq.isEmpty()) {
            int val = pq.poll();        
            int idx = indexMap.get(val);

            if (rank == 1) res[idx] = "Gold Medal";
            else if (rank == 2) res[idx] = "Silver Medal";
            else if (rank == 3) res[idx] = "Bronze Medal";
            else res[idx] = String.valueOf(rank);

            rank++;
        }

        return res;
    }
}
