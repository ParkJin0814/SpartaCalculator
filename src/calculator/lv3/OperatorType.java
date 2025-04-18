package calculator.lv3;

public enum OperatorType{
    ADDITION("+", (a,b)-> a.doubleValue() + b.doubleValue()),
    SUBTRACT("-", (a,b) -> a.doubleValue() - b.doubleValue()),
    MULTIPLICATION("*", (a,b) -> a.doubleValue() * b.doubleValue()),
    DIVIDE("/", (a,b)->{
        if(b.doubleValue() == 0){
            System.out.println("나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다.");
            return 0;
        } else {
            return a.doubleValue() / b.doubleValue();
        }})
    ;

    final String operator;
    final Operation operation;
    OperatorType(String operator, Operation operation) {
        this.operator = operator;
        this.operation = operation;
    }

    public static OperatorType ofArithmetic(char arithmetic) {
        return null;
    }
    
    @FunctionalInterface
    interface Operation{
        Number apply(Number a, Number b);
    }
    
}
