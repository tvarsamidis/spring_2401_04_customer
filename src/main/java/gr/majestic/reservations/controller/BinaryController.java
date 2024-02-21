package gr.majestic.reservations.controller;


import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.font.FontRenderContext;
import java.awt.font.TextLayout;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
public class BinaryController {

    @GetMapping("/image")
    public ResponseEntity<byte[]> getImage() throws IOException {
        Path path = Paths.get("images/red.jpg");
        byte[] imageBytes = Files.readAllBytes(path);

        // Set headers
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_JPEG);
        headers.setContentLength(imageBytes.length);

        // Return image as ResponseEntity
        return new ResponseEntity<>(imageBytes, headers, HttpStatus.OK);

    }


    @GetMapping("/create-image")
    public ResponseEntity<byte[]> createImage() throws IOException {

        int width = 200;
        int height = 200;
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = image.createGraphics();

        // Fill the background with white color
        g2d.setColor(Color.WHITE);
        g2d.fillRect(0, 0, width, height);

        // Draw a red rectangle
        g2d.setColor(Color.RED);
        g2d.fillRect(50, 50, 100, 100);

        String message = "European dynamics";
        Font font = new Font("Arial", Font.PLAIN, 10);
        g2d.setFont(font);
        g2d.setColor(Color.BLACK);

        FontRenderContext frc = g2d.getFontRenderContext();
        TextLayout textLayout = new TextLayout(message, font, frc);
        textLayout.draw(g2d, 50, 100);



        // Dispose Graphics2D
        g2d.dispose();

        // Write BufferedImage to byte array
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(image, "png", baos);
        byte[] imageBytes = baos.toByteArray();

        // Set headers
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_PNG);
        headers.setContentLength(imageBytes.length);

        // Return image as ResponseEntity
        return new ResponseEntity<>(imageBytes, headers, HttpStatus.OK);
    }


}
