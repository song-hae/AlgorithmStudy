package BackJoon;

import java.util.Scanner;

public class _2581 {

    // 1. M부터 N까지 반복문
    // 2. 소수인지 파악 후 sum에 더함
    // 3. 최소값 변수 -1이면 넣기 (최솟값)

    // ++ 소수 판별은 짝수 날리고 시작하는게 더 좋음

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int N = sc.nextInt();
        int sum = 0;
        int small = 0;

        for(int i=M ; i <= N; i++){
            boolean isPrime = true;
            if(i == 2) {
                small = i;
                sum += i;
                continue;
            }
            else if(i == 1 || i%2 == 0) continue;

            for(int j=2 ; j <= Math.sqrt(i); j++){
                if(i % j == 0){
                    isPrime = false;
                    break;
                }
            }
            if(isPrime){
                sum += i;
                if(small == 0) small = i;
            }
        }
        if(sum == 0){
            System.out.println(-1);
        } else{
            System.out.println(sum);
            System.out.println(small);
        }
    }
}


