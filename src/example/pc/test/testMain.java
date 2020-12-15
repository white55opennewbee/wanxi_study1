package example.pc.test;

public class testMain {
    public static void main(String[] args) {
        WareHouse wareHouse = new WareHouse();
            for (int i=0;i<100;i++){
                Consumer consumer = new Consumer(wareHouse);

                consumer.start();
            }
    }
}
