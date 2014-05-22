package com.sankaran.sairam;

import java.util.ArrayList;
import java.util.List;

public class TrieNode {
    private char character;
    private TrieNode[] children;
    private TrieNode parent;
    private boolean isLeaf;
    private boolean isWord;

    public TrieNode() {
        this.children = new TrieNode[26]; // 26 English consonants
        this.parent = null;
        this.isLeaf = true;
        this.isWord = false;
    }

    public TrieNode(char character) {
        this();
        this.character = character;
    }

    public boolean addWord(String word) {
        word = word.toLowerCase(); // no characters other than [a-z] accepted. characters stored as lowercase
        this.isLeaf = false;
        int charPosition = word.charAt(0) - 'a';

        if (children[charPosition] == null) {
            children[charPosition] = new TrieNode(word.charAt(0));
            children[charPosition].parent = this;
        }

        if (word.length() > 1) {
            children[charPosition].addWord(word.substring(1));
        } else {
            children[charPosition].isWord = true;
        }
        return true;
    }

    public List getWords() {
        ArrayList<String> words = new ArrayList<String>();
        if (isWord) {
            words.add(toString());
        }
        if (!isLeaf) {
            for (TrieNode child : children) {
                if (child != null) {
                    words.addAll(child.getWords());
                }
            }
        }
        return words;
    }

    public TrieNode getNode(char c) {
        int charPosition = c - 'a';
        return children[charPosition];
    }

    @Override
    public String toString() {
        if (this.parent == null) {
            return "";
        } else {
            return this.parent.toString() + Character.toString(character);
        }
    }
}
