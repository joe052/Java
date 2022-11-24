package task1;
public interface Eat {
    default void drink(){
        System.out.println("I drink milk");
    };
    abstract void eat();
}
