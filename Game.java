
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;  

public class Game {
     
     public void play(){
        int Choose;
        int size;
        int enemy;
        int upperbound = 4; //bstas limit atas
        Scanner input = new Scanner(System.in);
        Random rand =  new Random();
        HumanPlayer player1 = new HumanPlayer();
        HumanPlayer player2= new HumanPlayer();
        ComputerPlayer computer = new ComputerPlayer();
        Board board = new Board(0);
        do
        {
            System.out.println("===== Tic Tac Toe =====");
            System.out.println("1.Join Game\n2.View History\n3.Exit");
            System.out.println("Choose : ");
            Choose = input.nextInt();
            if(Choose == 1)
            {
                System.out.println("Enter Your name : ");
                player1.name = input.next();
                System.out.println("Determine the size of the board : "); //3
                size = input.nextInt();
                board = new Board(size);
                board.printBoard();
                System.out.println("Choose Your enemy : \n1.Computer\n2.Human");
                enemy = input.nextInt();
                //untuk mereset board setelah game pertama selesai
                if(board.score!=0){
                    board.score = 0;
                }
                //jika musuh computer
                if(enemy == 1)
                {
                    
                    computer.name = "Computer";
                    computer.shape = "O";
                    computer.playerId = "[CMPTR]"+(rand.nextInt(upperbound)+1);
                    player1.shape = "X";
                    player1.playerId = "[HMN1]"+(rand.nextInt(upperbound)+1);
                    while(board.score == 0)
                    {
                        //saran-----
                        // cetak board seperti ini
                        //     0       1       2       
                        //  0 [1]    [2]     [3]     
                        //  1 [4]    [5]     [6]      
                        //  2 [7]    [8]    [9]     
                        //  
                        // input = 5
                        // int kanan = 4/size board adalah jumlah gerakan ke bawah
                        // int bawah = 4%size board adalah jumlah gerakan ke kanan
                        // koordinat array(1,1)
                        // board.dimension[kanan][bawah] = 1;
                        do{
                            System.out.println("Player 1 ["+player1.name+"] Turn : " ); 
                            player1.playerMove = input.nextInt(); 
                            player1.playerMove -= 1; // player1.playerMove = player1.playerMove - 1
                        }while(player1.playerMove>size*size-1 || player1.playerMove<0);
                        int kanan = player1.playerMove/size;
                        int bawah = player1.playerMove%size;
                        board.dimension[kanan][bawah] = 1;
                        board.printBoard();
                        board.CalculateScore();
                        //jika player 1 menang
                        if(board.score == 1)
                        {
                            break;
                        }
                        else
                        {
                            System.out.println("Player 2 ["+computer.name+"] Turn : " );
                            do{
                                computer.playerMove = computer.generateRandomMove(size);
                                System.out.println(computer.playerMove);
                                computer.playerMove -= 1;
                            }while(computer.playerMove > size*size - 1 || computer.playerMove < 0);
                            kanan = computer.playerMove/size;
                            bawah = computer.playerMove%size;
                            //System.out.println(kanan1 + " " +bawah1);
                            board.dimension[kanan][bawah] = 2;
                            board.printBoard();
                            board.CalculateScore();
                        }
                    }
                }
                //jika musuh human
                else if(enemy == 2)
                {
                    System.out.println("Enter Your name : ");
                    player2.name = input.next();
                    player2.shape = "O";
                    player1.shape = "X";
                    player1.playerId = "[HMN1]"+(rand.nextInt(upperbound)+1);
                    player2.playerId = "[HMN2]"+(rand.nextInt((upperbound)+1)*5);
                    while(board.score == 0)
                    {
                        do{
                            System.out.println("Player 1 ["+player1.name+"] Turn : " ); 
                            player1.playerMove = input.nextInt(); 
                            player1.playerMove -=1;
                        }while(player1.playerMove>size*size-1 || player1.playerMove<0);
                        int kanan = player1.playerMove/size;
                        int bawah = player1.playerMove%size;
                        board.dimension[kanan][bawah] = 1;
                        board.printBoard();
                        board.CalculateScore();
                        if(board.score == 1)
                        {
                            break;
                        }
                        do{
                            System.out.println("Player 2 ["+player2.name+"] Turn : " ); 
                            player2.playerMove = input.nextInt(); 
                            player2.playerMove -=1;
                        }while(player2.playerMove>size*size-1 || player2.playerMove<0);
                        kanan = player2.playerMove/size;
                        bawah = player2.playerMove%size;
                        board.dimension[kanan][bawah] = 2;
                        board.printBoard(); 
                        board.CalculateScore();
                    }
                }
            }
            //melihat history game
            if(Choose == 2)
            {
                //read file
                // try {
                //     FileReader fr = new FileReader("data.txt");
                //     BufferedReader br = new BufferedReader(fr);
                    
                //     String data;
                //     if ((data = br.readLine()) == null){
                //         System.out.println("no matches found");
                //     }
                //     while ((data = br.readLine()) != null){
                //         System.out.println(data + "/n");
                //     }
                //     br.close();   
                // } catch (IOException e){
                //     System.out.println("");
                // }
                System.out.println();
                System.out.println("====== HISTORY GAME ======");  
                System.out.println("Players Name : ");
                //jika kita memilih enemy computer
                if(player2.name == null)
                {
                    System.out.println(player1.name+player1.playerId + " VS " + computer.name+computer.playerId);
                    
                    if(board.win == 1)
                    {
                        System.out.println("Result : The Winner is "+player1.name);
                    }
                    else if(board.win == 2)
                    {
                        System.out.println("Result : The Winner is "+computer.name);
                    }
                    else
                    {
                        System.out.println("No Winner");
                    }
                    System.out.print("Date of Play : ");
                    getDate();
                }
                //jika musuh human
                else
                {
                    System.out.println(player1.name+player1.playerId + " VS " + player2.name+player2.playerId);
                    if(board.win == 1)
                    {
                        System.out.println("Result : The Winner is "+player1.name);
                    }
                    else if(board.win == 2)
                    {
                        System.out.println("Result : The Winner is "+player2.name);
                    }
                    else
                    {
                        System.out.println("No Winner");
                    }
                    System.out.print("Date of play : ");
                    getDate();
                }
            }
        }while(Choose != 3);
        //passing data to notepad
        // try {
        //     FileWriter fw = new FileWriter("data.txt", true);
        //     BufferedWriter bw = new BufferedWriter(fw);
        //         bw.newLine();
        //         bw.write("====== HISTORY GAME ======");  
        //         bw.write("Players Name : ");
        //         //jika kita memilih enemy computer
        //         if(player2.name == null)
        //         {
        //             bw.write(player1.name+player1.playerId + " VS " + computer.name+computer.playerId);
                    
        //             if(board.win == 1)
        //             {
        //                 bw.write("Result : The Winner is "+player1.name);
        //             }
        //             else if(board.win == 2)
        //             {
        //                 bw.write("Result : The Winner is "+computer.name);
        //             }
        //             else
        //             {
        //                 bw.write("No Winner");
        //             }
        //             System.out.print("Date of Play : ");
        //             getDate();
        //         }
        //         //jika musuh human
        //         else
        //         {
        //             bw.write(player1.name+player1.playerId + " VS " + player2.name+player2.playerId);
        //             if(board.win == 1)
        //             {
        //                 bw.write("Result : The Winner is "+player1.name);
        //             }
        //             else if(board.win == 2)
        //             {
        //                 bw.write("Result : The Winner is "+player2.name);
        //             }
        //             else
        //             {
        //                 bw.write("No Winner");
        //             }
        //             bw.write("Date of play : ");
        //             getDate();
        //         }
        // } catch (Exception e) {
        //     //TODO: handle exception
        // }
        System.out.println("Thank You for Playing !");
        input.close();
    }

    //untuk mengambil tanggal
    public static void getDate(){
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");  
        Date date = new Date();  
        System.out.println(formatter.format(date)); 
    }

    //untuk menentukan status
    public static int Status(int score){
        if(score == 1)
        {
            System.out.println("Player 1 Win");
        }
        else if(score == 2)
        {
            System.out.println("Player 2 Win");
        }
        return score;
    }
}
