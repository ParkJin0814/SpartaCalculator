package calculator.lv3;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ArithmeticCalculator<T extends Number> {
    private List<T> results = new ArrayList<>();

    public List<T> getResults() {
        return this.results;
    }
    public void setResults(List<T> results){
        this.results = results;
    }

    public T calculate (T num1, T num2, char arithmetic){
        OperatorType op = OperatorType.ofArithmetic(arithmetic);
        Number number = op.operation.apply(num1, num2);

        return (T)returnTypeValue(number, num1);
    }

    public void removeFirstResult(){
        results.removeFirst();
    }

    public void printGreaterNumber(T number){
        System.out.println(results.stream()
                .filter((num)-> num.doubleValue() > number.doubleValue())
                .collect(Collectors.toList()));
    }

    private Number returnTypeValue(Number number, T t){
        if(t instanceof Double){
            number = number.doubleValue();
        } else if (t instanceof Float){
            number = number.floatValue();
        } else if (t instanceof Long){
            number = number.longValue();
        } else if (t instanceof Integer){
            number = number.intValue();
        }

        return number;
    }

}
