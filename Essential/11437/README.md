## 문제 요약
- 1번부터 n번까지 번호가 매겨진 트리
- 루트는 1번
- 두 노드의 쌍 m개가 주어졌을 때, 두 노드의 가장 가까운 공통 조상이 몇 번인지 구하기

## 풀이
### `bfs`
```
static void bfs() {
    Queue<Integer> q = new ArrayDeque<>();
    q.add(1);
    v[1] = true;
    parent[1] = 0;
    depth[1] = 0;

    while (!q.isEmpty()) {
        int c = q.poll();

        for (int nxt : adj[c]) {
            if(!v[nxt]) {
                q.add(nxt);
                v[nxt] = true;
                parent[nxt] = c;
                depth[nxt] = depth[c] + 1;
            }
        }
    }
}
```
- bfs로 부모와 깊이를 계산해서 기록한다
- 1번 노드(루트)부터 시작한다

### `lca`
```
static int lca(int a, int b) {
    if (depth[a] > depth[b]) {
        int temp = b;
        b = a;
        a = temp;
    }

    while (depth[a] != depth[b]) {
        b = parent[b];
    }

    while (a != b) {
        a = parent[a];
        b = parent[b];
    }

    return a;
}
```
- 항상 `a`의 `depth`가 더 적게 만든 다음, b를 부모로 이동시키면서 `depth`를 `a`와 같게 맞춘다
- `a`와 `b`가 같아질때까지 부모로 이동한다
- 같아지면 그 노드가 최소 공통 조상이므로 반환한다

## 성능 개선
- 처음에 `Node` 객체를 만들어서 각 노드의 부모와 깊이를 저장하는 방식으로 구현했는데, 실행 시간이 엄청 오래 걸렸다.
- 객체를 사용하는 대신 `parent[]`, `depth[]` 배열로 바꿔서 실행 시간을 약 5배 줄였다.
<img width="809" height="145" alt="스크린샷 2025-10-31 오후 6 38 22" src="https://github.com/user-attachments/assets/9f0e788b-76ab-4226-ad21-60d3dbe43bff" />
