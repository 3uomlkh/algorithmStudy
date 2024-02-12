package chaewon.linkedList;

import java.io.*;
import java.util.LinkedList;
import java.util.ListIterator;

// LinkedList로 풀어보려고 하였으나 실패하고 검색해서 푼 문제🥲(+ Stack을 이용해 푸는 방법도 있음)
public class 에디터 {
    public static void main(String[] args) throws IOException {
        // BufferedReader는 Scanner에 비해 속도가 빠름.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // BufferedWriter는 System.out.println()에 비해 속도가 빠름. 실제로 println()으로 제출하니 시간초과가 나옴.
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        int m = Integer.parseInt(br.readLine()); // BufferedReader는 String으로 리턴값 고정 -> 형변환 필요
        LinkedList<Character> list = new LinkedList<>();

        for (int i = 0; i < str.length(); i++) {
            list.add(str.charAt(i));
        }

        // ListIterator : Iterator를 상속한 인터페이스로, List 컬렉션을 순회하고 수정할 수 있음. 양방향 탐색이 가능함.
        ListIterator<Character> iter = list.listIterator();

        while (iter.hasNext()) { // 리스트에서 다음 요소가 있는지 여부를 확인
            iter.next();
        }

        for (int i = 0; i < m; i++) {
            String editor = br.readLine();
            char c = editor.charAt(0); // 입력받은 문자열의 맨 첫번째 문자

            switch(c) {
                case 'L' :
                    if (iter.hasPrevious()) iter.previous();
                    break;
                case 'D' :
                    if (iter.hasNext()) iter.next();
                    break;
                case 'B' :
                    if (iter.hasPrevious()) {
                        iter.previous();
                        iter.remove(); // previous()에 의해 반환된 가장 마지막 원소 제거
                    }
                    break;
                case 'P' :
                    char t = editor.charAt(2);
                    iter.add(t); // 띄어쓰기 공백을 제외한 문자를 추가
                    break;
                default:
                    break;
             }
        }

        for (Character c : list) {
            bw.write(c);
        }

        bw.flush(); // 남아있는 데이터 모두 출력
        bw.close(); // 출력 스트림 닫기
    }
}
