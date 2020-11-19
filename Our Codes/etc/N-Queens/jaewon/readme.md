<h1>N-Queens</h1>
<h2>solution</h2>
<em><B><u>b_tracking메소드</u></B></em> 를 재귀함수로 사용하며 내부에서 edge메소드를 통해 해당 경우의 수가 가능한지 아닌지를 판별하였고<br><br>
재귀에 의해 반복적으로 모든 경우의 수에 대하여 edge메소드의 판별을 받게 하고<br><br>
종료조건이 충족되지 않을 시 삽입과 확인을 반복문이 끝날 때 까지 edge메소드로 확인하며<br><br>
layer가 N과 같은지 확인하는 종료조건이 충족된다면 PrintTable 메소드로 태이블 형태로 출력되게 하였습니다.<br><br>
<br><br>
그리고 <em><B><u>edge메소드</u></B></em> 에서 확인하는 방법으로는 Q[layer]와 Q[i]가 일직선 상에 존재해 같거나<br><br>
Q[layer]가 Q[i]의 대각선 상에 있는 경우 인데 이 경우 대각선으로 만든 가로와 세로의 길이가 같으므로<br><br>
 절대값인 Math.abs(layer-i)== Math.abs(Q[layer]-Q[i]를 사용하여 좌측, 우측 대각선에 모두 적용 하였습니다.<br><br>                                    