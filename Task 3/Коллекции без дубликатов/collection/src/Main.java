import java.util.Collection;
import java.util.HashSet;

class ColNonDub {
    public static <T> Collection<T> removeDuplicates(Collection<T> collection) {
        return new HashSet<>(collection);
    }
}