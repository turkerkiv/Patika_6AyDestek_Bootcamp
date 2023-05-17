package Week2.Boxing;

public class Main {
    public static void main(String[] args) {
        Fighter turker = new Fighter("Turker" , 15 , 100, 90, 0);
        Fighter recep = new Fighter("Recep" , 10 , 95, 100, 0);
        Ring r = new Ring(turker, recep , 90 , 100);
        r.run();
    }
}