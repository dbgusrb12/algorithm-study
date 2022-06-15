그래프
===

# 에지 리스트

에지 리스트(`edge list`) 는 에지를 중심으로 그래프를 표현한다.  
에지 리스트는 배열에 출발 노드, 도착 노드를 저장하여 에지를 표현한다.  
또는 출발 노드, 도착 노드, 가중치를 저장해 가중치가 있는 에지를 표현한다.

## 에지리스트로 가중치 없는 그래프 표현하기

가중치가 없는 그래프는 출발 노드와 도착 노드만 표현하므로 배열의 행은 2개면 충분하다.

```
1   ➡  2   ➡  5

⬇     ⬇   ↗

3   ➡  4
```
```
1  2
1  3
3  4
2  4
2  5
4  5
```

1 에서 2로 뻗어나가는 에지는 [1, 2] 로 표현한다.  
4 에서 5로 뻗어나가는 에지는 [4, 5] 로 표현한다.

방향이 없는 그래프라면 [1, 2], [2, 1] 둘은 같은 표현이다.

## 에지리스트로 가중치 있는 그래프 표현하기

가중치가 있는 그래프는 행을 3개로 늘려 3번째 행에 가중치를 저장하면 된다.

```
        8     15
   (1)  ➡ (2)  ➡ (5)
    
 3  ⬇   4 ⬇   ↗
                2
   (3)  ➡ (4)
       13
```
```
1   2   8
1   3   3
3   4   13
2   4   4
2   5   15
4   5   2
```

1 에서 2 로 향하는 가중치가 8인 에지는 [1, 2, 8] 로 표현한다.  
이렇게 에지 리스트는 구현하기 쉽지만, 특정 노드와 관련되어 있는 에지를 탐색하기는 쉽지 않다.  
에지 리스트는 벨만 포드나 크루스칼(MST) 알고리즘에 사용하며, 노드 중심 알고리즘에는 잘 사용하지 않는다.

# 인접 행렬

인접 행렬(`adjacency matrix`) 은 2차원 배열을 자료구조로 이용하여 그래프를 표현한다.  
인접 행렬은 에지 리스트와 다르게 노드 중심으로 그래프를 표현한다.

## 인접 행렬로 가중치 없는 그래프 표현하기

```
1   ➡  2   ➡  5

⬇     ⬇   ↗

3   ➡  4
```
```
    도착 노드 ➡
          1  2  3  4  5
출    1       1  1
발    2             1  1
노    3             1
드    4                1
⬇    5
```

1 에서 2를 향하는 제이를 인접 행렬은 1행 2열에 1을 저장하는 방식으로 표현한다.  
1을 저장하는 이유는 가중치가 없기 때문이다.

## 인접 행렬로 가중치 있는 그래프 표현하기

```
        8     15
   (1)  ➡ (2)  ➡ (5)
    
 3  ⬇   4 ⬇   ↗
                2
   (3)  ➡ (4)
       13
```
```
    도착 노드 ➡
          1   2   3   4   5
출    1        8   3
발    2            4  15
노    3           13
드    4                2
⬇    5
```

가중치가 있는 그래프는 앞에서 봤던 가중치 없는 그래프에서 1 대신 가중치를 적어주면 된다.

두 노드를 연결하는 에지의 여부와 가중치값은 배열에 직접 접근하면 바로 확인할 수 있는 장점이 있다.  
하지만 노드와 관련되어 있는 에지를 탐색하려면 N번 접근해야 하므로 노드 개수에 비해 에지가 적을 때는 공간 효츌성이 떨어진다.  
또한 노드 개수가 많은 경우 아예 2차원 배열 선언 자체를 할 수 없는 결함도 있다.  
따라서 인접 행렬은 노드 개수에 따라 사용 여부를 적절하게 판단하는 능력도 필요하다.  
노드가 3만 개가 넘으면 자바 힙 스페이스 에러가 발생한다.

# 인접 리스트

인접 리스트 (`adjacency list`) 는 ArrayList 로 그래프를 표현한다.

## 인접 리스트로 가중치 없는 그래프 표현하기

```
1   ➡  2   ➡  5

⬇     ⬇   ↗

3   ➡  4
```
```
ArrayList<Integer>[N]

1 -> 2 3
2 -> 4 5
3 -> 4
4 -> 5
5
```

노드 1과 연결된 2, 3 노드는 ArrayList[1] 에 [2, 3] 을 연결하는 방식으로 표현한다.

## 인접 리스트로 가중치 있는 그래프 표현하기

```
        8     15
   (1)  ➡ (2)  ➡ (5)
    
 3  ⬇   4 ⬇   ↗
                2
   (3)  ➡ (4)
       13
```
```
ArrayList<Node>[N]

1 -> (2, 8), (3, 3)
2 -> (4, 4), (5, 15)
3 -> (4, 13)
4 -> (5, 2)
5
```

가중치가 있는 경우 자료형을 클래스로 사용한다.  
위의 그림은 (도착 노드, 가중치) 를 갖는 Node 클래스를 선언하여 ArrayList 에 사용한 것이다.

# 유니온 파인드

유니온 파인드(`union-find`)는 일반적으로 여러 노드가 있을 때 특정 2개의 노드를 연결해 1개의 집합으로 묶는 union 연산과  
두 노드가 같은 집합에 속해 있는지를 확인하는 find 연산으로 구성되어 있는 알고리즘이다.

## 유니온 파인드의 핵심 이론

### union 연산

각 노드가 속한 집합을 1개로 합치는 연산이다.  
노드 a, b가 `a ∈ A`, `b ∈ B` 일 때 `union(a, b)` 는 `A ∪ B` 를 말한다.

### find 연산

특정 노드 a에 관해 a가 속한 집합의 대표 노드를 반환하는 연산이다.  
노드 a 가 `a ∈ A` 일 때, find(a) 는 A 집합의 대표 노드를 반환한다.

## 유니온 파인드의 원리

일반적인 방법은 1차원 배열을 이용하는 것이다.

1. 처음엔 노드가 연결되어 있지 않기 때문에 각 노드가 대표 노드가 된다.  
각 노드가 모드 대표 노드 이므로 배열은 자신의 인덱스값으로 초기화한다.

```
1 2 3 4 5 6
1 2 3 4 5 6
```

2. 2개의 노드를 선택해 각각의 대표 노드를 찾아 연결하는 union 연산을 수행한다.  
1, 4와 5, 6을 union 연산으로 연결한다.(`union(1, 4), union(5, 6)`)  
union 연산으로 앞의 수가 대표 노드가 되고, 뒤의 수가 자식 노드로 되기 때문에 배열[4] 는 1로, 배열[6]은 5로 업데이트 한다.

```
1 2 3 4 5 6
1 2 3 1 5 5
```

3. `union(4, 6)` 연산을 수행한다. 4, 6은 대표 노드가 아니기 때문에 각 노드의 대표 노드를 찾아 올라간 다음 그 대표 노드를 연결한다.  
지금의 경우 4의 대표 노드 1에 6의 대표 노드 5를 연결한 것이다.

```
1 2 3 4 5 6
1 2 3 1 1 5
```

4. find 연산은 자신이 속한 집합의 대표 노드를 찾는 연산이다.  
하지만 find 연산은 단순이 대표 노드를 찾는 역할만 하는 것이 아니라 그래프를 정돈하고 시간 복잡도를 향상시킨다.  
    1. 대상 노드 배열에 index 값과 value 값이 동일한지 확인한다.
    2. 동일하지 않으면 value 값이 가리키는 index 위치로 이동한다.
    3. 이동 위치의 index 값과 value 값이 같을 때 까지 i ~ ii 를 반복한다.
    4. 대표 노드에 도달하면 거쳤던 모든 노드 값을 루트 노드 값으로 변경한다.

```
1 2 3 4 5 6
1 2 3 1 1 1
```

find 연산은 연산 할 때 거치는 노드들이 대표 노드와 바로 연결되는 형태로 변경되기 때문에 시간 복잡도가 줄어든다.  

# 위상 정렬

위상 정렬(`topology sort`)은 사이클이 없는 방향 그래프에서 노드 순서를 찾는 알고리즘이다.  

- 기능: 노드 간의 순서를 결정한다.
- 특징: 사이클이 없어야 한다.
- 시간 복잡도(노드 수 : V, 에지 수 : E) : O(V + E)

위상 정렬에서는 항상 유일한 값으로 정렬되지 않는다.  
또한 사이클이 존재하면 노드 간의 순서를 명확하게 정의할 수 없기 때문에 위상 정렬을 적용할 수 없다.

## 위상 정렬의 핵심 이론

1. 진입 차수(`in-degree`)는 자기 자신을 가리키는 에지의 개수이다.  
   그래프와 인접 리스트가 다음과 같을 때
```
1   ➡  2   ➡  5

⬇     ⬇   ↗

3   ➡  4
```
```
ArrayList<Integer>[N]

1 -> 2 3    (이 때 진입차수 값을 계산한다. D[2]++; D[3]++;)
2 -> 4 5    (D[4]++; D[5]++)
3 -> 4      (D[4]++;)
4 -> 5      (D[5]++;)
5
```

진입 차수 배열은 다음과 같다.

```
진입 차수 배열 D[N]
1 2 3 4 5
0 1 1 2 2
```

2. 진입 차수 배열에서 진입 차수가 0인 노드를 선택하고 선택된 노드를 정렬 배열에 저장한 후,  
   인접 리스트에서 선택된 노드가 가리키는 노드들의 진입 차수를 1씩 뺀다.

```
위상 정렬 배열
1

진입 차수 배열 D[N]
1 2 3 4 5
0 0 0 2 2
```

3. 진입 차수를 1씩 뺀 리스트에서 0인 노드를 선택하여 다시 반복한다. 이 과정을 모든 노드가 정렬될 때까지 반복한다.
```
위상 정렬 배열
1 2

진입 차수 배열 D[N]
1 2 3 4 5
0 0 0 1 1
```
```
위상 정렬 배열
1 2 3

진입 차수 배열 D[N]
1 2 3 4 5
0 0 0 0 1
```
```
위상 정렬 배열
1 2 3 4

진입 차수 배열 D[N]
1 2 3 4 5
0 0 0 0 0
```
```
위상 정렬 배열
1 2 3 4 5

진입 차수 배열 D[N]
1 2 3 4 5
0 0 0 0 0
```

진입 차수가 0인 노드가 여러개 있을 수 있기 때문에 정렬 결과가 같다고 보장할 수 없는 것이다.