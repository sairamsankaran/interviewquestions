package com.sankaran.sairam;

import java.util.ArrayList;
import java.util.List;

public class Trie implements  Dictionary {
    private TrieNode root;

    public Trie() {
        this.root = new TrieNode();
    }

    @Override
    public boolean addWord(String word) {
        return root.addWord(word);
    }

    @Override
    public boolean isPrefix(String prefix) {
        boolean isPrefix = false;
        TrieNode lastNode = this.root;
        for (int i = 0; i < prefix.length(); i++) {
            lastNode = lastNode.getNode(prefix.charAt(i));
            if (lastNode == null) {
                isPrefix = false;
                break;
            }
        }
        if (lastNode != null) {
            isPrefix = true;
        }
        return isPrefix;
    }

    @Override
    public boolean contains(String word) {
        return getWordsForPrefix(word).contains(word);
    }

    public List<String> getWordsForPrefix(String prefix) {
        TrieNode lastNode = this.root;
        for (int i = 0; i < prefix.length(); i++) {
            lastNode = lastNode.getNode(prefix.charAt(i));
            if (lastNode == null) {
                return new ArrayList<String>();
            }
        }
        if (lastNode != null) {
            return lastNode.getWords();
        }
        return new ArrayList<String>();
    }
}
