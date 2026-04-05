class Solution {
    public List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
        Set<Integer> res = new HashSet<>();
        Set<Integer> s1 = new HashSet<>();
        Set<Integer> s2 = new HashSet<>();
        Set<Integer> s3 = new HashSet<>();

        for (int x : nums1) s1.add(x);
        for (int x : nums2) s2.add(x);
        for (int x : nums3) s3.add(x);

        for (int x : s1) {
            if (s2.contains(x) || s3.contains(x)) res.add(x);
        }

        for (int x : s2) {
            if (s3.contains(x)) res.add(x);
        }

        return new ArrayList<>(res);
    }
}