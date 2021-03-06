algorithm-study
===

# 시간 복잡도

알고리즘에서 시간 복잡도는 주어진 문제를 해결하기 위한 연산 횟수를 말한다.  
일반적으로 수행 시간은 1억 번의 연산을 1초의 시간으로 간주하여 예측한다.

시간 복잡도의 유형은 3가지가 있다.

- 빅-오메가(`Ω(n)`): 최선일 때 (best case)의 연산 횟수를 나타낸 표기법
- 빅-세타(`Θ(n)`): 보통일 때 (average case)의 연산 횟수를 나타낸 표기법
- 빅-오(`O(n)`): 최악일 때(worst case)의 연산 횟수를 나타낸 표기법

코딩 테스트에서는 빅-오 표기법을 기준으로 수행 시간을 계산하는 것이 좋다.

'대충 얼마정도 걸릴거야' 보단 '이 시간은 절대 넘지 않을거야' 가 신뢰도가 더 높기 때문이다.