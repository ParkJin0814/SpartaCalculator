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
                result = a / b;
                break;
            case '*':
                result = a * b;
                break;
            default:
                throw new IllegalArgumentException();
        }

        return result;
    }

    public void removeFirstResult(){
        results.removeFirst();
    }

}
