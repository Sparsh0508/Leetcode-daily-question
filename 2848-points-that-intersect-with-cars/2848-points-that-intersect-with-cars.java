class Solution {
    public int numberOfPoints(List<List<Integer>> nums) {
    int[] line = new int[102];
    int points_on_line = 0;

    for (int i = 0; i < nums.size(); i++) {
        int s = nums.get(i).get(0);
        int e = nums.get(i).get(1);
        line[s] += 1;
        line[e + 1] -= 1;
    }

    for (int i = 1; i < 102; i++) {
        line[i] += line[i - 1];
        if (line[i] != 0) {
            points_on_line += 1;
        }
    }

    return points_on_line;
    }
}