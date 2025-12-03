package day_one_secret_entrance;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner;
        final int DIAL_SIZE = 100;
        final int DIAL_INITIAL_POSITION = 50;
        try {
            scanner = new Scanner(new FileReader("day_one_secret_entrance/input"));
        } catch (FileNotFoundException exception) {
            System.out.println("Input file not found. Ending execution.");
            return;
        }

        ArrayList<DialRotation> allRotations = new ArrayList<>();

        while (scanner.hasNext()) {
            allRotations.add(DialRotation.fromLine(scanner.next()));
        }

        Dial dial = new Dial(DIAL_SIZE, DIAL_INITIAL_POSITION);

        int firstSolution = dial.getEndingZeroCounter(allRotations);
        System.out.println(firstSolution);

        dial.setCurrentPosition(DIAL_INITIAL_POSITION);

        int secondSolution = dial.getAnytimeZeroCounter(allRotations);
        System.out.println(secondSolution);

        scanner.close();
    }
}
