public class Chifoumi {
    public static ChifoumiAction getActionBeatenBy(ChifoumiAction chifoumiAction) {
        switch (chifoumiAction) {
            case ROCK:
                return ChifoumiAction.PAPER;
            case PAPER:
                return ChifoumiAction.SCISSOR;
            case SCISSOR:
                return ChifoumiAction.ROCK;
        }
        return chifoumiAction.PAPER;
    }
}