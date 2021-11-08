public class Multiplier {
    public int mul(int num, int mul){
        int res = num;
        for (int i = 1; i < mul; i++)
            res *= num;
        return res;
    }

    public int getCheck(){
        return 5;
    }
}
