package InsuranceCompany;

import java.util.Date;

public class ResidenceInsurance extends Insurance{
    public ResidenceInsurance(String name, double fee, Date startDate, Date endDate) {
        super(name, fee, startDate, endDate);
    }

    public double calculate() {
        return 0.0;
    }
}
