import com.sealed.test.Apple;

import java.io.File;
import java.io.IOException;
import java.text.NumberFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.function.Consumer;
import java.util.stream.Collectors;


public class Java11Changes {

    public static void main(String[] args) throws IOException {

        //Applet tool viewer is removed in java 11 from java 8

        //AWTUtilities (Abstract windows toolkit) is removed in java 11



        //More string methods introduced in java 11 like isBlank, lines
        //repeat, stripLeading, stripTrailing and strip are introduced
        //in java 11
        // Later in java 12 stripIndent was introduced
//        String value = "     There     ";
//        String html = """
//                                <html>
//                                        <body>
//                                        <p>Hello, world</p>
//                                    </body>
//                                 </html>
//                                 """;
//        System.out.println(value.isBlank());
//        System.out.println(value.repeat(2));
//        System.out.println(value.stripLeading());
//        System.out.println(value.strip());
//        System.out.println(value.stripTrailing());
//        System.out.println(value.stripIndent());
//        System.out.println(html.lines().collect(Collectors.joining(",")));
//        System.out.println(html.strip());
//        System.out.println(html.stripIndent());

        // In java 8 modularity feature was not available but introduced in 9
        // Java 11 provide a feature of multi-jar release
        // (originally java 9) which allow coding with the latest feature
        // of java 11 but also have jar compiled in
        // java 8 to support clients. we need to use --release with jdk version
        // to compile code.

        // var was introduced in java 10 and in 11 it supported with lambda
//        Consumer<Integer> lambda = (var t) -> {};

        //Java deployment technologies (to develop applets and deployment) are removed in java 11

        // JMC and JavaFx is not the part of JDK 11 (they are not separate project)

        // In Java 8 there was no suitable method to work with File
        // but Java 11 introduced many methods like writeString, readString
        // isSameFile etc
//        File file = new File("tmp.txt");
//        if(!file.exists()) file.createNewFile();
//        Files.writeString(Paths.get(file.getPath()), "Hi there", StandardOpenOption.APPEND);

//        System.out.println(Files.readString(Paths.get(file.getPath())));

        // asMatchPredicate was introduced in java 11

        // Java 17 changes
//        UserRecords userRecords = new UserRecords(1, "A");
//        System.out.println(userRecords);

//        Object obj = new Apple();
//        if(obj instanceof Apple apple) {
//            System.out.println(apple);
//        }

//        Apple apple = null;
//        apple.test();


//        NumberFormat fmt = NumberFormat.getCompactNumberInstance(Locale.ENGLISH, NumberFormat.Style.LONG);
//        System.out.println(fmt.format(100000000));
//
//        var dtf = DateTimeFormatter.ofPattern("B").withLocale(Locale.ENGLISH);
//
//        System.out.println(dtf.format(LocalTime.of(20,10)));




        // Java 8 changes
        /**
         * 1- forEach support in Iterator
         * 2- Functional Interfaces
         * 3- static and default methods in interface
         * 4- Stream API
         * 5- Lambda expression
         * 6- Collection update with support of stream
         * 7- Concurrent API improvements (newStealingThreadPool)
         * 8- IO updates (Files.list, Files.lines)
         * 9- DateTimeApi
         * **/

        // java 11
        /**
         * 1- Applet Tool Viewer removed
         * 2- JWTUtilities removed
         * 3- JMC and JavaFX removed from JDK 11
         * 4- CMS deprecated and G1GC is default
         * 5- ZGC, Shenandoah GC and No-Opt GC
         * 6- String class with methods isBlank, repeat, lines, strip, stripLeading, stripTrailing and stripIndent
         * 7- Files updated with Files.readString, Files.writeString and Files.isSameFiles
         * 8- Modularity support from java 9
         * 9- var from jdk 10 enhanced by adding support in Lambda
         * 10- Patterns updated with method isMatchedPredicate
         * 11- multi-jar support most important which make you able to add code from different versions of java
         * */

        // java 17
        /**
         * 1- Text Block
         * 2- Switch update with yield and return
         * 3- Records (Just like case classes of scala)
         * 4- sealed, non-sealed & permits
         * 5- Pattern matching of instanceof with auto casting
         * 6- NumberFormat with human-readable formats
         * 7- DateTimeFormat "B" to support day periods
         * 8- Improved NullPointerExceptions with more detailed trace
         * 9- Stream toList to improve toCollect verbose
         * */



        // Java 8
        /**
         * 1- forEach introduced in iterator
         * 2- Functional Interfaces
         * 3- Added support for static and default methods in interface
         * 4- Stream API implementations
         * 5- Lambda support
         * 6- DateAndTime API
         * 8- Collection improved with stream
         * 9- Concurrent API improvements (e.g. newWorkStealingPool)
         * 10- Java IO improvements (e.g. Files.list, Files.lines)
         * */

        // Java 11
        /**
         * 1- Applet Tool Viewer removed
         * 2- JWTUtilities removed
         * 3- Deprecate CMS (Concurrent Mark Sweep), and make G1GC default
         * 4- Removed JMC and JavaFX from JDK 11
         * 5- String class enhanced with methods like isBlank(), lines(), repeat(n), strip(), stringLeading(), stripTrailing(), stringIndent() etc
         * 6- var and enhanced var by adding its support in lambda
         * 7- Added multi-jar support to add jars from older versions and 11 version.
         * 8- Modularity is supported in java 11 from java 9.
         * 9- New GC like ZGC, No-Opt GC and Shenandoah
         * 10- Files is improved with new methods like Files.readString, Files.writeString, Files.isEquals
         * 11- Patterns is improved with support of isMatchPredicate
         * */
        // Java 17
        /**
         * 1- Text block support
         * 2- Switch statement update to support return and yield
         * 3- Records (just like case classes of scala)
         * 4- Sealed classes (Sealed, non-Sealed, permits)
         * 5- NumberFormat to support human-readable numbers
         * 6- DateTimeFormat 'B' to support period of day
         * 7- Impactful NullPointerException with more details
         * 8- Pattern matching and casting for instanceof
         * 9- Stream.toList to avoid verbose of toCollect
         * */



        // How to calculate number of threads needed for a thread pool

        /**
         *
         * thread = No of available cores * target CPU utilization
         * x (1 + wait time / service time)
         * */

        
        List<Integer> li = new ArrayList<>();
        li.add(1);
        Iterator<Integer> it = li.iterator();
        while(it.hasNext()) {
            System.out.println(it.next());

            li.add(23);
        }

    }

    // Optimistic locking

    /**
     * Optimistic locking:
     * In optimistic locking we do not lock our data for read and write
     * but we use versioning or timestamping to validate any dirty read
     * while any other request are updating the same data. whenever read
     * happen, request store timestamp read from database and before updating
     * the value it checks again timestamp if any other request updated that or not
     * . if so request discard this change or re-read.
     * We us optimistic locking in read intensive applications where we know
     * that application will have more read requests as compared to write requests.
     *
     * Pessimistic locking:
     * Pessimistic locking in when we do not allow any other transaction on
     * our data when one transaction is in progress. In this we will strictly apply
     * lock until one transaction finished. In java pessimistic locking can be achieved
     * with synchronization or locks.
     * Pessimistic locking used in write intensive application
     * */
}
