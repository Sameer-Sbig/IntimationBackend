package com.sbigeneral.PINS.Utill;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

import org.apache.commons.codec.binary.Base64;
import org.apache.logging.log4j.LogManager;import org.apache.logging.log4j.Logger;

public class ZipUtil
{
  private static final Logger logger = LogManager.getLogger(ZipUtil.class);
  //static List<String> filesListInDir = new ArrayList<String>();
  public static List<File> unZipfile(String zipFile, String outputFolder)
  {
    logger.debug("start of unZipIt :" + zipFile + ";  outputFolder : " + outputFolder);
    byte[] buffer = new byte[1024];
    List csvFileList = new ArrayList();
    File csvFile = null;
    ZipInputStream zis = null;
    FileOutputStream fos = null;
    int count = 1;
    try
    {
      File folder = new File(outputFolder);
      if (!folder.exists()) {
        folder.mkdir();
      }

      logger.debug("inside try");
      zis = new ZipInputStream(new FileInputStream(zipFile));

      ZipEntry ze = zis.getNextEntry();
      logger.debug("Before while " + ze);
      while (ze != null)
      {
        logger.debug("inside while");
        String fileName = ze.getName();
        String[] tempName = fileName.split("\\.");
        logger.debug("tempName " + tempName[0] + "   " + tempName[1]);
        fileName = tempName[0] + System.currentTimeMillis() + "." + tempName[1];

        csvFile = new File(outputFolder + File.separator + fileName);

        logger.debug("file unzip : " + csvFile.getAbsoluteFile());

        int i = fileName.lastIndexOf('.');
        String extension = null;
        if (i > 0) {
          extension = fileName.substring(i + 1);
        }
        if (!extension.equalsIgnoreCase("csv")) {
          csvFile.delete();
          csvFile = null;
          logger.error("File not in csv format" + fileName);
        }
        else
        {
          fos = new FileOutputStream(csvFile);
          int len;
          while ((len = zis.read(buffer)) > 0) {
            fos.write(buffer, 0, len);
          }

          fos.close();
          csvFileList.add(csvFile);
          count++;
        }
        ze = zis.getNextEntry();
      }

      zis.closeEntry();
      zis.close();

      logger.debug("Done");
    }
    catch (IOException ex)
    {
      try
      {
        if (fos != null)
        {
          fos.close();
          fos = null;
        }
      } catch (IOException e) {
        e.printStackTrace();
      }

      boolean isCSVFileDeleted = csvFile.delete();
      logger.info("File CSV Deleted ? = " + isCSVFileDeleted);
      csvFile = null;
      logger.error("exp is : " + ex.getMessage());
    }
    finally
    {
      try
      {
        zis.close();
        if (fos != null)
        {
          fos.close();
          fos = null;
        }
      }
      catch (IOException e)
      {
      }
    }

    return csvFileList;
  }

  public static void zipfile(String zipFileName, File errorFile)
  {
    byte[] buffer = new byte[1024];
    System.out.println("STart of zipFIle " + zipFileName);
    try
    {
      String destDir = errorFile.getParent();
      System.out.println("destDir :" + destDir + " file is" + errorFile.getName());
      FileOutputStream fos = new FileOutputStream(destDir + "/" + zipFileName);
      ZipOutputStream zos = new ZipOutputStream(fos);
      ZipEntry ze = new ZipEntry(errorFile.getName());
      zos.putNextEntry(ze);
      FileInputStream in = new FileInputStream(errorFile);
      int len;
      while ((len = in.read(buffer)) > 0) {
        zos.write(buffer, 0, len);
      }

      in.close();
      zos.closeEntry();

      zos.close();
    }
    catch (IOException ex)
    {
      ex.printStackTrace();
    }
  }

  public static String createZipFile(List<String> filePaths, String fileNamePath) throws FileNotFoundException, IOException {
		fileNamePath = fileNamePath.replace(".pdf", "");
		String zipFileName = fileNamePath + ".zip";
		FileOutputStream fos = null;
		ZipOutputStream zipOut = null;
		FileInputStream fis = null;

		try {
			fos = new FileOutputStream(zipFileName);
			zipOut = new ZipOutputStream(new BufferedOutputStream(fos));
			for (String filePath : filePaths) {
				File input = new File(filePath);
				fis = new FileInputStream(input);
				ZipEntry ze = new ZipEntry(input.getName());
				logger.info("Zipping the file: " + input.getName());
				zipOut.putNextEntry(ze);
				byte[] tmp = new byte[4 * 1024];
				int size = 0;
				while ((size = fis.read(tmp)) != -1) {
					zipOut.write(tmp, 0, size);
				}
				zipOut.flush();
				fis.close();
			}
			zipOut.close();
			logger.info("Done... Zipped the files...");
		} catch (FileNotFoundException e) {
			logger.error("Exception File Not Found", e);
			throw e;
		} catch (IOException e) {
			throw e;
		} finally {
			try {
				if (fos != null)
					fos.close();
			} catch (Exception ex) {
				logger.error("Exception Occured : ", ex);
			}

		}

		return zipFileName;
	}
  /**
   * This method zips the directory
   * @param dir
   * @param zipDirName
   */
  public static String zipDirectory(File dir, String zipDirName) {
      try {
//          populateFilesList(dir);
          File[] files = dir.listFiles();
          List<String> filesListInDir = new ArrayList<String>();
          for(File file : files){
              if(file.isFile()) filesListInDir.add(file.getAbsolutePath());
          }
          //now zip files one by one
          //create ZipOutputStream to write to the zip file
          FileOutputStream fos = new FileOutputStream(zipDirName);
          ZipOutputStream zos = new ZipOutputStream(fos);
          
          for(String filePath : filesListInDir){
              System.out.println("Zipping "+filePath);
              //for ZipEntry we need to keep only relative file path, so we used substring on absolute path
              ZipEntry ze = new ZipEntry(filePath.substring(dir.getAbsolutePath().length()+1, filePath.length()));
              zos.putNextEntry(ze);
              //read the file and write to ZipOutputStream
              FileInputStream fis = new FileInputStream(filePath);
              byte[] buffer = new byte[1024];
              int len;
              while ((len = fis.read(buffer)) > 0) {
                  zos.write(buffer, 0, len);
              }
              zos.closeEntry();
              fis.close();
          }
          zos.close();
          fos.close();
      } catch (IOException e) {
          e.printStackTrace();
      }
	return zipDirName;
  }
  /**
   * This method populates all the files in a directory to a List
   * @param dir
   * @throws IOException
   */
  private static  void populateFilesList(File dir) throws IOException {
	
//      File[] files = dir.listFiles();
//      for(File file : files){
//          if(file.isFile()) filesListInDir.add(file.getAbsolutePath());
//          else populateFilesList(file);
//      }
  }
  
  public static void main(String[] args)
  {
    System.out.println("Zipping file");
  }
  public static String convertZipFileToBaseEncodeString(File originalFile) {
		
		String encodedBase64 = null;
		try {
			try (FileInputStream fileInputStreamReader = new FileInputStream(originalFile)) {
				byte[] bytes = new byte[(int) originalFile.length()];
				fileInputStreamReader.read(bytes);
				encodedBase64 = new String(Base64.encodeBase64(bytes));
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return encodedBase64;

	}
  
}