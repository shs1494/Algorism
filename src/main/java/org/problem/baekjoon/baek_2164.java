package org.problem.baekjoon;

import java.io.*;
import java.util.*;

public class baek_2164 {
    public static void main(String args[]) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0;i<num;i++) {
            queue.add(i+1);
        }

        while (queue.size() > 1) {
            queue.poll();
            queue.add(queue.poll());
        }

        bw.write(String.valueOf(queue.poll()));
        bw.flush();
    }
}
