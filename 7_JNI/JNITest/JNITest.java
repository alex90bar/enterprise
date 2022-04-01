public class JNITest{

  //подключение динамической библиотеки, блок static вызывается при инициализации класса, когда Bootstrap Loader
  //загружает класс (в данном случае, APplication Loader), и на последней стадии инициализации выполняется
  static{
    System.loadLibrary("JNITest");
  }

  public native void print();

  public static void main(String[] args) {
    new JNITest().print();
  }
}

//javac .\JNITest.java
//(javah .\JNITest.java) <- deprecated since Java 9   javac JNITest.java -h .\
// генерация заголовочного файла
//создаем .с на основе заголовочного файла
//gcc -I"C:\Program Files\Java\jdk-11.0.10\include" -I"C:\Program Files\Java\jdk-11.0.10\i
//nclude\win32" -o JNITest.dll -s -shared JNITest.c -Wl,--subsystem,windows  - компиляция DLL-библиотеики
// java JNITest   = запуcкаем