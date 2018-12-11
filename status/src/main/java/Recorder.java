import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Map;

/**
 * 录音机
 * @Author daimt
 * @date 2018/11/1
 **/
public class Recorder extends AbstractContext{

    /**
     *
     */
    private static XStream xstream = new XStream();

    static {
        xstream.alias("recorder", List.class);
        xstream.alias("state", State.class);
        xstream.alias("fun", Function.class);

        xstream.useAttributeFor(State.class, "id");
        xstream.useAttributeFor(State.class, "name");

        xstream.addImplicitCollection(State.class, "functions");

        xstream.addImplicitMap(State.class,"functionMap",Function.class,"name");

        xstream.registerConverter(new Converter() {
            @Override
            public void marshal(Object source, HierarchicalStreamWriter writer, MarshallingContext marshallingContext) {
                Function fun = (Function) source;
                writer.addAttribute("name", fun.getName());
                writer.addAttribute("next", String.valueOf(fun.getNext()));
                writer.setValue(fun.getCommand().getClass().getName());
            }

            @Override
            public Object unmarshal(HierarchicalStreamReader reader, UnmarshallingContext context) {
                Function fun = new Function();
                fun.setName(reader.getAttribute("name"));
                fun.setNext(Long.parseLong(reader.getAttribute("next")));
                try {
                    fun.setCommand((Command) Class.forName(reader.getValue().trim()).newInstance());
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return fun;
            }

            @Override
            public boolean canConvert(Class clazz) {
                return clazz == Function.class;
            }
        });
    }

    @Override
    protected void init(Map<Long, State> states) {
        List<State> list = (List<State>) xstream.fromXML(Recorder.class.getResource("/recorder_state.xml"));
        for (State s : list) {
            states.put(s.getId(),s);
        }
        System.out.println(states);
    }

    @Override
    protected long queryState(long id) {
        String line = null;
        try(BufferedReader br = new BufferedReader(new InputStreamReader(Recorder.class.getResourceAsStream("/test_data")))){
            while((line = br.readLine()) != null){
                String[] ds = line.trim().split(",");
                if(Long.parseLong(ds[0]) == id){
                return Long.parseLong(ds[1]);
            }
        }
    }catch (Exception e){
        e.printStackTrace();
        }
        return -1;
    }


    @Override
    protected void updState(long id, long state) {

    }

    public static void main(String[] args) throws Exception {
        System.out.println(new Recorder()); ;

    }
}
