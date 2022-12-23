public class Main {
    public static void main(String[] args) {
        New_Thread new_t = new New_Thread();
        Thread t = new Thread(new_t);
        t.start();
    }
}


class New_Thread extends Thread {

    @Override
    public void run(){
        for (int i = 1; i < 101; i++) {
            System.out.println(i);
        }
    }
}