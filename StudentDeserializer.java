import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class StudentDeserializer {
    final static String filename = "output.out";
    private static ArrayList<Student> studentArrayList; 
    public static void main(String[] args){
        studentArrayList = new ArrayList<Student>();
                // Deserialization 
                try
                {   
                    // Reading the object from a file 
                    FileInputStream file = new FileInputStream(filename); 
                    ObjectInputStream in = new ObjectInputStream(file); 
                    // try{
                    //     Student st = (Student) in.readObject();
                    // }catch(NullPointerException e){
                    //     e.printStackTrace();
                    // }
                    // Method for deserialization of object 
                    try {
                        studentArrayList.add((Student)in.readObject());
                    } catch (Exception e) {
                        //TODO: handle exception
                    }{
                    }
                      
                    in.close(); 
                    file.close(); 
                      
                    System.out.println("Object has been deserialized "); 
                    // System.out.println("a = " + studentArrayList.get(0).getFirstName()); 
                    // System.out.println("b = " + studentArrayList.get(0).getStdId()); 
                    // System.out.println("b = " + studentArrayList.get(0).getCourses()); 
                } 
                  
                catch(IOException ex) 
                { 
                    System.out.println("IOException is caught"); 
                } 
                  
                // catch(ClassNotFoundException ex) 
                // { 
                //     System.out.println("ClassNotFoundException is caught"); 
                // } 
    }
    
}