package application;

import entities.Sale;
import services.SaleService;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;


public class Program {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("Entre o caminho do arquivo: "); // C:\Users\ferna\Documents\Java Expert - Nélio Alves\base-de-dados.txt
        String path = sc.nextLine();

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {

            Set<Sale> set = new HashSet<>();

            String line = br.readLine();
            while (line != null) {
                String[] fields = line.split(",");
                set.add(new Sale(Integer.parseInt(fields[0]), Integer.parseInt(fields[1]), fields[2], Integer.parseInt(fields[3]), Double.parseDouble(fields[4])));
                line = br.readLine();
            }

            SaleService ss = new SaleService();
            Map<String, Double> salesSeller = ss.sumSales(set);

            System.out.println("Total de vendas por vendedor: ");

            for (String seller : salesSeller.keySet()) {
                System.out.println(seller + ": R$ " + String.format("%.2f", salesSeller.get(seller)));
            }

        } catch (IOException e) {
            System.out.println("Erro: " + path + " (O sistema não pode encontrar o arquivo especificado)");
        }
        sc.close();
    }
}