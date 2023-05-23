import java.util.*;
public class Sections{
  static Scanner gIN = new Scanner(System.in); //Global Scanner
  static double[] gGrades = new double[100]; //Global Array
  static int gClassSize; //Global Size of Array
  public static void main(String[] args){
    int option;
    System.out.print("Please, enter the class size : ");
    gClassSize = gIN.nextInt(); //Asks for class size
    System.out.println("MAIN MENU"); //Prints Menu
    System.out.println("0 - Exit, 1 - List, 2 - Report, 3 - Add/Modify Grade, 4 - Swap Grades");
    System.out.print("Select an option : ");
    option = gIN.nextInt(); //Asks for option number
    while (option < 0 || option > 4){ //Checks if 1st number entered is within range
      System.out.println("Value out of range, please, try again");
      System.out.println("");
      System.out.println("MAIN MENU");
      System.out.println("0 - Exit, 1 - List, 2 - Report, 3 - Add/Modify Grade, 4 - Swap Grades");
      System.out.print("Select an option : ");
      option = gIN.nextInt();
    }
    while (option != 0){ //Runs code until option equals 0
      if (option == 1){ //Runs code if option equals 1
        listGrades(); //Calls listGrades Method
        System.out.println("");
        System.out.println("MAIN MENU"); //Prints menu to set up next option
        System.out.println("0 - Exit, 1 - List, 2 - Report, 3 - Add/Modify Grade, 4 - Swap Grades");
        System.out.print("Select an option : ");
        option = gIN.nextInt(); //Gets next input for option
      }
      if (option == 2){ //Runs code if option equals 2
        report(); //Calls report method
        System.out.println("");
        System.out.println("MAIN MENU");
        System.out.println("0 - Exit, 1 - List, 2 - Report, 3 - Add/Modify Grade, 4 - Swap Grades");
        System.out.print("Select an option : ");
        option = gIN.nextInt();
      }
      if (option == 3){ //Runs code if option equals 3
        addModifyGrade(); //Calls addModifyGrade method
        System.out.println("");
        System.out.println("MAIN MENU");
        System.out.println("0 - Exit, 1 - List, 2 - Report, 3 - Add/Modify Grade, 4 - Swap Grades");
        System.out.print("Select an option : ");
        option = gIN.nextInt();
      }
      if (option == 4){ //Runs code if option equals 4
        swapGrades(); //Calls swapGrades method
        System.out.println("");
        System.out.println("MAIN MENU");
        System.out.println("0 - Exit, 1 - List, 2 - Report, 3 - Add/Modify Grade, 4 - Swap Grades");
        System.out.print("Select an option : ");
        option = gIN.nextInt();
      }
      if (option == 0){ //Prints conclusion sentence when 0 is the input
        System.out.println("Thank you for using the grades program! Bye!");
      }
      if (option > 4 || option < 0){ //Keeps loop going if option is ever not in range while in this loop
        System.out.println("Value out of range, please, try again");
        System.out.println("");
        System.out.println("MAIN MENU");
        System.out.println("0 - Exit, 1 - List, 2 - Report, 3 - Add/Modify Grade, 4 - Swap Grades");
        System.out.print("Select an option : ");
        option = gIN.nextInt();
    }
  }
  }
  public static void listGrades(){ //Prints the list of grades
  int i;
  System.out.println("LIST OF GRADES");
  for (i=0;i<gClassSize;i++){ //Loop that will print array values
    System.out.println("Grade[" + i + "] : " + gGrades[i]);
  }
  }
  public static int getGradesLetter(char letter){ //Method that determines Letter Grades and how much of each
    int i;
    int count = 0; //Counts amount of each letter
    char[] letters = new char[gClassSize]; //array that holds the Letter grades
    for (i = 0; i< gClassSize; i++){ //Loop that determines the letter grade for each grade
      if (gGrades[i] >= 90.0 && gGrades[i] <= 100.0){
        letters[i] = 'A';
      }
       if (gGrades[i] >= 80.0 && gGrades[i] < 90.0){
        letters[i] = 'B';
    }
        if (gGrades[i] >= 70.0 && gGrades[i] < 80.0){
        letters[i] = 'C';
        }
         if (gGrades[i] >= 60.0 && gGrades[i] < 70.0){
        letters[i] = 'D';
         }
          if (gGrades[i] < 60.0){
        letters[i] = 'F';
          }
    }
    for (i=0; i< gClassSize; i++){ //Loop that updates count
      if (letters[i] == letter){
        count++;
      }
    }
    return count;
  }
  public static void report(){ //Prints the letter grade report
    System.out.println("GRADES REPORT");
    System.out.println("F : " + getGradesLetter('F'));
    System.out.println("D : " + getGradesLetter('D'));
    System.out.println("C : " + getGradesLetter('C'));
    System.out.println("B : " + getGradesLetter('B'));
    System.out.println("A : " + getGradesLetter('A'));
  }
  public static void addModifyGrade(){ //Method that adds and modifys grades
    int index; // Index input
    double grade; // Gets grade 
    System.out.print("Enter the index (0 to " + (gClassSize -1) + ") : ");
    index = gIN.nextInt();
    while ( index < 0 || index > (gClassSize -1)){ //Checks to make sure input is in range
      System.out.println("Value out of range, please, try again");
      System.out.print("Enter the index (0 to " + (gClassSize -1) + ") : ");
    index = gIN.nextInt();
    }
    System.out.println("The current value of the grade in index " + index + " is : " + gGrades[index]);
    System.out.print("Enter the grade you want to assign (0.00 - 100.00) : ");
    grade = gIN.nextDouble();
    while (grade < 0.00 || grade > 100.00){
      System.out.println("Value out of range, please, try again");
      System.out.println("The current value of the grade in index " + index + " is : " + gGrades[index]);
      System.out.print("Enter the grade you want to assign (0.00 - 100.00) : ");
      grade = gIN.nextDouble();
    }
    gGrades[index] = grade; //Assigns double grade into array
}
  public static void swapGrades(){ //Swaps grades
    int indexFrom; //First index
    int indexTo; //Second index
    System.out.print("Enter the index from (0 to " + (gClassSize -1) + ") : ");
    indexFrom = gIN.nextInt();
    while ( indexFrom < 0 || indexFrom > (gClassSize -1)){ //Makes sure indexes are in range
      System.out.println("Value out of range, please, try again");
      System.out.print("Enter the index from (0 to " + (gClassSize -1) + ") : ");
    indexFrom = gIN.nextInt();
    }
    System.out.print("Enter the index to (0 to " + (gClassSize -1) + ") that is not " + indexFrom + " : ");
    indexTo = gIN.nextInt();
    while ( indexTo < 0 || indexTo > (gClassSize -1)){
      System.out.println("Value out of range, please, try again");
      System.out.print("Enter the index to (0 to " + (gClassSize -1) + ") that is not " + indexFrom + "  : ");
    indexTo = gIN.nextInt();
    }
    while ( indexTo == indexFrom){ //Makes sure both indexes don't match
      System.out.print("Enter the index to (0 to " + (gClassSize -1) + ") that is not " + indexFrom + "  : ");
      indexTo = gIN.nextInt();
    }
    swapValues(indexFrom, indexTo); //Calls method swapValues
  }
  public static void swapValues(int f, int t){ //Swaps value with index inputs
    double swapper; //Filler that holds grade so it isn't erased
    swapper = gGrades[f]; 
    gGrades[f] = gGrades[t];
    gGrades[t] = swapper;
}
}