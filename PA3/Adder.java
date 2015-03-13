class Adder {
  public static void main (String[] args) {
    if (args.length == 2) {
      try {
        int first = Integer.parseInt(args[0]);
        int second = Integer.parseInt(args[1]);
        int sum = first + second;
        System.out.println("" + first + " + " + second + " = " + sum);
      } catch (NumberFormatException e) {
        System.err.println("Both must be integers: " + args[0] + ", " + args[1]);
      }
    }else{
      System.err.println("Usage: java Adder x y");
    } 
  }
}