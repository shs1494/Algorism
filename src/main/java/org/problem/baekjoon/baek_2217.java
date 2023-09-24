package org.problem.baekjoon;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;

public class baek_2217 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());
        Integer arr[] = new Integer[num];


        for (int i = 0; i<num;i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr, Collections.reverseOrder());

        int res = 0;
        for (int i = 0; i<num;i++) {
            res = Math.max(res, arr[i] * (i+1));
        }

        bw.write(String.valueOf(res));
        bw.flush();
    }
}
