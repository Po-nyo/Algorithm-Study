import java.util.Stack;
import java.util.HashMap;

class Solution {
  char[] people;
  String[] data;
  int n;
  int answer;

  private void init(int n, String[] data) {
    people = new char[]{'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};
    this.data = data;
    this.n = n;
    answer = 0;
  }

  private boolean verify(HashMap<Character,Integer> hash) {
    for(int i = 0; i < data.length; ++i) {
      String _case = data[i];

      int difference = Math.abs(hash.get(_case.charAt(0)) - hash.get(_case.charAt(2))) - 1; 
      char condition_operator = _case.charAt(3);
      int condition = Integer.parseInt(Character.toString(_case.charAt(4)));

      if(!verify(difference, condition_operator, condition))
        return false;
    }
    return true;
  }

  private boolean verify(int difference, char operator, int condition) {
    if(operator == '>' && difference > condition)
      return true;
    else if(operator == '<' && difference < condition)
      return true;
    else if(operator == '=' && difference == condition)
      return true;
    else
      return false;
  }

  private void dfs(HashMap<Character,Integer> hash) {
    if(hash.size() == people.length) {
      if(verify(hash))
        answer += 1;
    }
    else {
      for(int i = 0; i < people.length; ++i) {
        if(hash.get(people[i]) == null) {
          hash.put(people[i], hash.size());
          dfs(hash);
          hash.remove(people[i]);
        }
      }
    }
  }

  public int solution(int n, String[] data) {
    init(n, data);
    dfs(new HashMap<Character,Integer>());
    return answer;
  }
}
