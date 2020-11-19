<h1>Valid Plindrome</h1>
<h2>solution</h2>
우선 문자열을 확인해 영문자와 숫자만을 구분해내어 새로운 문자열을 만들고<br><br>
그 문자열을 toUpperCase로 전부 대문자로 만든 뒤 <br><br>
순회하면서 가장 앞에서 부터 글자와 가장 뒤에서 부터 글자 같은지 비교하고 <br><br>
다르다면 false를 리턴하고 반복문 종료 마지막 까지 같다면 true 리턴<br><br>