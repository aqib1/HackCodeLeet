
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.function.BiConsumer;

public class Java8PlugableAnnotations {
    @Target(value = ElementType.TYPE_USE)
    @interface NonNull  {

    }

    @Target(value = ElementType.TYPE_USE)
    @interface English  {

    }

    @Target(value = ElementType.TYPE_USE)
    @interface ReadOnly  {

    }


    class NonNullString {
        Set<@NonNull String> set = new HashSet<>();

        // A read-only array of non-null array of english words
        @English String  @ReadOnly[] @NonNull[] a;
    }


    public static void main(String[] args) {

//        BiConsumer<String, String> t = (@NonNull String s, String s1) -> {
//            @NonNull String test = "There";
//            System.out.println(test + s + s1);
//        };
//
//
//        int [] arr = new int[Short.MAX_VALUE * 100];
//        int i = 0;
//        for(int x = Short.MAX_VALUE * 100 - 1; x >= 0; x--) {
//            arr[i++] = x;
//        }
//
//        long start = System.currentTimeMillis();
//        Arrays.parallelSort(arr);
//        long end = System.currentTimeMillis() - start;
//        System.out.println("Time taken : "+ end);


        System.out.println(Java8PlugableAnnotations.class.getNestHost());
        System.out.println(Arrays.toString(Java8PlugableAnnotations.class.getNestMembers()));
        System.out.println(Java8PlugableAnnotations.NonNull.class.isNestmateOf(Java8PlugableAnnotations.class));

    }
}
