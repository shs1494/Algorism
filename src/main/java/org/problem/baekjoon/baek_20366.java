package org.problem.baekjoon;

import java.io.*;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.StringTokenizer;

public class baek_20366 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());
        int[] snows = new int[num];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i<num;i++) {
            snows[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(snows);
        int res = Integer.MAX_VALUE;

        for(int i=0; i<num-3; i++) {
            for(int j=i+3; j<num; j++) {
                int left = i+1;
                int right = j-1;

                while(left < right) {
                    int heiht = snows[left] + snows[right] - snows[i] - snows[j];

                    if(res > Math.abs(heiht)) {
                        res = Math.abs(heiht);
                    }

                    if(heiht > 0) {
                        right = right - 1;
                    } else {
                        left = left + 1;
                    }
                }
            }
        }

        bw.write(String.valueOf(res));
        bw.flush();
    }
}
