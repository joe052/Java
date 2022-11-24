package task1;

abstract class Walk implements Speak {
    public void speak(){
        System.out.println("I can say my name now");
    }
    abstract void greet();  
}
