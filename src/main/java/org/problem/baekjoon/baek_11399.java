package org.problem.baekjoon;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class baek_11399 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());
        int[] arr = new int[num];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i<num;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int[] sum = new int[num];
        sum[0] = arr[0];
        int res = 0;

        for (int i = 1;i<num;i++) {
            sum[i] = sum[i-1] + arr[i];
            res += sum[i];
        }
        bw.write(String.valueOf(res+sum[0]));
        bw.flush();
    }
}
