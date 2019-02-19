package com.nokia.databuild.domain;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.util.Objects;

/**
 * A NewSiteCreation.
 */
@Entity
@Table(name = "new_site_creation")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class NewSiteCreation implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "request_name", nullable = false)
    private String requestName;

    @Column(name = "wbts_id")
    private String wbtsId;

    @Column(name = "rnc_id")
    private String rncId;

    @Column(name = "wbts_name")
    private String wbtsName;

    @Column(name = "lcr_id")
    private String lcrId;

    @Column(name = "lac")
    private String lac;

    @Column(name = "rac")
    private String rac;

    @Column(name = "sac")
    private String sac;

    @Column(name = "c_id")
    private String cId;

    @Column(name = "template_name")
    private String templateName;

    @Column(name = "pri_src_code")
    private String priSrcCode;

    @Column(name = "wlcse_id")
    private String wlcseId;

    @Column(name = "ant_bearing")
    private String antBearing;

    @Column(name = "wlcse_rnc_id")
    private String wlcseRncId;

    @Column(name = "antenna_coord_latitude")
    private String antennaCoordLatitude;

    @Column(name = "antenna_coord_longitude")
    private String antennaCoordLongitude;

    @Column(name = "site_name")
    private String siteName;

    @Column(name = "technology")
    private String technology;

    @Lob
    @Column(name = "golden_parameters_wbts")
    private byte[] goldenParametersWbts;

    @Column(name = "golden_parameters_wbts_content_type")
    private String goldenParametersWbtsContentType;

    @Lob
    @Column(name = "golden_parameters_wcell")
    private byte[] goldenParametersWcell;

    @Column(name = "golden_parameters_wcell_content_type")
    private String goldenParametersWcellContentType;

    @Lob
    @Column(name = "golden_parameters_wlcse")
    private byte[] goldenParametersWlcse;

    @Column(name = "golden_parameters_wlcse_content_type")
    private String goldenParametersWlcseContentType;

    @Column(name = "adj_gid")
    private String adjGid;

    @Column(name = "adjg_ncc")
    private String adjgNcc;

    @Column(name = "adjg_bcc")
    private String adjgBcc;

    @Column(name = "adjg_bcch")
    private String adjgBcch;

    @Column(name = "adjg_band_indicator")
    private String adjgBandIndicator;

    @Column(name = "adjg_ci")
    private String adjgCi;

    @Column(name = "adjg_lac")
    private String adjgLac;

    @Column(name = "adjs_id")
    private String adjsId;

    @Column(name = "adjs_ci")
    private String adjsCi;

    @Column(name = "adjs_lac")
    private String adjsLac;

    @Column(name = "adjs_rac")
    private String adjsRac;

    @Column(name = "adjs_rn_cid")
    private String adjsRnCid;

    @Column(name = "adjs_src_code")
    private String adjsSrcCode;

    @Column(name = "adji_id")
    private String adjiId;

    @Column(name = "adji_ci")
    private String adjiCi;

    @Column(name = "adji_lac")
    private String adjiLac;

    @Column(name = "adji_rac")
    private String adjiRac;

    @Column(name = "adji_rn_cid")
    private String adjiRnCid;

    @Column(name = "adji_src_code")
    private String adjiSrcCode;

    @Column(name = "bsc_id")
    private String bscId;

    @Column(name = "bcf_id")
    private String bcfId;

    @Column(name = "bts_id")
    private String btsId;

    @Column(name = "adjw_cid")
    private String adjwCid;

    @Column(name = "adjw_lac")
    private String adjwLac;

    @Column(name = "adjw_rnc_id")
    private String adjwRncId;

    @Column(name = "scrambling_code")
    private String scramblingCode;

    @Lob
    @Column(name = "golden_parameters_adji")
    private byte[] goldenParametersAdji;

    @Column(name = "golden_parameters_adji_content_type")
    private String goldenParametersAdjiContentType;

    @Lob
    @Column(name = "golden_parameters_adjs")
    private byte[] goldenParametersAdjs;

    @Column(name = "golden_parameters_adjs_content_type")
    private String goldenParametersAdjsContentType;

    @Lob
    @Column(name = "golden_parameters_adjg")
    private byte[] goldenParametersAdjg;

    @Column(name = "golden_parameters_adjg_content_type")
    private String goldenParametersAdjgContentType;

    @Lob
    @Column(name = "golden_parameters_adjw")
    private byte[] goldenParametersAdjw;

    @Column(name = "golden_parameters_adjw_content_type")
    private String goldenParametersAdjwContentType;

    @Lob
    @Column(name = "rf_database")
    private String rfDatabase;

    @Lob
    @Column(name = "neighbor_database")
    private String neighborDatabase;

    @Lob
    @Column(name = "output_wbts")
    private byte[] outputWbts;

    @Column(name = "output_wbts_content_type")
    private String outputWbtsContentType;

    @Lob
    @Column(name = "output_wcell")
    private byte[] outputWcell;

    @Column(name = "output_wcell_content_type")
    private String outputWcellContentType;

    @Lob
    @Column(name = "output_wcell_ac")
    private byte[] outputWcellAc;

    @Column(name = "output_wcell_ac_content_type")
    private String outputWcellAcContentType;

    @Lob
    @Column(name = "output_wcell_lc")
    private byte[] outputWcellLc;

    @Column(name = "output_wcell_lc_content_type")
    private String outputWcellLcContentType;

    @Lob
    @Column(name = "output_wcell_pc")
    private byte[] outputWcellPc;

    @Column(name = "output_wcell_pc_content_type")
    private String outputWcellPcContentType;

    @Lob
    @Column(name = "output_wcell_hc")
    private byte[] outputWcellHc;

    @Column(name = "output_wcell_hc_content_type")
    private String outputWcellHcContentType;

    @Lob
    @Column(name = "output_wcell_ps")
    private byte[] outputWcellPS;

    @Column(name = "output_wcell_ps_content_type")
    private String outputWcellPSContentType;

    @Lob
    @Column(name = "output_wcell_sib")
    private byte[] outputWcellSib;

    @Column(name = "output_wcell_sib_content_type")
    private String outputWcellSibContentType;

    @Lob
    @Column(name = "output_wcell_uraid")
    private byte[] outputWcellUraid;

    @Column(name = "output_wcell_uraid_content_type")
    private String outputWcellUraidContentType;

    @Lob
    @Column(name = "output_wlcse")
    private byte[] outputWlcse;

    @Column(name = "output_wlcse_content_type")
    private String outputWlcseContentType;

    @Lob
    @Column(name = "output_adji")
    private byte[] outputAdji;

    @Column(name = "output_adji_content_type")
    private String outputAdjiContentType;

    @Lob
    @Column(name = "output_adjs")
    private byte[] outputAdjs;

    @Column(name = "output_adjs_content_type")
    private String outputAdjsContentType;

    @Lob
    @Column(name = "output_adjg")
    private byte[] outputAdjg;

    @Column(name = "output_adjg_content_type")
    private String outputAdjgContentType;

    @Lob
    @Column(name = "output_adjw")
    private byte[] outputAdjw;

    @Column(name = "output_adjw_content_type")
    private String outputAdjwContentType;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRequestName() {
        return requestName;
    }

    public NewSiteCreation requestName(String requestName) {
        this.requestName = requestName;
        return this;
    }

    public void setRequestName(String requestName) {
        this.requestName = requestName;
    }

    public String getWbtsId() {
        return wbtsId;
    }

    public NewSiteCreation wbtsId(String wbtsId) {
        this.wbtsId = wbtsId;
        return this;
    }

    public void setWbtsId(String wbtsId) {
        this.wbtsId = wbtsId;
    }

    public String getRncId() {
        return rncId;
    }

    public NewSiteCreation rncId(String rncId) {
        this.rncId = rncId;
        return this;
    }

    public void setRncId(String rncId) {
        this.rncId = rncId;
    }

    public String getWbtsName() {
        return wbtsName;
    }

    public NewSiteCreation wbtsName(String wbtsName) {
        this.wbtsName = wbtsName;
        return this;
    }

    public void setWbtsName(String wbtsName) {
        this.wbtsName = wbtsName;
    }

    public String getLcrId() {
        return lcrId;
    }

    public NewSiteCreation lcrId(String lcrId) {
        this.lcrId = lcrId;
        return this;
    }

    public void setLcrId(String lcrId) {
        this.lcrId = lcrId;
    }

    public String getLac() {
        return lac;
    }

    public NewSiteCreation lac(String lac) {
        this.lac = lac;
        return this;
    }

    public void setLac(String lac) {
        this.lac = lac;
    }

    public String getRac() {
        return rac;
    }

    public NewSiteCreation rac(String rac) {
        this.rac = rac;
        return this;
    }

    public void setRac(String rac) {
        this.rac = rac;
    }

    public String getSac() {
        return sac;
    }

    public NewSiteCreation sac(String sac) {
        this.sac = sac;
        return this;
    }

    public void setSac(String sac) {
        this.sac = sac;
    }

    public String getcId() {
        return cId;
    }

    public NewSiteCreation cId(String cId) {
        this.cId = cId;
        return this;
    }

    public void setcId(String cId) {
        this.cId = cId;
    }

    public String getTemplateName() {
        return templateName;
    }

    public NewSiteCreation templateName(String templateName) {
        this.templateName = templateName;
        return this;
    }

    public void setTemplateName(String templateName) {
        this.templateName = templateName;
    }

    public String getPriSrcCode() {
        return priSrcCode;
    }

    public NewSiteCreation priSrcCode(String priSrcCode) {
        this.priSrcCode = priSrcCode;
        return this;
    }

    public void setPriSrcCode(String priSrcCode) {
        this.priSrcCode = priSrcCode;
    }

    public String getWlcseId() {
        return wlcseId;
    }

    public NewSiteCreation wlcseId(String wlcseId) {
        this.wlcseId = wlcseId;
        return this;
    }

    public void setWlcseId(String wlcseId) {
        this.wlcseId = wlcseId;
    }

    public String getAntBearing() {
        return antBearing;
    }

    public NewSiteCreation antBearing(String antBearing) {
        this.antBearing = antBearing;
        return this;
    }

    public void setAntBearing(String antBearing) {
        this.antBearing = antBearing;
    }

    public String getWlcseRncId() {
        return wlcseRncId;
    }

    public NewSiteCreation wlcseRncId(String wlcseRncId) {
        this.wlcseRncId = wlcseRncId;
        return this;
    }

    public void setWlcseRncId(String wlcseRncId) {
        this.wlcseRncId = wlcseRncId;
    }

    public String getAntennaCoordLatitude() {
        return antennaCoordLatitude;
    }

    public NewSiteCreation antennaCoordLatitude(String antennaCoordLatitude) {
        this.antennaCoordLatitude = antennaCoordLatitude;
        return this;
    }

    public void setAntennaCoordLatitude(String antennaCoordLatitude) {
        this.antennaCoordLatitude = antennaCoordLatitude;
    }

    public String getAntennaCoordLongitude() {
        return antennaCoordLongitude;
    }

    public NewSiteCreation antennaCoordLongitude(String antennaCoordLongitude) {
        this.antennaCoordLongitude = antennaCoordLongitude;
        return this;
    }

    public void setAntennaCoordLongitude(String antennaCoordLongitude) {
        this.antennaCoordLongitude = antennaCoordLongitude;
    }

    public String getSiteName() {
        return siteName;
    }

    public NewSiteCreation siteName(String siteName) {
        this.siteName = siteName;
        return this;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }

    public String getTechnology() {
        return technology;
    }

    public NewSiteCreation technology(String technology) {
        this.technology = technology;
        return this;
    }

    public void setTechnology(String technology) {
        this.technology = technology;
    }

    public byte[] getGoldenParametersWbts() {
        return goldenParametersWbts;
    }

    public NewSiteCreation goldenParametersWbts(byte[] goldenParametersWbts) {
        this.goldenParametersWbts = goldenParametersWbts;
        return this;
    }

    public void setGoldenParametersWbts(byte[] goldenParametersWbts) {
        this.goldenParametersWbts = goldenParametersWbts;
    }

    public String getGoldenParametersWbtsContentType() {
        return goldenParametersWbtsContentType;
    }

    public NewSiteCreation goldenParametersWbtsContentType(String goldenParametersWbtsContentType) {
        this.goldenParametersWbtsContentType = goldenParametersWbtsContentType;
        return this;
    }

    public void setGoldenParametersWbtsContentType(String goldenParametersWbtsContentType) {
        this.goldenParametersWbtsContentType = goldenParametersWbtsContentType;
    }

    public byte[] getGoldenParametersWcell() {
        return goldenParametersWcell;
    }

    public NewSiteCreation goldenParametersWcell(byte[] goldenParametersWcell) {
        this.goldenParametersWcell = goldenParametersWcell;
        return this;
    }

    public void setGoldenParametersWcell(byte[] goldenParametersWcell) {
        this.goldenParametersWcell = goldenParametersWcell;
    }

    public String getGoldenParametersWcellContentType() {
        return goldenParametersWcellContentType;
    }

    public NewSiteCreation goldenParametersWcellContentType(String goldenParametersWcellContentType) {
        this.goldenParametersWcellContentType = goldenParametersWcellContentType;
        return this;
    }

    public void setGoldenParametersWcellContentType(String goldenParametersWcellContentType) {
        this.goldenParametersWcellContentType = goldenParametersWcellContentType;
    }

    public byte[] getGoldenParametersWlcse() {
        return goldenParametersWlcse;
    }

    public NewSiteCreation goldenParametersWlcse(byte[] goldenParametersWlcse) {
        this.goldenParametersWlcse = goldenParametersWlcse;
        return this;
    }

    public void setGoldenParametersWlcse(byte[] goldenParametersWlcse) {
        this.goldenParametersWlcse = goldenParametersWlcse;
    }

    public String getGoldenParametersWlcseContentType() {
        return goldenParametersWlcseContentType;
    }

    public NewSiteCreation goldenParametersWlcseContentType(String goldenParametersWlcseContentType) {
        this.goldenParametersWlcseContentType = goldenParametersWlcseContentType;
        return this;
    }

    public void setGoldenParametersWlcseContentType(String goldenParametersWlcseContentType) {
        this.goldenParametersWlcseContentType = goldenParametersWlcseContentType;
    }

    public String getAdjGid() {
        return adjGid;
    }

    public NewSiteCreation adjGid(String adjGid) {
        this.adjGid = adjGid;
        return this;
    }

    public void setAdjGid(String adjGid) {
        this.adjGid = adjGid;
    }

    public String getAdjgNcc() {
        return adjgNcc;
    }

    public NewSiteCreation adjgNcc(String adjgNcc) {
        this.adjgNcc = adjgNcc;
        return this;
    }

    public void setAdjgNcc(String adjgNcc) {
        this.adjgNcc = adjgNcc;
    }

    public String getAdjgBcc() {
        return adjgBcc;
    }

    public NewSiteCreation adjgBcc(String adjgBcc) {
        this.adjgBcc = adjgBcc;
        return this;
    }

    public void setAdjgBcc(String adjgBcc) {
        this.adjgBcc = adjgBcc;
    }

    public String getAdjgBcch() {
        return adjgBcch;
    }

    public NewSiteCreation adjgBcch(String adjgBcch) {
        this.adjgBcch = adjgBcch;
        return this;
    }

    public void setAdjgBcch(String adjgBcch) {
        this.adjgBcch = adjgBcch;
    }

    public String getAdjgBandIndicator() {
        return adjgBandIndicator;
    }

    public NewSiteCreation adjgBandIndicator(String adjgBandIndicator) {
        this.adjgBandIndicator = adjgBandIndicator;
        return this;
    }

    public void setAdjgBandIndicator(String adjgBandIndicator) {
        this.adjgBandIndicator = adjgBandIndicator;
    }

    public String getAdjgCi() {
        return adjgCi;
    }

    public NewSiteCreation adjgCi(String adjgCi) {
        this.adjgCi = adjgCi;
        return this;
    }

    public void setAdjgCi(String adjgCi) {
        this.adjgCi = adjgCi;
    }

    public String getAdjgLac() {
        return adjgLac;
    }

    public NewSiteCreation adjgLac(String adjgLac) {
        this.adjgLac = adjgLac;
        return this;
    }

    public void setAdjgLac(String adjgLac) {
        this.adjgLac = adjgLac;
    }

    public String getAdjsId() {
        return adjsId;
    }

    public NewSiteCreation adjsId(String adjsId) {
        this.adjsId = adjsId;
        return this;
    }

    public void setAdjsId(String adjsId) {
        this.adjsId = adjsId;
    }

    public String getAdjsCi() {
        return adjsCi;
    }

    public NewSiteCreation adjsCi(String adjsCi) {
        this.adjsCi = adjsCi;
        return this;
    }

    public void setAdjsCi(String adjsCi) {
        this.adjsCi = adjsCi;
    }

    public String getAdjsLac() {
        return adjsLac;
    }

    public NewSiteCreation adjsLac(String adjsLac) {
        this.adjsLac = adjsLac;
        return this;
    }

    public void setAdjsLac(String adjsLac) {
        this.adjsLac = adjsLac;
    }

    public String getAdjsRac() {
        return adjsRac;
    }

    public NewSiteCreation adjsRac(String adjsRac) {
        this.adjsRac = adjsRac;
        return this;
    }

    public void setAdjsRac(String adjsRac) {
        this.adjsRac = adjsRac;
    }

    public String getAdjsRnCid() {
        return adjsRnCid;
    }

    public NewSiteCreation adjsRnCid(String adjsRnCid) {
        this.adjsRnCid = adjsRnCid;
        return this;
    }

    public void setAdjsRnCid(String adjsRnCid) {
        this.adjsRnCid = adjsRnCid;
    }

    public String getAdjsSrcCode() {
        return adjsSrcCode;
    }

    public NewSiteCreation adjsSrcCode(String adjsSrcCode) {
        this.adjsSrcCode = adjsSrcCode;
        return this;
    }

    public void setAdjsSrcCode(String adjsSrcCode) {
        this.adjsSrcCode = adjsSrcCode;
    }

    public String getAdjiId() {
        return adjiId;
    }

    public NewSiteCreation adjiId(String adjiId) {
        this.adjiId = adjiId;
        return this;
    }

    public void setAdjiId(String adjiId) {
        this.adjiId = adjiId;
    }

    public String getAdjiCi() {
        return adjiCi;
    }

    public NewSiteCreation adjiCi(String adjiCi) {
        this.adjiCi = adjiCi;
        return this;
    }

    public void setAdjiCi(String adjiCi) {
        this.adjiCi = adjiCi;
    }

    public String getAdjiLac() {
        return adjiLac;
    }

    public NewSiteCreation adjiLac(String adjiLac) {
        this.adjiLac = adjiLac;
        return this;
    }

    public void setAdjiLac(String adjiLac) {
        this.adjiLac = adjiLac;
    }

    public String getAdjiRac() {
        return adjiRac;
    }

    public NewSiteCreation adjiRac(String adjiRac) {
        this.adjiRac = adjiRac;
        return this;
    }

    public void setAdjiRac(String adjiRac) {
        this.adjiRac = adjiRac;
    }

    public String getAdjiRnCid() {
        return adjiRnCid;
    }

    public NewSiteCreation adjiRnCid(String adjiRnCid) {
        this.adjiRnCid = adjiRnCid;
        return this;
    }

    public void setAdjiRnCid(String adjiRnCid) {
        this.adjiRnCid = adjiRnCid;
    }

    public String getAdjiSrcCode() {
        return adjiSrcCode;
    }

    public NewSiteCreation adjiSrcCode(String adjiSrcCode) {
        this.adjiSrcCode = adjiSrcCode;
        return this;
    }

    public void setAdjiSrcCode(String adjiSrcCode) {
        this.adjiSrcCode = adjiSrcCode;
    }

    public String getBscId() {
        return bscId;
    }

    public NewSiteCreation bscId(String bscId) {
        this.bscId = bscId;
        return this;
    }

    public void setBscId(String bscId) {
        this.bscId = bscId;
    }

    public String getBcfId() {
        return bcfId;
    }

    public NewSiteCreation bcfId(String bcfId) {
        this.bcfId = bcfId;
        return this;
    }

    public void setBcfId(String bcfId) {
        this.bcfId = bcfId;
    }

    public String getBtsId() {
        return btsId;
    }

    public NewSiteCreation btsId(String btsId) {
        this.btsId = btsId;
        return this;
    }

    public void setBtsId(String btsId) {
        this.btsId = btsId;
    }

    public String getAdjwCid() {
        return adjwCid;
    }

    public NewSiteCreation adjwCid(String adjwCid) {
        this.adjwCid = adjwCid;
        return this;
    }

    public void setAdjwCid(String adjwCid) {
        this.adjwCid = adjwCid;
    }

    public String getAdjwLac() {
        return adjwLac;
    }

    public NewSiteCreation adjwLac(String adjwLac) {
        this.adjwLac = adjwLac;
        return this;
    }

    public void setAdjwLac(String adjwLac) {
        this.adjwLac = adjwLac;
    }

    public String getAdjwRncId() {
        return adjwRncId;
    }

    public NewSiteCreation adjwRncId(String adjwRncId) {
        this.adjwRncId = adjwRncId;
        return this;
    }

    public void setAdjwRncId(String adjwRncId) {
        this.adjwRncId = adjwRncId;
    }

    public String getScramblingCode() {
        return scramblingCode;
    }

    public NewSiteCreation scramblingCode(String scramblingCode) {
        this.scramblingCode = scramblingCode;
        return this;
    }

    public void setScramblingCode(String scramblingCode) {
        this.scramblingCode = scramblingCode;
    }

    public byte[] getGoldenParametersAdji() {
        return goldenParametersAdji;
    }

    public NewSiteCreation goldenParametersAdji(byte[] goldenParametersAdji) {
        this.goldenParametersAdji = goldenParametersAdji;
        return this;
    }

    public void setGoldenParametersAdji(byte[] goldenParametersAdji) {
        this.goldenParametersAdji = goldenParametersAdji;
    }

    public String getGoldenParametersAdjiContentType() {
        return goldenParametersAdjiContentType;
    }

    public NewSiteCreation goldenParametersAdjiContentType(String goldenParametersAdjiContentType) {
        this.goldenParametersAdjiContentType = goldenParametersAdjiContentType;
        return this;
    }

    public void setGoldenParametersAdjiContentType(String goldenParametersAdjiContentType) {
        this.goldenParametersAdjiContentType = goldenParametersAdjiContentType;
    }

    public byte[] getGoldenParametersAdjs() {
        return goldenParametersAdjs;
    }

    public NewSiteCreation goldenParametersAdjs(byte[] goldenParametersAdjs) {
        this.goldenParametersAdjs = goldenParametersAdjs;
        return this;
    }

    public void setGoldenParametersAdjs(byte[] goldenParametersAdjs) {
        this.goldenParametersAdjs = goldenParametersAdjs;
    }

    public String getGoldenParametersAdjsContentType() {
        return goldenParametersAdjsContentType;
    }

    public NewSiteCreation goldenParametersAdjsContentType(String goldenParametersAdjsContentType) {
        this.goldenParametersAdjsContentType = goldenParametersAdjsContentType;
        return this;
    }

    public void setGoldenParametersAdjsContentType(String goldenParametersAdjsContentType) {
        this.goldenParametersAdjsContentType = goldenParametersAdjsContentType;
    }

    public byte[] getGoldenParametersAdjg() {
        return goldenParametersAdjg;
    }

    public NewSiteCreation goldenParametersAdjg(byte[] goldenParametersAdjg) {
        this.goldenParametersAdjg = goldenParametersAdjg;
        return this;
    }

    public void setGoldenParametersAdjg(byte[] goldenParametersAdjg) {
        this.goldenParametersAdjg = goldenParametersAdjg;
    }

    public String getGoldenParametersAdjgContentType() {
        return goldenParametersAdjgContentType;
    }

    public NewSiteCreation goldenParametersAdjgContentType(String goldenParametersAdjgContentType) {
        this.goldenParametersAdjgContentType = goldenParametersAdjgContentType;
        return this;
    }

    public void setGoldenParametersAdjgContentType(String goldenParametersAdjgContentType) {
        this.goldenParametersAdjgContentType = goldenParametersAdjgContentType;
    }

    public byte[] getGoldenParametersAdjw() {
        return goldenParametersAdjw;
    }

    public NewSiteCreation goldenParametersAdjw(byte[] goldenParametersAdjw) {
        this.goldenParametersAdjw = goldenParametersAdjw;
        return this;
    }

    public void setGoldenParametersAdjw(byte[] goldenParametersAdjw) {
        this.goldenParametersAdjw = goldenParametersAdjw;
    }

    public String getGoldenParametersAdjwContentType() {
        return goldenParametersAdjwContentType;
    }

    public NewSiteCreation goldenParametersAdjwContentType(String goldenParametersAdjwContentType) {
        this.goldenParametersAdjwContentType = goldenParametersAdjwContentType;
        return this;
    }

    public void setGoldenParametersAdjwContentType(String goldenParametersAdjwContentType) {
        this.goldenParametersAdjwContentType = goldenParametersAdjwContentType;
    }

    public String getRfDatabase() {
        return rfDatabase;
    }

    public NewSiteCreation rfDatabase(String rfDatabase) {
        this.rfDatabase = rfDatabase;
        return this;
    }

    public void setRfDatabase(String rfDatabase) {
        this.rfDatabase = rfDatabase;
    }

    public String getNeighborDatabase() {
        return neighborDatabase;
    }

    public NewSiteCreation neighborDatabase(String neighborDatabase) {
        this.neighborDatabase = neighborDatabase;
        return this;
    }

    public void setNeighborDatabase(String neighborDatabase) {
        this.neighborDatabase = neighborDatabase;
    }

    public byte[] getOutputWbts() {
        return outputWbts;
    }

    public NewSiteCreation outputWbts(byte[] outputWbts) {
        this.outputWbts = outputWbts;
        return this;
    }

    public void setOutputWbts(byte[] outputWbts) {
        this.outputWbts = outputWbts;
    }

    public String getOutputWbtsContentType() {
        return outputWbtsContentType;
    }

    public NewSiteCreation outputWbtsContentType(String outputWbtsContentType) {
        this.outputWbtsContentType = outputWbtsContentType;
        return this;
    }

    public void setOutputWbtsContentType(String outputWbtsContentType) {
        this.outputWbtsContentType = outputWbtsContentType;
    }

    public byte[] getOutputWcell() {
        return outputWcell;
    }

    public NewSiteCreation outputWcell(byte[] outputWcell) {
        this.outputWcell = outputWcell;
        return this;
    }

    public void setOutputWcell(byte[] outputWcell) {
        this.outputWcell = outputWcell;
    }

    public String getOutputWcellContentType() {
        return outputWcellContentType;
    }

    public NewSiteCreation outputWcellContentType(String outputWcellContentType) {
        this.outputWcellContentType = outputWcellContentType;
        return this;
    }

    public void setOutputWcellContentType(String outputWcellContentType) {
        this.outputWcellContentType = outputWcellContentType;
    }

    public byte[] getOutputWcellAc() {
        return outputWcellAc;
    }

    public NewSiteCreation outputWcellAc(byte[] outputWcellAc) {
        this.outputWcellAc = outputWcellAc;
        return this;
    }

    public void setOutputWcellAc(byte[] outputWcellAc) {
        this.outputWcellAc = outputWcellAc;
    }

    public String getOutputWcellAcContentType() {
        return outputWcellAcContentType;
    }

    public NewSiteCreation outputWcellAcContentType(String outputWcellAcContentType) {
        this.outputWcellAcContentType = outputWcellAcContentType;
        return this;
    }

    public void setOutputWcellAcContentType(String outputWcellAcContentType) {
        this.outputWcellAcContentType = outputWcellAcContentType;
    }

    public byte[] getOutputWcellLc() {
        return outputWcellLc;
    }

    public NewSiteCreation outputWcellLc(byte[] outputWcellLc) {
        this.outputWcellLc = outputWcellLc;
        return this;
    }

    public void setOutputWcellLc(byte[] outputWcellLc) {
        this.outputWcellLc = outputWcellLc;
    }

    public String getOutputWcellLcContentType() {
        return outputWcellLcContentType;
    }

    public NewSiteCreation outputWcellLcContentType(String outputWcellLcContentType) {
        this.outputWcellLcContentType = outputWcellLcContentType;
        return this;
    }

    public void setOutputWcellLcContentType(String outputWcellLcContentType) {
        this.outputWcellLcContentType = outputWcellLcContentType;
    }

    public byte[] getOutputWcellPc() {
        return outputWcellPc;
    }

    public NewSiteCreation outputWcellPc(byte[] outputWcellPc) {
        this.outputWcellPc = outputWcellPc;
        return this;
    }

    public void setOutputWcellPc(byte[] outputWcellPc) {
        this.outputWcellPc = outputWcellPc;
    }

    public String getOutputWcellPcContentType() {
        return outputWcellPcContentType;
    }

    public NewSiteCreation outputWcellPcContentType(String outputWcellPcContentType) {
        this.outputWcellPcContentType = outputWcellPcContentType;
        return this;
    }

    public void setOutputWcellPcContentType(String outputWcellPcContentType) {
        this.outputWcellPcContentType = outputWcellPcContentType;
    }

    public byte[] getOutputWcellHc() {
        return outputWcellHc;
    }

    public NewSiteCreation outputWcellHc(byte[] outputWcellHc) {
        this.outputWcellHc = outputWcellHc;
        return this;
    }

    public void setOutputWcellHc(byte[] outputWcellHc) {
        this.outputWcellHc = outputWcellHc;
    }

    public String getOutputWcellHcContentType() {
        return outputWcellHcContentType;
    }

    public NewSiteCreation outputWcellHcContentType(String outputWcellHcContentType) {
        this.outputWcellHcContentType = outputWcellHcContentType;
        return this;
    }

    public void setOutputWcellHcContentType(String outputWcellHcContentType) {
        this.outputWcellHcContentType = outputWcellHcContentType;
    }

    public byte[] getOutputWcellPS() {
        return outputWcellPS;
    }

    public NewSiteCreation outputWcellPS(byte[] outputWcellPS) {
        this.outputWcellPS = outputWcellPS;
        return this;
    }

    public void setOutputWcellPS(byte[] outputWcellPS) {
        this.outputWcellPS = outputWcellPS;
    }

    public String getOutputWcellPSContentType() {
        return outputWcellPSContentType;
    }

    public NewSiteCreation outputWcellPSContentType(String outputWcellPSContentType) {
        this.outputWcellPSContentType = outputWcellPSContentType;
        return this;
    }

    public void setOutputWcellPSContentType(String outputWcellPSContentType) {
        this.outputWcellPSContentType = outputWcellPSContentType;
    }

    public byte[] getOutputWcellSib() {
        return outputWcellSib;
    }

    public NewSiteCreation outputWcellSib(byte[] outputWcellSib) {
        this.outputWcellSib = outputWcellSib;
        return this;
    }

    public void setOutputWcellSib(byte[] outputWcellSib) {
        this.outputWcellSib = outputWcellSib;
    }

    public String getOutputWcellSibContentType() {
        return outputWcellSibContentType;
    }

    public NewSiteCreation outputWcellSibContentType(String outputWcellSibContentType) {
        this.outputWcellSibContentType = outputWcellSibContentType;
        return this;
    }

    public void setOutputWcellSibContentType(String outputWcellSibContentType) {
        this.outputWcellSibContentType = outputWcellSibContentType;
    }

    public byte[] getOutputWcellUraid() {
        return outputWcellUraid;
    }

    public NewSiteCreation outputWcellUraid(byte[] outputWcellUraid) {
        this.outputWcellUraid = outputWcellUraid;
        return this;
    }

    public void setOutputWcellUraid(byte[] outputWcellUraid) {
        this.outputWcellUraid = outputWcellUraid;
    }

    public String getOutputWcellUraidContentType() {
        return outputWcellUraidContentType;
    }

    public NewSiteCreation outputWcellUraidContentType(String outputWcellUraidContentType) {
        this.outputWcellUraidContentType = outputWcellUraidContentType;
        return this;
    }

    public void setOutputWcellUraidContentType(String outputWcellUraidContentType) {
        this.outputWcellUraidContentType = outputWcellUraidContentType;
    }

    public byte[] getOutputWlcse() {
        return outputWlcse;
    }

    public NewSiteCreation outputWlcse(byte[] outputWlcse) {
        this.outputWlcse = outputWlcse;
        return this;
    }

    public void setOutputWlcse(byte[] outputWlcse) {
        this.outputWlcse = outputWlcse;
    }

    public String getOutputWlcseContentType() {
        return outputWlcseContentType;
    }

    public NewSiteCreation outputWlcseContentType(String outputWlcseContentType) {
        this.outputWlcseContentType = outputWlcseContentType;
        return this;
    }

    public void setOutputWlcseContentType(String outputWlcseContentType) {
        this.outputWlcseContentType = outputWlcseContentType;
    }

    public byte[] getOutputAdji() {
        return outputAdji;
    }

    public NewSiteCreation outputAdji(byte[] outputAdji) {
        this.outputAdji = outputAdji;
        return this;
    }

    public void setOutputAdji(byte[] outputAdji) {
        this.outputAdji = outputAdji;
    }

    public String getOutputAdjiContentType() {
        return outputAdjiContentType;
    }

    public NewSiteCreation outputAdjiContentType(String outputAdjiContentType) {
        this.outputAdjiContentType = outputAdjiContentType;
        return this;
    }

    public void setOutputAdjiContentType(String outputAdjiContentType) {
        this.outputAdjiContentType = outputAdjiContentType;
    }

    public byte[] getOutputAdjs() {
        return outputAdjs;
    }

    public NewSiteCreation outputAdjs(byte[] outputAdjs) {
        this.outputAdjs = outputAdjs;
        return this;
    }

    public void setOutputAdjs(byte[] outputAdjs) {
        this.outputAdjs = outputAdjs;
    }

    public String getOutputAdjsContentType() {
        return outputAdjsContentType;
    }

    public NewSiteCreation outputAdjsContentType(String outputAdjsContentType) {
        this.outputAdjsContentType = outputAdjsContentType;
        return this;
    }

    public void setOutputAdjsContentType(String outputAdjsContentType) {
        this.outputAdjsContentType = outputAdjsContentType;
    }

    public byte[] getOutputAdjg() {
        return outputAdjg;
    }

    public NewSiteCreation outputAdjg(byte[] outputAdjg) {
        this.outputAdjg = outputAdjg;
        return this;
    }

    public void setOutputAdjg(byte[] outputAdjg) {
        this.outputAdjg = outputAdjg;
    }

    public String getOutputAdjgContentType() {
        return outputAdjgContentType;
    }

    public NewSiteCreation outputAdjgContentType(String outputAdjgContentType) {
        this.outputAdjgContentType = outputAdjgContentType;
        return this;
    }

    public void setOutputAdjgContentType(String outputAdjgContentType) {
        this.outputAdjgContentType = outputAdjgContentType;
    }

    public byte[] getOutputAdjw() {
        return outputAdjw;
    }

    public NewSiteCreation outputAdjw(byte[] outputAdjw) {
        this.outputAdjw = outputAdjw;
        return this;
    }

    public void setOutputAdjw(byte[] outputAdjw) {
        this.outputAdjw = outputAdjw;
    }

    public String getOutputAdjwContentType() {
        return outputAdjwContentType;
    }

    public NewSiteCreation outputAdjwContentType(String outputAdjwContentType) {
        this.outputAdjwContentType = outputAdjwContentType;
        return this;
    }

    public void setOutputAdjwContentType(String outputAdjwContentType) {
        this.outputAdjwContentType = outputAdjwContentType;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        NewSiteCreation newSiteCreation = (NewSiteCreation) o;
        if (newSiteCreation.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), newSiteCreation.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "NewSiteCreation{" +
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
            ", goldenParametersWbtsContentType='" + getGoldenParametersWbtsContentType() + "'" +
            ", goldenParametersWcell='" + getGoldenParametersWcell() + "'" +
            ", goldenParametersWcellContentType='" + getGoldenParametersWcellContentType() + "'" +
            ", goldenParametersWlcse='" + getGoldenParametersWlcse() + "'" +
            ", goldenParametersWlcseContentType='" + getGoldenParametersWlcseContentType() + "'" +
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
            ", goldenParametersAdjiContentType='" + getGoldenParametersAdjiContentType() + "'" +
            ", goldenParametersAdjs='" + getGoldenParametersAdjs() + "'" +
            ", goldenParametersAdjsContentType='" + getGoldenParametersAdjsContentType() + "'" +
            ", goldenParametersAdjg='" + getGoldenParametersAdjg() + "'" +
            ", goldenParametersAdjgContentType='" + getGoldenParametersAdjgContentType() + "'" +
            ", goldenParametersAdjw='" + getGoldenParametersAdjw() + "'" +
            ", goldenParametersAdjwContentType='" + getGoldenParametersAdjwContentType() + "'" +
            ", rfDatabase='" + getRfDatabase() + "'" +
            ", neighborDatabase='" + getNeighborDatabase() + "'" +
            ", outputWbts='" + getOutputWbts() + "'" +
            ", outputWbtsContentType='" + getOutputWbtsContentType() + "'" +
            ", outputWcell='" + getOutputWcell() + "'" +
            ", outputWcellContentType='" + getOutputWcellContentType() + "'" +
            ", outputWcellAc='" + getOutputWcellAc() + "'" +
            ", outputWcellAcContentType='" + getOutputWcellAcContentType() + "'" +
            ", outputWcellLc='" + getOutputWcellLc() + "'" +
            ", outputWcellLcContentType='" + getOutputWcellLcContentType() + "'" +
            ", outputWcellPc='" + getOutputWcellPc() + "'" +
            ", outputWcellPcContentType='" + getOutputWcellPcContentType() + "'" +
            ", outputWcellHc='" + getOutputWcellHc() + "'" +
            ", outputWcellHcContentType='" + getOutputWcellHcContentType() + "'" +
            ", outputWcellPS='" + getOutputWcellPS() + "'" +
            ", outputWcellPSContentType='" + getOutputWcellPSContentType() + "'" +
            ", outputWcellSib='" + getOutputWcellSib() + "'" +
            ", outputWcellSibContentType='" + getOutputWcellSibContentType() + "'" +
            ", outputWcellUraid='" + getOutputWcellUraid() + "'" +
            ", outputWcellUraidContentType='" + getOutputWcellUraidContentType() + "'" +
            ", outputWlcse='" + getOutputWlcse() + "'" +
            ", outputWlcseContentType='" + getOutputWlcseContentType() + "'" +
            ", outputAdji='" + getOutputAdji() + "'" +
            ", outputAdjiContentType='" + getOutputAdjiContentType() + "'" +
            ", outputAdjs='" + getOutputAdjs() + "'" +
            ", outputAdjsContentType='" + getOutputAdjsContentType() + "'" +
            ", outputAdjg='" + getOutputAdjg() + "'" +
            ", outputAdjgContentType='" + getOutputAdjgContentType() + "'" +
            ", outputAdjw='" + getOutputAdjw() + "'" +
            ", outputAdjwContentType='" + getOutputAdjwContentType() + "'" +
            "}";
    }
}
