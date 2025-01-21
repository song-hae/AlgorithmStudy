package BackJoon;

import java.util.Scanner;

public class _1978 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int len = scanner.nextInt();
        int cnt = 0;

        for(int i=0; i<len; i++){
            int num = scanner.nextInt();
            boolean isPrime = true;
            if(num == 2){
                cnt++;
                continue;
            }
            else if(num == 1) continue;

            for(int j=2; j <= num/2+1 ; j++) {
                if (num % j == 0) {
                    isPrime = false;
                    break;
                }
            }
            if(isPrime) cnt++;
        }
        System.out.println(cnt);
        }
    }

