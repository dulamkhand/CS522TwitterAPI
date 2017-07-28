/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hw4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author 985892
 */
public class Q3b {

    public static void main(String[] args) throws Exception {
        String filename = "./src/hw4/sale-table.txt";
        BufferedReader br = null;
        FileReader fr = null;

        try {
            fr = new FileReader(filename);
            br = new BufferedReader(fr);
            String sCurrentLine;

            int i=0;
            String storeid, prodid;
            Integer qty;
            String[] arr;
            Map<String, Map<String, Integer>> stores = new HashMap();
            while ((sCurrentLine = br.readLine()) != null) {
                if(i++ == 0) continue;
                System.out.println("line: " + sCurrentLine);
                
                arr = sCurrentLine.split(",");
                prodid = arr[3]; // product
                storeid = arr[4]; // storeid
                qty = Integer.parseInt(arr[5]); // qty
//                System.out.println(String.format("store[%s], product[%s]: %d"
//                            , storeid, prodid, qty));
                
                Map<String, Integer> products;
                if(stores.containsKey(storeid)) {
                    products =  stores.get(storeid);
                } else {
                    products = new HashMap();
                }
                products.put(prodid, qty);
                stores.put(storeid, products);
            }
            
            // print
            Map<String, Integer> products;
            for(String s : stores.keySet()) {
                products = stores.get(s);
                for(String p : products.keySet()) {
                    System.out.println(String.format("store[%s], product[%s]: %d"
                            , s, p, products.get(p)));
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (br != null) br.close();
                if (fr != null) fr.close();
            } catch (IOException ex) {
            }
        }

    }

}
