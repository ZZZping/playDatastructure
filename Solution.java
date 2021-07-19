package leetcode0007;

import java.util.*;

public class Solution {
  public int numWays(int n, int[][] relations, int k) {
    Map<Integer, Set<Integer>> map = new HashMap<>();
    for (int[] r : relations) {
      int a = r[0];
      int b = r[1];
      Set<Integer> set = map.getOrDefault(a, new HashSet<>());
      set.add(b);
      map.put(a, set);
    }
    Deque<Integer> deque = new ArrayDeque<>();
    deque.addLast(0);
    while (!deque.isEmpty() && k-- > 0) {
      int size = deque.size();
      while (size-- > 0) {
        int poll = deque.pollFirst();
        Set<Integer> integerSet = map.get(poll);
        if (integerSet == null) {
          continue;
        }
        for (int next : integerSet) {
          deque.addLast(next);
        }
      }
    }
    int ans = 0;
    while (!deque.isEmpty()) {
      if (deque.pollFirst() == n -1) {
        ans++;
      }
    }
    return ans;
  }
}
