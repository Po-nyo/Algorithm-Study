<h1>Automata</h1>
<h2>풀이</h2>
이 문제를 푸는데 저는 세가지의 메소드를 만들었습니다.<br><br>
우선 Binary(int length,int num)메소드는 숫자와 자릿수를 받아와 <br><br>
원하는 크기의 이진수로 만들어주는 메소드입니다.<br><br>
Convert(String num2)메소드는 String형의 이진수를 받아와 조건에 맞는 모양으로 <br><br>
바꾸어 준 뒤 이진수 형태인 String타입으로 다시 반환합니다.<br><br> 
Confirm(String num)메소드는 String형의 이진수를 받아와 Covert로 변형하여서 num과 같은<br><br>
형태가 되는 것이 몇개가 있는지 확인한 뒤 갯수에 따라 다른 값을 반환해 줍니다.<br><br>
<B>
위의 세가지 메소드를 이용하여 우선 Confirm에서 바뀐 숫자를 받아온 뒤 2의 num의 길이 제곱 만큼의 <br><br>
포문을 돌려 Binary를 이용하여 0 ~ 2에서 num제곱 만큼의 수를 자릿수가 같은 이진수로 바꾼 뒤 <br><br>
Convert를 통해 변환 시켜줍니다. 그 후 num과 비교하여 같다면 String s 에 저장하고 같은 갯수를 count하며 <br><br>
Confirm 메소드에 의해 count된 갯수에 따라 다른 값을 반환시킵니다.
   