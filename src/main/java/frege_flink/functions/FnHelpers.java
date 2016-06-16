package frege_flink.functions;

import frege.run7.Func;
import frege.run7.Box;
import org.apache.flink.api.common.functions.MapFunction;

import java.io.Serializable;

public final class FnHelpers {

    public static <A, B> MapFunction<A, B> lambdaToMapFn(final Func.U<A, B> f) {

        return new MapFunction<A, B>() {
            public B map(A x) throws Exception {
                return f.apply(new Box<A>(x)).call();
            }
        };
    }
    
    public static MapFunction<String, String> appendExcl = new MapFunction<String, String>() {
        @Override
        public String map(String x) throws Exception {
            return x + "!";
        }
    };
}
