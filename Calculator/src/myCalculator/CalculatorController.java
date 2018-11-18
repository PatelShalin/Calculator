//CalculatorController
//Shalin A. Patel
//March 21, 2018
//This program controls the calculator (as the name implies) by obtaining which
//buttons are pressed. This calculator can do mild one-step operations, and
//includes a visually appealing display
package myCalculator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class CalculatorController {

	@FXML
	private TextField displayField;

	// Operation is a double variable used to store any total of any operation (i.e.
	// multiply, divide, etc.)
	public double number1, number2, operation, memory, flipSign;

	public String number = "";

	public String operationStore = "";

	public void buttonClickHandler(ActionEvent evt) {

		Button clickedButton = (Button) evt.getTarget();
		String buttonLabel = clickedButton.getText();

		switch (buttonLabel) {
		// If the user clicked Random:
		case "Random":
			// Set number equal to a random double between 0 and 1
			number = Double.toString(Math.random());
			// Display this number onto the display
			displayField.setText(number);
			break;
		// If the user chose Pi:
		case "Pi":
			// Set number equal to the double value of pi
			number = Double.toString(Math.PI);
			// Display pi onto the display screen
			displayField.setText(number);
			break;
		case "0":
		case "1":
		case "2":
		case "3":
		case "4":
		case "5":
		case "6":
		case "7":
		case "8":
		case "9":
		case ".":
			// If the user has completed an operation and now they want to enter a new
			// number
			// without pressing the clear button, then the program will reset all of the
			// previously stored numbers and will clear the displayField
			if (operationStore == "=") {
				displayField.setText("");
				number1 = 0;
				number2 = 0;
				operation = 0;
				number = "";
				operationStore = "";
			}
			processDigit(buttonLabel);
			break;
		// If the user clicked an operation
		default:
			processOperation(buttonLabel);
		}
	}

	private void processDigit(String buttonLabel) {
		// Get the number from the displayField and store it as a string
		number += buttonLabel;
		// Show this number on the calculator screen
		displayField.setText(displayField.getText() + buttonLabel);
	}

	private void processOperation(String buttonLabel) {
		switch (buttonLabel) {
		// If the user chose multiply:
		case "X":
			// Hold the previous number on screen into a double variable
			number1 = Double.parseDouble(number);
			// Reset the number field from the displayField
			number = "";
			// Erase the calculator screen
			displayField.setText("");
			// Store the operation into a variable
			operationStore = "X";
			break;
		// If the user chose the power function:
		case "^":
			number1 = Double.parseDouble(number);
			number = "";
			displayField.setText("");
			operationStore = "^";
			break;
		// If the user chose subtract
		case "-":
			number1 = Double.parseDouble(number);
			number = "";
			displayField.setText("");
			operationStore = "-";
			break;
		// If the user chose addition
		case "+":
			number1 = Double.parseDouble(number);
			number = "";
			displayField.setText("");
			operationStore = "+";
			break;
		// If the user chose division
		case "/":
			number1 = Double.parseDouble(number);
			number = "";
			displayField.setText("");
			operationStore = "/";
			break;
		// If the user chose to store the number on screen into the memory
		case "MS":
			memory = (Double.parseDouble(displayField.getText()));
			break;
		// If the user chose to add the number to the memory storage
		case "M+":
			// Add the number on display into the memory variable
			memory += (Double.parseDouble(displayField.getText()));
			break;
		// If the user chose to subtract the number from the memory storage
		case "M-":
			// Subtract the number on display from the memory variable
			memory -= (Double.parseDouble(displayField.getText()));
			break;
		// If the user chose to recall the memory
		case "MR":
			// If the memory is a complete integer value, display the number as an integer
			// to the screen
			if (memory % 1 == 0) {
				displayField.setText(Integer.toString((int) Math.round(memory)));
			}
			// Else display a double value to the screen
			else {
				displayField.setText(Double.toString(memory));
			}
			// Set the string number equal to the memory since it was called onto the screen
			number = Double.toString(memory);
			break;
		// If the user chose memory clear then set memory equal to 0
		case "MC":
			memory = 0;
			break;
		// If the user chose +- then multiply the number by -1 to flip the sign
		case "+-":
			flipSign = (Double.parseDouble(displayField.getText()) * -1);
			if (flipSign % 1 == 0) {
				number = (Integer.toString((int) Math.round(flipSign)));
			} else {
				number = Double.toString(flipSign);
			}
			displayField.setText(number);
			break;
		// If the user chose C then clear the display screen, set both number1 and
		// number2 equal to 0, set the operation equal to 0, set number and
		// operationStore equal to ""
		case "C":
			displayField.setText("");
			number1 = 0;
			number2 = 0;
			operation = 0;
			number = "";
			operationStore = "";
			break;

		// If the user chose sin then set operationStore equal to sin
		case "sin":
			operationStore = "sin";
			break;

		// If the user chose cos then set operationStore equal to cos
		case "cos":
			operationStore = "cos";
			break;

		// If the user chose =
		case "=":
			// Set number2 equal to the current number on display
			number2 = Double.parseDouble(number);
			// If the user chose multiply:
			if (operationStore == "X") {
				// Set operation equal to number1 times number2
				operation = number1 * number2;
				// If operation is an integer then display it to the screen as an integer
				if (operation % 1 == 0) {
					displayField.setText(Integer.toString((int) Math.round(operation)));
					// Else display it as a double value
				} else {
					displayField.setText(Double.toString(operation));
				}
				// Set operationStore equal to "="
				operationStore = "=";
				// If the user chose divide
			} else if (operationStore == "/") {
				operation = number1 / number2;
				if (operation % 1 == 0) {
					displayField.setText(Integer.toString((int) Math.round(operation)));
				} else {
					displayField.setText(Double.toString(operation));
				}
				operationStore = "=";
				// If the user chose addition
			} else if (operationStore == "+") {
				operation = number1 + number2;
				if (operation % 1 == 0) {
					displayField.setText(Integer.toString((int) Math.round(operation)));
				} else {
					displayField.setText(Double.toString(operation));
				}
				System.out.println(operation);
				operationStore = "=";
				// If the user chose subtraction
			} else if (operationStore == "-") {
				operation = number1 - number2;
				if (operation % 1 == 0) {
					displayField.setText(Integer.toString((int) Math.round(operation)));
				} else {
					displayField.setText(Double.toString(operation));
				}
				operationStore = "=";
				// If the user chose sin
			} else if (operationStore == "sin") {
				operation = (Math.sin(Math.toRadians(number2)));
				if (operation % 1 == 0) {
					displayField.setText(Integer.toString((int) Math.round(operation)));
				} else {
					displayField.setText(Double.toString(operation));
				}
				operationStore = "=";
				// If the user chose cos
			} else if (operationStore == "cos") {
				operation = (Math.cos(Math.toRadians(number2)));
				if (operation % 1 == 0) {
					displayField.setText(Integer.toString((int) Math.round(operation)));
				} else {
					displayField.setText(Double.toString(operation));
				}
				operationStore = "=";
				// If the user chose the power function
			} else if (operationStore == "^") {
				operation = Math.pow(number1, number2);
				if (operation % 1 == 0) {
					displayField.setText(Integer.toString((int) Math.round(operation)));
				} else {
					displayField.setText(Double.toString(operation));
				}
				operationStore = "=";
			}
			break;

		}
	}
}
