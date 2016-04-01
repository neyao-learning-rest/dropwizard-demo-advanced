package cn.com.deepdata.frontend.entity;

import io.dropwizard.jackson.JsonSnakeCase;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 待推送的风险企业，包含各个风险类型的风险值。<br>
 * <br>
 * 1. 该表只由中间层写入
 * 2. 完成推送之后，不会删除该表这中的记录。下一次会有中间层来update。
 *
 *
 *
 * Created by neyao@github.com on 2016/3/30.
 */
@SuppressWarnings("ALL")
@Entity
@Table(name = "WARNING_MES")
@NamedQueries({
        @NamedQuery(
                name = "cn.com.deepdata.front.entity.RiskMes.findAll",
                query = "select r from RiskMes r"
        )
})
@JsonSnakeCase
public class RiskMes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private long id;

    /**
     * 客户ID
     */
    @NotNull
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
    @NotEmpty
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
