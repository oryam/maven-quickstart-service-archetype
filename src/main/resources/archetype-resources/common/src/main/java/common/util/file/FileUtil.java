#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.common.util.file;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class FileUtil {

    private static final Logger LOG = LoggerFactory.getLogger(FileUtil.class);

    private FileUtil() {
        // it is a private constructor because this class has only static methods
    }

    public static String read(final String classpath) {
        String message = null;
        try {
            final URI uri = ClassLoader.getSystemResource(classpath).toURI();
            message = new String(Files.readAllBytes(Paths.get(uri)));
        } catch (URISyntaxException | IOException e) {
            LOG.error(String.format("Unable to read file %s", classpath), e);
        }
        return message;
    }

    public static String readInline(final String classpath) {
        return inline(read(classpath));
    }

    private static String inline(final String multiline) {
        final String[] lines = Arrays.stream(multiline.split("[${symbol_escape}${symbol_escape}r${symbol_escape}${symbol_escape}n]+"))
                                     .map(line -> line.trim())
                                     .toArray(String[]::new);
        return String.join("", lines);
    }

    public static String template(final String classpath, final Map<String, String> params) {
        String replacement = read(classpath);
        for (String key : params.keySet()) {
            replacement = replacement.replace(new StringBuilder().append("{").append(key).append("}").toString(),
                                              params.get(key));
        }
        return replacement;
    }

    public static String appendForderSeparator(final String path) {
        final StringBuilder result = new StringBuilder(path);
        if (!path.endsWith("/") && !path.endsWith(File.separator)) {
            result.append(File.separator);
        }
        return result.toString();
    }
}
