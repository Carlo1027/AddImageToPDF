package com.onpe.addimagetopdf;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author CCastro
 */
public class AddImageWithId {
    public static final String SRC = "resources/uno.pdf";
    public static final String DEST = "results/new.pdf";
    
    public static void main(String[] args) throws IOException, DocumentException {
        File file = new File(DEST);
        file.getParentFile().mkdirs();
        new AddImageWithId().manipulatePdf(SRC, DEST);
    }

    public void manipulatePdf(String src, String dest) throws IOException, DocumentException {
        PdfReader reader = new PdfReader(src);        
        PdfStamper stamper = new PdfStamper(reader, new FileOutputStream(dest));
        MyEvent mievent = new MyEvent();
        mievent.OnEndPage(stamper, reader.getNumberOfPages());
        stamper.close();
        reader.close();
    }
    
}