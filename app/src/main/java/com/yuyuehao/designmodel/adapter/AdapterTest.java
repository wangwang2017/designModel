package com.yuyuehao.designmodel.adapter;

/**
 * Created by Wang
 * on 2018-09-19
 */

public class AdapterTest {

    public static void main(String[] args){
//        类适配  当希望将一个类转换成满足另一个新接口的类时，可以使用类的适配器模式，创建一个新类，继承原有的类，实现新的接口即可。
//        Targetable target = new Adapter();  // 实现Targetable
//        target.method1();
//        target.method2();

//        对象适配   新建一个类持有需要适配的对象的一个实例  同时实现Targetable
//        当希望将一个对象转换成满足另一个新接口的对象时，可以创建一个Wrapper类，持有原类的一个实例，在Wrapper类的方法中，调用实例的方法就行。
        Source source = new Source();
        Targetable target = new Wrapper(source);
        target.method1();
        target.method2();


    }
}
