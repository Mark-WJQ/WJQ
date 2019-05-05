/**
 * 功能
 * @date 2018/11/1
 **/
class Function implements Command{
    /**
     * 功能名称
     */
    private String name = null;
    /**
     * 功能执行器
     */
    private Command command = null;
    /**
     * 下一个状态
     */
    private long next = 0;

    /**
     *
     */
    public Function(){
    }

    /**
     *
     * @param name
     * @param command
     * @param next
     */
    public Function(String name, Command command, long next) {
        this.name = name;
        this.command = command;
        this.next = next;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCommand(Command command) {
        this.command = command;
    }

    public void setNext(long next) {
        this.next = next;
    }

    public String getName() {
        return name;
    }

    public Command getCommand() {
        return command;
    }

    public long getNext() {
        return next;
    }

    @Override
    public String toString() {
        return name + "\t" + next + "\t" + command.getClass().getName();
    }

    /**
     * 执行逻辑
     *
     * @param id
     */
    @Override
    public void execute(long id) {
        command.execute(id);
    }
}
