package com.wangjx.common.util.zip;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * Created by IntelliJ IDEA.
 * User: tigeeer
 * Date: 2017/7/12
 * Time: 11:20
 */
public class ZipUtil {

    private ZipOutputStream zipOutputStream;

    public ZipUtil(OutputStream outputStream) {
        this.zipOutputStream = new ZipOutputStream(outputStream);
    }

    public ZipUtil(OutputStream out, Charset charset) {
        this.zipOutputStream = new ZipOutputStream(out, charset);
    }

    public void push(String name, byte[] data) {
        try {
            zipOutputStream.putNextEntry(new ZipEntry(name));
            zipOutputStream.write(data, 0, data.length);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ZipOutputStream getZipOutputStream() {
        return zipOutputStream;
    }

    public void close() {
        try {
            zipOutputStream.closeEntry();
            zipOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
