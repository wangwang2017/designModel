package com.yuyuehao.designmodel.singleton;

/**
 * Created by Wang
 * on 2018-09-19
 */

public class Singleton {

//    /* 私有构造方法，防止被实例化 */
//    private Singleton(){}
//
//    /* 此处使用一个内部类来维护单例 */
//    private static class SingletonFactory{
//        private static Singleton instance = new Singleton();//如果在构造函数中抛出异常，实例将永远得不到创建
//    }
//
//    /* 获取实例 */
//    public static Singleton getInstance() {
//        return SingletonFactory.instance;
//    }
//
//    /* 如果该对象被用于序列化，可以保证对象在序列化前后保持一致 */
//    public Object readResolve() {
//        return getInstance();
//    }





//    //补充：采用"影子实例"的办法为单例对象的属性同步更新
//
//    private static Singleton instance = null;
//    private Vector properties = null;
//
//    public Vector getProperties() {
//        return properties;
//    }
//
//    private Singleton() {
//    }
//
//    private static synchronized void syncInit() {
//        if (instance == null) {
//            instance = new Singleton();
//        }
//    }
//
//    public static Singleton getInstance() {
//        if (instance == null) {
//            syncInit();
//        }
//        return instance;
//    }
//
//    public void updateProperties() {
//        Singleton shadow = new Singleton();
//        properties = shadow.getProperties();
//    }


    //饿汉式（静态常量）

    /**
     *  优点：这种写法比较简单，就是在类装载的时候就完成实例化。避免了线程同步问题。
     *  缺点：在类装载的时候就完成实例化，没有达到Lazy Loading的效果。如果从始至终从未使用过这个实例，则会造成内存的浪费。
     */

//    private final static Singleton INSTANCE = new Singleton();
//
//    private Singleton(){
//
//    }
//    public static Singleton getInstance(){
//     return INSTANCE;
//    }



    //饿汉式（静态代码块）

    /**
     *  优点：这种写法比较简单，就是在类装载的时候就完成实例化。避免了线程同步问题。
     *  缺点：在类装载的时候就完成实例化，没有达到Lazy Loading的效果。如果从始至终从未使用过这个实例，则会造成内存的浪费。
     */
//    private static Singleton instance;
//
//    static {
//        instance = new Singleton();
//    }
//
//    private Singleton() {}
//
//    public static Singleton getInstance() {
//        return instance;
//    }

    //3、懒汉式(线程不安全)[不可用]
    /**
     *  这种写法起到了Lazy Loading的效果，但是只能在单线程下使用。如果在多线程下，一个线程进入了if (singleton == null)判断语句块，
     *  还未来得及往下执行，另一个线程也通过了这个判断语句，这时便会产生多个实例。所以在多线程环境下不可使用这种方式。
     */
//    private static Singleton singleton;
//
//    private Singleton() {}
//
//    public static Singleton getInstance() {
//        if (singleton == null) {
//            singleton = new Singleton();
//        }
//        return singleton;
//    }

    //4、懒汉式(线程安全，同步方法)[不推荐用]
    /**
     *  解决上面第三种实现方式的线程不安全问题，做个线程同步就可以了，于是就对getInstance()方法进行了线程同步。
     *  缺点：效率太低了，每个线程在想获得类的实例时候，执行getInstance()方法都要进行同步。而其实这个方法只执行一次实例化代码就够了，
     *  后面的想获得该类实例，直接return就行了。方法进行同步效率太低要改进。
     */
//    private static Singleton singleton;
//
//    private Singleton() {}
//
//    public static synchronized Singleton getInstance() {
//        if (singleton == null) {
//            singleton = new Singleton();
//        }
//        return singleton;
//    }

    //5、懒汉式(线程安全，同步代码块)[不可用]
    /**
     * 由于第四种实现方式同步效率太低，所以摒弃同步方法，改为同步产生实例化的的代码块。但是这种同步并不能起到线程同步的作用。
     * 跟第3种实现方式遇到的情形一致，假如一个线程进入了if (singleton == null)判断语句块，还未来得及往下执行，
     * 另一个线程也通过了这个判断语句，这时便会产生多个实例。
     */
//    private static Singleton singleton;
//
//    private Singleton() {}
//
//    public static Singleton getInstance() {
//        if (singleton == null) {
//            synchronized (Singleton.class) {
//                singleton = new Singleton();
//            }
//        }
//        return singleton;
//    }


    //6、双重检查[推荐用]
    /**
     * Double-Check概念对于多线程开发者来说不会陌生，如代码中所示，我们进行了两次if (singleton == null)检查，
     * 这样就可以保证线程安全了。这样，实例化代码只用执行一次，后面再次访问时，判断if (singleton == null)，直接return实例化对象。
     *  优点：线程安全；延迟加载；效率较高。
     */
//    private static volatile Singleton singleton;
//
//    private Singleton() {}
//
//    public static Singleton getInstance() {
//        if (singleton == null) {
//            synchronized (Singleton.class) {
//                if (singleton == null) {
//                    singleton = new Singleton();
//                }
//            }
//        }
//        return singleton;
//    }

    //7、静态内部类[推荐用]

    /**
     * 这种方式跟饿汉式方式采用的机制类似，但又有不同。两者都是采用了类装载的机制来保证初始化实例时只有一个线程。
     * 不同的地方在饿汉式方式是只要Singleton类被装载就会实例化，没有Lazy-Loading的作用，
     * 而静态内部类方式在Singleton类被装载时并不会立即实例化，而是在需要实例化时，调用getInstance方法，
     * 才会装载SingletonInstance类，从而完成Singleton的实例化。
     * 类的静态属性只会在第一次加载类的时候初始化，所以在这里，JVM帮助我们保证了线程的安全性
     * 在类进行初始化时，别的线程是无法进入的。
     * 优点：避免了线程不安全，延迟加载，效率高。
     */
//    private Singleton() {}
//
//    private static class SingletonInstance {
//        private static final Singleton INSTANCE = new Singleton();
//    }
//
//    public static Singleton getInstance() {
//        return SingletonInstance.INSTANCE;
//    }

    //8、枚举[推荐用]

    /**
     * 不仅能避免多线程同步问题，而且还能防止反序列化重新创建新的对象。
     */

//    public enum Singleton {
//        INSTANCE;
//        public void whateverMethod() {
//
//    }

//----------------------二--------------------------

//    private enum EnmuSingleton{
//        Singleton;
//        private Singleton singleton;
//
//        //枚举类的构造方法在类加载是被实例化
//        private EnmuSingleton(){
//            singleton = new Singleton();
//        }
//        public Singleton getInstance(){
//            return singleton;
//        }
//    }
//    public static Singleton getInstance() {
//        return EnmuSingleton.Singleton.getInstance();
//    }

}


