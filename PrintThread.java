package com.company;

public class PrintThread extends Thread {
    public static Object lock = new Object(); // Это вариант реализации семафора.
    // Объект, на котором блокируется класс (общий для всех PrintThread)
    protected static int current = 1; // Общая переменная - счетчик
    private int max; // Лимит
    private int divider; // делитель - указывает потоку, что делать,
    // если число делится на делитель без остатка
    private String message; // Текст сообщения, уникальный для каждого потока

    public PrintThread(int divider, int max, String message) {
        this.max = max;
        this.message = message;
        this.divider = divider;
    }

    public void print() {
        if (message != null) {
            System.out.println(message);
        }
    }

    public void run() {
        while (true) {
            synchronized (lock) {
                if (current > max) {
                    return;
                }

                if (divider == 0) {
                    print();
                    current++;

                } else if (current % divider == 0) {
                    print();
                    current++;
                }
            }
        }
    }
}

