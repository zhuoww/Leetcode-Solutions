
class DetectSquares {
    int[][] counts = new int[1001][1001];

    public DetectSquares() {
        for (int i = 0; i <= 1000; i++) {
            for (int j = 0; j <= 1000; j++) {
                counts[i][j] = 0;
            }
        }
    }

    public void add(int[] point) {
        counts[point[0]][point[1]] += 1;
    }

    public int count(int[] point) {
        int x = point[0];
        int y = point[1];

        int res = 0;
        for (int i = 0; i <= 1000; i++) {
            int d = Math.abs(x - i);
            if (d == 0)
                continue;

            int j;
            j = y + d;
            if (j >= 0 && j <= 1000) {
                res += counts[i][j] * counts[i][y] * counts[x][j];
            }

            j = y - d;
            if (j >= 0 && j <= 1000) {
                res += counts[i][j] * counts[i][y] * counts[x][j];
            }
        }
        return res;
    }
}

/**
 * Your DetectSquares object will be instantiated and called as such:
 * DetectSquares obj = new DetectSquares();
 * obj.add(point);
 * int param_2 = obj.count(point);
 */