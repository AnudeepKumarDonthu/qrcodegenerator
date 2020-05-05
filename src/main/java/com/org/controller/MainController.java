package com.org.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.org.model.FinalResponse;
import com.org.model.InputFromUI;
import com.org.service.MainService;

@RestController
public class MainController {

	@Autowired
	private MainService mainService;

	@RequestMapping(value = "/ping")
	public ResponseEntity<String> pingme() {
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "text/html");
		return new ResponseEntity<String>("I am Available", headers, HttpStatus.OK);
	}

	@RequestMapping(value = "/home")
	public ModelAndView mainPage() {
		return new ModelAndView("/html/home.html", HttpStatus.OK);
	}

	@RequestMapping(value = "/generateqr", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<FinalResponse> generatingQRCode(@RequestBody InputFromUI inputFromUI) {
		FinalResponse finalResponse = new FinalResponse();
		if ((null != inputFromUI.getFilename() || "" != inputFromUI.getFilename())
				&& (null != inputFromUI.getQrdata() || "" != inputFromUI.getQrdata())) {
			finalResponse = mainService.generateQR(inputFromUI);
			return new ResponseEntity<FinalResponse>(finalResponse, HttpStatus.OK);
		} else {
			finalResponse.setStatus(false);
			finalResponse.setFileName(null);
			return new ResponseEntity<FinalResponse>(finalResponse, HttpStatus.BAD_REQUEST);
		}
	}

}
