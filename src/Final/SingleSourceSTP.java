package Final;

import java.util.HashMap;
import java.util.Map;

public class SingleSourceSTP {
  //    graph.put("A", new HashMap<>(Map.of("B", 1, "D",10)));
  //        graph.put("B", new HashMap<>(Map.of("D", 1, "C", 2)));
  //        graph.put("D", new HashMap<>(Map.of("C", 2)));
  //        graph.put("C", new HashMap<>());
  // output: "A": 0, "B": 1, "D": 2, "C": 3
  public static Map<String, Integer> singleSourceSTP(
      Map<String, Map<String, Integer>> graph, String start) {
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

  private static Map<String, Integer> Helper(
      Map<String, Map<String, Integer>> graph, Map<String, Integer> result, String start) {
    if (graph.get(start).isEmpty()) { // if no more neighbors do nothing
      return result;
    } else {
      for (String key : graph.get(start).keySet()) {
        if (result.get(key) > result.get(start) + graph.get(start).get(key)) {
          result.put(key, result.get(start) + graph.get(start).get(key));
        }
        Helper(graph, result, key);
      }
      return result;
      //            int min = Integer.MAX_VALUE;
      //            String next = "";
      //            for (String key : graph.get(start).keySet()) {
      //                if (result.get(key) < min) {
      //                    min = result.get(key);
      //                    next = key;
      //                }
      //            }
      //            return Helper(graph, result, next);
    }
  }

  public static int naiveSingleSourceSTP(
      Map<String, Map<String, Integer>> graph, String start, String end) {
    if (start.equals(end)) {
      return 0;
    } else {
      int min = Integer.MAX_VALUE;
      for (String key : graph.get(start).keySet()) { // loop through neighbors with start vertex
        min = Math.min(min, graph.get(start).get(key) + naiveSingleSourceSTP(graph, key, end));
      }
      return min;
    }
  }
}
