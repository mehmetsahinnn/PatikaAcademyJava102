package InsuranceCompany;

import java.util.Date;

class TravelInsurance extends Insurance {
    public TravelInsurance(String name, double fee, Date startDate, Date endDate) {
        super(name, fee, startDate, endDate);
    }

    public double calculate() {
        return 0.0;
    }
}