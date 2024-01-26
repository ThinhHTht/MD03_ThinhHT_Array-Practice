package ra;

import java.util.Scanner;

public class Exam01 {

    public static void main(String[] args) {
        int[] integerArr = new int[100];
        Scanner scanner = new Scanner(System.in);
        int currentIndex = 0;
        do {
            System.out.println("\n*******************Menu*****************");
            System.out.println("1. Nhập giá trị n phần tử của mảng (n nhập từ bàn phím)");
            System.out.println("2. In giá trị các phần tử của mảng");
            System.out.println("3. Tính trung bình các phần tử dương");
            System.out.println("4. In ra vị trí các phần tử có giá trị bằng k (k nhập tử bàn phím");
            System.out.println("5. Sử dụng thuật toán sắp xếp nổi bọt sắp xếp mảng giảm dần");
            System.out.println("6. Tính số lượng các phần tử là số nguyên tố trong mảng");
            System.out.println("7. Sắp xếp các phần tử chẵn chia hết cho 3 ở đầu mảng theo thứ tự tăng dần,\n các phần tử lẻ chia hết cho 3 ở cuối mảng theo thứ tự giảm dần,\n các phần tử còn lại ở giữa mảng theo thứ tự tăng dần");
            System.out.println("8. Nhập giá trị m từ bàn phím, chèn giá trị m vào mảng (sắp xếp giảm\n" +
                    "dần) đúng vị trí");
            System.out.println("9. Thoát");
            System.out.print("Lựa chọn của bạn là:");
            int choice = scanner.nextInt();

            switch (choice) {

                case 1:
                    System.out.println("Hãy nhập số phần tử của mảng");
                    int n = scanner.nextInt();
                    System.out.println("Hãy nhập các phần tử của mảng:");
                    for (int i = 0; i < n ; i++) {

                        System.out.printf("integerArr[%d]:", currentIndex);
                        integerArr[currentIndex] = scanner.nextInt();
                        currentIndex++;

                    }
                    break;
                case 2:

                    System.out.println("Mảng la:");
                    for (int i = 0; i < currentIndex; i++) {
                        System.out.printf("%d\t", integerArr[i]);

                    }
                    break;
                case 3:
                    int sum = 0;
                    int quantity = 0;
                    for (int i = 0; i < currentIndex; i++) {
                        if(integerArr[i] % 2 == 0){
                            sum += integerArr[i];
                            quantity +=1;
                        }

                    }
                    System.out.println("Trung bình các phần tử dương là:" + sum/quantity);
                    break;
                case 4:
                    System.out.println("Hãy nhập số cần tìm:");
                    int findNumber = scanner.nextInt();
                    System.out.printf("Vị trí các phần tử trong mảng bẳng %d là:", findNumber);
                    for (int i = 0; i <  currentIndex; i++) {
                        if(integerArr[i] == findNumber){
                            System.out.printf("%d\t", i);
                        }

                    }
                    break;
                case 5:
                    System.out.println("Mảng theo thứ tự giảm dần là:");
                    for (int i = 0; i < currentIndex-1; i++) {
                        for (int j = i+1; j <currentIndex ; j++) {
                            if(integerArr[i]<integerArr[j]){
                                int temp;
                                temp = integerArr[i];
                                integerArr[i] = integerArr[j];
                                integerArr[j] = temp;

                            }

                        }


                    }
                    for (int i = 0; i < currentIndex; i++) {
                        System.out.printf("%d\t", integerArr[i]);

                    }

                    break;
                case 6:
                    int primeQuantity = 0;

                    for (int i = 0; i < currentIndex; i++) {
                        boolean isPrime = false;
                        if(integerArr[i] > 2){
                            for (int j = 2; j < Math.sqrt(integerArr[i]) ; j++) {
                                if(integerArr[i] % j == 0){
                                    isPrime = false;
                                    break;
                                } else {
                                    isPrime = true;
                                }

                            }

                        }else if (integerArr[i] == 2){
                            isPrime = true;
                        }
                        else {
                            isPrime = false;
                        };
                        if(isPrime){
                            primeQuantity +=1;
                        };

                    }
                    System.out.printf("Số phần tử là số nguyên tố là: %d", primeQuantity);
                    break;
                case 7: // Chưa làm được
                    // Lặp qua các phần từ để tìm giá trị c/l chia hết cho 3
                    // Cho các phần tử tìm được vào 2 mảng và sắp xếp theo tăng dần / giảm dần
                    // Khai báo 1 mảng mới có length = current index rồi copy 2 mảng trên vào
                    int arr1Length = 0;
                    int arr2Length = 0;
                    int[] newArr = new int[currentIndex];
                    for (int i = 0; i < currentIndex; i++) {
                        boolean isFirst = false;
                        if(integerArr[i] % 2 == 0 && integerArr[i] % 3 == 0){
                            arr1Length+=1;
                            isFirst = true;
                        }
                        int[] evenArr = new int[arr1Length];
                        for (int j = 0; j < arr1Length; j++) {
                           if(isFirst) {
                               evenArr[j] = integerArr[i];
                           }

                        }
                    }
                    break;
                case 8:
                    int[] addArr = new int[currentIndex +1];
                    System.out.println("Hay nhập giá trị muốn thêm vào:");
                    int addValue = scanner.nextInt();
                    for (int i = 0; i < currentIndex; i++) {
                        addArr[i] = integerArr[i];

                    }
                    addArr[currentIndex] = addValue;
                    for (int i = 0; i < currentIndex; i++) {
                        for (int j = i+1; j < currentIndex+1; j++) {
                            int temp;
                            if(addArr[i] < addArr[j]){
                               temp = addArr[i];
                               addArr[i] = addArr[j];
                               addArr[j] = temp;
                            }

                        }

                    }
                    System.out.println("\nMảng mới là:");
                    for (int i = 0; i < currentIndex+1; i++) {
                        System.out.printf("%d\t", addArr[i]);
                    }

                    break;
                case 9:
                    System.exit(0);
                default:
                    System.err.println("Vui lòng nhập từ 1-9");
            }


        }while(true);


    }
}
