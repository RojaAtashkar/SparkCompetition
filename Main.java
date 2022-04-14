import java.io.*;
import java.util.*;
public class spark2 {
    static int R, C;
    static int[] x = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] y = {-1, 0, 1, -1, 1, -1, 0, 1};
    static boolean search2D ( char[][] map, int i, int j, String word)
    {
        if (map[i][j] != word.charAt(0))
            return false;
        int l = word.length();
        for (int v = 0; v < 8; v++) {
            int k, i1 = i + x[v], j1 = j + y[v];
            for (k = 1; k < l; k++) {
                if (i1 >= R  i1 < 0  j1 >= C || j1 < 0)
                break;
                if (map[i1][j1] != word.charAt(k))
                    break;
                i1 += x[v];
                j1 += y[v];
            }
            if (k == l)
                return true;
        }
        return false;
    }
    static void patternSearch ( char[][] map, String word){
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] == word.charAt(0)) {
                    if (search2D(map, i, j, word))
                        System.out.print(word);
                }
            }
        }
    }
    public static void main(String[] args) {        {
        String word;
        Scanner sc = new Scanner(System.in);
        word = sc.nextLine();
        R = 3;
        C = 11;
        char[][] map = {{'m','f','m','e','r','l','h','i','w','d','f'},
                {'n','a','q','e','t','y','u','i','d','z','o'},
                {'q','c','p','r','f','x','u','t','b','x','e'}};
        patternSearch(map, word);
    }
    }
}