package com.sankaran.sairam;

public interface Dictionary {
    public boolean add(String word);
    public boolean isPrefix(String prefix);
    public boolean contains(String word);
}
