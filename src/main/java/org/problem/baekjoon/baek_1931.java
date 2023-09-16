package org.problem.baekjoon;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class baek_1931 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());
        int timeTable[][] = new int[num][2];

        for (int i = 0 ; i<num; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            timeTable[i][0] = Integer.parseInt(st.nextToken());
            timeTable[i][1] = Integer.parseInt(st.nextToken());
        }

        int count = 0;
        Arrays.sort(timeTable, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] == o2[1]) {
                    return o1[0] - o2[0];
                }
                return o1[1] - o2[1];
            }
        });

        int end = 0;
        for (int i = 0;i<num;i++) {
            if (end <= timeTable[i][0]) {
                end = timeTable[i][1];
                count++;
            }
        }

        bw.write(String.valueOf(count));
        bw.flush();
    }
}
