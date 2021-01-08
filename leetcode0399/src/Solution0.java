import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

/**
 * You are given an array of variable pairs equations and an array of real numbers values,
 * where equations[i] = [Ai, Bi] and values[i] represent the equation Ai / Bi = values[i].
 * Each Ai or Bi is a string that represents a single variable.
 *
 * You are also given some queries, where queries[j] = [Cj, Dj] represents the jth query
 * where you must find the answer for Cj / Dj = ?.
 *
 * Return the answers to all queries. If a single answer cannot be determined, return -1.0.
 *
 * Note: The input is always valid. You may assume that evaluating the queries will not
 * result in division by zero and that there is no contradiction.
 *
 * Example 1:
 * Input:
 * equations = [["a","b"],["b","c"]],
 * values = [2.0,3.0],
 * queries = [["a","c"],["b","a"],["a","e"],["a","a"],["x","x"]]
 * Output: [6.00000,0.50000,-1.00000,1.00000,-1.00000]
 * Explanation:
 * Given: a / b = 2.0, b / c = 3.0
 * queries are: a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ?
 * return: [6.0, 0.5, -1.0, 1.0, -1.0 ]
 *
 * Example 2:
 * Input:
 * equations = [["a","b"],["b","c"],["bc","cd"]],
 * values = [1.5,2.5,5.0],
 * queries = [["a","c"],["c","b"],["bc","cd"],["cd","bc"]]
 * Output: [3.75000,0.40000,5.00000,0.20000]
 *
 * Example 3:
 * Input:
 * equations = [["a","b"]],
 * values = [0.5],
 * queries = [["a","b"],["b","a"],["a","c"],["x","y"]]
 * Output: [0.50000,2.00000,-1.00000,-1.00000]
 */

public class Solution0 {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {

        HashMap<String, HashMap<String, Double>> map = new HashMap<>();
        for (int i = 0; i < equations.size(); i++) {
            String start = equations.get(i).get(0);
            String end = equations.get(i).get(1);
            double ratio = values[i];
            map.putIfAbsent(start, new HashMap<>());
            map.get(start).put(end,ratio);
            map.putIfAbsent(end, new HashMap<>());
            map.get(end).put(start, 1.0 / ratio);
        }
        double[] result = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            String start = queries.get(i).get(0), end  = queries.get(i).get(1);
            if (!map.containsKey(start) || !map.containsKey(end)) {
                result[i] = -1.0;
                continue;
            }
            result[i] = helper(map, start, end, new HashSet<>());
        }
        return result;
    }

    private double helper(HashMap<String, HashMap<String, Double>> map, String start, String end,
                          HashSet<String> visited) {
        if (map.get(start).containsKey(end)) {
            return map.get(start).get(end);
        }
        visited.add(start);
        for (Map.Entry<String,Double> entry : map.get(start).entrySet()) {
            if (visited.contains(entry.getKey())) {
                continue;
            }
            double result = helper(map, entry.getKey(), end, visited);
            if(result == -1.0) {
                continue;
            }
            return result * entry.getValue();
        }
        return -1.0;
    }
}
