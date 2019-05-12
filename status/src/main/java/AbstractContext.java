import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * 状态上下文
 * @date 2018/11/1
 **/
public abstract class AbstractContext {
    /**
     * 状态集合
     */
    private Map<Long,State> states = new HashMap<>();

    private Table<Long,String,State> stateTable = HashBasedTable.create();

    /**
     *
     */
    public AbstractContext(){
        init(states);
    }

    /**
     * 转换状态
     * @param id 数据标识,当前状态标识
     * @param funcName 功能名称
     */
    public void transform(long id,String funcName){
        long num = queryState(id);
        State state = states.get(num);
        for (Function f : state){
            if (funcName.equals(f.getName())){
                f.execute(id);
                updState(id,f.getNext());
                return;
            }
        }
        throw new UnsupportedOperationException("");
    }


    /**
     * 转换状态
     * @param id 数据标识,当前状态标识
     * @param name 当前执行标识，跟id共同确定当前状态
     *
     * @param funcName 功能名称，下一步执行操作
     * @param consumeId 订单id
     */
    public void transform(String name,String funcName,Long consumeId){
        long num = queryState(consumeId);
        State state = stateTable.get(name,num);
        Function function = state.getFunctionMap().get(funcName);
        if (Objects.nonNull(funcName)) {
            function.execute(consumeId);
            updState(consumeId,function.getNext());
            return;
        }
        throw new UnsupportedOperationException("");
    }


    /**
     * 初始化状态组
     * @param states
     */
    protected abstract void init(Map<Long,State> states);

    /**
     * 查询订单状态
     * @param id
     * @return
     */
    protected abstract long queryState(long id);


    /**
     * 修改订单状态
     * @param id 订单id
     * @param state 状态
     */
    protected abstract void updState(long id,long state);
}
