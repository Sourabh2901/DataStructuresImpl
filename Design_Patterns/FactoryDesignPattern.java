package Design_Patterns;

// Factory Design Pattern are used when we need object of paticular class base on some specific condition

interface Greeting {
    String greet();
}

class Hindi implements Greeting{
    @Override
    public String greet() {
        return "Namaste";
    }
}

class English implements Greeting{
    @Override
    public String greet() {
        return "Hello";
    }
}


public class FactoryDesignPattern{

    public static Greeting greetObj(String language) {
        
        if(language.trim().equalsIgnoreCase("hindi")){
            return new Hindi();
        }else if(language.trim().equalsIgnoreCase("english")){
            return new English();
        }else{
            return null;
        }

    }

}
