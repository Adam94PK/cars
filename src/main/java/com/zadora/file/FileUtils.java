package com.zadora.file;

import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.net.URLConnection;

/**
 * Created by adam on 22.01.2017.
 */
public class FileUtils {

    public void saveFile(MultipartFile file, File filePath) {

        filePath.setWritable(true);

        if (!filePath.exists()) {
            filePath.mkdirs();
        }

        FileSaver.saveFile(file, filePath);

    }

    public boolean deleteFile(File file) {

        if (file.exists()) {

            if (file.delete()) {
                return true;
            }
        }

        return false;
    }

    public String getFileMimeType(String filename) {
        String mimeType = URLConnection.guessContentTypeFromName(filename);

        if (mimeType == null) {
            mimeType = "application/octet-stream";
        }

        return mimeType;
    }

    public String getFileExtension(String filename) {
        String[] fileArray = filename.split("\\.");

        return fileArray[fileArray.length - 1];
    }

    public File createFolderPath(String requestPath, String folderPath) {
        return new File(requestPath + "/" + folderPath);
    }

    public File createFilePath(String requestPath, String folderPath, String filename) {
        return new File(requestPath + "/" + folderPath + "/" + filename);
    }
}
