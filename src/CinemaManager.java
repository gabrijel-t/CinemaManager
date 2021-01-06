
import java.util.Scanner;
public class CinemaManager {

    // A bit messy but working code!!!

    public static void main(String[] args) {
        // Write your code here
        CinemaManager c = new CinemaManager();
        c.initialize();
        while(flag){
            c.menu();
        }

        //c.initialize();
        //c.display();
        //c.book();
    }

    char[][] seats;
    int row;
    int seat;
    static boolean flag= true;
    int ticketSold;
    int currentIncome;
    int halfTeathre;
    int tot;

    public void initialize(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the number of rows: ");
        row = scan.nextInt();
        System.out.println("Enter the number of seats in each row: ");
        seat = scan.nextInt();
        System.out.println();
        seats = new char[row][seat];
        for(int i =0; i< row; i++) {
            for (int j = 0; j < seat; j++) {
                seats[i][j] = 'S';
            }
        }
        tot = totalIncome();

    }

    public void display(){
        System.out.println("Cinema:");
        System.out.println();
        for(int i =0; i<= seat; i++){
            if (i ==0){
                System.out.print("  ");
            }else {
                System.out.print(i + " ");
            }
        }
        System.out.println();

        for(int i =0; i <row; i++){
            System.out.print((i+1)+" ");
            for(int j =0; j<seat; j++){
                System.out.print(seats[i][j]+" ");
            }
            System.out.println("");
        }
    }



    public void book(){
        Scanner scan = new Scanner(System.in);
        boolean test = false;
        int rowN=0;
        int seatN=0;
        while(!test){
            System.out.println("Enter a row number: ");
            rowN = scan.nextInt();
            halfTeathre= rowN;
            System.out.println("Enter a seat number in that row: ");
            seatN = scan.nextInt();
            System.out.println();
            if (rowN >row || seatN > seat) {
                System.out.println("Wrong input!");

            } else if( seats[rowN - 1][seatN - 1] == 'B'){
                System.out.println("That ticket has already been purchased!");
            }else{
                test= true;
            }

        }
        int price=0;

        if(row* seat <=60){
            price =10;

        }else{
            int half = row/2;
            if(half>= rowN){
                price =10;

            }else{
                price =8;

            }
        }

        System.out.println("Ticket price: $"+price);
        currentIncome+= price;
        ticketSold++;
        seats[rowN-1][seatN-1] ='B';
        System.out.println("Cinema: ");

        for(int i =0; i<= seat; i++){
            if (i ==0){
                System.out.print("  ");
            }else {
                System.out.print(i + " ");
            }
        }
        System.out.println();
        for(int i =0; i <row; i++){
            System.out.print((i+1)+" ");
            for(int j =0; j<seat; j++){
                System.out.print(seats[i][j]+" ");
            }
            System.out.println("");
        }
    }

    public int totalIncome(){
        if(row*seat<=60){
            return row *seat*10;
        }else{
            int half = row/2;
            int cost =0;
            if(half>= halfTeathre) {
                cost += half * seat * 10;

                cost += (row - half) * seat * 8;
            }
            return cost;
        }
    }

    public void menu(){
        Scanner scan = new Scanner(System.in);
        System.out.println("1. Show the seats");
        System.out.println("2. Buy a ticket");
        System.out.println("3. Statistics");
        System.out.println("0. Exit");
        int option = scan.nextInt();

        if(option ==1){
            display();
            System.out.println();
        }else if(option ==2){
            book();
            System.out.println();
        }else if(option ==3){
            statistics();
            System.out.println();
        }else{
            flag = false;
        }
    }

    public void statistics(){
        System.out.println("Number of purchased tickets: "+ticketSold);
        double totalTickets = row* seat;
        double percentTicket = (ticketSold* 100)/ totalTickets;
        System.out.printf("Percentage %.2f%s", percentTicket, "%");
        System.out.println();
        System.out.println("Current income: $"+currentIncome);

        System.out.println("Total income: $"+ tot);
    }

    public void profit(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the number of rows:");
        int rows = scan.nextInt();
        System.out.println("Enter the number of seats in each row:");
        int seatPerRow = scan.nextInt();

        int seats = seatPerRow*rows;
        int income=0;
        if(seats< 60){
            income = seats*10;
        }else{
            int half = rows/2;
            income = half*seatPerRow*10 +(rows-half)*seatPerRow*8;
        }
        System.out.printf("Total income: \n$%d", income);
    }
}