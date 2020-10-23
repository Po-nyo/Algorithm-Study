package anagram;

public class Anagram {

    public void solve(String a, String b) {
        int[] alphabet_count = new int[26];

        for(int i=0; i<a.length(); i++)
            alphabet_count[a.charAt(i) - 'a']++;

        for(int i=0; i<b.length(); i++)
            alphabet_count[b.charAt(i) - 'a']--;

        int count = 0;
        for(int i : alphabet_count)
            count += Math.abs(i);

        System.out.println(count);
    }
}
