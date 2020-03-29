package junit5;

import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.support.AnnotationConsumer;

import java.util.stream.Stream;

public class TestBeanProvider implements ArgumentsProvider, AnnotationConsumer<TestBeanSource> {

     public Stream<? extends Arguments> provideArguments(org.junit.jupiter.api.extension.ExtensionContext context) throws Exception {
        return null;
    }


    @Override
    public void accept(TestBeanSource testBeanSource) {







    }
}
