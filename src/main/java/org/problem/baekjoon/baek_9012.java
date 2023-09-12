package org.problem.baekjoon;

import java.io.*;
import java.util.Stack;

public class baek_9012 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());


        for (int i = 0; i<num;i++) {
            Stack<String> stack = new Stack<>();
            String str = br.readLine();
            boolean valid = true;

            for (int j = 0;j<str.length();j++) {
                if (str.charAt(j) == '(') {
                    stack.push("(");
                } else {
                    if (stack.isEmpty()) {
                        valid = false;
                        break;
                    }
                    stack.pop();
                }
            }
            if (stack.isEmpty() && valid) {
                bw.write("YES");
            } else {
                bw.write("NO");
            }
            bw.newLine();
        }
        bw.flush();
    }
}
