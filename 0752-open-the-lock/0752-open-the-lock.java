class Solution {
    public int openLock(String[] deadends, String target) {

        Set<String> dead = new HashSet<>();
        for (String d : deadends) dead.add(d);

        String start = "0000";
        if (dead.contains(start)) return -1;

        Queue<String> q = new LinkedList<>();
        Set<String> vis = new HashSet<>();

        q.offer(start);
        vis.add(start);

        int level = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                String curr = q.poll();

                if (curr.equals(target)) {
                    return level;
                }

                for (String next : getNeighbours(curr)) {
                    if (!dead.contains(next) && !vis.contains(next)) {
                        vis.add(next);
                        q.offer(next);
                    }
                }
            }
            level++;
        }
        return -1;
    }

    public List<String> getNeighbours(String curr) {
        List<String> res = new ArrayList<>();

        char[] arr = curr.toCharArray();

        for (int i = 0; i < 4; i++) {
            char original = arr[i];
            arr[i] = (original == '9') ? '0' : (char) (original + 1);
            res.add(new String(arr));
            
            arr[i] = (original == '0') ? '9' : (char) (original - 1);
            res.add(new String(arr));
            
            arr[i] = original;
        }
        return res;
    }
}