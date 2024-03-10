import java.util.ArrayList;
import java.util.Scanner;

public class Bai8 {
	static ArrayList<Integer> a = new ArrayList<Integer>();

	public static void nhap() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Nhap so phan tu: ");
		int n = scanner.nextInt();
		
		for(int i = 0; i < n; i++) {
			System.out.printf("Nhap a[%d]: ", i);
			int x = scanner.nextInt();
			a.add(x);
		}
	}

	public static void demChanLe() {
		int soChan = 0;
		int soLe = 0;
		for(int i = 0; i < a.size(); i++) {
			if(a.get(i) % 2 == 0) {
				soChan++;
			}
			else {
				soLe++;
			}
		}
		System.out.printf("So so chan la %d, so so le la %d \n", soChan, soLe);
	}
	
	public static void tb() {
		int sum = 0;
		
		for (int i =0; i < a.size(); i++) {
			sum += a.get(i);
		}
		
		System.out.printf("Gia tri trung binh la %.2f \n", (sum*1.0)/a.size());
	}
	
	public static void minMax() {
		sapXep();
		System.out.printf("Gia tri lon nhat la %d, nho nhat la %d \n", a.get(a.size()-1), a.get(0));
	}
	
	public static void xuatNguocLai() {
		for(int i = a.size()-1; i >= 0; i--) {
			System.out.printf("%d ", a.get(i));
		}
	}
	
	public static void sapXep() {
		System.out.println("Mang sap xep tang dan la: ");
		a.sort(null);
		for(Integer i : a) {
			System.out.printf("%d ", i);
		}
	}
	
    public static int menu() {
		System.out.println("Mời bạn nhập lựa chọn: ");
		System.out.println("#################################################################################################");
		System.out.println("## 1. Nhập mảng                                                                                ##");
		System.out.println("## 2. Xuất mảng nguoc lai                                                                      ##");
		System.out.println("## 3. Xuat min, max                                                                            ##");
		System.out.println("## 4. Dem chan le                                                                              ##");
		System.out.println("## 5. Sắp xếp mảng                                                                             ##");
		System.out.println("## 6. Tính giá trị trung bình của dãy                                                          ##");                           
		System.out.println("## 0. Thoát                                                                                    ##"); 
		System.out.println("#################################################################################################");
		Scanner scanner = new Scanner(System.in);
		int choice = scanner.nextInt();
		return choice;
	}
    
	public static void main() {
		int choice = menu();
		
		do {
            choice = menu();
            switch (choice) {
                case 1:
                    nhap();
                    break;
                case 2:
                    xuatNguocLai();
                    break;
                case 3:
                    minMax();
                    break;
                case 4:
                    demChanLe();
                    break;
                case 5:
                    sapXep();
                    break;
                case 6:
                	tb();
                	break;
                default:
                	return;
            }
        } while(true);
    }
}
