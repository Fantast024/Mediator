import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;
import mediator.Admin;
import mediator.Observer;
import mediator.User;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;
import java.util.Scanner;

public class Controller2 {
    TextFlow textFlow1 = new TextFlow();
    TextFlow textFlow2 = new TextFlow();
    public TextField nameFileField;
    File fileInput = null;
    MyListener myListener = new MyListener();
    public TextFlow fieldCode;
    public TextFlow fieldResult;
    User user;

    public File loadFile()
    {
        fileInput = new File("src/testFiles/" + nameFileField.getText());
        try (Scanner input = new Scanner(fileInput)) {
            while (input.hasNextLine()) {
                String[] str = input.nextLine().split(" ");
                for(int i = 0; i<str.length; i++)
                {
                    Text text = new Text();
                    if(str[i].equals(";") || str[i].equals("{") || str[i].equals("}"))
                    {
                        text.setText(str[i] + "\n");
                    } else
                    {
                        text.setText(str[i] + " ");
                    }
                    fieldCode.getChildren().addAll(text);
                }
            }
        } catch (FileNotFoundException ex)
        {
            ex.printStackTrace();
        }
        myListener.controller_check.loadFileForCheck(fileInput);
        return fileInput;
    }

    public void runCode() {
        if (fileInput == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("????????????!");
            alert.setHeaderText(null);
            alert.setContentText("???? ???????????????? ???????? ?????? ????????????????????????!");
            alert.showAndWait();
            System.out.println("???? ???????????????????? ???????? ?? ??????????");
            System.exit(2);
        } else {

            try {
                org.antlr.v4.runtime.CharStream input = CharStreams.fromFileName(fileInput.getAbsolutePath());
                myListener.controller_check.test(fieldResult);

                myJavaLexer lexer = new myJavaLexer(input);
                myJavaParser parser = new myJavaParser(new CommonTokenStream(lexer));
                parser.addParseListener(myListener);
                parser.program();
                checkMethod();

            } catch (IOException e) {
                e.printStackTrace();
            }
            fieldResult.getChildren().addAll(myListener.texts);
        }
    }

    public void helpMessage() {
        try {
            Stage stage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("helper.fxml"));
            stage.setTitle("??????????????");
            stage.setScene(new Scene(root, 600, 400));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean checkMethod(){

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        textFlow1.getChildren().addAll(myListener.controller_check.checkTest());
        textFlow2.getChildren().addAll(myListener.texts);
        if (!Objects.equals(textFlow1.getChildren().toString(), textFlow2.getChildren().toString()) || myListener.controller_check.getKey() == 1) {
            alert.setTitle("???? ??????????????????????!");
            alert.setHeaderText(null);
            alert.setContentText("?? ???????????????? ???????????????? ?? ???????? ???????????????????? ????????????!");
            alert.showAndWait();
            return false;

        } else {

            alert.setTitle("??????????!");
            alert.setHeaderText(null);
            alert.setContentText("?? ???????????????? ???????????????? ?? ???????? ???????????? ???? ????????????????????!" + "\n" + myListener.controller_check.str);
            alert.show();
            return true;

        }
    }
}
