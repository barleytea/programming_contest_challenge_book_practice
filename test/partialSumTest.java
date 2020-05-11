import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;

public class partialSumTest {

    private StandardInputStream in = new StandardInputStream();
    private StandardOutputStream out = new StandardOutputStream();

    @Before
    public void setUp() {
        System.setIn(in);
        System.setOut(out);
    }

    @After
    public void tearDown() {
        System.setIn(null);
        System.setOut(null);
    }

    @Test
    public void case1() {
        in.inputln("4");
        in.inputln("1");
        in.inputln("2");
        in.inputln("4");
        in.inputln("7");
        in.inputln("13");

        PartialSumSolution solution = new PartialSumSolution();
        Assert.assertThat(solution.solvePartialSum(0, 0), is(true));
    }

    @Test
    public void case2() {
        in.inputln("4");
        in.inputln("1");
        in.inputln("2");
        in.inputln("4");
        in.inputln("7");
        in.inputln("15");

        PartialSumSolution solution = new PartialSumSolution();
        Assert.assertThat(solution.solvePartialSum(0, 0), is(false));
    }
}
