package pl.udu.uwr.pum.offlinecachingbasicsjava.data.response;

public class Subscription {
    private String plan;
    private String status;
    private String payment_method;
    private String term;

    public Subscription(String plan, String status, String payment_method, String term) {
        this.plan = plan;
        this.status = status;
        this.payment_method = payment_method;
        this.term = term;
    }

    public String getPlan() {
        return plan;
    }

    public void setPlan(String plan) {
        this.plan = plan;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPayment_method() {
        return payment_method;
    }

    public void setPayment_method(String payment_method) {
        this.payment_method = payment_method;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }
}
