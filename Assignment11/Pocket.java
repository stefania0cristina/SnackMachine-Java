import java.util.HashSet;
import java.util.Iterator;
/** The Pocket class is used to store each student's pennies.
 *
 * @author Stefania-Cristina Gheorghe
 * @version 2022.12.09
 */
public class Pocket
{
    /**HashSet Penny field to store the pennies in the pocket.
     */
    private HashSet<Penny> pennies;
    
    /**method adds pennies to the HashSet
     * @param pocketSize represents the amount of pennies in the pocket. 
     */
    public Pocket(int pocketSize){
        pennies = new HashSet<Penny>(pocketSize);
        for (int x = 0; pocketSize > x; x++){
            pennies.add(new Penny());
        }
    }
    
    /**method to count the pennies in a pocket
     * @return An int that represents the amount of pennies in the pocket.
     */
    public int pennyCount(){
        return pennies.size();
    }
    
    /** method to remove one penny
     * @return It returns the removed penny.
     * @return In the case that there are no more pennies left in the 
     * pocket it will return null. 
     */
    public Penny removePenny(){
        Iterator<Penny> itr = pennies.iterator();
        
        if(itr.hasNext()){
            Penny tmp = itr.next();
            pennies.remove(tmp);
            return tmp;
        }
        else {
            return null;
        }
    }
}
