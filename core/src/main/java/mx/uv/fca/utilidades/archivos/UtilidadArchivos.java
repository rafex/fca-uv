package mx.uv.fca.utilidades.archivos;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class UtilidadArchivos {

    private static final Log LOG = LogFactory.getLog(UtilidadArchivos.class);
    private static final ClassLoader CLASS_LOADER = Thread.currentThread().getContextClassLoader();

    private UtilidadArchivos() {
    }

    public static InputStream classLoader(final String ruta) {

        if (StringUtils.isBlank(ruta))
            return null;

        InputStream is = null;
        try {
            is = CLASS_LOADER.getResourceAsStream(ruta);
        } catch (final NullPointerException e) {
            LOG.error("Error al classLoader el archivo con ruta: " + ruta, e);
            e.printStackTrace();
        }

        return is;

    }

    public static Map<String, String> buscar(final String dir, final String suffix, final int maxDepth) throws IOException {
        final Path start = Paths.get(dir);
        final Stream<Path> stream = Files.find(start, maxDepth, (path, attr) -> String.valueOf(path).endsWith("." + suffix));
        final Map<String, String> map = new HashMap<String, String>();
        stream.sorted().forEach(file -> map.put(file.getFileName().toString(), file.toAbsolutePath().toString()));
        // final String joined =
        // stream.sorted().map(String::valueOf).collect(Collectors.joining(";;"));
        // List<String> listFiles = Arrays.asList(joined.split(";"));
//        map.forEach((k, v) -> System.out.println(v));

        return map;
    }

    public static String leerDocumento(final String file) {
        Path path = Paths.get(file);
        return leerTodasLasLineas(path).toString();
    }

    public static String leerDocumento(final java.io.File file) {
        Path path = file.toPath();
        return leerTodasLasLineas(path).toString();
    }

    private static StringBuilder leerTodasLasLineas(final Path path) {
        final StringBuilder sb = new StringBuilder();
        try {
            final List<String> lines = Files.readAllLines(path);
            lines.forEach(sb::append);
        } catch (final IOException e) {
            e.printStackTrace();
        }
        return sb;
    }

}
