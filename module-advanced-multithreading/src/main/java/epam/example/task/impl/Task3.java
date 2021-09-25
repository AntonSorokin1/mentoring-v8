package epam.example.task.impl;

import epam.example.task.Task;
import epam.example.util.FileScanner;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Task3 implements Task {

  public static final URL PATH_ADAPTIVE = Task3.class.getClassLoader().getResource("test");

  @Override
  public void start() {
    Path path = Paths.get(PATH_ADAPTIVE.toString().substring(6));
    System.out.println(path);
    FileScanner scanner = new FileScanner();
    try {
      List<Path> pathList = scanner.scanDirectory(path);
      System.out.format("Number of files = %d%n", scanner.fileCount(pathList));
      System.out.format("Number of directories = %d%n", scanner.directoryCount(pathList));
      System.out.format("Size of all files = %d%n", scanner.getFilesSize(pathList));
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
