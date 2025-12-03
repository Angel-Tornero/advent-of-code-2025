package day_one_secret_entrance;

import java.util.ArrayList;

public class Dial {

    private final int size;
    private int currentPosition;

    public Dial(int dialSize, int initialPosition) throws IllegalArgumentException {
        if (dialSize <= initialPosition) {
            throw new IllegalArgumentException("Initial position of Dial must be lower than its size.");
        }
        this.size = dialSize;
        this.currentPosition = initialPosition;
    }

    private void rotate(DialRotation rotation) {
        if (rotation.getDirection() == Direction.RIGHT) {
            this.currentPosition = (this.currentPosition + rotation.getClicks()) % this.size;
        } else {
            int newPosition = currentPosition - (rotation.getClicks() % this.size);
            this.currentPosition = newPosition >= 0 ? newPosition : newPosition + this.size;
        }
    }

    /**
     * Counts how many times the dial points to zero at the end of a rotation.
     */
    public int getEndingZeroCounter(ArrayList<DialRotation> rotations) {
        int initialPosition = this.currentPosition;
        int counter = 0;
        this.currentPosition = initialPosition;
        for (DialRotation rotation : rotations) {
            this.rotate(rotation);
            if (this.currentPosition == 0) {
                counter++;
            }
        }
        return counter;
    }

    /**
     * Calculates how many times the dial has been pointing to zero in an only
     * rotation.
     */
    private int countPassesOfZero(DialRotation rotation) {

        // Right
        if (rotation.getDirection() == Direction.RIGHT)
            return (this.currentPosition + rotation.getClicks()) / this.size;

        // Left
        int distanceToZero = (this.size - this.currentPosition) % this.size;
        return (distanceToZero + rotation.getClicks()) / this.size;

    }

    /**
     * Counts how many times the dial points to the given position at any time
     * (ending or during a rotation).
     */
    public int getAnytimeZeroCounter(ArrayList<DialRotation> rotations) {
        int initialPosition = this.currentPosition;
        int counter = 0;
        this.currentPosition = initialPosition;
        for (DialRotation rotation : rotations) {
            counter += countPassesOfZero(rotation);
            this.rotate(rotation);
        }
        return counter;
    }

    // Getters and Setters

    public void setCurrentPosition(int currentPosition) {
        this.currentPosition = currentPosition;
    }
}
