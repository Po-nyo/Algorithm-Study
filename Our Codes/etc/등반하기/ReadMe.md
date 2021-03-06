# 등반하기

시장에 버섯을 팔아 돈을 버는 Teemo는 오늘도 버섯을 채집하기 위해 산에 오른다.

하지만 무서운 늑대가 산에 존재하기 때문에 날이 저물기 전에 산에서 내려오려고 한다.

Teemo는 산의 지도를 보면서 자신이 가장 높이 올라 갔다가 내려올 수 있는 위치를 알아내고 싶다.

<br>

Teemo의 집은 지도의 좌상단인(0,0)에 위치해 있다.

산의 높이는 A-Z로 표현되어 있고 0-25까지의 높이를 의미한다.

Teemo는 인접한 좌표이면 상하좌우, 대각선 어디로든지 이동할 수 있다.

<br>

낮은 곳에서 높은 곳으로 이동할 때는 높이 차이의 제곱만큼의 시간이 걸리지만, 높은 곳에서 낮은 곳으로 이동할때는 1시간만 걸린다.

높이가 동일한 곳으로의 이동 시간은 0이라고 가정한다.

예를 들어, A에서 C로 이동하려면 4시간(A->C는 2만큼 차이가 나고 2를 제곱하면 4가 됨),

C에서 A로 이동할 때는 1시간(C->A로 내려오는 것이므로)이 걸린다.

(단, 높이 차이가 너무 큰 곳은 올라갈 수도 내려갈 수도 없다.)

<br>

산의 크기와 지도, 날이 저물기까지 남은 시간, 넘을 수 있는 최대 높이가 주어질 때

Teemo가 다녀올 수 있는 가장 높은 곳의 높이를 출력하라. (Z가 가장 높은 곳이라면 25가 된다.)

* Teemo는 집에서 출발해서 집으로 돌아 와야 한다.
* 입력 첫 줄은 [가로 X, 세로 Y, 한 번에 오르거나 내려 올 수 있는 최대 높이 H, 날이 저물기까지 남은 시간 T]이다.
* X와 Y는 10 이하의 정수이고, H는 25 이하의 정수이며, T는 100 이하의 정수이다.
* 다음 줄 부터는 X행 Y열 크기의 지도 행렬이 주어진다.

단, 입력은 한 개 이상의 테스트케이스가 아래 예시와 같이 반복해서 나올 수 있다.

<br>

#### 입/출력 예시

##### 입력
```
6 6 6 30
ABCDED
DEFZFG
MLKJIH
NOPQRS
YXWVUT
ZAAAAA
6 6 6 31
ABCDED
DEFZFG
MLKJIH
NOPQRS
YXWVUT
ZAAAAA
```

##### 출력
```
24
25
```
