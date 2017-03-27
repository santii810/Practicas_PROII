/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EjemploThow;

public class Hilos_P2_142 extends Thread {

    public void run() {

        String threadName = Thread.currentThread().getName();
        System.out.println("Hello, I’m thread number " + threadName);
        try {
            Thread.sleep(1000);//Stop the process 1 second
        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println("Bye, this was thread number " + threadName);

    }

    public static void main(String[] args) { //function main
        long totalTime;
        long initialTime;

        // Init initial time
        initialTime = System.currentTimeMillis();

        if (args.length > 1 || args.length == 0) { //comprobe that the num of args is bigger than 1
            System.out.println("Error in arguments");
        } else {
            Hilos_P2_142[] threads = new Hilos_P2_142[Integer.parseInt(args[0])];
            long[][] diagram = new long[Integer.parseInt(args[0])][2];

            for (int i = 0; i < Integer.parseInt(args[0]); i++) { //Appeal the num of args to create many threads as arguments
                Hilos_P2_142 h = new Hilos_P2_142();
                threads[i] = h;
                diagram[i][0] = System.currentTimeMillis();
                h.start(); //init thread
            }

            for (int i = 0; i < Integer.parseInt(args[0]); i++) {
                try {
                    threads[i].join();// threads must wait for their parent thread
                    diagram[i][1] = System.currentTimeMillis();
                } catch (Exception e) {
                    System.out.println(e);
                }
            }

            for (int i = 0; i < diagram.length; i++) {
                long r = diagram[i][1] / 100;
                System.out.println(diagram[i][1]);
                for (long j = 0; j < r; j++) {
                    System.out.print("--");
                }
                System.out.println(" ");
            }
        }
        System.out.println("Program of exercise 2.2 of p2 has terminated");

        totalTime = System.currentTimeMillis() - initialTime; //Calcule total time
        System.out.println("Tiempo demorado:\t" + totalTime + " milisegundos.");//print execute time(total time)
    }

}
