package controller;

import java.io.File;
import java.math.BigDecimal;

public class FileSizeChecker {

    public static String getSizeString(File file) {
        long size;
        String notation;
        if (file.isDirectory()) {
            // File is a directory, calculate size of all files in the directory
            size = 0;
            for (File f : file.listFiles()) {

                // Only count if file size <3 GiB
                if( (f.length()) < (3 * (1024L*1024L*1024L)) ) {

                    size += f.length();

                }

            }
        } else {
            // File is a regular file, use size of file
            size = file.length();
        }

        // Conversion
        BigDecimal bsize  = BigDecimal.valueOf(size);
        BigDecimal bytes = BigDecimal.valueOf(size);
        BigDecimal kilobytes = bytes.divide(BigDecimal.valueOf(1024));
        BigDecimal megabytes = kilobytes.divide(BigDecimal.valueOf(1024));
        BigDecimal gigabytes = megabytes.divide(BigDecimal.valueOf(1024));
        BigDecimal terabytes = gigabytes.divide(BigDecimal.valueOf(1024));
        BigDecimal petabytes = terabytes.divide(BigDecimal.valueOf(1024));
        BigDecimal exabytes = petabytes.divide(BigDecimal.valueOf(1024));
        //long zettabytes = (exabytes / 1024);
        //long yottabytes = (zettabytes / 1024);


        if (bsize.compareTo(BigDecimal.valueOf(1024)) < 0) {
            notation = "B";
            //System.out.println(bsize+notation);
        } else if (bsize.compareTo(BigDecimal.valueOf(1024*1024)) < 0) {
            // File is smaller than 1 MB, return size in KB
            bsize = bsize.divide(BigDecimal.valueOf(1024));
            notation = "KB";
            //System.out.println(bsize+notation);
        } else if (bsize.compareTo(BigDecimal.valueOf(1024L*1024L*1024L)) < 0) {
            // File is smaller than 1 GB, return size in MB
            notation = "MB";
            bsize = bsize.divide(BigDecimal.valueOf(1024*1024));
            //System.out.println(bsize+notation);
        } else if (bsize.compareTo(BigDecimal.valueOf(1024L*1024L*1024L*1024L)) < 0) {
            // File is larger than 1 GB, return size in GB
            notation = "GB";
            //System.out.println(bsize+notation);
            bsize = bsize.divide(BigDecimal.valueOf(1024*1024*1024));
            //System.out.println(bsize+notation);
        } else {
            // File is larger than 1 TB, return size in TB
            notation = "TB";
            bsize = bsize.divide(BigDecimal.valueOf(1024L*1024L*1024L*1024L));
            //System.out.println(bsize+notation);
        }

        // Cast size to double before passing it to String.format
        return String.format("[Size: %.3f %s]", bsize.doubleValue(), notation);
    }

}
