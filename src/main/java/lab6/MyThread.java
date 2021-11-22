package lab6;

class MyThread extends Thread {
    public float[] arr = {1f, 2f};

    @Override
    public void run() {
        for (int i = 0; i < arr.length; i++){
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i/5) * Math.cos(0.2f + i/5) * Math.cos(0.4f + i /2));
        }
    }
}
