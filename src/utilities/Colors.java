package utilities;

import java.awt.*;
import java.util.Random;

/**
 * A utility class which houses the color codes for all colors we are using.
 *
 * @author heshamsalman
 */
public class Colors {

    private static Random r = new Random();

    public static Color[] getRandomColorFamily() {
        colorFamily c = colorFamily.values()[r.nextInt(colorFamily.values().length)];
        switch (c) {
            case RED:
                return redFamily();
            case TEAL:
                return tealFamily();
            case GREEN:
                return greenFamily();
            case PURPLE:
                return purpleFamily();
            case LAVENDER:
                return lavenderFamily();
            case YELLOW:
                return yellowFamily();
            case ORANGE:
                return orangeFamily();
            case BLUE:
                return blueFamily();
            case PINK:
                return pinkFamily();
            default:
                System.out.println("ERROR!");
                return tealFamily();
        }
    }

    /**
     * Family colors return from lightest to darkest. Middle array value is the "base" color.
     * Color families are derived from Paletton.com
     * To add a new family, please generate it from Paletton.
     *
     * @return color family
     */
    private static Color[] redFamily() {
        return new Color[]{new Color(0xFFAAAA), new Color(0xD46A6A), new Color(0xAA3939), new Color(0x801515), new Color(0x550000)};
    }

    private static Color[] tealFamily() {
        return new Color[]{new Color(0x669999), new Color(0x407F7F), new Color(0x226666), new Color(0x0D4D4D), new Color(0x003333)};
    }

    private static Color[] greenFamily() {
        return new Color[]{new Color(0x88CC88), new Color(0x55AA55), new Color(0x2D882D), new Color(0x116611), new Color(0x004400)};
    }

    private static Color[] purpleFamily() {
        return new Color[]{new Color(0x8F78AD), new Color(0x6B4E90), new Color(0x4C2D73), new Color(0x321456), new Color(0x1C053A)};
    }

    private static Color[] lavenderFamily() {
        return new Color[]{new Color(0xAA71A7), new Color(0x8D478A), new Color(0x71266E), new Color(0x550E52), new Color(0x390036)};
    }

    private static Color[] yellowFamily() {
        return new Color[]{new Color(0xFFF58D), new Color(0xFFF163), new Color(0xF6E53E), new Color(0xE2CF11), new Color(0xAE9F06)};
    }

    private static Color[] orangeFamily() {
        return new Color[]{new Color(0xFFD77B), new Color(0xFFCA50), new Color(0xFFBE28), new Color(0xF8AC00), new Color(0xBD8300)};
    }

    private static Color[] blueFamily() {
        return new Color[]{new Color(0x3D71C9), new Color(0x2E61B9), new Color(0x1E52AA), new Color(0x154495), new Color(0x143A7A)};
    }

    private static Color[] pinkFamily() {
        return new Color[]{new Color(0xFACFE6), new Color(0xF09FCB), new Color(0xE274B0), new Color(0xD35098), new Color(0xBC317D)};
    }

    //Blue (V. Dark)
    public static Color unselected() {
        return new Color(0x454951);
    }

    //White
    public static Color selected() {
        return new Color(0xFFFFFF);
    }

    //Orange
    public static Color orange() {
        return new Color(0xEB5D00);
    }


    private enum colorFamily {
        RED,
        TEAL,
        GREEN,
        PURPLE,
        LAVENDER,
        YELLOW,
        ORANGE,
        BLUE,
        PINK
    }
}
