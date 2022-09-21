public class Board {
    static int [][] dimension;
    static int score = 0;
    static int win;

    //constructor
    Board(int size){
    dimension = new int [size][size];
    }

    public static void CalculateScore(){
    String line = "";
    Game game = new Game();
    for(int i = 0; i < dimension.length; i++){
        for(int j = 0; j < dimension.length*dimension.length; j++){
            if(dimension.length == 3)   //jika board 3x3
            {
                    switch (j){
                        //horizontal
                        case 0:
                            line = (dimension[0][0]==1?"X":dimension[0][0]==2?"O":" ") + (dimension[0][1]==1?"X":dimension[0][1]==2?"O":"") + (dimension[0][2]==1?"X":dimension[0][2]==2?"O":"");
                            break;
                        case 1:
                            line = (dimension[1][0]==1?"X":dimension[0][1]==2?"O":" ") + (dimension[1][0]==1?"X":dimension[1][1]==2?"O":"") + (dimension[1][2]==1?"X":dimension[1][2]==2?"O":"");
                            break;
                        case 2:
                            line = (dimension[2][0]==1?"X":dimension[2][0]==2?"O":" ") + (dimension[2][1]==1?"X":dimension[2][1]==2?"O":"") + (dimension[2][2]==1?"X":dimension[2][2]==2?"O":"");
                            break;
                        //vertical
                        case 3:
                            line = (dimension[0][0]==1?"X":dimension[0][0]==2?"O":" ") + (dimension[1][0]==1?"X":dimension[1][0]==2?"O":"") + (dimension[2][0]==1?"X":dimension[2][0]==2?"O":"");
                            break;
                        case 4:
                            line = (dimension[0][1]==1?"X":dimension[0][1]==2?"O":" ") + (dimension[1][1]==1?"X":dimension[1][1]==2?"O":"") + (dimension[2][1]==1?"X":dimension[2][1]==2?"O":"");
                            break;
                        case 5:
                            line = (dimension[0][2]==1?"X":dimension[0][2]==2?"O":" ") + (dimension[1][2]==1?"X":dimension[1][2]==2?"O":"") + (dimension[2][2]==1?"X":dimension[2][2]==2?"O":"");
                            break;
                        //diagonal
                        case 6  :
                            line = (dimension[0][0]==1?"X":dimension[0][0]==2?"O":" ") + (dimension[1][1]==1?"X":dimension[1][1]==2?"O":"") + (dimension[2][2]==1?"X":dimension[2][2]==2?"O":"");
                            break;
                        case 7 :
                            line = (dimension[0][2]==1?"X":dimension[0][2]==2?"O":" ") + (dimension[1][1]==1?"X":dimension[1][1]==2?"O":"") + (dimension[2][0]==1?"X":dimension[2][0]==2?"O":"");
                            break;
                }
                if(line.equals("XXX")){
                    score = 1;
                }
                else if(line.equals("OOO")){
                    score = 2;
                } 
            }
            else if(dimension.length == 4)
            {
                    switch (j){
                        //horizontal
                        case 0:
                            line = (dimension[0][0]==1?"X":dimension[0][0]==2?"O":" ") + (dimension[0][1]==1?"X":dimension[0][1]==2?"O":"") + (dimension[0][2]==1?"X":dimension[0][2]==2?"O":"") + (dimension[0][3]==1?"X":dimension[0][3]==2?"O":"");
                            break;
                        case 1:
                            line = (dimension[1][0]==1?"X":dimension[1][0]==2?"O":" ") + (dimension[1][1]==1?"X":dimension[1][1]==2?"O":"") + (dimension[1][2]==1?"X":dimension[1][2]==2?"O":"") + (dimension[1][3]==1?"X":dimension[1][3]==2?"O":"");
                            break;
                        case 2:
                            line = (dimension[2][0]==1?"X":dimension[2][0]==2?"O":" ") + (dimension[2][1]==1?"X":dimension[2][1]==2?"O":"") + (dimension[2][2]==1?"X":dimension[2][2]==2?"O":"")+ (dimension[2][3]==1?"X":dimension[2][3]==2?"O":"");
                            break;
                        case 3:
                            line = (dimension[3][0]==1?"X":dimension[3][0]==2?"O":" ") + (dimension[3][1]==1?"X":dimension[3][1]==2?"O":"") + (dimension[3][2]==1?"X":dimension[3][2]==2?"O":"") + (dimension[3][3]==1?"X":dimension[3][3]==2?"O":"");
                            break;
                        //vertical
                        case 4:
                            line = (dimension[0][0]==1?"X":dimension[0][0]==2?"O":" ") + (dimension[1][0]==1?"X":dimension[1][0]==2?"O":"") + (dimension[2][0]==1?"X":dimension[2][0]==2?"O":"") + (dimension[3][0]==1?"X":dimension[3][0]==2?"O":"");
                            break;
                        case 5:
                            line = (dimension[0][1]==1?"X":dimension[0][1]==2?"O":" ") + (dimension[1][1]==1?"X":dimension[1][1]==2?"O":"") + (dimension[2][1]==1?"X":dimension[2][1]==2?"O":"")+ (dimension[3][1]==1?"X":dimension[3][1]==2?"O":"");
                            break;
                        case 6:
                            line = (dimension[0][2]==1?"X":dimension[0][2]==2?"O":" ") + (dimension[1][2]==1?"X":dimension[1][2]==2?"O":"") + (dimension[2][2]==1?"X":dimension[2][2]==2?"O":"")+ (dimension[3][2]==1?"X":dimension[3][2]==2?"O":"");
                            break;
                        case 7 :
                            line = (dimension[0][3]==1?"X":dimension[0][3]==2?"O":" ") + (dimension[1][3]==1?"X":dimension[1][3]==2?"O":"") + (dimension[2][3]==1?"X":dimension[2][3]==2?"O":"") + (dimension[3][3]==1?"X":dimension[3][3]==2?"O":"");
                            break;
                        //diagonal
                        case 8  :
                            line = (dimension[0][0]==1?"X":dimension[0][0]==2?"O":" ") + (dimension[1][1]==1?"X":dimension[1][1]==2?"O":"") + (dimension[2][2]==1?"X":dimension[2][2]==2?"O":"") + (dimension[3][3]==1?"X":dimension[3][3]==2?"O":"");
                            break;
                        case 9 :
                            line = (dimension[0][3]==1?"X":dimension[0][3]==2?"O":" ") + (dimension[1][2]==1?"X":dimension[1][2]==2?"O":"") + (dimension[2][1]==1?"X":dimension[2][1]==2?"O":"") + (dimension[3][0]==1?"X":dimension[3][0]==2?"O":"");
                            break;   
                    }
                    if(line.equals("XXXX")){
                        score = 1;
                    }
                    else if(line.equals("OOOO")){
                        score = 2;
                    } 
                }
                //board 5x5
                else if(dimension.length == 5)
                {
                    switch (j){
                        //horizontal
                        case 0:
                            line = (dimension[0][0]==1?"X":dimension[0][0]==2?"O":" ") + (dimension[0][1]==1?"X":dimension[0][1]==2?"O":"") + (dimension[0][2]==1?"X":dimension[0][2]==2?"O":"") + (dimension[0][3]==1?"X":dimension[0][3]==2?"O":"") + (dimension[0][4]==1?"X":dimension[0][4]==2?"O":"");
                            break;
                        case 1:
                            line = (dimension[1][0]==1?"X":dimension[1][0]==2?"O":" ") + (dimension[1][1]==1?"X":dimension[1][1]==2?"O":"") + (dimension[1][2]==1?"X":dimension[1][2]==2?"O":"") + (dimension[1][3]==1?"X":dimension[1][3]==2?"O":"") + (dimension[1][4]==1?"X":dimension[1][4]==2?"O":"");
                            break;
                        case 2:
                            line = (dimension[2][0]==1?"X":dimension[2][0]==2?"O":" ") + (dimension[2][1]==1?"X":dimension[2][1]==2?"O":"") + (dimension[2][2]==1?"X":dimension[2][2]==2?"O":"")+ (dimension[2][3]==1?"X":dimension[2][3]==2?"O":"") + (dimension[2][4]==1?"X":dimension[2][4]==2?"O":"");
                            break;
                        case 3:
                            line = (dimension[3][0]==1?"X":dimension[3][0]==2?"O":" ") + (dimension[3][1]==1?"X":dimension[3][1]==2?"O":"") + (dimension[3][2]==1?"X":dimension[3][2]==2?"O":"") + (dimension[3][3]==1?"X":dimension[3][3]==2?"O":"") + (dimension[3][4]==1?"X":dimension[3][4]==2?"O":"");
                            break;
                        case 4:
                            line = (dimension[4][0]==1?"X":dimension[4][0]==2?"O":" ") + (dimension[4][1]==1?"X":dimension[4][1]==2?"O":"") + (dimension[4][2]==1?"X":dimension[4][2]==2?"O":"") + (dimension[4][3]==1?"X":dimension[4][3]==2?"O":"") + (dimension[4][4]==1?"X":dimension[4][4]==2?"O":"");
                            break;
                        //vertical
                        case 5:
                            line = (dimension[0][0]==1?"X":dimension[0][0]==2?"O":" ") + (dimension[1][0]==1?"X":dimension[1][0]==2?"O":"") + (dimension[2][0]==1?"X":dimension[2][0]==2?"O":"") + (dimension[3][0]==1?"X":dimension[3][0]==2?"O":"") + (dimension[4][0]==1?"X":dimension[4][0]==2?"O":"");
                            break;
                        case 6:
                            line = (dimension[0][1]==1?"X":dimension[0][1]==2?"O":" ") + (dimension[1][1]==1?"X":dimension[1][1]==2?"O":"") + (dimension[2][1]==1?"X":dimension[2][1]==2?"O":"") + (dimension[3][1]==1?"X":dimension[3][1]==2?"O":"") + (dimension[4][1]==1?"X":dimension[4][1]==2?"O":"");
                            break;
                        case 7:
                            line = (dimension[0][2]==1?"X":dimension[0][2]==2?"O":" ") + (dimension[1][2]==1?"X":dimension[1][2]==2?"O":"") + (dimension[2][2]==1?"X":dimension[2][2]==2?"O":"") + (dimension[3][2]==1?"X":dimension[3][2]==2?"O":"") + (dimension[4][2]==1?"X":dimension[4][2]==2?"O":"");
                            break;
                        case 8:
                            line = (dimension[0][3]==1?"X":dimension[0][3]==2?"O":" ") + (dimension[1][3]==1?"X":dimension[1][3]==2?"O":"") + (dimension[2][3]==1?"X":dimension[2][3]==2?"O":"") + (dimension[3][3]==1?"X":dimension[3][3]==2?"O":"") + (dimension[4][3]==1?"X":dimension[4][3]==2?"O":"");
                        case 9:
                            line = (dimension[0][4]==1?"X":dimension[0][4]==2?"O":" ") + (dimension[1][4]==1?"X":dimension[1][4]==2?"O":"") + (dimension[2][4]==1?"X":dimension[2][4]==2?"O":"") + (dimension[3][4]==1?"X":dimension[3][4]==2?"O":"") + (dimension[4][4]==1?"X":dimension[4][4]==2?"O":"");
                            break;
                        //diagonal
                        case 10:
                            line = (dimension[0][0]==1?"X":dimension[0][0]==2?"O":" ") + (dimension[1][1]==1?"X":dimension[1][1]==2?"O":"") + (dimension[2][2]==1?"X":dimension[2][2]==2?"O":"") + (dimension[3][3]==1?"X":dimension[3][3]==2?"O":"") + (dimension[4][4]==1?"X":dimension[4][4]==2?"O":"");
                            break;
                        case 11:
                            line = (dimension[0][4]==1?"X":dimension[0][4]==2?"O":" ") + (dimension[1][3]==1?"X":dimension[1][3]==2?"O":"") + (dimension[2][2]==1?"X":dimension[2][2]==2?"O":"") + (dimension[3][1]==1?"X":dimension[3][1]==2?"O":"") + (dimension[4][0]==1?"X":dimension[4][0]==2?"O":"");
                            break;
                    }
                    if(line.equals("XXXXX")){
                        score = 1;
                    }
                    else if(line.equals("OOOOO")){
                        score = 2;
                    } 
                }
            }
        }
        win = game.Status(score);
        
   }

   public static void printBoard(){
    //for each loop
    for(int[] i : dimension){
        for(int j : i){
            System.out.print(j == 1?"[X] ":j==2?"[O] ":"["+j+"]"+ " ");//ternary operator (condition)? true: false;
        }
        System.out.println();
    }
   }
}

