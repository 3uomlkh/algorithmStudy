package chaewon.sorting2;

import java.util.*;

// 답을 보고 적어본 문제 - 다시 풀기..
public class 시리얼_번호 {
    public static void main(String args[]) {
        // 기타의 개수 입력받기
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        // 시리얼 번호 n개 입력받기
        List<Item> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new Item(sc.next()));
        }

        Collections.sort(list);

        for (Item item : list) {
            System.out.println(item.text);
        }

    }
}
class Item implements Comparable<Item> { // Comparable을 이용해 compare를 재정의해서 풀어야 하는 함 -> 공부 필요
    int size;
    String text;
    int number;

    public Item(String text) {
        this.text = text;
        this.size = text.length();
        this.number = findNumber(text);
    }

    // 시리얼 번호 안 숫자들의 합 구하기
    private int findNumber(String str) {
        int sum = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                sum += str.charAt(i) - '0';
            }
        }
        return sum;
    }

    @Override
    public int compareTo(Item o) {
        return this.size > o.size ? 1 : this.size < o.size ? -1 : // 시리얼 번호의 길이 비교
                this.number > o.number ? 1 : this.number < o.number ? -1 : // 시리얼 번호 안 숫자들의 합 비교(작은 합이 먼저)
                        this.text.compareTo(o.text); // 사전순으로 비교 -> String.compareTo 메소드
    }
}
