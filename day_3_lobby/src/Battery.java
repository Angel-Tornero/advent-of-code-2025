package day_3_lobby.src;

public class Battery {
    private static int MIN_VOLTAGE = 1;
    private static int MAX_VOLTAGE = 9;

    private final int joltage;

    public Battery(int joltage) throws IllegalArgumentException {
        if (joltage < MIN_VOLTAGE || joltage > MAX_VOLTAGE)
            throw new IllegalArgumentException(
                    String.format("Joltage must be between %d and %d", MIN_VOLTAGE, MAX_VOLTAGE));
        this.joltage = joltage;
    }
}
