package lab6;

class MyThread extends Thread {
    public float[] arr = { };
    private int position = 0;


    public MyThread(float[] arr, int position){
        this.arr = arr;
        this.position = position;
    }

    @Override
    public void run() {
//        for (int i = 0; i < arr.length + position - 1; i++){
//            arr[i] = (float)(arr[i] * Math.sin(0.2f + i/5) * Math.cos(0.2f + i/5) * Math.cos(0.4f + i /2));
//        }

        int i = 0;
        int currentPosition = position;
        while (currentPosition < arr.length + position){
            arr[i] = (float)(arr[i] * Math.sin(0.2f + currentPosition/5) * Math.cos(0.2f + currentPosition/5) * Math.cos(0.4f + currentPosition/2));
            currentPosition++;
            i++;
        }
    }
}
