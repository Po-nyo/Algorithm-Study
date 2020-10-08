package crypt.solution;

import java.util.*;

public class Solution {

    private Map<Character, Character> mapping_code;
    private String[] original_words;
    private String[] coded_words;
    private boolean[] matched;

    public Solution() {
        this.mapping_code = new HashMap<>();
    }

    public void solve(String original, String coded) {
        this.original_words = original.split(" ");
        this.coded_words = coded.split(" ");
        this.matched = new boolean[coded_words.length];

        List<String> rests = new ArrayList<>();

        for(String origin : this.original_words)
            inIt_mapping(origin, rests);

        for(String rest : rests)
            rest_mapping(rest);

        String str = "the quick brown fox jumps over the lazy dog";
        System.out.println(encode(str));

        for(int i='a'; i<='z'; i++) {
            char alphabet = (char)i;
            System.out.println(alphabet + " " + this.mapping_code.get(alphabet));
        }
    }

    private void inIt_mapping(String original, List<String> rest) {
        Map<Character, Character> temp = new HashMap<>();
        int pattern_count = 0;
        int index = 0;

        for(int i=0; i<coded_words.length; i++) {
            String coded_word = this.coded_words[i];

            if(getPattern(original).equals(getPattern(coded_word))) {
                index = i;
                pattern_count++;

                for(int j=0; j<original.length(); j++) {
                    char char_origin = original.charAt(j);
                    char char_coded = coded_word.charAt(j);

                    temp.put(char_origin, char_coded);
                }
            }
        }

        if(pattern_count == 1) {
            merge(temp);
            this.matched[index] = true;
        }
        else
            rest.add(original);
    }

    private void rest_mapping(String rest) {
        Map<Character, Character> temp = new HashMap<>();;

        Loop:
        for(int i=0; i<coded_words.length; i++) {
            temp.clear();
            String coded_word = this.coded_words[i];

            if(!this.matched[i] && getPattern(rest).equals(getPattern(coded_word))) {
                for(int j=0; j<rest.length(); j++) {
                    char char_origin = rest.charAt(j);
                    char char_coded = coded_word.charAt(j);

                    if(this.mapping_code.containsKey(char_origin) && this.mapping_code.get(char_origin) != char_coded)
                        continue Loop;
                    temp.put(char_origin, char_coded);
                }
                merge(temp);
                this.matched[i] = true;
                return;
            }
        }
    }

    private void merge(Map<Character, Character> map) {
        for(Character key: map.keySet()) {
            if(!this.mapping_code.containsKey(key))
                this.mapping_code.put(key, map.get(key));
        }
    }

    private String encode(String str) {
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<str.length(); i++) {
            char current = str.charAt(i);
            if(current == ' ')
                sb.append(" ");
            else
                sb.append(this.mapping_code.get(str.charAt(i)));
        }

        return sb.toString();
    }

    private String getPattern(String str) {
        StringBuilder sb = new StringBuilder();
        Map<Character, Character> map = new HashMap<>();

        char c = 'a';

        for(int i=0; i<str.length(); i++) {
            char current = str.charAt(i);

            if(!map.containsKey(current))
                map.put(current, c++);

            sb.append(map.get(str.charAt(i)));
        }

        return sb.toString();
    }
}
