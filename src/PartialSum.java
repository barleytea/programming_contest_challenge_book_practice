import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PartialSum {

    public static void main(String[] args) {
        PartialSumSolution solution = new PartialSumSolution();
        System.out.println(solution.solvePartialSum(0, 0));
    }
}

class PartialSumSolution {
    private int n = 0;
    private List<Integer> a = new ArrayList<>();
    private int k = 0;

    PartialSumSolution() {
        final Scanner sc = new Scanner(System.in);
        for (int i = 0; sc.hasNext(); i++) {
            final int nextInt = Integer.parseInt(sc.next());
            if (i == 0) {
                this.n = nextInt;
            } else if (i <= this.n) {
                this.a.add(nextInt);
            } else {
                this.k = nextInt;
            }
        }
    }

    /**
     * given integer a_1, a_2, ... a_n,
     * check if sum of some numbers can be just k
     * solved by DFS
     * @return boolean if sum of some numbers can be just k
     */
    boolean solvePartialSum(int i, int sum) {
        // すべての入力値を足してちょうど k
        if (i == this.n) {
            return sum == k;
        }
        // 途中までの和が k になった時点で打ち切り
        if (solvePartialSum(i + 1, sum)) {
            return true;
        }
        // それ以外の場合は次の再帰
        return solvePartialSum(i + 1, sum + a.get(i));
    }
}


