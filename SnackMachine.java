//Stefania-Cristina Gheorghe
import java.util.ArrayList;

public class SnackMachine
{
    //fields 
    private ArrayList<PackOfCrisps> packets;//the packets in the machine
    private int capacity;//max of packets in the machine 
    private int cost;//price of packet 
    private int payment;//number of pennies inserted 
    private ArrayList<Penny> pennies;//stores the pennies inserted/cash machine
    
    //initialising fields
    public SnackMachine(int maxCapacity, int packCost){
        this.capacity = maxCapacity;//maximum number of packs in the machine 
        this.cost = packCost;//cost per packet
        this.payment = 0;//setting the default pennies to 0
        this.packets = new ArrayList<PackOfCrisps>();//creating array to sort the packets of crisps
        this.pennies = new ArrayList<Penny>();//creating array to store the pennies inserted/cash machine
    }
    
    //method that outputs the cost of 1 pack
    public int getCost(){
        return cost;
    }
    
    //method to add a pack in the machine
    public void addPack(PackOfCrisps pack){
        if (packets.size() < capacity){
            packets.add(pack);
        }
        else {
            System.out.println("Machine is full.");
        }
    }
    
    //method that returns number of packs with specific flavour 
    public int countPacks(String flavour){
        int flavourCount = 0;
        for (PackOfCrisps currentPack : packets){
            if (currentPack.getFlavour() == flavour){
                flavourCount = flavourCount + 1;
            }
        }
        return flavourCount;
    }
    
    //method to insert 1 penny at a time
    public void insertMoney(Penny penny){
        pennies.add(penny);
        payment = payment + 1;
    }
    
    //method to buy a pack of crisps if enough pennies inserted
    public PackOfCrisps buyPack(String flavour){
        if (payment >= cost){
            for (int x = 0; x < packets.size(); x++){
                PackOfCrisps currentPack = packets.get(x);
                if (currentPack.getFlavour()==flavour){
                    packets.remove(x);
                    payment = 0;
                    return currentPack;
                }
            }
            System.out.println("No more " + flavour + " crisps./n Please choose another flavour.");
            return null;
        }
        else {
            System.out.println("Insufficient amount. Please insert more pennies.");
            return null;
        }
    }
    
    //method to print the packets left and amount of pennies in the machine 
    public void describe(){
        System.out.println("There are " + packets.size() + " packets of crisps left. /n The machine has taken " + payment + " pennies in total");
    }
}
