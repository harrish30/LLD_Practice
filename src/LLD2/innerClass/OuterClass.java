package LLD2.innerClass;
public class OuterClass
{
    public void printOuter()
    {
        System.out.println("Hello from outer");
    }
    public void methodForLocalInnerClass()
    {
        System.out.println("Hello from outer");
        class LocalInnerClass
        {
            public void printLocalInner()
            {
                System.out.println("Hello from local inner");
            }
        }
        LocalInnerClass l = new LocalInnerClass();
        l.printLocalInner();
    }
    public class InnerClass
    {
        public void printInner()
        {
            System.out.println("Hello from inner");
        }
    }
    public static class StaticInnerClass
    {
        public void printInner()
        {
            System.out.println("Hello from inner");
        }
    }
}