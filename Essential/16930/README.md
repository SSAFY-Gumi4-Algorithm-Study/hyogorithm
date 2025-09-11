## 문제 요약
- `N × M` 크기의 `.(빈칸)`과 `#(벽)`으로 구성된 체육관
- 상하좌우 한 방향으로 최대 `k`칸 이동 가능
- 중간에 벽이 있으면 그 방향으로 더이상 이동 불가
- 주어진 시작점에서 도착점까지 이동하는 최소 시간 구하기

## 문제 풀이 - BFS
```java
for (int d = 0; d < 4; d++) {
  for (int step = 1; step <= k; step++) {
    int nx = c.x + dx[d] * step;
    int ny = c.y + dy[d] * step;
    
    if (nx < 0 || nx >= n || ny < 0 || ny >= m) break;
    if (grid[nx][ny] == '#') break;
    
    if (v[nx][ny] != -1) {
      if (v[nx][ny] < v[c.x][c.y] + 1) break;
      else continue;
    }
    
    q.offer(new Point(nx, ny));
    v[nx][ny] = v[c.x][c.y] + 1;
    
    if (nx == ex && ny == ey) {
      answer = v[nx][ny];
      return;
    }					
  }
}
```
- step = 1부터 k까지 늘려가며 한 방향으로 탐색
- 범위를 벗어나거나 벽이거나 현재보다 더 빠르게 방문했다면 break
- `v`를 `boolean[][]`이 아니라 `int[][]`을 사용해서 현재까지 걸린 이동 횟수를 기록
  - `v[x][y] == -1`: 아직 방문하지 않음
  - `v[x][y] != -1`: 이미 방문해서 최소 이동 횟수가 기록됨
