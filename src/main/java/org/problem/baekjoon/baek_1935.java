package org.problem.baekjoon;

import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;
import java.util.StringTokenizer;

public class baek_1935 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());
        String words = br.readLine();
        double[] a = new double[num];

        for (int i = 0; i<a.length;i++) {
            a[i] = Double.parseDouble(br.readLine());
        }

        Stack<Double> stack = new Stack<>();

//        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i<words.length();i++) {
            char word = words.charAt(i);
            if (word >= 'A' && word <= 'Z') {
//                a[word] = Integer.parseInt(st.nextToken());
                stack.add(a[word - 'A']);
            } else {
                double first = stack.pop();
                double second = stack.pop();
                switch (word) {
                    case '+' :
                        stack.add(second + first);
                        break;
                    case '-' :
                        stack.add(second - first);
                        break;
                    case '/' :
                        stack.add(second / first);
                        break;
                    case '*' :
                        stack.add(second * first);
                        break;
                }
            }
        }
//        String answer = String.format("%.2f",stack.pop());
        bw.write(String.format("%.2f",stack.pop()));
        bw.flush();
    }
}
