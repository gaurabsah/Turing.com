package micro1.coding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/*
 * You are developing a text-based adventure game 
 * where players navigate through a series of interconnected rooms. 
 * Each room is represented by a node in a graph, and the connections 
 * between rooms are represented by edges. Your task is to implement a 
 * function that finds the shortest path between two rooms. 
 * Given a list of room connections and two room names, start and end, 
 * return the shortest path as a list of room names. If no path exists, 
 * return an empty list. The room connections are provided as a list of strings, 
 * where each string represents a bidirectional connection between two rooms 
 * in the format room A, room B. Room names are unique and case-sensitive.
 */

public class ShortestPath {
	
	public static List<String> findShortestPath(List<String> connections, String start, String end) {
        // Create the graph as an adjacency list
        Map<String, List<String>> graph = new HashMap<>();
        for (String connection : connections) {
            String[] rooms = connection.split(", ");
            String roomA = rooms[0];
            String roomB = rooms[1];
            graph.putIfAbsent(roomA, new ArrayList<>());
            graph.putIfAbsent(roomB, new ArrayList<>());
            graph.get(roomA).add(roomB);
            graph.get(roomB).add(roomA);
        }

        // Perform BFS to find the shortest path
        Queue<List<String>> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.offer(Collections.singletonList(start)); // Start with the initial room

        while (!queue.isEmpty()) {
            List<String> path = queue.poll();
            String currentRoom = path.get(path.size() - 1);

            // If we reach the destination, return the path
            if (currentRoom.equals(end)) {
                return path;
            }

            // Mark as visited and add neighbors to the queue
            if (!visited.contains(currentRoom)) {
                visited.add(currentRoom);
                for (String neighbor : graph.getOrDefault(currentRoom, new ArrayList<>())) {
                    List<String> newPath = new ArrayList<>(path);
                    newPath.add(neighbor);
                    queue.offer(newPath);
                }
            }
        }

        // If no path is found, return an empty list
        return Collections.emptyList();
    }

    public static void main(String[] args) {
        List<String> connections = Arrays.asList(
            "Room A, Room B",
            "Room B, Room C",
            "Room C, Room D",
            "Room D, Room E",
            "Room B, Room E"
        );

        String start = "Room A";
        String end = "Room E";

        List<String> shortestPath = findShortestPath(connections, start, end);
        System.out.println(shortestPath); // Output: [Room A, Room B, Room E]
    }

}
