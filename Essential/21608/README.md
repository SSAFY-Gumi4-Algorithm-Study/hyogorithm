## 문제 요약

- `n x n` 크기의 교실에 n^2명의 학생 자리를 배정하기
- 자리 배정 규칙
    1. 비어있는 칸 중에서 좋아하는 학생이 인접한 칸에 가장 많은 칸으로 자리를 정한다.
    2. 1을 만족하는 칸이 여러 개이면, 인접한 칸 중에서 비어있는 칸이 가장 많은 칸으로 자리를 정한다.
    3. 2를 만족하는 칸도 여러 개인 경우에는 행의 번호가 가장 작은 칸으로, 그러한 칸도 여러 개이면 열의 번호가 가장 작은 칸으로 자리를 정한다.
- 자리 배정 후 학생 만족도의 총 합 구하기
    - 만족도는 그 학생과 인접한 칸에 앉은 좋아하는 학생의 수에 따라 정해진다.
    
    | 좋아하는 학생 수 | 만족도 점수 |
    | --- | --- |
    | 0명 | 0점 |
    | 1명 | 1점 |
    | 2명 | 10점 |
    | 3명 | 100점 |
    | 4명 | 1000점 |

## 문제 풀이

### `assignSeat`

```java
static void assignSeat() {
    for (int i = 0; i < n * n; i++) {
        int student = order[i];
        Point seat = findBestSeat(student);
        classroom[seat.x][seat.y] = student;
    }
}
```

- 모든 학생을 순서대로 자리에 배치하는 함수
- `findBestSeat` 함수로 최적의 자리를 찾아서 `classroom`에 배정한다

### `findBestSeat`

- 각 학생에 대해 최적의 자리를 찾는 함수

```java
PriorityQueue<Point> pq = new PriorityQueue<>(
        (a, b) -> {
            if (a.like != b.like) return b.like - a.like;
            if (a.empty != b.empty) return b.empty - a.empty;
            if (a.x != b.x) return a.x - b.x;
            return a.y - b.y;
        }
);
```

- `PriorityQueue`를 이용해 규칙에 맞는 최적의 자리를 선택한다
    - 좋아하는 학생 수 → 빈 자리 수 → 행 → 열 순

### `calculate`

- 만족도를 계산하는 함수
- 각 학생의 상하좌우 4칸을 확인하여 좋아하는 학생 수를 센 후, 만족도를 구한다
