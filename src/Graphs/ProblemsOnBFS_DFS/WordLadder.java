package Graphs.ProblemsOnBFS_DFS;

import java.util.*;

public class WordLadder {
    /**
     * A transformation sequence from word beginWord to word endWord using a dictionary wordList is a sequence of words
     * beginWord -> s1 -> s2 -> ... -> sk such that:
     *
     * 1. Every adjacent pair of words differs by a single letter.
     * 2. Every si for 1 <= i <= k is in wordList. Note that beginWord does not need to be in wordList.
     * 3. sk == endWord
     *
     * Given two words, beginWord and endWord, and a dictionary wordList, return the number of words in the shortest
     * transformation sequence from beginWord to endWord, or 0 if no such sequence exists.
     * */
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> words = new HashSet<>(wordList);
        int n = beginWord.length();
        int ans = func(beginWord,0,endWord,n,words);
        if(ans==1000000000) return 0;
        return ans;
    }

    // this method is wrong since maanlo ki abhi index=0 par hai and apan ne index=0 pr v daala "vater", but ye wordset
    // mai nhi hai toh for loop use aage jaane nhi dega
    // ex-: bater
    // but ho skta hai ki aage ke kuch character change krne ke baad index=0 pr v daalo toh voh wordset mai ho
    // like agar mai pehle index=1 ko change krke o kru, "boter" and then index=0 ko change kru v mai "voter" toh ab ye
    // wordset mai hai.
    // So the question is ki konsa character ko pehle change kroge kuiki aage jaake vapis purane indexes mai combinations thodi lagaoge
    public int func(String beginWord,int index,String endWord,int n,HashSet<String> words){
        if(beginWord.equals(endWord)) return 0;
        if(index==n) return (int)1e9;

        // change current character, but the question is ki change kisme karoge, we have 25 options
        char currentCharacter = beginWord.charAt(index);
        int faith2 = (int) 1e9;
        for (char c = 'a'; c <= 'z'; c++) {
            if(c==currentCharacter) continue;
            String newString = beginWord.substring(0,index)+c+beginWord.substring(index+1);
            // if this newString is in words hashset means it is a valid word, and we can form it
            // since we changed one character so add 1 to faith2
            faith2 = Math.min(faith2,func(newString,index+1,endWord,n,words)+1);
        }

        // don't change current character
        int faith1 = func(beginWord,index+1,endWord,n,words);

        return Math.min(faith2,faith1);
    }

    // I don't understand why the hell it works in bfs, but not in dfs
    public int ladderLength2(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> words = new HashSet<>(wordList);
        int n = beginWord.length();

        Queue<CellWithLevel> queue = new ArrayDeque<>();
        queue.offer(new CellWithLevel(beginWord,1));

        while (!queue.isEmpty()){
            CellWithLevel cellWithLevel = queue.poll();
            String curr = cellWithLevel.s;

            if(curr.equals(endWord)) return cellWithLevel.level;

            for (int i = 0; i < n; i++) {
                for (char c = 'a'; c <='z' ; c++) {
                    String newString = curr.substring(0,i)+c+curr.substring(i+1);
                    if(words.contains(newString)){
                        words.remove(newString);
                        queue.offer(new CellWithLevel(newString,cellWithLevel.level+1));
                    }
                }
            }
        }

        return 0;
    }
    class CellWithLevel{
        String s;
        int level;

        public CellWithLevel(String s, int level) {
            this.s = s;
            this.level = level;
        }
    }

    public static void main(String[] args) {
        WordLadder wordLadder = new WordLadder();
        List<String> list = new ArrayList<>();
        list.add("hot");
        list.add("dot");
        list.add("lot");
        list.add("dog");
        list.add("log");
        list.add("cog");
        System.out.println(wordLadder.ladderLength("hit","cog",list));
    }
}
