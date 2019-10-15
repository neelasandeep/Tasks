package com.epam.engx.cleancode.naming.task5;

import com.epam.engx.cleancode.naming.task5.thirdpartyjar.InvalidDirectoryException;
import com.epam.engx.cleancode.naming.task5.thirdpartyjar.InvalidFileTypeException;
import com.epam.engx.cleancode.naming.task5.thirdpartyjar.PropertyUtil;

import java.io.File;
import java.io.FilenameFilter;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public final class FileManager {

    private static final String[] IMAGETYPE = {"jpg", "png"};
    private static final String[] DOCUMENTTYPE = {"pdf", "doc"};

    private String basePath = PropertyUtil.loadProperty("basePath");

    public File retrieveFile(String fileName) {
        validateFileType(fileName);
        final String directoryPath = basePath + File.separator;
        return Paths.get(directoryPath, fileName).toFile();
    }

    public List<String> listAllImages() {
        return files(basePath, IMAGETYPE);
    }

    public List<String> listAllDocumentFiles() {
        return files(basePath, DOCUMENTTYPE);
    }

    private void validateFileType(String fileName) {
        if (isInvalidFileType(fileName)) {
            throw new InvalidFileTypeException("File type not Supported: " + fileName);
        }
    }

    private boolean isInvalidFileType(String fileName) {
        return isInvalidImage(fileName) && isInvalidDocument(fileName);
    }

    private boolean isInvalidImage(String fileName) {
        FileExtPred imageExtensionsPredicate = new FileExtPred(IMAGETYPE);
        return !imageExtensionsPredicate.test(fileName);
    }

    private boolean isInvalidDocument(String fileName) {
        FileExtPred documentExtensionsPredicate = new FileExtPred(DOCUMENTTYPE);
        return !documentExtensionsPredicate.test(fileName);
    }

    private List<String> files(String directoryPath, String[] allowedExtensions) {
        final FileExtPred pred = new FileExtPred(allowedExtensions);
        return Arrays.asList(directory(directoryPath).list(getFilenameFilterByPredicate(pred)));
    }

    private FilenameFilter getFilenameFilterByPredicate(final FileExtPred pred) {
        return new FilenameFilter() {
            @Override
            public boolean accept(File directory, String fileName) {
                return pred.test(fileName);
            }
        };
    }

    private File directory(String directoryPath) {
        File directory = new File(directoryPath);
        validateDirectory(directory);
        return directory;
    }

    private void validateDirectory(File directoryInstance) {
        if (isNotDirectory(directoryInstance)) {
            throw new InvalidDirectoryException("Invalid directory found: " + directoryInstance.getAbsolutePath());
        }
    }

    private boolean isNotDirectory(File directory) {
        return !directory.isDirectory();
    }

}