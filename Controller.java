import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;



public class Controller implements EventHandler<ActionEvent> {
    public Model model;
    public View view;
    public Controller(View view) {
        model = new Model(view);
    }
    public void handle (ActionEvent event){
		System.out.println("im controller");
		Button btn = (Button)event.getTarget();
		String textButton = btn.getText();
		String command = "";
		if(textButton.equals("1")) {
		  command = "One";
		}else if(textButton.equals("2")) {
		  command = "Two";
		}else if(textButton.equals("3")) {
		  command = "Three";
		}else if(textButton.equals("4")) {
		  command = "Four";
		}else if(textButton.equals("5")) {
		  command = "Five";
		}else if(textButton.equals("6")) {
		  command = "Six";
		}else if(textButton.equals("7")) {
		  command = "Seven";
		}else if(textButton.equals("8")) {
		  command = "Eight";
		}else if(textButton.equals("9")) {
		  command = "Nine";
		}else if(textButton.equals("+")) {
		  command = "Plus_Command";
		} else if(textButton.equals("-")) {
		  command = "Minus_Command";
		} else if(textButton.equals("=")) {
		  command = "Equals_Command";
		}else if(textButton.equals("*")) {
		  command = "Mult_Command";
		}else if(textButton.equals("/")) {
		  command = "Div_Command";
		}else if(textButton.equals("%")) {
		  command = "Rem_Command";
		}else if(textButton.equals("C")) {
		  command = "C_Command";
		}else if(textButton.equals("<-")) {
		  command = "Del_Command";
		}else if(textButton.equals(".")) {
		  command = "Dot_Command";
		}else if(textButton.equals("C")) {
		  command = "C_Command";
		}else if(textButton.equals("Sqrt")) {
		  command = "Sqrt_Command";
		} else {
		  return ;
		}
		model.doAction(command);
	}
	
}


