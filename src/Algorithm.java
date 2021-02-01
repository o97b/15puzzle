import javafx.geometry.Pos;

import java.util.*;

public class Algorithm {

    static HashMap<Integer, Position> mapOfVisited = new HashMap<>();
    static LinkedList<Position> path = new LinkedList<>();

    static PriorityQueue<Position> priorityQueue= new PriorityQueue<>(new Comparator<Position>() {
        @Override
        public int compare(Position o1, Position o2) {
            return Integer.compare(o1.weight, o2.weight);
        }
    });

    public static LinkedList<Position> algorithm(Position currentPosition) {
        priorityQueue.add(currentPosition);
        ArrayList<Integer> visitedArrayPosition;
        List<Position> checkedPosition = new LinkedList<>();
        List<Position> neighbors = new LinkedList<>();

        while (!priorityQueue.isEmpty()) {
//        for( int i = 0; i < 5; i++) {
            currentPosition = priorityQueue.poll();
            System.out.println(currentPosition.positionArray.toString());
            mapOfVisited.put(currentPosition.positionArray.hashCode(), currentPosition);

            if (currentPosition.positionArray.equals(Main.endPosition.positionArray)) {
                Position parent = currentPosition.parent;
                while (parent != null) {
                    path.addFirst(parent);
                    parent = parent.parent;
                }
                path.add(Main.endPosition);
                return path;
            }
            checkedPosition.add(currentPosition); // Окрашиваем в черный

            neighbors = currentPosition.neighbors();
            for(Position position : neighbors) {
                int key = position.positionArray.hashCode();
                if (mapOfVisited.containsKey(key)) {
                    Position previousPosition = mapOfVisited.get(key);
                    if (previousPosition.stepForPosition > position.stepForPosition) {
                        mapOfVisited.put(key, position);
                        priorityQueue.remove(previousPosition);
                        priorityQueue.add(position);
                    }
                } else {
                    priorityQueue.add(position);
                    System.out.println("ADD " + position.positionArray.toString());
                    mapOfVisited.put(key, position);
                }
            }
            System.out.println("-------------");
            System.out.println(priorityQueue.size());
            System.out.println("-------------");
        }
        return null;
    }
}
