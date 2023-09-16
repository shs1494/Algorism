package org.problem.baekjoon;

import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class baek_10866 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());
        Deque<Integer> deque = new LinkedList<>();

        for (int i = 0 ; i < num ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            switch(st.nextToken()) {
                case "push_back":
                    deque.addLast(Integer.parseInt(st.nextToken()));
                    break;
                case "push_front":
                    deque.addFirst(Integer.parseInt(st.nextToken()));
                    break;
                case "pop_back":
                    if (deque.isEmpty()) {
                        bw.write(String.valueOf(-1));
                    } else {
                        bw.write(String.valueOf(deque.pollLast()));
                    }
                    bw.newLine();
                    break;
                case "pop_front":
                    if (deque.isEmpty()) {
                        bw.write(String.valueOf(-1));
                    } else {
                        bw.write(String.valueOf(deque.pollFirst()));
                    }
                    bw.newLine();
                    break;
                case "size":
                    bw.write(String.valueOf(deque.size()));
                    bw.newLine();
                    break;
                case "empty":
                    if (deque.isEmpty()) {
                        bw.write(String.valueOf(1));
                    } else {
                        bw.write(String.valueOf(0));
                    }
                    bw.newLine();
                    break;
                case "front":
                    if (deque.isEmpty()) {
                        bw.write(String.valueOf(-1));
                    } else {
                        bw.write(String.valueOf(deque.peekFirst()));
                    }
                    bw.newLine();
                    break;
                case "back":
                    if (deque.isEmpty()) {
                        bw.write(String.valueOf(-1));
                    } else {
                        bw.write(String.valueOf(deque.peekLast()));
                    }
                    bw.newLine();
                    break;
            }
        }
        bw.flush();
    }
}
