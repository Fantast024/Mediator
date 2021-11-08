package mediator;

import java.util.ArrayList;

public class AcsessLoad implements Load{
    User user;

    public void setUser(User user){
        this.user = user;
    }

    @Override
    public boolean acsessLoad() {
            if(user.getAcsessLoad()){
                return true;
            }else{
                return false;
            }
    }
}
