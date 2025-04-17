package calculator.lv3;

public enum OperatorType{
    addition("+"){
        @Override
        public Number apply(Number a, Number b) {
            return a.doubleValue() + b.doubleValue();
        }
    }
    ,
    subtract ("-"){
        @Override
        public Number apply(Number a, Number b) {
            return a.doubleValue() - b.doubleValue();
        }
    },
    multiplication("*"){
        @Override
        public Number apply(Number a, Number b) {
            return a.doubleValue() * b.doubleValue();
        }
    },
    divide("/"){
        @Override
        public Number apply(Number a, Number b) {
            if(b.doubleValue() == 0){
                System.out.println("나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다.");
                return 0;
            } else {
                return a.doubleValue() / b.doubleValue();
            }
        }
    }
    ;

    final String operator;
    OperatorType(String operator) {
        this.operator = operator;
    }

    public abstract Number apply(Number a, Number b);
}
