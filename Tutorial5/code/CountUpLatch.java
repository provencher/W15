public interface CountUpLatch {
    /**
     * Increase the counter value by one.
     * Notify to waiting instances
     */
    void countUp();

    /**
     * If the counter is equal or greater than value, just returns
     * Otherwise waits until satisfies the condition
     * @param value required value
     * @throws InterruptedException
     */
    void await(int value)throws InterruptedException;
}

