package com.Ty.Wiki;

import java.io.File;
import java.io.IOException;
import org.testng.annotations.Test;
import com.asprise.ocr.Ocr;

public class FetchTextInImage {
	@Test
	public void start() throws IOException
	{
		Ocr ocr = new Ocr(); // create a new OCR engine
		ocr.startEngine("eng", Ocr.SPEED_FASTEST); // English

		String text = ocr.recognize(new File[] 
				{ 
						new File("C:\\Users\\Pavithra\\Desktop\\log1.png") // path of the image
				},
				Ocr.RECOGNIZE_TYPE_TEXT, Ocr.OUTPUT_FORMAT_PLAINTEXT);
		System.out.println(text);
		ocr.stopEngine(); // Stop OCR engine
	}  
}


