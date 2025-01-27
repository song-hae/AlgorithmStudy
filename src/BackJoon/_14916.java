package BackJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _14916 {

            public static void main(String[] args) throws IOException {

        /*
        2원, 5원으로 최소 개수가 되도록 거스름돈
        안된다면 -1

        최소 개수가 되려면, 더 큰 5원을 먼저 써야 함
        그 다음 2원

        5로 나눈 후 그 나머지를 2로 나눔 그래도 나머지가 나오면 -1 반환

        예외
        5로 끝까지 나누면 2로 나누어 떨어지지 않을 수 있음 ex) 13

        5로 나눈 나머지가 2로 나누어 떨어지지 않는 경우에는 5로 나눈 나머지가 홀수라는 것
        -> 5로 하나 덜 나누게 되면 나머지는 짝수가 되어서 2로 나누어 떨어질 수 있음

        그럼 -1이 나오는 경우는 1, 3
        */
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                int change = Integer.parseInt(br.readLine());

                int five = change/5;
                int two = (change%5)/2;

                if(change>3 && (change%5)%2 != 0) {
                    five = change / 5 - 1;
                    two = (change % 5 + 5) / 2;
                }

                if(change == 1 || change == 3) System.out.print(-1);
                else System.out.print(five+two);


                }
            }
