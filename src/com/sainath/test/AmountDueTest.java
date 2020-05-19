package com.sainath.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class AmountDueTest {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] accounts = new String[n];
        for (int i = 0; i < n; i++) {
            accounts[i] = sc.nextLine();
        }

        n = sc.nextInt();
        int[] dues = new int[n];
        for (int i = 0; i < n; i++) {
            dues[i] = sc.nextInt();
        }

        int m = sc.nextInt();
        String[] chequeAccounts = new String[m];
        for (int i = 0; i < m; i++) {
            chequeAccounts[i] = sc.next();
        }

        m = sc.nextInt();
        int[] chequeAmounts = new int[m];
        for (int i = 0; i < m; i++) {
            chequeAmounts[i] = sc.nextInt();
        }

        System.out.println(chequeMismatchCount(accounts, dues, chequeAccounts, chequeAmounts));
    }

    private static int chequeMismatchCount(String[] accounts, int[] dues, String[] chequeAccounts, int[] chequeAmounts) {
        Map<String, Integer> accountDueMap = new HashMap<>();
        for (int i = 0; i < accounts.length; i++) {
            accountDueMap.put(accounts[i], dues[i]);
        }

        Map<String, Integer> chequeAccountAmtMap = new HashMap<>();
        for (int i = 0; i < chequeAccounts.length; i++) {
            chequeAccountAmtMap.put(chequeAccounts[i], chequeAmounts[i]);
        }

        int count = 0;
        for (Map.Entry<String, Integer> entry : chequeAccountAmtMap.entrySet()) {
            String acctName = entry.getKey();
            int paid = entry.getValue();

            if (accountDueMap.containsKey(acctName) && paid != accountDueMap.get(acctName)) {
                count++;
            }
        }
        return count;
    }
}
