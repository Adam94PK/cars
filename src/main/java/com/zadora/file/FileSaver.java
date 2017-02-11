package com.zadora.file;

import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

/**
 * Created by adam on 22.01.2017.
 */
public class FileSaver {
    public static void saveFile(MultipartFile file, File filePath) {

        try {
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new
                    FileOutputStream(filePath + "\\" + file.getOriginalFilename()));

            FileCopyUtils.copy(file.getInputStream(), bufferedOutputStream);
            bufferedOutputStream.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
