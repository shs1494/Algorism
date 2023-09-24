package org.problem.baekjoon;

import java.io.*;

public class baek_1343 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String words = br.readLine();
        int count = 0;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i<words.length();i++) {
            char word = words.charAt(i);

            if (word == 'X') {
                count++;
                if (count == 4) {
                    sb.append("AAAA");
                    count = 0;
                }
            } else {
                if (count == 2) {
                    sb.append("BB");
                    sb.append(".");
                    count = 0;
                } else if (count == 0) {
                    sb.append(".");
                } else {
                    break;
                }
            }
        }

        if (count == 2) {
            sb.append("BB");
            bw.write(sb.toString());
        } else if (count == 0){
            bw.write(sb.toString());
        } else {
            bw.write(String.valueOf(-1));
        }

        bw.flush();
    }
}
