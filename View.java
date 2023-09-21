import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.control.TextField;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Circle;
import javafx.scene.layout.VBox;
import javafx.geometry.Insets; 

public class View extends Application {
    
	private Controller controller;
	
	private TextField textField;
	
	public View(){
		controller = new Controller(this);
	}
    
    public void start(Stage stage){
		textField = new TextField();
		textField.setLayoutX(50);
		textField.setLayoutY(10);
		textField.setPrefSize(350, 80);
		textField.setStyle("-fx-text-fill: black;-fx-background-color: black; -fx-text-fill: white; -fx-border-color: #fe9504; -fx-border-width: 1px; -fx-border-radius: 30px; -fx-background-radius: 30px" );
		textField.setFont(Font.font("Helvetica", FontWeight.BOLD, 40));
		Circle circle = new Circle(80);

		Button buttonOne = new Button();
		buttonOne.setStyle("-fx-background-color: #333333; -fx-text-fill: white;");
		buttonOne.setShape(circle);
		buttonOne.setText("1");
		buttonOne.setLayoutX(50);
		buttonOne.setLayoutY(100);
		buttonOne.setPrefSize(80, 80);
		buttonOne.setTextFill(Color.BLACK);
		buttonOne.setFont(Font.font("Helvetica", FontWeight.BOLD, 30));
		buttonOne.setOnAction(controller);

		Button buttonTwo = new Button();
		buttonTwo.setStyle("-fx-background-color: #333333; -fx-text-fill: white;");
		buttonTwo.setShape(circle);
		buttonTwo.setText("2");
		buttonTwo.setLayoutX(140);
		buttonTwo.setLayoutY(100);
		buttonTwo.setPrefSize(80, 80);
		buttonTwo.setTextFill(Color.BLACK);
		buttonTwo.setFont(Font.font("Helvetica", 30));
		buttonTwo.setOnAction(controller);
		
		Button buttonThree = new Button();
		buttonThree.setStyle("-fx-background-color: #333333; -fx-text-fill: white;");
		buttonThree.setShape(circle);
		buttonThree.setText("3");
		buttonThree.setLayoutX(230);
		buttonThree.setLayoutY(100);
		buttonThree.setPrefSize(80, 80);
		buttonThree.setTextFill(Color.BLACK);
		buttonThree.setFont(Font.font("Helvetica", 30));
		buttonThree.setOnAction(controller);
		
		Button buttonFour = new Button();
		buttonFour.setStyle("-fx-background-color: #333333; -fx-text-fill: white;");
		buttonFour.setShape(circle);
		buttonFour.setText("4");
		buttonFour.setLayoutX(50);
		buttonFour.setLayoutY(190);
		buttonFour.setPrefSize(80, 80);
		buttonFour.setTextFill(Color.BLACK);
		buttonFour.setFont(Font.font("Helvetica", 30));
		buttonFour.setOnAction(controller);
		
		Button buttonFive = new Button();
		buttonFive.setStyle("-fx-background-color: #333333; -fx-text-fill: white;");
		buttonFive.setShape(circle);
		buttonFive.setText("5");
		buttonFive.setLayoutX(140);
		buttonFive.setLayoutY(190);
		buttonFive.setPrefSize(80, 80);
		buttonFive.setTextFill(Color.BLACK);
		buttonFive.setFont(Font.font("Helvetica", 30));
		buttonFive.setOnAction(controller);
		
		Button buttonSix = new Button();
		buttonSix.setStyle("-fx-background-color: #333333; -fx-text-fill: white;");
		buttonSix.setShape(circle);
		buttonSix.setText("6");
		buttonSix.setLayoutX(230);
		buttonSix.setLayoutY(190);
		buttonSix.setPrefSize(80, 80);
		buttonSix.setTextFill(Color.BLACK);
		buttonSix.setFont(Font.font("Helvetica", 30));
		buttonSix.setOnAction(controller);
		
		Button buttonSeven = new Button();
		buttonSeven.setStyle("-fx-background-color: #333333; -fx-text-fill: white;");
		buttonSeven.setShape(circle);
		buttonSeven.setText("7");
		buttonSeven.setLayoutX(50);
		buttonSeven.setLayoutY(280);
		buttonSeven.setPrefSize(80, 80);
		buttonSeven.setTextFill(Color.BLACK);
		buttonSeven.setFont(Font.font("Helvetica", 30));
		buttonSeven.setOnAction(controller);
		
		Button buttonEight = new Button();
		buttonEight.setStyle("-fx-background-color: #333333; -fx-text-fill: white;");
		buttonEight.setShape(circle);
		buttonEight.setText("8");
		buttonEight.setLayoutX(140);
		buttonEight.setLayoutY(280);
		buttonEight.setPrefSize(80, 80);
		buttonEight.setTextFill(Color.BLACK);
		buttonEight.setFont(Font.font("Helvetica", 30));
		buttonEight.setOnAction(controller);
		
		Button buttonNine = new Button();
		buttonNine.setStyle("-fx-background-color: #333333; -fx-text-fill: white;");
		buttonNine.setShape(circle);
		buttonNine.setText("9");
		buttonNine.setLayoutX(230);
		buttonNine.setLayoutY(280);
		buttonNine.setPrefSize(80, 80);
		buttonNine.setTextFill(Color.BLACK);
		buttonNine.setFont(Font.font("Helvetica", 30));
		buttonNine.setOnAction(controller);
		
		Button buttonZero = new Button();
		buttonZero.setStyle("-fx-background-color: #333333; -fx-text-fill: white;");
		buttonZero.setShape(circle);
		buttonZero.setText("0");
		buttonZero.setLayoutX(50);
		buttonZero.setLayoutY(370);
		buttonZero.setPrefSize(80, 80);
		buttonZero.setTextFill(Color.BLACK);
		buttonZero.setFont(Font.font("Helvetica", 30));
		buttonZero.setOnAction(controller);

		Button buttonPlus = new Button();
		buttonPlus.setStyle("-fx-background-color: #fe9504; -fx-text-fill: white;");
		buttonPlus.setShape(circle);
		buttonPlus.setText("+");
		buttonPlus.setLayoutX(320);
		buttonPlus.setLayoutY(280);
		buttonPlus.setPrefSize(80, 80);
		buttonPlus.setTextFill(Color.ORANGE);
		buttonPlus.setFont(Font.font("Helvetica", 40));
		buttonPlus.setOnAction(controller);

		Button buttonEquals = new Button();
		buttonEquals.setStyle("-fx-background-color: #fe9504; -fx-text-fill: white;");
		buttonEquals.setShape(circle);
		buttonEquals.setText("=");
		buttonEquals.setLayoutX(320);
		buttonEquals.setLayoutY(100);
		buttonEquals.setPrefSize(80, 80);
		buttonEquals.setTextFill(Color.ORANGE);
		buttonEquals.setFont(Font.font("Helvetica", FontWeight.BOLD, 40));
		buttonEquals.setOnAction(controller);

		Button buttonMinus = new Button();
		buttonMinus.setStyle("-fx-background-color: #fe9504; -fx-text-fill: white;");
		buttonMinus.setShape(circle);
		buttonMinus.setText("-");
		buttonMinus.setLayoutX(320);
		buttonMinus.setLayoutY(190);
		buttonMinus.setPrefSize(80, 80);
		buttonMinus.setTextFill(Color.ORANGE);
		buttonMinus.setFont(Font.font("Helvetica", 40));
		buttonMinus.setOnAction(controller);
		
		Button buttonMult = new Button();
		buttonMult.setStyle("-fx-background-color: #333333; -fx-text-fill: white;");
		buttonMult.setShape(circle);
		buttonMult.setText("*");
		buttonMult.setLayoutX(140);
		buttonMult.setLayoutY(370);
		buttonMult.setPrefSize(80, 80);
		buttonMult.setTextFill(Color.ORANGE);
		buttonMult.setFont(Font.font("Helvetica", 30));
		buttonMult.setOnAction(controller);
		
		Button buttonDiv = new Button();
		buttonDiv.setStyle("-fx-background-color: #fe9504; -fx-text-fill: white;");
		buttonDiv.setShape(circle);
		buttonDiv.setText("/");
		buttonDiv.setLayoutX(320);
		buttonDiv.setLayoutY(370);
		buttonDiv.setPrefSize(80, 80);
		buttonDiv.setTextFill(Color.ORANGE);
		buttonDiv.setFont(Font.font("Helvetica", 35));
		buttonDiv.setOnAction(controller);
		
		Button buttonRem = new Button();
		buttonRem.setStyle("-fx-background-color: #333333; -fx-text-fill: white;");
		buttonRem.setShape(circle);
		buttonRem.setText("%");
		buttonRem.setLayoutX(230);
		buttonRem.setLayoutY(370);
		buttonRem.setPrefSize(80, 80);
		buttonRem.setTextFill(Color.ORANGE);
		buttonRem.setFont(Font.font("Helvetica", 30));
		buttonRem.setOnAction(controller);
		
		Button buttonC = new Button();
		buttonC.setText("C");
		buttonC.setStyle("-fx-background-color: #a5a5a5; -fx-background-radius: 30px; -fx-text-fill: BLACK");
		buttonC.setLayoutX(50);
		buttonC.setLayoutY(460);
		buttonC.setPrefSize(160, 80);
		buttonC.setTextFill(Color.BLACK);
		buttonC.setFont(Font.font("Helvetica", 40));
		buttonC.setOnAction(controller);
		
		Button buttonDel = new Button();
		buttonDel.setShape(circle);
		buttonDel.setStyle("-fx-background-color: #a5a5a5;");
		buttonDel.setText("<-");
		buttonDel.setLayoutX(320);
		buttonDel.setLayoutY(460);
		buttonDel.setPrefSize(80, 80);
		buttonDel.setTextFill(Color.BLACK);
		buttonDel.setFont(Font.font("Helvetica", 30));
		buttonDel.setOnAction(controller);
		
		Button buttonDot = new Button();
		buttonDot.setShape(circle);
		buttonDot.setStyle("-fx-background-color: #a5a5a5;");
		buttonDot.setText(".");
		buttonDot.setLayoutX(230);
		buttonDot.setLayoutY(460);
		buttonDot.setPrefSize(80, 80);
		buttonDot.setTextFill(Color.BLACK);
		buttonDot.setFont(Font.font("Helvetica", 40));
		buttonDot.setOnAction(controller);
		
		

		//Button buttonSqrt = new Button();
		//buttonSqrt.setShape(circle);
		//buttonSqrt.setText("Sqrt");
		//buttonSqrt.setLayoutX(140);
		//buttonSqrt.setLayoutY(500);
		//buttonSqrt.setPrefSize(80, 80);
		//buttonSqrt.setTextFill(Color.ORANGE);
		//buttonSqrt.setFont(Font.font("Helvetica", 30));
		//buttonSqrt.setOnAction(controller);
		
		Pane root = new Pane();
		
		Scene scene = new Scene(root, 450, 580);
		root.setStyle("-fx-background-color: black; -fx-margin: 330 0 0 0;");
		scene.setFill(Color.RED);
		
		
		stage.setTitle("RPN Calc Mediator");
		
		root.getChildren().addAll(buttonOne, buttonTwo, buttonThree, buttonFour, buttonFive, buttonSix, buttonSeven,
		buttonEight, buttonNine, buttonPlus, buttonEquals, buttonMinus, buttonC, textField,
		buttonRem, buttonMult, buttonZero, buttonDel, buttonDiv, buttonDot);
		
		
		stage.setScene(scene);
        stage.show();
		
		//javac --module-path="C:\Program Files\Java\javafx-sdk-21\lib" --add-modules=ALL-MODULE-PATH *.java

		//java --module-path="C:\Program Files\Java\javafx-sdk-21\lib" --add-modules=ALL-MODULE-PATH Main

	}
	
	public static void startJavaFx(String[] args){
		launch(args);
	}
	
	public void update(String result) {
		textField.setText(result);
	}
}




