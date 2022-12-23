import java.util.Objects;

interface LLI {
    LLI next();
}
public class LoopInList {
    public boolean hasLoop (LLI lli) {
        LLI slow = lli;
        LLI fast = lli;
        while(!Objects.isNull(slow) &&
                !Objects.isNull(fast) &&
                !Objects.isNull(fast.next())) {
            slow = slow.next();
            fast = fast.next().next();
            if(slow == fast) return true;

        }
        return false;
    }
}
