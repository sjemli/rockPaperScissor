package org.imc.rockpaperscissors.enums;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public enum Move {
    ROCK('R'), PAPER('P'), SCISSORS('S');

    private static final EnumMap<Move, Move> strongerToWeakerMoveMap = new EnumMap<>(Move.class);

    private static final Map<Character, Move> mnemonicToMoveMap;

    static {
        mnemonicToMoveMap = Arrays.stream(values())
                .collect(Collectors
                        .toMap(e -> e.mnemonic, Function.identity()));

        strongerToWeakerMoveMap.put(ROCK, SCISSORS);
        strongerToWeakerMoveMap.put(PAPER, ROCK);
        strongerToWeakerMoveMap.put(SCISSORS, PAPER);
    }

    private final char mnemonic;

    Move(char mnemonic) {
        this.mnemonic = mnemonic;
    }

    public static Optional<Move> fromMnemonic(char playerInput) {
        return Optional.ofNullable(mnemonicToMoveMap.get(playerInput));
    }

    public boolean beats(Move opponentMove) {
        return strongerToWeakerMoveMap.get(this) == opponentMove;
    }

}
