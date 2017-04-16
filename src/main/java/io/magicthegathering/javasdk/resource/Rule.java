package io.magicthegathering.javasdk.resource;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 *     This class represents one rule of the json field
 *     <em>rulings</em>, which is an array of objects.
 * </p>
 * <p>
 *     One {@link Rule} exists of the following fields:
 *     <table>
 *         <tr>
 *             <th style="border: none; text-align: left;">name</th>
 *             <th style="border: none; text-align: left;">meaning</th>
 *         </tr>
 *         <tr>
 *             <td><code>text</code></td>
 *             <td>The rules text.</td>
 *         </tr>
 *         <tr>
 *             <td><code>date</code></td>
 *             <td>The date when the rule was added to the card.</td>
 *         </tr>
 *     </table>
 * </p>
 *
 * @author Timon Link - timon.link@gmail.com
 */
public class Rule implements Serializable {

    private static final long serialVersionUID = -6400465618108003905L;

    private String text;
    private Date date;

    /**
     * Returns the text of the {@link Rule}.
     * @return The text of the {@link Rule}.
     */
    public String getText() {
        return text;
    }

    /**
     * Sets the text of the {@link Rule}.
     * @param text The text to Set.
     */
    public void setText(String text) {
        this.text = text;
    }

    /**
     * Returns the date of the {@link Rule}.
     * @return The date of the {@link Rule}.
     */
    public Date getDate() {
        return date;
    }

    /**
     * Sets the date of the {@link Rule}.
     * @param date The date to set.
     */
    public void setDate(Date date) {
        this.date = date;
    }


}
