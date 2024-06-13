package hyunjin.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 한국이_그리울_땐_서버에_접속하지 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        String pattern = br.readLine();
        String[] patterns = pattern.split("\\*");

        for (int i = 0; i < N; i++) {
            String fileName = br.readLine();

            if (patterns[0].length() + patterns[1].length() > fileName.length()) {
                System.out.println("NE");
                continue;
            }

            String fileNameStart = fileName.substring(0, patterns[0].length());
            String fileNameEnd = fileName.substring(fileName.length() - patterns[1].length());


            if (fileNameStart.equals(patterns[0]) && fileNameEnd.equals(patterns[1])) {
                System.out.println("DA");
            } else {
                System.out.println("NE");
            }
        }

    }
}
