import java.util.Scanner;

class RemainService {
  private int a, b, c;

  public RemainService(int a, int b, int c) {
    this.a = a;
    this.b = b;
    this.c = c;
  }

  public void call() {
    int aDividedByC = this.a % this.c;
    int bDividedByC = this.b % this.c;

    // 출력함수 call 횟수를 1번으로 줄이기
    System.out.printf(
      "%d\n%d\n%d\n%d",
      this.add(this.a, this.b, this.c),
      this.add(aDividedByC, bDividedByC, this.c),
      this.multiply(this.a, this.b, this.c),
      this.multiply(aDividedByC, bDividedByC, this.c)
    );
  }

  private int add(int a, int b, int c) {
    return (a + b) % c;
  }

  private int multiply(int a, int b, int c) {
    return (a * b) % c;
  }
}

public class Main{
  public static void main(String[] args) {
    int a, b, c;
    Scanner in = new Scanner(System.in);

    a = in.nextInt();
    b = in.nextInt();
    c = in.nextInt();

    RemainService remain = new RemainService(a, b, c);
    remain.call();
    in.close();
  }
}
