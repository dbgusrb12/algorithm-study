투 포인터
===

투 포인터는 2개의 포인터로 시간 복잡도를 최적화하는 알고리즘

# 투 포인터 이동 원칙

- `sum > N: sum = sum - start_index; start_index++;`
- `sum < N: end_index++; sum = sum + end_index;`
- `sum == N: end_index++; sum = sum + end_index; count++;`

start_index 를 오른쪽으로 한 칸 이동하는 것은 연속된 자연수에서 왼쪽 값을 삭제하는 것  
end_index 를 오른쪽으로 한 칸 이동하는 것은 연속된 자연수의 범위를 한 칸 더 확장하는 것  
합이 N과 같을 때 경우의 수를 1 증가시키고, end_index 를 오른쪽으로 이동시킨다.


