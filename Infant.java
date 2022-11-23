public class Infant extends Child implements Speak {
    Infant(String name) {
        super(name);        
    }
    @Override
    public void speak() {
        System.out.println("I can say bu bu bu");
    }    
}
