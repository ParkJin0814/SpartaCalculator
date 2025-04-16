package calculator.lv3;

import java.security.PrivateKey;

public enum OperatorType{
    addition("+"){
        @Override
        public double apply(double a, double b) {
            return a + b;
        }
    }
    ,
    subtract ("-"){
        @Override
        public double apply(double a, double b) {
            return a-b;
        }
    },
    multiplication("*"){
        @Override
        public double apply(double a, double b) {
            return a*b;
        }
    },
    divide("/"){
        @Override
        public double apply(double a, double b) {
            if(b == 0){
                System.out.println("나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다.");
                return 0;
            } else {
                return a/b;
            }
        }
    }
    ;

    final String operator;
    OperatorType(String operator) {
        this.operator = operator;
    }

    public abstract double apply(double a, double b);
}
