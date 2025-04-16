package calculator.lv3;

public enum OperatorType{
    addition("+"){
        @Override
        public Number apply(Number a, Number b) {
            if(a instanceof Double){
                return a.doubleValue() + b.doubleValue();
            } else if (a instanceof Float) {
                return a.floatValue() + b.floatValue();
            } else if (a instanceof Long){
                return a.longValue() + b.longValue();
            } else if (a instanceof Integer){
                return a.intValue() + b.intValue();
            }
            return a.intValue() + b.intValue();
        }
    }
    ,
    subtract ("-"){
        @Override
        public Number apply(Number a, Number b) {
            if(a instanceof Double){
                return a.doubleValue() - b.doubleValue();
            } else if (a instanceof Float) {
                return a.floatValue() - b.floatValue();
            } else if (a instanceof Long){
                return a.longValue() - b.longValue();
            } else if (a instanceof Integer){
                return a.intValue() - b.intValue();
            }
            return a.intValue() - b.intValue();
        }
    },
    multiplication("*"){
        @Override
        public Number apply(Number a, Number b) {
            if(a instanceof Double){
                return a.doubleValue() * b.doubleValue();
            } else if (a instanceof Float) {
                return a.floatValue() * b.floatValue();
            } else if (a instanceof Long){
                return a.longValue() * b.longValue();
            } else if (a instanceof Integer){
                return a.intValue() * b.intValue();
            }
            return a.intValue() * b.intValue();
        }
    },
    divide("/"){
        @Override
        public Number apply(Number a, Number b) {
            if(b.doubleValue() == 0){
                System.out.println("나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다.");
                return 0;
            } else {
                if(a instanceof Double){
                    return a.doubleValue() / b.doubleValue();
                } else if (a instanceof Float) {
                    return a.floatValue() / b.floatValue();
                } else if (a instanceof Long){
                    return a.longValue() / b.longValue();
                } else if (a instanceof Integer){
                    return a.intValue() / b.intValue();
                }
                return a.intValue() / b.intValue();
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
