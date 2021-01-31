import java.util.*;

public class Position {

    int N = Main.N;
    int[] positionArray;
    int hashPosition, stepForPosition;

    public Position(int[] position, int step) {
        this.positionArray = position;
        this.stepForPosition = step;
        this.hashPosition = Arrays.hashCode(position);
    }

    public boolean checkPosition() { // Проверка позиции на достижимость искомой
        return true;
    }

    private int manhattan() { // Расчет манхеттонского расстояния
        int result = 0, element;

        for (int i = 0; i < positionArray.length; i++) {
            element = positionArray[i];
            if (element == 0) {
                result += (N - 1 - i % N) + (N - 1 - i / N);
            }
            else {
                if (i != element - 1) {
                    result += Math.abs(i % N - (element - 1) % N +
                            i / N - (element - 1) / N);
                }
            }
        }
        return result;
    }


    public int weight() { // Вес позиции
        return manhattan() + stepForPosition;
    }


    public LinkedList<int[]> neighbors() { // Соседние позиции

        int zeroPosition = 0, zeroPositionX = 0, zeroPositionY = 0;
        LinkedList<int[]> neighbors = new LinkedList<>();

        for (int i = 0; i < positionArray.length; i++) {
            if (positionArray[i] == 0) {
                zeroPosition = i;
                zeroPositionX = i % N;
                zeroPositionY = i / N;
            }
        }

        ArrayList<Integer> list = new ArrayList<>();


        int[] neighbor = positionArray.clone();
        if (zeroPositionX != 0) {
            int temp = neighbor[zeroPosition];
            neighbor[zeroPosition] = neighbor[zeroPosition-1];
            neighbor[zeroPosition-1] = temp;
            neighbors.add(neighbor);
        }
        neighbor = positionArray.clone();
        if (zeroPositionX != N-1) {
            Collections.swap(neighbors, zeroPosition, zeroPosition+1);
            int temp = neighbor[zeroPosition];
            neighbor[zeroPosition] = neighbor[zeroPosition+1];
            neighbor[zeroPosition+1] = temp;
            neighbors.add(neighbor);
        }
        neighbor = positionArray.clone();
        if (zeroPositionY != 0) {
            int temp = neighbor[zeroPosition];
            neighbor[zeroPosition] = neighbor[zeroPosition-N];
            neighbor[zeroPosition-N] = temp;
            neighbors.add(neighbor);
        }
        neighbor = positionArray.clone();
        if (zeroPositionY != N-1) {
            int temp = neighbor[zeroPosition];
            neighbor[zeroPosition] = neighbor[zeroPosition+N];
            neighbor[zeroPosition+N] = temp;
            neighbors.add(neighbor);
        }
        return neighbors;
    }
}
