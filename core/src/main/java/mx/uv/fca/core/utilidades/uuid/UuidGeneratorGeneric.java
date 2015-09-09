package mx.uv.fca.core.utilidades.uuid;

import java.util.UUID;

/**
 * Created by rafex on 08/09/15.
 */
public class UuidGeneratorGeneric {

    public static String generateUuid() {
        return UUID.randomUUID().toString();
    }
}
