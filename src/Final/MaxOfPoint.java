package Final;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MaxOfPoint {
  public static int maxOfPoint(List<int[]> setOfPoint) {
    int max = 0;
    HashMap<Double, List<int[]>> map = new HashMap<>();
    for (int i = 0; i < setOfPoint.size(); i++) {
      for (int j = i + 1; j < setOfPoint.size(); j++) {
        double slope =
            findSlope(
                setOfPoint.get(i)[0],
                setOfPoint.get(i)[1],
                setOfPoint.get(j)[0],
                setOfPoint.get(j)[1]);
        if (map.containsKey(slope)) {
          if (!map.get(slope).contains(setOfPoint.get(i))) {
            map.get(slope).add(setOfPoint.get(i));
          }
          if (!map.get(slope).contains(setOfPoint.get(j))) {
            map.get(slope).add(setOfPoint.get(j));
          }
        } else {
          int finalI = i;
          int finalJ = j;
          map.put(
              slope,
              new ArrayList<>() {
                {
                  add(setOfPoint.get(finalI));
                  add(setOfPoint.get(finalJ));
                }
              });
        }
      }
    }
    for (List<int[]> list : map.values()) {
      if (list.size() > max) {
        max = list.size();
      }
    }
    return max;
  }

  private static double findSlope(int x1, int y1, int x2, int y2) {
    return (double) (y2 - y1) / (x2 - x1);
  }
}
