public class Model {
   private View view;
   private String temp;
   private String leftValue;
   private String rightValue;
   private char actionValue;
  
   public Model(View view) {
 	this.view = view;
 	temp = "";
 	leftValue = "";
 	rightValue = "";
 	actionValue = '@';
   }
   public void doAction(String command) {
	System.out.println("im model");
 	if(command.equals("One")) {
 	  temp = temp + 1;
 	} else if(command.equals("Two")) {
 	  temp = temp + 2;
 	} else if(command.equals("Three")) {
 	  temp = temp + 3;
 	}else if(command.equals("Four")) {
 	  temp = temp + 4;
 	}else if(command.equals("Five")) {
 	  temp = temp + 5;
 	}else if(command.equals("Six")) {
 	  temp = temp + 6;
 	}else if(command.equals("Seven")) {
 	  temp = temp + 7;
 	}else if(command.equals("Eight")) {
 	  temp = temp + 8;
 	}else if(command.equals("Nine")) {
 	  temp = temp + 9;
 	}
	else if(command.equals("Plus_Command")) {
 	  leftValue = temp;
 	  actionValue = '+';
 	  temp = "";
 	  return;
 	} else if(command.equals("Minus_Command")) {
 	  leftValue = temp;
 	  actionValue = '-';
 	  temp = "";
 	  return;
 	} else if(command.equals("Mult_Command")) {
 	  leftValue = temp;
 	  actionValue = '*';
 	  temp = "";
 	  return;
	} else if(command.equals("Div_Command")) {
 	  leftValue = temp;
 	  actionValue = '/';
 	  temp = "";
 	  return;
	} else if(command.equals("Rem_Comand")) {
 	  leftValue = temp;
 	  actionValue = '%';
 	  temp = "";
 	  return;
	} else if(command.equals("C_Command")) {
 	  temp = "";
	  return;
	} else if(command.equals("Equals_Command")) {
 	  rightValue = temp;
  
 	  double leftValueDouble = Double.parseDouble(leftValue);
 	  double rightValueDouble = Double.parseDouble(rightValue);
 	  double answer = 0.0F;
  
		switch (actionValue) {
		case '+':
		answer = leftValueDouble + rightValueDouble;
		break;
		case '-':
		answer = leftValueDouble - rightValueDouble;
		break;
		default:
		}
		temp = "" + answer;
 	}
	
 	view.update(temp);
   }
}
