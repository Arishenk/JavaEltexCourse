package com.arishenk;

import lombok.NoArgsConstructor;
import lombok.Setter;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

@People
@NoArgsConstructor
public class Manager extends User{

    @Setter
    private Sale[] sales;

    public Integer index = 0;
    public static int countIndex = 0;

    @Override
    public String toString() {
        return super.toString() +
                "sales=" + Arrays.toString(sales) +
                '}';
    }

    public Manager(String fio, String phone, String email, Sale[] sales) {
        super(fio, phone, email);
        this.sales = sales;
        index += countIndex;
        this.setId(index);
        countIndex++;
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

    public void fromCSV(String str) throws TypeException {
        super.fromCSV(str);

        String[] lineFromCSV = str.split(";");

        if (lineFromCSV.length != 6) {
            throw new TypeException("this type is not developer");
        }

        String[] salesFromCSV = lineFromCSV[lineFromCSV.length - 1].split(":");

        checkInputData(salesFromCSV);

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

    private void checkInputData(String[] salesFromCSV) throws TypeException {
        for (String sale : salesFromCSV ) {

            String[] masSales = sale.split(" ");
            try {
                Double cost = (Double.parseDouble(masSales[1]));
            }
            catch (NumberFormatException err) {
                throw new TypeException("this type is not manager");
            }
        }
    }

    @Override
    public String toJSON(String fileName) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(new File(fileName), this);
        return mapper.writeValueAsString(this);
    }

    @Override
    public void fromJSON(String fileName) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        Manager u2 = mapper.readValue(new File(fileName), Manager.class);
        this.index = u2.index;
        this.setSales(u2.sales);
        this.setPhone(u2.getPhone());
        this.setEmail(u2.getEmail());
        this.setFio(u2.getFio());
    }
}
