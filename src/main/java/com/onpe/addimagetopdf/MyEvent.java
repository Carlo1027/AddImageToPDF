package com.onpe.addimagetopdf;

import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfImage;
import com.itextpdf.text.pdf.PdfIndirectObject;
import com.itextpdf.text.pdf.PdfPageEventHelper;
import com.itextpdf.text.pdf.PdfStamper;

/**
 *
 * @author CCastro
 */
public class MyEvent extends PdfPageEventHelper  {
    
    public static final String IMG = "resources/images/firma.jpg";
    
    public void OnEndPage(PdfStamper stamper, int x) {
        try{
            Image image = Image.getInstance(IMG);
            PdfImage stream = new PdfImage(image, "", null);
            PdfIndirectObject ref = stamper.getWriter().addToBody(stream);
            image.setDirectReference(ref.getIndirectReference());
            image.setAbsolutePosition(180, 400);
            
            Image imgSoc = Image.getInstance(IMG);
            imgSoc.setDirectReference(ref.getIndirectReference());
            imgSoc.setAbsolutePosition(180, 100);
            //image.scaleToFit(110,110);
            for(int i=1;i<=x;i++){
                PdfContentByte over = stamper.getOverContent(i);
                over.addImage(image);
                over.addImage(imgSoc);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
