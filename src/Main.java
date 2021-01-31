import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
    static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    static int N;

    static int ReadInt() throws IOException {
        return Integer.parseInt(bufferedReader.readLine());
    }

    public static void main(String[] args) throws Exception {
        N = ReadInt();
        int[] currentPositionArray = new int[N * N];
        for (int i = 0; i < N * N; i++) {
            currentPositionArray[i] = ReadInt();
        }
        bufferedReader.close();

        Position currentPosition = new Position(currentPositionArray, 0);

        algorithm(currentPosition);
    }

    PriorityQueue<Position> priorityQueue= new PriorityQueue<>(new Comparator<Position>() {
        @Override
        public int compare(Position o1, Position o2) {
            return 0;
        }
    });


    public static void algorithm(Position currentPosition) {

    }

}
