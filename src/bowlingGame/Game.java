package bowlingGame;

public class Game {
    private boolean firstRollInFrame = true;
    private int currentFrame = 1;
    private Scorer scorer = new Scorer();

    public void add(int pins) {
        scorer.add(pins);
        adjustCurrentFrame(pins);
    }

    private void adjustCurrentFrame(int pins) {
        if (lastRollInFrame(pins)) {
            advanceFrame();
            firstRollInFrame = true;
        } else {
            firstRollInFrame = false;
        }
    }

    private boolean lastRollInFrame(int pins) {
        return isStrike(pins) || !firstRollInFrame;
    }

    private boolean isStrike(int pins) {
        return firstRollInFrame && pins == 10;
    }

    private void advanceFrame() {
        currentFrame = Math.min(10, currentFrame + 1);
    }

    public int getScore() {
        int frame;
        if (currentFrame == 10) {
            frame = 10;
        }
        else {
            frame = currentFrame - 1;
        }
        return scorer.getScoreForFrame(frame);
    }

    public int getScoreForFrame(int frame) {
        return scorer.getScoreForFrame(frame);
    }

    public int getCurrentFrame() {
        return currentFrame;
    }
}
