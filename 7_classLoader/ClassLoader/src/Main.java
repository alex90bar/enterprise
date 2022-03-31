import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public class Main {

  public static void main(String[] args)
      throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
    ClassLoader classLoader = new MyClassLoader();
    // loadCLass() производит дополнительные проверки и синхронизацию, для того, чтобы нельзя было
    // загрузить, например, один и тот же класс в разных потоках, и необходимая защита там тоже делается,
    // поэтому желательно использовать его

    // вызываем конструктор и создаем обьект через рефлекции,
    // т.к. Java не знает про класс ничего, т.к. описание и объект мы удалили
    Object x = classLoader.loadClass("Test").getDeclaredConstructor().newInstance();

    Arrays.stream(x.getClass().getDeclaredMethods()).forEach(
        (m) -> {
          try {
            m.invoke(x);
          } catch (IllegalAccessException e) {
            e.printStackTrace();
          } catch (InvocationTargetException e) {
            e.printStackTrace();
          }
        }
    );
  }

}
