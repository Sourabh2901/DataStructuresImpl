/**
 * SingletonPattern -> CreationalDesign Pattern
 */

 package Design_Patterns;

public class SingletonPattern {

    private static SingletonPattern singletonObj;

    private SingletonPattern(){}

    public static SingletonPattern getSingletonObject(){
        if(singletonObj == null){
            singletonObj = new SingletonPattern();
        }
        return singletonObj;
    }

    //when multiple thread access the above method then their will be chance that those thread will create more than one object.
    // so to avoid this we need to use synchoronized keyword in above method i.e
    public static SingletonPattern getSingletonThreadObject(){
        if(singletonObj == null){
            synchronized(SingletonPattern.class){
                singletonObj = new SingletonPattern();
            }
        }
        return singletonObj;
    }


}