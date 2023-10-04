package pocketmon;

public abstract class Turn {
    public void runTurn() {
        startTurn();
        endTurn();
    }

    /**
     * Turn 동안 수행해야하는 내용들을 정의
     */
    protected abstract void startTurn();

    /**
     * Turn 종료시 처리되어야 하는 내용들을 정의
     */
    protected abstract void endTurn();
}
