package calculator.lv3;

import java.util.ArrayList;

public class ArithmeticCalculator<T extends Number> {
    private ArrayList<T> results = new ArrayList<>();

    public ArrayList<T> getResults() {
        return this.results;
    }
    public void setResults(ArrayList<T> results){
        this.results = results;
    }

    public T makeCalculator (T a, T b, char arithmetic){
        /*double result = 0;

        switch (arithmetic) {
            case '+':
                result = OperatorType.addition.apply(a.doubleValue(), b.doubleValue());
                break;
            case '-':
                result = OperatorType.subtract.apply(a, b);
                break;
            case '/':
                result = OperatorType.divide.apply(a, b);
                break;
            case '*':
                result = OperatorType.multiplication.apply(a, b);
                break;
            default:
                System.out.println("잘못된 접근입니다.");
                break;
        }

        return result;*/
        return null;
    }

    public void removeFirstResult(){
        results.removeFirst();
    }
}
