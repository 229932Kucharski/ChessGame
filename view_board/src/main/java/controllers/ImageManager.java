package controllers;

import javafx.stage.FileChooser;
import player.manager.LoginManager;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

public class ImageManager {

    /**
     * Read file .jpg or .png from file and convert it to byte array
     * @return image in byte array
     */
    public static byte[] chooseCoverFromFile() throws IOException {
        byte[] cover;
        FileChooser fileChooser = new FileChooser();
        FileChooser.ExtensionFilter filter = new FileChooser.ExtensionFilter("Image Files", "*.jpg", "*.jpeg");
        fileChooser.setSelectedExtensionFilter(filter);
        fileChooser.setTitle("Choose a cover (.jpg)");
        fileChooser.setInitialDirectory(
                new File(System.getProperty("user.home"))
        );
        File file = fileChooser.showOpenDialog(null);
        if (file == null) {
            return null;
        }
        String fileName = file.toString();
        int index = fileName.lastIndexOf('.');
        if(index > 0) {
            String extension = fileName.substring(index + 1);
            if(!extension.equals("jpg") && !extension.equals("jpeg")) {
                return null;
            }
        }

        cover = ImageManager.imageToByteArray(file.getAbsolutePath());
        byteArrayToImage(LoginManager.getLoggedUser().getLogin(), cover);

        return cover;
    }

    /**
     * Convert image to byte array
     * @param path path to image
     * @return image in byte array
     */
    public static byte[] imageToByteArray(String path) throws IOException {
        File file = new File(path);
        BufferedImage bImage= ImageIO.read(file);
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ImageIO.write(bImage, "jpg", bos);
        return bos.toByteArray();
    }

    /**
     * Convert byte array to iamge
     * @param login login of user
     * @param data image in byte array
     */
    public static void byteArrayToImage(String login, byte[] data) throws IOException {
        ByteArrayInputStream bis = new ByteArrayInputStream(data);
        BufferedImage bImage = ImageIO.read(bis);
        File file = new File("assets/cover/" + login + ".jpg");
        if(!file.exists()) {
            file.mkdirs();
        }
        ImageIO.write(bImage, "jpg", new File("assets/cover/" + login + ".jpg"));
    }


}
