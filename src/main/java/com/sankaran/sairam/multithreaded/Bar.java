package com.sankaran.sairam.multithreaded;

public class Bar implements Runnable {

    private Resource resource1;
    private Resource resource2;

    Bar(Resource resource1, Resource resource2) {
        this.resource1 = resource1;
        this.resource2 = resource2;
    }

    @Override
    public void run() {
        synchronized (resource2) {
            System.out.println("Got lock for Id: " + resource2.getId() + " from Bar");

            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {

            }

            synchronized (resource1) {
                System.out.println("Got lock for Id: " + resource1.getId() + " from Bar");
            }
        }
    }
}