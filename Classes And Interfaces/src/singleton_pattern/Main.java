package singleton_pattern;

import java.io.*;

public class Main {
      public static void main(String[] args) throws IOException, ClassNotFoundException {
            Singleton s1 = Singleton.getLazySingleton();
            Singleton s2 = Singleton.getLazySingleton();
            System.out.println(s1 == s2);
            Singleton s3 = Singleton.getLazySingleton();
            System.out.println(s1 == s3);
            s2 = Singleton.getLazySingleton();
            System.out.println(s2 == s1);

            System.out.println(s1.hashCode());
            System.out.println(s2.hashCode());
            System.out.println(s3.hashCode());
            System.out.println();

            Singleton s4 = Singleton.getEagerSingleton();
            Singleton s5 = Singleton.getEagerSingleton();
            Singleton s6 = Singleton.getEagerSingleton();

            System.out.println(s4.hashCode());
            System.out.println(s5.hashCode());
            System.out.println(s6.hashCode());
            System.out.println();

            final int THREAD_COUNT = 10;
            Thread[] threads = new Thread[THREAD_COUNT];

            for (int i = 0; i < THREAD_COUNT; i++) {
                  final int threadNum = i;
                  threads[i] = new Thread(() -> {
                        Singleton singleton = Singleton.getThreadSafeLazySingleton();
                        System.out.println("Thread " + threadNum + ": " + singleton.hashCode());
                  });
            }

            for (Thread t : threads) {
                  t.start();
            }

            for (Thread t : threads) {
                  try {
                        t.join();
                  } catch (InterruptedException e) {
                        e.printStackTrace();
                  }
            }
            System.out.println("All thread-safe singleton tests complete");
            System.out.println();

            /*
            Constructor<Singleton> constructor = Singleton.class.getDeclaredConstructor();
            constructor.setAccessible(true);
            Singleton s10 = constructor.newInstance();
            System.out.println(s10.hashCode());
            */

            Singleton s11 = Singleton.getThreadSafeLazySingleton();
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("singleton.ob"));
            oos.writeObject(s11);
            oos.close();
            System.out.println("Writing object to file with hashcode:: " + s11.hashCode());

            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("singleton.ob"));
            Singleton s12 = (Singleton) ois.readObject();
            ois.close();
            System.out.println("Reading object to file with hashcode:: " + s12.hashCode());
      }
}
