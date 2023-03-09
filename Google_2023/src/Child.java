import java.util.Collections;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;
class c1 extends Child {

}
public class Child extends  Parent{

    public static void main(String[] args) {
        Parent p = new c1();
        p.move();

    }

    @Override
    void move() {
        System.out.println("K");
    }
}
