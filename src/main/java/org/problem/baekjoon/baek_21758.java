package org.problem.baekjoon;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class baek_21758 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());
        int[] arr = new int[num];
        int[] rightSum = new int[num];
        int[] leftSum = new int[num];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < num; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        long res = 0;

        // 벌 오른쪽, 벌통 왼쪽 고정
        for (int i = num-1; i > 0; i--) {
            //            sum[0] = arr[1] + arr[2] + arr[3] + arr[4] + arr[5] + arr[6];
            //            sum[1] = arr[2] + arr[3] + arr[4] + arr[5] + arr[6];
            //            sum[2] = arr[3] + arr[4] + arr[5] + arr[6];
            //            sum[3] = arr[4] + arr[5] + arr[6];
            //            sum[4] = arr[5] + arr[6];
            //            sum[5] = arr[6];
            //            sum[6] = 0;
            rightSum[i-1] = arr[i-1] + rightSum[i];
            //            sum[4] = arr[5] + sum[5];
            //            ...
        }

        // 벌 왼쪽, 벌통 오른쪽 고정
        for (int i = 0; i<num-1;i++) {
            leftSum[i+1] = arr[i+1] + leftSum[i];
        }

        // 벌 양쪽 고정, 최대 구하기
        for (int i = 0; i<num-1;i++) {
            res = Math.max(res, Math.max(2*rightSum[0]-arr[i]-rightSum[i], Math.max(2*leftSum[num-1]-arr[i+1]-leftSum[i+1], rightSum[i+1]+leftSum[i+1])));
        }

        bw.write(String.valueOf(res));
        bw.flush();
    }
}
