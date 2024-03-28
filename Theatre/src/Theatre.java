import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
public class Theatre {
    static {
        System.out.println("|--------------------------|");
        System.out.println("|Welcome to the New Theatre|");//Welcome message
        System.out.println("|--------------------------|");
    }
    public static ArrayList<Ticket> full_details = new ArrayList<>();//Create an Array List
    public static int[] row_1 = new int [12]; //Array for the 1st row
    public static int[] row_2 = new int [16];//Array for the 2nd row
    public static int[] row_3 = new int [20];//Array for the 3rd row
    public static int row_num;//creating a variable to get row number
    public static int seat_num;//creating a variable to get seat number
    public static void main(String[] args) {
        boolean status = true;
        while (status) {
            System.out.println();
            System.out.println("""
                    -------------------------------------------------
                    Please select an option:
                    1) Buy a ticket
                    2) Print seating area
                    3) Cancel ticket
                    4) List available seats
                    5) Save to file
                    6) Load from file
                    7) Print ticket information and total price
                    8) Sort tickets by price
                         0) Quit
                    -------------------------------------------------
                    """);
            //getting a valid option
            int option;
            while (true) {
                try {
                    Scanner input = new Scanner(System.in);
                    System.out.print("Enter option: ");
                    option = input.nextInt();
                    if (option > 8 || option < 0) {
                        System.out.println("Please select the right option");
                    } else {
                        break;
                    }
                } catch (Exception InputMismatchException) {
                    System.out.println("Invalid Input");
                }

            }
            //Calling a Switch-case
            switch (option) {
                case 1:
                    buy_ticket();//method for buy a ticket
                    break;
                case 2:
                    print_seating_area();//method for print the seating area
                    break;
                case 3:
                    cancel_ticket();//method for cancel ticket
                    break;
                case 4:
                    show_available();//method for view available seats
                    break;
                case 5:
                    save();//method for save details in a file
                    break;
                case 6:
                    load();//method for get saving details
                    break;
                case 7:
                    show_tickets_info();//method for show all details of tickets and total price
                    break;
                case 8:
                    sort_tickets();//method for organize ticket information and print the cheapest tickets first
                    break;
                default:
                    System.out.println("Thank you for using our System");
                    status = false;
            }
        }
    }
    //Creating the method to get valid row and seat number
    public static void validation_seat_row(){
        while (true) {
            try {
                System.out.print("Enter a row number(1-3): ");
                Scanner input_1 = new Scanner(System.in);
                row_num = input_1.nextInt();
                if (row_num > 3 || row_num<0) {
                    System.out.println("Row number is not in range");
                } else {
                    break;
                }
            } catch (Exception InputMismatchException) {
                System.out.println("Invalid row number");
            }

        }
        //getting a valid seat number as a input
        while (true) {
            try {
                if(row_num==1) {
                    System.out.print("Enter a seat number(1-12): ");
                } else if (row_num==2) {
                    System.out.print("Enter a seat number(1-16): ");
                }
                else{
                    System.out.print("Enter a seat number(1-20): ");
                }
                Scanner input_2 = new Scanner(System.in);
                seat_num = input_2.nextInt();
                if ((row_num==1) && (seat_num>12||seat_num<0)){
                    System.out.println("Please enter valid seat number in row 1");
                } else if ((row_num==2) && (seat_num>16 || seat_num<0)) {
                    System.out.println("Please enter valid seat number in row 2");
                } else if ((row_num ==3) && (seat_num>20 || seat_num<0)) {
                    System.out.println("please enter valid seat number in row 3");
                }
                else{
                    break;
                }
            } catch (Exception InputMismatchException) {
                System.out.println("Invalid seat number");
            }

        }

    }
    // create a method for buying a ticket
    public static void buy_ticket() {
        Scanner input_person = new Scanner(System.in);
        Person p1 = new Person();
        //getting person details(using Person class)
        System.out.print("Enter the name: ");
        p1.setName(input_person.nextLine());
        System.out.print("Enter the surname: ");
        p1.setSurname(input_person.nextLine());
        System.out.print("Enter the email: ");
        p1.setEmail(input_person.nextLine());
        validation_seat_row();
        //check seat is booked or available, if seat is available then progress as booked.
        if (row_num == 1) {
            if (row_1[seat_num-1] == 0) {
                row_1[seat_num - 1] = 1;
                System.out.println("This seat is available for booking.");
                System.out.println("Successfully booked a seat.");
                // evaluate the price for seat in row 1.
                double price = 30;
                Ticket t1 = new Ticket(row_num, seat_num, price, p1);
                full_details.add(t1);
            }
            else{
                System.out.println("This seat already booked.");
                buy_ticket();
            }
        } else if (row_num == 2) {
            if(row_2[seat_num-1] == 0) {
                row_2[seat_num - 1] = 1;
                System.out.println("This seat is available for booking.");
                System.out.println("Successfully booked a seat.");
                // evaluate the price for seat in row 2.
                double price = 50;
                Ticket t1 = new Ticket(row_num, seat_num, price, p1);
                full_details.add(t1);
            }
            else{
                System.out.println("This seat already booked.");
                buy_ticket();
            }
        } else {
            if (row_3[seat_num-1] == 0) {
                row_3[seat_num - 1] = 1;
                System.out.println("This seat is available for booking.");
                System.out.println("Successfully booked a seat.");
                // evaluate the price for seat in row 3.
                double price = 70;
                Ticket t1 = new Ticket(row_num, seat_num, price, p1);
                full_details.add(t1);
            }
            else{
                System.out.println("This seat already booked.");
                buy_ticket();
            }
        }
    }
    // create a method for print seating area
    public static void print_seating_area() {
        System.out.println("     "+"***********");
        System.out.println("     "+"*  STAGE  *");
        System.out.println("     "+"***********");

        //getting booked seat as X and available seat as O in row 1
        System.out.print("    ");
        for(int seating_row_1=0;seating_row_1 < row_1.length/2; seating_row_1 ++){
            if (row_1[seating_row_1] ==0){
                System.out.print("O");
            }
            else{
                System.out.print("X");
            }
        }
        System.out.print(" ");
        for(int seating_row_1=6;seating_row_1 >= row_1.length/2 && seating_row_1 <row_1.length ; seating_row_1 ++){
            if (row_1[seating_row_1] ==0){
                System.out.print("O");
            }
            else{
                System.out.print("X");
            }
        }

        //getting booked seat as X and available seat as O in row 2
        System.out.print("\n");
        System.out.print("  ");
        for(int seating_row_2=0;seating_row_2 < row_2.length/2; seating_row_2 ++){
            if (row_2[seating_row_2] ==0) {
                System.out.print("O");
            }
            else{
                System.out.print("X");
            }
        }
        System.out.print(" ");
        for(int seating_row_2=8;seating_row_2 >= row_2.length/2 && seating_row_2<row_2.length; seating_row_2 ++){
            if (row_2[seating_row_2] ==0) {
                System.out.print("O");
            }
            else{
                System.out.print("X");
            }
        }

        //getting booked seat as X and available seat as O in row 1
        System.out.print("\n");
        for(int seating_row_3=0;seating_row_3 < row_3.length/2; seating_row_3 ++) {
            if (row_3[seating_row_3] == 0) {
                System.out.print("O");
            } else {
                System.out.print("X");
            }
        }
        System.out.print(" ");
        for(int seating_row_3=10;seating_row_3 >= row_3.length/2 && seating_row_3<row_3.length; seating_row_3 ++) {
            if (row_3[seating_row_3] == 0) {
                System.out.print("O");
            } else {
                System.out.print("X");
            }
        }
    }
    //create method to cancel tickets
    public static void cancel_ticket() {
        int seat_row_1 = 0;
        int seat_row_2 = 0;
        int seat_row_3 = 0;
        while (true) {
            System.out.print("\n");
            validation_seat_row();
            for  (int i=0; i <full_details.size(); i++){
                Ticket item = full_details.get(i);
                if (item.getSeat()==seat_num && item.getRow()==row_num){
                    full_details.remove(i);
                }
            }
            //cancel row 1 booking seats
            if (row_num == 1 && row_1[seat_num - 1] == 1) {
                row_1[seat_num - 1] = 0;
                System.out.println("Successfully canceled the booked seat.");
                break;
            //cancel row 2 booking seats
            } else if (row_num == 2 && row_2[seat_num - 1] == 1) {
                row_2[seat_num - 1] = 0;
                System.out.println("Successfully canceled the booked seat.");
                break;
            //cancel row 3 booking seats
            } else if (row_num == 3 && row_3[seat_num - 1] == 1) {
                row_3[seat_num - 1] = 0;
                System.out.println("Successfully canceled the booked seat.");
                break;
            //check all seats are available or not
            } else if (row_1[seat_row_1]==0 && row_2[seat_row_2]==0 && row_3[seat_row_3]==0) {
                System.out.print("All seats are available");
                break;
            //check entering seat is booked or not
            } else {
                System.out.print("The seat is available not occupied ");
            }
        }
    }
    //create a method to show available seats
    public static void show_available(){
        //check row 1 available seats
        System.out.print("Seats available in row 1: ");
        for(int seat_row_1 = 0; seat_row_1 < row_1.length; seat_row_1++){
            if (row_1[seat_row_1]==0 && seat_row_1!=row_1.length-1){
                System.out.print((seat_row_1+1)+","+" ");
            }
            else if(row_1[seat_row_1]==0 && seat_row_1<=row_1.length-1){
                System.out.print((seat_row_1+1)+".");
            }
        }
        //check row 2 available seats
        System.out.print("\n"+"Seats available in row 2: ");
        for(int seat_row_2 = 0; seat_row_2 < row_2.length; seat_row_2++){
            if (row_2[seat_row_2]==0 && seat_row_2!=row_2.length-1){
                System.out.print((seat_row_2+1)+","+" ");
            }
            else if(row_2[seat_row_2]==0 && seat_row_2<=row_2.length-1){
                System.out.print((seat_row_2+1)+".");
            }
        }
        //check row 3 available seats
        System.out.print("\n"+"Seats available in row 3: ");
        for(int seat_row_3 = 0; seat_row_3 < row_3.length; seat_row_3++){
            if (row_3[seat_row_3]==0 && seat_row_3!=row_3.length-1){
                System.out.print((seat_row_3+1)+","+" ");
            }
            else if(row_3[seat_row_3]==0 && seat_row_3<=row_3.length-1){
                System.out.print((seat_row_3+1)+".");
            }
        }

    }
    //create a method to save seating details in file
    public static void save(){
        try {
            FileWriter write_file = new FileWriter("Row_seat.txt");//create a file name as Row_seat.
            write_file.write("row 1: "+ Arrays.toString(row_1)+"\n");
            write_file.write("row 2: "+ Arrays.toString(row_2)+"\n");
            write_file.write("row 3: "+ Arrays.toString(row_3)+"\n");
            write_file.close();
            System.out.println("Arrays saved Successfully.");
        }
        catch(IOException e){
            System.out.println("An error occurred while saving the arrays.");
            e.printStackTrace();
        }

    }
    //create a method to get save file
    public  static void load(){
        System.out.println("-----For avoiding load file without save So auto saving while access to load-----");
        save();
        try{
            File file = new File("Row_seat.txt");
            Scanner file_reader = new Scanner(file);
            while(file_reader.hasNextLine()){
                String text = file_reader.nextLine();
                System.out.println(text);
            }
        }
        catch(IOException e){
            System.out.println("Error while reading file.");
            e.printStackTrace();
        }

    }
    //create a method for show tickets information
    public static void show_tickets_info(){
        double total = 0;// variable assigned to get total price of tickets
        for (Ticket item: full_details){
            System.out.println();
            item.print();
            System.out.println();

            //calculate total price
            total = total+ item.getPrice();
        }
        if (total == 0){
            System.out.println("No seats are booked");
        }
        else {
            System.out.println("Total price of all tickets: " + total + "$"+"\n");
        }

    }
    //create a method for print out ascending order of ticket price with full details
    public static void sort_tickets(){
        int n = full_details.size();
        Ticket t2;

        for(int i=0; i<n;i++){//iterates the list
            for(int j=0; j <n-i-1;j++){//iterates the unsorted parts in list
                if(full_details.get(j).getPrice() >full_details.get(j+1).getPrice()){//compare the price
                    t2 = full_details.get(j);
                    full_details.set(j, full_details.get(j+1));
                    full_details.set(j +1, t2);
                }
            }
        }
        for (Ticket item: full_details){
            System.out.println();
            item.print();
            System.out.println();
        }
        if (full_details.size()==0){
            System.out.println("No tickets are booked");
        }
    }
}






