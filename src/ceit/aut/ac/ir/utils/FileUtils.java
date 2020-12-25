package ceit.aut.ac.ir.utils;
import ceit.aut.ac.ir.model.Note;
import java.io.*;
/**
 * @author Arman Hatami
 * @version 1.0
 * saving notes
 */
public class FileUtils {

    private static final String NOTES_PATH = "./notes/";


    //It's a static initializer. It's executed when the class is loaded.
    //It's similar to constructor
    static {
        boolean isSuccessful = new File(NOTES_PATH).mkdirs();
        System.out.println("Creating " + NOTES_PATH + " directory is successful: " + isSuccessful);
    }

    public static File[] getFilesInDirectory() {
        return new File(NOTES_PATH).listFiles();
    }

    /**
     * read from file by input stream
     * @param file
     * @return
     * @throws IOException
     */
    public static String fileReader(File file) throws IOException {
        //TODO: Phase1: read content from file
        File f=file;
        String st="";

        FileInputStream fileInputStream=new FileInputStream(f);
        while (fileInputStream.available()>0){
            st+=(char) fileInputStream.read();

        }fileInputStream.close();
        return st;
    }

    /**
     * write in file by output stream
     * @param content
     * @throws IOException
     */
    public static void fileWriter(String content) throws IOException {
        //TODO: write content on file
        String fileName = getProperFileName(content);

        String st=NOTES_PATH+fileName;
        File f = new File(st);

        FileOutputStream fileOutputStream=new FileOutputStream(f);

        char [] c= content.toCharArray();
        byte [] temp= new byte[c.length];
        for (int i=0;i<temp.length;i++){
            temp[i]=(byte) c[i];

        }
        fileOutputStream.write(temp);

        fileOutputStream.close();
    }

    /**
     * write in file by buffer
     * @param content
     */
    public static void fileWriterBuffer(String content){
        String fileName=getProperFileName(content);
        String st=NOTES_PATH+fileName;
        File file=new File(st);
        try {
            FileWriter fw=new FileWriter(file);
            BufferedWriter bw=new BufferedWriter(fw);
            bw.write(content);
            fw.close();bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    /**
     * read from file by buffer
     * @param file
     * @return
     */
    public  static String fileReaderBuffer(File file){
        String st="";
        try {
            FileReader fr=new FileReader(file);
            BufferedReader br=new BufferedReader(fr);
            while (br.ready()) {
                st+=br.readLine()+"\n";
            }
            br.close();
            fr.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return st;
    }

    /**
     * read obj from file
     * @param file
     * @return
     */
    public static Note fileReaderSerialize(File file){
        File f=file;
        Note note=null;
        try {
            FileInputStream is=new FileInputStream(f);
            BufferedInputStream bis=new BufferedInputStream(is);
            ObjectInputStream ois=new ObjectInputStream(bis);
            note=(Note) ois.readObject();
            ois.close();bis.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return note;
    }

    /**
     * write obj in file
     * @param content
     */
    public static void filewWriterSerialize(String content){
        String fileName=getProperFileName(content);
        String st=NOTES_PATH+fileName;
        File f=new File(st);
        String[] array = content.lines().toArray(String[]::new);
        String title=array[0];
        String date=array[array.length-1]; String contentSt="";
        for (int i=0;i<array.length;i++){
            contentSt+=array[i];
        }


        Note note=new Note(title,contentSt,date);



        try {
            FileOutputStream os=new FileOutputStream(f);
            ObjectOutputStream objectOutputStream=new ObjectOutputStream(os);
            objectOutputStream.writeObject(note);
            objectOutputStream.close();
            os.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
    //TODO: Phase1: define method here for reading file with InputStream
    //TODO: Phase1: define method here for writing file with OutputStream

    //TODO: Phase2: proper methods for handling serialization


    private static String getProperFileName(String content) {
        int loc = content.indexOf("\n");
        if (loc != -1) {
            return content.substring(0, loc);
        }
        if (!content.isEmpty()) {
            return content;
        }
        return System.currentTimeMillis() + "_new file.txt";
    }
}
