package chaewon.simulation;

import java.io.*;

public class 한국이_그리울_땐_서버에_접속하지_9996 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] pattern = br.readLine().split("\\*");

        int l1 = pattern[0].length();
        int l2 = pattern[1].length();

        while (n-- > 0) {
            String fileName = br.readLine();
            if (l1 + l2 > fileName.length()) {
                System.out.println("NE");
                continue;
            }

            String temp1 = fileName.substring(0, l1);
            String temp2 = fileName.substring(fileName.length() - l2);

            if (temp1.equals(pattern[0]) && temp2.equals(pattern[1])) {
                System.out.println("DA");
            } else {
                System.out.println("NE");
            }
        }
    }
}
