package main.java.com;

public class Manager extends User{

    private Sale[] sales;

    public Manager(String fio, String phone, String email, Sale[] sales) {
        super(fio, phone, email);
        this.sales = sales;
    }

    public void setSales(Sale[] sales) {
        this.sales = sales;
    }

    public Sale[] getSales() {
        return this.getSales();
    }

    public String toCSV() {
        String str = "";
        for (Sale sale : sales) {
            str += sale.toString();
        }
        return super.toCSV() + str + "\n\n";
    }
}
