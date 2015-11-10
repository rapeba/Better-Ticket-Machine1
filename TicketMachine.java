/**
 * TicketMachine models a ticket machine that issues
 * flat-fare tickets.
 * The price of a ticket is specified via the constructor.
 * Instances will check to ensure that a user only enters
 * sensible amounts of money, and will only print a ticket
 * if enough money has been input.
 * 
 * @author David J. Barnes and Michael Kölling
 * @version 2011.07.31
 */
public class TicketMachine
{
    // The price of a ticket from this machine.
    private int price;
    // The amount of money entered by a customer so far.
    private int balance;
    // The total amount of money collected by this machine.
    private int total;
    //Se aplica descuento o no (true o false).
    private boolean descontar;
    //Se pide el porcentaje de descuento.
    private int porCiento;

    /**
     * Crea una m�quina de tickets a la que ponemos el precio del ticket
     * y si hace descuentos en alg�n ticket.
     */
    public TicketMachine (int cost, boolean discount, int porcent)
    {
        price = cost;
        balance = 0;
        total = 0;
        descontar = discount;
        porCiento = porcent;
        
    }
     
    /**
     * @Return The price of a ticket.
     */
    public int getPrice()
    {
        return price;
    }

    /**
     * Return The amount of money already inserted for the
     * next ticket.
     */
    public int getBalance()
    {
        return balance;
    }

    /**
     * Receive an amount of money from a customer.
     * Check that the amount is sensible.
     */
    public void insertMoney(int amount)
    {
        if(amount > 0) {
            balance = balance + amount;
        }
        else {
            System.out.println("Use a positive amount rather than: " +
                               amount);
        }
    }

    /**
     * Print a ticket if enough money has been inserted, and
     * reduce the current balance by the ticket price. Print
     * an error message if more money is required.
     */
    public void printTicket()
    {
        if(balance >= price) {
            // Simulate the printing of a ticket.
            System.out.println("##################");
            System.out.println("# The BlueJ Line");
            System.out.println("# Ticket");
            System.out.println("# " + price + " cents.");
            System.out.println("##################");
            System.out.println();

            // Update the total collected with the price.
            total = total + price;
            // Reduce the balance by the prince.
            balance = balance - price;
        }
        else{
            int amountLeftToPay = price - balance;
            System.out.println("You must insert at least: " +
                               (amountLeftToPay) + " more cents.");
                    
        }
    }

    /**
     * Return the money in the balance.
     * The balance is cleared.
     */
    public int refundBalance()
    {
        int amountToRefund;
        amountToRefund = balance;
        balance = 0;
        return amountToRefund;
    }
    
    /**
     * M�todo para vaciar la m�quina.
     */
    public int emptyMachine()
    {
        int recaudacion = -1;
        if (balance == 0){
            recaudacion = total;
            total = 0;
        }
      
            return recaudacion;
    }
    
    public void printTicketWithDiscount()
    {
        int rebajado = price - (price*porCiento / 100);
        if (descontar == true){
            //Imprime el ticket.
            System.out.println("##################");
            System.out.println("# The blueJ Line");
            System.out.println("# Ticket");
            System.out.println("#Con descuento");
            System.out.println("# " + rebajado + " cents.");
            System.out.println("##################");
            System.out.println();
        }
    
        
        else
           {
            System.out.println("#########################");
            System.out.println("## No hay descuento en ##");
            System.out.println("##     el tickect      ##");
            System.out.println("#########################");
        }
    }
}
    

 
