public class Toddler extends Walk {
    private String name;

    Toddler(String name){
        this.name =  name;
    }

    public String getName(){
        return this.name;
    }

    @Override
    void greet() {        
        
    }

    public void walk(){
        System.out.println("I can now walk");
    }
    
}
