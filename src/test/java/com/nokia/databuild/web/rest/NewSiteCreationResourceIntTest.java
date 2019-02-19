package com.nokia.databuild.web.rest;

import com.nokia.databuild.DatabuildJavaApp;

import com.nokia.databuild.domain.NewSiteCreation;
import com.nokia.databuild.repository.NewSiteCreationRepository;
import com.nokia.databuild.service.NewSiteCreationService;
import com.nokia.databuild.service.dto.NewSiteCreationDTO;
import com.nokia.databuild.service.mapper.NewSiteCreationMapper;
import com.nokia.databuild.web.rest.errors.ExceptionTranslator;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Base64Utils;

import javax.persistence.EntityManager;
import java.util.List;


import static com.nokia.databuild.web.rest.TestUtil.createFormattingConversionService;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Test class for the NewSiteCreationResource REST controller.
 *
 * @see NewSiteCreationResource
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = DatabuildJavaApp.class)
public class NewSiteCreationResourceIntTest {

    private static final String DEFAULT_REQUEST_NAME = "AAAAAAAAAA";
    private static final String UPDATED_REQUEST_NAME = "BBBBBBBBBB";

    private static final String DEFAULT_WBTS_ID = "AAAAAAAAAA";
    private static final String UPDATED_WBTS_ID = "BBBBBBBBBB";

    private static final String DEFAULT_RNC_ID = "AAAAAAAAAA";
    private static final String UPDATED_RNC_ID = "BBBBBBBBBB";

    private static final String DEFAULT_WBTS_NAME = "AAAAAAAAAA";
    private static final String UPDATED_WBTS_NAME = "BBBBBBBBBB";

    private static final String DEFAULT_LCR_ID = "AAAAAAAAAA";
    private static final String UPDATED_LCR_ID = "BBBBBBBBBB";

    private static final String DEFAULT_LAC = "AAAAAAAAAA";
    private static final String UPDATED_LAC = "BBBBBBBBBB";

    private static final String DEFAULT_RAC = "AAAAAAAAAA";
    private static final String UPDATED_RAC = "BBBBBBBBBB";

    private static final String DEFAULT_SAC = "AAAAAAAAAA";
    private static final String UPDATED_SAC = "BBBBBBBBBB";

    private static final String DEFAULT_C_ID = "AAAAAAAAAA";
    private static final String UPDATED_C_ID = "BBBBBBBBBB";

    private static final String DEFAULT_TEMPLATE_NAME = "AAAAAAAAAA";
    private static final String UPDATED_TEMPLATE_NAME = "BBBBBBBBBB";

    private static final String DEFAULT_PRI_SRC_CODE = "AAAAAAAAAA";
    private static final String UPDATED_PRI_SRC_CODE = "BBBBBBBBBB";

    private static final String DEFAULT_WLCSE_ID = "AAAAAAAAAA";
    private static final String UPDATED_WLCSE_ID = "BBBBBBBBBB";

    private static final String DEFAULT_ANT_BEARING = "AAAAAAAAAA";
    private static final String UPDATED_ANT_BEARING = "BBBBBBBBBB";

    private static final String DEFAULT_WLCSE_RNC_ID = "AAAAAAAAAA";
    private static final String UPDATED_WLCSE_RNC_ID = "BBBBBBBBBB";

    private static final String DEFAULT_ANTENNA_COORD_LATITUDE = "AAAAAAAAAA";
    private static final String UPDATED_ANTENNA_COORD_LATITUDE = "BBBBBBBBBB";

    private static final String DEFAULT_ANTENNA_COORD_LONGITUDE = "AAAAAAAAAA";
    private static final String UPDATED_ANTENNA_COORD_LONGITUDE = "BBBBBBBBBB";

    private static final String DEFAULT_SITE_NAME = "AAAAAAAAAA";
    private static final String UPDATED_SITE_NAME = "BBBBBBBBBB";

    private static final String DEFAULT_TECHNOLOGY = "AAAAAAAAAA";
    private static final String UPDATED_TECHNOLOGY = "BBBBBBBBBB";

    private static final byte[] DEFAULT_GOLDEN_PARAMETERS_WBTS = TestUtil.createByteArray(1, "0");
    private static final byte[] UPDATED_GOLDEN_PARAMETERS_WBTS = TestUtil.createByteArray(1, "1");
    private static final String DEFAULT_GOLDEN_PARAMETERS_WBTS_CONTENT_TYPE = "image/jpg";
    private static final String UPDATED_GOLDEN_PARAMETERS_WBTS_CONTENT_TYPE = "image/png";

    private static final byte[] DEFAULT_GOLDEN_PARAMETERS_WCELL = TestUtil.createByteArray(1, "0");
    private static final byte[] UPDATED_GOLDEN_PARAMETERS_WCELL = TestUtil.createByteArray(1, "1");
    private static final String DEFAULT_GOLDEN_PARAMETERS_WCELL_CONTENT_TYPE = "image/jpg";
    private static final String UPDATED_GOLDEN_PARAMETERS_WCELL_CONTENT_TYPE = "image/png";

    private static final byte[] DEFAULT_GOLDEN_PARAMETERS_WLCSE = TestUtil.createByteArray(1, "0");
    private static final byte[] UPDATED_GOLDEN_PARAMETERS_WLCSE = TestUtil.createByteArray(1, "1");
    private static final String DEFAULT_GOLDEN_PARAMETERS_WLCSE_CONTENT_TYPE = "image/jpg";
    private static final String UPDATED_GOLDEN_PARAMETERS_WLCSE_CONTENT_TYPE = "image/png";

    private static final String DEFAULT_ADJ_GID = "AAAAAAAAAA";
    private static final String UPDATED_ADJ_GID = "BBBBBBBBBB";

    private static final String DEFAULT_ADJG_NCC = "AAAAAAAAAA";
    private static final String UPDATED_ADJG_NCC = "BBBBBBBBBB";

    private static final String DEFAULT_ADJG_BCC = "AAAAAAAAAA";
    private static final String UPDATED_ADJG_BCC = "BBBBBBBBBB";

    private static final String DEFAULT_ADJG_BCCH = "AAAAAAAAAA";
    private static final String UPDATED_ADJG_BCCH = "BBBBBBBBBB";

    private static final String DEFAULT_ADJG_BAND_INDICATOR = "AAAAAAAAAA";
    private static final String UPDATED_ADJG_BAND_INDICATOR = "BBBBBBBBBB";

    private static final String DEFAULT_ADJG_CI = "AAAAAAAAAA";
    private static final String UPDATED_ADJG_CI = "BBBBBBBBBB";

    private static final String DEFAULT_ADJG_LAC = "AAAAAAAAAA";
    private static final String UPDATED_ADJG_LAC = "BBBBBBBBBB";

    private static final String DEFAULT_ADJS_ID = "AAAAAAAAAA";
    private static final String UPDATED_ADJS_ID = "BBBBBBBBBB";

    private static final String DEFAULT_ADJS_CI = "AAAAAAAAAA";
    private static final String UPDATED_ADJS_CI = "BBBBBBBBBB";

    private static final String DEFAULT_ADJS_LAC = "AAAAAAAAAA";
    private static final String UPDATED_ADJS_LAC = "BBBBBBBBBB";

    private static final String DEFAULT_ADJS_RAC = "AAAAAAAAAA";
    private static final String UPDATED_ADJS_RAC = "BBBBBBBBBB";

    private static final String DEFAULT_ADJS_RN_CID = "AAAAAAAAAA";
    private static final String UPDATED_ADJS_RN_CID = "BBBBBBBBBB";

    private static final String DEFAULT_ADJS_SRC_CODE = "AAAAAAAAAA";
    private static final String UPDATED_ADJS_SRC_CODE = "BBBBBBBBBB";

    private static final String DEFAULT_ADJI_ID = "AAAAAAAAAA";
    private static final String UPDATED_ADJI_ID = "BBBBBBBBBB";

    private static final String DEFAULT_ADJI_CI = "AAAAAAAAAA";
    private static final String UPDATED_ADJI_CI = "BBBBBBBBBB";

    private static final String DEFAULT_ADJI_LAC = "AAAAAAAAAA";
    private static final String UPDATED_ADJI_LAC = "BBBBBBBBBB";

    private static final String DEFAULT_ADJI_RAC = "AAAAAAAAAA";
    private static final String UPDATED_ADJI_RAC = "BBBBBBBBBB";

    private static final String DEFAULT_ADJI_RN_CID = "AAAAAAAAAA";
    private static final String UPDATED_ADJI_RN_CID = "BBBBBBBBBB";

    private static final String DEFAULT_ADJI_SRC_CODE = "AAAAAAAAAA";
    private static final String UPDATED_ADJI_SRC_CODE = "BBBBBBBBBB";

    private static final String DEFAULT_BSC_ID = "AAAAAAAAAA";
    private static final String UPDATED_BSC_ID = "BBBBBBBBBB";

    private static final String DEFAULT_BCF_ID = "AAAAAAAAAA";
    private static final String UPDATED_BCF_ID = "BBBBBBBBBB";

    private static final String DEFAULT_BTS_ID = "AAAAAAAAAA";
    private static final String UPDATED_BTS_ID = "BBBBBBBBBB";

    private static final String DEFAULT_ADJW_CID = "AAAAAAAAAA";
    private static final String UPDATED_ADJW_CID = "BBBBBBBBBB";

    private static final String DEFAULT_ADJW_LAC = "AAAAAAAAAA";
    private static final String UPDATED_ADJW_LAC = "BBBBBBBBBB";

    private static final String DEFAULT_ADJW_RNC_ID = "AAAAAAAAAA";
    private static final String UPDATED_ADJW_RNC_ID = "BBBBBBBBBB";

    private static final String DEFAULT_SCRAMBLING_CODE = "AAAAAAAAAA";
    private static final String UPDATED_SCRAMBLING_CODE = "BBBBBBBBBB";

    private static final byte[] DEFAULT_GOLDEN_PARAMETERS_ADJI = TestUtil.createByteArray(1, "0");
    private static final byte[] UPDATED_GOLDEN_PARAMETERS_ADJI = TestUtil.createByteArray(1, "1");
    private static final String DEFAULT_GOLDEN_PARAMETERS_ADJI_CONTENT_TYPE = "image/jpg";
    private static final String UPDATED_GOLDEN_PARAMETERS_ADJI_CONTENT_TYPE = "image/png";

    private static final byte[] DEFAULT_GOLDEN_PARAMETERS_ADJS = TestUtil.createByteArray(1, "0");
    private static final byte[] UPDATED_GOLDEN_PARAMETERS_ADJS = TestUtil.createByteArray(1, "1");
    private static final String DEFAULT_GOLDEN_PARAMETERS_ADJS_CONTENT_TYPE = "image/jpg";
    private static final String UPDATED_GOLDEN_PARAMETERS_ADJS_CONTENT_TYPE = "image/png";

    private static final byte[] DEFAULT_GOLDEN_PARAMETERS_ADJG = TestUtil.createByteArray(1, "0");
    private static final byte[] UPDATED_GOLDEN_PARAMETERS_ADJG = TestUtil.createByteArray(1, "1");
    private static final String DEFAULT_GOLDEN_PARAMETERS_ADJG_CONTENT_TYPE = "image/jpg";
    private static final String UPDATED_GOLDEN_PARAMETERS_ADJG_CONTENT_TYPE = "image/png";

    private static final byte[] DEFAULT_GOLDEN_PARAMETERS_ADJW = TestUtil.createByteArray(1, "0");
    private static final byte[] UPDATED_GOLDEN_PARAMETERS_ADJW = TestUtil.createByteArray(1, "1");
    private static final String DEFAULT_GOLDEN_PARAMETERS_ADJW_CONTENT_TYPE = "image/jpg";
    private static final String UPDATED_GOLDEN_PARAMETERS_ADJW_CONTENT_TYPE = "image/png";

    private static final String DEFAULT_RF_DATABASE = "AAAAAAAAAA";
    private static final String UPDATED_RF_DATABASE = "BBBBBBBBBB";

    private static final String DEFAULT_NEIGHBOR_DATABASE = "AAAAAAAAAA";
    private static final String UPDATED_NEIGHBOR_DATABASE = "BBBBBBBBBB";

    private static final byte[] DEFAULT_OUTPUT_WBTS = TestUtil.createByteArray(1, "0");
    private static final byte[] UPDATED_OUTPUT_WBTS = TestUtil.createByteArray(1, "1");
    private static final String DEFAULT_OUTPUT_WBTS_CONTENT_TYPE = "image/jpg";
    private static final String UPDATED_OUTPUT_WBTS_CONTENT_TYPE = "image/png";

    private static final byte[] DEFAULT_OUTPUT_WCELL = TestUtil.createByteArray(1, "0");
    private static final byte[] UPDATED_OUTPUT_WCELL = TestUtil.createByteArray(1, "1");
    private static final String DEFAULT_OUTPUT_WCELL_CONTENT_TYPE = "image/jpg";
    private static final String UPDATED_OUTPUT_WCELL_CONTENT_TYPE = "image/png";

    private static final byte[] DEFAULT_OUTPUT_WCELL_AC = TestUtil.createByteArray(1, "0");
    private static final byte[] UPDATED_OUTPUT_WCELL_AC = TestUtil.createByteArray(1, "1");
    private static final String DEFAULT_OUTPUT_WCELL_AC_CONTENT_TYPE = "image/jpg";
    private static final String UPDATED_OUTPUT_WCELL_AC_CONTENT_TYPE = "image/png";

    private static final byte[] DEFAULT_OUTPUT_WCELL_LC = TestUtil.createByteArray(1, "0");
    private static final byte[] UPDATED_OUTPUT_WCELL_LC = TestUtil.createByteArray(1, "1");
    private static final String DEFAULT_OUTPUT_WCELL_LC_CONTENT_TYPE = "image/jpg";
    private static final String UPDATED_OUTPUT_WCELL_LC_CONTENT_TYPE = "image/png";

    private static final byte[] DEFAULT_OUTPUT_WCELL_PC = TestUtil.createByteArray(1, "0");
    private static final byte[] UPDATED_OUTPUT_WCELL_PC = TestUtil.createByteArray(1, "1");
    private static final String DEFAULT_OUTPUT_WCELL_PC_CONTENT_TYPE = "image/jpg";
    private static final String UPDATED_OUTPUT_WCELL_PC_CONTENT_TYPE = "image/png";

    private static final byte[] DEFAULT_OUTPUT_WCELL_HC = TestUtil.createByteArray(1, "0");
    private static final byte[] UPDATED_OUTPUT_WCELL_HC = TestUtil.createByteArray(1, "1");
    private static final String DEFAULT_OUTPUT_WCELL_HC_CONTENT_TYPE = "image/jpg";
    private static final String UPDATED_OUTPUT_WCELL_HC_CONTENT_TYPE = "image/png";

    private static final byte[] DEFAULT_OUTPUT_WCELL_PS = TestUtil.createByteArray(1, "0");
    private static final byte[] UPDATED_OUTPUT_WCELL_PS = TestUtil.createByteArray(1, "1");
    private static final String DEFAULT_OUTPUT_WCELL_PS_CONTENT_TYPE = "image/jpg";
    private static final String UPDATED_OUTPUT_WCELL_PS_CONTENT_TYPE = "image/png";

    private static final byte[] DEFAULT_OUTPUT_WCELL_SIB = TestUtil.createByteArray(1, "0");
    private static final byte[] UPDATED_OUTPUT_WCELL_SIB = TestUtil.createByteArray(1, "1");
    private static final String DEFAULT_OUTPUT_WCELL_SIB_CONTENT_TYPE = "image/jpg";
    private static final String UPDATED_OUTPUT_WCELL_SIB_CONTENT_TYPE = "image/png";

    private static final byte[] DEFAULT_OUTPUT_WCELL_URAID = TestUtil.createByteArray(1, "0");
    private static final byte[] UPDATED_OUTPUT_WCELL_URAID = TestUtil.createByteArray(1, "1");
    private static final String DEFAULT_OUTPUT_WCELL_URAID_CONTENT_TYPE = "image/jpg";
    private static final String UPDATED_OUTPUT_WCELL_URAID_CONTENT_TYPE = "image/png";

    private static final byte[] DEFAULT_OUTPUT_WLCSE = TestUtil.createByteArray(1, "0");
    private static final byte[] UPDATED_OUTPUT_WLCSE = TestUtil.createByteArray(1, "1");
    private static final String DEFAULT_OUTPUT_WLCSE_CONTENT_TYPE = "image/jpg";
    private static final String UPDATED_OUTPUT_WLCSE_CONTENT_TYPE = "image/png";

    private static final byte[] DEFAULT_OUTPUT_ADJI = TestUtil.createByteArray(1, "0");
    private static final byte[] UPDATED_OUTPUT_ADJI = TestUtil.createByteArray(1, "1");
    private static final String DEFAULT_OUTPUT_ADJI_CONTENT_TYPE = "image/jpg";
    private static final String UPDATED_OUTPUT_ADJI_CONTENT_TYPE = "image/png";

    private static final byte[] DEFAULT_OUTPUT_ADJS = TestUtil.createByteArray(1, "0");
    private static final byte[] UPDATED_OUTPUT_ADJS = TestUtil.createByteArray(1, "1");
    private static final String DEFAULT_OUTPUT_ADJS_CONTENT_TYPE = "image/jpg";
    private static final String UPDATED_OUTPUT_ADJS_CONTENT_TYPE = "image/png";

    private static final byte[] DEFAULT_OUTPUT_ADJG = TestUtil.createByteArray(1, "0");
    private static final byte[] UPDATED_OUTPUT_ADJG = TestUtil.createByteArray(1, "1");
    private static final String DEFAULT_OUTPUT_ADJG_CONTENT_TYPE = "image/jpg";
    private static final String UPDATED_OUTPUT_ADJG_CONTENT_TYPE = "image/png";

    private static final byte[] DEFAULT_OUTPUT_ADJW = TestUtil.createByteArray(1, "0");
    private static final byte[] UPDATED_OUTPUT_ADJW = TestUtil.createByteArray(1, "1");
    private static final String DEFAULT_OUTPUT_ADJW_CONTENT_TYPE = "image/jpg";
    private static final String UPDATED_OUTPUT_ADJW_CONTENT_TYPE = "image/png";

    @Autowired
    private NewSiteCreationRepository newSiteCreationRepository;

    @Autowired
    private NewSiteCreationMapper newSiteCreationMapper;
    
    @Autowired
    private NewSiteCreationService newSiteCreationService;

    @Autowired
    private MappingJackson2HttpMessageConverter jacksonMessageConverter;

    @Autowired
    private PageableHandlerMethodArgumentResolver pageableArgumentResolver;

    @Autowired
    private ExceptionTranslator exceptionTranslator;

    @Autowired
    private EntityManager em;

    private MockMvc restNewSiteCreationMockMvc;

    private NewSiteCreation newSiteCreation;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        final NewSiteCreationResource newSiteCreationResource = new NewSiteCreationResource(newSiteCreationService);
        this.restNewSiteCreationMockMvc = MockMvcBuilders.standaloneSetup(newSiteCreationResource)
            .setCustomArgumentResolvers(pageableArgumentResolver)
            .setControllerAdvice(exceptionTranslator)
            .setConversionService(createFormattingConversionService())
            .setMessageConverters(jacksonMessageConverter).build();
    }

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static NewSiteCreation createEntity(EntityManager em) {
        NewSiteCreation newSiteCreation = new NewSiteCreation()
            .requestName(DEFAULT_REQUEST_NAME)
            .wbtsId(DEFAULT_WBTS_ID)
            .rncId(DEFAULT_RNC_ID)
            .wbtsName(DEFAULT_WBTS_NAME)
            .lcrId(DEFAULT_LCR_ID)
            .lac(DEFAULT_LAC)
            .rac(DEFAULT_RAC)
            .sac(DEFAULT_SAC)
            .cId(DEFAULT_C_ID)
            .templateName(DEFAULT_TEMPLATE_NAME)
            .priSrcCode(DEFAULT_PRI_SRC_CODE)
            .wlcseId(DEFAULT_WLCSE_ID)
            .antBearing(DEFAULT_ANT_BEARING)
            .wlcseRncId(DEFAULT_WLCSE_RNC_ID)
            .antennaCoordLatitude(DEFAULT_ANTENNA_COORD_LATITUDE)
            .antennaCoordLongitude(DEFAULT_ANTENNA_COORD_LONGITUDE)
            .siteName(DEFAULT_SITE_NAME)
            .technology(DEFAULT_TECHNOLOGY)
            .goldenParametersWbts(DEFAULT_GOLDEN_PARAMETERS_WBTS)
            .goldenParametersWbtsContentType(DEFAULT_GOLDEN_PARAMETERS_WBTS_CONTENT_TYPE)
            .goldenParametersWcell(DEFAULT_GOLDEN_PARAMETERS_WCELL)
            .goldenParametersWcellContentType(DEFAULT_GOLDEN_PARAMETERS_WCELL_CONTENT_TYPE)
            .goldenParametersWlcse(DEFAULT_GOLDEN_PARAMETERS_WLCSE)
            .goldenParametersWlcseContentType(DEFAULT_GOLDEN_PARAMETERS_WLCSE_CONTENT_TYPE)
            .adjGid(DEFAULT_ADJ_GID)
            .adjgNcc(DEFAULT_ADJG_NCC)
            .adjgBcc(DEFAULT_ADJG_BCC)
            .adjgBcch(DEFAULT_ADJG_BCCH)
            .adjgBandIndicator(DEFAULT_ADJG_BAND_INDICATOR)
            .adjgCi(DEFAULT_ADJG_CI)
            .adjgLac(DEFAULT_ADJG_LAC)
            .adjsId(DEFAULT_ADJS_ID)
            .adjsCi(DEFAULT_ADJS_CI)
            .adjsLac(DEFAULT_ADJS_LAC)
            .adjsRac(DEFAULT_ADJS_RAC)
            .adjsRnCid(DEFAULT_ADJS_RN_CID)
            .adjsSrcCode(DEFAULT_ADJS_SRC_CODE)
            .adjiId(DEFAULT_ADJI_ID)
            .adjiCi(DEFAULT_ADJI_CI)
            .adjiLac(DEFAULT_ADJI_LAC)
            .adjiRac(DEFAULT_ADJI_RAC)
            .adjiRnCid(DEFAULT_ADJI_RN_CID)
            .adjiSrcCode(DEFAULT_ADJI_SRC_CODE)
            .bscId(DEFAULT_BSC_ID)
            .bcfId(DEFAULT_BCF_ID)
            .btsId(DEFAULT_BTS_ID)
            .adjwCid(DEFAULT_ADJW_CID)
            .adjwLac(DEFAULT_ADJW_LAC)
            .adjwRncId(DEFAULT_ADJW_RNC_ID)
            .scramblingCode(DEFAULT_SCRAMBLING_CODE)
            .goldenParametersAdji(DEFAULT_GOLDEN_PARAMETERS_ADJI)
            .goldenParametersAdjiContentType(DEFAULT_GOLDEN_PARAMETERS_ADJI_CONTENT_TYPE)
            .goldenParametersAdjs(DEFAULT_GOLDEN_PARAMETERS_ADJS)
            .goldenParametersAdjsContentType(DEFAULT_GOLDEN_PARAMETERS_ADJS_CONTENT_TYPE)
            .goldenParametersAdjg(DEFAULT_GOLDEN_PARAMETERS_ADJG)
            .goldenParametersAdjgContentType(DEFAULT_GOLDEN_PARAMETERS_ADJG_CONTENT_TYPE)
            .goldenParametersAdjw(DEFAULT_GOLDEN_PARAMETERS_ADJW)
            .goldenParametersAdjwContentType(DEFAULT_GOLDEN_PARAMETERS_ADJW_CONTENT_TYPE)
            .rfDatabase(DEFAULT_RF_DATABASE)
            .neighborDatabase(DEFAULT_NEIGHBOR_DATABASE)
            .outputWbts(DEFAULT_OUTPUT_WBTS)
            .outputWbtsContentType(DEFAULT_OUTPUT_WBTS_CONTENT_TYPE)
            .outputWcell(DEFAULT_OUTPUT_WCELL)
            .outputWcellContentType(DEFAULT_OUTPUT_WCELL_CONTENT_TYPE)
            .outputWcellAc(DEFAULT_OUTPUT_WCELL_AC)
            .outputWcellAcContentType(DEFAULT_OUTPUT_WCELL_AC_CONTENT_TYPE)
            .outputWcellLc(DEFAULT_OUTPUT_WCELL_LC)
            .outputWcellLcContentType(DEFAULT_OUTPUT_WCELL_LC_CONTENT_TYPE)
            .outputWcellPc(DEFAULT_OUTPUT_WCELL_PC)
            .outputWcellPcContentType(DEFAULT_OUTPUT_WCELL_PC_CONTENT_TYPE)
            .outputWcellHc(DEFAULT_OUTPUT_WCELL_HC)
            .outputWcellHcContentType(DEFAULT_OUTPUT_WCELL_HC_CONTENT_TYPE)
            .outputWcellPS(DEFAULT_OUTPUT_WCELL_PS)
            .outputWcellPSContentType(DEFAULT_OUTPUT_WCELL_PS_CONTENT_TYPE)
            .outputWcellSib(DEFAULT_OUTPUT_WCELL_SIB)
            .outputWcellSibContentType(DEFAULT_OUTPUT_WCELL_SIB_CONTENT_TYPE)
            .outputWcellUraid(DEFAULT_OUTPUT_WCELL_URAID)
            .outputWcellUraidContentType(DEFAULT_OUTPUT_WCELL_URAID_CONTENT_TYPE)
            .outputWlcse(DEFAULT_OUTPUT_WLCSE)
            .outputWlcseContentType(DEFAULT_OUTPUT_WLCSE_CONTENT_TYPE)
            .outputAdji(DEFAULT_OUTPUT_ADJI)
            .outputAdjiContentType(DEFAULT_OUTPUT_ADJI_CONTENT_TYPE)
            .outputAdjs(DEFAULT_OUTPUT_ADJS)
            .outputAdjsContentType(DEFAULT_OUTPUT_ADJS_CONTENT_TYPE)
            .outputAdjg(DEFAULT_OUTPUT_ADJG)
            .outputAdjgContentType(DEFAULT_OUTPUT_ADJG_CONTENT_TYPE)
            .outputAdjw(DEFAULT_OUTPUT_ADJW)
            .outputAdjwContentType(DEFAULT_OUTPUT_ADJW_CONTENT_TYPE);
        return newSiteCreation;
    }

    @Before
    public void initTest() {
        newSiteCreation = createEntity(em);
    }

    @Test
    @Transactional
    public void createNewSiteCreation() throws Exception {
        int databaseSizeBeforeCreate = newSiteCreationRepository.findAll().size();

        // Create the NewSiteCreation
        NewSiteCreationDTO newSiteCreationDTO = newSiteCreationMapper.toDto(newSiteCreation);
        restNewSiteCreationMockMvc.perform(post("/api/new-site-creations")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(newSiteCreationDTO)))
            .andExpect(status().isCreated());

        // Validate the NewSiteCreation in the database
        List<NewSiteCreation> newSiteCreationList = newSiteCreationRepository.findAll();
        assertThat(newSiteCreationList).hasSize(databaseSizeBeforeCreate + 1);
        NewSiteCreation testNewSiteCreation = newSiteCreationList.get(newSiteCreationList.size() - 1);
        assertThat(testNewSiteCreation.getRequestName()).isEqualTo(DEFAULT_REQUEST_NAME);
        assertThat(testNewSiteCreation.getWbtsId()).isEqualTo(DEFAULT_WBTS_ID);
        assertThat(testNewSiteCreation.getRncId()).isEqualTo(DEFAULT_RNC_ID);
        assertThat(testNewSiteCreation.getWbtsName()).isEqualTo(DEFAULT_WBTS_NAME);
        assertThat(testNewSiteCreation.getLcrId()).isEqualTo(DEFAULT_LCR_ID);
        assertThat(testNewSiteCreation.getLac()).isEqualTo(DEFAULT_LAC);
        assertThat(testNewSiteCreation.getRac()).isEqualTo(DEFAULT_RAC);
        assertThat(testNewSiteCreation.getSac()).isEqualTo(DEFAULT_SAC);
        assertThat(testNewSiteCreation.getcId()).isEqualTo(DEFAULT_C_ID);
        assertThat(testNewSiteCreation.getTemplateName()).isEqualTo(DEFAULT_TEMPLATE_NAME);
        assertThat(testNewSiteCreation.getPriSrcCode()).isEqualTo(DEFAULT_PRI_SRC_CODE);
        assertThat(testNewSiteCreation.getWlcseId()).isEqualTo(DEFAULT_WLCSE_ID);
        assertThat(testNewSiteCreation.getAntBearing()).isEqualTo(DEFAULT_ANT_BEARING);
        assertThat(testNewSiteCreation.getWlcseRncId()).isEqualTo(DEFAULT_WLCSE_RNC_ID);
        assertThat(testNewSiteCreation.getAntennaCoordLatitude()).isEqualTo(DEFAULT_ANTENNA_COORD_LATITUDE);
        assertThat(testNewSiteCreation.getAntennaCoordLongitude()).isEqualTo(DEFAULT_ANTENNA_COORD_LONGITUDE);
        assertThat(testNewSiteCreation.getSiteName()).isEqualTo(DEFAULT_SITE_NAME);
        assertThat(testNewSiteCreation.getTechnology()).isEqualTo(DEFAULT_TECHNOLOGY);
        assertThat(testNewSiteCreation.getGoldenParametersWbts()).isEqualTo(DEFAULT_GOLDEN_PARAMETERS_WBTS);
        assertThat(testNewSiteCreation.getGoldenParametersWbtsContentType()).isEqualTo(DEFAULT_GOLDEN_PARAMETERS_WBTS_CONTENT_TYPE);
        assertThat(testNewSiteCreation.getGoldenParametersWcell()).isEqualTo(DEFAULT_GOLDEN_PARAMETERS_WCELL);
        assertThat(testNewSiteCreation.getGoldenParametersWcellContentType()).isEqualTo(DEFAULT_GOLDEN_PARAMETERS_WCELL_CONTENT_TYPE);
        assertThat(testNewSiteCreation.getGoldenParametersWlcse()).isEqualTo(DEFAULT_GOLDEN_PARAMETERS_WLCSE);
        assertThat(testNewSiteCreation.getGoldenParametersWlcseContentType()).isEqualTo(DEFAULT_GOLDEN_PARAMETERS_WLCSE_CONTENT_TYPE);
        assertThat(testNewSiteCreation.getAdjGid()).isEqualTo(DEFAULT_ADJ_GID);
        assertThat(testNewSiteCreation.getAdjgNcc()).isEqualTo(DEFAULT_ADJG_NCC);
        assertThat(testNewSiteCreation.getAdjgBcc()).isEqualTo(DEFAULT_ADJG_BCC);
        assertThat(testNewSiteCreation.getAdjgBcch()).isEqualTo(DEFAULT_ADJG_BCCH);
        assertThat(testNewSiteCreation.getAdjgBandIndicator()).isEqualTo(DEFAULT_ADJG_BAND_INDICATOR);
        assertThat(testNewSiteCreation.getAdjgCi()).isEqualTo(DEFAULT_ADJG_CI);
        assertThat(testNewSiteCreation.getAdjgLac()).isEqualTo(DEFAULT_ADJG_LAC);
        assertThat(testNewSiteCreation.getAdjsId()).isEqualTo(DEFAULT_ADJS_ID);
        assertThat(testNewSiteCreation.getAdjsCi()).isEqualTo(DEFAULT_ADJS_CI);
        assertThat(testNewSiteCreation.getAdjsLac()).isEqualTo(DEFAULT_ADJS_LAC);
        assertThat(testNewSiteCreation.getAdjsRac()).isEqualTo(DEFAULT_ADJS_RAC);
        assertThat(testNewSiteCreation.getAdjsRnCid()).isEqualTo(DEFAULT_ADJS_RN_CID);
        assertThat(testNewSiteCreation.getAdjsSrcCode()).isEqualTo(DEFAULT_ADJS_SRC_CODE);
        assertThat(testNewSiteCreation.getAdjiId()).isEqualTo(DEFAULT_ADJI_ID);
        assertThat(testNewSiteCreation.getAdjiCi()).isEqualTo(DEFAULT_ADJI_CI);
        assertThat(testNewSiteCreation.getAdjiLac()).isEqualTo(DEFAULT_ADJI_LAC);
        assertThat(testNewSiteCreation.getAdjiRac()).isEqualTo(DEFAULT_ADJI_RAC);
        assertThat(testNewSiteCreation.getAdjiRnCid()).isEqualTo(DEFAULT_ADJI_RN_CID);
        assertThat(testNewSiteCreation.getAdjiSrcCode()).isEqualTo(DEFAULT_ADJI_SRC_CODE);
        assertThat(testNewSiteCreation.getBscId()).isEqualTo(DEFAULT_BSC_ID);
        assertThat(testNewSiteCreation.getBcfId()).isEqualTo(DEFAULT_BCF_ID);
        assertThat(testNewSiteCreation.getBtsId()).isEqualTo(DEFAULT_BTS_ID);
        assertThat(testNewSiteCreation.getAdjwCid()).isEqualTo(DEFAULT_ADJW_CID);
        assertThat(testNewSiteCreation.getAdjwLac()).isEqualTo(DEFAULT_ADJW_LAC);
        assertThat(testNewSiteCreation.getAdjwRncId()).isEqualTo(DEFAULT_ADJW_RNC_ID);
        assertThat(testNewSiteCreation.getScramblingCode()).isEqualTo(DEFAULT_SCRAMBLING_CODE);
        assertThat(testNewSiteCreation.getGoldenParametersAdji()).isEqualTo(DEFAULT_GOLDEN_PARAMETERS_ADJI);
        assertThat(testNewSiteCreation.getGoldenParametersAdjiContentType()).isEqualTo(DEFAULT_GOLDEN_PARAMETERS_ADJI_CONTENT_TYPE);
        assertThat(testNewSiteCreation.getGoldenParametersAdjs()).isEqualTo(DEFAULT_GOLDEN_PARAMETERS_ADJS);
        assertThat(testNewSiteCreation.getGoldenParametersAdjsContentType()).isEqualTo(DEFAULT_GOLDEN_PARAMETERS_ADJS_CONTENT_TYPE);
        assertThat(testNewSiteCreation.getGoldenParametersAdjg()).isEqualTo(DEFAULT_GOLDEN_PARAMETERS_ADJG);
        assertThat(testNewSiteCreation.getGoldenParametersAdjgContentType()).isEqualTo(DEFAULT_GOLDEN_PARAMETERS_ADJG_CONTENT_TYPE);
        assertThat(testNewSiteCreation.getGoldenParametersAdjw()).isEqualTo(DEFAULT_GOLDEN_PARAMETERS_ADJW);
        assertThat(testNewSiteCreation.getGoldenParametersAdjwContentType()).isEqualTo(DEFAULT_GOLDEN_PARAMETERS_ADJW_CONTENT_TYPE);
        assertThat(testNewSiteCreation.getRfDatabase()).isEqualTo(DEFAULT_RF_DATABASE);
        assertThat(testNewSiteCreation.getNeighborDatabase()).isEqualTo(DEFAULT_NEIGHBOR_DATABASE);
        assertThat(testNewSiteCreation.getOutputWbts()).isEqualTo(DEFAULT_OUTPUT_WBTS);
        assertThat(testNewSiteCreation.getOutputWbtsContentType()).isEqualTo(DEFAULT_OUTPUT_WBTS_CONTENT_TYPE);
        assertThat(testNewSiteCreation.getOutputWcell()).isEqualTo(DEFAULT_OUTPUT_WCELL);
        assertThat(testNewSiteCreation.getOutputWcellContentType()).isEqualTo(DEFAULT_OUTPUT_WCELL_CONTENT_TYPE);
        assertThat(testNewSiteCreation.getOutputWcellAc()).isEqualTo(DEFAULT_OUTPUT_WCELL_AC);
        assertThat(testNewSiteCreation.getOutputWcellAcContentType()).isEqualTo(DEFAULT_OUTPUT_WCELL_AC_CONTENT_TYPE);
        assertThat(testNewSiteCreation.getOutputWcellLc()).isEqualTo(DEFAULT_OUTPUT_WCELL_LC);
        assertThat(testNewSiteCreation.getOutputWcellLcContentType()).isEqualTo(DEFAULT_OUTPUT_WCELL_LC_CONTENT_TYPE);
        assertThat(testNewSiteCreation.getOutputWcellPc()).isEqualTo(DEFAULT_OUTPUT_WCELL_PC);
        assertThat(testNewSiteCreation.getOutputWcellPcContentType()).isEqualTo(DEFAULT_OUTPUT_WCELL_PC_CONTENT_TYPE);
        assertThat(testNewSiteCreation.getOutputWcellHc()).isEqualTo(DEFAULT_OUTPUT_WCELL_HC);
        assertThat(testNewSiteCreation.getOutputWcellHcContentType()).isEqualTo(DEFAULT_OUTPUT_WCELL_HC_CONTENT_TYPE);
        assertThat(testNewSiteCreation.getOutputWcellPS()).isEqualTo(DEFAULT_OUTPUT_WCELL_PS);
        assertThat(testNewSiteCreation.getOutputWcellPSContentType()).isEqualTo(DEFAULT_OUTPUT_WCELL_PS_CONTENT_TYPE);
        assertThat(testNewSiteCreation.getOutputWcellSib()).isEqualTo(DEFAULT_OUTPUT_WCELL_SIB);
        assertThat(testNewSiteCreation.getOutputWcellSibContentType()).isEqualTo(DEFAULT_OUTPUT_WCELL_SIB_CONTENT_TYPE);
        assertThat(testNewSiteCreation.getOutputWcellUraid()).isEqualTo(DEFAULT_OUTPUT_WCELL_URAID);
        assertThat(testNewSiteCreation.getOutputWcellUraidContentType()).isEqualTo(DEFAULT_OUTPUT_WCELL_URAID_CONTENT_TYPE);
        assertThat(testNewSiteCreation.getOutputWlcse()).isEqualTo(DEFAULT_OUTPUT_WLCSE);
        assertThat(testNewSiteCreation.getOutputWlcseContentType()).isEqualTo(DEFAULT_OUTPUT_WLCSE_CONTENT_TYPE);
        assertThat(testNewSiteCreation.getOutputAdji()).isEqualTo(DEFAULT_OUTPUT_ADJI);
        assertThat(testNewSiteCreation.getOutputAdjiContentType()).isEqualTo(DEFAULT_OUTPUT_ADJI_CONTENT_TYPE);
        assertThat(testNewSiteCreation.getOutputAdjs()).isEqualTo(DEFAULT_OUTPUT_ADJS);
        assertThat(testNewSiteCreation.getOutputAdjsContentType()).isEqualTo(DEFAULT_OUTPUT_ADJS_CONTENT_TYPE);
        assertThat(testNewSiteCreation.getOutputAdjg()).isEqualTo(DEFAULT_OUTPUT_ADJG);
        assertThat(testNewSiteCreation.getOutputAdjgContentType()).isEqualTo(DEFAULT_OUTPUT_ADJG_CONTENT_TYPE);
        assertThat(testNewSiteCreation.getOutputAdjw()).isEqualTo(DEFAULT_OUTPUT_ADJW);
        assertThat(testNewSiteCreation.getOutputAdjwContentType()).isEqualTo(DEFAULT_OUTPUT_ADJW_CONTENT_TYPE);
    }

    @Test
    @Transactional
    public void createNewSiteCreationWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = newSiteCreationRepository.findAll().size();

        // Create the NewSiteCreation with an existing ID
        newSiteCreation.setId(1L);
        NewSiteCreationDTO newSiteCreationDTO = newSiteCreationMapper.toDto(newSiteCreation);

        // An entity with an existing ID cannot be created, so this API call must fail
        restNewSiteCreationMockMvc.perform(post("/api/new-site-creations")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(newSiteCreationDTO)))
            .andExpect(status().isBadRequest());

        // Validate the NewSiteCreation in the database
        List<NewSiteCreation> newSiteCreationList = newSiteCreationRepository.findAll();
        assertThat(newSiteCreationList).hasSize(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    public void checkRequestNameIsRequired() throws Exception {
        int databaseSizeBeforeTest = newSiteCreationRepository.findAll().size();
        // set the field null
        newSiteCreation.setRequestName(null);

        // Create the NewSiteCreation, which fails.
        NewSiteCreationDTO newSiteCreationDTO = newSiteCreationMapper.toDto(newSiteCreation);

        restNewSiteCreationMockMvc.perform(post("/api/new-site-creations")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(newSiteCreationDTO)))
            .andExpect(status().isBadRequest());

        List<NewSiteCreation> newSiteCreationList = newSiteCreationRepository.findAll();
        assertThat(newSiteCreationList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void getAllNewSiteCreations() throws Exception {
        // Initialize the database
        newSiteCreationRepository.saveAndFlush(newSiteCreation);

        // Get all the newSiteCreationList
        restNewSiteCreationMockMvc.perform(get("/api/new-site-creations?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(newSiteCreation.getId().intValue())))
            .andExpect(jsonPath("$.[*].requestName").value(hasItem(DEFAULT_REQUEST_NAME.toString())))
            .andExpect(jsonPath("$.[*].wbtsId").value(hasItem(DEFAULT_WBTS_ID.toString())))
            .andExpect(jsonPath("$.[*].rncId").value(hasItem(DEFAULT_RNC_ID.toString())))
            .andExpect(jsonPath("$.[*].wbtsName").value(hasItem(DEFAULT_WBTS_NAME.toString())))
            .andExpect(jsonPath("$.[*].lcrId").value(hasItem(DEFAULT_LCR_ID.toString())))
            .andExpect(jsonPath("$.[*].lac").value(hasItem(DEFAULT_LAC.toString())))
            .andExpect(jsonPath("$.[*].rac").value(hasItem(DEFAULT_RAC.toString())))
            .andExpect(jsonPath("$.[*].sac").value(hasItem(DEFAULT_SAC.toString())))
            .andExpect(jsonPath("$.[*].cId").value(hasItem(DEFAULT_C_ID.toString())))
            .andExpect(jsonPath("$.[*].templateName").value(hasItem(DEFAULT_TEMPLATE_NAME.toString())))
            .andExpect(jsonPath("$.[*].priSrcCode").value(hasItem(DEFAULT_PRI_SRC_CODE.toString())))
            .andExpect(jsonPath("$.[*].wlcseId").value(hasItem(DEFAULT_WLCSE_ID.toString())))
            .andExpect(jsonPath("$.[*].antBearing").value(hasItem(DEFAULT_ANT_BEARING.toString())))
            .andExpect(jsonPath("$.[*].wlcseRncId").value(hasItem(DEFAULT_WLCSE_RNC_ID.toString())))
            .andExpect(jsonPath("$.[*].antennaCoordLatitude").value(hasItem(DEFAULT_ANTENNA_COORD_LATITUDE.toString())))
            .andExpect(jsonPath("$.[*].antennaCoordLongitude").value(hasItem(DEFAULT_ANTENNA_COORD_LONGITUDE.toString())))
            .andExpect(jsonPath("$.[*].siteName").value(hasItem(DEFAULT_SITE_NAME.toString())))
            .andExpect(jsonPath("$.[*].technology").value(hasItem(DEFAULT_TECHNOLOGY.toString())))
            .andExpect(jsonPath("$.[*].goldenParametersWbtsContentType").value(hasItem(DEFAULT_GOLDEN_PARAMETERS_WBTS_CONTENT_TYPE)))
            .andExpect(jsonPath("$.[*].goldenParametersWbts").value(hasItem(Base64Utils.encodeToString(DEFAULT_GOLDEN_PARAMETERS_WBTS))))
            .andExpect(jsonPath("$.[*].goldenParametersWcellContentType").value(hasItem(DEFAULT_GOLDEN_PARAMETERS_WCELL_CONTENT_TYPE)))
            .andExpect(jsonPath("$.[*].goldenParametersWcell").value(hasItem(Base64Utils.encodeToString(DEFAULT_GOLDEN_PARAMETERS_WCELL))))
            .andExpect(jsonPath("$.[*].goldenParametersWlcseContentType").value(hasItem(DEFAULT_GOLDEN_PARAMETERS_WLCSE_CONTENT_TYPE)))
            .andExpect(jsonPath("$.[*].goldenParametersWlcse").value(hasItem(Base64Utils.encodeToString(DEFAULT_GOLDEN_PARAMETERS_WLCSE))))
            .andExpect(jsonPath("$.[*].adjGid").value(hasItem(DEFAULT_ADJ_GID.toString())))
            .andExpect(jsonPath("$.[*].adjgNcc").value(hasItem(DEFAULT_ADJG_NCC.toString())))
            .andExpect(jsonPath("$.[*].adjgBcc").value(hasItem(DEFAULT_ADJG_BCC.toString())))
            .andExpect(jsonPath("$.[*].adjgBcch").value(hasItem(DEFAULT_ADJG_BCCH.toString())))
            .andExpect(jsonPath("$.[*].adjgBandIndicator").value(hasItem(DEFAULT_ADJG_BAND_INDICATOR.toString())))
            .andExpect(jsonPath("$.[*].adjgCi").value(hasItem(DEFAULT_ADJG_CI.toString())))
            .andExpect(jsonPath("$.[*].adjgLac").value(hasItem(DEFAULT_ADJG_LAC.toString())))
            .andExpect(jsonPath("$.[*].adjsId").value(hasItem(DEFAULT_ADJS_ID.toString())))
            .andExpect(jsonPath("$.[*].adjsCi").value(hasItem(DEFAULT_ADJS_CI.toString())))
            .andExpect(jsonPath("$.[*].adjsLac").value(hasItem(DEFAULT_ADJS_LAC.toString())))
            .andExpect(jsonPath("$.[*].adjsRac").value(hasItem(DEFAULT_ADJS_RAC.toString())))
            .andExpect(jsonPath("$.[*].adjsRnCid").value(hasItem(DEFAULT_ADJS_RN_CID.toString())))
            .andExpect(jsonPath("$.[*].adjsSrcCode").value(hasItem(DEFAULT_ADJS_SRC_CODE.toString())))
            .andExpect(jsonPath("$.[*].adjiId").value(hasItem(DEFAULT_ADJI_ID.toString())))
            .andExpect(jsonPath("$.[*].adjiCi").value(hasItem(DEFAULT_ADJI_CI.toString())))
            .andExpect(jsonPath("$.[*].adjiLac").value(hasItem(DEFAULT_ADJI_LAC.toString())))
            .andExpect(jsonPath("$.[*].adjiRac").value(hasItem(DEFAULT_ADJI_RAC.toString())))
            .andExpect(jsonPath("$.[*].adjiRnCid").value(hasItem(DEFAULT_ADJI_RN_CID.toString())))
            .andExpect(jsonPath("$.[*].adjiSrcCode").value(hasItem(DEFAULT_ADJI_SRC_CODE.toString())))
            .andExpect(jsonPath("$.[*].bscId").value(hasItem(DEFAULT_BSC_ID.toString())))
            .andExpect(jsonPath("$.[*].bcfId").value(hasItem(DEFAULT_BCF_ID.toString())))
            .andExpect(jsonPath("$.[*].btsId").value(hasItem(DEFAULT_BTS_ID.toString())))
            .andExpect(jsonPath("$.[*].adjwCid").value(hasItem(DEFAULT_ADJW_CID.toString())))
            .andExpect(jsonPath("$.[*].adjwLac").value(hasItem(DEFAULT_ADJW_LAC.toString())))
            .andExpect(jsonPath("$.[*].adjwRncId").value(hasItem(DEFAULT_ADJW_RNC_ID.toString())))
            .andExpect(jsonPath("$.[*].scramblingCode").value(hasItem(DEFAULT_SCRAMBLING_CODE.toString())))
            .andExpect(jsonPath("$.[*].goldenParametersAdjiContentType").value(hasItem(DEFAULT_GOLDEN_PARAMETERS_ADJI_CONTENT_TYPE)))
            .andExpect(jsonPath("$.[*].goldenParametersAdji").value(hasItem(Base64Utils.encodeToString(DEFAULT_GOLDEN_PARAMETERS_ADJI))))
            .andExpect(jsonPath("$.[*].goldenParametersAdjsContentType").value(hasItem(DEFAULT_GOLDEN_PARAMETERS_ADJS_CONTENT_TYPE)))
            .andExpect(jsonPath("$.[*].goldenParametersAdjs").value(hasItem(Base64Utils.encodeToString(DEFAULT_GOLDEN_PARAMETERS_ADJS))))
            .andExpect(jsonPath("$.[*].goldenParametersAdjgContentType").value(hasItem(DEFAULT_GOLDEN_PARAMETERS_ADJG_CONTENT_TYPE)))
            .andExpect(jsonPath("$.[*].goldenParametersAdjg").value(hasItem(Base64Utils.encodeToString(DEFAULT_GOLDEN_PARAMETERS_ADJG))))
            .andExpect(jsonPath("$.[*].goldenParametersAdjwContentType").value(hasItem(DEFAULT_GOLDEN_PARAMETERS_ADJW_CONTENT_TYPE)))
            .andExpect(jsonPath("$.[*].goldenParametersAdjw").value(hasItem(Base64Utils.encodeToString(DEFAULT_GOLDEN_PARAMETERS_ADJW))))
            .andExpect(jsonPath("$.[*].rfDatabase").value(hasItem(DEFAULT_RF_DATABASE.toString())))
            .andExpect(jsonPath("$.[*].neighborDatabase").value(hasItem(DEFAULT_NEIGHBOR_DATABASE.toString())))
            .andExpect(jsonPath("$.[*].outputWbtsContentType").value(hasItem(DEFAULT_OUTPUT_WBTS_CONTENT_TYPE)))
            .andExpect(jsonPath("$.[*].outputWbts").value(hasItem(Base64Utils.encodeToString(DEFAULT_OUTPUT_WBTS))))
            .andExpect(jsonPath("$.[*].outputWcellContentType").value(hasItem(DEFAULT_OUTPUT_WCELL_CONTENT_TYPE)))
            .andExpect(jsonPath("$.[*].outputWcell").value(hasItem(Base64Utils.encodeToString(DEFAULT_OUTPUT_WCELL))))
            .andExpect(jsonPath("$.[*].outputWcellAcContentType").value(hasItem(DEFAULT_OUTPUT_WCELL_AC_CONTENT_TYPE)))
            .andExpect(jsonPath("$.[*].outputWcellAc").value(hasItem(Base64Utils.encodeToString(DEFAULT_OUTPUT_WCELL_AC))))
            .andExpect(jsonPath("$.[*].outputWcellLcContentType").value(hasItem(DEFAULT_OUTPUT_WCELL_LC_CONTENT_TYPE)))
            .andExpect(jsonPath("$.[*].outputWcellLc").value(hasItem(Base64Utils.encodeToString(DEFAULT_OUTPUT_WCELL_LC))))
            .andExpect(jsonPath("$.[*].outputWcellPcContentType").value(hasItem(DEFAULT_OUTPUT_WCELL_PC_CONTENT_TYPE)))
            .andExpect(jsonPath("$.[*].outputWcellPc").value(hasItem(Base64Utils.encodeToString(DEFAULT_OUTPUT_WCELL_PC))))
            .andExpect(jsonPath("$.[*].outputWcellHcContentType").value(hasItem(DEFAULT_OUTPUT_WCELL_HC_CONTENT_TYPE)))
            .andExpect(jsonPath("$.[*].outputWcellHc").value(hasItem(Base64Utils.encodeToString(DEFAULT_OUTPUT_WCELL_HC))))
            .andExpect(jsonPath("$.[*].outputWcellPSContentType").value(hasItem(DEFAULT_OUTPUT_WCELL_PS_CONTENT_TYPE)))
            .andExpect(jsonPath("$.[*].outputWcellPS").value(hasItem(Base64Utils.encodeToString(DEFAULT_OUTPUT_WCELL_PS))))
            .andExpect(jsonPath("$.[*].outputWcellSibContentType").value(hasItem(DEFAULT_OUTPUT_WCELL_SIB_CONTENT_TYPE)))
            .andExpect(jsonPath("$.[*].outputWcellSib").value(hasItem(Base64Utils.encodeToString(DEFAULT_OUTPUT_WCELL_SIB))))
            .andExpect(jsonPath("$.[*].outputWcellUraidContentType").value(hasItem(DEFAULT_OUTPUT_WCELL_URAID_CONTENT_TYPE)))
            .andExpect(jsonPath("$.[*].outputWcellUraid").value(hasItem(Base64Utils.encodeToString(DEFAULT_OUTPUT_WCELL_URAID))))
            .andExpect(jsonPath("$.[*].outputWlcseContentType").value(hasItem(DEFAULT_OUTPUT_WLCSE_CONTENT_TYPE)))
            .andExpect(jsonPath("$.[*].outputWlcse").value(hasItem(Base64Utils.encodeToString(DEFAULT_OUTPUT_WLCSE))))
            .andExpect(jsonPath("$.[*].outputAdjiContentType").value(hasItem(DEFAULT_OUTPUT_ADJI_CONTENT_TYPE)))
            .andExpect(jsonPath("$.[*].outputAdji").value(hasItem(Base64Utils.encodeToString(DEFAULT_OUTPUT_ADJI))))
            .andExpect(jsonPath("$.[*].outputAdjsContentType").value(hasItem(DEFAULT_OUTPUT_ADJS_CONTENT_TYPE)))
            .andExpect(jsonPath("$.[*].outputAdjs").value(hasItem(Base64Utils.encodeToString(DEFAULT_OUTPUT_ADJS))))
            .andExpect(jsonPath("$.[*].outputAdjgContentType").value(hasItem(DEFAULT_OUTPUT_ADJG_CONTENT_TYPE)))
            .andExpect(jsonPath("$.[*].outputAdjg").value(hasItem(Base64Utils.encodeToString(DEFAULT_OUTPUT_ADJG))))
            .andExpect(jsonPath("$.[*].outputAdjwContentType").value(hasItem(DEFAULT_OUTPUT_ADJW_CONTENT_TYPE)))
            .andExpect(jsonPath("$.[*].outputAdjw").value(hasItem(Base64Utils.encodeToString(DEFAULT_OUTPUT_ADJW))));
    }
    
    @Test
    @Transactional
    public void getNewSiteCreation() throws Exception {
        // Initialize the database
        newSiteCreationRepository.saveAndFlush(newSiteCreation);

        // Get the newSiteCreation
        restNewSiteCreationMockMvc.perform(get("/api/new-site-creations/{id}", newSiteCreation.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.id").value(newSiteCreation.getId().intValue()))
            .andExpect(jsonPath("$.requestName").value(DEFAULT_REQUEST_NAME.toString()))
            .andExpect(jsonPath("$.wbtsId").value(DEFAULT_WBTS_ID.toString()))
            .andExpect(jsonPath("$.rncId").value(DEFAULT_RNC_ID.toString()))
            .andExpect(jsonPath("$.wbtsName").value(DEFAULT_WBTS_NAME.toString()))
            .andExpect(jsonPath("$.lcrId").value(DEFAULT_LCR_ID.toString()))
            .andExpect(jsonPath("$.lac").value(DEFAULT_LAC.toString()))
            .andExpect(jsonPath("$.rac").value(DEFAULT_RAC.toString()))
            .andExpect(jsonPath("$.sac").value(DEFAULT_SAC.toString()))
            .andExpect(jsonPath("$.cId").value(DEFAULT_C_ID.toString()))
            .andExpect(jsonPath("$.templateName").value(DEFAULT_TEMPLATE_NAME.toString()))
            .andExpect(jsonPath("$.priSrcCode").value(DEFAULT_PRI_SRC_CODE.toString()))
            .andExpect(jsonPath("$.wlcseId").value(DEFAULT_WLCSE_ID.toString()))
            .andExpect(jsonPath("$.antBearing").value(DEFAULT_ANT_BEARING.toString()))
            .andExpect(jsonPath("$.wlcseRncId").value(DEFAULT_WLCSE_RNC_ID.toString()))
            .andExpect(jsonPath("$.antennaCoordLatitude").value(DEFAULT_ANTENNA_COORD_LATITUDE.toString()))
            .andExpect(jsonPath("$.antennaCoordLongitude").value(DEFAULT_ANTENNA_COORD_LONGITUDE.toString()))
            .andExpect(jsonPath("$.siteName").value(DEFAULT_SITE_NAME.toString()))
            .andExpect(jsonPath("$.technology").value(DEFAULT_TECHNOLOGY.toString()))
            .andExpect(jsonPath("$.goldenParametersWbtsContentType").value(DEFAULT_GOLDEN_PARAMETERS_WBTS_CONTENT_TYPE))
            .andExpect(jsonPath("$.goldenParametersWbts").value(Base64Utils.encodeToString(DEFAULT_GOLDEN_PARAMETERS_WBTS)))
            .andExpect(jsonPath("$.goldenParametersWcellContentType").value(DEFAULT_GOLDEN_PARAMETERS_WCELL_CONTENT_TYPE))
            .andExpect(jsonPath("$.goldenParametersWcell").value(Base64Utils.encodeToString(DEFAULT_GOLDEN_PARAMETERS_WCELL)))
            .andExpect(jsonPath("$.goldenParametersWlcseContentType").value(DEFAULT_GOLDEN_PARAMETERS_WLCSE_CONTENT_TYPE))
            .andExpect(jsonPath("$.goldenParametersWlcse").value(Base64Utils.encodeToString(DEFAULT_GOLDEN_PARAMETERS_WLCSE)))
            .andExpect(jsonPath("$.adjGid").value(DEFAULT_ADJ_GID.toString()))
            .andExpect(jsonPath("$.adjgNcc").value(DEFAULT_ADJG_NCC.toString()))
            .andExpect(jsonPath("$.adjgBcc").value(DEFAULT_ADJG_BCC.toString()))
            .andExpect(jsonPath("$.adjgBcch").value(DEFAULT_ADJG_BCCH.toString()))
            .andExpect(jsonPath("$.adjgBandIndicator").value(DEFAULT_ADJG_BAND_INDICATOR.toString()))
            .andExpect(jsonPath("$.adjgCi").value(DEFAULT_ADJG_CI.toString()))
            .andExpect(jsonPath("$.adjgLac").value(DEFAULT_ADJG_LAC.toString()))
            .andExpect(jsonPath("$.adjsId").value(DEFAULT_ADJS_ID.toString()))
            .andExpect(jsonPath("$.adjsCi").value(DEFAULT_ADJS_CI.toString()))
            .andExpect(jsonPath("$.adjsLac").value(DEFAULT_ADJS_LAC.toString()))
            .andExpect(jsonPath("$.adjsRac").value(DEFAULT_ADJS_RAC.toString()))
            .andExpect(jsonPath("$.adjsRnCid").value(DEFAULT_ADJS_RN_CID.toString()))
            .andExpect(jsonPath("$.adjsSrcCode").value(DEFAULT_ADJS_SRC_CODE.toString()))
            .andExpect(jsonPath("$.adjiId").value(DEFAULT_ADJI_ID.toString()))
            .andExpect(jsonPath("$.adjiCi").value(DEFAULT_ADJI_CI.toString()))
            .andExpect(jsonPath("$.adjiLac").value(DEFAULT_ADJI_LAC.toString()))
            .andExpect(jsonPath("$.adjiRac").value(DEFAULT_ADJI_RAC.toString()))
            .andExpect(jsonPath("$.adjiRnCid").value(DEFAULT_ADJI_RN_CID.toString()))
            .andExpect(jsonPath("$.adjiSrcCode").value(DEFAULT_ADJI_SRC_CODE.toString()))
            .andExpect(jsonPath("$.bscId").value(DEFAULT_BSC_ID.toString()))
            .andExpect(jsonPath("$.bcfId").value(DEFAULT_BCF_ID.toString()))
            .andExpect(jsonPath("$.btsId").value(DEFAULT_BTS_ID.toString()))
            .andExpect(jsonPath("$.adjwCid").value(DEFAULT_ADJW_CID.toString()))
            .andExpect(jsonPath("$.adjwLac").value(DEFAULT_ADJW_LAC.toString()))
            .andExpect(jsonPath("$.adjwRncId").value(DEFAULT_ADJW_RNC_ID.toString()))
            .andExpect(jsonPath("$.scramblingCode").value(DEFAULT_SCRAMBLING_CODE.toString()))
            .andExpect(jsonPath("$.goldenParametersAdjiContentType").value(DEFAULT_GOLDEN_PARAMETERS_ADJI_CONTENT_TYPE))
            .andExpect(jsonPath("$.goldenParametersAdji").value(Base64Utils.encodeToString(DEFAULT_GOLDEN_PARAMETERS_ADJI)))
            .andExpect(jsonPath("$.goldenParametersAdjsContentType").value(DEFAULT_GOLDEN_PARAMETERS_ADJS_CONTENT_TYPE))
            .andExpect(jsonPath("$.goldenParametersAdjs").value(Base64Utils.encodeToString(DEFAULT_GOLDEN_PARAMETERS_ADJS)))
            .andExpect(jsonPath("$.goldenParametersAdjgContentType").value(DEFAULT_GOLDEN_PARAMETERS_ADJG_CONTENT_TYPE))
            .andExpect(jsonPath("$.goldenParametersAdjg").value(Base64Utils.encodeToString(DEFAULT_GOLDEN_PARAMETERS_ADJG)))
            .andExpect(jsonPath("$.goldenParametersAdjwContentType").value(DEFAULT_GOLDEN_PARAMETERS_ADJW_CONTENT_TYPE))
            .andExpect(jsonPath("$.goldenParametersAdjw").value(Base64Utils.encodeToString(DEFAULT_GOLDEN_PARAMETERS_ADJW)))
            .andExpect(jsonPath("$.rfDatabase").value(DEFAULT_RF_DATABASE.toString()))
            .andExpect(jsonPath("$.neighborDatabase").value(DEFAULT_NEIGHBOR_DATABASE.toString()))
            .andExpect(jsonPath("$.outputWbtsContentType").value(DEFAULT_OUTPUT_WBTS_CONTENT_TYPE))
            .andExpect(jsonPath("$.outputWbts").value(Base64Utils.encodeToString(DEFAULT_OUTPUT_WBTS)))
            .andExpect(jsonPath("$.outputWcellContentType").value(DEFAULT_OUTPUT_WCELL_CONTENT_TYPE))
            .andExpect(jsonPath("$.outputWcell").value(Base64Utils.encodeToString(DEFAULT_OUTPUT_WCELL)))
            .andExpect(jsonPath("$.outputWcellAcContentType").value(DEFAULT_OUTPUT_WCELL_AC_CONTENT_TYPE))
            .andExpect(jsonPath("$.outputWcellAc").value(Base64Utils.encodeToString(DEFAULT_OUTPUT_WCELL_AC)))
            .andExpect(jsonPath("$.outputWcellLcContentType").value(DEFAULT_OUTPUT_WCELL_LC_CONTENT_TYPE))
            .andExpect(jsonPath("$.outputWcellLc").value(Base64Utils.encodeToString(DEFAULT_OUTPUT_WCELL_LC)))
            .andExpect(jsonPath("$.outputWcellPcContentType").value(DEFAULT_OUTPUT_WCELL_PC_CONTENT_TYPE))
            .andExpect(jsonPath("$.outputWcellPc").value(Base64Utils.encodeToString(DEFAULT_OUTPUT_WCELL_PC)))
            .andExpect(jsonPath("$.outputWcellHcContentType").value(DEFAULT_OUTPUT_WCELL_HC_CONTENT_TYPE))
            .andExpect(jsonPath("$.outputWcellHc").value(Base64Utils.encodeToString(DEFAULT_OUTPUT_WCELL_HC)))
            .andExpect(jsonPath("$.outputWcellPSContentType").value(DEFAULT_OUTPUT_WCELL_PS_CONTENT_TYPE))
            .andExpect(jsonPath("$.outputWcellPS").value(Base64Utils.encodeToString(DEFAULT_OUTPUT_WCELL_PS)))
            .andExpect(jsonPath("$.outputWcellSibContentType").value(DEFAULT_OUTPUT_WCELL_SIB_CONTENT_TYPE))
            .andExpect(jsonPath("$.outputWcellSib").value(Base64Utils.encodeToString(DEFAULT_OUTPUT_WCELL_SIB)))
            .andExpect(jsonPath("$.outputWcellUraidContentType").value(DEFAULT_OUTPUT_WCELL_URAID_CONTENT_TYPE))
            .andExpect(jsonPath("$.outputWcellUraid").value(Base64Utils.encodeToString(DEFAULT_OUTPUT_WCELL_URAID)))
            .andExpect(jsonPath("$.outputWlcseContentType").value(DEFAULT_OUTPUT_WLCSE_CONTENT_TYPE))
            .andExpect(jsonPath("$.outputWlcse").value(Base64Utils.encodeToString(DEFAULT_OUTPUT_WLCSE)))
            .andExpect(jsonPath("$.outputAdjiContentType").value(DEFAULT_OUTPUT_ADJI_CONTENT_TYPE))
            .andExpect(jsonPath("$.outputAdji").value(Base64Utils.encodeToString(DEFAULT_OUTPUT_ADJI)))
            .andExpect(jsonPath("$.outputAdjsContentType").value(DEFAULT_OUTPUT_ADJS_CONTENT_TYPE))
            .andExpect(jsonPath("$.outputAdjs").value(Base64Utils.encodeToString(DEFAULT_OUTPUT_ADJS)))
            .andExpect(jsonPath("$.outputAdjgContentType").value(DEFAULT_OUTPUT_ADJG_CONTENT_TYPE))
            .andExpect(jsonPath("$.outputAdjg").value(Base64Utils.encodeToString(DEFAULT_OUTPUT_ADJG)))
            .andExpect(jsonPath("$.outputAdjwContentType").value(DEFAULT_OUTPUT_ADJW_CONTENT_TYPE))
            .andExpect(jsonPath("$.outputAdjw").value(Base64Utils.encodeToString(DEFAULT_OUTPUT_ADJW)));
    }

    @Test
    @Transactional
    public void getNonExistingNewSiteCreation() throws Exception {
        // Get the newSiteCreation
        restNewSiteCreationMockMvc.perform(get("/api/new-site-creations/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateNewSiteCreation() throws Exception {
        // Initialize the database
        newSiteCreationRepository.saveAndFlush(newSiteCreation);

        int databaseSizeBeforeUpdate = newSiteCreationRepository.findAll().size();

        // Update the newSiteCreation
        NewSiteCreation updatedNewSiteCreation = newSiteCreationRepository.findById(newSiteCreation.getId()).get();
        // Disconnect from session so that the updates on updatedNewSiteCreation are not directly saved in db
        em.detach(updatedNewSiteCreation);
        updatedNewSiteCreation
            .requestName(UPDATED_REQUEST_NAME)
            .wbtsId(UPDATED_WBTS_ID)
            .rncId(UPDATED_RNC_ID)
            .wbtsName(UPDATED_WBTS_NAME)
            .lcrId(UPDATED_LCR_ID)
            .lac(UPDATED_LAC)
            .rac(UPDATED_RAC)
            .sac(UPDATED_SAC)
            .cId(UPDATED_C_ID)
            .templateName(UPDATED_TEMPLATE_NAME)
            .priSrcCode(UPDATED_PRI_SRC_CODE)
            .wlcseId(UPDATED_WLCSE_ID)
            .antBearing(UPDATED_ANT_BEARING)
            .wlcseRncId(UPDATED_WLCSE_RNC_ID)
            .antennaCoordLatitude(UPDATED_ANTENNA_COORD_LATITUDE)
            .antennaCoordLongitude(UPDATED_ANTENNA_COORD_LONGITUDE)
            .siteName(UPDATED_SITE_NAME)
            .technology(UPDATED_TECHNOLOGY)
            .goldenParametersWbts(UPDATED_GOLDEN_PARAMETERS_WBTS)
            .goldenParametersWbtsContentType(UPDATED_GOLDEN_PARAMETERS_WBTS_CONTENT_TYPE)
            .goldenParametersWcell(UPDATED_GOLDEN_PARAMETERS_WCELL)
            .goldenParametersWcellContentType(UPDATED_GOLDEN_PARAMETERS_WCELL_CONTENT_TYPE)
            .goldenParametersWlcse(UPDATED_GOLDEN_PARAMETERS_WLCSE)
            .goldenParametersWlcseContentType(UPDATED_GOLDEN_PARAMETERS_WLCSE_CONTENT_TYPE)
            .adjGid(UPDATED_ADJ_GID)
            .adjgNcc(UPDATED_ADJG_NCC)
            .adjgBcc(UPDATED_ADJG_BCC)
            .adjgBcch(UPDATED_ADJG_BCCH)
            .adjgBandIndicator(UPDATED_ADJG_BAND_INDICATOR)
            .adjgCi(UPDATED_ADJG_CI)
            .adjgLac(UPDATED_ADJG_LAC)
            .adjsId(UPDATED_ADJS_ID)
            .adjsCi(UPDATED_ADJS_CI)
            .adjsLac(UPDATED_ADJS_LAC)
            .adjsRac(UPDATED_ADJS_RAC)
            .adjsRnCid(UPDATED_ADJS_RN_CID)
            .adjsSrcCode(UPDATED_ADJS_SRC_CODE)
            .adjiId(UPDATED_ADJI_ID)
            .adjiCi(UPDATED_ADJI_CI)
            .adjiLac(UPDATED_ADJI_LAC)
            .adjiRac(UPDATED_ADJI_RAC)
            .adjiRnCid(UPDATED_ADJI_RN_CID)
            .adjiSrcCode(UPDATED_ADJI_SRC_CODE)
            .bscId(UPDATED_BSC_ID)
            .bcfId(UPDATED_BCF_ID)
            .btsId(UPDATED_BTS_ID)
            .adjwCid(UPDATED_ADJW_CID)
            .adjwLac(UPDATED_ADJW_LAC)
            .adjwRncId(UPDATED_ADJW_RNC_ID)
            .scramblingCode(UPDATED_SCRAMBLING_CODE)
            .goldenParametersAdji(UPDATED_GOLDEN_PARAMETERS_ADJI)
            .goldenParametersAdjiContentType(UPDATED_GOLDEN_PARAMETERS_ADJI_CONTENT_TYPE)
            .goldenParametersAdjs(UPDATED_GOLDEN_PARAMETERS_ADJS)
            .goldenParametersAdjsContentType(UPDATED_GOLDEN_PARAMETERS_ADJS_CONTENT_TYPE)
            .goldenParametersAdjg(UPDATED_GOLDEN_PARAMETERS_ADJG)
            .goldenParametersAdjgContentType(UPDATED_GOLDEN_PARAMETERS_ADJG_CONTENT_TYPE)
            .goldenParametersAdjw(UPDATED_GOLDEN_PARAMETERS_ADJW)
            .goldenParametersAdjwContentType(UPDATED_GOLDEN_PARAMETERS_ADJW_CONTENT_TYPE)
            .rfDatabase(UPDATED_RF_DATABASE)
            .neighborDatabase(UPDATED_NEIGHBOR_DATABASE)
            .outputWbts(UPDATED_OUTPUT_WBTS)
            .outputWbtsContentType(UPDATED_OUTPUT_WBTS_CONTENT_TYPE)
            .outputWcell(UPDATED_OUTPUT_WCELL)
            .outputWcellContentType(UPDATED_OUTPUT_WCELL_CONTENT_TYPE)
            .outputWcellAc(UPDATED_OUTPUT_WCELL_AC)
            .outputWcellAcContentType(UPDATED_OUTPUT_WCELL_AC_CONTENT_TYPE)
            .outputWcellLc(UPDATED_OUTPUT_WCELL_LC)
            .outputWcellLcContentType(UPDATED_OUTPUT_WCELL_LC_CONTENT_TYPE)
            .outputWcellPc(UPDATED_OUTPUT_WCELL_PC)
            .outputWcellPcContentType(UPDATED_OUTPUT_WCELL_PC_CONTENT_TYPE)
            .outputWcellHc(UPDATED_OUTPUT_WCELL_HC)
            .outputWcellHcContentType(UPDATED_OUTPUT_WCELL_HC_CONTENT_TYPE)
            .outputWcellPS(UPDATED_OUTPUT_WCELL_PS)
            .outputWcellPSContentType(UPDATED_OUTPUT_WCELL_PS_CONTENT_TYPE)
            .outputWcellSib(UPDATED_OUTPUT_WCELL_SIB)
            .outputWcellSibContentType(UPDATED_OUTPUT_WCELL_SIB_CONTENT_TYPE)
            .outputWcellUraid(UPDATED_OUTPUT_WCELL_URAID)
            .outputWcellUraidContentType(UPDATED_OUTPUT_WCELL_URAID_CONTENT_TYPE)
            .outputWlcse(UPDATED_OUTPUT_WLCSE)
            .outputWlcseContentType(UPDATED_OUTPUT_WLCSE_CONTENT_TYPE)
            .outputAdji(UPDATED_OUTPUT_ADJI)
            .outputAdjiContentType(UPDATED_OUTPUT_ADJI_CONTENT_TYPE)
            .outputAdjs(UPDATED_OUTPUT_ADJS)
            .outputAdjsContentType(UPDATED_OUTPUT_ADJS_CONTENT_TYPE)
            .outputAdjg(UPDATED_OUTPUT_ADJG)
            .outputAdjgContentType(UPDATED_OUTPUT_ADJG_CONTENT_TYPE)
            .outputAdjw(UPDATED_OUTPUT_ADJW)
            .outputAdjwContentType(UPDATED_OUTPUT_ADJW_CONTENT_TYPE);
        NewSiteCreationDTO newSiteCreationDTO = newSiteCreationMapper.toDto(updatedNewSiteCreation);

        restNewSiteCreationMockMvc.perform(put("/api/new-site-creations")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(newSiteCreationDTO)))
            .andExpect(status().isOk());

        // Validate the NewSiteCreation in the database
        List<NewSiteCreation> newSiteCreationList = newSiteCreationRepository.findAll();
        assertThat(newSiteCreationList).hasSize(databaseSizeBeforeUpdate);
        NewSiteCreation testNewSiteCreation = newSiteCreationList.get(newSiteCreationList.size() - 1);
        assertThat(testNewSiteCreation.getRequestName()).isEqualTo(UPDATED_REQUEST_NAME);
        assertThat(testNewSiteCreation.getWbtsId()).isEqualTo(UPDATED_WBTS_ID);
        assertThat(testNewSiteCreation.getRncId()).isEqualTo(UPDATED_RNC_ID);
        assertThat(testNewSiteCreation.getWbtsName()).isEqualTo(UPDATED_WBTS_NAME);
        assertThat(testNewSiteCreation.getLcrId()).isEqualTo(UPDATED_LCR_ID);
        assertThat(testNewSiteCreation.getLac()).isEqualTo(UPDATED_LAC);
        assertThat(testNewSiteCreation.getRac()).isEqualTo(UPDATED_RAC);
        assertThat(testNewSiteCreation.getSac()).isEqualTo(UPDATED_SAC);
        assertThat(testNewSiteCreation.getcId()).isEqualTo(UPDATED_C_ID);
        assertThat(testNewSiteCreation.getTemplateName()).isEqualTo(UPDATED_TEMPLATE_NAME);
        assertThat(testNewSiteCreation.getPriSrcCode()).isEqualTo(UPDATED_PRI_SRC_CODE);
        assertThat(testNewSiteCreation.getWlcseId()).isEqualTo(UPDATED_WLCSE_ID);
        assertThat(testNewSiteCreation.getAntBearing()).isEqualTo(UPDATED_ANT_BEARING);
        assertThat(testNewSiteCreation.getWlcseRncId()).isEqualTo(UPDATED_WLCSE_RNC_ID);
        assertThat(testNewSiteCreation.getAntennaCoordLatitude()).isEqualTo(UPDATED_ANTENNA_COORD_LATITUDE);
        assertThat(testNewSiteCreation.getAntennaCoordLongitude()).isEqualTo(UPDATED_ANTENNA_COORD_LONGITUDE);
        assertThat(testNewSiteCreation.getSiteName()).isEqualTo(UPDATED_SITE_NAME);
        assertThat(testNewSiteCreation.getTechnology()).isEqualTo(UPDATED_TECHNOLOGY);
        assertThat(testNewSiteCreation.getGoldenParametersWbts()).isEqualTo(UPDATED_GOLDEN_PARAMETERS_WBTS);
        assertThat(testNewSiteCreation.getGoldenParametersWbtsContentType()).isEqualTo(UPDATED_GOLDEN_PARAMETERS_WBTS_CONTENT_TYPE);
        assertThat(testNewSiteCreation.getGoldenParametersWcell()).isEqualTo(UPDATED_GOLDEN_PARAMETERS_WCELL);
        assertThat(testNewSiteCreation.getGoldenParametersWcellContentType()).isEqualTo(UPDATED_GOLDEN_PARAMETERS_WCELL_CONTENT_TYPE);
        assertThat(testNewSiteCreation.getGoldenParametersWlcse()).isEqualTo(UPDATED_GOLDEN_PARAMETERS_WLCSE);
        assertThat(testNewSiteCreation.getGoldenParametersWlcseContentType()).isEqualTo(UPDATED_GOLDEN_PARAMETERS_WLCSE_CONTENT_TYPE);
        assertThat(testNewSiteCreation.getAdjGid()).isEqualTo(UPDATED_ADJ_GID);
        assertThat(testNewSiteCreation.getAdjgNcc()).isEqualTo(UPDATED_ADJG_NCC);
        assertThat(testNewSiteCreation.getAdjgBcc()).isEqualTo(UPDATED_ADJG_BCC);
        assertThat(testNewSiteCreation.getAdjgBcch()).isEqualTo(UPDATED_ADJG_BCCH);
        assertThat(testNewSiteCreation.getAdjgBandIndicator()).isEqualTo(UPDATED_ADJG_BAND_INDICATOR);
        assertThat(testNewSiteCreation.getAdjgCi()).isEqualTo(UPDATED_ADJG_CI);
        assertThat(testNewSiteCreation.getAdjgLac()).isEqualTo(UPDATED_ADJG_LAC);
        assertThat(testNewSiteCreation.getAdjsId()).isEqualTo(UPDATED_ADJS_ID);
        assertThat(testNewSiteCreation.getAdjsCi()).isEqualTo(UPDATED_ADJS_CI);
        assertThat(testNewSiteCreation.getAdjsLac()).isEqualTo(UPDATED_ADJS_LAC);
        assertThat(testNewSiteCreation.getAdjsRac()).isEqualTo(UPDATED_ADJS_RAC);
        assertThat(testNewSiteCreation.getAdjsRnCid()).isEqualTo(UPDATED_ADJS_RN_CID);
        assertThat(testNewSiteCreation.getAdjsSrcCode()).isEqualTo(UPDATED_ADJS_SRC_CODE);
        assertThat(testNewSiteCreation.getAdjiId()).isEqualTo(UPDATED_ADJI_ID);
        assertThat(testNewSiteCreation.getAdjiCi()).isEqualTo(UPDATED_ADJI_CI);
        assertThat(testNewSiteCreation.getAdjiLac()).isEqualTo(UPDATED_ADJI_LAC);
        assertThat(testNewSiteCreation.getAdjiRac()).isEqualTo(UPDATED_ADJI_RAC);
        assertThat(testNewSiteCreation.getAdjiRnCid()).isEqualTo(UPDATED_ADJI_RN_CID);
        assertThat(testNewSiteCreation.getAdjiSrcCode()).isEqualTo(UPDATED_ADJI_SRC_CODE);
        assertThat(testNewSiteCreation.getBscId()).isEqualTo(UPDATED_BSC_ID);
        assertThat(testNewSiteCreation.getBcfId()).isEqualTo(UPDATED_BCF_ID);
        assertThat(testNewSiteCreation.getBtsId()).isEqualTo(UPDATED_BTS_ID);
        assertThat(testNewSiteCreation.getAdjwCid()).isEqualTo(UPDATED_ADJW_CID);
        assertThat(testNewSiteCreation.getAdjwLac()).isEqualTo(UPDATED_ADJW_LAC);
        assertThat(testNewSiteCreation.getAdjwRncId()).isEqualTo(UPDATED_ADJW_RNC_ID);
        assertThat(testNewSiteCreation.getScramblingCode()).isEqualTo(UPDATED_SCRAMBLING_CODE);
        assertThat(testNewSiteCreation.getGoldenParametersAdji()).isEqualTo(UPDATED_GOLDEN_PARAMETERS_ADJI);
        assertThat(testNewSiteCreation.getGoldenParametersAdjiContentType()).isEqualTo(UPDATED_GOLDEN_PARAMETERS_ADJI_CONTENT_TYPE);
        assertThat(testNewSiteCreation.getGoldenParametersAdjs()).isEqualTo(UPDATED_GOLDEN_PARAMETERS_ADJS);
        assertThat(testNewSiteCreation.getGoldenParametersAdjsContentType()).isEqualTo(UPDATED_GOLDEN_PARAMETERS_ADJS_CONTENT_TYPE);
        assertThat(testNewSiteCreation.getGoldenParametersAdjg()).isEqualTo(UPDATED_GOLDEN_PARAMETERS_ADJG);
        assertThat(testNewSiteCreation.getGoldenParametersAdjgContentType()).isEqualTo(UPDATED_GOLDEN_PARAMETERS_ADJG_CONTENT_TYPE);
        assertThat(testNewSiteCreation.getGoldenParametersAdjw()).isEqualTo(UPDATED_GOLDEN_PARAMETERS_ADJW);
        assertThat(testNewSiteCreation.getGoldenParametersAdjwContentType()).isEqualTo(UPDATED_GOLDEN_PARAMETERS_ADJW_CONTENT_TYPE);
        assertThat(testNewSiteCreation.getRfDatabase()).isEqualTo(UPDATED_RF_DATABASE);
        assertThat(testNewSiteCreation.getNeighborDatabase()).isEqualTo(UPDATED_NEIGHBOR_DATABASE);
        assertThat(testNewSiteCreation.getOutputWbts()).isEqualTo(UPDATED_OUTPUT_WBTS);
        assertThat(testNewSiteCreation.getOutputWbtsContentType()).isEqualTo(UPDATED_OUTPUT_WBTS_CONTENT_TYPE);
        assertThat(testNewSiteCreation.getOutputWcell()).isEqualTo(UPDATED_OUTPUT_WCELL);
        assertThat(testNewSiteCreation.getOutputWcellContentType()).isEqualTo(UPDATED_OUTPUT_WCELL_CONTENT_TYPE);
        assertThat(testNewSiteCreation.getOutputWcellAc()).isEqualTo(UPDATED_OUTPUT_WCELL_AC);
        assertThat(testNewSiteCreation.getOutputWcellAcContentType()).isEqualTo(UPDATED_OUTPUT_WCELL_AC_CONTENT_TYPE);
        assertThat(testNewSiteCreation.getOutputWcellLc()).isEqualTo(UPDATED_OUTPUT_WCELL_LC);
        assertThat(testNewSiteCreation.getOutputWcellLcContentType()).isEqualTo(UPDATED_OUTPUT_WCELL_LC_CONTENT_TYPE);
        assertThat(testNewSiteCreation.getOutputWcellPc()).isEqualTo(UPDATED_OUTPUT_WCELL_PC);
        assertThat(testNewSiteCreation.getOutputWcellPcContentType()).isEqualTo(UPDATED_OUTPUT_WCELL_PC_CONTENT_TYPE);
        assertThat(testNewSiteCreation.getOutputWcellHc()).isEqualTo(UPDATED_OUTPUT_WCELL_HC);
        assertThat(testNewSiteCreation.getOutputWcellHcContentType()).isEqualTo(UPDATED_OUTPUT_WCELL_HC_CONTENT_TYPE);
        assertThat(testNewSiteCreation.getOutputWcellPS()).isEqualTo(UPDATED_OUTPUT_WCELL_PS);
        assertThat(testNewSiteCreation.getOutputWcellPSContentType()).isEqualTo(UPDATED_OUTPUT_WCELL_PS_CONTENT_TYPE);
        assertThat(testNewSiteCreation.getOutputWcellSib()).isEqualTo(UPDATED_OUTPUT_WCELL_SIB);
        assertThat(testNewSiteCreation.getOutputWcellSibContentType()).isEqualTo(UPDATED_OUTPUT_WCELL_SIB_CONTENT_TYPE);
        assertThat(testNewSiteCreation.getOutputWcellUraid()).isEqualTo(UPDATED_OUTPUT_WCELL_URAID);
        assertThat(testNewSiteCreation.getOutputWcellUraidContentType()).isEqualTo(UPDATED_OUTPUT_WCELL_URAID_CONTENT_TYPE);
        assertThat(testNewSiteCreation.getOutputWlcse()).isEqualTo(UPDATED_OUTPUT_WLCSE);
        assertThat(testNewSiteCreation.getOutputWlcseContentType()).isEqualTo(UPDATED_OUTPUT_WLCSE_CONTENT_TYPE);
        assertThat(testNewSiteCreation.getOutputAdji()).isEqualTo(UPDATED_OUTPUT_ADJI);
        assertThat(testNewSiteCreation.getOutputAdjiContentType()).isEqualTo(UPDATED_OUTPUT_ADJI_CONTENT_TYPE);
        assertThat(testNewSiteCreation.getOutputAdjs()).isEqualTo(UPDATED_OUTPUT_ADJS);
        assertThat(testNewSiteCreation.getOutputAdjsContentType()).isEqualTo(UPDATED_OUTPUT_ADJS_CONTENT_TYPE);
        assertThat(testNewSiteCreation.getOutputAdjg()).isEqualTo(UPDATED_OUTPUT_ADJG);
        assertThat(testNewSiteCreation.getOutputAdjgContentType()).isEqualTo(UPDATED_OUTPUT_ADJG_CONTENT_TYPE);
        assertThat(testNewSiteCreation.getOutputAdjw()).isEqualTo(UPDATED_OUTPUT_ADJW);
        assertThat(testNewSiteCreation.getOutputAdjwContentType()).isEqualTo(UPDATED_OUTPUT_ADJW_CONTENT_TYPE);
    }

    @Test
    @Transactional
    public void updateNonExistingNewSiteCreation() throws Exception {
        int databaseSizeBeforeUpdate = newSiteCreationRepository.findAll().size();

        // Create the NewSiteCreation
        NewSiteCreationDTO newSiteCreationDTO = newSiteCreationMapper.toDto(newSiteCreation);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restNewSiteCreationMockMvc.perform(put("/api/new-site-creations")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(newSiteCreationDTO)))
            .andExpect(status().isBadRequest());

        // Validate the NewSiteCreation in the database
        List<NewSiteCreation> newSiteCreationList = newSiteCreationRepository.findAll();
        assertThat(newSiteCreationList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteNewSiteCreation() throws Exception {
        // Initialize the database
        newSiteCreationRepository.saveAndFlush(newSiteCreation);

        int databaseSizeBeforeDelete = newSiteCreationRepository.findAll().size();

        // Get the newSiteCreation
        restNewSiteCreationMockMvc.perform(delete("/api/new-site-creations/{id}", newSiteCreation.getId())
            .accept(TestUtil.APPLICATION_JSON_UTF8))
            .andExpect(status().isOk());

        // Validate the database is empty
        List<NewSiteCreation> newSiteCreationList = newSiteCreationRepository.findAll();
        assertThat(newSiteCreationList).hasSize(databaseSizeBeforeDelete - 1);
    }

    @Test
    @Transactional
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(NewSiteCreation.class);
        NewSiteCreation newSiteCreation1 = new NewSiteCreation();
        newSiteCreation1.setId(1L);
        NewSiteCreation newSiteCreation2 = new NewSiteCreation();
        newSiteCreation2.setId(newSiteCreation1.getId());
        assertThat(newSiteCreation1).isEqualTo(newSiteCreation2);
        newSiteCreation2.setId(2L);
        assertThat(newSiteCreation1).isNotEqualTo(newSiteCreation2);
        newSiteCreation1.setId(null);
        assertThat(newSiteCreation1).isNotEqualTo(newSiteCreation2);
    }

    @Test
    @Transactional
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(NewSiteCreationDTO.class);
        NewSiteCreationDTO newSiteCreationDTO1 = new NewSiteCreationDTO();
        newSiteCreationDTO1.setId(1L);
        NewSiteCreationDTO newSiteCreationDTO2 = new NewSiteCreationDTO();
        assertThat(newSiteCreationDTO1).isNotEqualTo(newSiteCreationDTO2);
        newSiteCreationDTO2.setId(newSiteCreationDTO1.getId());
        assertThat(newSiteCreationDTO1).isEqualTo(newSiteCreationDTO2);
        newSiteCreationDTO2.setId(2L);
        assertThat(newSiteCreationDTO1).isNotEqualTo(newSiteCreationDTO2);
        newSiteCreationDTO1.setId(null);
        assertThat(newSiteCreationDTO1).isNotEqualTo(newSiteCreationDTO2);
    }

    @Test
    @Transactional
    public void testEntityFromId() {
        assertThat(newSiteCreationMapper.fromId(42L).getId()).isEqualTo(42);
        assertThat(newSiteCreationMapper.fromId(null)).isNull();
    }
}
