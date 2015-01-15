class MyApp {
  public static void main(String[] args) {
    int n = 5;
    Mathematician m = new Mathematician("Anonymous");
    int factorial = m.calculateFactorial(n);
    System.out.println("Methematican says: " + n + "! = " + factorial);
  }
}
