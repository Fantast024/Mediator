package mediator;

public class Admin implements User{
    Boolean acsess;

    public Admin(){
        this.acsess = true;
    }

    @Override
    public boolean getAcsessLoad() {
        return this.acsess;
    }

    @Override
    public void setAcsessLoad(boolean bool) {
        if (!bool){
            System.out.println("У админа не может быть заблокировано поле загрузки!");
            this.acsess = true;
        }else {
            this.acsess = bool;
        }
    }
}
