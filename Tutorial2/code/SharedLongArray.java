public class SharedLongArray extends Thread{ 
    private static final int NI = 100000;
    private static long es[] = new long [2 * NI];
    private static int index = 0;
    private long tid;
    
    public SharedLongArray(long tid){ 
        this.tid = tid; 
    }
    
    public void run(){ 
        for(int i = 0; i < NI; i++){ 
            es[index] = tid; 
            index = index + 1; 
        } 
    }

    public static void main(String[] args){ 
        System.out.println("SharedArrayGame starts");
        long left = 15 << 35;
        long right = 120;
        //Expect 
        SharedLongArray t1 = new SharedLongArray(left);
        SharedLongArray t2 = new SharedLongArray(right);
        t1.start();
        t2.start();
        try{ 
            t1.join(); 
            t2.join(); 
        }catch(InterruptedException e){} 

        System.out.println("SharedArrayGame done");

        for(int i = 0; i < 2 * NI; i++) { 
            if(es[i] != 0 && es[i] != left && es[i] != right) {
                System.err.println("Detected weird value : " + es[i]);
            }
        }
    }
} 