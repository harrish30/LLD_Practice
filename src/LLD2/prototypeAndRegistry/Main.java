package LLD2.prototypeAndRegistry;

public class Main
{
    public static void main(String[] args)
    {
        Student studentPrototype = new Student("2023", "BatchA", "LLD", "Sandeep", "12-Dec-23", "TTS", "30-Apr-2024");
        System.out.println(studentPrototype);
        Student harrish = studentPrototype.clone();
        System.out.println(harrish);
        harrish.setName("Harrish M");
        harrish.setEmail("harrishmuthu66@gmail.com");
        harrish.setPhoneNumber("9486460239");
        System.out.println(harrish);

        //Since, a single prototype will not work for all the batches, we need to have multiple prototypes for each batch, hence need to maintain this in a datastructure

        //Registry Design pattern comes into play as it contains a hashmap, that stores all the prototypes of a class, which can be fetched using a specific key, whenever required
        Student studentPrototypeBatchA = new Student("2023", "BatchA", "HLD", "Sandeep", "12-June-23", "MWF", "30-Apr-2024");
        Student studentPrototypeBatchB = new Student("2023", "BatchB", "LLD", "naman", "12-Dec-23", "TTS", "30-June-2024");
        Student studentPrototypeBatchC = new Student("2024", "BatchC", "DSA", "mohit", "12-Jan-24", "MWF Morning", "30-Dec-2024");
        StudentRegistry studentRegistry = new StudentRegistry();
        studentRegistry.add(studentPrototypeBatchA);
        studentRegistry.add(studentPrototypeBatchB);
        studentRegistry.add(studentPrototypeBatchC);

        //enrolling vasanthan
        Student vasanthan = studentRegistry.get("BatchB").clone();
        vasanthan.setName("Vasanthan A");
        vasanthan.setEmail("vasanthansafasf@gmail.com");
        vasanthan.setPhoneNumber("1234567890");
        System.out.println(vasanthan);
    }
}
