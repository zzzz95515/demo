package ru.mpei.prob.model.CIMProfile;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import org.hibernate.proxy.pojo.bytebuddy.ByteBuddyInterceptor;
import ru.mpei.prob.model.CIMProfile.IEC61970.Base.Core.IdentifiedObject;

import java.io.IOException;

public class HibernateProxyClassSerializer extends StdSerializer<ByteBuddyInterceptor> {

    public HibernateProxyClassSerializer() {
        this(null);
    }

    public HibernateProxyClassSerializer(Class<ByteBuddyInterceptor> t) {
        super(t);
    }

    @Override
    public void serialize(ByteBuddyInterceptor value, JsonGenerator gen, SerializerProvider provider) throws IOException {
        IdentifiedObject io = (IdentifiedObject) value.getImplementation();
        gen.writeStartObject();
        gen.writeStringField("mRID", io.getMRID());
        gen.writeNumberField("synthesizedSchemeNumber", io.getSynthesizedSchemeNumber());
        gen.writeEndObject();
    }
}
