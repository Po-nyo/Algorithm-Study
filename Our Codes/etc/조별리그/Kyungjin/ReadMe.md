# 조별리그

## 풀이

사실 문제 해결만을 위해서라면 이렇게까지 할 필요는 없었겠지만

체계적이고 읽기 편하면서, 깔끔하고 보기좋게 코드를 작성하여 문제를 해결해보고자 객체지향적으로 풀어보았다.

<br>

먼저, 문제에서 제시한 기준대로 정렬할 수 있도록 Comparable한 객체 Team을 만들고

필드에는 팀 이름, 이긴 경기, 진 경기를 저장하도록 했다. 

이긴 경기와 진 경기는 "상대 팀의 이름"을 key로 하고, "세트 스코어 정보"를 value로 하는 Map에 저장했다.

또, 출력으로 이긴 세트와 진 세트의 수와 세트득실차를 원하고 있기 때문에

이긴 세트와 진 세트의 수를 세는 메소드를 따로 구현했다.

```java
public class Team implements Comparable<Team> {

    private String name;
    private Map<String, String> wins;
    private Map<String, String> loses;

    public Team(String name) {
        this.name = name;
        this.wins = new HashMap<>();
        this.loses = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public Map<String, String> getWins() {
        return this.wins;
    }

    public Map<String, String> getLoses() {
        return this.loses;
    }

    public int numOfWinSets() {
        int num = 0;

        for(String key : this.wins.keySet()) {
            String[] score = this.wins.get(key).split(":");
            num += Math.max(Integer.parseInt(score[0]), Integer.parseInt(score[1]));
        }

        for(String key : this.loses.keySet()) {
            String[] score = this.loses.get(key).split(":");
            num += Math.min(Integer.parseInt(score[0]), Integer.parseInt(score[1]));
        }

        return num;
    }

    public int numOfLoseSets() {
        int num = 0;

        for(String key : this.wins.keySet()) {
            String[] score = this.wins.get(key).split(":");
            num += Math.min(Integer.parseInt(score[0]), Integer.parseInt(score[1]));
        }

        for(String key : this.loses.keySet()) {
            String[] score = this.loses.get(key).split(":");
            num += Math.max(Integer.parseInt(score[0]), Integer.parseInt(score[1]));
        }

        return num;
    }

    @Override
    public int compareTo(Team other) {
        int compared = Integer.compare(this.wins.size(), other.wins.size());
        if(compared != 0)
            return -compared;
        else {
            compared = Integer.compare(this.numOfWinSets() - this.numOfLoseSets(), other.numOfWinSets() - other.numOfLoseSets());
            if(compared != 0)
                return -compared;
            else {
                if(this.wins.containsKey(other.name))
                    return -1;
                else
                    return 1;
            }
        }
    }
}
```

<br>

다음의 GroupStage 객체는 필드로 Team들의 정보와 경기 결과를 가진다.

Team들은 "Team의 이름"을 key로 하고, "Team객체"를 value로 하는 Map에 저장했다.

경기 결과는 String 형태의 List로 전달받는다.

printInfo() 메소드를 통해 문제에서 요구하는 출력을 볼 수 있으며, 

printInfo() 메소드를 호출하면 String으로 된 경기 결과를 parsing() 메소드에서 parsing하여 각 Team객체에 데이터를 입력한다.

Team객체에 데이터 입력이 완료되면 Team객체에 Comparable 인터페이스를 구현한 것을 이용하여 자바의 정렬메소드로 정렬한다.

이 때, 팀들을 Map으로 저장해두었기 때문에 Map의 Value들을 리스트로 뽑아서 정렬한다.

마지막으로 printStanding() 메소드를 통해 순위와 정보를 출력한다.

```java
public class GroupStage {
    private final Map<String, Team> teams;
    private final List<String> result;

    public GroupStage(Map<String, Team> teams, List<String> result) {
        this.teams = teams;
        this.result = result;
    }

    public void printInfo() {
        parsing();

        List<Team> teamList = new ArrayList<>(teams.values());
        Collections.sort(teamList);
        printStanding(teamList);
    }

    private void parsing() {
        for(String data : this.result) {
            String[] split = data.split(" ");

            String team1 = split[0];
            String score = split[1];
            String team2 = split[2];

            int score1 = Integer.parseInt(score.split(":")[0]);
            int score2 = Integer.parseInt(score.split(":")[1]);

            Team t1 = this.teams.get(team1);
            Team t2 = this.teams.get(team2);

            if(score1 > score2) {
                t1.getWins().put(team2, score);
                t2.getLoses().put(team1, score);
            }
            else {
                t1.getLoses().put(team2, score);
                t2.getWins().put(team1, score);
            }
        }
    }

    private void printStanding(List<Team> sorted) {
        for(int i=0; i<sorted.size(); i++) {
            Team team = sorted.get(i);
            StringBuilder sb = new StringBuilder();

            sb.append(i + 1).append(") ");
            sb.append(team.getName()).append(" ");
            sb.append(team.getWins().size()).append(" ");
            sb.append(team.getLoses().size()).append(" ");

            int winSets = team.numOfWinSets();
            int loseSets = team.numOfLoseSets();

            sb.append(winSets).append("-").append(loseSets).append(" ");
            sb.append(winSets - loseSets);

            System.out.println(sb.toString());
        }
    }
}
```
