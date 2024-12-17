public class MedievalKingdom{

    public static void newDay(){
        // every character levels up each day (cur max level = 5)
        for (int i = 0; i < Character.getCharacters().size(); i++){
            Character.getCharacters().get(i).lvup();
        }
        // stamina of peasants reset
        for (int i = 0; i < Peasant.getPeasants().size(); i++){
            Peasant.getPeasants().get(i).setCurStamina(Peasant.getPeasants().get(i).getMaxStamina());
        }
        //knights get paid each day
        for (int i = 0; i < Knight.getKnights().size(); i++){
            if (Knight.getKnights().get(i).duty()){
                Knight.getKnights().get(i).pay();
            }
        }
        // mana of wizards reset
        for (int i = 0; i < Wizard.getWizards().size(); i++){
            Wizard.getWizards().get(i).setCurMana(Wizard.getWizards().get(i).getMaxMana());
        }
        // attempts of merchants reset
        for (int i = 0; i < Merchant.getMerchants().size(); i++){
            Merchant.getMerchants().get(i).setRemAttempt(Merchant.getMerchants().get(i).getMaxAttempt());
        }
    }
    
    public static void main(String[] args) {
        Peasant sam = new Peasant("Sam");
        Knight dan = new Knight("Dan");
        Merchant minnie = new Merchant("Minnie");
        Wizard bob = new Wizard("Bob");
        Peasant cindy = new Peasant("Cindy");

        int daysElapsed = 0;
        while (Character.kingdomWealth() < 5000){
            daysElapsed++;
            //System.out.println(Character.kingdomWealth());
            bob.buff(minnie);
            bob.buff(sam);
            bob.buff(cindy);
            minnie.makeTool(bob);
            minnie.makeTool(sam);
            minnie.makeTool(cindy);
            dan.dutyOn();
            minnie.trade();
            //System.out.println(Character.kingdomWealth());
            minnie.trade();
            //System.out.println(Character.kingdomWealth());
            minnie.trade();
            //System.out.println(Character.kingdomWealth());
            sam.marry(cindy);
            //System.out.println(Character.kingdomWealth());
            sam.farm();
            sam.farm();
            sam.farm();
            //System.out.println(Character.kingdomWealth());
            cindy.farm();
            cindy.farm();
            cindy.farm();
            //System.out.println(Character.kingdomWealth());
            newDay();
            //System.out.println(daysElapsed);
        }
        System.out.println("Total days elapsed: " + daysElapsed);
    }
}