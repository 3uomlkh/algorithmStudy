package chaewon.bfsdfs;

public class 타겟_넘버 {
    static int answer = 0;
    public static void main(String[] args) {
        System.out.println(solution(new int[] {1, 1, 1, 1, 1}, 3));
        System.out.println(solution(new int[] {4, 1, 2, 1}, 4));
    }

    public static int solution(int[] numbers, int target) {
        dfs(0, numbers, target, 0);
        return answer;
    }

    public static void dfs(int index, int[] numbers, int target, int sum) {
        if (index == numbers.length) {
            if (target == sum) {
                answer++;
                return;
            }
            return;
        }

        dfs(index + 1, numbers, target, sum - numbers[index]);
        dfs(index + 1, numbers, target, sum + numbers[index]);
    }
}
