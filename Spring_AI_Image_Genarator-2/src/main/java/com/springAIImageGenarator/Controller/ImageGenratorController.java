package com.springAIImageGenarator.Controller;

import org.springframework.ai.image.Image;
import org.springframework.ai.image.ImageClient;
import org.springframework.ai.image.ImagePrompt;
import org.springframework.ai.image.ImageResponse;
import org.springframework.ai.openai.OpenAiImageOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ImageGenratorController {
	
	@Autowired
	private ImageClient openaiImageClient ;
	
	@GetMapping("/image/{promt}")
	public Image getImage (@PathVariable String promt) {
		
		ImageResponse response = openaiImageClient.call(
		        new ImagePrompt(promt,
		        OpenAiImageOptions.builder()
		                .withQuality("hd")
		                .withN(4)
		                .withHeight(1024)
		                .withWidth(1024).build())

		);
		return response.getResult().getOutput() ;
	}
}
