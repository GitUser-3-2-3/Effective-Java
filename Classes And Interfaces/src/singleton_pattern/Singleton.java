package singleton_pattern;

import java.io.Serial;
import java.io.Serializable;

public class Singleton implements Serializable {

      private static final Singleton eagerSingleton = new Singleton();

      private static volatile Singleton lazySingleton;

      private Singleton() {
            if (lazySingleton != null) {
                  throw new RuntimeException("Singleton class is already instantiated");
            }
      }

      // Lazy initialization - not thread safe
      public static Singleton getLazySingleton() {
            if (lazySingleton == null) {
                  lazySingleton = new Singleton();
            }
            return lazySingleton;
      }

      // Lazy initialization - thread safe
      public static Singleton getThreadSafeLazySingleton() {
            if (lazySingleton == null) {
                  synchronized (Singleton.class) {
                        if (lazySingleton == null) {
                              lazySingleton = new Singleton();
                        }
                  }
            }
            return lazySingleton;
      }

      // Eager initialization - objects get created at class loading.
      //                        can impact performance on huge project with multiple singletons.
      public static Singleton getEagerSingleton() {
            return eagerSingleton;
      }

      @Serial
      public Object readResolve() {
            return lazySingleton;
      }
}
