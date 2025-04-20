package iuh.fit.se.designs.SingletonPattern;

public class LazyInitializedSingleton {
    public static LazyInitializedSingleton instance;
    private static volatile LazyInitializedSingleton instanceDoubleLocking;
    private LazyInitializedSingleton() {

    }

    public static LazyInitializedSingleton getInstance(){
        if(instanceDoubleLocking == null){
            synchronized (LazyInitializedSingleton.class) {
                if(instanceDoubleLocking == null){
                    instanceDoubleLocking = new LazyInitializedSingleton();
                }
            }
        }
        return instanceDoubleLocking;
    }
}
