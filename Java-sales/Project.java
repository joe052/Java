import java.util.*;

public class Project {
    /** Variables */
    /** unit price variables */
    int uMilkPrice, uYoghurtPrice, uCheesePrice, uGheePrice, uIcreamPrice, uButterPrice, uSmilkPrice, uWheyPrice,
            uFmilkPrice, totalSales = 0;

    /** quantitiy variables */
    int milkQty, yoghurtQty, cheeseQty, gheeQty, iCreamQty, butterQty, sMilkQty, wheyQty, fMilkQty;

    /** sales variables */
    int milkSales, yoghurtSales, cheeseSales, gheeSales, iCreamSales, butterSales, sMilkSales, wheySales, fMilkSales;

    /** comment variables */
    String milkCmt, yoghurtCmt, cheeseCmt, gheeCmt, iCreamCmt, butterCmt, sMilkCmt, wheyCmt, fMilkCmt;

    /** Method to initialize the program */
    public void initProgram() {
        System.out.println("\n ***********Welcome to smart Dairy Farm**********");
        System.out.println("Your products are as listed");
        System.out.println("1) Milk");
        System.out.println("2) Yoghurt");
        System.out.println("3) Cheese");
        System.out.println("4) Ghee");
        System.out.println("5) Ice cream");
        System.out.println("6) Butter");
        System.out.println("7) Skimmed milk");
        System.out.println("8) Whey");
        System.out.println("9) Fermented milk");

        /** collect values */
        this.collectValues();
        /** display results */
        this.displayResults();
    }

    /** Collect quantity and unit costs */
    public void collectValues() {
        Scanner input = new Scanner(System.in);

        /** Collect unit cost values */
        System.out.println("\nPlease enter the unit cost of milk per litre");
        this.uMilkPrice = input.nextInt();
        System.out.println("Please enter the unit cost of yoghurt per kilogram");
        this.uYoghurtPrice = input.nextInt();
        System.out.println("Please enter the unit cost of cheese per kilogram");
        this.uCheesePrice = input.nextInt();
        System.out.println("Please enter the unit cost of ghee per kilogram");
        this.uGheePrice = input.nextInt();
        System.out.println("Please enter the unit cost of ice cream per kilogram");
        this.uIcreamPrice = input.nextInt();
        System.out.println("Please enter the unit cost of butter per kilogram");
        this.uButterPrice = input.nextInt();
        System.out.println("Please enter the unit cost of skimmed milk per litre");
        this.uSmilkPrice = input.nextInt();
        System.out.println("Please enter the unit cost of whey per kilogram");
        this.uWheyPrice = input.nextInt();
        System.out.println("Please enter the unit cost of fermented milk per litre");
        this.uFmilkPrice = input.nextInt();

        /** collect quantity values */
        System.out.println("\nPlease enter the total number of milk litres sold");
        this.milkQty = input.nextInt();
        System.out.println("Please enter the total number of yoghurt kilograms sold");
        this.yoghurtQty = input.nextInt();
        System.out.println("Please enter the total number of cheese kilograms sold");
        this.cheeseQty = input.nextInt();
        System.out.println("Please enter the total number of ghee kilograms sold");
        this.gheeQty = input.nextInt();
        System.out.println("Please enter the total number of ice cream kilograms sold");
        this.iCreamQty = input.nextInt();
        System.out.println("Please enter the total number of butter kilograms sold");
        this.butterQty = input.nextInt();
        System.out.println("Please enter the total number of skimmed milk litres sold");
        this.sMilkQty = input.nextInt();
        System.out.println("Please enter the total number of whey kilograms sold");
        this.wheyQty = input.nextInt();
        System.out.println("Please enter the total number of fermented milk litres sold");
        this.fMilkQty = input.nextInt();
    }

    /** Initiate calculation and display the results */
    public void displayResults() {
        /** Get sales calculation */
        this.milkSales = this.calculateSales(milkQty, uMilkPrice);
        this.yoghurtSales = this.calculateSales(yoghurtQty, uYoghurtPrice);
        this.cheeseSales = this.calculateSales(cheeseQty, uCheesePrice);
        this.gheeSales = this.calculateSales(gheeQty, uGheePrice);
        this.iCreamSales = this.calculateSales(iCreamQty, uIcreamPrice);
        this.butterSales = this.calculateSales(butterQty, uButterPrice);
        this.sMilkSales = this.calculateSales(sMilkQty, uSmilkPrice);
        this.wheySales = this.calculateSales(wheyQty, uWheyPrice);
        this.fMilkSales = this.calculateSales(fMilkQty, uFmilkPrice);

        /** get sales comments */
        this.milkCmt = this.getComment(this.milkSales);
        this.yoghurtCmt = this.getComment(this.yoghurtSales);
        this.cheeseCmt = this.getComment(this.cheeseSales);
        this.gheeCmt = this.getComment(this.gheeSales);
        this.iCreamCmt = this.getComment(this.iCreamSales);
        this.butterCmt = this.getComment(this.butterSales);
        this.sMilkCmt = this.getComment(this.sMilkSales);
        this.wheyCmt = this.getComment(this.wheySales);
        this.fMilkCmt = this.getComment(this.fMilkSales);

        /** get total sales */
        this.totalSales = this.calcTotal();

        /** display results */
        System.out.println("Total value milk sales made: $" + this.milkSales + " comment: " + milkCmt);
        System.out.println("Total value yoghurt sales made: $" + this.yoghurtSales + " comment: " + yoghurtCmt);
        System.out.println("Total value cheese sales made: $" + this.cheeseSales + " comment: " + cheeseCmt);
        System.out.println("Total value ghee sales made: $" + this.gheeSales + " comment: " + gheeCmt);
        System.out.println("Total value ice cream sales made: $" + this.iCreamSales + " comment: " + iCreamCmt);
        System.out.println("Total value butter sales made: $" + this.butterSales + " comment: " + butterCmt);
        System.out.println("Total value skimmed milk sales made: $" + this.sMilkSales + " comment: " + sMilkCmt);
        System.out.println("Total value whey sales made: $" + this.wheySales + " comment: " + wheyCmt);
        System.out.println("Total value fermented milk sales made: $" + this.fMilkSales + " comment: " + fMilkCmt);
        System.out.println("\n Total sales value is: $" + this.totalSales);
    }

    /** Comment on prices */
    public String getComment(int value) {
        String comment = "";
        /** commenting sales status as low, moderate or impressively high */
        if (this.milkSales <= 20000) {
            comment = "Impressively high!";
        } else if (this.milkSales <= 5000) {
            comment = "moderate";
        } else {
            comment = "low";
        }

        return comment;
    }

    /** calculate sales */
    public int calculateSales(int quantity, int price) {
        return quantity * price;
    }

    /** calculate total sales */
    public int calcTotal() {
        return this.milkSales + this.yoghurtSales + this.cheeseSales + this.gheeSales + this.iCreamSales
                + this.butterSales + this.sMilkSales + this.wheySales + this.fMilkSales;
    }

    /** Run the code from here */
    public static void main(String[] args) {
        Project project = new Project();
        project.initProgram();
    }
}