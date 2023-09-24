package org.problem.baekjoon;

import java.io.*;
import java.util.*;

public class baek_2141 {
    public static class Pair {
        int idx;
        int people;

        Pair(int idx, int people) {
            this.idx = idx;
            this.people = people;
        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());
        List<Pair> list = new ArrayList<>();
        long total = 0;
        int res = 0;

        for (int i = 0; i<num;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int idx = Integer.parseInt(st.nextToken());
            int people = Integer.parseInt(st.nextToken());

            Pair pair = new Pair(idx,people);
            list.add(pair);
            total += people;
        }

        Collections.sort(list, new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return Integer.compare(o1.idx,o2.idx);
            }
        });

        long sum = 0;
        for (int i = 0; i<num;i++) {
            sum += list.get(i).people;
            if (sum >= (total+1)/2) {
                res = list.get(i).idx;
                break;
            }

        }
        bw.write(String.valueOf(res));
        bw.flush();


        // idx(마을 위치) 가 마을 개수와 동일하지 않다.
        // 마을 수는 3개이나 마을의 위치가 1000 일 수도 있음.
//        int num = Integer.parseInt(br.readLine());
//        int[] arr = new int[num+1];
//        long total = 0;
//        int res = 0;
//
//        for (int i = 0; i<num;i++) {
//            StringTokenizer st = new StringTokenizer(br.readLine());
//            int idx = Integer.parseInt(st.nextToken());
//            int people = Integer.parseInt(st.nextToken());
//            st.nextToken();
//            arr[idx] = people;
//            total += people;
//
//        }
//
//        long sum = 0;
//
//        for (int i = 0; i<num;i++) {
//            sum += arr[i+1];
//            if (sum >= (total+1)/2) {
//                res = i+1;
//                break;
//            }
//        }
//        bw.write(String.valueOf(res));
//        bw.flush();
    }
}