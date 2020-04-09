package enums;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public enum Move implements Comparable<Move> {
    ROCK('R'), PAPER('P'), SCISSORS('S');

    private final char mnemonic;

    private static EnumMap<Move, Move> strongerToWeakerMoveMap = new
            EnumMap<>(Move.class);

    private static final Map<Character, Move> mnemonicToMoveMap = Arrays.stream(values())
            .collect(Collectors.toMap(e -> e.mnemonic, Function.identity()));
    public static Move[] values = values();

    static {
        strongerToWeakerMoveMap.put(ROCK, SCISSORS);
        strongerToWeakerMoveMap.put(PAPER, ROCK);
        strongerToWeakerMoveMap.put(SCISSORS, PAPER);
    }

    Move(char mnemonic) {
        this.mnemonic = mnemonic;
    }

    public static Optional<Move> fromMnemonic(char playerInput) {
        return Optional.ofNullable(mnemonicToMoveMap.get(playerInput));
    }

    public boolean beats(Move opponentMove) {
        return strongerToWeakerMoveMap.get(this) == opponentMove;
    }


/*   public int compare(Move opponentMove) {
        if (opponentMove == this) return 0;
        else if (strongerToWeakerMoveMap.get(this) == opponentMove) return 1;
        return -1;
    }*/

}
