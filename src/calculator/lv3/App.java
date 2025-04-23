package calculator.lv3;

import java.util.List;


public class App {
    public static void main(String[] args) {
        ArithmeticCalculator<Number> intCalculator = new ArithmeticCalculator<>();
        InputHandler input = new InputHandler();

        while (true) {
            Number num1 = input.inputPositiveNumber("첫 번째 양의정수를 입력해주세요 : ");
            Number num2 = input.inputPositiveNumber("두 번째 양의정수를 입력해주세요 : ");
            char arithmetic = input.inputArithmetic();

            if(arithmetic == '/' && num2.doubleValue() == 0){
                System.out.println("나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다.");
                continue;
            }

            Number result = intCalculator.calculate(num1, num2, arithmetic);
            List<Number> tempArray = intCalculator.getResults();
            tempArray.add(result);
            intCalculator.setResults(tempArray);

            System.out.println("결과  : " + tempArray);


            if (input.inputText("remove 입력 시 결과의 첫 번째 요소를 제거  : ").equals("remove")) {
                intCalculator.removeFirstResult();
                System.out.println("결과 : " + tempArray);
            }

            // 입력받은값 보다 큰 결과값들만 출력
            Number removeGreateNumber = input.inputNumber("입력받은 값보다 큰 결과값 들을 출력 : ");
            intCalculator.printGreaterNumber(removeGreateNumber);

            if (input.inputText("더 계산하시겠습니까? (exit 입력 시 종료) : ").equals("exit")) {
                System.out.println("프로그램 종료");
                return;
            }
        }
    }
}
