package com.ai.SpringAiDemo;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.ai.image.ImageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class GenAiController {


    ImageGenerateService imageGenerateService;
    ChatService chatService;

    public GenAiController(ChatService chatService, ImageGenerateService imageGenerateService) {
        this.chatService = chatService;
        this.imageGenerateService = imageGenerateService;
    }

//    @GetMapping("ask-ai")
//    public  String getResponse(@RequestParam String prompt) {
//        return  chatService.getResponse(prompt);
//    }
//
//    @GetMapping("ask-ai-options")
//    public  String getResponseWithOptions(@RequestParam String prompt) {
//        return  chatService.getResponseOptions(prompt);
//    }

//    @PostMapping("generate-image")
//    public ResponseEntity<String> generateImage(HttpServletResponse response, @RequestParam String prompt, @RequestParam(defaultValue = "" , required = false) String imageStyle) throws IOException {
//        ImageResponse imageResponse = imageGenerateService.generateImage(prompt, imageStyle);
//        String imageURL = imageResponse.getResult().getOutput().getUrl();
//        System.out.println("IMAGE URL: "+imageURL);
//        return new ResponseEntity<>(imageURL, HttpStatus.CREATED);
//        //response.sendRedirect(imageURL);
//    }

    @PostMapping("/generate")
    public void generateImageStream(
            HttpServletResponse response,
            @RequestParam String prompt,
            @RequestParam(defaultValue = "cinematic") String imageStyle
    ) throws IOException {
        byte[] pngBytes = imageGenerateService.generateImageBytes(prompt, imageStyle);
        response.setStatus(HttpStatus.CREATED.value());
        response.setContentType(MediaType.IMAGE_PNG_VALUE);
        response.getOutputStream().write(pngBytes);
    }
}
