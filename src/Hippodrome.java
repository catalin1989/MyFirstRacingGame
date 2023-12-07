import java.util.ArrayList;
import java.util.List;

public class Hippodrome{
    private List<Horse> horses;
    public static Hippodrome game;
    public Hippodrome(List<Horse> horses ){
        this.horses=horses;
    }

    public List<Horse> getHorses(){
        return horses;
    }
    public static void main(String[] args) {
        List<Horse> horses=new ArrayList<>();
        Hippodrome hippodrome= new Hippodrome(horses);
        Hippodrome.game=hippodrome;

        Horse horse=new Horse("Fluffy",3,0);
        Horse horse1=new Horse("Archibald",3,0);
        Horse horse2=new Horse("Bucifal",3,0);

        horses.add(horse);
        horses.add(horse1);
        horses.add(horse2);

        game.run();
        game.printWinner();

    }

    public void run() {
        for(int i=1;i<=100;i++){
            move();
            print();
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void move(){
        for(Horse horse:horses){
            horse.move();
        }
    }
    public void print(){
        for(Horse horse:horses){
            horse.print();
        }
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
    }
    public Horse getWinner(){
        double maxDistance=0.0d;
        String winnerName="";
        Horse winner=null;
        for(Horse horse:horses){
            if(horse.getDistance()>maxDistance){
                maxDistance=horse.getDistance();
                winnerName=horse.getName();
            }

        }
        for(Horse horse:horses){
            if (horse.getName().equals(winnerName)){
                winner= horse;
            }
        }
        return winner;
    }
    public void printWinner(){
        String answer=String.format("The winner is %s!",getWinner().getName());
        System.out.println(answer);
    }
}
