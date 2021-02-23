package pl.mrcwojcik.snakeapp.modules.bill;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "billDetails")
public class BillDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String category;
    private BigDecimal value;

    @ManyToOne
    private Bill bill;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public Bill getBill() {
        return bill;
    }

    public void setBill(Bill bill) {
        this.bill = bill;
    }
}
