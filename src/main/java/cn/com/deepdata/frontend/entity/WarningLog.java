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
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 给用户推送过的企业风险历史记录表。
 *
 * Created by neyao@github.com on 2016/3/30.
 */
@Entity
@Table(name = "WXHISDATA")
@NamedQueries({
        @NamedQuery(
                name = "cn.com.deepdata.front.entity.WarningLog.findAll",
                query = "select l from WarningLog l"
        )
})
@JsonSnakeCase
public class WarningLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private long id;

    /**
     * 微信用户的Id
     */
    @NotNull
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
    @NotNull
    @Column(name="CUSTOMER_ID")
    private long customerId;

    /**
     * @deprecated
     * 是否移除？
     */
    @Column(name="W_MARK")
    private long wMark;

    /**
     * 创建时间
     */
    @Column(name="ADDED")
    private Date added;

    /**
     * 更新时间
     */
    @Column(name="UPDATED")
    private Date updated;

    /**
     * 内部风险
     */
    @NotNull
    @Column(name="INNER_RISK")
    private String innerRisk;

    /**
     * 区域风险
     */
    @NotNull
    @Column(name="REGION_RISK")
    private String regionRisk;

    /**
     * 行业风险
     */
    @NotNull
    @Column(name="INDUSTER_RISK")
    private String industeryRisk;

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

    public long getwMark() {
        return wMark;
    }

    public void setwMark(long wMark) {
        this.wMark = wMark;
    }

    public Date getAdded() {
        return added;
    }

    public void setAdded(Date added) {
        this.added = added;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    public String getInnerRisk() {
        return innerRisk;
    }

    public void setInnerRisk(String innerRisk) {
        this.innerRisk = innerRisk;
    }

    public String getRegionRisk() {
        return regionRisk;
    }

    public void setRegionRisk(String regionRisk) {
        this.regionRisk = regionRisk;
    }

    public String getIndusteryRisk() {
        return industeryRisk;
    }

    public void setIndusteryRisk(String industeryRisk) {
        this.industeryRisk = industeryRisk;
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
        return "WarningLog{" +
                "id=" + id +
                ", userId=" + userId +
                ", wRead=" + wRead +
                ", riskValue='" + riskValue + '\'' +
                ", customerId='" + customerId + '\'' +
                ", wMark=" + wMark +
                ", added=" + added +
                ", updated=" + updated +
                ", innerRisk='" + innerRisk + '\'' +
                ", regionRisk='" + regionRisk + '\'' +
                ", industeryRisk='" + industeryRisk + '\'' +
                ", pinner='" + pinner + '\'' +
                ", riskRanking=" + riskRanking +
                '}';
    }
}
