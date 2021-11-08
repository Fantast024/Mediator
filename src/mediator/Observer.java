package mediator;

public class Observer implements User{
    Boolean acsess;

    public Observer(boolean acsess){
        this.acsess = acsess;
    }

    @Override
    public boolean getAcsessLoad() {
        return this.acsess;
    }

    @Override
    public void setAcsessLoad(boolean bool) {
        this.acsess = bool;
    }
}
