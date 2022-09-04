import java.nio.file.FileSystemNotFoundException;
import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

public class TicTacToe {

    public static char[][] board;
    public static int wr;
    public static int wc;
    public static char checkWin() {
        //rows
        char choice = '_';
        if ((board[0][0] == board[0][1]) && (board[0][1] == board[0][2]) && board[0][0] != '_') {
            choice = board[0][0];
        }
        if ((board[1][0] == board[1][1]) && (board[1][1] == board[1][2]) && board[1][0] != '_') {
            choice = board[1][0];
        }
        if ((board[2][0] == board[2][1]) && (board[2][1] == board[2][2]) && board[2][0] != '_') {
            choice = board[2][0];
        }

        //columns

        if ((board[0][0] == board[1][0]) && (board[1][0] == board[2][0]) && board[1][0] != '_') {
            choice = board[1][0];
        }
        if ((board[0][1] == board[1][1]) && (board[1][1] == board[2][1]) && board[0][1] != '_') {
            choice = board[0][1];
        }
        if ((board[0][2] == board[1][2]) && (board[1][2] == board[2][2]) && board[0][2] != '_') {
            choice = board[0][2];
        }

        //diagonals

        if ((board[0][0] == board[1][1]) && (board[1][1] == board[2][2]) && board[0][0] != '_') {
            choice = board[0][0];
        }

        if ((board[0][2] == board[1][1]) && (board[1][1] == board[2][0]) && board[0][2] != '_') {
            choice = board[0][2];
        }

        return choice;
    }
    public static void printBoard() {
        for (int i = 0; i < board.length; i++) {
            System.out.print("\t");
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + " ");

            }
            System.out.print("\t");
            System.out.println();
        }
    }


    public static void boardSetup() {
        board = new char[3][3];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = '_';
            }
        }
    }

    public static void updateBoard(char choice, int row, int column) {
        board[row][column] = choice;
    }

    public static boolean checkEmptySlot(int r, int col) {
        return board[r][col] == '_';
    }


    public static int checkUserSlotsRow(char userChoice, int r) {
        int count = 0;
        if (board[r][0] != '_' && board[r][1] != '_' && board[r][2] != '_') return -1;

        if (board[r][0] == userChoice) {
            count++;
        }
        if (board[r][1] == userChoice) {
            count++;
        }

        if (board[r][2] == userChoice) {
            count++;
        }


        return count;
    }

    public static int checkUserSlotsColumn(char userChoice, int c) {
        int count = 0;

        if (board[0][c] != '_' && board[1][c] != '_' && board[2][c] != '_') return -1;
        if (board[0][c] == userChoice) {
            count++;
        }
        if (board[1][c] == userChoice) {
            count++;
        }

        if (board[2][c] == userChoice) {
            count++;
        }


        return count;
    }



    public static int checkLeftDiagonalSlots(char userChoice) {


        int count = 0;

        if (board[0][0] != '_' && board[1][1] != '_' && board[2][2] != '_') return -1;

        if (board[0][0] == userChoice) {
            count++;
        }
        if (board[1][1] == userChoice) {
            count++;
        }
        if (board[2][2] == userChoice) {
            count++;
        }

        return count;
    }

    public static int checkRighttDiagonalSlots(char userChoice) {
        int count = 0;

        if (board[2][0] != '_' && board[1][1] != '_' && board[0][2] != '_') return -1;

        if (board[2][0] == userChoice) {
            count++;
        }
        if (board[1][1] == userChoice) {
            count++;
        }
        if (board[0][2] == userChoice) {
            count++;
        }
        return count;
    }

    public static int getMin(int a, int b, int c) {
        return (a < b) ? (a < c ? a : c) : (b < c ? b : c);
    }
    public static int getMax(int a, int b, int c) {
        return (a > b) ? (a > c ? a : c) : (b > c ? b : c);
    }
    public static int getMin(int a, int b) {
        return (a < b) ? a : b;
    }

    public static int getMax(int a, int b) {
        return (a > b) ? a : b;
    }

    public static void checkAndUpdateRow(char choice, int r) {
        if (checkEmptySlot(r, 0)) {
            updateBoard(choice, r, 0);
        } else if (checkEmptySlot(r, 1)) {
            updateBoard(choice, r, 1);
        } else if (checkEmptySlot(r, 2)) {
            updateBoard(choice, r, 2);

        }
    }

    public static void checkAndUpdateColumn(char choice, int c) {
        if (checkEmptySlot(0, c)) {
            updateBoard(choice, 0, c);

        } else if (checkEmptySlot(1, c)) {
            updateBoard(choice, 1, c);
        } else if (checkEmptySlot(2, c)) {
            updateBoard(choice, 2, c);

        }
    }

    public static void checkAndUpdateLeftDiagnonal(char choice) {
        if (checkEmptySlot(0, 0)) {
            updateBoard(choice, 0, 0);
        } else if (checkEmptySlot(1, 1)) {
            updateBoard(choice, 1, 1);
        } else if (checkEmptySlot(2, 2)) {
            updateBoard(choice, 2, 2);

        }
    }

    public static void checkAndUpdateRightDiagnonal(char choice) {
        if (checkEmptySlot(2, 0)) {
            updateBoard(choice, 2, 0);

        } else if (checkEmptySlot(1, 1)) {
            updateBoard(choice, 1, 1);
            return;
        } else if (checkEmptySlot(0, 2)) {
            updateBoard(choice, 0, 2);

        }
    }
    public static void updateBoard(char choice, String slotToUpdate) {
        int slot[] = new int[2];
        switch (slotToUpdate) {

            case "firstrow":
                checkAndUpdateRow(choice, 0);
                break;
            case "secondrow":
                checkAndUpdateRow(choice, 1);
                break;
            case "thirdrow":
                checkAndUpdateRow(choice, 2);
                break;
            case "firstcolumn":
                checkAndUpdateColumn(choice, 0);
                break;
            case "secondcolumn":
                checkAndUpdateColumn(choice, 1);
                break;
            case "thirdcolumn":
                checkAndUpdateColumn(choice, 2);
                break;
            case "rightdiagonal":
                checkAndUpdateRightDiagnonal(choice);
                break;
            case "leftdiagonal":
                checkAndUpdateLeftDiagnonal(choice);
                break;
            default:
                System.out.println("game is going to crash :( :( :(");
                System.exit(0);
                break;


        }

    }

    public static boolean checkAndUpdateWinningSlot(char choice)
    {
        //row
        int count=0;
        for(int i=0;i<board[0].length;i++)
        {

            if(board[0][i] == choice)
            {
                count++;
            }
        }
        if(count == 2){

        }


        return false;
    }

    public static void getWinningSlotRow(char choice,int r)
    {
        int count=0;
        for(int i=0;i<3;i++)
        {
            if(board[r][i] == '_') {
                if(count == 2){
                    wr = 0;
                    wc =i;
                }

            }
            else
            {
                if(board[r][i]==choice)
                {
                    count++;
                }

            }
        }

    }

    public static void getWinningSlotColumn(char choice,int c)
    {
        int count=0;
        for(int i=0;i<3;i++)
        {
            if(board[i][c] == '_') {
                if(count == 2){
                    wr = i;
                    wc =c;
                }

            }
            else
            {
                if(board[i][c]==choice)
                {
                    count++;
                }

            }
        }

    }

    public static void getWinnsingSlotRightDiagonal(char choice){
        if(board[2][0]==board[1][1]){
            if(board[1][1]==choice){
                if(board[0][2]=='_'){
                    wr =0;
                    wc=2;
                    return;
                }
            }
        }

        if(board[2][0]==board[0][2]){
            if(board[2][0]==choice){
                if(board[1][1]=='_'){
                    wr =1;
                    wc=1;
                    return;
                }
            }
        }
        if(board[1][1]==board[0][2]){
            if(board[1][1]==choice){
                if(board[2][0]=='_'){
                    wr =2;
                    wc=0;
                    return;
                }
            }
        }


    }


    public static void getWinnigSlotLeftDiagonal(char choice){
        int count=0;
        for(int i=0;i<3;i++){
            if(board[i][i]=='_'){
                if(count == 2){
                    wr=wc=i;
                    return;
                }
            }
            else{
                if(choice == board[i][i]){
                    count++;
                }
            }
        }
    }


    public static void getWinningSlot(char choice){
        //row
        getWinningSlotRow(choice,0);
        if(wr != -1 && wc != -1) return;

        wr=wc=-1;
        getWinningSlotRow(choice,1);
        if(wr != -1 && wc != -1) return;

        wr=wc=-1;
        getWinningSlotRow(choice,2);
        if(wr != -1 && wc != -1) return;

        //columns

        wr=wc=-1;
        getWinningSlotColumn(choice,0);
        if(wr != -1 && wc != -1) return;

        wr=wc=-1;
        getWinningSlotColumn(choice,1);
        if(wr != -1 && wc != -1) return;

        wr=wc=-1;
        getWinningSlotColumn(choice,2);
        if(wr != -1 && wc != -1) return;

        //diagonal
        wr=wc=-1;
        getWinnigSlotLeftDiagonal(choice);
        if(wr != -1 && wc != -1) return;

        wr=wc=-1;
        getWinnigSlotLeftDiagonal(choice);
        if(wr != -1 && wc != -1) return;

        wr=wc=-1;
        getWinnsingSlotRightDiagonal(choice);


    }


    public static void computerTurn(char userChoice, char computerChoice, int lur, int luc) {

        System.out.println("Computer is playing ! Please wait for computers turn to finish!!!");

        wr=wc=-1;
        getWinningSlot(computerChoice);
        if(wr !=-1 && wc!=-1){
            updateBoard(computerChoice,wr,wc);
            return;
        }

        String maxUserSlots = "";
        int firstRow = checkUserSlotsRow(userChoice, 0);
        int secondRow = checkUserSlotsRow(userChoice, 1);
        int thirdRow = checkUserSlotsRow(userChoice, 2);

        int maxRow = getMax(firstRow, secondRow, thirdRow);


        int firstColumn = checkUserSlotsColumn(userChoice, 0);
        int secondColumn = checkUserSlotsColumn(userChoice, 1);
        int thirdColumn = checkUserSlotsColumn(userChoice, 2);

        int maxCol = getMax(firstColumn, secondColumn, thirdColumn);

        int ltoRDiag = checkLeftDiagonalSlots(userChoice);
        int rtoLDiag = checkRighttDiagonalSlots(userChoice);
        int maxDiag = getMax(ltoRDiag, rtoLDiag);


        maxUserSlots = (maxRow > maxCol) ? ((maxRow > maxDiag) ? "row" : "diagonal") : ((maxCol > maxDiag) ? "column" : "diagonal");

        String slotToUpdate = "";

        if (maxUserSlots.equalsIgnoreCase("row")) {
            String row = (firstRow > secondRow) ? ((firstRow > thirdRow) ? "first" : "third") : ((secondRow > thirdRow) ? "second" : "third");
            slotToUpdate = row + maxUserSlots;
        } else if (maxUserSlots.equalsIgnoreCase("column")) {
            String column = (firstColumn > secondColumn) ? ((firstRow > thirdColumn) ? "first" : "third") : ((secondColumn > thirdColumn) ? "second" : "third");
            slotToUpdate = column + maxUserSlots;
        } else if (maxUserSlots.equalsIgnoreCase("diagonal")) {
            String diagonal = (ltoRDiag > rtoLDiag) ? "left" : "right";
            slotToUpdate = diagonal + maxUserSlots;
        }

        //System.out.println("Slot to update:"+ slotToUpdate);

        updateBoard(computerChoice, slotToUpdate);
    }

    public static boolean checkAllSlotsFilled() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == '_') return false;
            }
        }

        return true;
    }


    public static boolean isUserChoiceValid(char choice) {
        return (choice == 'x' || choice == 'X' || choice == 'O' || choice == 'o');
    }

    public static boolean isValidRowColumn(int r,int c)
    {
        if( (r<0 || r>2) || (c<0 || c>2) ) return false;

        if( board[r][c] !='_'){
               System.out.println("Please Choose a slot that is not yet filled by anyone ");
               return false;
        }

        return true ;
    }

    public static void main(String args[]) {

        boolean gameOver = false;
        boolean userTurn = true;
        char computerChoice = '_';
        char userChoice = '_';
        int lastUserRow = -1;
        int lastUserColumn = -1;
        boolean firstTurn = true;
        System.out.println("*************Let's play tic tac toe*******************\n" +
                           "******************************************************\n" +
                           "******************************************************");
        boardSetup();

        Scanner sc = new Scanner(System.in);

        while (!isUserChoiceValid(userChoice)) {
            System.out.println("Enter ur choice(X/O):");
            userChoice = sc.nextLine().charAt(0);
        }


        if (userChoice == 'x' || userChoice == 'X') {
            userChoice ='X';
            computerChoice = 'O';
        } else {
            computerChoice = 'X';
            userChoice = 'O';
        }


        while (!gameOver) {
            if (gameOver == false && checkAllSlotsFilled()) {
                gameOver = true;
                System.out.println("#########################Its a TIE#############################################");
                System.out.println("Final board:");
                printBoard();
                continue;
            }
            char winner = checkWin();



            if (winner == userChoice) {
                printBoard();
                System.out.println("******************You win*********************");
                System.out.println("Final board:");
                printBoard();
                gameOver = true;
                break;
            } else if (winner == computerChoice) {
                printBoard();
                System.out.println("####################Computer  wins########################");
                System.out.println("Final board:");
                printBoard();
                gameOver = true;
                break;
            }

            if (firstTurn) {
                System.out.println("Do you want computer to begin playing?(yes/no)");

                String playerBegins = sc.nextLine();
                if (playerBegins.equalsIgnoreCase("yes")) {
                    userTurn = false;
                }

                firstTurn = false;
            }

            gameOver = false;

            if (userTurn) {
                printBoard();

                int row =-1;
                int column = -1;
                while(!isValidRowColumn(row,column))
                {
                    System.out.println("your turn, choose a valid row{0,1,2} and valid column {0,1,2}");
                     row = sc.nextInt();
                     column = sc.nextInt();
                }


                userTurn = false;
                updateBoard(userChoice, row, column);
                lastUserRow = row;
                lastUserColumn = column;

            } else {
                computerTurn(userChoice, computerChoice, lastUserRow, lastUserColumn);

                userTurn = true;
            }

        }

        sc.close();
    }
}