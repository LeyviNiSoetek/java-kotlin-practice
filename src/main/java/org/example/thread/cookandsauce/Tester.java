package org.example.thread.cookandsauce;

public class Tester {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Cooking for dish #1 ..");
        Thread.sleep(5000);
        System.out.println(".. finished #1.");

        System.out.println("Cooking for dish #2 ..");
        Thread.sleep(2000);
        // found the lack of soy sauce
        Thread ming = new SauceChef();
        Thread ming2 = new Thread(() -> {});
        ming.setName("our sauce chef's personal working space");
        ming.start();
        System.out.println("Instructed our sauce chef for lacking sauce. Finishing other steps ..");
        Thread.sleep(3000);
        System.out.println(".. finished others but soy sauce.");

        System.out.println("Cooking for dish #3 ..");
        Thread.sleep(5000);
        System.out.println(".. finished #3.");

        ming.join();
        System.out.println("Finished #2 with sauce chef's amazing work.");

        System.out.println("All done.  All thanks to our sauce chef B-)");
    }
}
