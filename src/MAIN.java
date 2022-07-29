import java.util.*;
import java.io.*;
import java.nio.*;
public class MAIN {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("\n\n");
        System.out.println("Welcome to Virtual Repository");
        System.out.println("\t\t\t - Developed By 'Rahul Kumar'");
        System.out.println();
        int num = 1 ;
        while(num<3)
        {
            System.out.println("*************************************");
            System.out.println("\t PRESS");
            System.out.println("1. Retrieving the file name");
            System.out.println("2. Business level operations");
            System.out.println("3. Option to close Application");
            System.out.println("*************************************");
            System.out.print("Enter your Choice : ");
            num = sc.nextInt();
            switch (num)
            {
                case 1 -> {
                    retrive_files rf = new retrive_files();
                    rf.main();
                }
                case 2 -> {
                    file_ops fo = new file_ops();
                    fo.main();
                }
                default -> {
                    System.out.println("\n\n");
                    System.out.println("---------------------------------------------------------------");
                    System.out.println("\t\t\t ------------------------------");
                    System.out.println("\t\t\t      CLOSING APPLICATION");
                    System.out.println("\t\t\t ------------------------------");
                    System.out.println("---------------------------------------------------------------");
                }
            }

        }
    }
}
