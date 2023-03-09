public class SwitchPatternMatching {

    public static double check (Object o) {
        return switch (o) {
            case Integer i ->  i.doubleValue();
            case String s  && s.length() > 2 && !(s.contains("£") || s.contains(")"))-> Double.parseDouble(s);
            case Double d -> d;
            case null -> 0.0d;
            default -> throw new IllegalStateException("Unexpected value: " + o);
        };
    }

    public static void main(String[] args) {
        System.out.println(check("AMBAJ)"));
    }
}
