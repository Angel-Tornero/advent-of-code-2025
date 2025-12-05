package day_4_printing_department.src;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Main {

    private static final String INPUT_PATH = "day_4_printing_department/src/input";
    private static final int LIMIT_ALLOWED_ADJACENT_ROLLS = 4;

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new FileReader(INPUT_PATH))) {

            Grid grid = new Grid();

            while (scanner.hasNext()) {
                grid.addRowFromLine(scanner.next());
            }

            int firstSolution = grid.countAccessible(LIMIT_ALLOWED_ADJACENT_ROLLS);
            System.out.println(firstSolution);

            int secondSolution = grid.countAccessibleWithRemovals(LIMIT_ALLOWED_ADJACENT_ROLLS);
            System.out.println(secondSolution);

        } catch (FileNotFoundException exception) {
            System.err.println("Input file not found: " + INPUT_PATH);
        }
    }

}
