public class GFG {
    private static final int NO_OF_CHARS = 256;
    private static int getNextState(char[] pat, int M, int state, int x) {
        if (state < M && x == pat[state]) {
            return state + 1;
        }
        int nextState, i;
        for (nextState = state; nextState > 0; nextState --) {
            if (pat[nextState - 1] == x) {
                for (i = 0; i < nextState - 1; i ++) {
                    if (pat[i] != pat[state - nextState + 1 + i]) {
                        break;
                    }
                    if (i == nextState - 1) {
                        return nextState;
                    }
                }
            }
        }
        return 0;
    }

    private static void computeTF(char[] pat, int M, int[][] TF) {
        int state, x;
        for (state = 0; state <= M; ++ state) {
            for (x = 0; x < NO_OF_CHARS; ++ x) {
                TF[state][x] = getNextState(pat, M, state, x);
            }
        }
    }

    public static void search(char[] pat, char[] txt) {
        int M = pat.length;
        int N = txt.length;
        int[][] TF = new int[M + 1][NO_OF_CHARS];
        computeTF(pat, M, TF);
        int i, state = 0;
        for (i = 0; i < N; i++) {
            state = TF[state][txt[i]];
            if (state == M) {
                System.out.println("Pattern found at index " + (i - M + 1));
            }
        }
    }
}
