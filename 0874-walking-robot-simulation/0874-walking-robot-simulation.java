class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        HashSet<String> obs = new HashSet<>();
        for (int[] arr : obstacles) {
            obs.add(arr[0] + "," + arr[1]);
        }

        char ch = 'N';
        int max = 0;
        int x = 0, y = 0;

        for (int i = 0; i < commands.length; i++) {
            int curr = commands[i];

            if (curr == -1) {
                if (ch == 'N') ch = 'E';
                else if (ch == 'E') ch = 'S';
                else if (ch == 'S') ch = 'W';
                else ch = 'N';

            } else if (curr == -2) {
                if (ch == 'N') ch = 'W';
                else if (ch == 'W') ch = 'S';
                else if (ch == 'S') ch = 'E';
                else ch = 'N';

            } else {

                if (ch == 'N') {
                    for (int j = 0; j < curr; j++) {
                        if (obs.contains(x + "," + (y + 1))) break;
                        y++;
                    }
                } else if (ch == 'S') {
                    for (int j = 0; j < curr; j++) {
                        if (obs.contains(x + "," + (y - 1))) break;
                        y--;
                    }
                } else if (ch == 'W') {
                    for (int j = 0; j < curr; j++) {
                        if (obs.contains((x - 1) + "," + y)) break;
                        x--;
                    }
                } else if (ch == 'E') {
                    for (int j = 0; j < curr; j++) {
                        if (obs.contains((x + 1) + "," + y)) break;
                        x++;
                    }
                }

                max = Math.max(max, x * x + y * y);
            }
        }

        return max;
    }
}