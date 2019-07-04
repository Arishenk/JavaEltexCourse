package main.java.com;

public class Manager extends User{

    private Sale[] sales;

    public Manager(String fio, String phone, String email, Sale[] sales) {
        super(fio, phone, email);
        this.sales = sales;
    }

    public Manager() {
    }

    public void setSales(Sale[] sales) {
        this.sales = sales;
    }

    public String getSales() {
        String str = "";
        for (Sale sale : this.sales) {
            str += sale.toString() + ":";
        }
        return str;
    }

    public String toCSV() {
        return super.toCSV() + ";" + this.getSales() + "\n";
    }

    public void fromCSV(String str) {
        super.fromCSV(str);

        String[] lineFromCSV = str.split(";");
        String[] salesFromCSV = lineFromCSV[lineFromCSV.length - 1].split(":");
        Sale[] resultSales = new Sale[salesFromCSV.length];

        Integer counterSales = 0;
        for (String sale : salesFromCSV) {
            String[] saleStr = sale.split(" ");
            Double cost = Double.parseDouble(saleStr[1]);
            String[] itemsStr = saleStr[0].split(",");
            resultSales[counterSales] = new Sale(itemsStr, cost);
            counterSales++;
        }
        this.sales = resultSales;
    }
}
