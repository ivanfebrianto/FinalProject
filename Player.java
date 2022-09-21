import java.util.Random;

abstract class Player {
    protected String shape;
    protected static int playerMove;
    protected String name,playerId;
    Random rand = new Random();
    
}

class HumanPlayer extends Player{
    
}

class ComputerPlayer extends Player{
    public int generateRandomMove(int size){
        int kanan,bawah;
        do{
            playerMove = rand.nextInt(size*size);
            kanan = playerMove/size;
            bawah = playerMove%size;
        }while(Board.dimension[kanan][bawah] !=0);

        return playerMove;
    }
}
