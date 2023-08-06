package thread.impl;

public class MyThread extends Thread {
        private ImplThread implThread;

        public MyThread(ImplThread implThread) {
            this.implThread = implThread;
        }

        @Override
        public void run() {
            for (int i = 0; i < 1000; i++) {
                implThread.test();
            }
            System.out.println("implThread = " + implThread.getNumber());
        }

    }
