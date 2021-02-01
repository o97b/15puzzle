import java.lang.invoke.SwitchPoint;
import java.util.*;

public class Position {

    int N = Main.N;
    List<Integer> positionArray;
    int  stepForPosition, weight;
    Position parent;

    public Position(List<Integer> positionArray, int step, Position parent) {
        this.positionArray = positionArray;
        this.stepForPosition = step;
        this.parent = parent;
        this.weight = weight();
    }

    @Override
    public int hashCode() {
        return positionArray.hashCode();
    }

    public boolean checkPosition() { // Проверка позиции на достижимость искомой
        return true;
    }

    public int manhattan() { // Расчет манхеттонского расстояния
        int result = 0, element;

        for (int i = 0; i < positionArray.size(); i++) {
            element = positionArray.get(i);
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


    private int weight() { // Вес позиции
        return manhattan() + stepForPosition;
    }


    public LinkedList<Position> neighbors() { // Соседние позиции

        int zeroPosition = 0, zeroPositionX = 0, zeroPositionY = 0;
        LinkedList<Position> neighbors = new LinkedList<>();

        for (int i = 0; i < positionArray.size(); i++) {
            if (positionArray.get(i) == 0) {
                zeroPosition = i;
                zeroPositionX = i % N;
                zeroPositionY = i / N;
            }
        }

        List<Integer> neighbor = new ArrayList<>(positionArray);
        if (zeroPositionX != 0) {
            Collections.swap(neighbor, zeroPosition, zeroPosition - 1);
            neighbors.add(new Position(neighbor, stepForPosition + 1, this));
        }
        neighbor = new ArrayList<>(positionArray);
        if (zeroPositionX != N-1) {
            Collections.swap(neighbor, zeroPosition, zeroPosition + 1);
            neighbors.add(new Position(neighbor, stepForPosition + 1, this));
        }
        neighbor = new ArrayList<>(positionArray);
        if (zeroPositionY != 0) {
            Collections.swap(neighbor, zeroPosition, zeroPosition - N);
            neighbors.add(new Position(neighbor, stepForPosition + 1, this));
        }
        neighbor = new ArrayList<>(positionArray);
        if (zeroPositionY != N-1) {
            Collections.swap(neighbor, zeroPosition, zeroPosition + N);
            neighbors.add(new Position(neighbor, stepForPosition + 1, this));
        }

        for (Position list : neighbors) {
            System.out.println("neighbor " + list.positionArray.toString());
        }

        return neighbors;
    }

}
