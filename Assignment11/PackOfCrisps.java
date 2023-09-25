/**The PackOfCrisps class represents a packet of crisps.
 * 
 *@author Stefania-Cristina Gheorghe
 *@version 2022.12.09 
 */
public class PackOfCrisps
{
    /**fields
     */
    private boolean open;
    private int numOfCrisps;
    private String flavour;
    
    /**initialising fields
     */
    public PackOfCrisps(String flavour)
    {
        this.flavour = flavour;
        this.numOfCrisps = 10; //set default count of crisps
        this.open = false; //the crisp packet is not open yet by default
    }
    
    
    /**method to open the packet 
     * If the packet was closed, it will open the packet and let the user
     * know that the packet it's been opened. If the packet was already 
     * open, it will also output appropriate messag efor the user. 
     */
    public void open(){
        if (!open){
            open = true;
            System.out.println("Now opened");
        }
        else{
            System.out.println("Already open");
        }
    }
    
    /**method that states if the packet is empty
     * @return In the case that the packet is empty, it will return that 
     * the number of crisps in the pack is 0.
     */
    public boolean isEmpty(){
        return numOfCrisps == 0;
        
    }
    
    /**method that states if packet is closed
     * @return A boolean that will return true to whether the packet is 
     * closed as long as it has not been opened yet.
     */
    public boolean isClosed(){
        return !open;
    }
    
    /**method that outputs the flavour 
     * @return A string that specifies the flavour of the chosen pack.
     */
        public String getFlavour(){
        return flavour;
    }

    /**method that allows eating 1 crisp at a time 
     * If the pack of crisps has been opened and the number of crisps
     * is greater than 0, it will allow user to take out one crisp. If the 
     * number of crisps is 0, it will print appropriate message. 
     * If the pack is closed it will ask user to open the pack. 
     */
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