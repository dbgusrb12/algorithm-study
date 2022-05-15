String, StringBuffer, StringBuilder 차이
===

문자열을 다루는 대표적인 클래스로 `String`, `StringBuffer`, `StringBuilder` 가 있다.

3가지 클래스들의 대표적인 차이점은 `String` 은 불변(immutable) 속성을 가지고,  
`StringBuffer`, `StringBuilder` 는 가변(mutable) 속성을 가진다는 것이다.

```java
String str = "hello"; // String str = new String("hello");
str = str + " hyungyu";
```
이 코드를 봤을 때 `str` 변수에 hyungyu 문자열을 붙인거로 보이지만,  
사실은 hello 문자열이 저장된 메모리 영역은 그대로 있고,  
문자열을 더한 hello hyungyu 라는 문자열이 담긴 새로운 메모리를 가리키게 변경되고,  
hello 문자열이 저장된 메모리 영역은 garbage 로 남아있다가 GC 에 의해 삭제가 되는 식으로 진행된다.

`String` 클래스는 불변하기 때문에 문자열을 수정하면 새로운 `String` 클래스의 인스턴스가 만들어지는 것이다.

위와 같이 `String` 클래스는 불변 속성이기 때문에 변하지 않는 문자열을 담아두고 사용하는 부분에서는 좋은 성능을 기대 할 수 있지만,  
문자열의 추가, 수정, 삭제가 빈번하게 발생한다면 힙 메모리(`Heap`)에 많은 임시 가비지(Garbage)가 생성되어  
힙 메모리 부족으로 어플리케이션 성능에 치명적인 영향을 끼치게 된다.

이런 상황을 해결하기 위해 Java 는 `StringBuffer`, `StringBuilder` 클래스를 도입했다.

# `StringBuffer`, `StringBuilder`

`StringBuffer`, `StringBuilder` 클래스는 `String` 클래스와는 다르게 가변적이여서,  
같은 객체 안에서 문자열을 변경 할 수 있다.

하지만 둘 다 버퍼의 크기를 초기에 설정해 주어야 하고, 그렇기 때문에 `String` 객체보다 생성 속도가 느리다.

## `StringBuffer` VS `StringBuilder`

이 두 클래스의 차이는 동기화의 유무이다.

`StringBuffer` 클래스는 동기화 키워드를 지원하여 멀티쓰레드 환경에서 안전(`thread-safe`)하다는 장점이 있다.  

이에 반해 `StringBuilder` 클래스는 동기화 키워드를 지원하지 않아 멀티쓰레드 환경에서는 적합하지 않지만,  
그렇기 때문에 단일 쓰레드 환경에서는 `StringBuffer` 클래스보다 성능이 뛰어나다.

# 사용 시기

- `String` : 문자열 연산이 적은 경우
- `StringBuffer` : 문자열 연산이 많고, 멀티 쓰레드 환경일 경우
- `StringBuilder` : 문자열 연산이 많고, 단일 쓰레드 환경이거나, 동기화를 고려하지 않아도 될 경우

> 웹문서
> - [[Java] String, StringBuffer, StringBuilder 차이 및 장단점](https://ifuwanna.tistory.com/221)