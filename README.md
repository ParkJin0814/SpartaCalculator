
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




