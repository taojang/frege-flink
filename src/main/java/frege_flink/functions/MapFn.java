package frege_flink.functions;

import org.apache.flink.api.common.functions.MapFunction;

import frege.run7.Box;
import frege.run7.Func;
import frege.run7.Func.U;

public class MapFn<A, B> extends KryoWrapper implements MapFunction<A,B> {
    
    public MapFn(Func.U<A, B> f) {
        super(f);
    }

    @Override
    public B map(A x) throws Exception {
        @SuppressWarnings("unchecked")
        Func.U<A, B> f = (U<A, B>) fromBytes(s);
        return f.apply(new Box<A>(x)).call();
    } 
}