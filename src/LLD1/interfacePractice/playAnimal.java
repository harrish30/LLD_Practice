package LLD1.interfacePractice;

public class playAnimal //PhonePe
{
    private static Animal ani; //RBIAPI
    public playAnimal()
    {
        //can be changed to lion/ rabbit easily
        //upcasting
        ani = new deer(); //RBIAPI = new ICICIBankAPI()/ YesBankAPI();
    }
    public static void doAnimalThings()
    {
        //common functionalities in bank
        ani.drink();
        ani.eat();
        ani.walk();
    }
}
