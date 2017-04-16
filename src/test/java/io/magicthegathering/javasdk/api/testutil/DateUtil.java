package io.magicthegathering.javasdk.api.testutil;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * <p>
 *     This class is a helper util for test classes. It offers methods
 *     to work with {@link Date dates}.
 * </p>
 *
 * @author Timon Link - timon.link@gmail.com
 */
public class DateUtil {

    /**
     * <p>
     *     Creates a {@link Date date} from the given String.
     * </p>
     * <p>
     *     The given String must be in the format <code>yyyy-MM-dd</code>.
     * </p>
     *
     * @param dateString The string to create the {@link Date date} from.
     * @return The converted {@link Date date}.
     *
     * @throws ParseException when the given String couldn't be parsed.
     */
    public static Date fromString(String dateString) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        return sdf.parse(dateString);
    }

}
