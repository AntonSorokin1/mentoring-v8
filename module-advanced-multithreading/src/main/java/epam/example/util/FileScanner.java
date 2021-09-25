package epam.example.util;

import static java.nio.file.Files.walk;
import static java.util.stream.Collectors.toList;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Stream;

public class FileScanner {

  public List<Path> scanDirectory(Path path) throws IOException {
    try (Stream<Path> pathStream = walk(path)) {
      return pathStream.collect(toList());
    }
  }

  public Long directoryCount(List<Path> pathList) {
    return pathList.stream()
        .filter(Files::isDirectory)
        .count();
  }

  public Long fileCount(List<Path> pathList) {
    return pathList.stream()
        .filter(Files::isRegularFile)
        .count();
  }

  public Long getFilesSize(List<Path> pathList) {
    return pathList.parallelStream()
        .filter(Files::isRegularFile)
        .map(Path::toFile)
        .mapToLong(File::length)
        .sum();
  }
}
