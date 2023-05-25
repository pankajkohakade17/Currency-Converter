package CurrencyConverter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
public class CurrencyConverter {
    private static Map<String, Double> exchangeRates;

        static {
            exchangeRates = new HashMap<>();
            exchangeRates.put("USD", 1.0);  // (1.0 USD = 1.0 USD)
            exchangeRates.put("EUR", 0.93); // (1.0 USD = 0.86 EUR)
            exchangeRates.put("GBP", 0.81); // (1.0 USD = 0.75 GBP)
            exchangeRates.put("INR", 82.75);// (1.0 USD = 82.75 USD)
        }

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            boolean status = false;
            do {
                System.out.println("Welcome to Currency Converter!");
                System.out.println("++++++++++++++++++++++++++++++++++++++++++");
                System.out.print("Available Currencies:");

                for (String currency : exchangeRates.keySet()) {
                    System.out.print(" "+currency+" ");
                }
                System.out.println(" ");
                System.out.println("==========================================");
                System.out.println("Enter the Amount: ");
                double amount = scanner.nextDouble();

                System.out.println("Enter the Source Currency: ");
                String sourceCurrency = scanner.next().toUpperCase();

                System.out.println("Enter the Target Currency: ");
                String targetCurrency = scanner.next().toUpperCase();

                double convertedAmount = convertCurrency(amount, sourceCurrency, targetCurrency);
                System.out.println(Math.round(amount) + " " + sourceCurrency + " = " + Math.round(convertedAmount)  + " " + targetCurrency);
                System.out.println("------------------------------------------");
                status=true;
            }while (status);
        }

        public static double convertCurrency(double amount, String sourceCurrency, String targetCurrency) {
            double sourceRate = exchangeRates.get(sourceCurrency);
            double targetRate = exchangeRates.get(targetCurrency);

            // Convert the amount from source currency to USD
            double usdAmount = amount / sourceRate;

            // Convert the USD amount to target currency
            return usdAmount * targetRate;
        }
}
