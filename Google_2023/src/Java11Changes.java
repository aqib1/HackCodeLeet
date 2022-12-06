import com.sealed.test.Apple;

import java.io.File;
import java.io.IOException;
import java.text.NumberFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
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



    }
}
