package calculator.lv1;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        // 양의 정수(0 포함)를 입력받기
        // 사칙연산 기호(➕,➖,✖️,➗)를 입력받기
        // 위에서 입력받은 양의 정수 2개와 사칙연산 기호를 사용하여 연산을 진행한 후 결과값을 출력하기
        // 반복문을 사용하되, 반복의 종료를 알려주는 “exit” 문자열을 입력하기 전까지 무한으로 계산을 진행할 수 있도록 소스 코드를 수정하기
        Scanner sc = new Scanner(System.in);

        System.out.print("첫 번째 양의 정수를 입력해주세요 : ");
        int integer1 = Integer.parseInt(sc.nextLine());
        System.out.print("두 번째 양의 정수를 입력해주세요 : ");
        int integer2 = Integer.parseInt(sc.nextLine());
        System.out.print("사칙연산 기호(➕,➖,✖\uFE0F,➗)를 입력해주세요 : ");
        char arithmetic = sc.nextLine().charAt(0);

        System.out.println(integer1);
        System.out.println(integer2);
        System.out.println(arithmetic);
    }
}
