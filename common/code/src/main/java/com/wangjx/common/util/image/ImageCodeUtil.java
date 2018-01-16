package com.wangjx.common.util.image;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

/**
 * Created by IntelliJ IDEA.
 * User: tigeeer
 * Date: 2017/1/6
 * Time: 14:30
 */
public class ImageCodeUtil {

    private BufferedImage buffImg = null;

    public ImageCodeUtil(String code) {
        this.createCode(code);
    }

    private void createCode(String code) {
        int codeSize = 25;
        int red, green, blue;
        int codeCount = code.length();
        int width = (codeSize * codeCount) + 10;
        int height = codeSize + 10;

        // image buffer
        buffImg = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D g = buffImg.createGraphics();
        Random random = new Random();
        // set color
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, width, height);
        // set font
        Font font = new Font("TimesRoman", Font.PLAIN, codeSize);
        g.setFont(font);

        int lineCount = (width * height) / 50;

        for (int i = 0; i < lineCount; i++) {
            int x1 = random.nextInt(width);
            int y1 = random.nextInt(height);
            red = random.nextInt(255);
            green = random.nextInt(255);
            blue = random.nextInt(255);
            g.setColor(new Color(red, green, blue));
            g.fillOval(x1, y1, 3, 3);
        }

        for (int i = 0; i < codeCount; i++) {
            red = 0;
            green = 0;
            blue = 0;
            g.setColor(new Color(red, green, blue));
            g.drawString(String.valueOf(code.charAt(i)), (i * codeSize) + 10, codeSize);
        }
    }

    public void write(String path) throws IOException {
        OutputStream sos = new FileOutputStream(path);
        this.write(sos);
    }

    public void write(OutputStream sos) throws IOException {
        ImageIO.write(buffImg, "png", sos);
        sos.close();
    }

    public BufferedImage getBuffImg() {
        return buffImg;
    }
}
