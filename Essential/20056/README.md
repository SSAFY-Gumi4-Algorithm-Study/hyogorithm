## 문제 요약
- N x N 크기의 격자에 파이어볼 M개가 존재한다.
- K번 아래 동작을 반복한다.
    1. 파이어볼 이동
        1. 모든 파이어볼이 자신의 방향(d)으로 s칸만큼 이동
    2. 파이어볼 분리
        1. 같은 칸에 있는 파이어볼은 하나로 합쳐진다
        2. 파이어볼은 4개로 나누어진다
            1. 질량은 `합쳐진 파이어볼의 질량 합 / 5`
            2. 속력은 `합쳐진 파이어볼의 속력 합 / 합쳐진 파이어볼의 개수`
            3. 합쳐진 파이어볼의 방향이 모두 홀수거나 모두 짝수라면 방향은 0, 2, 4, 6
            4. 그렇지 않으면 1, 3, 5, 7
            5. 질량이 0인 파이어볼은 소멸되어 없어진다.
- 남아있는 파이어볼 질량의 합을 구하기

## 문제 풀이
- 전체적인 흐름은 문제의 동작을 따라갔다.
    1. 파이어볼 정보 입력받기
    2. K번 `move()`, `divide()` 실행
    3. 남아있는 파이어볼의 질량 합 구하기

### `move()`
```java
static void move() {
    for (FireBall fb : fireBalls) {
        int row = (fb.r + dr[fb.d] * fb.s) % N;
        if (row < 0) row += N;

        int col = (fb.c + dc[fb.d] * fb.s) % N;
        if (col < 0) col += N;

        fb.r = row;
        fb.c = col;
        map[fb.r][fb.c].add(fb);
    }
}
```

- 각 파이어볼의 좌표를 계산하고, 계산한 좌표에 파이어볼을 추가한다
- 현재의 행(`fb.r`)에 파이어볼의 방향으로 s칸만큼(`dr[fb.d] * fb.s`) 이동
- 1번 행은 N번과 연결되어 있고, 1번 열은 N번 열과 연결되어 있으므로 범위를 벗어나는 경우 처리하기 위해 `% N`
- 음수인 경우 `+ N`

 

### `divide()`
```java
static void divide() {
    for (int r = 0; r < N; r++) {
        for (int c = 0; c < N; c++) {
            if (map[r][c].size() <= 1){
                map[r][c].clear();
                continue;
            }

            int sumM = 0;
            int sumS = 0;
            boolean even = map[r][c].get(0).d % 2 == 0;
            boolean odd = map[r][c].get(0).d % 2 == 1;

            for (FireBall fb : map[r][c]){
                sumS += fb.s;
                sumM += fb.m;
                even = even && fb.d % 2 == 0;
                odd = odd && fb.d % 2 == 1;
                fireBalls.remove(fb);
            }

            sumM /= 5;
            sumS /= map[r][c].size();
            map[r][c].clear();

            if (sumM == 0) continue;

            if (even || odd) {
                for (int i = 0; i < 8; i += 2) {
                    fireBalls.add(new FireBall(r, c, sumM, sumS, i));
                }
            } else {
                for (int i = 1; i < 8; i += 2) {
                    fireBalls.add(new FireBall(r, c, sumM, sumS, i));
                }
            }
        }
    }
}
```

- `map`의 각 좌표를 돌면서
    - 파이어볼이 1개 이하인 칸은 바로 초기화 후에 넘어간다
    - 파이어볼이 2개 이상인 칸은 모든 파이어볼을 합친다
        - 질량 합과 속도 합, 방향 홀짝을 확인하고 지운다
        - 조건에 따라 새로운 파이어볼 4개를 생성하고 fireBalls에 추가한다.
            - 모두 짝수(`even`)거나 모두 홀수(`odd`)인 경우 `0, 2, 4, 8`
            - 아니면 `1, 3, 5, 7`
