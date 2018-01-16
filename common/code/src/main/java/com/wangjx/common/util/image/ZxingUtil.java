package com.wangjx.common.util.image;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

/**
 * Created by IntelliJ IDEA.
 * User: tigeeer
 * Date: 2017/1/18
 * Time: 14:03
 */
public class ZxingUtil {

    public static BitMatrix qrCode(String code, int width, int height) {
        QRCodeWriter qrWrite = new QRCodeWriter();

        try {
            return qrWrite.encode(code, BarcodeFormat.QR_CODE, width, height);
        } catch (WriterException e) {
            e.printStackTrace();
            return null;
        }
    }
}
