public class Main {
  public static void main(String[] args) {
    final int nCounter = 5;
    String[] names = {
      "Аристотель", "Конфуций", "Платон", "Сократ", "Пифагор"
    };

    Thread[] philosophers = new Thread[nCounter];
    Round round = new Round(nCounter);
    for (int i = 0; i < nCounter; ++i) {
      philosophers[i] = new Thread(
        new Philosopher(names[i], i, nCounter, round, 1000*(1+i))
      );
    }
    for (Thread th : philosophers) {
      th.start();
    }

  }
}

class Philosopher implements Runnable {
  private final int maxPhilosofields;
  private int eatCounter;
  private final String name;
  private Round round;
  private int id;
  private int eatTime;
  
  public Philosopher(String name, int id, final int maxPhilosofields, final Round round, int eatTime) {
    this.name = name;
    this.round = round;
    this.maxPhilosofields = maxPhilosofields;
    this.id = id;
    this.eatTime = eatTime;
    eatCounter = 0;
  }

  @Override
  public void run() {
    final int variations = (int) Math.floor(maxPhilosofields / 2.0);
    while (true) {
      try {
        int nRound = round.getRound();
        for (int i = 0; i < variations; ++i) {
          int nIndex = nRound + i * 2;
          if (nIndex >= maxPhilosofields) {
            nIndex -= maxPhilosofields;
          }
          if (id == nIndex) {
            eat();
          }
        }
        round.next();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }

  private void eat() throws InterruptedException {
    this.eatCounter += 1;
    System.out.println(name + " поел " + eatCounter + " раз(а)");
    if (eatTime > 0) {
      Thread.sleep(eatTime);
    }
  }
}

class Round {
  private volatile int round;
  private volatile int counter;
  private final int maxCounter;

  public Round(int maxCounter) {
    this.round = 0;
    this.counter = 0;
    this.maxCounter = maxCounter;
  }

  public int getRound() {
    return round;
  }
  
  public synchronized void next() throws InterruptedException {
    int nNow = round;
    int valNextRound = counter;
    if (valNextRound + 1 == maxCounter) {
      if (nNow + 1 < maxCounter) {
        round = nNow + 1;
      } else {
        round = 0;
      }
      counter = 0;
      notifyAll();
    } else {
      counter = valNextRound + 1;
      wait();
    }
  }
}