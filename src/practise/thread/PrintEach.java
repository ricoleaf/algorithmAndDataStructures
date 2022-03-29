package practise.thread;


import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: wangkangnian
 * @since: v1.0.0
 */
public class PrintEach implements Runnable {
    private Lock lock;
    private Condition condition1;
    private Condition condition2;
    private String str;

    public PrintEach(Lock lock, Condition condi1, Condition condi2, String str) {
        this.lock = lock;
        this.condition1 = condi1;
        this.condition2 = condi2;
        this.str = str;
    }

    public static void main(String[] args) {
       Lock lock = new ReentrantLock();
       Condition condition1 = lock.newCondition();
        Condition condition2 = lock.newCondition();
       String str1 = "1234567890";
       String str2 =  "abcdefghjk";

       Thread t1 = new Thread(new PrintEach(lock, condition1, condition2, str1));
       Thread t2 = new Thread(new PrintEach(lock, condition1, condition2, str2));
       t1.start();
       sleep();
       t2.start();
       sleep();
    }
    public static void sleep() {
        try {
            Thread.sleep(500);
        } catch (Exception e) {
            System.out.println("error");
        }
    }

    @Override
    public void run() {

        lock.lock();
        try {

            for (int i = 0; i < str.length(); i++) {
                System.out.println(str.charAt(i));
                if (str.startsWith("qwe")) {
                    condition1.signal();
                    condition2.await();
                } else {
                    condition2.signal();
                    condition1.await();
                }
            }
        } catch (Exception e) {

        } finally {
            lock.unlock();
        }
    }
}
