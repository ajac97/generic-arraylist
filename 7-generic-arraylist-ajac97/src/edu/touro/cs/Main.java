package edu.touro.cs;
import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.*;

enum DaysOfWeek {Sunday("Yom Rishon"), Monday(""), Tuesday(""), Wednesday(""), Thursday(""), Friday(""), Saturday("");

    private final String hebrewName;

    DaysOfWeek(String s) {
        hebrewName = s;
    }

    public String toString()
    {
        return super.toString() + " " + hebrewName;
    }

    public void foo(){}
}
class UniversalSystem
{
    static {
        // startup geospatial engine
        // get distance from geospatialengine
        distanceFromSun = 92_136_736_439l;
    }
    private static final double distanceFromSun;
}

class CountUntil10Iterator implements Iterator<String>
{
    private int counter = 0;
    @Override
    public boolean hasNext() {
        return counter < 10;
    }

    @Override
    public String next() {
        return counter++ + "";
    }
}
class Placeholder implements Iterable<String>
{
    @Override
    public Iterator<String> iterator() {
        return new CountUntil10Iterator();
    }
}
public class Main {
    public static void main(String[] args) throws FileNotFoundException { // entry point...pass through args the command line arguments (from OS)
        MyGenericArrayList<Integer> gl = new MyGenericArrayList<>(); // diamond operator
        gl.add(87);
        int x = gl.get(0);

        //        for(String s : args) // for each
//                // Effective Java Josh Bloch
//                // index out of bounds impossible
//                // simpler
//                // read only
//
//        {
//            String inputFileName = args[0];
//           // Scanner sc = new Scanner(new File(inputFileName));
//
//
//            System.out.println(s);
//            s = "Bob";
//        }
//        System.out.println(max(6,3,7,3,7,9,7,4,-2,7,4,7,4,2,75,89,1,38,6657,25,2,24));
        //oom();

//        Placeholder ph = new Placeholder();
//        for (String s : ph ) {
//            System.out.println(s);
//        }

        ArrayList<Integer> ial = new ArrayList<>();
        for (int i=0;i<10;i++) // wrapper // immutable
            ial.add(i); // auto-boxing

        System.out.println("Size:" + ial.size());

        for (Iterator<Integer> iterator = ial.iterator(); iterator.hasNext(); ) {
            int i = iterator.next(); // collection is "locked" during iteration
            System.out.println(i);
            if (i == 5) {
                ial.remove(5);
                //it.remove();
            }
        }
        System.out.println("Size:" + ial.size());


    }
//
//    public static int max(int a, int b)
//    {
//        return  a > b ? a: b;
//    }
//
//    public static int max(int a, int b, int c)
//    {
//        int max1 = max(a,b);
//        return   max1 > c ? max1: c;
//    }
//    public static int max(int a, int b, int c, int d)
//    {
//        int max1 = max(a,b);
//        int max2 = max(c,d);
//        return   max(max1, max2);
//    }

    public static int max(int ... list) // var args
    {
//        Arrays.sort(list); // horrendously EXPENSIVE O(n log n), 1,000,000 x 20
//        return list[list.length - 1];
        int max = list[0];
        for (int i=1;i<list.length;i++) // O(n)
        {
            if (list[i] > max)
            {
                max = list[i];
            }
        }
        return  max;
    }

    public static void oom()
    {
        ArrayList<String>  al = new ArrayList<>(1_000_000);
        int i = 0;
        while (true)
            al.add( i++ + "");
    }
}
