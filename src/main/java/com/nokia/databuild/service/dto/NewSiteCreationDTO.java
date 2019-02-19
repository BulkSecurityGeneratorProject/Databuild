package com.nokia.databuild.service.dto;

import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Lob;

/**
 * A DTO for the NewSiteCreation entity.
 */
public class NewSiteCreationDTO implements Serializable {

    private Long id;

    @NotNull
    private String requestName;

    private String wbtsId;

    private String rncId;

    private String wbtsName;

    private String lcrId;

    private String lac;

    private String rac;

    private String sac;

    private String cId;

    private String templateName;

    private String priSrcCode;

    private String wlcseId;

    private String antBearing;

    private String wlcseRncId;

    private String antennaCoordLatitude;

    private String antennaCoordLongitude;

    private String siteName;

    private String technology;

    @Lob
    private byte[] goldenParametersWbts;
    private String goldenParametersWbtsContentType;

    @Lob
    private byte[] goldenParametersWcell;
    private String goldenParametersWcellContentType;

    @Lob
    private byte[] goldenParametersWlcse;
    private String goldenParametersWlcseContentType;

    private String adjGid;

    private String adjgNcc;

    private String adjgBcc;

    private String adjgBcch;

    private String adjgBandIndicator;

    private String adjgCi;

    private String adjgLac;

    private String adjsId;

    private String adjsCi;

    private String adjsLac;

    private String adjsRac;

    private String adjsRnCid;

    private String adjsSrcCode;

    private String adjiId;

    private String adjiCi;

    private String adjiLac;

    private String adjiRac;

    private String adjiRnCid;

    private String adjiSrcCode;

    private String bscId;

    private String bcfId;

    private String btsId;

    private String adjwCid;

    private String adjwLac;

    private String adjwRncId;

    private String scramblingCode;

    @Lob
    private byte[] goldenParametersAdji;
    private String goldenParametersAdjiContentType;

    @Lob
    private byte[] goldenParametersAdjs;
    private String goldenParametersAdjsContentType;

    @Lob
    private byte[] goldenParametersAdjg;
    private String goldenParametersAdjgContentType;

    @Lob
    private byte[] goldenParametersAdjw;
    private String goldenParametersAdjwContentType;

    @Lob
    private String rfDatabase;

    @Lob
    private String neighborDatabase;

    @Lob
    private byte[] outputWbts;
    private String outputWbtsContentType;

    @Lob
    private byte[] outputWcell;
    private String outputWcellContentType;

    @Lob
    private byte[] outputWcellAc;
    private String outputWcellAcContentType;

    @Lob
    private byte[] outputWcellLc;
    private String outputWcellLcContentType;

    @Lob
    private byte[] outputWcellPc;
    private String outputWcellPcContentType;

    @Lob
    private byte[] outputWcellHc;
    private String outputWcellHcContentType;

    @Lob
    private byte[] outputWcellPS;
    private String outputWcellPSContentType;

    @Lob
    private byte[] outputWcellSib;
    private String outputWcellSibContentType;

    @Lob
    private byte[] outputWcellUraid;
    private String outputWcellUraidContentType;

    @Lob
    private byte[] outputWlcse;
    private String outputWlcseContentType;

    @Lob
    private byte[] outputAdji;
    private String outputAdjiContentType;

    @Lob
    private byte[] outputAdjs;
    private String outputAdjsContentType;

    @Lob
    private byte[] outputAdjg;
    private String outputAdjgContentType;

    @Lob
    private byte[] outputAdjw;
    private String outputAdjwContentType;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRequestName() {
        return requestName;
    }

    public void setRequestName(String requestName) {
        this.requestName = requestName;
    }

    public String getWbtsId() {
        return wbtsId;
    }

    public void setWbtsId(String wbtsId) {
        this.wbtsId = wbtsId;
    }

    public String getRncId() {
        return rncId;
    }

    public void setRncId(String rncId) {
        this.rncId = rncId;
    }

    public String getWbtsName() {
        return wbtsName;
    }

    public void setWbtsName(String wbtsName) {
        this.wbtsName = wbtsName;
    }

    public String getLcrId() {
        return lcrId;
    }

    public void setLcrId(String lcrId) {
        this.lcrId = lcrId;
    }

    public String getLac() {
        return lac;
    }

    public void setLac(String lac) {
        this.lac = lac;
    }

    public String getRac() {
        return rac;
    }

    public void setRac(String rac) {
        this.rac = rac;
    }

    public String getSac() {
        return sac;
    }

    public void setSac(String sac) {
        this.sac = sac;
    }

    public String getcId() {
        return cId;
    }

    public void setcId(String cId) {
        this.cId = cId;
    }

    public String getTemplateName() {
        return templateName;
    }

    public void setTemplateName(String templateName) {
        this.templateName = templateName;
    }

    public String getPriSrcCode() {
        return priSrcCode;
    }

    public void setPriSrcCode(String priSrcCode) {
        this.priSrcCode = priSrcCode;
    }

    public String getWlcseId() {
        return wlcseId;
    }

    public void setWlcseId(String wlcseId) {
        this.wlcseId = wlcseId;
    }

    public String getAntBearing() {
        return antBearing;
    }

    public void setAntBearing(String antBearing) {
        this.antBearing = antBearing;
    }

    public String getWlcseRncId() {
        return wlcseRncId;
    }

    public void setWlcseRncId(String wlcseRncId) {
        this.wlcseRncId = wlcseRncId;
    }

    public String getAntennaCoordLatitude() {
        return antennaCoordLatitude;
    }

    public void setAntennaCoordLatitude(String antennaCoordLatitude) {
        this.antennaCoordLatitude = antennaCoordLatitude;
    }

    public String getAntennaCoordLongitude() {
        return antennaCoordLongitude;
    }

    public void setAntennaCoordLongitude(String antennaCoordLongitude) {
        this.antennaCoordLongitude = antennaCoordLongitude;
    }

    public String getSiteName() {
        return siteName;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }

    public String getTechnology() {
        return technology;
    }

    public void setTechnology(String technology) {
        this.technology = technology;
    }

    public byte[] getGoldenParametersWbts() {
        return goldenParametersWbts;
    }

    public void setGoldenParametersWbts(byte[] goldenParametersWbts) {
        this.goldenParametersWbts = goldenParametersWbts;
    }

    public String getGoldenParametersWbtsContentType() {
        return goldenParametersWbtsContentType;
    }

    public void setGoldenParametersWbtsContentType(String goldenParametersWbtsContentType) {
        this.goldenParametersWbtsContentType = goldenParametersWbtsContentType;
    }

    public byte[] getGoldenParametersWcell() {
        return goldenParametersWcell;
    }

    public void setGoldenParametersWcell(byte[] goldenParametersWcell) {
        this.goldenParametersWcell = goldenParametersWcell;
    }

    public String getGoldenParametersWcellContentType() {
        return goldenParametersWcellContentType;
    }

    public void setGoldenParametersWcellContentType(String goldenParametersWcellContentType) {
        this.goldenParametersWcellContentType = goldenParametersWcellContentType;
    }

    public byte[] getGoldenParametersWlcse() {
        return goldenParametersWlcse;
    }

    public void setGoldenParametersWlcse(byte[] goldenParametersWlcse) {
        this.goldenParametersWlcse = goldenParametersWlcse;
    }

    public String getGoldenParametersWlcseContentType() {
        return goldenParametersWlcseContentType;
    }

    public void setGoldenParametersWlcseContentType(String goldenParametersWlcseContentType) {
        this.goldenParametersWlcseContentType = goldenParametersWlcseContentType;
    }

    public String getAdjGid() {
        return adjGid;
    }

    public void setAdjGid(String adjGid) {
        this.adjGid = adjGid;
    }

    public String getAdjgNcc() {
        return adjgNcc;
    }

    public void setAdjgNcc(String adjgNcc) {
        this.adjgNcc = adjgNcc;
    }

    public String getAdjgBcc() {
        return adjgBcc;
    }

    public void setAdjgBcc(String adjgBcc) {
        this.adjgBcc = adjgBcc;
    }

    public String getAdjgBcch() {
        return adjgBcch;
    }

    public void setAdjgBcch(String adjgBcch) {
        this.adjgBcch = adjgBcch;
    }

    public String getAdjgBandIndicator() {
        return adjgBandIndicator;
    }

    public void setAdjgBandIndicator(String adjgBandIndicator) {
        this.adjgBandIndicator = adjgBandIndicator;
    }

    public String getAdjgCi() {
        return adjgCi;
    }

    public void setAdjgCi(String adjgCi) {
        this.adjgCi = adjgCi;
    }

    public String getAdjgLac() {
        return adjgLac;
    }

    public void setAdjgLac(String adjgLac) {
        this.adjgLac = adjgLac;
    }

    public String getAdjsId() {
        return adjsId;
    }

    public void setAdjsId(String adjsId) {
        this.adjsId = adjsId;
    }

    public String getAdjsCi() {
        return adjsCi;
    }

    public void setAdjsCi(String adjsCi) {
        this.adjsCi = adjsCi;
    }

    public String getAdjsLac() {
        return adjsLac;
    }

    public void setAdjsLac(String adjsLac) {
        this.adjsLac = adjsLac;
    }

    public String getAdjsRac() {
        return adjsRac;
    }

    public void setAdjsRac(String adjsRac) {
        this.adjsRac = adjsRac;
    }

    public String getAdjsRnCid() {
        return adjsRnCid;
    }

    public void setAdjsRnCid(String adjsRnCid) {
        this.adjsRnCid = adjsRnCid;
    }

    public String getAdjsSrcCode() {
        return adjsSrcCode;
    }

    public void setAdjsSrcCode(String adjsSrcCode) {
        this.adjsSrcCode = adjsSrcCode;
    }

    public String getAdjiId() {
        return adjiId;
    }

    public void setAdjiId(String adjiId) {
        this.adjiId = adjiId;
    }

    public String getAdjiCi() {
        return adjiCi;
    }

    public void setAdjiCi(String adjiCi) {
        this.adjiCi = adjiCi;
    }

    public String getAdjiLac() {
        return adjiLac;
    }

    public void setAdjiLac(String adjiLac) {
        this.adjiLac = adjiLac;
    }

    public String getAdjiRac() {
        return adjiRac;
    }

    public void setAdjiRac(String adjiRac) {
        this.adjiRac = adjiRac;
    }

    public String getAdjiRnCid() {
        return adjiRnCid;
    }

    public void setAdjiRnCid(String adjiRnCid) {
        this.adjiRnCid = adjiRnCid;
    }

    public String getAdjiSrcCode() {
        return adjiSrcCode;
    }

    public void setAdjiSrcCode(String adjiSrcCode) {
        this.adjiSrcCode = adjiSrcCode;
    }

    public String getBscId() {
        return bscId;
    }

    public void setBscId(String bscId) {
        this.bscId = bscId;
    }

    public String getBcfId() {
        return bcfId;
    }

    public void setBcfId(String bcfId) {
        this.bcfId = bcfId;
    }

    public String getBtsId() {
        return btsId;
    }

    public void setBtsId(String btsId) {
        this.btsId = btsId;
    }

    public String getAdjwCid() {
        return adjwCid;
    }

    public void setAdjwCid(String adjwCid) {
        this.adjwCid = adjwCid;
    }

    public String getAdjwLac() {
        return adjwLac;
    }

    public void setAdjwLac(String adjwLac) {
        this.adjwLac = adjwLac;
    }

    public String getAdjwRncId() {
        return adjwRncId;
    }

    public void setAdjwRncId(String adjwRncId) {
        this.adjwRncId = adjwRncId;
    }

    public String getScramblingCode() {
        return scramblingCode;
    }

    public void setScramblingCode(String scramblingCode) {
        this.scramblingCode = scramblingCode;
    }

    public byte[] getGoldenParametersAdji() {
        return goldenParametersAdji;
    }

    public void setGoldenParametersAdji(byte[] goldenParametersAdji) {
        this.goldenParametersAdji = goldenParametersAdji;
    }

    public String getGoldenParametersAdjiContentType() {
        return goldenParametersAdjiContentType;
    }

    public void setGoldenParametersAdjiContentType(String goldenParametersAdjiContentType) {
        this.goldenParametersAdjiContentType = goldenParametersAdjiContentType;
    }

    public byte[] getGoldenParametersAdjs() {
        return goldenParametersAdjs;
    }

    public void setGoldenParametersAdjs(byte[] goldenParametersAdjs) {
        this.goldenParametersAdjs = goldenParametersAdjs;
    }

    public String getGoldenParametersAdjsContentType() {
        return goldenParametersAdjsContentType;
    }

    public void setGoldenParametersAdjsContentType(String goldenParametersAdjsContentType) {
        this.goldenParametersAdjsContentType = goldenParametersAdjsContentType;
    }

    public byte[] getGoldenParametersAdjg() {
        return goldenParametersAdjg;
    }

    public void setGoldenParametersAdjg(byte[] goldenParametersAdjg) {
        this.goldenParametersAdjg = goldenParametersAdjg;
    }

    public String getGoldenParametersAdjgContentType() {
        return goldenParametersAdjgContentType;
    }

    public void setGoldenParametersAdjgContentType(String goldenParametersAdjgContentType) {
        this.goldenParametersAdjgContentType = goldenParametersAdjgContentType;
    }

    public byte[] getGoldenParametersAdjw() {
        return goldenParametersAdjw;
    }

    public void setGoldenParametersAdjw(byte[] goldenParametersAdjw) {
        this.goldenParametersAdjw = goldenParametersAdjw;
    }

    public String getGoldenParametersAdjwContentType() {
        return goldenParametersAdjwContentType;
    }

    public void setGoldenParametersAdjwContentType(String goldenParametersAdjwContentType) {
        this.goldenParametersAdjwContentType = goldenParametersAdjwContentType;
    }

    public String getRfDatabase() {
        return rfDatabase;
    }

    public void setRfDatabase(String rfDatabase) {
        this.rfDatabase = rfDatabase;
    }

    public String getNeighborDatabase() {
        return neighborDatabase;
    }

    public void setNeighborDatabase(String neighborDatabase) {
        this.neighborDatabase = neighborDatabase;
    }

    public byte[] getOutputWbts() {
        return outputWbts;
    }

    public void setOutputWbts(byte[] outputWbts) {
        this.outputWbts = outputWbts;
    }

    public String getOutputWbtsContentType() {
        return outputWbtsContentType;
    }

    public void setOutputWbtsContentType(String outputWbtsContentType) {
        this.outputWbtsContentType = outputWbtsContentType;
    }

    public byte[] getOutputWcell() {
        return outputWcell;
    }

    public void setOutputWcell(byte[] outputWcell) {
        this.outputWcell = outputWcell;
    }

    public String getOutputWcellContentType() {
        return outputWcellContentType;
    }

    public void setOutputWcellContentType(String outputWcellContentType) {
        this.outputWcellContentType = outputWcellContentType;
    }

    public byte[] getOutputWcellAc() {
        return outputWcellAc;
    }

    public void setOutputWcellAc(byte[] outputWcellAc) {
        this.outputWcellAc = outputWcellAc;
    }

    public String getOutputWcellAcContentType() {
        return outputWcellAcContentType;
    }

    public void setOutputWcellAcContentType(String outputWcellAcContentType) {
        this.outputWcellAcContentType = outputWcellAcContentType;
    }

    public byte[] getOutputWcellLc() {
        return outputWcellLc;
    }

    public void setOutputWcellLc(byte[] outputWcellLc) {
        this.outputWcellLc = outputWcellLc;
    }

    public String getOutputWcellLcContentType() {
        return outputWcellLcContentType;
    }

    public void setOutputWcellLcContentType(String outputWcellLcContentType) {
        this.outputWcellLcContentType = outputWcellLcContentType;
    }

    public byte[] getOutputWcellPc() {
        return outputWcellPc;
    }

    public void setOutputWcellPc(byte[] outputWcellPc) {
        this.outputWcellPc = outputWcellPc;
    }

    public String getOutputWcellPcContentType() {
        return outputWcellPcContentType;
    }

    public void setOutputWcellPcContentType(String outputWcellPcContentType) {
        this.outputWcellPcContentType = outputWcellPcContentType;
    }

    public byte[] getOutputWcellHc() {
        return outputWcellHc;
    }

    public void setOutputWcellHc(byte[] outputWcellHc) {
        this.outputWcellHc = outputWcellHc;
    }

    public String getOutputWcellHcContentType() {
        return outputWcellHcContentType;
    }

    public void setOutputWcellHcContentType(String outputWcellHcContentType) {
        this.outputWcellHcContentType = outputWcellHcContentType;
    }

    public byte[] getOutputWcellPS() {
        return outputWcellPS;
    }

    public void setOutputWcellPS(byte[] outputWcellPS) {
        this.outputWcellPS = outputWcellPS;
    }

    public String getOutputWcellPSContentType() {
        return outputWcellPSContentType;
    }

    public void setOutputWcellPSContentType(String outputWcellPSContentType) {
        this.outputWcellPSContentType = outputWcellPSContentType;
    }

    public byte[] getOutputWcellSib() {
        return outputWcellSib;
    }

    public void setOutputWcellSib(byte[] outputWcellSib) {
        this.outputWcellSib = outputWcellSib;
    }

    public String getOutputWcellSibContentType() {
        return outputWcellSibContentType;
    }

    public void setOutputWcellSibContentType(String outputWcellSibContentType) {
        this.outputWcellSibContentType = outputWcellSibContentType;
    }

    public byte[] getOutputWcellUraid() {
        return outputWcellUraid;
    }

    public void setOutputWcellUraid(byte[] outputWcellUraid) {
        this.outputWcellUraid = outputWcellUraid;
    }

    public String getOutputWcellUraidContentType() {
        return outputWcellUraidContentType;
    }

    public void setOutputWcellUraidContentType(String outputWcellUraidContentType) {
        this.outputWcellUraidContentType = outputWcellUraidContentType;
    }

    public byte[] getOutputWlcse() {
        return outputWlcse;
    }

    public void setOutputWlcse(byte[] outputWlcse) {
        this.outputWlcse = outputWlcse;
    }

    public String getOutputWlcseContentType() {
        return outputWlcseContentType;
    }

    public void setOutputWlcseContentType(String outputWlcseContentType) {
        this.outputWlcseContentType = outputWlcseContentType;
    }

    public byte[] getOutputAdji() {
        return outputAdji;
    }

    public void setOutputAdji(byte[] outputAdji) {
        this.outputAdji = outputAdji;
    }

    public String getOutputAdjiContentType() {
        return outputAdjiContentType;
    }

    public void setOutputAdjiContentType(String outputAdjiContentType) {
        this.outputAdjiContentType = outputAdjiContentType;
    }

    public byte[] getOutputAdjs() {
        return outputAdjs;
    }

    public void setOutputAdjs(byte[] outputAdjs) {
        this.outputAdjs = outputAdjs;
    }

    public String getOutputAdjsContentType() {
        return outputAdjsContentType;
    }

    public void setOutputAdjsContentType(String outputAdjsContentType) {
        this.outputAdjsContentType = outputAdjsContentType;
    }

    public byte[] getOutputAdjg() {
        return outputAdjg;
    }

    public void setOutputAdjg(byte[] outputAdjg) {
        this.outputAdjg = outputAdjg;
    }

    public String getOutputAdjgContentType() {
        return outputAdjgContentType;
    }

    public void setOutputAdjgContentType(String outputAdjgContentType) {
        this.outputAdjgContentType = outputAdjgContentType;
    }

    public byte[] getOutputAdjw() {
        return outputAdjw;
    }

    public void setOutputAdjw(byte[] outputAdjw) {
        this.outputAdjw = outputAdjw;
    }

    public String getOutputAdjwContentType() {
        return outputAdjwContentType;
    }

    public void setOutputAdjwContentType(String outputAdjwContentType) {
        this.outputAdjwContentType = outputAdjwContentType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        NewSiteCreationDTO newSiteCreationDTO = (NewSiteCreationDTO) o;
        if (newSiteCreationDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), newSiteCreationDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "NewSiteCreationDTO{" +
            "id=" + getId() +
            ", requestName='" + getRequestName() + "'" +
            ", wbtsId='" + getWbtsId() + "'" +
            ", rncId='" + getRncId() + "'" +
            ", wbtsName='" + getWbtsName() + "'" +
            ", lcrId='" + getLcrId() + "'" +
            ", lac='" + getLac() + "'" +
            ", rac='" + getRac() + "'" +
            ", sac='" + getSac() + "'" +
            ", cId='" + getcId() + "'" +
            ", templateName='" + getTemplateName() + "'" +
            ", priSrcCode='" + getPriSrcCode() + "'" +
            ", wlcseId='" + getWlcseId() + "'" +
            ", antBearing='" + getAntBearing() + "'" +
            ", wlcseRncId='" + getWlcseRncId() + "'" +
            ", antennaCoordLatitude='" + getAntennaCoordLatitude() + "'" +
            ", antennaCoordLongitude='" + getAntennaCoordLongitude() + "'" +
            ", siteName='" + getSiteName() + "'" +
            ", technology='" + getTechnology() + "'" +
            ", goldenParametersWbts='" + getGoldenParametersWbts() + "'" +
            ", goldenParametersWcell='" + getGoldenParametersWcell() + "'" +
            ", goldenParametersWlcse='" + getGoldenParametersWlcse() + "'" +
            ", adjGid='" + getAdjGid() + "'" +
            ", adjgNcc='" + getAdjgNcc() + "'" +
            ", adjgBcc='" + getAdjgBcc() + "'" +
            ", adjgBcch='" + getAdjgBcch() + "'" +
            ", adjgBandIndicator='" + getAdjgBandIndicator() + "'" +
            ", adjgCi='" + getAdjgCi() + "'" +
            ", adjgLac='" + getAdjgLac() + "'" +
            ", adjsId='" + getAdjsId() + "'" +
            ", adjsCi='" + getAdjsCi() + "'" +
            ", adjsLac='" + getAdjsLac() + "'" +
            ", adjsRac='" + getAdjsRac() + "'" +
            ", adjsRnCid='" + getAdjsRnCid() + "'" +
            ", adjsSrcCode='" + getAdjsSrcCode() + "'" +
            ", adjiId='" + getAdjiId() + "'" +
            ", adjiCi='" + getAdjiCi() + "'" +
            ", adjiLac='" + getAdjiLac() + "'" +
            ", adjiRac='" + getAdjiRac() + "'" +
            ", adjiRnCid='" + getAdjiRnCid() + "'" +
            ", adjiSrcCode='" + getAdjiSrcCode() + "'" +
            ", bscId='" + getBscId() + "'" +
            ", bcfId='" + getBcfId() + "'" +
            ", btsId='" + getBtsId() + "'" +
            ", adjwCid='" + getAdjwCid() + "'" +
            ", adjwLac='" + getAdjwLac() + "'" +
            ", adjwRncId='" + getAdjwRncId() + "'" +
            ", scramblingCode='" + getScramblingCode() + "'" +
            ", goldenParametersAdji='" + getGoldenParametersAdji() + "'" +
            ", goldenParametersAdjs='" + getGoldenParametersAdjs() + "'" +
            ", goldenParametersAdjg='" + getGoldenParametersAdjg() + "'" +
            ", goldenParametersAdjw='" + getGoldenParametersAdjw() + "'" +
            ", rfDatabase='" + getRfDatabase() + "'" +
            ", neighborDatabase='" + getNeighborDatabase() + "'" +
            ", outputWbts='" + getOutputWbts() + "'" +
            ", outputWcell='" + getOutputWcell() + "'" +
            ", outputWcellAc='" + getOutputWcellAc() + "'" +
            ", outputWcellLc='" + getOutputWcellLc() + "'" +
            ", outputWcellPc='" + getOutputWcellPc() + "'" +
            ", outputWcellHc='" + getOutputWcellHc() + "'" +
            ", outputWcellPS='" + getOutputWcellPS() + "'" +
            ", outputWcellSib='" + getOutputWcellSib() + "'" +
            ", outputWcellUraid='" + getOutputWcellUraid() + "'" +
            ", outputWlcse='" + getOutputWlcse() + "'" +
            ", outputAdji='" + getOutputAdji() + "'" +
            ", outputAdjs='" + getOutputAdjs() + "'" +
            ", outputAdjg='" + getOutputAdjg() + "'" +
            ", outputAdjw='" + getOutputAdjw() + "'" +
            "}";
    }
}
