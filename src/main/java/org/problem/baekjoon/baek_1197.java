package org.problem.baekjoon;

import java.io.*;
import java.util.*;

public class baek_1197 {

    static int[] origin;
    static class Node {
        int start;
        int end;
        int value;

        public Node(int start, int end, int value){
            this.start = start;
            this.end = end;
            this.value = value;
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        origin = new int[v+1];
        for(int i = 1 ; i<v+1 ; i++) {
            origin[i] = i;
        }
//        bw.write(Arrays.toString(origin));
//        bw.newLine();

        Queue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.value - o2.value;
            }
        });

        for(int i=0; i<e; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            pq.add(new Node(start,end,value));
        }

        int sum = 0;
        int size = pq.size();
        for(int i=0; i<size; i++) {
            Node node = pq.poll();

            if(find(node.start) != find(node.end)) {
                sum += node.value;
                union(node.start, node.end);
            }
        }
        bw.write(Arrays.toString(origin));
        bw.write(String.valueOf(sum));
        bw.flush();
    }
    public static int find(int idx) {
        if(origin[idx] == idx ) return idx;
        return find(origin[idx]);
    }

    public static void union(int idx1, int idx2) {
        int p1 = find(idx1);
        int p2 = find(idx2);
        if(p1 != p2) {
            origin[p2] = p1;
        }
    }
}