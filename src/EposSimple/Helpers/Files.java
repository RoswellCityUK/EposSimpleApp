/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EposSimple.Helpers;

import java.io.File;
import java.util.ArrayList;

/**
 *
 * @author tg
 */
public class Files {
    public static ArrayList<String> listFilesFromFolder(final File folder) {
        ArrayList<String> files = new ArrayList<>();
        for (final File fileEntry : folder.listFiles()) {
                files.add(fileEntry.getName());
        }
        return files;
    }
}
