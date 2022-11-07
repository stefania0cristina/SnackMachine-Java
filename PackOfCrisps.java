//Stefania-Cristina Gheorghe
public class PackOfCrisps
{
    // fields
    private boolean open;
    private int numOfCrisps;
    private String flavour;
    
    //initialising fields 
    public PackOfCrisps(String flavour)
    {
        this.flavour = flavour;
        this.numOfCrisps = 10; //set default count of crisps
        this.open = false; //the crisp packet is not open yet by default
    }
    
    
    //method to open the packet 
    public void open(){
        if (!open){
            open = true;
            System.out.println("Now opened");
        }
        else{
            System.out.println("Already open");
        }
    }
    
    //method finding out if pack is empty 
    public boolean isEmpty(){
        return numOfCrisps == 0;
        
    }
    
    //method finding out if pack is closed 
    public boolean isClosed(){
        return !open;
    }
    
    //method that outputs the flavour 
        public String getFlavour(){
        return flavour;
    }

    //method that allows eating 1 crisp at a time 
    public void eatCrisp(){
        if (open){
            if (numOfCrisps > 0){
                numOfCrisps = numOfCrisps - 1;
            }
            
            else{
                System.out.println("Packet is empty. Purchase another one and try again");
            }
        }
        else{
            System.out.println("Packet is closed, please open the packet and try again");
        }
    }
    
}