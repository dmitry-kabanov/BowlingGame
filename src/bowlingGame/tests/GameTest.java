package bowlingGame.tests;

import bowlingGame.Game;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GameTest {
    private Game g;

    @Before
    public void setUp() {
        g = new Game();
    }

//    @Test
//    public void test_OneThrow_ScoreShouldEqualToPinsInThisThrow() {
//        g.add(5);
//
//        assertEquals(5, g.getScore());
//        assertEquals(1, g.getCurrentFrame());
//    }

    @Test
    public void test_OpenFrame_ScoreShouldBeSumOfTwoRolls() {
        g.add(5);
        g.add(4);

        assertEquals(9, g.getScore());
    }

    @Test
    public void testScore_TwoOpenFrames_ScoreShouldBeSumOfFourRolls() {
        g.add(5);
        g.add(4);
        g.add(7);
        g.add(2);

        assertEquals(18, g.getScore());
        assertEquals(9, g.getScoreForFrame(1));
        assertEquals(18, g.getScoreForFrame(2));
    }

    @Test
    public void testScore_OneSpare_ScoreShouldSumBonusForNextRoll() {
        g.add(3);
        g.add(7);
        g.add(4);

        assertEquals(14, g.getScoreForFrame(1));
    }

    @Test
    public void testScore_OneSpareFollowedByOpenFrame_ScoreShouldSumBonusForFirstRollInOpenFrame() {
        g.add(3);
        g.add(7);
        g.add(3);
        g.add(2);

        assertEquals(13, g.getScoreForFrame(1));
        assertEquals(18, g.getScoreForFrame(2));
        assertEquals(18, g.getScore());
    }

    @Test
    public void testScore_SimpleStrike_ScoreShouldSumBonusForTwoNextRollsAfterStrike() {
        g.add(10);
        g.add(3);
        g.add(6);

        assertEquals(19, g.getScoreForFrame(1));
        assertEquals(28, g.getScore());
    }

    @Test
    public void testScore_PerfectGame_ScoreShouldBeEqualTo300() {
        for (int i = 0; i < 12; i++) {
            g.add(10);
        }

        assertEquals(300, g.getScore());
    }

    @Test
    public void testScore_InFirst9FramesGutterRollsThenIn10FrameSpareAndStrike_ScoreShouldSum10FrameRollsAccountingSpare() {
        for (int i = 0; i < 9; i++) {
            g.add(0);
            g.add(0);
        }
        g.add(2);
        g.add(8);
        g.add(10);
        assertEquals(20, g.getScore());
    }

    @Test
    public void testScore_SampleGame_ScoreShouldAccountOpenFramesStrikesAndSpares() {
        g.add(1);
        g.add(4);

        g.add(4);
        g.add(5);

        g.add(6);
        g.add(4);

        g.add(5);
        g.add(5);

        g.add(10);

        g.add(0);
        g.add(1);

        g.add(7);
        g.add(3);

        g.add(6);
        g.add(4);

        g.add(10);

        g.add(2);
        g.add(8);
        g.add(6);

        assertEquals(133, g.getScore());
    }

    @Test
    public void testScore_ElevenStrikesAnd9Pins_ScoreShouldBe299() {
        for (int i = 0; i < 11; i++) {
            g.add(10);
        }
        g.add(9);

        assertEquals(299, g.getScore());
    }

    @Test
    public void testScore_9StrikesAndSpareInFinalFrame_ScoreShouldBe270() {
        for (int i = 0; i < 9; i++) {
            g.add(10);
        }
        g.add(9);
        g.add(1);
        g.add(1);

        assertEquals(270, g.getScore());
    }
}
