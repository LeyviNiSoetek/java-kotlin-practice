package org.example.thread.cookandsauce;

/**
 * A sauce chef is who responsible for ensuring soy sauce for dishes.
 * No it's definitely not sous chef or sth.
 */
public class SauceChef extends Thread{

    @Override
    public void run() {
        // NOTE: `super.run()` here is optional since default `Thread.run` has empty body
//        super.run();

        System.out.println("Buying soy sauce..");
        try {
            /*Thread.*/sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(".. here is the sauce.");
    }

}
