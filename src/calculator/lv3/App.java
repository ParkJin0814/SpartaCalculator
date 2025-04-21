package calculator.lv3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        // 1. 현재 사칙연산 계산기는 (➕,➖,✖️,➗) 이렇게 총 4가지 연산 타입으로 구성되어 있습니다.
        // Enum 타입을 활용하여 연산자 타입에 대한 정보를 관리하고 이를 사칙연산 계산기 ArithmeticCalculator 클래스에 활용 해봅니다.

        // 2. 실수, 즉 double 타입의 값을 전달 받아도 연산이 수행하도록 만들기
        // 단순히, 기존의 Int 타입을 double 타입으로 바꾸는 게 아닌 점에 주의하세요!
        // 지금까지는 ArithmeticCalculator, 즉 사칙연산 계산기는 양의 정수(0 포함)를 매개변수로 전달받아 연산을 수행
        // 피연산자를 여러 타입으로 받을 수 있도록 기능을 확장
        //ArithmeticCalculator 클래스의 연산 메서드(calculate)
        // 위 요구사항을 만족할 수 있도록 ArithmeticCalculator 클래스를 수정합니다. (제네릭)
        //추가적으로 수정이 필요한 다른 클래스나 메서드가 있다면 같이 수정 해주세요.

        // 3. 저장된 연산 결과들 중 Scanner로 입력받은 값보다 큰 결과값 들을 출력
        // ArithmeticCalculator 클래스에 위 요구사항을 만족하는 조회 메서드를 구현합니다.
        // 단, 해당 메서드를 구현할 때 Lambda & Stream을 활용하여 구현합니다
        // Java 강의에서 람다 & 스트림을 학습 및 복습 하시고 적용 해보세요!
        // 추가) 람다 & 스트림 학습을 위해 여러 가지 조회 조건들을 추가하여 구현 해보시면 학습에 많은 도움이 되실 수 있습니다.
        Scanner sc = new Scanner(System.in);
        ArithmeticCalculator<Integer> intCalculator = new ArithmeticCalculator<>();

        while (true) {
            int num1 = inputNumber(sc);
            int num2 = inputNumber(sc);            
            char arithmetic = inputArithmetic(sc);

            int result = intCalculator.calculate(num1, num2, arithmetic);
            List<Integer> tempArray = intCalculator.getResults();
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

    public static int inputNumber(Scanner sc) {
        int num = -1 ;
        while (num < 0) {
            System.out.print("양의 정수를 입력해주세요 : ");
            String text = sc.nextLine();
            if(text.chars().allMatch(Character::isDigit)){
                num = Integer.parseInt(text);
            } else {
                System.out.println("잘못된 값을 입력하였습니다.");
            }
        }
        return num;
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
