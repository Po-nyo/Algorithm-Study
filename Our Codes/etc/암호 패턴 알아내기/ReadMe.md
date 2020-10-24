# Decode Challenge

알파벳의 한 글자씩 다른 글자로 치환해서 암호를 만들었다고 하자.

입력 첫째 줄에는 암호화하지 않은 단어 n개가 있다.

둘째 줄에는 그 단어들을 암호화한 것 n개가 있는데, 순서는 섞여있다.

총 단어의 수 n은 최대 20개이고, 한 단어는 최대 10글자 이다.

이 단어들을 이용해 어떤 글자가 어떤 글자로 암호화되는지를 알아내어

"the quick brown fox jumps over the lazy dog" 을 암호화한 문장을 출력하고,

a부터 z가 어떠한 글자로 암호화 되었는지 오름차순으로 출력하라.

(단, 알파벳 소문자만 고려한다.)

<br>

#### 입/출력 예시

##### 입력 1
```
abcdefg hijk lmnop qrstuv wxyzz
kpofrz vabmteg dwhuq yjcxx lisn
```
##### 출력 1
```
flt kribn apuyh euj srwqo uztp flt dvxc mug
a v
b a
c b
d m
e t
f e
g g
h l
i i
j s
k n
l d
m w
n h
o u
p q
q k
r p
s o
t f
u r
v z
w y
x j
y c
z x
```

<br>

##### 입력 2
```
aabbccc oookewn qwetytyuip bzxcvgb hhggxxx dddfjkl mrszcvd
uuxxfff hhhseqn rqedvdvmoi ppyyttt jgbztca yzftcxy aaalwsk
```
##### 출력 2
```
due rmots yghqn lhf wmjib hceg due kpzv ahx
a p
b y
c t
d a
e e
f l
g x
h u
i o
j w
k s
l k
m j
n n
o h
p i
q r
r g
s b
t d
u m
v c
w q
x f
y v
z z
```