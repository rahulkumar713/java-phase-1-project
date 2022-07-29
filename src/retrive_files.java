import java.io.*;
import java.util.*;
public class retrive_files {

    public static void RemoveFileFromAllFiles(String filename)
    {

        File fileToBeModified= new  File("E:\\Virtual Key for Your Repositories\\src\\files\\allfiles.txt");
        String fileData="";
        BufferedReader reader=  null;
        FileWriter writer=null;
        String olddata = filename.toLowerCase();
        String newdata = "";

        try {
            reader= new BufferedReader(new FileReader(fileToBeModified));
            String line= reader.readLine();

            while(line!=null) {
                fileData= fileData+line+System.lineSeparator();
                line=reader.readLine();
            }


            String newFiledata= fileData.replaceAll(olddata, newdata);

            writer = new FileWriter(fileToBeModified);
            writer.write(newFiledata);
    }catch (Exception e)
        {
            System.out.println(e);
        }
        finally {

            try {
                reader.close();
                writer.close();

            } catch (IOException e2) {
            }

        }
    }
    public static void updateAllFiles(String file) throws IOException {
        BufferedWriter b = new BufferedWriter(new FileWriter("E:\\Virtual Key for Your Repositories\\src\\files\\allfiles.txt" , true));
        b.write("\n");
        b.write(file.toLowerCase());
        b.close();
    }

    public static boolean search(String file) throws FileNotFoundException {
        FileReader r = new FileReader("E:\\Virtual Key for Your Repositories\\src\\files\\allfiles.txt");
        BufferedReader buf = new BufferedReader(r);
        ArrayList<String> list = new ArrayList<>();
        try {
            String line = buf.readLine();
            while (line != null) {
                list.add(line);
                line = buf.readLine();
            }
            buf.close();
            r.close();
        }catch (Exception e)
        {
            System.out.println(e);
        }
        for (String it : list) {
            if (it.equalsIgnoreCase(file)) {
                return true;
            }
        }
        return false;
    }
    public static void main() throws IOException {
            FileReader r = new FileReader("E:\\Virtual Key for Your Repositories\\src\\files\\allfiles.txt");
            BufferedReader buf = new BufferedReader(r);
            ArrayList<String> list = new ArrayList<>();
            try
            {
            String line = buf.readLine();
            while (line != null) {
                list.add(line);
                line = buf.readLine();
            }

            Scanner sc = new Scanner(System.in);
            file_ops fo = new file_ops();
            int temp = 1;
            while (temp < 3) {
                System.out.println("********************************");
                System.out.println("\t PRESS");
                System.out.println("1. GET THE SORTED LIST");
                System.out.println("2. SEARCH A FILE");
                System.out.println("3. BACK ");
                System.out.print("Enter your choice : ");
                temp = sc.nextInt();
                sc.nextLine();
                System.out.println("********************************");
                switch (temp) {
                    case 1 -> {
                        Collections.sort(list);
                        System.out.println("\t SORTED LIST");
                        System.out.println("----------------------------");
                        for (String it : list)
                        {
                            System.out.println(it);
                        }
                    }
                    case 2 -> {
                        System.out.println("Enter the name of file you want to find");
                        String str1 = sc.nextLine();
                        StringBuilder ff = new StringBuilder(str1.toLowerCase());
                        ff.append(".txt");
                        String str = ff.toString();
                        if(search(str.toLowerCase())) {
                            System.out.println("File is present ");
                            System.out.println("------------------------------");
                            System.out.println("To Read file Press 1");
                            System.out.println("Else press 0");
                            System.out.print("Enter your choice : ");
                            int fnum = sc.nextInt();
                            sc.nextLine();
                            System.out.println("------------------------------");
                            StringBuilder stb = new StringBuilder("E:\\Virtual Key for Your Repositories\\src\\files\\");
                            stb.append(str);
                            if (fnum == 1) {
                                fo.ReadFile(stb.toString());
                            }
                        }
                        else{
                            System.out.println("file doesn't exit");
                        }
                    }
                    default -> System.out.println(" MOVING BACK ");
                }
            }
        }
    catch(Exception e){
        System.out.println(e);
    }
        finally {
            try {
                buf.close();
                r.close();
            }
            catch (Exception e)
            {
                System.out.println(e);
            }
        }
}
}
