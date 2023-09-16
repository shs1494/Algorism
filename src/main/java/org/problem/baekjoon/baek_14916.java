package org.problem.baekjoon;

import java.io.*;

public class baek_14916 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());
        int fiveCount = num / 5;
        int res = -1;

        while (fiveCount >= 0) {
            if ((num - 5*fiveCount) % 2 == 0) {
                res = fiveCount + ((num - 5*fiveCount) / 2);
                break;
            }
            fiveCount--;
        }

        bw.write(String.valueOf(res));
        bw.flush();
    }
}
