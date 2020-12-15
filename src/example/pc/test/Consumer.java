package example.pc.test;

public class Consumer extends Thread {
    WareHouse wareHouse;
    Object object;
    public Consumer(WareHouse wareHouse){
        super();
        this.wareHouse = wareHouse;
        this.object = wareHouse.object;
    }
    @Override
    public void run() {
        while (wareHouse.count>0){
            synchronized (object){
                if (wareHouse.count>0){
                    System.out.println(getName()+"出售台产品:"+wareHouse.count);
                    wareHouse.count--;
                }
                notifyAll();
            }
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
