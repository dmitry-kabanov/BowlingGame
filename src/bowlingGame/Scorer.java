package bowlingGame;

public class Scorer {
    private int rollIndex;
    private int[] rolls = new int[21];
    private int currentRoll = 0;

    public void add(int pins) {
        rolls[currentRoll++] = pins;
    }

    public int getScoreForFrame(int frame) {
        int score = 0;
        rollIndex = 0;
        for (int currentFrame = 0; currentFrame < frame; currentFrame++) {
            if (isStrike()) {
                score += 10 + getBonusForStrike();
                rollIndex++;
            } else if (isSpare()) {
                score += 10 + getBonusForSpare();
                rollIndex += 2;
            } else {
                score += getSumOfOpenFrame();
                rollIndex += 2;
            }
        }

        return score;
    }

    private boolean isStrike() {
        return rolls[rollIndex] == 10;
    }

    private int getBonusForStrike() {
        return rolls[rollIndex + 1] + rolls[rollIndex + 2];
    }

    private boolean isSpare() {
        return rolls[rollIndex] + rolls[rollIndex + 1] == 10;
    }

    private int getBonusForSpare() {
        return rolls[rollIndex + 2];
    }

    private int getSumOfOpenFrame() {
        return rolls[rollIndex] + rolls[rollIndex + 1];
    }
}
