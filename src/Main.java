import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class Main {
    static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static Position endPosition;

    static int ReadInt() throws IOException {
        return Integer.parseInt(bufferedReader.readLine());
    }

    public static void main(String[] args) throws Exception {
        // N = ReadInt();
        //int[] currentPositionArray = new int[N * N];
//            for (int i = 0; i < N * N; i++) {
//                currentPositionArray[i] = ReadInt();
//            }
        N = 3;
        int[] currentPositionArray = {1,0,3,4,5,6,7,8,2};

        bufferedReader.close();

        Position currentPosition = new Position(currentPositionArray, 0, null);

        Algorithm.algorithm(currentPosition);
    }
}
