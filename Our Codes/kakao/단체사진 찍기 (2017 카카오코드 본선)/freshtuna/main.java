import java.util.Stack;
import java.util.HashMap;

class Solution {
  static char[] people;
  static String[] data;
  static int n;
  static int answer;

  private void init(int n, String[] data) {
    this.people = new char[]{'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};
    this.data = data;
    this.n = n;
    this.answer = 8 * 7 * 6 * 5 * 4 * 3 * 2;
  }

  private void verify(HashMap<Character,Integer> hash) {
    for(int i = 0; i < this.data.length; ++i) {
      String _case = this.data[i];

      int difference = Math.abs(_case.charAt(0) - _case.charAt(2)); 
      char condition_operator = _case.charAt(3);
      char condition = _case.charAt(4);

      if(!verify(difference, condition_operator, condition))
        this.answer -= 1;
    }
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
    if(hash.size() == this.people.length) 
      verify(hash);
    else {
      for(int i = 0; i < this.n; ++i) {
        if(hash.get(this.people[i]) == null) {
          HashMap<Character,Integer> new_hash = (HashMap<Character,Integer>)hash.clone();
          new_hash.put(this.people[i], hash.size());
          dfs(new_hash);
        }
      }
    }
  }

  public int solution(int n, String[] data) {
    init(n, data);
    dfs(new HashMap<Character,Integer>());
    return this.answer;
  }
}
