package com.Ty.Wiki;

import java.io.File;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

public class TextFromImage {
	public static void main(String[] args) throws TesseractException {
		
		ITesseract image=new Tesseract();
		String str = image.doOCR(new File("C:\\Users\\Pavithra\\Desktop\\log1.png"));
		System.out.println(str);
	}

}
