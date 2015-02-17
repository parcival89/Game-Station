package core.code;

import java.util.Random;

/**
 * @author SanderP
 * @version 0.0.1
 */
public enum CardType implements Comparable<CardType> {
    HARTEN(0),
    KOEKEN(1),
    KLAVEREN(2),
    SCHOPPEN(3);

    private final Integer code;

    private CardType(final int code) {
        this.code = code;
    }

    public Integer getCode() {
        return this.code;
    }

    public Boolean isCardType(CardType type) {
        return this.equals(type);
    }

    public Boolean isHigherThan(CardType other) {
        return this.compareTo(other) < 0;
    }

    public static CardType fromCode(int code) {
        for (CardType type : values()) {
            if (type.code.equals(code)) {
                return type;
            }
        }
        throw new IllegalArgumentException("Geen CardType voor code " + code);
    }

    public static CardType getRandomType() {
        Random random = new Random();
        return fromCode(random.nextInt(values().length));
    }
}
