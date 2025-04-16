package calculator.lv2;

import java.util.ArrayList;

public class Calculator {
    private ArrayList<Integer> results = new ArrayList<>();

    public ArrayList<Integer> getResults() {
        return this.results;
    }
    public void setResults(ArrayList<Integer> results){
        this.results = results;
    }

    public int makeCalculator (int a, int b, char arithmetic){
        int result = 0;
        switch (arithmetic) {
            case '+':
                result = a + b;
                break;
            case '-':
                result = a - b;
                break;
            case '/':
                if(b == 0){
                    System.out.println("나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다.");
                } else {
                    result = a / b;
                }
                break;
            case '*':
                result = a * b;
                break;
            default:
                System.out.println("잘못된 접근입니다.");
                break;
        }

        return result;
    }


}
