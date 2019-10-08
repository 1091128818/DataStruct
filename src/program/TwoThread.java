package program;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/*
*写两个线程，其中一个线程打印1-52，另一个打印A-Z，打印顺序为12A34B56C....5152Z(可能会时间久一点）
* */
public class TwoThread {
    public static void main(String[] args){
        ReentrantLock r1= new ReentrantLock();
        Condition c = r1.newCondition();
        Condition c2 =  r1.newCondition();
        new Thread(new Runnable() {
            @Override
                public void run(){
                    try {
                        r1.lock();
                        for (int i = 1; i <=52 ; i++) {
                            System.out.print(i);
                            if (i%2==0){
                                c.signalAll();
                                try {
                                    c2.await();
                                }catch (InterruptedException e){
                                    e.printStackTrace();
                                }
                            }
                        }
                    }finally {
                        r1.unlock();
                    }
                }

        }).start();

        new Thread(new Runnable() {
            @Override
                public void run(){
                    try {
                        r1.lock();
                        for (int i = 0; i <26 ; i++) {
                            System.out.print((char)('A'+i)+" ");
                                c2.signalAll();
                                try {
                                   if (i!=25){
                                       c.await();
                                }
                                }catch (InterruptedException e){
                                        e.printStackTrace();
                            }
                        }
                    }finally {
                        r1.unlock();
                    }
                }

        }).start();
    }
}
