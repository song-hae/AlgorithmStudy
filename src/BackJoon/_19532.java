package BackJoon;

import java.util.Scanner;

public class _19532 {

    public static void main(String[] args) {

        //1. 연립 방정식이기에 and 연산 활용
        //2. x,y는 -999부터 999까지의 정수이기에 순회하면서 만족하는 x,y찾기
        // O(N^2)인데 2000*2000 이라 ㄱㅊ

        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int d = sc.nextInt();
        int e = sc.nextInt();
        int f = sc.nextInt();

        for(int i=-999; i<1000 ; i++){ // x 값
            for(int j=-999; j<1000 ; j++){ // y 값
                if((a*i + b*j == c) && (d*i + e*j == f)) { // 연립 방정식 성립 시
                    System.out.print(i+" "+j);
                    return;
                }
            }
        }
    }
}