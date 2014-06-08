package com.sankaran.sairam;

public interface Dictionary {
    public boolean addWord(String word);
    public boolean isPrefix(String prefix);
    public boolean contains(String word);
}
