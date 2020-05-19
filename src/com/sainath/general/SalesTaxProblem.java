package com.sainath.general;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class SalesTaxProblem {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Set<String> exemptedProducts = new HashSet<>();
        exemptedProducts.add("chocolate");
        exemptedProducts.add("book");
        //exemptedProducts.add("pill")

        while (N > 0) {



            N--;
        }
    }
}
