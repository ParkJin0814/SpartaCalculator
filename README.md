
# 🔢 사칙연산 계산기 만들기(Lv.3)
>
Enum, 제네릭, 람다 & 스트림을 이해한 계산기 만들기
* 요구사항
  * 양의 정수만 받았지만 이제부터는 실수도 받을 수 있게 수정한다.
  * 결과가 저장되어 있는 컬렉션을 조회하는 기능을 만든다. 그 때 특정 갓보다 큰 결과 값을 출력할 수 있도록
  


## 🎗️ 플로우 차트

 <img src="https://velog.velcdn.com/images/klkl97/post/1217ef70-3325-4486-8d73-7a02eaa64be9/image.png" width="700"/>

<br>


---
## 💻 구현 내용 요약

- eunm을 이용한 사칙연산 연산자 타입에 대한 정보 관리
- 함수형 인터페이스를 이용하여 계산
- 계산클래스를 제네릭 타입으로 지정
- 저장된 연산 결과중 입력받은 값보다 높은 값 출력

<br>

---
## 📖 배운점

- 제네릭을 타입을 한정해서 받을 수 있다는걸 배웠다.
  - T 에 extends 키워드를 붙여줌으로써, T extends Number 제네릭을 Number 클래스와 그 하위 타입들만 받도록 범위제한
  * 출처 : [출처](https://inpa.tistory.com/entry/JAVA-%E2%98%95-%EC%A0%9C%EB%84%A4%EB%A6%ADGenerics-%EA%B0%9C%EB%85%90-%EB%AC%B8%EB%B2%95-%EC%A0%95%EB%B3%B5%ED%95%98%EA%B8%B0#%ED%83%80%EC%9E%85_%ED%8C%8C%EB%9D%BC%EB%AF%B8%ED%84%B0_%EC%A0%95%EC%9D%98)
- instanceof를 이용하여 실제 객체타입을 확인하는 방법
  - <code>object instanceOf type</code> object가 type이거나 type을 상속받는 클래스라면 true를 리턴  
  - 출처 : [출처](https://dev-cini.tistory.com/62)
- 인터페이스 함수를 이용하여 enum에서 람다식으로 함수 재정의를 할 수 있다.
- ArrayList를 List로 선언하는 이유(업캐스팅)
  - ArrayList는 class이고 List는 interface이다
  - List로 업캐스팅하여 선언하는 이유는 코드의 다향성을 부여하기 위해서이다 
  - 다향성이란 하나의 객체가 여러 가지 타입을 가지는 것
  - 만약 구현체를 변경해야할 상황이 온다면 ArrayList로 선언하는 경우 전부 변경해야하지만 List의 경우 구현체만 변경하면된다
  - 출처 : [출처](https://woojin.tistory.com/62)
- 박싱과 언박싱의 개념을 확인
  - 박싱   : 기본 타입의 데이터를 래퍼 클래스의 인스턴스로 변환
  - 언박싱 : 래퍼 클래스의 인스턴스에 저장된 값을 기본 타입의 데이터로 변환

<br>

---
## 🛠️ 트러블 슈팅
### 문제1. 제네릭타입의 연산
>
### 🔒문제 : 제네릭타입의 연산
- 제네릭을 숫자타입만 받겠다고 정했어도 타입이 정해져 있지 않아 연산과정에 어려움이 있었다
### 🔓해결방법  
- doubleValue()으로 더블타입으로 변경해준 뒤 연산을 진행하였다.
```
(a,b)-> a.doubleValue() + b.doubleValue()
```

### 문제2. 연산된 결과 반환
>
### 🔒문제 : 연산된 결과를 Number타입이 제네릭 타입으로 형변환이 제대로 되지않는 문제
- Number 타입으로 전달을 하여 double로 값을 바꿔 계산한 뒤 그대로 전달하였더니 Double로 타입이 지정되어
제네릭 타입으로 형변환이 진행되지 않았다.
사유 : double로 값을 계산하고 반환 과정에서 Number객체가 double로 박싱
### 🔓해결방법  
- 기존 제네릭 타입을 가진 변수를 instanceof를 통하여 조건검사를 통해 어떤 타입인지 확인 후 언박싱을 진행후 다시 오토박싱진행.
```
if(t instanceof Double){
            number = number.doubleValue();
        } else if (t instanceof Float){
            number = number.floatValue();
        } else if (t instanceof Long){
            number = number.longValue();
        } else if (t instanceof Integer){
            number = number.intValue();
        }
```


---

## 📝 나의 코드
App
```
package calculator.lv3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        // 1. 현재 사칙연산 계산기는 (➕,➖,✖️,➗) 이렇게 총 4가지 연산 타입으로 구성되어 있습니다.
        // Enum 타입을 활용하여 연산자 타입에 대한 정보를 관리하고 이를 사칙연산 계산기 ArithmeticCalculator 클래스에 활용 해봅니다.

        // 2. 실수, 즉 double 타입의 값을 전달 받아도 연산이 수행하도록 만들기
        // 단순히, 기존의 Int 타입을 double 타입으로 바꾸는 게 아닌 점에 주의하세요!
        // 지금까지는 ArithmeticCalculator, 즉 사칙연산 계산기는 양의 정수(0 포함)를 매개변수로 전달받아 연산을 수행
        // 피연산자를 여러 타입으로 받을 수 있도록 기능을 확장
        //ArithmeticCalculator 클래스의 연산 메서드(calculate)
        // 위 요구사항을 만족할 수 있도록 ArithmeticCalculator 클래스를 수정합니다. (제네릭)
        //추가적으로 수정이 필요한 다른 클래스나 메서드가 있다면 같이 수정 해주세요.

        // 3. 저장된 연산 결과들 중 Scanner로 입력받은 값보다 큰 결과값 들을 출력
        // ArithmeticCalculator 클래스에 위 요구사항을 만족하는 조회 메서드를 구현합니다.
        // 단, 해당 메서드를 구현할 때 Lambda & Stream을 활용하여 구현합니다
        // Java 강의에서 람다 & 스트림을 학습 및 복습 하시고 적용 해보세요!
        // 추가) 람다 & 스트림 학습을 위해 여러 가지 조회 조건들을 추가하여 구현 해보시면 학습에 많은 도움이 되실 수 있습니다.
        Scanner sc = new Scanner(System.in);
        ArithmeticCalculator<Integer> intCalculator = new ArithmeticCalculator<>();

        while (true) {
            int num1 = -1;
            int num2 = -1;

            num1 = inputNumber(sc);
            num2 = inputNumber(sc);

            System.out.print("사칙연산 기호(➕,➖,✖\uFE0F,➗)를 입력해주세요 : ");
            char arithmetic = sc.nextLine().charAt(0);

            int result = intCalculator.calculate(num1, num2, arithmetic);
            List<Integer> tempArray = intCalculator.getResults();
            tempArray.add(result);
            intCalculator.setResults(tempArray);

            System.out.println("결과  : " + tempArray);
            System.out.print("remove 입력 시 결과의 첫 번째 요소를 제거  : ");
            String remove = sc.nextLine();
            if (remove.equals("remove")) {
                intCalculator.removeFirstResult();
                System.out.println("결과 : " + tempArray);
            }

            int soutArray = -1;
            while (true) {
                try {
                    System.out.print("입력받은 값보다 큰 결과값 들을 출력 : ");
                    soutArray = Integer.parseInt(sc.nextLine());
                    break;
                } catch (Exception e) {
                    System.out.println("숫자를 입력해 주세요");
                }
            }
            intCalculator.printGreaterNumber(soutArray);

            System.out.print("더 계산하시겠습니까? (exit 입력 시 종료) : ");
            String exit = sc.nextLine();
            if (exit.equals("exit")) {
                System.out.println("프로그램 종료");
                return;
            }
        }
    }

    public static int inputNumber(Scanner sc) {
        int num = -1 ;
        while (num < 0) {
            System.out.print("양의 정수를 입력해주세요 : ");
            String text = sc.nextLine();
            if(text.chars().allMatch(Character::isDigit)){
                num = Integer.parseInt(text);
            }
        }
        return num;
    }
}

```
ArithmeticCalculator
```
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
        /*results.stream()
            .filter((num)-> num.doubleValue() > number.doubleValue())
            .forEach((T num) -> {
                System.out.print(num);
            });*/
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

```
OperatorType
```
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

```

