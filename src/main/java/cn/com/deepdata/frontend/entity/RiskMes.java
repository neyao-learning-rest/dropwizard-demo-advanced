package cn.com.deepdata.frontend.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by neyao@github.com on 2016/3/30.
 */
@Entity
@Table(name = "WARNING_MES")
@NamedQueries({
        @NamedQuery(
                name = "cn.com.deepdata.front.entity.RiskMes.findAll",
                query = "select r from RiskMes r"
        )
})
public class RiskMes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private long id;

    /**
     * 客户ID
     */
    @Column(name = "CUSTOMER_ID")
    private long customerId;

    /**
     * 创建时间
     */
    @Column(name = "ADDED")
    private Date addedDate;

    /**
     * 综合风险
     */
    @Column(name = "INTEGRATED_RISK")
    private BigDecimal integratedRisk;

    /**
     * 内部风险
     */
    @Column(name = "INNER_RISK")
    private String innerRisk;

    /**
     * 行业风险
     */
    @Column(name = "INDUSTRY_RISK")
    private String industryRisk;

    /**
     * 地区风险
     */
    @Column(name = "REGION_RISK")
    private String regionRisk;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    public Date getAddedDate() {
        return addedDate;
    }

    public void setAddedDate(Date addedDate) {
        this.addedDate = addedDate;
    }

    public BigDecimal getIntegratedRisk() {
        return integratedRisk;
    }

    public void setIntegratedRisk(BigDecimal integratedRisk) {
        this.integratedRisk = integratedRisk;
    }

    public String getInnerRisk() {
        return innerRisk;
    }

    public void setInnerRisk(String innerRisk) {
        this.innerRisk = innerRisk;
    }

    public String getIndustryRisk() {
        return industryRisk;
    }

    public void setIndustryRisk(String industryRisk) {
        this.industryRisk = industryRisk;
    }

    public String getRegionRisk() {
        return regionRisk;
    }

    public void setRegionRisk(String regionRisk) {
        this.regionRisk = regionRisk;
    }

    @Override
    public String toString() {
        return "RiskMes{" +
                "id=" + id +
                ", customerId=" + customerId +
                ", addedDate=" + addedDate +
                ", integratedRisk=" + integratedRisk +
                ", innerRisk='" + innerRisk + '\'' +
                ", industryRisk='" + industryRisk + '\'' +
                ", regionRisk='" + regionRisk + '\'' +
                '}';
    }
}
