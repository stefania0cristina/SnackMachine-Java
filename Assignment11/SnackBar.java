import java.util.Random;
import java.util.ArrayList;
/**The SnackBar class represents a bar for students where multiple 
 * Snack Machines can be used.
 *
 * @author Stefania-Cristina Gheorghe 
 * @version 2022.12.09
 */
public class SnackBar
{
    /**Fields 
     */
    //generate random numbers 
    private Random random;
    //array of strings stores flavours 
    private String[] allFlavours;
    //machine for students at the snack bar
    private SnackMachine machine;
    //list of students at the snack bar
    private ArrayList<Student> students;
    
    /**Constructor method
     *@param NumOfStudents represents the students in the snack bar
     *@param PacketCount represents the packets in the snack macine 
     *@param PacketCost represents the price of a pack
    */
    public SnackBar(int numOfStudents, int packetCount, int packetCost){
        random = new Random();
        allFlavours = new String[]{"Beef", "Salted", "Sweet Chilli", "Cheddar cheese"};
        machine = new SnackMachine(packetCount, packetCost);
        //adds packets to the machine
        for (int x = 0; packetCount > x; x++){
            machine.addPack(new PackOfCrisps(randomFlavour()));
        }
        students = new ArrayList<Student>();
        //adds students to the array list 
        for (int x = 0; numOfStudents > x; x++){
            students.add(new Student(randomFlavour(), machine));
        }
    }
    
    /**method uses the random object to index a random crisps flavour 
     * @return A string that returns the random flavour  
     */
    private String randomFlavour(){
        return allFlavours[random.nextInt(allFlavours.length)];
    }
    
    /**method prints summary of students at the snack bar and the stock in 
     * the machine
     */
    public void describe(){
        System.out.println("There are " + students.size() +"students at the SnackBar./n The SnackMachine has ");
        for (int x = 0; allFlavours.length > x; x++){
            System.out.println(machine.countPacks(allFlavours[x]) + "packets of" + allFlavours[x]);
        }
    }

    /**method that carries out instructions a given amount of times 
     * @param nSteps the number of steps to run
     */
    public void runSnackBar(int nSteps){
        for (int x = 0; nSteps > x; x++){
            System.out.println("Time Step " + (x++));
            describe();
            students.get(random.nextInt(students.size())).snackTime();
            
        }
    }
    
    /**param Args which (I am hoping) allows the project to run without bluej
     * it will first try to parse the arguments and if it will be invalid, 
     * it will use the defaults 
     */
    public static void main(String[] args){
        if (args.length == 2){
            try{
                int students = Integer.parseInt(args[0]);
                int iterations =Integer.parseInt(args[1]);
                SnackBar bar = new SnackBar(students,10,10);
                bar.runSnackBar(iterations);
            }
            catch ( Exception e){
                System.out.println("Invalid arguments. Using defaults.");
                SnackBar bar = new SnackBar(10,10,10);
                bar.runSnackBar(30);
            }
        }
        else {
            SnackBar bar = new SnackBar(10,10,10);
            bar.runSnackBar(30);
        }
    }
}