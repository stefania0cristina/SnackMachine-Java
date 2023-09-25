/** The Student class represents a student.
 *
 * @author Stefania-Cristina Gheorghe
 * @version 2022.12.09
 */
public class Student
{
    /**Fields
     */
    //static int variable will increment by 1
    private static int STUDENT_ID = 0;
    //favourite flavour of student 
    private String FavouriteFlavour;
    //chosen snack machine to buy packets of crisps
    private SnackMachine chosenSM;
    //student's identity number 
    private String identityNumber;
    //student pocket of coins
    private Pocket coinsPocket;
    //the packet of crisps bought by student
    private PackOfCrisps boughtPack;
    
    /**method to add new student 
     * @param Flavour represents the student's favourite flavour
     * @param Machine represents the machine that the student might use
     * to buy crisps of that flavour
     * StudentID increments by 1 and updates teh field.A pocket will be
     * created containing 20 pennies and the packets bought will be set
     * set to null. 
     */
    public Student(String flavour,SnackMachine machine){
        FavouriteFlavour = flavour;
        chosenSM = machine;
        identityNumber = "student" + ++STUDENT_ID;
        coinsPocket = new Pocket(20);
        boughtPack = null;
    }
    
    /**Buying a pack of crips from the machine
     * If a student has enough pennies(if not print appropriate message)
     * and their favourite flavour is in stock(if not print appropriate
     * message), insert coins=cost of pack from student's pocket and update 
     * the bought packet from null to the packet bought. 
     */
    private void buyCrisps(){ 
        if (coinsPocket.pennyCount() >= chosenSM.getCost()){
            if (chosenSM.countPacks(FavouriteFlavour) > 0){
                for (int x = 0; chosenSM.getCost() > x; x++){
                    chosenSM.insertMoney(coinsPocket.removePenny());
                }
                boughtPack = chosenSM.buyPack(FavouriteFlavour);
            }
            else {
                System.out.println("Sorry, there are no " +FavouriteFlavour + "crisps left.");
            }
        }
        else {
            System.out.println("Sorry, you do not have enough coins for that.");
        }
    }
    
    /**Eating crisps from a packet 
     *Checking if student has bought the packet(if not print appropriate
     *message)and if pack has been opened (if not print appropriate 
     *message). Check if pack is not empty(if not print appropriate message)
     *Assuming that the student has an opened packet that is not empty, 
     *it will allow the student to eat out of that pack..SNACK TIME!
     */
    public void snackTime(){
        //checking if the student has a packet 
        if (boughtPack != null){
            //if pack has been opened 
            if (!boughtPack.isClosed()){
                //if pack is not empty
                if (!boughtPack.isEmpty()){
                    System.out.println(identityNumber + "is eating a favourite " + boughtPack.getFlavour() + " crisp.");
                    boughtPack.eatCrisp();
                }
                else{
                    System.out.println(identityNumber + "is throwing away their empty packet");
                    boughtPack = null;
                }
            }
            else {
                System.out.println(identityNumber + "is opening their new " + boughtPack.getFlavour() + " crisps");
                boughtPack.open();
            }
        }
        else{
            System.out.println(identityNumber + "is buying crisps.");
            buyCrisps();
        }
    }
}
