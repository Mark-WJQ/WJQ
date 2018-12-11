/**
 * 停止
 * @Author daimt
 * @date 2018/11/1
 **/
public class StopCommand implements Command {
    @Override
    public void execute(long id) {
        System.out.println("--------------------- stop -----------------------");
    }
}
