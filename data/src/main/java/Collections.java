import java.util.Arrays;
import java.util.List;

/**
 * Created by Administrator on 2017/3/8.
 */
public class Collections<T> {

    private static final Object[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {};

    private static int default_size = 16;
    private int size;
    private Object[] ts;

    public int getSize() {
        return size;
    }

    public Collections() {
        ts = new Object[default_size];
    }

    public void insert(T t){
        if(size +1 > ts.length) {
            int oldCapacity = ts.length;
            int newCapacity = oldCapacity + (oldCapacity >> 1);

           ts =  Arrays.copyOf(ts,newCapacity);
        }
        ts[size++] = t;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public void makeEmpty(){
        size = 0;
        this.ts = new Object[default_size];
    }

    public void remove(int i){
        if (i > size)
            return;
        int numMove = size - i - 1;
        if (numMove > 0)
            System.arraycopy(ts,i+1,ts,i,numMove);
        ts[size -- ] = null;
    }

    public boolean isPresent(Object t){
        if (t == null){
            for (Object o : ts) {
                if (o == null)
                    return true;
            }
        }
        for (Object o : ts) {
            if (t.equals((T) o)) {
                return true;
            }
        }
        return false;
    }

}
