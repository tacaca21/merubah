
import java.util.Scanner;
import java.util.Stack;

public class SaldoStuck {
    public static void main(String[] args) {
        Scanner inputx = new Scanner(System.in);
        Stack<Integer> transactions = new Stack<>();
        int balance = 2000000, nav;

        do {
            System.out.println("\n1. Penarikan\n2. Menyimpan\n3. Lihat Saldo\n4. Total Uang Masuk\n5. Total Uang Keluar\n0. Exit");
            System.out.print("Pilih Menu: ");
            nav = inputx.nextInt();

            if (nav == 0) break;

            if (nav == 1 || nav == 2) {
                if (transactions.size() == 5) {
                    System.out.println("Data Transaksi sudah penuh");
                    continue;
                }

                System.out.print("Jumlah: ");
                int amount = inputx.nextInt();

                if (amount <= 0) continue;

                if (nav == 1) {
                    if (amount > balance) {
                        System.out.println("Saldo tidak cukup");
                        continue;
                    }
                    balance -= amount;
                    transactions.push(-amount);
                } else {
                    balance += amount;
                    transactions.push(amount);
                }

            } else if (nav == 3) {
                System.out.println("Saldo Anda: " + balance);

            } else if (nav == 4 || nav == 5) {
                int total = 0;

                for (int x : transactions) {
                    if (nav == 4 && x > 0) total += x;
                    if (nav == 5 && x < 0) total += x;
                }

                System.out.println("Total: " + Math.abs(total));
            }

        } while (true);

        inputx.close();
    }
}