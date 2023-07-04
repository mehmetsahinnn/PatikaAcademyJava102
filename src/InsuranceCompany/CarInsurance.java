package InsuranceCompany;

import java.util.Date;

class CarInsurance extends Insurance {
    public CarInsurance(String name, double fee, Date startDate, Date endDate) {
        super(name, fee, startDate, endDate);
    }

    public double calculate() {
        return 0.0;
    }
}