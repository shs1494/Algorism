package org.problem.baekjoon;

import java.io.*;
import java.util.*;

public class baek_1368 {
    static int[] arr;
    static int[] connect;
    static class Ground {
        int from;
        int to;
        int value;

        public Ground(int from, int to, int value) {
            this.from = from;
            this.to = to;
            this.value = value;
        }
    }
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());
        arr = new int[num+1];
        connect = new int[num+1];
        int sum = 0;
        for (int i = 1; i<connect.length;i++) {
            connect[i] = i;
        }

//        bw.write(Arrays.toString(connect));

        for (int i = 1;i<arr.length;i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
//        bw.newLine();
//        bw.write(Arrays.toString(arr));

        Queue<Ground> queue = new PriorityQueue<>(new Comparator<Ground>() {
            @Override
            public int compare(Ground o1, Ground o2) {
                return o1.value - o2.value;
            }
        });

        for (int i = 1; i<num+1;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 1; j<num+1;j++) {
                if (i == j) {
                    queue.add(new Ground(0,i,arr[i]));
                    st.nextToken();
                } else {
                    queue.add(new Ground(i,j,Integer.parseInt(st.nextToken())));
                }

            }
        }

        while (!queue.isEmpty()) {
            Ground ground = queue.poll();
            if (find(ground.from) != find(ground.to)) {
                union(ground.from, ground.to);
                sum += ground.value;
            }
        }

        bw.write(String.valueOf(sum));
        bw.flush();
    }

    public static int find(int idx) {
        if (connect[idx] == idx) {
            return idx;
        }
        return find(connect[idx]);
    }

    public static void union(int idx1, int idx2) {
        int origin1 = find(idx1);
        int origin2 = find(idx2);

        if (origin1 != origin2) {
            connect[origin2] = origin1;
        }
    }
}
