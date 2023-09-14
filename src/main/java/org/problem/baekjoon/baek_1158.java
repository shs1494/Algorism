package org.problem.baekjoon;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class baek_1158 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int num = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        bw.write("<");
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i<num;i++) {
            queue.add(i+1);
        }

        while (queue.size() > 1) {
            for (int i = 0;i<k-1;i++) {
                queue.add(queue.poll());
            }
            bw.write(String.valueOf(queue.poll()));
            bw.write(", ");
        }

        bw.write(queue.poll()+">");
        bw.flush();
    }
}