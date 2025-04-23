package calculator.lv3;

import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArithmeticCalculator<Number> intCalculator = new ArithmeticCalculator<>();

        while (true) {
            Number num1 = inputPositiveNumber(sc, "첫 번째 양의정수를 입력해주세요 : ");
            Number num2 = inputPositiveNumber(sc, "두 번째 양의정수를 입력해주세요 : ");
            char arithmetic = inputArithmetic(sc);

            if(arithmetic == '/' && num2.doubleValue() == 0){
                System.out.println("나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다.");
                continue;
            }

            Number result = intCalculator.calculate(num1, num2, arithmetic);
            List<Number> tempArray = intCalculator.getResults();
            tempArray.add(result);
            intCalculator.setResults(tempArray);

            System.out.println("결과  : " + tempArray);
            System.out.print("remove 입력 시 결과의 첫 번째 요소를 제거  : ");
            String remove = sc.nextLine();
            if (remove.equals("remove")) {
                intCalculator.removeFirstResult();
                System.out.println("결과 : " + tempArray);
            }

            int soutArray = -1;
            while (true) {
                try {
                    System.out.print("입력받은 값보다 큰 결과값 들을 출력 : ");
                    soutArray = Integer.parseInt(sc.nextLine());
                    break;
                } catch (Exception e) {
                    System.out.println("숫자를 입력해 주세요");
                }
            }
            intCalculator.printGreaterNumber(soutArray);

            System.out.print("더 계산하시겠습니까? (exit 입력 시 종료) : ");
            String exit = sc.nextLine();
            if (exit.equals("exit")) {
                System.out.println("프로그램 종료");
                return;
            }
        }
    }

    public static Number inputPositiveNumber(Scanner sc, String printText) {
        Number number = null;
        while (true) {
            System.out.print(printText);
            String text = sc.nextLine();
            try {
                number = Double.parseDouble(text);
                if(number.doubleValue() > 0){
                    break;
                }
            } catch (Exception e){
                System.out.println("잘못된 값을 입력하였습니다.");
            }

            System.out.println("잘못된 값을 입력하였습니다.");
        }
        return number;
    }
    
    public static char inputArithmetic(Scanner sc) {
        boolean isWhile = true;
        char arithmetic = '-';
        while (isWhile) {
            System.out.print("사칙연산 기호(➕,➖,✖\uFE0F,➗)를 입력해주세요 : ");
            arithmetic = sc.nextLine().charAt(0);
            switch (arithmetic){
                case '+':
                case '-':
                case '*':
                case '/':
                    isWhile = false;
                    break;
                default:
                    System.out.println("잘못된 값을 입력하였습니다.");
                    break;
            }
        }
        return arithmetic;
    }
}
