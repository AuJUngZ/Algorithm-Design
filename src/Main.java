import Final.SingleSourceSTP;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String, Map<String, Integer>> graph = new HashMap<>();
        Map<String, Map<String, Integer>> result = new HashMap<>();
        String start = "A";
//        graph.put("A", new HashMap<>(Map.of("B", 0, "C", 10)));
//        graph.put("B", new HashMap<>(Map.of("C", 2)));
//        graph.put("C", new HashMap<>());
//        graph.put("A", new HashMap<>(Map.of("B", 1, "D",10)));
//        graph.put("B", new HashMap<>(Map.of("D", 1, "C", 2)));
//        graph.put("D", new HashMap<>(Map.of("C", 2)));
//        graph.put("C", new HashMap<>());
        graph.put("A", new HashMap<>(Map.of("B", 10, "D", 1)));
        graph.put("B", new HashMap<>(Map.of("C", 1)));
        graph.put("D", new HashMap<>(Map.of("C", 20)));
        graph.put("C", new HashMap<>());
//        System.out.println(SingleSourceSTP.naiveSingleSourceSTP(graph, start,"C"));
        System.out.println(SingleSourceSTP.singleSourceSTP(graph, start));
    }
}
