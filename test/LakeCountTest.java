import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;

public class LakeCountTest {
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
        in.inputln("10");
        in.inputln("12");
        in.inputln("W........WW.");
        in.inputln(".WWW.....WWW");
        in.inputln("....WW...WW.");
        in.inputln(".........WW.");
        in.inputln(".........W..");
        in.inputln("..W......W..");
        in.inputln(".W.W.....WW.");
        in.inputln("W.W.W.....W.");
        in.inputln(".W.W......W.");
        in.inputln("..W.......W.");

        LakeCountSolution solution = new LakeCountSolution();
        Assert.assertThat(solution.solveLakeCount(), is(3));
    }
}
