import java.util.ArrayList;

public class Knight extends Character{
    private int health;
    private int damage;
    final private int SALARY = 75;
    private boolean tool;
    private boolean onDuty = false;
    private static ArrayList<Knight> knights = new ArrayList<Knight>();

    public Knight(String n){
        super(n);
        role = "Knight";
        health = 10 + (2 * (getlv() + buff + toolBuff));
        damage = 5 + getlv() + buff + toolBuff;
        knights.add(this);
    }

    public static ArrayList<Knight> getKnights(){
        return knights;
    }

    public int getHealth(){
        return health;
    }

    public int getDamage(){
        return damage;
    }

    public boolean duty(){
        return onDuty;
    }

    public void dutyOn(){
        this.onDuty = true;
    }

    public void dutyOff(){
        this.onDuty = false;
    }

    public int getSalary(){
        return SALARY;
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

    public void pay(){
        this.deposit(SALARY);
    }
    
    // on duty knights determines kingdom defense power
    public static int kingdomDefense(){
        int j = 0;
        for (int i = 0; i < knights.size(); i++){
            if (knights.get(i).onDuty){
                j += knights.get(i).health;
            }
        }
        return j;
    }

    // on duty knights determines kingdom attack power
    public static int kingdomAttack(){
        int j = 0;
        for (int i = 0; i < knights.size(); i++){
            if (knights.get(i).onDuty){
                j += knights.get(i).damage;
            }
        }
        return j;
    }

}