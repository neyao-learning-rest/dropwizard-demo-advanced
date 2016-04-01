package cn.com.deepdata.frontend.entity;

import io.dropwizard.jackson.JsonSnakeCase;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 存储某个企业上次收到预警的时间的记录表
 * Created by neyao@github.com on 2016/3/30.
 */
@SuppressWarnings("ALL")
@Entity
@Table(name = "WARNING_HISTORY")
@NamedQueries({
        @NamedQuery(
                name = "cn.com.deepdata.front.entity.WarningHistory.findAll",
                query = "select r from WarningHistory r"
        )
})
@JsonSnakeCase
public class WarningHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private long id;

    /**
     * 微信用户的Id
     */
    @Min(1)
    @Column(name = "USER_ID", nullable = false)
    private long userId;

    /**
     * 用户是否在微信端和PC端阅读了该条消息
     * 0表示未读，1表示已读。
     */
    @Column(name="W_READ")
    private long wRead;

    /**
     * 综合风险值
     */
    @NotNull
    @Column(name="RISK_VALUE")
    private String riskValue;

    /**
     * 客户Id（即企业Id）
     */
    @Min(1)
    @Column(name="CUSTOMER_ID")
    private long customerId;

    /**
     * @deprecated
     * 是否移除？
     */
    @Column(name="W_MARK")
    private BigDecimal wMark;

    /**
     * 创建时间
     */
    @Column(name="ADDED")
    private Date added;

    /**
     * 内部风险增长率（自行计算的结果）
     */
    @Column(name="PINNER")
    private String pinner;

    /**
     * 综合风险值排名（自行计算的结果）
     */
    @Column(name="RISK_RANKING")
    private BigDecimal riskRanking;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getwRead() {
        return wRead;
    }

    public void setwRead(long wRead) {
        this.wRead = wRead;
    }

    public String getRiskValue() {
        return riskValue;
    }

    public void setRiskValue(String riskValue) {
        this.riskValue = riskValue;
    }

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    public BigDecimal getwMark() {
        return wMark;
    }

    public void setwMark(BigDecimal wMark) {
        this.wMark = wMark;
    }

    public Date getAdded() {
        return added;
    }

    public void setAdded(Date added) {
        this.added = added;
    }

    public String getPinner() {
        return pinner;
    }

    public void setPinner(String pinner) {
        this.pinner = pinner;
    }

    public BigDecimal getRiskRanking() {
        return riskRanking;
    }

    public void setRiskRanking(BigDecimal riskRanking) {
        this.riskRanking = riskRanking;
    }

    @Override
    public String toString() {
        return "WarningHistory{" +
                "id=" + id +
                ", userId=" + userId +
                ", wRead=" + wRead +
                ", riskValue='" + riskValue + '\'' +
                ", customerId='" + customerId + '\'' +
                ", wMark=" + wMark +
                ", added=" + added +
                ", pinner='" + pinner + '\'' +
                ", riskRanking=" + riskRanking +
                '}';
    }
}
