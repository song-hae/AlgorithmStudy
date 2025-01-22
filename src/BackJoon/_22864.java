package BackJoon;

import java.util.Scanner;

public class _22864 {

    public static void main(String[] args) {

        /* 1.
        A: 단위 피로도
        B: 단위 작업량 -> 이걸 누적으로 더해서 리턴
        C: 감소 피로도
        M: 최대 피로도
        2. A와 C는 한 변수에 접근, 그 변수를 M이 넘지 않도록, 반복은 24번.
         */

        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int m = sc.nextInt();
        int t = 0; //현재 피로도
        int ret = 0; //최대 작업량(리턴 값)

        for(int i = 0; i < 24 ; i++){
            if(t+a <= m){ // 작업 후 피로도가 최대 피로도보다 낮으면
                t += a; // 작업
                ret += b; // 작업량 증가
            } else { // 아니면
                t -= c; // 휴식
                if(t < 0) t=0; // 휴식 후 음수면 0으로
            }
        }
        System.out.println(ret);
    }
}