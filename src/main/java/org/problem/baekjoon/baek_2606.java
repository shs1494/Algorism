package org.problem.baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class baek_2606 {
    static int count = 0;
    static boolean[][] map;
    static boolean[] visited;
    static int n,m,v;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        v = 1;

        map = new boolean[n+1][n+1];
        visited = new boolean[n+1];

        for (int i = 0; i<m;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            map[a][b] = map[b][a] = true;
        }

//        System.out.println(dfs(v));
        bw.write(String.valueOf(dfs(v)));
        bw.flush();
    }

    public static int dfs(int a) {
        visited[a] = true;

        for (int j = 0; j<=n;j++) {
            if (map[a][j] && visited[j] == false) {
                count++;
                dfs(j);
            }
        }
        return count;
    }
}