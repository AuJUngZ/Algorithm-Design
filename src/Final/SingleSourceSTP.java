package Final;

import java.util.HashMap;
import java.util.Map;

public class SingleSourceSTP {
    //    graph.put("A", new HashMap<>(Map.of("B", 1, "D",10)));
//        graph.put("B", new HashMap<>(Map.of("D", 1, "C", 2)));
//        graph.put("D", new HashMap<>(Map.of("C", 2)));
//        graph.put("C", new HashMap<>());
// output: "A": 0, "B": 1, "D": 2, "C": 3
    public static Map<String, Integer> singleSourceSTP(Map<String, Map<String, Integer>> graph, String start) {
        Map<String, Integer> result = new HashMap<>();
        for (String key : graph.keySet()) {
            if (key.equals(start)) {
                result.put(key, 0);
            } else {
                result.put(key, Integer.MAX_VALUE);
            }
        }
        return Helper(graph, result, start);
    }

    private static Map<String, Integer> Helper(Map<String, Map<String, Integer>> graph, Map<String, Integer> result, String start) {
        if (graph.get(start).isEmpty()) { //if no more neighbors do nothing
            return result;
        } else {
            for (String key : graph.get(start).keySet()) {
                if (result.get(key) > result.get(start) + graph.get(start).get(key)) {
                    result.put(key, result.get(start) + graph.get(start).get(key));
                }
                Helper(graph, result, key);
            }
            return result;
        }
    }

    public static int naiveSingleSourceSTP(Map<String, Map<String, Integer>> graph, String start, String end) {
        if (start.equals(end)) {
            return 0;
        } else {
            int min = Integer.MAX_VALUE;
            for (String key : graph.get(start).keySet()) { //loop through neighbors with start vertex
                min = Math.min(min, graph.get(start).get(key) + naiveSingleSourceSTP(graph, key, end));
            }
            return min;
        }
    }

    public static Map<String, Integer> inClassAlgorithm(Map<String, Map<String, Integer>> graph, String start, String end) {
        Map<String, Integer> result = new HashMap<>();
        return HelpInClassAlgorithm(graph, start, end, result);
    }

    private static Map<String, Integer> HelpInClassAlgorithm(Map<String, Map<String, Integer>> graph, String start, String end, Map<String, Integer> result) {
        if (start.equals(end)) {
            result.put(start, 0);
            return result;
        } else {
            //start from end vertex
            //find vertex that connects to end vertex
            int min = Integer.MAX_VALUE;
            for (String key : graph.keySet()) {
                if (graph.get(key).containsKey(start)) {
                    result.put(start, Math.min(result.getOrDefault(start, min), graph.get(key).get(start) + HelpInClassAlgorithm(graph, key, end, result).get(key)));
                }
            }
        }
        return result;
    }

    public static Map<String, Integer> inClassAlgorithmWithTable(Map<String, Map<String, Integer>> graph, String start, String end) {
        Map<String, Integer> result = new HashMap<>();
        Map<String, Integer> table = new HashMap<>();
        result = HelpInClassAlgorithmWithTable(graph, start, end, result, table);
        return result;
    }

    private static Map<String, Integer> HelpInClassAlgorithmWithTable(Map<String, Map<String, Integer>> graph, String start, String end, Map<String, Integer> result, Map<String, Integer> table) {
        if(start.equals(end)) {
            result.put(start, 0);
            table.put(start, 0);
            return result;
        }else {
            if(table.containsKey(start)) {
                return result;
            } else {
                int min = Integer.MAX_VALUE;
                for(String key : graph.keySet()) {
                    if(graph.get(key).containsKey(start)) {
                        int temp = graph.get(key).get(start) + HelpInClassAlgorithmWithTable(graph, key, end, result, table).get(key);
                        result.put(start, Math.min(result.getOrDefault(start, min), temp));
                        table.put(start, Math.min(table.getOrDefault(start, min), temp));
                    }
                }
            }
            return result;
        }
    }
}
