package pl.mrcwojcik.snakeapp.modules.bill;

import pl.mrcwojcik.snakeapp.modules.account.Account;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Entity
@Table (name = "bills")
public class Bill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private Date created;
    @ManyToOne
    private Account account;
    private boolean profitOrLoss;
    @OneToMany (mappedBy = "bill", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<BillDetails> billDetails;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public boolean isProfitOrLoss() {
        return profitOrLoss;
    }

    public void setProfitOrLoss(boolean profitOrLoss) {
        this.profitOrLoss = profitOrLoss;
    }

    public List<BillDetails> getBillDetails() {
        return billDetails;
    }

    public void setBillDetails(List<BillDetails> billDetails) {
        this.billDetails = billDetails;
    }

    public BigDecimal getBillValue(){
        BigDecimal sum = new BigDecimal(0);
        for (BillDetails bd : billDetails){
            sum.add(bd.getValue());
        }

        return sum;
    }
}
