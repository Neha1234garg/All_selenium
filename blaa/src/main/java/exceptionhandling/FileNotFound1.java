package exceptionhandling;

public class FileNotFound1 extends Exception {

    private static final long serialVersionUID = 1L;
    
    public FileNotFound1(String str){
        super(str);
    }
}
