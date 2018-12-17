##Задание 5.01.2018

Используя паттерн Decorator создать шифрующие с помощью XOR потоки ввода/вывода. Они должны наследовать FilterInputStream и FilterOutputStream.
Конструктор этих потоков должен принимать пароль в виде массива байт и поток, который он декорирует.

Использование должно выглядеть следующим образом:
Трафик автоматически шифрует и дешифруется:

```
InputStream in = new CryptoInputStream(socket.getInputStream(), password);
OutputStream out = new CryptoOutputStream(socket.getOutputStream(), password);
```
Сохраняем в шифрованный файл и читаем из шифрованного файла:

```
InputStream in = new CryptoInputStream(new FileInputStream("test.bin"), password);
OutputStream out = new CryptoOutputStream(new FileOutputStream("test.bin"), password);
```