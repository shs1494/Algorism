package org.problem.baekjoon;

import java.io.*;
import java.util.*;

public class baek_1922 {
    static int[] arr;
    static class Computer {
        int from;
        int to;
        int value;

        Computer(int from, int to, int value) {
            this.from = from;
            this.to = to;
            this.value = value;
        }
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        arr = new int[Integer.parseInt(br.readLine())+1];
        int e = Integer.parseInt(br.readLine());

        for (int i = 1; i<arr.length;i++) {
            arr[i] = i;
        }

        Queue<Computer> queue = new PriorityQueue<>(new Comparator<Computer>() {
            @Override
            public int compare(Computer o1, Computer o2) {
                return o1.value - o2.value;
            }
        });

        for (int i = 0; i<e;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());

            queue.add(new Computer(from,to,value));
        }

        int size = queue.size();
        int sum = 0;
        for (int i = 0; i<size;i++) {
            Computer computer = queue.poll();

            if (find(computer.from) != find(computer.to)) {
                union(computer.from, computer.to);
                sum += computer.value;
            }
        }

        bw.write(String.valueOf(sum));
        bw.flush();
    }

    public static int find(int comIdx) {
        if (arr[comIdx] == comIdx) {
            return comIdx;
        }
        return find(arr[comIdx]);
    }

    public static void union(int comIdx1, int comIdx2) {
        int parent1 = find(comIdx1);
        int parent2 = find(comIdx2);

        if (parent1 != parent2) {
            arr[parent2] = parent1;
        }
    }
}
