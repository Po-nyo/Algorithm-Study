import java.util.Stack;
import java.util.HashMap;

public class Solution {
  static char[] people;
  static String[] data;
  static int n;
  static int answer;

  private static void init(int n, String[] data) {
    people = new char[]{'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};
    Solution.data = data;
    Solution.n = n;
    answer = 0;
  }

  private static boolean verify(HashMap<Character,Integer> hash) {
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

  private static boolean verify(int difference, char operator, int condition) {
    if(operator == '>' && difference > condition)
      return true;
    else if(operator == '<' && difference < condition)
      return true;
    else if(operator == '=' && difference == condition)
      return true;
    else
      return false;
  }

  private static void dfs(HashMap<Character,Integer> hash) {
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

  public static int solution(int n, String[] data) {
    init(n, data);
    dfs(new HashMap<Character,Integer>());
    return answer;
  }

  // main method
  // public static void main(String[] args) {
  //   System.out.println(solution(2, new String[]{"N~F=0", "R~T>2"}));
  // }
}
