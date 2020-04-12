/**
 * 
 */
package com.org.service;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.org.model.FinalResponse;
import com.org.model.InputFromUI;
import com.org.repository.MainRepository;

import net.glxn.qrgen.QRCode;
import net.glxn.qrgen.image.ImageType;

/**
 * @author M1041175
 *
 */
@Service
public class MainService {

	@Autowired
	private MainRepository mainResources;
	
	@Autowired
	private JavaMailSender javaMailSender;

	public FinalResponse generateQR(InputFromUI inputFromUI) {
		FinalResponse finalResponse= new FinalResponse();
		String qrFilePath="C:\\qrfile\\"+inputFromUI.getFilename()+".jpg";
		ByteArrayOutputStream outData=QRCode.from(inputFromUI.getQrdata()).to(ImageType.JPG).stream();
		File file= new File(qrFilePath);
		try {
			FileOutputStream fileOutputStream = new FileOutputStream(file);
			try {
				fileOutputStream.write(outData.toByteArray());
				finalResponse.setFileName(qrFilePath);
				finalResponse.setStatus(true);
				fileOutputStream.flush();
				workOnSendsendEmail(inputFromUI.getEmail(),qrFilePath,inputFromUI.getFilename()+".jpg");
			} catch (IOException e) {
				finalResponse.setStatus(true);
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			finalResponse.setStatus(true);
			e.printStackTrace();
		}
		return finalResponse;
	}

	public void workOnSendsendEmail(String emailId,String filePathtoSend,String fileName) {
		MimeMessage mimeMessage = javaMailSender.createMimeMessage();
		MimeMessageHelper mimeMessageHelper = null;
		try {
			mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
		} catch (MessagingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String[] toEmial = { emailId };
		try {
			mimeMessageHelper.setTo(toEmial);
			mimeMessageHelper.setText(
					"Hello \n\nGood News!!!\n\nPlease Find Attached QR File of your's. \n \n \nThanks & Regards,"
							+ "\nAnudeep Kumar Donthu\nQR Code Generator Team");
			mimeMessageHelper.addAttachment(fileName,new File(filePathtoSend) );
			mimeMessageHelper.setSubject("Your QR Code is ready");
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		javaMailSender.send(mimeMessage);

	}

}
