package LLD2.innerClass;
public class Main
{
    public static void main(String args[])
    {
        //inner class
        OuterClass o = new OuterClass();
        o.printOuter();
        OuterClass.InnerClass i = o.new InnerClass();
        i.printInner();
        //static inner class
        OuterClass.StaticInnerClass j = new OuterClass.StaticInnerClass();
        j.printInner();
        //local inner class
        OuterClass o1 = new OuterClass();
        o1.methodForLocalInnerClass();
    }
}