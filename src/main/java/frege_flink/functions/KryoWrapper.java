package frege_flink.functions;

import java.io.ObjectStreamException;
import java.io.Serializable;


import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;


public class KryoWrapper implements Serializable {

   protected byte[] s;

   public KryoWrapper(Object target) {
      s = toBytes(target);
   }
   
   private static byte[] toBytes(Object obj) {
       Kryo kryo = new Kryo();
       Output output = new Output(512, 2014 * 8);
       kryo.writeClassAndObject(output, obj);
       return output.getBuffer();
   }
   
   protected static Object fromBytes(byte[] bs)  {
       Kryo kryo = new Kryo();
       return kryo.readClassAndObject(new Input(bs));
   }
}
