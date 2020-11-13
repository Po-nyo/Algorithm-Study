<H1>문자분류 문제</H1>
<H2>풀이</H2>

문자를 입력받고 Convert메소드에서 Pattern.matches("[a-zA-Z]","")를 이용하여 한글과 영문을 순서대로 재배치 한뒤<br><br>
Count메소드에서 다시한번 Pattern.matches("[a-zA-Z]","")메소드를 이용하여 영문자의 갯수를 세고 <br><br>
전체 길이에서 빼면 한글의 갯수도 알 수 있습니다.
