구간 합
===

구간 합은 합 배열을 이용하여 시간 복잡도를 더 줄이기 위해 사용하는 특수한 목적의 알고리즘

# 구간 합의 핵심 이론

구간 합 알고리즘을 활용하기 위해서는 합 배열을 구해야 한다.

배열 A가 있을 때 합 배열 S는 다음과 같이 정의한다.

```
S[i] = A[0] + A[1] + A[2] + ... + A[i - 1] + A[i]
// A[0] 부터 A[i] 까지의 합
```

```
인덱스     0   1   2   3   4   5

배열 A    15  13  10  7   3   12

합 배열 S  15  28  38  45  48  60
```

## 합 배열 S를 만드는 공식

```
S[i] = S[i - 1] + A[i]
```

## 구간 합을 구하는 공식

```
S[j] - S[i - 1]
```

## 2차원 구간 합 배열 D[X][Y]의 정의

```
D[X][Y] = 원본 배열의 (0, 0) 부터 (X, Y) 까지의 사각형 영역 안에 있는 수의 합
```

## 2차원 구간 합 배열 구하는 공식

```
D[i][j] = D[i][j - 1] + D[i - 1][j] - D[i - 1][j - 1] + A[i][j]
```

## 2차원 구간 합 구하는 방법

```
D[X2][Y2] - D[X1 - 1][Y2] - D[X2][Y1 - 1] + D[X1 - 1][Y1 - 1]
```

## 나머지 합 문제 풀이의 핵심

- 특정 구간 수들의 나머지 연산을 더해 나머지 연산을 한 값과 해당 구간 합의 나머지 연산을 한 값은 동일하다.

```
(A + B) % C = ((A % C) + (B % C)) % C
```

- 구간 합 배열을 이용한 식 `S[i] - S[j]` 는 원본 배열 `j + 1 ~ i` 까지의 구간 합 이다.

```
S[j] - S[i] = A[j + 1] + ... + A[i]
```

- 구간 합 배열의 원소를 `M`으로 나눈 나머지로 업데이트 하고 `S[i]` 와 `S[j]`가 같다면 `j + 1 ~ i` 까지의 구간 합은 `M`으로 나누어 떨어진다.

```
S[i] % M = S[j] % M
(S[i] - S[j]) % M = 0
S[i] - S[j] 는 A[j + 1] ~ A[i] 의 구간 합
A[j + 1] ~ A[i] 의 구간 합은 M 으로 나누어 떨어진다.
```

- N 개 중 2개를 뽑는 경우의 수

```
N * (N - 1) / 2
```