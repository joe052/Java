import java.util.*;

@FunctionalInterface
interface Utility {
    public abstract void printList(ArrayList<Player> p);
}

enum PlayerCategory {
    GOALKEEPER(0),
    MIDFIELDER(5),
    STRIKER(10),
    DEFENDER(2);

    int jerseyNumber;

    private PlayerCategory(int jerseyNumber) {
        this.jerseyNumber = jerseyNumber;
    }
}

public class Player {
    private String name;
    private PlayerCategory category;
    private int goalsScored;

    public Player(String name, PlayerCategory category, int goalsScored) {
        this.name = name;
        this.category = category;
        this.goalsScored = goalsScored;
    }

    @Override
    public String toString() {
        return name + " " + category + " " + category.jerseyNumber + " " + goalsScored;
    }

    public static void main(String[] args) {
        ArrayList<Player> players = new ArrayList<Player>();
        Scanner scan = new Scanner(System.in);

        while (true) {
            System.out.println("Enter player name: ");
            String name = scan.next();
            System.out.println("1.GOALKEEPER\n2.MIDFIELDER\n3.STRIKER\n4.DEFENDER\nChoose player position: ");
            int categoryValue = scan.nextInt();
            PlayerCategory playerCategory = null;

            for (PlayerCategory category : PlayerCategory.values()) {
                if (category.ordinal() + 1 == categoryValue) {
                    playerCategory = category;
                    break;
                }
            }
            if (playerCategory == null)
                return;
            System.out.println("Enter goals scored by " + name + ": ");
            int goalsScored = scan.nextInt();
            players.add(new Player(name, playerCategory, goalsScored));
            System.out.println("Want to add more players? Yes/No: ");
            if (scan.next() == "No"){
                break;
            }
        }

        players.sort((p1, p2) -> p1.goalsScored > p2.goalsScored ? 0 : 1);

        Utility obj = p3 -> {
            for (Player p : p3)
                System.out.println(p);
        };

        obj.printList(players);
    }
}