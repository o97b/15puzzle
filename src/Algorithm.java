import java.util.*;

public class Algorithm {

    static HashMap<Integer, Position> mapOfVisited = new HashMap<>();
    static LinkedList<Position> path = new LinkedList<>();
    static PriorityQueue<Integer> priorityQueue= new PriorityQueue<>(Comparator.comparingInt(o -> mapOfVisited.get(o).weight));

    public static LinkedList<Position> algorithm(Position currentPosition) {
        priorityQueue.add(currentPosition.hashCode());
        List<Position> neighbors;
        mapOfVisited.put(currentPosition.hashCode(), currentPosition);

        while (!priorityQueue.isEmpty()) {
            currentPosition = mapOfVisited.get(priorityQueue.poll());
            System.out.println("POLL " + currentPosition.positionArray.toString() + " Weight "
                    +  currentPosition.weight + " Step " + currentPosition.stepForPosition);
            mapOfVisited.put(currentPosition.hashCode(), currentPosition);

            if (currentPosition.positionArray.equals(Main.endPosition.positionArray)) {
                Position parent = currentPosition.parent;
                while (parent != null) {
                    path.addFirst(parent);
                    parent = parent.parent;
                }
                path.add(Main.endPosition);
                return path;
            }

            neighbors = currentPosition.neighbors();
            for(Position position : neighbors) {
                int key = position.hashCode();
                if (mapOfVisited.containsKey(key)) {
                    Position previousPosition = mapOfVisited.get(key);
                    if (previousPosition.stepForPosition > position.stepForPosition) {
                        mapOfVisited.put(key, position);
                    }
                } else {
                    mapOfVisited.put(key, position);
                    priorityQueue.add(position.hashCode());
                    System.out.println("ADD " + position.positionArray.toString() + " Weight " +  position.weight
                            + " Step " + position.stepForPosition);
                }
            }
            System.out.println("----------");
        }
        return null;
    }
}
