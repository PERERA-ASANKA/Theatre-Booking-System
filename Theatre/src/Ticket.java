public class Ticket {
    private int row;
    private int seat;
    private double price;
    public Person person;
    public Ticket(int row, int seat, double price,Person person) {
        this.row = row;
        this.seat = seat;
        this.price = price;
        this.person =person;
    }
    public int getRow(){
        return row;
    }
    public int getSeat(){
        return seat;
    }
    public double getPrice(){
        return price;
    }
    public void print(){
        System.out.println("----------Ticket details---------");
        System.out.println("Row: "+getRow());
        System.out.println("Seat: "+getSeat());
        System.out.println("Price: "+getPrice()+"$");
        System.out.println("Name: "+this.person.getName());
        System.out.println("Surname: "+this.person.getSurname());
        System.out.println("Email: "+this.person.getEmail());
        System.out.println();
    }
}
