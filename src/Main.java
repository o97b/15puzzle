import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static ArrayList<Integer> endArray = new ArrayList<>();

    static Position endPosition;

    static int ReadInt() throws IOException {
        return Integer.parseInt(bufferedReader.readLine());
    }

    public static void main(String[] args) throws Exception {
        N = ReadInt();

        endArray.add(1);
        endArray.add(2);
        endArray.add(3);
        endArray.add(4);
        endArray.add(5);
        endArray.add(6);
        endArray.add(7);
        endArray.add(8);
//        endArray.add(9);
//        endArray.add(10);
//        endArray.add(11);
//        endArray.add(12);
//        endArray.add(13);
//        endArray.add(14);
//        endArray.add(15);
        endArray.add(0);

        endPosition = new Position(endArray, Integer.MAX_VALUE, null);

        List<Integer> currentPositionArray = new ArrayList<>(N * N);
        for (int i = 0; i < N * N; i++) {
            currentPositionArray.add(ReadInt());
        }

        bufferedReader.close();

        Position currentPosition = new Position(currentPositionArray, 0, null);

        LinkedList<Position> PATH = Algorithm.algorithm(currentPosition);

        System.out.println("__________");

        for (Position position : PATH) {
            System.out.println(position.positionArray.toString());
        }


    }
}
