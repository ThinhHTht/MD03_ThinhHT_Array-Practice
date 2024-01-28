package JV230913_HoangThiThinh;

import java.util.Scanner;

public class Ex0202 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hãy nhập số hàng của mảng 2 chiều:");
        int n = scanner.nextInt();
        System.out.println("Hãy nhập số cột của mảng 2 chiều:");
        int m = scanner.nextInt();
        int[][] twoWay = new int[n][m];

        do {
            System.out.println("\n***********Menu************");
            System.out.println("1. Nhập giá trị các phần tử của mảng");
            System.out.println("2. In giá trị các phần tử trong mảng theo ma trận");
            System.out.println("3. Tính số lượng các phần tử chia hết cho 2 và 3 trong mảng");
            System.out.println("4. In các phần tử và tổng các phần tử nằm trên đường biên, đường chéo chính và\n" +
                    "đường chéo phụ");
            System.out.println("5. Sử dụng thuật toán sắp xếp lựa chọn sắp xếp các phần tử tăng dần theo cột của\n" +
                    "mảng");
            System.out.println("6. In ra các phần tử là số nguyên tố trong mảng");
            System.out.println("7. Sử dụng thuật toán chèn (Insertion sort) sắp xếp các phần tử trên đường chéo chính\n" +
                    "của mảng giảm dần");
            System.out.println("8. Nhập giá trị một mảng 1 chiều gồm m phần tử và chỉ số dòng muốn chèn vào mảng,\n" +
                    "thực hiện chèn vào mảng 2 chiều");
            System.out.println("9. Thoát");
            System.out.print("Lựa chọn của bạn là:");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Hãy nhập các phân tử của mảng:");
                    for (int i = 0; i < n; i++) {
                        for (int j = 0; j < m; j++) {
                            System.out.printf("twoWay[%d][%d]:", i,j);
                            twoWay[i][j] = scanner.nextInt();
                        }
                    }
                    break;
                case 2:
                    System.out.println("Mảng là:");
                    for (int i = 0; i < n; i++) {
                        for (int j = 0; j < m; j++) {
                            System.out.printf("%d\t", twoWay[i][j]);
                        }
                        System.out.println("\n");

                    }
                    break;
                case 3:
                    int quantity = 0;
                    for (int i = 0; i < n; i++) {
                        for (int j = 0; j < m; j++) {
                            if(twoWay[i][j] % 2 == 0 && twoWay[i][j] % 3 == 0){
                                quantity += 1;
                            }

                        }

                    }
                    System.out.println("Số phần tuwr chia hết cho 2 và 3 là:" + quantity);
                    break;
                case 4:
                    int marginSum = 0;
                    int mainSum = 0;
                    int subSum = 0;
                    // Đường biên
                    System.out.println("Các phần tử nằm trên đường bieen là:");
                    for (int i = 0; i < n; i++) {
                        for (int j = 0; j < m; j++) {
                            if(i == 0 || i == n-1 || j == 0 || j == m-1 ){
                                marginSum += twoWay[i][j];
                                System.out.printf("%d\t", twoWay[i][j]);
                            }

                        }

                    }
                    System.out.println("\nTổng các phần tử nằm trên đường biên là:" + marginSum);
                    //Đường chéo chính
                    if(n != m) {
                        System.out.printf("Ma trận không có đường chéo chính và đường chéo phụ");

                    } else {
                    System.out.println("Các phần tử nằm trên đường chéo chính là:");
                    for (int i = 0; i < n; i++) {
                        for (int j = 0; j < m; j++) {
                            if(i == j) {
                                mainSum += twoWay[i][j];
                                System.out.printf("%d\t", twoWay[i][j] );
                            }

                        }

                    }
                    System.out.printf("\nTổng các phần tử nằm trên đường chéo chính là: %d\n", mainSum);
                    // Đường chéo phụ
                    System.out.println("Các phần tử nằm trên đường chéo phụ la:");
                    for (int i = 0; i < n; i++) {
                        for (int j = 0; j < m; j++) {
                            if(i+j == n-1){
                                subSum += twoWay[i][j];
                                System.out.printf("%d\t", twoWay[i][j]);
                            }

                        }

                    }
                        System.out.printf("\nTống của các phần tuwr nằm trên đường chéo phuj là: %d\n", subSum);
                    }
                    break;
                case 5:
                    for (int i = 0; i < m; i++) {
                        for (int j = 0; j < n-1; j++) {
                            if(twoWay[j][i] > twoWay[j+1][i]){
                                int temp = twoWay[j][i];
                                twoWay[j][i] = twoWay[j+1][i];
                                twoWay[j+1][i] = temp;
                            }

                        }

                    }
                    System.out.printf("Mảng sau khi sort theo cột là:\n");
                    for (int i = 0; i < n; i++) {
                        for (int j = 0; j < m ; j++) {
                            System.out.printf("%d\t", twoWay[i][j]);

                        }
                        System.out.printf("\n");

                    }
                    break;
                case 6:
                    System.out.printf("Các phần tử nguyên tố là:\n");
                    for (int i = 0; i < m; i++) {
                        for (int j = 0; j < n; j++) {
                            boolean isPrime = true;
                            if(twoWay[i][j] < 2){
                                isPrime = false;
                            } else if(twoWay[i][j] > 2){
                                for (int k = 2; k < Math.sqrt(twoWay[i][j]); k++) {
                                    if(twoWay[i][j] % k == 0){
                                        isPrime = false;
                                        break;
                                    } else {
                                        isPrime = true;
                                    }

                                }

                            }
                            if(isPrime){
                                System.out.printf("%d\t", twoWay[i][j]);
                            }


                        }

                    }
                    break;
                case 7:
                    System.out.printf("Mảng có đường chéo chính theo thứ tự giảm dần là:\n");
                    for (int i = 0; i < n; i++) {
                        for (int j = 0; j < m; j++) {
                            if(i == j){
                                for (int k = 0; k < n-1; k++) {
                                    for (int l = 0; l < m-1 ; l++) {
                                        if (l == k) {
                                            if (twoWay[k][l] < twoWay[k + 1][l + 1]) {
                                                int temp = twoWay[k][l];
                                                twoWay[k][l] = twoWay[k + 1][l + 1];
                                                twoWay[k + 1][l + 1] = temp;
                                            }
                                        }
                                    }
                                }
                            }
                            System.out.printf("%d\t", twoWay[i][j]);

                        }
                        System.out.println("\n");


                    }
                    break;
                case 8:
                    int[] addArr = new int[m];
                    System.out.println("Hãy nhập các phần tử của mảng muốn chèn vào:");
                    for (int i = 0; i < m; i++) {
                        System.out.printf("addArr[%d]", i);
                        addArr[i] = scanner.nextInt();

                    }
                    int[][] newArr = new int[n+1][m];
                    System.out.println("Hãy nhập chir số dòng muốn chèn:");
                    int addIndex = scanner.nextInt();

                    if(addIndex < 0 || addIndex > n){
                        System.out.println("Chỉ số này không hợp lệ");
                    } else if(addIndex == 0){
                        for (int i = 0; i < m; i++) {
                            newArr[0][i] = addArr[i];

                        }
                        for (int i = 1; i < n+1 ; i++) {
                            for (int j = 0; j < m; j++) {
                                newArr[i][j] = twoWay[i-1][j];
                            }

                        }
                    } else if (addIndex == n) {
                        for (int i = 0; i < n; i++) {
                            for (int j = 0; j < m; j++) {
                                newArr[i][j] = twoWay[i][j];


                            }

                        }
                        for (int i = 0; i < m; i++) {
                            newArr[n][i] = addArr[i];

                        }

                    } else {
                        for (int i = 0; i < addIndex; i++) {
                            for (int j = 0; j < m; j++) {
                                newArr[i][j] = twoWay[i][j];

                            }

                        }
                        for (int i = 0; i < m; i++) {
                            newArr[addIndex][i] = addArr[i];

                        }
                        for (int i = addIndex+1; i <= n; i++) {
                            for (int j = 0; j < m; j++) {
                            newArr[i][j] = twoWay[i-1][j];
                            }

                        }
                    }
                    System.out.println("Mảng sau khi thêm là:");
                    for (int i = 0; i < n+1; i++) {
                        for (int j = 0; j < m; j++) {
                            System.out.printf("%d\t", newArr[i][j]);
                        }
                        System.out.println("\n");

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
// Q1: Ở case 4 có thể cho vào 1 lần lặp i,j thôi ko?
