

class A extends Thread{

    public void run() {
        for(int i=0;i < 10;i++){
            System.out.println("Thread A is executing");

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}

// To implement thread Runnable Interface method is better because , 
//     Through , Interface we can overcome the problem of multiple inheritance
//     Secondly , As runnable is a functional Interface so we can use Lambda expression in this method.

class B implements Runnable{

    @Override
    public void run() {
        for(int i=0;i < 10;i++){
            System.out.println("Thread B is executing");

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }   
     }
}

// Produces - Consumer Thread example
class Company{
    int n;
    boolean chance = true;
    // Chance true means producer chance and false means consumer chance 

    synchronized public void produce(int n) throws InterruptedException{
        if(!chance){
            wait();
        }
        this.n = n;
        System.out.println("Produced :"+n);
        chance = false;
        notify();
    }
    synchronized public void consume() throws InterruptedException{
        if(chance){
            wait();
        }
        System.out.println("Consumed :"+this.n);
        chance = true;
        notify();
    }
}

class Producer extends Thread{
    Company c;
    public Producer(Company c){
        this.c = c;
    }
    public void run(){
        int i = 1;
        while(true){
            try { this.c.produce(i);} catch (InterruptedException e) {e.printStackTrace(); }
            try {Thread.sleep(1000);} catch (InterruptedException e) { e.printStackTrace();}
            i++;
        }
    }
}

class Consumer extends Thread{
    Company c;
    public Consumer(Company c){
        this.c = c;
    }
    public void run(){
        while(true){
            try { this.c.consume();} catch (InterruptedException e) {e.printStackTrace(); }
            try {Thread.sleep(2000);} catch (InterruptedException e) { e.printStackTrace();}
        }
    }
}

public class MultiThreading {
    
    public static void main(String[] args) {

        // As class A extends thread class therefore we don't need start method to start execution of thread
        A obj1 = new A();
        obj1.start();
        
        // In this procedure we will require thread class object to execute the thread as Runnable interface dosen't 
        // have run start method
        B obj2 = new B();
        Thread t = new Thread(obj2);
        t.start();

        Runnable obj3 = () -> {
            for(int i=0;i < 10;i++){
                System.out.println("Thread with lambda expression");
                try {Thread.sleep(1000);} catch (InterruptedException e) { e.printStackTrace();}
            }  
        };

        t = new Thread(obj3);
        t.start();


        // Producer-Consumer Demo

        Company obj = new Company();
        Producer p = new Producer(obj);
        Consumer c = new Consumer(obj);

        p.start();
        c.start();

    }
}
