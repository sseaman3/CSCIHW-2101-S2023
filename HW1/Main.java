package HW1;

public class Main {
    public static void main(String[] args) {
        System.out.println("Start of Main");
        // Create an instance of the Pyramid class and call the Output method (see Pyramid.java for more info)
Pyramid a = new Pyramid();
a.Output();
        // Create an instance of the Adlibs class and call the story method (see Adlibs.java for more info)
Adlibs b = new Adlibs();
b.story("Sarah", 18, "pink");
        // Create an instance of the Replace class and call the charReplace method (see Replace.java for more info)
Replace c = new Replace();
c.charReplace("Hello", 4, 'a');
        

    }
}
