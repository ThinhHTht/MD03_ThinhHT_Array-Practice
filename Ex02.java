package ra;

import java.util.Scanner;

public class Ex02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hãy nhập số dòng của mảng:");
        int n = Integer.parseInt(scanner.nextLine());
        System.out.println("Hãy nhập số cột của mảng:");
        int m = Integer.parseInt(scanner.nextLine());
        int[][] arr = new int[n][m];
        do {
            System.out.println("***********Menu************");
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

            switch (choice){
                case 1:
                    for (int i = 0; i < n; i++) {
                        for (int j = 0; j < m; j++) {
                            System.out.printf("arr[%d][%d]:", i,j);
                            arr[i][j] = scanner.nextInt();


                        }

                    }
                    break;
                case 2:
                    System.out.println("Mảng là:");
                    for (int i = 0; i < n; i++) {
                        for (int j = 0; j < m; j++) {
                            System.out.printf("%d\t", arr[i][j]);

                        }
                        System.out.printf("\n");


                    }
                    break;
                case 3:
                    int number = 0;
                    for (int i = 0; i < n; i++) {
                        for (int j = 0; j < m; j++) {
                            if(arr[i][j] % 2 == 0 && arr[i][j] % 3 == 0){
                                number +=1;
                            }

                        }

                    }
                    System.out.println("Số phần tử chia hết cho 2 vaf 3 là:" + number);
                    break;
                case 4:
                    int margin = 0;
                    int mainDiagonal = 4;
                    int subDiagonal = arr[0][0] + arr[0][m-1]+ arr[n-1][0]+arr[n-1][m-1];
                    System.out.println("Các phần tử nằm trên đường biên là:");
                    for (int i = 0; i < n; i++) {
                        for (int j = 0; j < m; j++) {
                            if(i==0 || i == n-1 || j == 0 || j == m-1){
                                margin += arr[i][j];
                                System.out.printf("%d\t", arr[i][j]);
                            }

                        }

                    }
                    System.out.printf("Tổng các phần tử nằm trên đường biên là: %d", margin);
                    // Đường chéo chính:
                    System.out.println("Các phần tử nằm trên đường chéo chính là:");
                    System.out.printf("%d\t %d\t %d\t %d\t ", arr[0][0], arr[0][m-1], arr[n-1][0], arr[n-1][m-1]);
                    for (int i = 1; i < n-1 ; i++) {
                        for (int j = 1; j < m-1 ; j++) {
                            mainDiagonal +=arr[i][j];
                            System.out.printf("%d\t", arr[i][j]);

                        }

                    }
                    System.out.printf("Tổng các phần tử nằm trên đường chéo chính là:%d", mainDiagonal);

                    // Đường chéo phụ


                    break;
                case 5:
                    for (int i = 0; i < m; i++) {
                        for (int j = 0; j < n-1; j++) {
                            if(arr[j][i] > arr[j+1][i]){
                                int temp;
                                temp = arr[j][i];
                                arr[j][i] = arr[j+1][i];
                                arr[j+1][i] = temp;
                            }

                        }

                    }
                    System.out.println("Mảng sắp xeeps theo giá trị tăng dần theo cột là:");
                    for (int i = 0; i < n; i++) {
                        for (int j = 0; j < m; j++) {
                            System.out.printf("%d\t", arr[i][j]);

                        }
                        System.out.println("\n");

                    }
                    break;
                case 6:
                    System.out.println("Cac số nguyên tố trong mảng là:");
                    for (int i = 0; i < n; i++) {
                        for (int j = 0; j < m; j++) {
                            boolean isPrime = false;
                            if(arr[i][j] > 2){
                                for (int k = 2; k < arr[i][j] ; k++) {
                                    if(arr[i][j] % k == 0){
                                        isPrime = false;
                                        break;
                                    } else {
                                        isPrime = true;
                                    }
                                }

                            } else if (arr[i][j] == 2) {
                                isPrime = true;
                            } else {
                                isPrime = false;
                            }
                            if(isPrime){
                                System.out.printf("%d\t", arr[i][j]);
                            }


                        }

                    }
                    System.out.println("\n");
                    break;
                case 7:
                    break;

                case 8:
                    // 1: Khai báo mảng muốn chen vào, nhập các phần tử của mảng đó
                    // 2: Nhập chỉ số dòng muốn chèn vào: insertIndex;
                    // 3: Khai báo 1 mảng mới có n+1 dòng, m cột
                    // 4: Check điều kiện: inserIndex >= 0 và <=n
                    // 5: Copy mảng cũ sang mảng mới và chèn mảng cần chèn vào mảng mới
                    int[] insertArr = new int[m];
                    System.out.println("Hãy nhập các phần tử muốn chèn");
                    for (int i = 0; i < m; i++) {
                        System.out.printf("insertArr[%d]", i);
                        insertArr[i] = scanner.nextInt();
                    }
                    int[][] insertedArr = new int[n+1][m];
                    System.out.println("Nhập chỉ số dòng muốn cheèn");
                    int insertIndex = scanner.nextInt();
                    if(insertIndex < 0 || insertIndex >n){
                        System.err.println("Chỉ số nhaapj vào không hợp lệ ");
                    } else if(insertIndex == 0){
                            for (int j = 0; j < m; j++) {
                                insertedArr[0][j] = insertArr[j];
                            }

                        for (int i = 1; i < n+1 ; i++) {
                            for (int j = 0; j < m; j++) {
                                insertedArr[i][j] = arr[i-1][j];

                            }

                        }
                    } else if(insertIndex == n){
                        for (int i = 0; i < n; i++) {
                            for (int j = 0; j < m; j++) {
                                insertedArr[i][j] = arr[i][j];

                            }

                        }
                        for (int i = 0; i < m; i++) {
                            insertedArr[n][i] = insertArr[i];

                        }
                    } else{
                        for (int i = 0; i < insertIndex; i++) {
                            for (int j = 0; j < m; j++) {
                                insertedArr[i][j] = arr[i][j];

                            }

                        }
                        for (int i = 0; i <m ; i++) {
                            insertedArr[insertIndex][i] = insertArr[i];

                        }
                        for (int i = insertIndex+1; i <= n; i++) {
                            for (int j = 0; j < m; j++) {
                                insertedArr[i][j] = arr[i-1][j];

                            }

                        }
                    }
                    System.out.println("Mảng sau khi chèn là:");
                    for (int i = 0; i <=n; i++) {
                        for (int j = 0; j <m ; j++) {

                            System.out.printf("%d\t", insertedArr[i][j]);
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
