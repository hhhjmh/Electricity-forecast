package com.example.power_prediction.entity;


import javax.persistence.*;

@Entity
@Table(name = "power_analyse_day_min", schema = "power", catalog = "")
public class PowerAnalyseDayMin {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  private long dataTime;
  private String totalLoad;
  private String aLoad;
  private String bLoad;
  private String cLoad;
  private String totalReactivePower;
  private String aReactivePower;
  private String bReactivePower;
  private String cReactivePower;
  private String totalPowerFactor;
  private String aPowerFactor;
  private String bPowerFactor;
  private String cPowerFactor;
  private String ia;
  private String ib;
  private String ic;
  private String zeroi;
  private String ua;
  private String ub;
  private String uc;
  private String uab;
  private String ubc;
  private String uca;
  private String iaPhd;
  private String ibPhd;
  private String icPhd;
  private String uaPhd;
  private String ubPhd;
  private String ucPhd;
  private String uaDeviation;
  private String ubDeviation;
  private String ucDeviation;
  private String uUabDeviation;
  private String uUbcDeviation;
  private String uUcaDeviation;
  private String iUnbalance;
  private String uUnbalance;
  private long aLoadTime;
  private long aPowerFactorTime;
  private long aReactivePowerTime;
  private long bLoadTime;
  private long bPowerFactorTime;
  private long bReactivePowerTime;
  private long cLoadTime;
  private long cPowerFactorTime;
  private long cReactivePowerTime;
  private long deviceId;
  private long iUnbalanceTime;
  private long iaPhdTime;
  private long iaTime;
  private long ibPhdTime;
  private long ibTime;
  private long icPhdTime;
  private long icTime;
  private long totalLoadTime;
  private long totalPowerFactorTime;
  private long totalReactivePowerTime;
  private long uUabDeviationTime;
  private long uUbcDeviationTime;
  private long uUcaDeviationTime;
  private long uUnbalanceTime;
  private long uaDeviationTime;
  private long uaPhdTime;
  private long uaTime;
  private long uabTime;
  private long ubDeviationTime;
  private long ubPhdTime;
  private long ubTime;
  private long ubcTime;
  private long ucDeviationTime;
  private long ucPhdTime;
  private long ucTime;
  private long ucaTime;
  private long zeroiTime;
  private String frequencyDeviation;
  private long frequencyDeviationTime;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public long getDataTime() {
    return dataTime;
  }

  public void setDataTime(long dataTime) {
    this.dataTime = dataTime;
  }


  public String getTotalLoad() {
    return totalLoad;
  }

  public void setTotalLoad(String totalLoad) {
    this.totalLoad = totalLoad;
  }


  public String getALoad() {
    return aLoad;
  }

  public void setALoad(String aLoad) {
    this.aLoad = aLoad;
  }


  public String getBLoad() {
    return bLoad;
  }

  public void setBLoad(String bLoad) {
    this.bLoad = bLoad;
  }


  public String getCLoad() {
    return cLoad;
  }

  public void setCLoad(String cLoad) {
    this.cLoad = cLoad;
  }


  public String getTotalReactivePower() {
    return totalReactivePower;
  }

  public void setTotalReactivePower(String totalReactivePower) {
    this.totalReactivePower = totalReactivePower;
  }


  public String getAReactivePower() {
    return aReactivePower;
  }

  public void setAReactivePower(String aReactivePower) {
    this.aReactivePower = aReactivePower;
  }


  public String getBReactivePower() {
    return bReactivePower;
  }

  public void setBReactivePower(String bReactivePower) {
    this.bReactivePower = bReactivePower;
  }


  public String getCReactivePower() {
    return cReactivePower;
  }

  public void setCReactivePower(String cReactivePower) {
    this.cReactivePower = cReactivePower;
  }


  public String getTotalPowerFactor() {
    return totalPowerFactor;
  }

  public void setTotalPowerFactor(String totalPowerFactor) {
    this.totalPowerFactor = totalPowerFactor;
  }


  public String getAPowerFactor() {
    return aPowerFactor;
  }

  public void setAPowerFactor(String aPowerFactor) {
    this.aPowerFactor = aPowerFactor;
  }


  public String getBPowerFactor() {
    return bPowerFactor;
  }

  public void setBPowerFactor(String bPowerFactor) {
    this.bPowerFactor = bPowerFactor;
  }


  public String getCPowerFactor() {
    return cPowerFactor;
  }

  public void setCPowerFactor(String cPowerFactor) {
    this.cPowerFactor = cPowerFactor;
  }


  public String getIa() {
    return ia;
  }

  public void setIa(String ia) {
    this.ia = ia;
  }


  public String getIb() {
    return ib;
  }

  public void setIb(String ib) {
    this.ib = ib;
  }


  public String getIc() {
    return ic;
  }

  public void setIc(String ic) {
    this.ic = ic;
  }


  public String getZeroi() {
    return zeroi;
  }

  public void setZeroi(String zeroi) {
    this.zeroi = zeroi;
  }


  public String getUa() {
    return ua;
  }

  public void setUa(String ua) {
    this.ua = ua;
  }


  public String getUb() {
    return ub;
  }

  public void setUb(String ub) {
    this.ub = ub;
  }


  public String getUc() {
    return uc;
  }

  public void setUc(String uc) {
    this.uc = uc;
  }


  public String getUab() {
    return uab;
  }

  public void setUab(String uab) {
    this.uab = uab;
  }


  public String getUbc() {
    return ubc;
  }

  public void setUbc(String ubc) {
    this.ubc = ubc;
  }


  public String getUca() {
    return uca;
  }

  public void setUca(String uca) {
    this.uca = uca;
  }


  public String getIaPhd() {
    return iaPhd;
  }

  public void setIaPhd(String iaPhd) {
    this.iaPhd = iaPhd;
  }


  public String getIbPhd() {
    return ibPhd;
  }

  public void setIbPhd(String ibPhd) {
    this.ibPhd = ibPhd;
  }


  public String getIcPhd() {
    return icPhd;
  }

  public void setIcPhd(String icPhd) {
    this.icPhd = icPhd;
  }


  public String getUaPhd() {
    return uaPhd;
  }

  public void setUaPhd(String uaPhd) {
    this.uaPhd = uaPhd;
  }


  public String getUbPhd() {
    return ubPhd;
  }

  public void setUbPhd(String ubPhd) {
    this.ubPhd = ubPhd;
  }


  public String getUcPhd() {
    return ucPhd;
  }

  public void setUcPhd(String ucPhd) {
    this.ucPhd = ucPhd;
  }


  public String getUaDeviation() {
    return uaDeviation;
  }

  public void setUaDeviation(String uaDeviation) {
    this.uaDeviation = uaDeviation;
  }


  public String getUbDeviation() {
    return ubDeviation;
  }

  public void setUbDeviation(String ubDeviation) {
    this.ubDeviation = ubDeviation;
  }


  public String getUcDeviation() {
    return ucDeviation;
  }

  public void setUcDeviation(String ucDeviation) {
    this.ucDeviation = ucDeviation;
  }


  public String getUUabDeviation() {
    return uUabDeviation;
  }

  public void setUUabDeviation(String uUabDeviation) {
    this.uUabDeviation = uUabDeviation;
  }


  public String getUUbcDeviation() {
    return uUbcDeviation;
  }

  public void setUUbcDeviation(String uUbcDeviation) {
    this.uUbcDeviation = uUbcDeviation;
  }


  public String getUUcaDeviation() {
    return uUcaDeviation;
  }

  public void setUUcaDeviation(String uUcaDeviation) {
    this.uUcaDeviation = uUcaDeviation;
  }


  public String getIUnbalance() {
    return iUnbalance;
  }

  public void setIUnbalance(String iUnbalance) {
    this.iUnbalance = iUnbalance;
  }


  public String getUUnbalance() {
    return uUnbalance;
  }

  public void setUUnbalance(String uUnbalance) {
    this.uUnbalance = uUnbalance;
  }


  public long getALoadTime() {
    return aLoadTime;
  }

  public void setALoadTime(long aLoadTime) {
    this.aLoadTime = aLoadTime;
  }


  public long getAPowerFactorTime() {
    return aPowerFactorTime;
  }

  public void setAPowerFactorTime(long aPowerFactorTime) {
    this.aPowerFactorTime = aPowerFactorTime;
  }


  public long getAReactivePowerTime() {
    return aReactivePowerTime;
  }

  public void setAReactivePowerTime(long aReactivePowerTime) {
    this.aReactivePowerTime = aReactivePowerTime;
  }


  public long getBLoadTime() {
    return bLoadTime;
  }

  public void setBLoadTime(long bLoadTime) {
    this.bLoadTime = bLoadTime;
  }


  public long getBPowerFactorTime() {
    return bPowerFactorTime;
  }

  public void setBPowerFactorTime(long bPowerFactorTime) {
    this.bPowerFactorTime = bPowerFactorTime;
  }


  public long getBReactivePowerTime() {
    return bReactivePowerTime;
  }

  public void setBReactivePowerTime(long bReactivePowerTime) {
    this.bReactivePowerTime = bReactivePowerTime;
  }


  public long getCLoadTime() {
    return cLoadTime;
  }

  public void setCLoadTime(long cLoadTime) {
    this.cLoadTime = cLoadTime;
  }


  public long getCPowerFactorTime() {
    return cPowerFactorTime;
  }

  public void setCPowerFactorTime(long cPowerFactorTime) {
    this.cPowerFactorTime = cPowerFactorTime;
  }


  public long getCReactivePowerTime() {
    return cReactivePowerTime;
  }

  public void setCReactivePowerTime(long cReactivePowerTime) {
    this.cReactivePowerTime = cReactivePowerTime;
  }


  public long getDeviceId() {
    return deviceId;
  }

  public void setDeviceId(long deviceId) {
    this.deviceId = deviceId;
  }


  public long getIUnbalanceTime() {
    return iUnbalanceTime;
  }

  public void setIUnbalanceTime(long iUnbalanceTime) {
    this.iUnbalanceTime = iUnbalanceTime;
  }


  public long getIaPhdTime() {
    return iaPhdTime;
  }

  public void setIaPhdTime(long iaPhdTime) {
    this.iaPhdTime = iaPhdTime;
  }


  public long getIaTime() {
    return iaTime;
  }

  public void setIaTime(long iaTime) {
    this.iaTime = iaTime;
  }


  public long getIbPhdTime() {
    return ibPhdTime;
  }

  public void setIbPhdTime(long ibPhdTime) {
    this.ibPhdTime = ibPhdTime;
  }


  public long getIbTime() {
    return ibTime;
  }

  public void setIbTime(long ibTime) {
    this.ibTime = ibTime;
  }


  public long getIcPhdTime() {
    return icPhdTime;
  }

  public void setIcPhdTime(long icPhdTime) {
    this.icPhdTime = icPhdTime;
  }


  public long getIcTime() {
    return icTime;
  }

  public void setIcTime(long icTime) {
    this.icTime = icTime;
  }


  public long getTotalLoadTime() {
    return totalLoadTime;
  }

  public void setTotalLoadTime(long totalLoadTime) {
    this.totalLoadTime = totalLoadTime;
  }


  public long getTotalPowerFactorTime() {
    return totalPowerFactorTime;
  }

  public void setTotalPowerFactorTime(long totalPowerFactorTime) {
    this.totalPowerFactorTime = totalPowerFactorTime;
  }


  public long getTotalReactivePowerTime() {
    return totalReactivePowerTime;
  }

  public void setTotalReactivePowerTime(long totalReactivePowerTime) {
    this.totalReactivePowerTime = totalReactivePowerTime;
  }


  public long getUUabDeviationTime() {
    return uUabDeviationTime;
  }

  public void setUUabDeviationTime(long uUabDeviationTime) {
    this.uUabDeviationTime = uUabDeviationTime;
  }


  public long getUUbcDeviationTime() {
    return uUbcDeviationTime;
  }

  public void setUUbcDeviationTime(long uUbcDeviationTime) {
    this.uUbcDeviationTime = uUbcDeviationTime;
  }


  public long getUUcaDeviationTime() {
    return uUcaDeviationTime;
  }

  public void setUUcaDeviationTime(long uUcaDeviationTime) {
    this.uUcaDeviationTime = uUcaDeviationTime;
  }


  public long getUUnbalanceTime() {
    return uUnbalanceTime;
  }

  public void setUUnbalanceTime(long uUnbalanceTime) {
    this.uUnbalanceTime = uUnbalanceTime;
  }


  public long getUaDeviationTime() {
    return uaDeviationTime;
  }

  public void setUaDeviationTime(long uaDeviationTime) {
    this.uaDeviationTime = uaDeviationTime;
  }


  public long getUaPhdTime() {
    return uaPhdTime;
  }

  public void setUaPhdTime(long uaPhdTime) {
    this.uaPhdTime = uaPhdTime;
  }


  public long getUaTime() {
    return uaTime;
  }

  public void setUaTime(long uaTime) {
    this.uaTime = uaTime;
  }


  public long getUabTime() {
    return uabTime;
  }

  public void setUabTime(long uabTime) {
    this.uabTime = uabTime;
  }


  public long getUbDeviationTime() {
    return ubDeviationTime;
  }

  public void setUbDeviationTime(long ubDeviationTime) {
    this.ubDeviationTime = ubDeviationTime;
  }


  public long getUbPhdTime() {
    return ubPhdTime;
  }

  public void setUbPhdTime(long ubPhdTime) {
    this.ubPhdTime = ubPhdTime;
  }


  public long getUbTime() {
    return ubTime;
  }

  public void setUbTime(long ubTime) {
    this.ubTime = ubTime;
  }


  public long getUbcTime() {
    return ubcTime;
  }

  public void setUbcTime(long ubcTime) {
    this.ubcTime = ubcTime;
  }


  public long getUcDeviationTime() {
    return ucDeviationTime;
  }

  public void setUcDeviationTime(long ucDeviationTime) {
    this.ucDeviationTime = ucDeviationTime;
  }


  public long getUcPhdTime() {
    return ucPhdTime;
  }

  public void setUcPhdTime(long ucPhdTime) {
    this.ucPhdTime = ucPhdTime;
  }


  public long getUcTime() {
    return ucTime;
  }

  public void setUcTime(long ucTime) {
    this.ucTime = ucTime;
  }


  public long getUcaTime() {
    return ucaTime;
  }

  public void setUcaTime(long ucaTime) {
    this.ucaTime = ucaTime;
  }


  public long getZeroiTime() {
    return zeroiTime;
  }

  public void setZeroiTime(long zeroiTime) {
    this.zeroiTime = zeroiTime;
  }


  public String getFrequencyDeviation() {
    return frequencyDeviation;
  }

  public void setFrequencyDeviation(String frequencyDeviation) {
    this.frequencyDeviation = frequencyDeviation;
  }


  public long getFrequencyDeviationTime() {
    return frequencyDeviationTime;
  }

  public void setFrequencyDeviationTime(long frequencyDeviationTime) {
    this.frequencyDeviationTime = frequencyDeviationTime;
  }

}
