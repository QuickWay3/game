import board.Board;
import game.Game;
import player.Player;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        System.out.println("Tic Tac Toe ");

        Board b = new Board(3, '.');

        Player p1 = new Player();
        p1.setPlayerNameAndSymbol("Ram", 'X');
        p1.getPlayerNameAndSymbol();

        Player p2 = new Player();
        p2.setPlayerNameAndSymbol("Shyam", 'O');
        p2.getPlayerNameAndSymbol();

        Game game = new Game(new Player[] {p1, p2}, b); //this will print the board congif from the game class
        game.play();

        sc.close();
    }
}