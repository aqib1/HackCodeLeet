package com.test.web3labs;

import java.util.*;

public class WordLadder {

    public static void main(String[] args) {
        WordLadder wl = new WordLadder();
        System.out.println(wl.ladderLength("hot", "dog", Arrays.asList("hot","dog","dot")));
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(endWord))
            return 0;
        if(adjacentPair(beginWord, endWord)) return 2;
        int indexOfEndWord = -1;

        Queue<Integer> startSeqIndex = new PriorityQueue<>(Comparator.reverseOrder());
        for(int x=0; x < wordList.size(); x++ ) {
          if(adjacentPair(beginWord, wordList.get(x))) {
              startSeqIndex.offer(x);
          }
          if(endWord.equals(wordList.get(x))) {
              indexOfEndWord = x;
          }
        }

        System.out.println(startSeqIndex);

        int startSeqLen = startSeqIndex.size();
        List<String> sequence = new ArrayList<>();
        String startWord = beginWord;
        loop:for(int seqIndex =0; seqIndex < startSeqLen; seqIndex++) {
            if(!startSeqIndex.isEmpty()) {
                int maxValue = startSeqIndex.poll();
                if (maxValue <= indexOfEndWord) {
                    sequence.add(startWord);
                    for (int i = maxValue; i <= indexOfEndWord; i++) {
                        if (adjacentPair(startWord, wordList.get(i))) {
                            sequence.add(wordList.get(i));
                        } else if (adjacentPair(startWord, endWord)) {
                            sequence.add(endWord);
                            break loop;
                        } else if (i == indexOfEndWord && !adjacentPair(startWord, endWord)) {
                            sequence.clear();
                            break;
                        }
                        startWord = wordList.get(i);
                    }
                }
            }
        }

        System.out.println(sequence);
        return sequence.size();
    }
    public boolean adjacentPair(String beginWord, String current) {
        int diff = 0;
        for(int x=0; x< beginWord.length(); x++) {
            if(beginWord.charAt(x) != current.charAt(x)) diff++;
        }

        return diff == 0 || diff == 1;
    }


}
