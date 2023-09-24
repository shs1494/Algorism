package org.problem.baekjoon;

import java.io.*;
import java.util.*;

public class baek_20115 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());
        double[] beverage = new double[num];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i<num ; i++) {
            beverage[i] = Double.parseDouble(st.nextToken());
        }
        Arrays.sort(beverage);
        double res = beverage[beverage.length-1];

        for (int i = beverage.length-2; i>=0; i--) {
            res += beverage[i]/2;
        }
        bw.write(String.valueOf(res));
        bw.flush();
    }
}
