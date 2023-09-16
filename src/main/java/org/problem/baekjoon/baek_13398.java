package org.problem.baekjoon;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class baek_13398 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] nums = new int[st.countTokens()];
        int[] sumNum = new int[nums.length];

        for (int i = 0; i<nums.length;i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        sumNum[0] = nums[0];
        for (int i = 1; i<sumNum.length;i++) {
            sumNum[i] = sumNum[i-1] + nums[i];
        }

        bw.write(Arrays.toString(nums));
        bw.newLine();
        bw.write(Arrays.toString(sumNum));
        bw.flush();
    }
}
