import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * 事物状态
 * @Author daimt
 * @date 2018/11/1
 **/
public class State implements Iterable<Function>{
    /**
     * 状态标识
     */
    private long id = 0;
    /**
     * 状态名称
     */
    private String name = null;
    /**
     * 当前状态下具有的功能集合
     */
    private List<Function> functions = null;

    private Map<String,Function> functionMap = null;

    public Map<String, Function> getFunctionMap() {
        return functionMap;
    }

    public void setFunctionMap(Map<String, Function> functionMap) {
        this.functionMap = functionMap;
    }

    @Override
    public Iterator<Function> iterator() {
        return functions.iterator();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Function> getFunctions() {
        return functions;
    }

    public void setFunctions(List<Function> functions) {
        this.functions = functions;
    }

    @Override
    public String toString() {
        return id + "\t" + name + "\t" + functions.toString();
    }
}
