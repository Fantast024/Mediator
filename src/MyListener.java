import Check_Program.Controller_Check;
import javafx.scene.control.Alert;
import javafx.scene.text.Text;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * "Класс для обработки программного кода
 * который позволяет переопределить необходимые методы в производном классе.
 * @author Сергеев Н.
 * @version 1.0
 */
public class MyListener extends myJavaBaseListener {
    /**
     * Переменная для обработки буквенных переменных в коде.
     */
    private Map<String, Integer> variables;
    /**
     * Переменныя для хранения текста для вывода в консоль.
     */
    public ArrayList<Text> texts = new ArrayList<Text>();
    /**
     * Экземпляр класса.
     */
    public Controller_Check controller_check = new Controller_Check();

    /**
     * Конструктор класса.
     */
    public MyListener()
    {
        variables = new HashMap<>();
    }
    Alert alert = new Alert(Alert.AlertType.ERROR);

    /**
     * Функция выхода из правила "присвоение" синтаксического анализатора.
     * @param ctx Контекст правила "присвоение" синтаксического анализатора.
     */
    @Override
    public void exitAssign(myJavaParser.AssignContext ctx)
    {
        String variableName = ctx.ID(0).getText();
        String value = ctx.ID().size()>1 ?
                ctx.ID(1).getText():
                ctx.NUMBER().getText();
        //let a be b
        if(ctx.ID().size()>1)
            variables.put(variableName,variables.get(value));
        else
            variables.put(variableName,Integer.parseInt(value));
    }

    /**
     * Функция выхода из правила "сложение" синтаксического анализатора.
     * @param ctx Контекст правила "сложение" синтаксического анализатора.
     */
    @Override
    public void exitAdd(myJavaParser.AddContext ctx)
    {
        String variableName = ctx.ID(0).getText();

        int value = ctx.ID().size() >1?
                variables.get(ctx.ID(1).getText()):
                Integer.parseInt(ctx.NUMBER().getText());
        variables.put(variableName, variables.get(variableName) + value);
    }

    /**
     * Функция выхода из правила "вычитание" синтаксического анализатора.
     * @param ctx Контекст правила "вычитание" синтаксического анализатора.
     */
    @Override
    public void exitSub(myJavaParser.SubContext ctx)
    {
        String variableName = ctx.ID(0).getText();

        int value = ctx.ID().size() >1?
                variables.get(ctx.ID(1).getText()):
                Integer.parseInt(ctx.NUMBER().getText());
        variables.put(variableName, variables.get(variableName) - value);
    }

    /**
     * Функция выхода из правила "умножение" синтаксического анализатора.
     * @param ctx Контекст правила "умножение" синтаксического анализатора.
     */
    @Override
    public void exitMul(myJavaParser.MulContext ctx) {
        String variableName = ctx.ID(0).getText();

        int value = ctx.ID().size() >1?
                variables.get(ctx.ID(1).getText()):
                Integer.parseInt(ctx.NUMBER().getText());
        variables.put(variableName, variables.get(variableName) * value);
    }

    /**
     * Функция выхода из правила "деление" синтаксического анализатора.
     * @param ctx Контекст правила "деление" синтаксического анализатора.
     */
    @Override
    public void exitDiv(myJavaParser.DivContext ctx) {
        alert.setTitle("Не соответские!");
        alert.setHeaderText(null);
        alert.setContentText("В процессе проверки в коде обнаружены ошибки!");
        String variableName = ctx.ID(0).getText();

            int value = ctx.ID().size() > 1 ?
                    variables.get(ctx.ID(1).getText()) :
                    Integer.parseInt(ctx.NUMBER().getText());
            if(value != 0) {
                variables.put(variableName, variables.get(variableName) / value);
            }else{
                controller_check.setKey(1);
                System.out.println("У программы нет возможности делить на 0!!!");
                alert.showAndWait();
                System.exit(1);
            }
    }

    /**
     * Функция выхода из правила "вывод данных в консоль" синтаксического анализатора.
     * @param ctx Контекст правила "вывод данных в консоль" синтаксического анализатора.
     */
    @Override
    public void exitPrint(myJavaParser.PrintContext ctx)
    {
        String output = "";
        Text result = new Text();
        if(ctx.ID() == null){
            output = ctx.NUMBER().getText();
            result.setText(output + "\n");
        }else {
            output = variables.get(ctx.ID().getText()).toString();
            result.setText(ctx.ID().getText() + " = " + output + "\n");
        }
        texts.add(result);
        //System.out.println(output);
    }
}
