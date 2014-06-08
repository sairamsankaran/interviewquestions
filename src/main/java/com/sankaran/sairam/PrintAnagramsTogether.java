package com.sankaran.sairam;

public class PrintAnagramsTogether {
    public static void print(String[] words) {
        CustomAnagramTrieNode trieNode = new CustomAnagramTrieNode();
        for (int i=0; i<words.length; i++) {
            trieNode.addWord(words[i]);
        }
    }
}

class CustomAnagramTrieNode extends TrieNode {
    private LinkedList indexList; // populated only in case of word node

    public CustomAnagramTrieNode() {
        super();
        this.indexList = null;
    }

    public CustomAnagramTrieNode(char character) {
        this();
        this.character = character;
    }
}
