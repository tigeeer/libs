package com.wangjx.common.util.image;

import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.encoder.ByteMatrix;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;

/**
 * Created by IntelliJ IDEA.
 * User: tigeeer
 * Date: 2017/1/18
 * Time: 13:57
 */
public class MatrixToImageWriter {
    private static int foreground = 0xFF000000;
    private static int background = 0xFFFFFFFF;

    private MatrixToImageWriter() {
    }

    /**
     * Renders a {@link BitMatrix} as an image, where "false" bits are rendered
     * as white, and "true" bits are rendered as black.
     */
    public static BufferedImage toBufferedImage(BitMatrix matrix) {

        int width = matrix.getWidth();
        int height = matrix.getHeight();
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                image.setRGB(x, y, matrix.get(x, y) ? foreground : background);
            }
        }
        return image;
    }

    /**
     * Renders a {@link ByteMatrix} as an image, as a
     * {@link BufferedImage}. The byte values are construed as (unsigned)
     * luminance values, in theory.
     * However, anything but 0 will be rendered as white, and 0 will be
     * rendered as black.
     */
    public static BufferedImage toBufferedImage(ByteMatrix matrix) {
        int width = matrix.getWidth();
        int height = matrix.getHeight();
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);

        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                image.setRGB(x, y, matrix.get(x, y) == 0 ? foreground : background);
            }
        }
        return image;
    }


    public static void writeImageToFile(BufferedImage bufferedImage, String format, File file) throws IOException {
        ImageIO.write(bufferedImage, format, file);

    }

    /**
     * Writes a {@link BitMatrix} to a file.
     *
     * @see #toBufferedImage(BitMatrix)
     */
    public static void writeToFile(BitMatrix matrix, String format, File file)
        throws IOException {
        BufferedImage image = toBufferedImage(matrix);
        ImageIO.write(image, format, file);
    }


    /**
     * Writes a {@link BitMatrix} to a stream.
     *
     * @see #toBufferedImage(BitMatrix)
     */
    public static void writeToStream(BitMatrix matrix, String format, OutputStream stream)
        throws IOException {
        BufferedImage image = toBufferedImage(matrix);
        ImageIO.write(image, format, stream);
    }

    public static void setBackground(int background) {
        MatrixToImageWriter.background = background;
    }

    public static void setForeground(int foreground) {
        MatrixToImageWriter.foreground = foreground;
    }
}
