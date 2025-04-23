package calculator.lv3;

import java.util.Scanner;

public class InputHandler {
    Scanner sc = new Scanner(System.in);

    public Number inputPositiveNumber(String printText) {
        Number number;
        while (true) {
            System.out.print(printText);
            String text = sc.nextLine();
            try {
                number = Double.parseDouble(text);
                if(number.doubleValue() > 0){
                    break;
                } else{
                    System.out.println("잘못된 값을 입력하였습니다.");
                }
            } catch (Exception e){
                System.out.println("잘못된 값을 입력하였습니다.");
            }
        }
        return number;
    }

    public char inputArithmetic() {
        boolean isWhile = true;
        char arithmetic = '-';
        while (isWhile) {
            System.out.print("사칙연산 기호(➕,➖,✖,➗)를 입력해주세요 : ");
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

    public Number inputNumber(String printText) {
        Number number;
        while (true) {
            System.out.print(printText);
            String text = sc.nextLine();
            try {
                number = Double.parseDouble(text);
                return number;
            } catch (Exception e){
                System.out.println("잘못된 값을 입력하였습니다.");
            }
        }
    }

    public String inputText(String printText){
        System.out.print(printText);
        return sc.nextLine();
    }
}
