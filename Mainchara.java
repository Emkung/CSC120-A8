public class Mainchara extends mc{
    public Mainchara(String name,int speed,boolean canFly, int attack, int hp, int iq){
        this.name = name;
        this.speed = speed; 
        this.canFly = canFly;
        this.attack = attack;
        this.hp = hp;
        this.iq = iq;
    }
    public static void main(String[] args) {
        Mainchara Mymc= new Mainchara("Steven",speed, false, attack, hp, iq);
        Mymc.grab("Water of the Fountain of Youth");
        Mymc.examine("Water of the Fountain of Youth");
        Mymc.use("Water of the Fountain of Youth");
    }

}
