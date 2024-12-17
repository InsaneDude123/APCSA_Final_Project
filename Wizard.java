import java.util.ArrayList;

public class Wizard extends Character {
    private int maxMana;
    private int curMana;
    private boolean tool;
    private static ArrayList<Wizard> wizards = new ArrayList<Wizard>();

    public Wizard(String n){
        super(n);
        role = "Wizard";
        maxMana = 1 + getlv();
        curMana = maxMana;
        wizards.add(this);
    }

    public static ArrayList<Wizard> getWizards(){
        return wizards;
    }

    public int getCurMana(){
        return curMana;
    }

    public void setCurMana(int curMana) {
        this.curMana = curMana;
    }

    public int getMaxMana(){
        return 1 + getlv();
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

    // wizards can buff wizards, but it does not have an effect, so it is a waste of mana
    public void buff(Character c){
        if (this.curMana > 0){
            c.setBuff(1 + this.getlv() + toolBuff);
            this.curMana--;
        }
    }
}
