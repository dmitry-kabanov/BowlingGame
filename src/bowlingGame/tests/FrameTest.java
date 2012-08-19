package bowlingGame.tests;

import bowlingGame.Frame;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FrameTest {
    @Test
    public void testScore_NoThrows_ScoreShouldBeZero() {
        Frame f = new Frame();
        assertEquals(0, f.getScore());
    }

    @Test
    public void testScore_OneThrow_ScoreShouldBeEqualToPinsInThisThrow() {
        Frame f = new Frame();
        f.add(5);
        assertEquals(5, f.getScore());
    }
}
