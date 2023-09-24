package org.problem.baekjoon;

import java.io.*;
import java.text.Format;
import java.util.*;

public class baek_1774 {
    static int[] arr;
    static class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

    }
    static class Distance {
        int from;
        int to;
        double value;

        Distance(int from, int to, double value) {
            this.from = from;
            this.to = to;
            this.value = value;
        }
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int num = Integer.parseInt(st.nextToken());
        int conCount = Integer.parseInt(st.nextToken());
        double sum = 0;
        arr = new int[num+1];
        List<Point> list = new ArrayList<>();
        Queue<Distance> queue = new PriorityQueue<>(new Comparator<Distance>() {
            @Override
            public int compare(Distance o1, Distance o2) {
                return Double.compare(o1.value,o2.value);
            }
        });
        list.add(new Point(0,0));
        for (int i = 1;i<arr.length;i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = i;
            list.add(new Point(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
        }

        for (int i = 0; i<conCount;i++) {
            st = new StringTokenizer(br.readLine());

            union(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        for (int i = 1; i<arr.length;i++) {
            for (int j = i+1; j<arr.length;j++) {
                queue.add(new Distance(i,j,Math.sqrt(Math.pow(list.get(i).x-list.get(j).x,2)+Math.pow(list.get(i).y-list.get(j).y,2))));
            }
        }

        while (!queue.isEmpty()) {
            Distance distance = queue.poll();

            if (find(distance.from) != find(distance.to)) {
                union(distance.from, distance.to);
                sum += distance.value;
            }
        }

        bw.write(String.format("%.2f",sum));
        bw.flush();
    }
    public static int find(int idx) {
        if (arr[idx] == idx) {
            return idx;
        }
        return find(arr[idx]);
    }
    public static void union(int idx1, int idx2) {
        int origin1 = find(idx1);
        int origin2 = find(idx2);

        if (origin1 != origin2) {
            arr[origin2] = origin1;
        }
    }
}
