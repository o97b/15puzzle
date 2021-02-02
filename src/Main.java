import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    static ArrayList<Integer> endArray = new ArrayList<>();
    static Position endPosition;
    static int N;

    public static int ReadInt() throws IOException {
        return Integer.parseInt(bufferedReader.readLine());
    }

    public static void main(String[] args) throws Exception {
        N = ReadInt();

        // Заполнение конечной позиции
        for (int i = 0; i < N * N - 1; i++) {
            endArray.add(i+1);
        } endArray.add(0);
        endPosition = new Position(endArray, Integer.MAX_VALUE, null);

        // Чтение стартовой позиции
        List<Integer> currentPositionArray = new ArrayList<>(N * N);
        for (int i = 0; i < N * N; i++) {
            currentPositionArray.add(ReadInt());
        }
        bufferedReader.close();

        Position currentPosition = new Position(currentPositionArray, 0, null);
        if (currentPosition.checkPosition()) {
            LinkedList<Position> PATH = Algorithm.algorithm(currentPosition);
            System.out.println("__________");
            for (Position position : PATH) {
                System.out.println(position.positionArray.toString());
            }
        } else {
            System.out.println("No solution");
        }
    }
}
