import java.util.*;

public class Solution1 {
    static class Formula {
        String a;
        String b;
        double c;
        Formula (String a, String b, double c) {
            this(a, b);
            this.c = c;
        }
        Formula (String a, String b) {
            this.a = a;
            this.b = b;
        }
    }

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        List<Formula> sources = new ArrayList<>();
        for (int i = 0; i < values.length; i++) {
            Formula f = new Formula(equations.get(i).get(0), equations.get(i).get(1), values[i]);
            sources.add(f);
        }
        List<Formula> query = new ArrayList<>();
        for (List<String> strings : queries) {
            Formula f = new Formula(strings.get(0), strings.get(1));
            query.add(f);
        }
        return solution(sources, query);
    }

    double[] solution(List<Formula> sources, List<Formula> queries) {
        double[] res = new double[queries.size()];
        Arrays.fill(res, -1);
        List<Map<String, Double>> mapList = new ArrayList<>();

        while (sources.size() > 0) {
            Formula first = sources.get(0);
            Map<String, Double> curMap = new HashMap<>();
            curMap.put(first.a, 1.0);
            curMap.put(first.b, 1.0 / first.c);

            int preSize;
            do {
                preSize = sources.size();
                for (int i = 0; i < sources.size(); ) {
                    Formula cur = sources.get(i);
                    if (curMap.containsKey(cur.a) && curMap.containsKey(cur.b)) {
                        sources.remove(i);
                    } else if (curMap.containsKey(cur.a)) {
                        curMap.put(cur.b, curMap.get(cur.a) / cur.c);
                        sources.remove(i);
                    } else if (curMap.containsKey(cur.b)) {
                        curMap.put(cur.a, curMap.get(cur.b) * cur.c);
                        sources.remove(i);
                    } else {
                        i++;
                    }
                }
            } while (preSize != sources.size());
            mapList.add(curMap);
        }

        Iterator<Formula> iteratorQuery = queries.iterator();
        int index = 0;
        while (iteratorQuery.hasNext()) {
            Formula cur = iteratorQuery.next();
            for (Map<String, Double> curMap : mapList) {
                if (curMap.containsKey(cur.a) && curMap.containsKey(cur.b)) {
                    res[index] = curMap.get(cur.a) / curMap.get(cur.b);
                    break;
                }
            }
            index++;
        }
        return res;
    }
}
