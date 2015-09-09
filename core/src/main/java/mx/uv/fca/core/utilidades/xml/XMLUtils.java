package mx.uv.fca.core.utilidades.xml;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.StringWriter;

/**
 * Created by rafex on 09/09/15.
 */
public class XMLUtils {

    public static Object xml(Object mensaje) {
        try {
            final JAXBContext jaxbContext = JAXBContext.newInstance(mensaje.getClass());
            final Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            // output pretty printed
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            final StringWriter sw = new StringWriter();
            jaxbMarshaller.marshal(mensaje, sw);
            return sw;
        } catch (final JAXBException e) {
            throw new UnsupportedOperationException("Error al convertir el objeto en XML : " + e);
        }

    }
}
