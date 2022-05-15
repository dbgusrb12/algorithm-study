슬라이딩 윈도우
===

슬라이딩 윈도우는 2개의 포인터로 범위를 지정한 다음 범위를 유지한 채로 이동하며 문제를 해결하는 알고리즘  

# 덱 (deque)

자바 1.6 부터 지원하게 된 덱(`Deque`) `Queue` 인터페이스를 확장하여 만들어 진 인터페이스이다.

덱은 양 끝에서 데이터를 삽입하거나 삭제할 수 있는 자료구조이기 때문에  
사용 방법에 따라 `Stack` 도 될 수 있고 `Queue`도 될 수 있다.


왼쪽에서는 `addFirst()`, `removeFirst()`, `getFirst()` 함수가 삽입, 삭제, 조회 역할을 하고,  
오른쪽에서는 `addLast()`, `removeLast()`, `getLast()` 함수가 삽입, 삭제, 조회 역할을 한다.

인덱스를 통해 검색, 추가, 삭제가 불가능하다.

## `Stack` VS `Deque`

Java 공식문서에는  
`보다 완전하고 일관된 LIFO 스택 작업은 Deque 인터페이스 및 해당 구현에 의해 제공됩니다.`  
라고 쓰여있다.

공식 문서에 `Stack` 보다 `Deque`를 권장하는 이유는 다음과 같다.

### `Deque` 은 인터페이스이고, `Stack` 은 Class 이다.  

자바는 다중 상속을 지원하지 않는다.  
그렇기 때문에 이미 상속받은 클래스가 있을 경우, `Stack`을 추가적으로 상속 받지 못한다.  
하지만 `Deque`은 인터페이스 이기 때문에, 이미 상속받은 클래스가 있더라도, `Deque`을 구현 할 수 있다.

### `Stack` 은 모든 작업에 Lock 이 사용된다.

`Stack` 클래스는 모든 작업에 Lock 이 사용되기 때문에,  
단일 쓰레드에서 성능이 저하 될 수 있고,  
단순한 Iterator 의 탐색 작업에서도 `get()` 메서드 실행 시 매번 Lock 이 발생하게 되므로 오버헤드가 커진다.

반면 `Deque` 인터페이스를 사용하게 되면 작업에 Lock 을 사용하지 않기 때문에 단일 스레드에서도 문제가 발생하지 않는다.  
다중 스레드 실행의 경우 문제가 될 수 있지만 ArrayDeque 에 대한 동기화 데코레이터를 구현할 수 있다.

### `Stack` 은 인덱스로 접근이 가능하다.

`Stack` 클래스는 인덱스로 접근하여 추가, 삭제, 검색이 가능하다.  
이건 LIFO 규칙을 위반하는 사항이다.

`Deque` 도 LIFO 를 위반하는 사항이 있다.  
기본적으로 `Deque`은 LIFO, FIFO 모두 지원하기 때문에 앞뒤 요소를 삽입, 삭제 할 수 있다.


> 웹문서
> - [Deque](https://docs.oracle.com/javase/8/docs/api/java/util/Deque.html)
> - [ArrayDeque](https://docs.oracle.com/javase/8/docs/api/java/util/ArrayDeque.html)
> - [[Java]Stack 대신 Deque 사용하기](https://kdhyo98.tistory.com/m/62)
> - [Java 의 Stack 대신 Deque](https://tecoble.techcourse.co.kr/post/2021-05-10-stack-vs-deque/)