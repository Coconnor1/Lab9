package hellofx;

import java.util.Scanner;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.geometry.HPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Main extends Application {
  private TextField conversion = new TextField();
  private TextField conversionTotal = new TextField();
  private Button btCalculate = new Button("Calculate");
  
  @Override // Override the start method in the Application class
  public void start(Stage primaryStage) {
    // Create UI
    GridPane gridPane = new GridPane();
    gridPane.setHgap(5);
    gridPane.setVgap(5);
    gridPane.add(new Label("Enter your conversion:"), 0, 0);
    gridPane.add(conversion, 1, 0);
    gridPane.add(new Label("Conversion rate:"), 0, 1);
    gridPane.add(conversionTotal, 1, 1);
    gridPane.add(btCalculate, 1, 5);
    conversionTotal.setEditable(false);

    // Set properties for UI
    gridPane.setAlignment(Pos.CENTER);
    conversion.setAlignment(Pos.BOTTOM_RIGHT);
    conversionTotal.setAlignment(Pos.BOTTOM_RIGHT);
    GridPane.setHalignment(btCalculate, HPos.RIGHT);

    // Process events
    btCalculate.setOnAction(e -> caculateConversion());

    // Create a scene and place it in the stage
    Scene scene = new Scene(gridPane, 400, 250);
    primaryStage.setTitle("Metric Converter"); // Set title
    primaryStage.setScene(scene); // Place the scene in the stage
    primaryStage.show(); // Display the stage
  }
  
  private Object caculateConversion() {
    return null;
  }

  class UnitConverter{
    public static float converter (float fromNum, String fromUnit, String toUnit){
        float result = 0;
        boolean err = false;
        switch (fromUnit){
            case "in":
            case "inches":
                switch (toUnit){
                    case "mm":
                        result = (float) (fromNum * 25.4);
                        break;
                    case "cm":
                        result = (float) (fromNum * 2.54);
                        break;
                    default:
                        System.out.println("Error");
                        err = true;
                        break;
                }
                break;


            case "gal":
            case "gallons":
            case "gallon":
                switch (toUnit){
                    case "qt":
                        result = fromNum * 4;
                        break;
                    case "pt":
                        result = fromNum * 8;
                        break;
                    case "cup":
                    case "cups":
                        result = fromNum * 16;
                        break;
                    default:
                        System.out.println("Error");
                        err = true;   
                        break;  
                }
                break;


            case "cup":
            case "cups":
            case "cp":
                switch (toUnit){
                    case "gal":
                    case "gallon":
                    case "gallons":
                        result = (float)(fromNum * 0.0625);
                        break;
                    case "pt":
                    case "pint":
                    case "pints":
                        result = (float)(fromNum * 0.5);
                        break;
                    case "qt":
                    case "quart":
                    case "quarts":
                        result = (float) (fromNum * 0.25);
                        break;
                    default:
                        System.out.println("Error");
                        err = true;   
                        break;  
                }
                break;

            case "qt":
            case "quart":
                switch (toUnit){
                    case "gal":
                        result = fromNum * 25 / 100;
                        break;
                    case "pt":
                        result = fromNum * 2;
                        break;
                    case "cups":
                        result = fromNum * 4;      
                    default:
                        System.out.println("Error");
                        err = true;
                        break;
                }
                break;


            default:
                System.out.println("Error");
                err = true;
                break;  
                
            


        }
        if (err == false){
            System.out.printf("%.2f %s = %.2f %s%n", fromNum, fromUnit, result, toUnit);
        }
        
        return result;

    }

}
public class Conversion {
    
    
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.println("Please enter a conversion. EX: 1 gal = pt, 1 pt = gal or exit" );
            String str;
            str = input.nextLine();
            str = str.toLowerCase();
            if (str.equals("exit")){
                break;
            }
            String[] sa;
            sa = str.split(" ");
            if (sa.length == 4){   
                String fromNum = sa[0];
                String fromUnit = sa[1];
                String toUnit = sa[3];
                float fromVal = Float.parseFloat(fromNum);
                UnitConverter.converter(fromVal,fromUnit,toUnit);
            }

            else{
                System.out.println("Invalid input, please try again.");
            }
            
        }
        input.close();
    }
}
}