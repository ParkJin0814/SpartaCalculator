package calculator.lv3;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ArithmeticCalculator<T extends Number> {
    private ArrayList<T> results = new ArrayList<>();

    public ArrayList<T> getResults() {
        return this.results;
    }
    public void setResults(ArrayList<T> results){
        this.results = results;
    }

    public T calculate (T num1, T num2, char arithmetic){
        T result = null;

        switch (arithmetic) {
            case '+':
                result = (T) OperatorType.addition.apply(num1, num2);
                break;
            case '-':
                result = (T) OperatorType.subtract.apply(num1, num2);
                break;
            case '/':
                result = (T) OperatorType.divide.apply(num1, num2);
                break;
            case '*':
                result = (T) OperatorType.multiplication.apply(num1, num2);
                break;
            default:
                System.out.println("잘못된 접근입니다.");
                break;
        }

        return result;
    }

    public void removeFirstResult(){
        results.removeFirst();
    }

    public void printGreaterNumber(T number){
        List<T> printList = results.stream()
                .filter((num)-> num.doubleValue() > number.doubleValue())
                .collect(Collectors.toList());
        System.out.println(printList);
    }

}
