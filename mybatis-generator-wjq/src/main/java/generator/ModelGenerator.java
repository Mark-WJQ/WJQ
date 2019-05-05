package generator;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.Context;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangjianqiang on 2019/1/2.
 * java 方式生成代码
 */
public class ModelGenerator {

    public static void main( String[] args )  {
        try {
            List<String> warnings = new ArrayList<String>();

            File configFile = new File("/Users/wangjianqiang/IdeaProjects/WJQ/mybatis-generator-wjq/src/main/resources/mybatis-generator.xml");
            ConfigurationParser cp = new ConfigurationParser(warnings);
            Configuration config = cp.parseConfiguration(configFile);

           Context context =  config.getContext("DB2Tables");
            context.getCommentGeneratorConfiguration().setConfigurationType(MySQLCommentGenerator.class.getName());
            context.getJavaTypeResolverConfiguration().setConfigurationType(MyJavaTypeResolverDefault.class.getName());


            DefaultShellCallback callback = new DefaultShellCallback(true);
            MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
            myBatisGenerator.generate(null);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

}
