import java.util.Scanner;

public class Point2D {
    private int x;
    private int y;

    public Point2D() {
        this.x = 0;
        this.y = 0;
    }

    public Point2D(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void move(Vector v) {
        this.x += v.getX();
        this.y += v.getY();
    }

    public double distance(Point2D p) {
        int dx = this.x - p.getX();
        int dy = this.y - p.getY();
        return Math.sqrt(dx * dx + dy * dy);
    }

    public void input() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap toa do x: ");
        this.x = scanner.nextInt();
        System.out.print("Nhap toa do y: ");
        this.y = scanner.nextInt();
    }

    public void output() {
        System.out.println("(" + this.x + ", " + this.y + ")");
    }

	public static class Vector {
	
	    private int x;
	    private int y;

	    public Vector() {
	        this.x = 0;
	        this.y = 0;
	    }
	
	    public Vector(int x, int y) {
	        this.x = x;
	        this.y = y;
	    }

	    public int getX() {
	        return x;
	    }
	
	    public int getY() {
	        return y;
	    }
	
	    public void input() {
	        Scanner scanner = new Scanner(System.in);
	        System.out.print("Nhap toa do x cua vector: ");
	        this.x = scanner.nextInt();
	        System.out.print("Nhap toa do y cua vector: ");
	        this.y = scanner.nextInt();
	    }
	}
	
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Nhập điểm A:");
        Point2D A = new Point2D();
        A.input();

        System.out.println("Nhập điểm B:");
        Point2D B = new Point2D();
        B.input();

        System.out.println("Nhập vector di chuyển:");
        Vector v = new Vector();
        v.input();

        A.move(v);

        double distance = A.distance(B);


        System.out.println("Điểm A sau khi di chuyển: ");
        A.output();

        System.out.println("Khoảng cách giữa A và B: " + distance);
    }
}

