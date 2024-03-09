package game;

import player.Player;
import board.Board;
import java.util.Scanner;

public class Game {

    Player players[];
    Board board;
    int turn;
    int noOfMoves;
    boolean gameOver;
    String zero;
    String cross;

    public Game(Player players[], Board board)
    {
        this.players = players; //this is an array of two players
        this.board = board;
        this.turn = 0;
        this.noOfMoves = 0;
        this.gameOver = false;

        StringBuilder z = new StringBuilder();
        StringBuilder c = new StringBuilder();

        for(int i=0; i<board.size; i++)
        {
            z.append('O'); //in z data is in form of characters so we have to convert it to string
            c.append('X');
        }

        this.zero = z.toString(); //converting the concatenated character into string
        this.cross = c.toString();
    }

    public void play(){
        printBoardConfig();
        int sz = board.size;

        while(!gameOver)
        {
            noOfMoves++;
            int idx = getIndex();

            int row = idx/sz; //this puts the character at specific place
            int col = idx%sz;

            board.matrix[row][col] = players[turn].getPlayerSymbol();

            if(noOfMoves >= sz*sz)
            {
                System.out.println("Game Draw ");
                return;
            }
             
            if(noOfMoves >= 2*sz-1 && checkCombination() == true){
                gameOver = true;
                printBoardConfig();
                System.out.println("Hurrah !!! you are the  WINNER :) "+ players[turn].getPlayerName());
                return;
            } 

            turn = (turn + 1)%2;
            printBoardConfig();
        }

    }

    public void printBoardConfig()
    {
        int sz = this.board.size;
        for(int i=0; i<sz; i++)
        {
            for(int j=0; j<sz; j++)
            {
                System.out.print(board.matrix[i][j] + " ");
            }

            System.out.println();
        }
    }

    public int getIndex(){
        while(true) //this while will place the o or x at its correct position
        {
            //first player takes any positon in board
            System.out.println("Player : " + players[turn].getPlayerName() + " give one position ");
            Scanner sc = new Scanner(System.in);
            int pos = sc.nextInt() - 1;

            int sz = board.size;

            int row = pos/sz; //this both together(i.e row and col) will give the exact positon of the 0 or 1 like (x,y) = (e)
            int col = pos%sz;

            //for invalid position
            if(row < 0 || row >= sz || col < 0 || col >= sz)
            {
                System.out.println("Invalid position renter the new one");
                continue;
            }

            //for position which is already occupied
            if(board.matrix[row][col] != '.')
            {
                System.out.println("Positon already ocuupied reneter the new position ");
                continue;
            }

            return pos; 
              
        }

    }

    public boolean checkCombination()
    {
        int sz = board.size;

        //rowise
        for(int i=0; i<sz; i++)
        {
            StringBuilder sb = new StringBuilder();
            for(int j=0; j<sz; j++)
            {
                sb.append(board.matrix[i][j]);
            }

            String pattern = sb.toString();
            if(pattern.equals(zero) || pattern.equals(cross))
            {
                return true;
            }       
        }

        //columnwise
        for(int i=0; i<sz; i++)
        {
            StringBuilder sb = new StringBuilder();
            for(int j=0; j<sz; j++)
            {
                sb.append(board.matrix[j][i]);
            }

            String pattern = sb.toString();

            if(pattern.equals(zero) || pattern.equals(cross))
            {
                return true;
            }
        }

        //diagonal
        int i=0, j=0;
        StringBuilder sb = new StringBuilder();

        while(i<sz)
        {
            sb.append(board.matrix[i][j]);
            i++;
            j++;
        }

        String pattern = sb.toString();
        if(pattern.equals(zero) || pattern.equals(cross))
        {
            return true;
        }

        //anti diagonal
        i=0;
        j=sz-1;
        sb = new StringBuilder();

        while(i<sz)
        {
            sb.append(board.matrix[i][j]);
            i++;
            j--;
        }
        pattern = sb.toString();
        if(pattern.equals(zero) || pattern.equals(cross)){
            return true;
        }
        

        return false;
    }
}



