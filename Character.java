import java.util.ArrayList;

class Character {

    protected int balance = 0;
    private Character spouse;
    private String name;
    protected String role;
    private int lv = 0;
    protected int buff = 0;
    protected int toolBuff = 0;
    public static int population = 0;
    private static ArrayList<Character> characters = new ArrayList<Character>();

    public Character(String n){
        name = n;
        population += 1;
        characters.add(this);
    }

    public static ArrayList<Character> getCharacters(){
        return characters;
    }

    public int getBuff(){
        return buff;
    }

    public void setBuff(int b){
        buff = b;
    }

    public int getToolBuff(){
        return toolBuff;
    }

    public void setToolBuff(int b){
        toolBuff = b;
    }

    public int getBalance(){
        return balance;
    }

    public void deposit(int s){
        this.balance += s;
    }

    public void withdraw(int s){
        this.balance -= s;
    }

    public String getRole(){
        return role;
    }

    public int getlv(){
        return lv;
    }

    public String getName(){
        return name;
    }

    public static int getPop(){
        return population;
    }
    public Character getSpouse(){
        if (spouse != null){
            return spouse;
        }
        else{
            return null;
        }
    }

    public void lvup(){
        if (lv<5){
            lv++;
        }
    }

    public static int kingdomWealth(){
        int j = 0;
        for (int i = 0; i < characters.size(); i++){
            j += characters.get(i).getBalance();
        }
        return j;
    }

    // the program does not support divorce at the moment
    public void marry(Character c){
        if (spouse == null && c.getSpouse() == null){
            spouse = c;
            c.spouse = this;
            this.deposit(100);
            c.deposit(100);
        }
    }

    public String toString(){
        if (spouse == null){
            return name + "; Role: " + role + "; Balance: " + balance + "; Spouse: null" + "; Level: " + lv;
        }
        else{
            return name + "; Role: " + role + "; Balance: " + balance + "; Spouse: " + this.spouse.name + "; Level: " + lv;
        }
    }
}