import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
public class file_ops {

    public static  void createFile() throws IOException
    {
        try {
            Scanner crf = new Scanner(System.in);
            retrive_files obj = new retrive_files();

            System.out.println("Enter the file name you want to create");
            String str1 = crf.nextLine();
            StringBuilder ff = new StringBuilder(str1.toLowerCase());
            ff.append(".txt");
            String str = ff.toString();
            StringBuilder stb = new StringBuilder("E:\\Virtual Key for Your Repositories\\src\\files\\");
            stb.append(str);
            obj.updateAllFiles(str);
            File nfile = new File(stb.toString());
            if (nfile.createNewFile()) {
                System.out.println("*************************************");
                System.out.println("FILE CREATION  :-> SUCCESSFUL");
                System.out.println("*************************************");
            }
            System.out.println("------------------------------");
            System.out.println("press 1 for writing");
            System.out.println("Else press 0 ");
            int b = crf.nextInt();
            System.out.println("------------------------------");
            if (b == 1) {
                WriteFile(stb.toString());
            }
        }
        catch (Exception e)
        {
            System.out.println(e);
            System.out.println("*************************************");
            System.out.println("FILE CREATION  :-> FAILED");
            System.out.println("*************************************");
        }
    }

    public static void ReadFile(String filename)
    {
        try{
            FileInputStream fin=new FileInputStream(filename);
            int i=0;
            while((i=fin.read())!=-1){
                System.out.print((char)i);
            }
            fin.close();
            System.out.println(" ");
            System.out.println("*************************************");
            System.out.println("READING  :-> SUCCESSFUL");
            System.out.println("*************************************");
        }catch(Exception e){
            System.out.println(e);
            System.out.println("*************************************");
            System.out.println("READING  :-> FAILED");
            System.out.println("*************************************");
        }
    }

    public static void WriteFile(String filename)
    {
        try{
            Scanner wf = new Scanner(System.in);
            System.out.println("------------------------------");
            System.out.println("***** what you want to write *****");
            String Str = wf.nextLine();
            FileOutputStream fout = new FileOutputStream(filename);
            byte b[] = Str.getBytes();
            fout.write(b);
            System.out.println("------------------------------");
            fout.close();
            System.out.println("*************************************");
            System.out.println("WRITING  :-> SUCCESSFUL");
            System.out.println("*************************************");
        }
        catch(Exception e)
        {
            System.out.println(e);
            System.out.println("*************************************");
            System.out.println("WRITING  :-> FAILED");
            System.out.println("*************************************");
        }
    }


    public static void appendFile(String filename) throws IOException {
        try
        {
        String app ;
        Scanner ap = new Scanner(System.in);
        System.out.println("------ Enter what you want to append -----");
        System.out.println("------------------------------");
        app = ap.nextLine();
        BufferedWriter b = new BufferedWriter(new FileWriter(filename , true));
        b.write("\n");
        b.write(app);
        System.out.println("------------------------------");
        b.close();
        System.out.println("*************************************");
        System.out.println("WRITING  :-> SUCCESSFUL");
        System.out.println("*************************************");
        }
        catch (Exception e)
        {
            System.out.println(e);
            System.out.println("*************************************");
            System.out.println("WRITING  :-> FAILED");
            System.out.println("*************************************");
        }

    }

    public static void DeleteFile(String filename) throws IOException {
        Path path = Paths.get(filename);
        try {
            if (Files.deleteIfExists(path)) {
                System.out.println("*************************************");
                System.out.println("DELETION  :-> SUCCESSFUL");
                System.out.println("*************************************");
            } else {
                System.out.println("*************************************");
                System.out.println("DELETION  :-> FAILED");
                System.out.println("*************************************");
            }
        }
        catch (Exception e)
        {
            System.out.println(e);
        }

    }


    public static void main() {
        try {
            Scanner sc = new Scanner(System.in);
            int num = 1;
            retrive_files rf = new retrive_files();
            while(num < 3)
            {
                System.out.println("*************************************");
                System.out.println("\t PRESS");
                System.out.println("1 :-> To Create File");
                System.out.println("2 :-> To Perform operation");
                System.out.println("3 :-> BACK ");
                System.out.print("Enter your choice : ");
                num  = sc.nextInt();
                sc.nextLine();
                System.out.println("*************************************");
                switch (num)
                {
                    case 1 -> createFile();
                    case 2 -> {
                        System.out.println("*************************************");
                        System.out.println("\t PRESS");
                        System.out.println("1. To Read File");
                        System.out.println("2. To Delete File");
                        System.out.println("3. To Append File");
                        System.out.println("4. BACK ");
                        System.out.print("Enter your choice : ");
                        int op_num = sc.nextInt();
                        sc.nextLine();
                        System.out.println("*************************************");

                        if(op_num >= 4)
                        {
                            break;
                        }

                        System.out.println("Search the file on which you want to do operation");
                        String filenameStr1 = sc.nextLine();
                        System.out.println("------------------------------");
                        StringBuilder ff = new StringBuilder(filenameStr1.toLowerCase());
                        ff.append(".txt");
                        String filenameStr = ff.toString();
                        StringBuilder filename = new StringBuilder("E:\\Virtual Key for Your Repositories\\src\\files\\");
                        filename.append(filenameStr.toLowerCase());
                        if(rf.search(filenameStr)) {

                            switch (op_num)
                            {
                                case 1 -> ReadFile(filename.toString());
                                case 2 -> {
                                    DeleteFile(filename.toString());
                                    rf.RemoveFileFromAllFiles(filenameStr);
                                }
                                case 3 -> appendFile(filename.toString());
                                default -> System.out.println(" MOVING BACK ");
                            }
                        }
                        else{
                            System.out.println("file doesn't exist or wrong file name");
                            continue;
                        }
                        }
                    default -> System.out.println(" MOVING BACK ");
                    }
                }
        } catch (Exception e) {
            System.out.println("Error: "+e);
        }
    }
}
