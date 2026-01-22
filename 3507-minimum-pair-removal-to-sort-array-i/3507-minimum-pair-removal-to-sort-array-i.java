class Solution {
    public int minimumPairRemoval(int[] nums) {
        ArrayList<Integer> al = new ArrayList<>();
        for (int a : nums) al.add(a);

        int count = 0;

        while (!isSorted(al)) {
            int min = Integer.MAX_VALUE;
            int index = 0;
            int n = al.size();

            for (int i = 0; i < n - 1; i++) {
                int val = al.get(i) + al.get(i + 1);
                if (val < min) {
                    min = val;
                    index = i;
                }
            }

            al.set(index, min);
            al.remove(index + 1);
            count++;
        }

        return count;
    }

    private boolean isSorted(ArrayList<Integer> al) {
        for (int i = 1; i < al.size(); i++) {
            if (al.get(i) < al.get(i - 1)) return false;
        }
        return true;
    }
}