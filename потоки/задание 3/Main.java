public class Main {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("a");
        for (int i = 0; i < 3; i++) {
            new New_Thread(sb).start();
        }
    }
}


class New_Thread extends Thread {
    StringBuilder sb;

    public New_Thread(StringBuilder sb) {
        this.sb = sb;
    }

    @Override
    public void run() {
        synchronized (sb) {
            for (int i = 0; i < 100; i++) {
                System.out.print(i + "" + sb + "    ");
            }
            System.out.println("\n");
            sb.setCharAt(0, (char) (sb.charAt(0) + 1));
        }
    }
}