package com.ai.SpringAiDemo;

import org.springframework.ai.image.ImageGeneration;
import org.springframework.ai.image.ImagePrompt;
import org.springframework.ai.image.ImageResponse;
import org.springframework.ai.stabilityai.StabilityAiImageModel;
import org.springframework.ai.stabilityai.api.StabilityAiImageOptions;
import org.springframework.stereotype.Service;

import java.util.Base64;

@Service
public class ImageGenerateService {

    private final StabilityAiImageModel stabilityAiImageModel;

    public ImageGenerateService(StabilityAiImageModel stabilityAiImageModel) {
        this.stabilityAiImageModel = stabilityAiImageModel;
    }

    public byte[] generateImageBytes(String imagePrompt, String imageStyle) {
        ImagePrompt prompt = new ImagePrompt(
                imagePrompt,
                StabilityAiImageOptions.builder()
                        .N(1)                          // request 1 image
                        .width(1024)                   // set width
                        .height(1024)                  // set height
                        .responseFormat("url")         // ask specifically for a URL
                        .stylePreset(imageStyle)      // e.g. “cinematic”
                        .build()
        );
        ImageResponse imageResponse = stabilityAiImageModel.call(prompt);

        ImageGeneration img = imageResponse.getResult();

        String b64 = img.getOutput()
                .getB64Json();
        // decode it to bytes
        return Base64.getDecoder().decode(b64);




//        ImageResponse response = stabilityAiImageModel.call(
//                new ImagePrompt(imagePrompt,
//                        StabilityAiImageOptions.builder()
//                                .stylePreset(imageStyle)
//                                .N(1)
//                                .height(1024)
//                                .width(1024).build())
//
//        );
//        System.out.println("=== raw ImageResponse ===");
//        System.out.println(response);
//        System.out.println("=========================");
    }
}