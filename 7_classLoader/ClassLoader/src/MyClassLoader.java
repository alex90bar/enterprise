import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class MyClassLoader extends ClassLoader{


  @Override
  protected Class<?> findClass(String name) throws ClassNotFoundException {
    Path path = Path.of("./Test.class");
    try {
      byte[] bytes = Files.readAllBytes(path);
      return this.defineClass("Test", bytes, 0, bytes.length);
    } catch (IOException e) {
      e.printStackTrace();
      throw new ClassNotFoundException();
    }
  }
}
