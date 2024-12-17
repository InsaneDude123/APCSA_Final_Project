import java.util.ArrayList;

public class Merchant extends Character{
    private int remAttempt;
    private int maxAttempt;
    private static ArrayList<Merchant> merchants = new ArrayList<Merchant>();

    public Merchant(String n){
        super(n);
        role = "Merchant";
        merchants.add(this);
        maxAttempt = 1 + getlv() + buff;
        remAttempt = maxAttempt;
    }

    public static ArrayList<Merchant> getMerchants(){
        return merchants;
    }

    public int getRemAttempt(){
        return remAttempt;
    }

    public void setRemAttempt(int remAttempt) {
        this.remAttempt = remAttempt;
    }

    public int getMaxAttempt(){
        return 1 + getlv() + buff;
    }

    public void trade(){
        if (remAttempt > 0){
            this.deposit((int) (Math.random()*100) + (10 * (getlv() + buff)));
            remAttempt--;
        }
    }

    public void makeTool(Peasant p){
        p.receiveTool();
        p.setToolBuff(1 + getlv() + buff);
    }

    public void makeTool(Knight k){
        k.receiveTool();
        k.setToolBuff(1 + getlv() + buff);
    }

    public void makeTool(Wizard w){
        w.receiveTool();
        w.setToolBuff(1 + getlv() + buff);
    }
}