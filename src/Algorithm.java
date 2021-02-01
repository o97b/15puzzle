import javafx.geometry.Pos;

import java.util.*;

public class Algorithm {

    static HashMap<Integer, Position> mapOfVisited = new HashMap<>();
    static LinkedList<Position> path = new LinkedList<>();

    static PriorityQueue<Integer> priorityQueue= new PriorityQueue<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return Integer.compare(mapOfVisited.get(o1).weight, mapOfVisited.get(o2).weight);
        }
    });

    public static LinkedList<Position> algorithm(Position currentPosition) {
        priorityQueue.add(currentPosition.hashCode());
        ArrayList<Integer> visitedArrayPosition;
        List<Position> checkedPosition = new LinkedList<>();
        List<Position> neighbors = new LinkedList<>();
        mapOfVisited.put(currentPosition.hashCode(), currentPosition);

        while (!priorityQueue.isEmpty()) {
//        for( int i = 0; i < 5; i++) {
            currentPosition = mapOfVisited.get(priorityQueue.poll());
            System.out.println(currentPosition.positionArray.toString());
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
            checkedPosition.add(currentPosition);

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
                    System.out.println("ADD " + position.positionArray.toString());
                }
            }
            System.out.println("-------------");
            System.out.println(priorityQueue.size());
            System.out.println("-------------");
        }
        return null;
    }
}
