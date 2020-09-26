import java.util.Scanner;

class Gcd {
  private int a, b;

  public Gcd(int a, int b) {
    this.a = a;
    this.b = b;
  }

  public int call() {
    int gcd = 1;
    while(this.a % gcd == 0 && this.b % gcd == 0) ++gcd;
    return gcd;
  }
}

class Lcm {
  private int a, b, gcd;

  public Lcm(int a, int b) {
    this.a = a;
    this.b = b;
  }

  public int call() {
    int lcm = 1;
    while(lcm % this.a == 0 && lcm % this.b == 0) ++lcm;
    return lcm;
  }
}

class Main{
  public static void main(String[] args) {
    int a, b;
    Scanner in = new Scanner(System.in);

    a = in.nextInt();
    b = in.nextInt();

    Gcd gcdCalculator = new Gcd(a, b);
    Lcm lcmCalculator = new Lcm(a, b);
    System.out.println(gcd.call());
    System.out.println(lcmCalculator.call());
    in.close();
  }
}
