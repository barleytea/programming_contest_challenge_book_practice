import java.util.Arrays;
import java.util.Scanner;

public class LakeCount {
    public static void main(String[] args) {
        LakeCountSolution solution = new LakeCountSolution();
        System.out.println(solution.solveLakeCount());
    }
}

class LakeCountSolution {
    private int n; // row
    private int m; // column
    private char[][] field;

    LakeCountSolution() {
        final Scanner scanner = new Scanner(System.in);
        n = Integer.parseInt(scanner.next());
        m = Integer.parseInt(scanner.next());
        field = new char[n][m];
        for (int i = 0; i < n; i++) {
            final char[] line = scanner.next().toCharArray();
            if (m >= 0) {
                System.arraycopy(line, 0, field[i], 0, m);
            }
        }
        System.out.println(Arrays.deepToString(field));
    }

    private void dfs(int x, int y) {
        field[x][y] = '.';

        for (int dx = -1; dx <= 1; dx++) {
            for (int dy = -1; dy <= 1; dy++) {
                int nx = x + dx; // next x
                int ny = y + dy; // next y
                if (0 <= nx && nx < n && 0 <= ny && ny < m && 'W' == field[nx][ny]) {
                    dfs(nx, ny);
                }
            }
        }
    }

    int solveLakeCount() {
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if ('W' == field[i][j]) {
                    dfs(i, j);
                    res++;
                }
            }
        }
        return res;
    }
}
