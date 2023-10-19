package org.problem.baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class baek_14889 {
    static int[][] arr;
    static boolean[] visited;
    static int res;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());
        arr = new int[num][num];
        visited = new boolean[num];

        for (int i = 0; i<num;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 0; j<num;j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        res = Integer.MAX_VALUE;

        bruteforce(num, 0,0);
        bw.write(String.valueOf(res));
        bw.flush();
        bw.close();
    }

    public static void bruteforce(int num, int idx, int depth) {
        if (depth == num / 2) {
            check(num);
            return;
        }

        for (int i = idx; i<num;i++) {
            if (!visited[i]) {
                visited[i] = true;
                bruteforce(num, i+1, depth+1);
                visited[i] = false;
            }
        }

    }

    public static void check(int num) {
        int start = 0;
        int link = 0;

        for (int i = 0;i<num-1;i++) {
            for (int j = i+1; j<num;j++) {
                if (visited[i] && visited[j]) {
                    start += arr[i][j];
                    start += arr[j][i];
                } else if (!visited[i] && !visited[j]) {
                    link += arr[i][j];
                    link += arr[j][i];
                }
            }
        }

        int sum = Math.abs(start - link);

        if (sum == 0) {
            res = 0;
            return;
        }

        res = Math.min(res, sum);
    }
}
