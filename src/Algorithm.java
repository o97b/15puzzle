import java.util.*;

public class Algorithm {

    static LinkedList<Position> path = new LinkedList<>();

    static PriorityQueue<Position> priorityQueue= new PriorityQueue<>(new Comparator<Position>() {
        @Override
        public int compare(Position o1, Position o2) {
            return Integer.compare(o1.weight(), o2.weight());
        }
    });

    public static LinkedList<Position> algorithm(Position currentPosition) {
        priorityQueue.add(currentPosition);
        ArrayList<Integer> visitedArrayPosition;
        List<Position> checkedPosition = new LinkedList<>();
        List<Position> neighbors = new LinkedList<>();

        Position previousPosition = null;

        while (!priorityQueue.isEmpty()) {
            currentPosition = priorityQueue.poll();

            if (currentPosition.equals(Main.endPosition)) {
                Position parent = currentPosition.parent;
                while (parent != null) {
                    path.addFirst(parent);
                    parent = parent.parent;
                }
                return path;
            }
            checkedPosition.add(currentPosition);



        }
        return null;
    }
}
