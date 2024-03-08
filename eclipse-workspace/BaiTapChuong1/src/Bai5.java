import java.util.ArrayList;
import java.util.Scanner;

public class Bai5 {
	static ArrayList<Integer> a = new ArrayList<Integer>();
    public static void them() {
        System.out.println("Nhap gia tri can them: ");
        Scanner scanner = new Scanner(System.in);
        int v = scanner.nextInt();
        System.out.println("Nhap vi tri can them: ");
        int index = scanner.nextInt();
        a.add(index, v);
    }

    public static void xoa() {
        System.out.println("Nhap vi tri can xoa: ");
        Scanner scanner = new Scanner(System.in);
        int index = scanner.nextInt();
        a.remove(index);
    }

    public static void sua() {
        System.out.println("Nhap vi tri can sua: ");
        Scanner scanner = new Scanner(System.in);
        int index = scanner.nextInt();
        System.out.println("Nhap gia tri moi: ");
        int v = scanner.nextInt();
        a.remove(index);
        a.add(index, v);
    }

    public static void nhap() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhap so phan tu: ");
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            System.out.printf("a[%d] = ", i);
            a.add(scanner.nextInt());
        }
    }

    public static void xuat() {
        for (int i = 0; i < a.size(); i++) {
            System.out.printf("%d ", a.get(i));
        }
        System.out.println();
    }

    public static int tb() {
        int sum = 0;
        for (Integer i: a) {
            sum += i;
        }
        int avg = sum / a.size();
        int minDiff = Math.abs(a.get(0) - avg);
        int closest = 0;
        for (int i = 1; i < a.size(); i++) {
            int diff = Math.abs(a.get(i) - avg);
            if (diff < minDiff) {
                minDiff = diff;
                closest = i;
            }
        }
        System.out.println("Trung binh: " + avg);
        System.out.println("Phan tu gan trung binh nhat: " + a.get(closest));
        return avg;
    }

    public static void sapxep() {
        // Sử dụng thuật toán sắp xếp nổi bọt
        a.sort(null);
    }
    
    public static int menu() {
		System.out.println("Mời bạn nhập lựa chọn: ");
		System.out.println("#################################################################################################");
		System.out.println("## 1. Nhập mảng                                                                                ##");
		System.out.println("## 2. Xuất mảng                                                                                ##");
		System.out.println("## 3. Thêm phần tử                                                                             ##");
		System.out.println("## 4. Xóa phần tử                                                                              ##");
		System.out.println("## 5. Sửa phần tử                                                                              ##");
		System.out.println("## 6. Sắp xếp mảng                                                                             ##");
		System.out.println("## 7. Tính giá trị trung bình của dãy và cho biết phần tử nào gần với giá trị trung bình nhất. ##");                           
		System.out.println("## 0. Thoát                                                                                    ##"); 
		System.out.println("#################################################################################################");
		Scanner scanner = new Scanner(System.in);
		int choice = scanner.nextInt();
		return choice;
	}
    
    public static void main(String[] args) {
        int choice;
        do {
            choice = menu();
            switch (choice) {
                case 1:
                    nhap();
                    break;
                case 2:
                    xuat();
                    break;
                case 3:
                    them();
                    break;
                case 4:
                    xoa();
                    break;
                case 5:
                    sua();
                    break;
                case 6:
                    sapxep();
                    break;
                case 7:
                	tb();
                	break;
                default:
                	return;
            }
        } while(true);
    }
}
