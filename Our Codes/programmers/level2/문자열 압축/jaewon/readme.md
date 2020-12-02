<h1> 문자열 압축</h1>
<h2>풀이</h2>

저는 이 문제를 countLength,cutting,makeQue세가지 메소드를 만들어 풀었습니다.<br><br>

makeQue는 n개 단위로 슬라이스한 큐를 만드는 메소드이며 이것을 이용하여 <br><br>

cutting 메소드 에서는 잘라낸 큐 확인하여 count값을 증가시키거나 초기화 해가며 <br><br>

문자열에 하나씩 잘라서 붙여 넣었고 이로인해 반환 된 문자열을 countLength에서 <br><br>

길이를 계산하여 가장 적은 길이를 가진 문자의 수를 반환하도록 하였습니다. <br><br>  