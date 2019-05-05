/**
 * 系统命令
\ * @date 2018/11/1
 **/
public interface Command {
    /**
     * 执行逻辑
     * @param id
     */
    public void execute(long id);
}
