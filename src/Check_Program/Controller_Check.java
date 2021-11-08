package Check_Program;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Controller_Check {
    public String str = "a = 5" + "\n" + "b = 20" + "\n" + "a = 100" + "\n" + "a = 400" + "\n" + "a = 100" + "\n" + "a = 5" + "\n" + "a = 25" + "\n" + "a = 60" + "\n" + "a = 25" + "\n" + "a = 5" + "\n" + "7";
    public TextFlow info;
    private TextFlow textFlow1 = new TextFlow(), textFlow2 = new TextFlow();
    int key = 0;
    ArrayList<Text> checkText = new ArrayList<Text>();
    File fileOutput, fileInput;
    ArrayList<Integer> numbers = new ArrayList<Integer>();

    public void loadFileForCheck(File file){
        fileInput = file;
        loadFile();
    }

    public void loadFile()
    {
        try (Scanner input = new Scanner(fileInput)) {
            while (input.hasNextLine()) {
                String[] str = input.nextLine().split(" ");
                for(int i = 0; i<str.length; i++)
                {
                    Text text = new Text();
                    if(str[i].equals(";") || str[i].equals("{") || str[i].equals("}") || str[i].equals("begin"))
                    {
                        text.setText(str[i] + "\n");
                        textFlow1.getChildren().addAll(text);
                    } else
                    {
                        text.setText(str[i] + " ");
                        textFlow1.getChildren().addAll(text);
                    }
                }
            }
        } catch (FileNotFoundException ex)
        {
            ex.printStackTrace();
        }
    }

    public void test(TextFlow text)
    {
        textFlow2 = text;
        fileOutput = new File(String.valueOf(textFlow2));
    }

    public File getOutput()
    {
        fileOutput = fileInput;
        return fileOutput;
    }

    public void setKey(int key){
        this.key = key;
    }

    public int getKey()
    {
        return this.key;
    }

    public ArrayList<Text> checkTest(){
        Text text = new Text();
        int a = 5;
        text.setText("a = "+ a + "\n");
        checkText.add(text);
        int c = 7;
        int b = 20;
        Text text1 = new Text("b = "+ b + "\n");
        checkText.add(text1);
        a = a * b;
        Text text2 = new Text("a = "+ a + "\n");
        checkText.add(text2);
        a = a * 4;
        Text text3 = new Text("a = "+ a + "\n");
        checkText.add(text3);
        a = a / 4;
        Text text4 = new Text("a = "+ a + "\n");
        checkText.add(text4);
        a = a / b;
        Text text5 = new Text("a = "+ a + "\n");
        checkText.add(text5);
        a = a + b;
        Text text6 = new Text("a = "+ a + "\n");
        checkText.add(text6);
        a = a + 35;
        Text text7 = new Text("a = "+ a + "\n");
        checkText.add(text7);
        a = a - 35;
        Text text8 = new Text("a = "+ a + "\n");
        checkText.add(text8);
        a = a - b;
        Text text9 = new Text("a = "+ a + "\n");
        checkText.add(text9);

        Text text10 = new Text(String.valueOf(c) + "\n");
        checkText.add(text10 );
        //info.getChildren().addAll(checkText);

        return checkText;
    }


    public int checktest(File file){
        //Text text = new Text();
        int a = 5;
        //text.setText("a = "+ a + "\n");
        //checkText.add(text);
        int c = 7;
        int b = 20;
        //Text text1 = new Text("b = "+ b + "\n");
        //checkText.add(text1);
        a = a * b;
        //Text text2 = new Text("a = "+ a + "\n");
        //checkText.add(text2);
        a = a * 4;
        //Text text3 = new Text("a = "+ a + "\n");
        //checkText.add(text3);
        a = a / 4;
        //Text text4 = new Text("a = "+ a + "\n");
        //checkText.add(text4);
        a = a / b;
        //Text text5 = new Text("a = "+ a + "\n");
        //checkText.add(text5);
        a = a + b;
        //Text text6 = new Text("a = "+ a + "\n");
        //checkText.add(text6);
        a = a + 35;
        //Text text7 = new Text("a = "+ a + "\n");
        //checkText.add(text7);
        a = a - 35;
        //Text text8 = new Text("a = "+ a + "\n");
        //checkText.add(text8);
        a = a - b;
        //Text text9 = new Text("a = "+ a + "\n");
        //checkText.add(text9);

        //Text text10 = new Text(String.valueOf(c) + "\n");
        //checkText.add(text10 );
        //info.getChildren().addAll(checkText);

        return a;
    }
}
