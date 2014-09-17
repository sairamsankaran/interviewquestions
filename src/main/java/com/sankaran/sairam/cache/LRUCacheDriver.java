package com.sankaran.sairam.cache;

/**
 * Created by sairamsankaran on 9/16/14.
 */
public class LRUCacheDriver {
    public static void main(String[] args){
        LRUCache cache = new LRUCache(2);
        //[set(2,1),set(3,2),get(3),get(2),set(4,3),get(2),get(3),get(4)]
        cache.set(2,1);
        System.out.println(cache.get(2));
        cache.set(3, 2);
        System.out.println(cache.get(3));
        System.out.println(cache.get(2));
        cache.set(4, 3);
        System.out.println(cache.get(2));
        System.out.println(cache.get(3));
        System.out.println(cache.get(4));
        System.out.println(cache.get(2));
        System.out.println(cache.get(3));
    }
}
