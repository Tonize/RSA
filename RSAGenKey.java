//For file management
import java.io.File;
import java.io.IOException;

//Write to file
import java.io.FileWriter;

//BigInteger
import java.math.BigInteger;

//take in user input
import java.util.Scanner;

//random
import java.util.Random;

class RSAGenKey {
    public static void main(String[] args) {
    
    //Scanner 
    Scanner in = new Scanner(System.in);

    //Used for generating random numbers
    Random random = new Random();

    //Prompt user for intput
    System.out.println("Please Input the key size:");

    //Take input
    int keySize = in.nextInt();

    //two random prime numbers p & q.
    BigInteger p = BigInteger.probablePrime(keySize, random);
    BigInteger q = BigInteger.probablePrime(keySize, random);

    //n = pq
    BigInteger n = p.multiply(q);

    //Creates the two text files, pub and private
    createFiles();

    //Writes to public key
    writePublicKey(p, n);
    //Writes to private key
    writePrivateKey(q, n);

    }
//Create both text files
public static void createFiles(){
    createPublicKey();
    createPrivateKey();
}
//creates the pub_key.txt
public static void createPublicKey(){
    try {  
        File myObj = new File("pub_key.txt");  
        if (myObj.createNewFile()) {  
          System.out.println("File created: " + myObj.getName());  
        } else {  
          System.out.println("File already exists.");  
        }  
      } catch (IOException e) {
        System.out.println("An error occurred.");
        e.printStackTrace();  
      }
    }
//creates the pri_key.txt
public static void createPrivateKey(){
    try {  
        File myObj = new File("pri_key.txt");  
        if (myObj.createNewFile()) {  
          System.out.println("File created: " + myObj.getName());  
        } else {  
          System.out.println("File already exists.");  
        }  
      } catch (IOException e) {
        System.out.println("An error occurred.");
        e.printStackTrace();  
      }
    }
//Write to both public & private keys
//Writes to the pub_key
public static void writePublicKey(BigInteger firstKey, BigInteger n) {
    try {
        FileWriter myWriter = new FileWriter("pub_key.txt");
        myWriter.write("e = "+firstKey+"\n"+"n = "+n);
        myWriter.close();
        System.out.println("Successfully wrote to the file.");
      } catch (IOException e) {
        System.out.println("An error occurred.");
        e.printStackTrace();
      }
    }
//writes to the private key
public static void writePrivateKey(BigInteger firstKey, BigInteger n) {
    try {
        FileWriter myWriter = new FileWriter("pri_key.txt");
        myWriter.write("n = "+firstKey+"\n"+"n = "+n);
        myWriter.close();
        System.out.println("Successfully wrote to the file.");
      } catch (IOException e) {
        System.out.println("An error occurred.");
        e.printStackTrace();
      }
    }
//Used to test p, q, n values
public static void displayPQN(BigInteger P, BigInteger Q, BigInteger N){
    System.out.println("P is :"+P);
    System.out.println("Q is :"+Q);
    System.out.println("N is :"+N);
    }
}
