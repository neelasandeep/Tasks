package com.epam.engx.cleancode.naming.task5;


import com.epam.engx.cleancode.naming.task5.thirdpartyjar.Predicate;

public class FileExtPred implements Predicate<String> {

    private String[] extention;

    FileExtPred(String[]extention) {
        this.extention = extention;
    }

    @Override
    public boolean test(String fileName) {
        for (String extension : extention) {
            if (fileName.toLowerCase().endsWith(extension)) {
                return true;
            }
        }
        return false;
    }
}
