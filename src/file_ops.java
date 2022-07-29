import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
public class file_ops {

    public static  void createFile() throws IOException
    {
        Scanner crf = new Scanner(System.in);
        retrive_files obj = new retrive_files();

        System.out.println("Enter the file name you want to create (with extension)");
        String str = crf.nextLine();
        StringBuilder stb = new StringBuilder("E:\\Virtual Key for Your Repositories\\src\\");
        stb.append(str);
        obj.updateAllFiles(str);
        File nfile = new File(stb.toString());
        if(nfile.createNewFile())
        {
            System.out.println("***** file is created *****");
        }
        System.out.println("press 1 for writing");
        System.out.println("Else press 0 ");
        int b =crf.nextInt();
        if(b == 1)
        {
            WriteFile(stb.toString());
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
        }catch(Exception e){
            System.out.println(e);
        }
    }

    public static void WriteFile(String filename)
    {
        try{
            Scanner wf = new Scanner(System.in);
            System.out.println("### what you want to write ###");
            String Str = wf.nextLine();
            FileOutputStream fout = new FileOutputStream(filename);
            byte b[] = Str.getBytes();
            fout.write(b);
            fout.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }

    public static void ModifyFile(String filename) {

        Scanner mf = new Scanner(System.in);
        System.out.println("Enter Old Data");
        String olddata = mf.nextLine();
        System.out.println("Enter New Data");
        String newdata = mf.nextLine();
        File fileToBeModified= new  File(filename);
        String fileData="";
        BufferedReader reader=  null;
        FileWriter writer=null;


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

        } catch (Exception e) {
            System.out.println("Error: "+e);
        }
        finally {

            try {
                reader.close();
                writer.close();

            } catch (IOException e2) {
            }

        }

    }

    public static void appendFile(String filename) throws IOException {
        String app ;
        Scanner ap = new Scanner(System.in);
        app = ap.nextLine();
        BufferedWriter b = new BufferedWriter(new FileWriter(filename , true));
        b.write("\n");
        b.write(app);
        b.close();
    }

    public static void DeleteFile(String filename) throws IOException {
        Path path = Paths.get(filename);
        try {
            if (Files.deleteIfExists(path)) {
                System.out.println("***** file deleted *****");
            } else {
                System.out.println("file is not deleted");
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
                System.out.println("press");
                System.out.println("1 :-> To Create File");
                System.out.println("2 :-> To Perform operation");
                System.out.println("3 :-> BACK ");
                System.out.println("*************************************");
                num  = sc.nextInt();
                sc.nextLine();
                switch (num)
                {
                    case 1 -> createFile();
                    case 2 -> {
                        System.out.println("*************************************");
                        System.out.println("\t PRESS");
                        System.out.println("1. To Read File");
                        System.out.println("2. To Write File");
                        System.out.println("3. To Delete File");
                        System.out.println("4. To Append File");
                        System.out.println("5. To Modify File");
                        System.out.println("6. BACK ");
                        System.out.print("Enter your choice : ");
                        int op_num = sc.nextInt();
                        sc.nextLine();
                        System.out.println("*************************************");
                        System.out.println("Search the file on which you want to do operation");
                        String filenameStr = sc.nextLine();
                        System.out.println("------------------------------");
                        StringBuilder filename = new StringBuilder("E:\\Virtual Key for Your Repositories\\src\\");
                        filename.append(filenameStr);
                        if(rf.search(filenameStr)) {

                            switch (op_num)
                            {
                                case 1 -> ReadFile(filename.toString());
                                case 2 -> WriteFile(filename.toString());
                                case 3 -> {
                                    DeleteFile(filename.toString());
                                    rf.RemoveFileFromAllFiles(filenameStr);
                                    rf.RemoveFileFromAllFiles("\n");
                                }
                                case 4 -> appendFile(filename.toString());
                                case 5 -> ModifyFile(filename.toString());
                            }
                        }
                        else{
                            System.out.println("file doesn't exist or wrong file name");
                            continue;
                        }
                        }
                    }
                }
        } catch (Exception e) {
            System.out.println("Error: "+e);
        }
    }
}
