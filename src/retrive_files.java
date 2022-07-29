import java.io.*;
import java.util.*;
public class retrive_files {

    public static void RemoveFileFromAllFiles(String filename)
    {
        File fileToBeModified= new  File("E:\\Virtual Key for Your Repositories\\src\\allFiles.txt");
        String fileData="";
        BufferedReader reader=  null;
        FileWriter writer=null;
        String olddata = filename;
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
        BufferedWriter b = new BufferedWriter(new FileWriter("E:\\Virtual Key for Your Repositories\\src\\allFiles.txt" , true));
        b.write("\n");
        b.write(file);
        b.close();
    }

    public static boolean search(String file) throws FileNotFoundException {
        FileReader r = new FileReader("E:\\Virtual Key for Your Repositories\\src\\allFiles.txt");
        BufferedReader buf = new BufferedReader(r);
        ArrayList<String> list = new ArrayList<>();

        try {
            String line = buf.readLine();
            while (line != null) {
                list.add(line);
                line = buf.readLine();
            }
        }catch(Exception e)
        {
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
        int n = Collections.binarySearch(list ,file);
        if(n >= 0 && n< list.size()) return true;
        return false;
    }
    public static void main() throws IOException {
            FileReader r = new FileReader("E:\\Virtual Key for Your Repositories\\src\\allFiles.txt");
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
            while (temp < 4) {
                System.out.println("********************************");
                System.out.println("\t PRESS");
                    System.out.println("1. LIST OF FILES");
                System.out.println("2. SORT THE LIST IN ASCENDING ORDER");
                System.out.println("3. SEARCH A FILE");
                System.out.println("4. BACK ");
                System.out.print("Enter your choice : ");
                temp = sc.nextInt();
                sc.nextLine();
                System.out.println("********************************");
                switch (temp) {
                    case 1 -> System.out.println(list);
                    case 2 -> {
                        Collections.sort(list);
                        System.out.println(list);
                    }
                    case 3 -> {
                        System.out.println("Enter the name of file you want to find (pls mention extension also)");
                        String str = sc.nextLine();
                        System.out.println("The file is at position : " + Collections.binarySearch(list, str));
                        if(search(str)) {
                            System.out.println("------------------------------");
                            System.out.println("To Read file Press 1");
                            System.out.println("Else press 0");
                            System.out.print("Enter your choice : ");
                            int fnum = sc.nextInt();
                            sc.nextLine();
                            System.out.println("------------------------------");
                            StringBuilder stb = new StringBuilder("E:\\Virtual Key for Your Repositories\\src\\");
                            stb.append(str);
                            if (fnum == 1) {
                                fo.ReadFile(stb.toString());
                            }
                        }
                        else{
                            System.out.println("file doesn't exit");
                        }
                    }
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
