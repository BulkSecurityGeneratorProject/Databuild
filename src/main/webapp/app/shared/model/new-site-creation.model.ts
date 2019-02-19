export interface INewSiteCreation {
    id?: number;
    requestName?: string;
    wbtsId?: string;
    rncId?: string;
    wbtsName?: string;
    lcrId?: string;
    lac?: string;
    rac?: string;
    sac?: string;
    cId?: string;
    templateName?: string;
    priSrcCode?: string;
    wlcseId?: string;
    antBearing?: string;
    wlcseRncId?: string;
    antennaCoordLatitude?: string;
    antennaCoordLongitude?: string;
    siteName?: string;
    technology?: string;
    goldenParametersWbtsContentType?: string;
    goldenParametersWbts?: any;
    goldenParametersWcellContentType?: string;
    goldenParametersWcell?: any;
    goldenParametersWlcseContentType?: string;
    goldenParametersWlcse?: any;
    adjGid?: string;
    adjgNcc?: string;
    adjgBcc?: string;
    adjgBcch?: string;
    adjgBandIndicator?: string;
    adjgCi?: string;
    adjgLac?: string;
    adjsId?: string;
    adjsCi?: string;
    adjsLac?: string;
    adjsRac?: string;
    adjsRnCid?: string;
    adjsSrcCode?: string;
    adjiId?: string;
    adjiCi?: string;
    adjiLac?: string;
    adjiRac?: string;
    adjiRnCid?: string;
    adjiSrcCode?: string;
    bscId?: string;
    bcfId?: string;
    btsId?: string;
    adjwCid?: string;
    adjwLac?: string;
    adjwRncId?: string;
    scramblingCode?: string;
    goldenParametersAdjiContentType?: string;
    goldenParametersAdji?: any;
    goldenParametersAdjsContentType?: string;
    goldenParametersAdjs?: any;
    goldenParametersAdjgContentType?: string;
    goldenParametersAdjg?: any;
    goldenParametersAdjwContentType?: string;
    goldenParametersAdjw?: any;
    rfDatabase?: any;
    neighborDatabase?: any;
    outputWbtsContentType?: string;
    outputWbts?: any;
    outputWcellContentType?: string;
    outputWcell?: any;
    outputWcellAcContentType?: string;
    outputWcellAc?: any;
    outputWcellLcContentType?: string;
    outputWcellLc?: any;
    outputWcellPcContentType?: string;
    outputWcellPc?: any;
    outputWcellHcContentType?: string;
    outputWcellHc?: any;
    outputWcellPSContentType?: string;
    outputWcellPS?: any;
    outputWcellSibContentType?: string;
    outputWcellSib?: any;
    outputWcellUraidContentType?: string;
    outputWcellUraid?: any;
    outputWlcseContentType?: string;
    outputWlcse?: any;
    outputAdjiContentType?: string;
    outputAdji?: any;
    outputAdjsContentType?: string;
    outputAdjs?: any;
    outputAdjgContentType?: string;
    outputAdjg?: any;
    outputAdjwContentType?: string;
    outputAdjw?: any;
}

export class NewSiteCreation implements INewSiteCreation {
    constructor(
        public id?: number,
        public requestName?: string,
        public wbtsId?: string,
        public rncId?: string,
        public wbtsName?: string,
        public lcrId?: string,
        public lac?: string,
        public rac?: string,
        public sac?: string,
        public cId?: string,
        public templateName?: string,
        public priSrcCode?: string,
        public wlcseId?: string,
        public antBearing?: string,
        public wlcseRncId?: string,
        public antennaCoordLatitude?: string,
        public antennaCoordLongitude?: string,
        public siteName?: string,
        public technology?: string,
        public goldenParametersWbtsContentType?: string,
        public goldenParametersWbts?: any,
        public goldenParametersWcellContentType?: string,
        public goldenParametersWcell?: any,
        public goldenParametersWlcseContentType?: string,
        public goldenParametersWlcse?: any,
        public adjGid?: string,
        public adjgNcc?: string,
        public adjgBcc?: string,
        public adjgBcch?: string,
        public adjgBandIndicator?: string,
        public adjgCi?: string,
        public adjgLac?: string,
        public adjsId?: string,
        public adjsCi?: string,
        public adjsLac?: string,
        public adjsRac?: string,
        public adjsRnCid?: string,
        public adjsSrcCode?: string,
        public adjiId?: string,
        public adjiCi?: string,
        public adjiLac?: string,
        public adjiRac?: string,
        public adjiRnCid?: string,
        public adjiSrcCode?: string,
        public bscId?: string,
        public bcfId?: string,
        public btsId?: string,
        public adjwCid?: string,
        public adjwLac?: string,
        public adjwRncId?: string,
        public scramblingCode?: string,
        public goldenParametersAdjiContentType?: string,
        public goldenParametersAdji?: any,
        public goldenParametersAdjsContentType?: string,
        public goldenParametersAdjs?: any,
        public goldenParametersAdjgContentType?: string,
        public goldenParametersAdjg?: any,
        public goldenParametersAdjwContentType?: string,
        public goldenParametersAdjw?: any,
        public rfDatabase?: any,
        public neighborDatabase?: any,
        public outputWbtsContentType?: string,
        public outputWbts?: any,
        public outputWcellContentType?: string,
        public outputWcell?: any,
        public outputWcellAcContentType?: string,
        public outputWcellAc?: any,
        public outputWcellLcContentType?: string,
        public outputWcellLc?: any,
        public outputWcellPcContentType?: string,
        public outputWcellPc?: any,
        public outputWcellHcContentType?: string,
        public outputWcellHc?: any,
        public outputWcellPSContentType?: string,
        public outputWcellPS?: any,
        public outputWcellSibContentType?: string,
        public outputWcellSib?: any,
        public outputWcellUraidContentType?: string,
        public outputWcellUraid?: any,
        public outputWlcseContentType?: string,
        public outputWlcse?: any,
        public outputAdjiContentType?: string,
        public outputAdji?: any,
        public outputAdjsContentType?: string,
        public outputAdjs?: any,
        public outputAdjgContentType?: string,
        public outputAdjg?: any,
        public outputAdjwContentType?: string,
        public outputAdjw?: any
    ) {}
}
