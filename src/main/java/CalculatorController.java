
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class CalculatorController {

    @FXML private TextField number1Field;
    @FXML private TextField number2Field;
    @FXML private Label resultLabel;

    @FXML
    private void onCalculateClick() {
        try {
            String msg = CalculatorLogic.calculateMessage(number1Field.getText(), number2Field.getText());
            resultLabel.setText(msg);

            double num1 = Double.parseDouble(number1Field.getText());
            double num2 = Double.parseDouble(number2Field.getText());
            ResultService.saveResult(num1, num2, num1 + num2, num1 * num2, num1 - num2, num1 / num2);

        } catch (NumberFormatException e) {
            resultLabel.setText("Please enter valid numbers!");
        }
    }
}