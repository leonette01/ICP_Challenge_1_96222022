package ICP_Challenge;

import java.util.Scanner;
import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;


/**
 * @author Akua
 */

public class Essentials {

    PrintWriter writer = null;
    PrintWriter b = null;
    
// Class constructor
    public Essentials() {

    }
// add method created to enable record keeping for item purchased    
    public String add(){
      Scanner scan = new Scanner(System.in);
      String name = scan.next();
      int quant = scan.nextInt();
      float price = scan.nextFloat();
      
      Stocks sampleItem = new Stocks(name, quant, price);
      return sampleItem.toString();

        
    }
    
 /**
  * writeToFile method created to write items purchased
  * one after the other into a specified file.
  * 
  * @exception FileNotFoundException The indicated file does not exist
  * */
    
    public void writeToFile(){
        try{
          writer = new PrintWriter(new FileOutputStream("essentials_stock.txt", true));  
        }
        catch(FileNotFoundException e){
            e.getMessage();
        }
        
        writer.println(this.add());
        writer.close();
    }

/**
 * @throws IOException On input error
 * @exception FileNotFoundException The indicated file does not exist
 **/
    public void backup() throws IOException{
      Scanner c = null;
      try{
        c = new Scanner(new FileInputStream("essentials_stock.txt"));
        b = new PrintWriter(new FileOutputStream("backup_essentials_stock.txt", true));
      }
      catch(FileNotFoundException e){
        System.out.println();
        c.close();
        b.close();
      }
      while(c.hasNextLine()){
        b.println(c.nextLine());
      }
      b.close();
      c.close();
    }

/**
 * @exception IOException On input error
 */
    public void addItems(){
        for (int i = 0; i < 10; i++){
            this.writeToFile();
            
            try{
              this.backup();
            }
            catch(IOException e){}
        }
    }
    
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Essentials e = new Essentials();
        e.addItems();
        System.out.println("Items added");
    }
    
}


class Stocks {
    private String itemName;
    private int quantity;
    private float price;

// Class constructor with the inclusion of formal parameters
    public Stocks(String itemName, int quantity, float price) {
        this.itemName = itemName;
        this.quantity = quantity;
        this.price = price;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }
    
/** 
 * @return int It returns the quantity purchased
 **/
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

/**
 * @return float It returns the price of item purchased
 **/
    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
    
    public float total(float price, int quantity){
        return price * quantity;
    }
    
/**
 * @Override To check if the method id an override
 **/
    public String toString(){
        return this.itemName + " " + this.quantity + " GHC " + this.price;
    }
 
  
}


