import Final.MaxOfPoint;
import Final.QuickSort;
import Final.RandomizeQuickSort;
import Final.SingleSourceSTP;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String,Integer> result = new HashMap<>();
        Map<String,Integer> result2 = new HashMap<>();
        Map<String, Map<String,Integer>> graph = new HashMap<>();
        graph.put("S", new HashMap<>(Map.of("A", 3, "B",1)));
        graph.put("A", new HashMap<>(Map.of("D" , 7)));
        graph.put("B", new HashMap<>(Map.of("A", 2, "D", 2, "C", 9)));
        graph.put("C", new HashMap<>(Map.of("Vs", 1)));
        graph.put("D", new HashMap<>(Map.of("Vs", 2,"C",10)));
        graph.put("Vs", new HashMap<>());

        result = SingleSourceSTP.inClassAlgorithm(graph,"Vs","S");
        result2 = SingleSourceSTP.inClassAlgorithmWithTable(graph,"Vs","S");

        return;
    }
}
