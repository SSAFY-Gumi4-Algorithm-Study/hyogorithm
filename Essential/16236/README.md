## 문제 요약
- n x n 공간에 1 ~ 6 크기의 물고기와 처음 크기가 2인 아기상어가 있다
- 상어는 자기 크기 이하 칸으로만 이동할 수 있고, 자기보다 작은 물고기만 먹을 수 있다
- 먹을 물고기가 여러 마리면
    1. 가장 가까운 물고기,
    2. 거리가 같다면 가장 위
    3. 가장 왼쪽 순으로 고른다.
- 물고기를 현재 크기만큼 먹으면 상어 크기가 +1 된다
- 상어가 물고기를 먹으러 이동한 칸 수의 합 구하기

## 문제 풀이 - PQ 이용
1. 현재 상어 위치에서 `find()` 실행해서 우선순위를 만족하는 물고기를 찾는다
    - find의 반환값이 null이면 더이상 먹을 수 있는 물고기가 없으므로 루프를 종료
2. 상태를 갱신한다
    ```
    time += p.dist;
    eat++;
    grid[p.x][p.y] = 0;
    sx = p.x; 
    sy = p.y;
    ```
    - 그 물고기까지 이동한 거리를 time에 더한다 (1칸 = 1초)
    - 현재 크기에서 먹은 물고기 수 증가
    - 먹은 칸을 빈칸으로 바꾼다
    - 상어의 현재 위치 갱신
3. 현재 상어의 크기만큼 먹었으면 상어 크기 증가
    ```
    if (eat == shark) {
      shark++;
      eat = 0;
    }
    ```

### find() 함수 
- dist -> x -> y 순으로 정렬하는 pq
    ```
    PriorityQueue<Point> pq = new PriorityQueue<>(
        (a, b) -> {
          if (a.dist != b.dist) return a.dist - b.dist;
          if (a.x != b.x)     return a.x - b.x;
          return a.y - b.y;
        }
    );
    ```
- `grid[c.x][c.y] > 0 && grid[c.x][c.y] < size` 이면 가장 우선순위를 만족하는 물고기이므로 반환한다
- 다음 좌표를 구하고, 이동 가능한 좌표를 pq에 추가한다
    ```
    for (int d = 0; d < 4; d++) {
      int nx = c.x + dx[d], ny = c.y + dy[d];
      if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
      if (v[nx][ny]) continue;
      if (grid[nx][ny] <= size) {
        v[nx][ny] = true;
        pq.offer(new Point(nx, ny, c.dist + 1));
      }
    }
    ```
