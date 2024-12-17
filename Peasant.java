import java.util.ArrayList;

public class Peasant extends Character {
    private int curStamina;
    private int maxStamina;
    private int productivity;
    private boolean tool;
    private static ArrayList<Peasant> peasants = new ArrayList<Peasant>();

    public Peasant(String n){
        super(n);
        role = "Peasant";
        productivity = 1 + getlv() + buff + toolBuff;
        maxStamina = 2 + getlv() + buff;
        curStamina = maxStamina;
        peasants.add(this);
    }

    public static ArrayList<Peasant> getPeasants(){
        return peasants;
    }

    public int getCurStamina(){
        return curStamina;
    }

    public void setCurStamina(int curStamina) {
        this.curStamina = curStamina;
    }

    public int getMaxStamina(){
        return 2 + getlv() + buff;
    }

    public int getProductivity(){
        return 1 + getlv() + buff + toolBuff;
    }

    public boolean hasTool(){
        return tool;
    }

    public void receiveTool(){
        tool = true;
    }

    public void disposeTool(){
        tool = false;
        setToolBuff(0);
    }

    public void farm(){
        if (curStamina > 0){
            this.deposit(40 + (10 * productivity));
            curStamina--;
        }
    }
}
