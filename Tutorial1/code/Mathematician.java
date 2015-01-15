class Mathematician {
    //Property
    private String name;
    
    //Constructor
    public Mathematician(String name) {
        this.name = name;
    }

    //Instance method
    public int calculateFactorial(int n) {
        int result = 1;
        for(int i = 2; i <= n; ++i) {
            result *= i;
        }
        return result;
    }
}