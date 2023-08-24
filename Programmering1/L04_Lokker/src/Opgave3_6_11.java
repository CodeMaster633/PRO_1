public class Opgave3_6_11 {
    public static void main(String[] args) {
        computeCommission(10);
    }
    public static void computeCommission(double salesAmount){
        int i = 1;
        int com = 0;
        int amount = 5000;
        System.out.println("Sales Amount    Commission");
        while(i<=19){
            amount = amount + 5000;
            com = com + 1000;
            System.out.println(amount + "           " + com);
            i++;
        }

}
}
