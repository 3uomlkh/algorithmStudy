package hyunjin.deque;

//push_front X: 정수 X를 덱의 앞에 넣는다.
//push_back X: 정수 X를 덱의 뒤에 넣는다.
//        pop_front: 덱의 가장 앞에 있는 수를 빼고, 그 수를 출력한다. 만약, 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
//pop_back: 덱의 가장 뒤에 있는 수를 빼고, 그 수를 출력한다. 만약, 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
//size: 덱에 들어있는 정수의 개수를 출력한다.
//        empty: 덱이 비어있으면 1을, 아니면 0을 출력한다.
//front: 덱의 가장 앞에 있는 정수를 출력한다. 만약 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
//back: 덱의 가장 뒤에 있는 정수를 출력한다. 만약 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.

import java.util.Scanner;

public class 덱 {
    public static int[] deque;
    public static int size = 0;
    public static int popCount = 0;


    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int N = in.nextInt();

        deque = new int[N];

        for(int i = 0; i < N; i++) {

            String str = in.next();

            switch (str) {

                case "push_front":
                    push_front(in.nextInt());
                    break;

                case "push_back":
                    push_back(in.nextInt());
                    break;

                case "pop_front":
                    sb.append(pop_front()).append('\n');
                    break;

                case "pop_back":
                    sb.append(pop_back()).append('\n');
                    break;

                case "size":
                    sb.append(size()).append('\n');
                    break;

                case "empty":
                    sb.append(empty()).append('\n');
                    break;

                case "front":
                    sb.append(front()).append('\n');
                    break;

                case "back":
                    sb.append(back()).append('\n');
                    break;
            }

        }
        System.out.println(sb);
    }

    public static void push_front(int item) {
        for (int i = 0; i < size; i++) {
            deque[i + 1] = deque[i];
        }
        deque[0] = item;
        size++;
    }

    public static void push_back(int item) {
        deque[size] = item;
        size++;
    }

    public static int pop_front() {
        if(size == 0) {
            return -1;
        }
        else {
            int res = deque[popCount];
            deque[popCount] = 0;
            size--;
            popCount++;
            for (int j = 0; j < size; j++) {
                deque[j] = deque[j + 1];
            }
            return res;
        }
    }

    public static int pop_back() {
        if(size == 0) {
            return -1;
        }
        else {
            int res = deque[size - 1];
            deque[size - 1] = 0;
            size--;
            return res;
        }
    }

    public static int size() {
        return size;
    }

    public static int empty() {
        if(size == 0) {
            return 1;
        }
        else {
            return 0;
        }
    }

    public static int front() {
        if(size == 0) {
            return -1;
        }
        else {
            return deque[0];
        }
    }

    public static int back() {
        if(size == 0) {
            return -1;
        }
        else {
            return deque[size() - 1];
        }
    }

}
