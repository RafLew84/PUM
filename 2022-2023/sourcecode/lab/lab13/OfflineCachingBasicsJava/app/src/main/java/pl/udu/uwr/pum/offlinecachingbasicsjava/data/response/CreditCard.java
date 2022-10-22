package pl.udu.uwr.pum.offlinecachingbasicsjava.data.response;

public class CreditCard {
    private String cc_number;

    public CreditCard(String cc_number) {
        this.cc_number = cc_number;
    }

    public String getCc_number() {
        return cc_number;
    }

    public void setCc_number(String cc_number) {
        this.cc_number = cc_number;
    }
}
