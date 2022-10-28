import java.util.Iterator;
import java.util.NoSuchElementException;

class Iterator2Array<T> implements Iterator<T> {

    private T[] array;
    private int index = 0;

    public Iterator2Array(T[] array) {
        this.array = array;
    }

    @Override
    public boolean hasNext() {
        return index < array.length;
    }

    @Override
    public T next() {
        if(!hasNext())
            throw new NoSuchElementException();
        return array[index++];
    }
}