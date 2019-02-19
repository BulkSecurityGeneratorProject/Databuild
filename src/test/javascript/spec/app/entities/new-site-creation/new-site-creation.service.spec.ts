/* tslint:disable max-line-length */
import { TestBed, getTestBed } from '@angular/core/testing';
import { HttpClientTestingModule, HttpTestingController } from '@angular/common/http/testing';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { of } from 'rxjs';
import { take, map } from 'rxjs/operators';
import { NewSiteCreationService } from 'app/entities/new-site-creation/new-site-creation.service';
import { INewSiteCreation, NewSiteCreation } from 'app/shared/model/new-site-creation.model';

describe('Service Tests', () => {
    describe('NewSiteCreation Service', () => {
        let injector: TestBed;
        let service: NewSiteCreationService;
        let httpMock: HttpTestingController;
        let elemDefault: INewSiteCreation;
        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [HttpClientTestingModule]
            });
            injector = getTestBed();
            service = injector.get(NewSiteCreationService);
            httpMock = injector.get(HttpTestingController);

            elemDefault = new NewSiteCreation(
                0,
                'AAAAAAA',
                'AAAAAAA',
                'AAAAAAA',
                'AAAAAAA',
                'AAAAAAA',
                'AAAAAAA',
                'AAAAAAA',
                'AAAAAAA',
                'AAAAAAA',
                'AAAAAAA',
                'AAAAAAA',
                'AAAAAAA',
                'AAAAAAA',
                'AAAAAAA',
                'AAAAAAA',
                'AAAAAAA',
                'AAAAAAA',
                'AAAAAAA',
                'AAAAAAA',
                'AAAAAAA',
                'AAAAAAA',
                'AAAAAAA',
                'AAAAAAA',
                'AAAAAAA',
                'AAAAAAA',
                'AAAAAAA',
                'AAAAAAA',
                'AAAAAAA',
                'AAAAAAA',
                'AAAAAAA',
                'AAAAAAA',
                'AAAAAAA',
                'AAAAAAA',
                'AAAAAAA',
                'AAAAAAA',
                'AAAAAAA',
                'AAAAAAA',
                'AAAAAAA',
                'AAAAAAA',
                'AAAAAAA',
                'AAAAAAA',
                'AAAAAAA',
                'AAAAAAA',
                'AAAAAAA',
                'AAAAAAA',
                'AAAAAAA',
                'AAAAAAA',
                'AAAAAAA',
                'AAAAAAA',
                'AAAAAAA',
                'AAAAAAA',
                'AAAAAAA',
                'AAAAAAA',
                'AAAAAAA',
                'AAAAAAA',
                'AAAAAAA',
                'AAAAAAA',
                'AAAAAAA',
                'AAAAAAA',
                'AAAAAAA',
                'AAAAAAA',
                'AAAAAAA',
                'AAAAAAA',
                'AAAAAAA',
                'AAAAAAA',
                'AAAAAAA',
                'AAAAAAA'
            );
        });

        describe('Service methods', async () => {
            it('should find an element', async () => {
                const returnedFromService = Object.assign({}, elemDefault);
                service
                    .find(123)
                    .pipe(take(1))
                    .subscribe(resp => expect(resp).toMatchObject({ body: elemDefault }));

                const req = httpMock.expectOne({ method: 'GET' });
                req.flush(JSON.stringify(returnedFromService));
            });

            it('should create a NewSiteCreation', async () => {
                const returnedFromService = Object.assign(
                    {
                        id: 0
                    },
                    elemDefault
                );
                const expected = Object.assign({}, returnedFromService);
                service
                    .create(new NewSiteCreation(null))
                    .pipe(take(1))
                    .subscribe(resp => expect(resp).toMatchObject({ body: expected }));
                const req = httpMock.expectOne({ method: 'POST' });
                req.flush(JSON.stringify(returnedFromService));
            });

            it('should update a NewSiteCreation', async () => {
                const returnedFromService = Object.assign(
                    {
                        requestName: 'BBBBBB',
                        wbtsId: 'BBBBBB',
                        rncId: 'BBBBBB',
                        wbtsName: 'BBBBBB',
                        lcrId: 'BBBBBB',
                        lac: 'BBBBBB',
                        rac: 'BBBBBB',
                        sac: 'BBBBBB',
                        cId: 'BBBBBB',
                        templateName: 'BBBBBB',
                        priSrcCode: 'BBBBBB',
                        wlcseId: 'BBBBBB',
                        antBearing: 'BBBBBB',
                        wlcseRncId: 'BBBBBB',
                        antennaCoordLatitude: 'BBBBBB',
                        antennaCoordLongitude: 'BBBBBB',
                        siteName: 'BBBBBB',
                        technology: 'BBBBBB',
                        goldenParametersWbts: 'BBBBBB',
                        goldenParametersWcell: 'BBBBBB',
                        goldenParametersWlcse: 'BBBBBB',
                        adjGid: 'BBBBBB',
                        adjgNcc: 'BBBBBB',
                        adjgBcc: 'BBBBBB',
                        adjgBcch: 'BBBBBB',
                        adjgBandIndicator: 'BBBBBB',
                        adjgCi: 'BBBBBB',
                        adjgLac: 'BBBBBB',
                        adjsId: 'BBBBBB',
                        adjsCi: 'BBBBBB',
                        adjsLac: 'BBBBBB',
                        adjsRac: 'BBBBBB',
                        adjsRnCid: 'BBBBBB',
                        adjsSrcCode: 'BBBBBB',
                        adjiId: 'BBBBBB',
                        adjiCi: 'BBBBBB',
                        adjiLac: 'BBBBBB',
                        adjiRac: 'BBBBBB',
                        adjiRnCid: 'BBBBBB',
                        adjiSrcCode: 'BBBBBB',
                        bscId: 'BBBBBB',
                        bcfId: 'BBBBBB',
                        btsId: 'BBBBBB',
                        adjwCid: 'BBBBBB',
                        adjwLac: 'BBBBBB',
                        adjwRncId: 'BBBBBB',
                        scramblingCode: 'BBBBBB',
                        goldenParametersAdji: 'BBBBBB',
                        goldenParametersAdjs: 'BBBBBB',
                        goldenParametersAdjg: 'BBBBBB',
                        goldenParametersAdjw: 'BBBBBB',
                        rfDatabase: 'BBBBBB',
                        neighborDatabase: 'BBBBBB',
                        outputWbts: 'BBBBBB',
                        outputWcell: 'BBBBBB',
                        outputWcellAc: 'BBBBBB',
                        outputWcellLc: 'BBBBBB',
                        outputWcellPc: 'BBBBBB',
                        outputWcellHc: 'BBBBBB',
                        outputWcellPS: 'BBBBBB',
                        outputWcellSib: 'BBBBBB',
                        outputWcellUraid: 'BBBBBB',
                        outputWlcse: 'BBBBBB',
                        outputAdji: 'BBBBBB',
                        outputAdjs: 'BBBBBB',
                        outputAdjg: 'BBBBBB',
                        outputAdjw: 'BBBBBB'
                    },
                    elemDefault
                );

                const expected = Object.assign({}, returnedFromService);
                service
                    .update(expected)
                    .pipe(take(1))
                    .subscribe(resp => expect(resp).toMatchObject({ body: expected }));
                const req = httpMock.expectOne({ method: 'PUT' });
                req.flush(JSON.stringify(returnedFromService));
            });

            it('should return a list of NewSiteCreation', async () => {
                const returnedFromService = Object.assign(
                    {
                        requestName: 'BBBBBB',
                        wbtsId: 'BBBBBB',
                        rncId: 'BBBBBB',
                        wbtsName: 'BBBBBB',
                        lcrId: 'BBBBBB',
                        lac: 'BBBBBB',
                        rac: 'BBBBBB',
                        sac: 'BBBBBB',
                        cId: 'BBBBBB',
                        templateName: 'BBBBBB',
                        priSrcCode: 'BBBBBB',
                        wlcseId: 'BBBBBB',
                        antBearing: 'BBBBBB',
                        wlcseRncId: 'BBBBBB',
                        antennaCoordLatitude: 'BBBBBB',
                        antennaCoordLongitude: 'BBBBBB',
                        siteName: 'BBBBBB',
                        technology: 'BBBBBB',
                        goldenParametersWbts: 'BBBBBB',
                        goldenParametersWcell: 'BBBBBB',
                        goldenParametersWlcse: 'BBBBBB',
                        adjGid: 'BBBBBB',
                        adjgNcc: 'BBBBBB',
                        adjgBcc: 'BBBBBB',
                        adjgBcch: 'BBBBBB',
                        adjgBandIndicator: 'BBBBBB',
                        adjgCi: 'BBBBBB',
                        adjgLac: 'BBBBBB',
                        adjsId: 'BBBBBB',
                        adjsCi: 'BBBBBB',
                        adjsLac: 'BBBBBB',
                        adjsRac: 'BBBBBB',
                        adjsRnCid: 'BBBBBB',
                        adjsSrcCode: 'BBBBBB',
                        adjiId: 'BBBBBB',
                        adjiCi: 'BBBBBB',
                        adjiLac: 'BBBBBB',
                        adjiRac: 'BBBBBB',
                        adjiRnCid: 'BBBBBB',
                        adjiSrcCode: 'BBBBBB',
                        bscId: 'BBBBBB',
                        bcfId: 'BBBBBB',
                        btsId: 'BBBBBB',
                        adjwCid: 'BBBBBB',
                        adjwLac: 'BBBBBB',
                        adjwRncId: 'BBBBBB',
                        scramblingCode: 'BBBBBB',
                        goldenParametersAdji: 'BBBBBB',
                        goldenParametersAdjs: 'BBBBBB',
                        goldenParametersAdjg: 'BBBBBB',
                        goldenParametersAdjw: 'BBBBBB',
                        rfDatabase: 'BBBBBB',
                        neighborDatabase: 'BBBBBB',
                        outputWbts: 'BBBBBB',
                        outputWcell: 'BBBBBB',
                        outputWcellAc: 'BBBBBB',
                        outputWcellLc: 'BBBBBB',
                        outputWcellPc: 'BBBBBB',
                        outputWcellHc: 'BBBBBB',
                        outputWcellPS: 'BBBBBB',
                        outputWcellSib: 'BBBBBB',
                        outputWcellUraid: 'BBBBBB',
                        outputWlcse: 'BBBBBB',
                        outputAdji: 'BBBBBB',
                        outputAdjs: 'BBBBBB',
                        outputAdjg: 'BBBBBB',
                        outputAdjw: 'BBBBBB'
                    },
                    elemDefault
                );
                const expected = Object.assign({}, returnedFromService);
                service
                    .query(expected)
                    .pipe(take(1), map(resp => resp.body))
                    .subscribe(body => expect(body).toContainEqual(expected));
                const req = httpMock.expectOne({ method: 'GET' });
                req.flush(JSON.stringify([returnedFromService]));
                httpMock.verify();
            });

            it('should delete a NewSiteCreation', async () => {
                const rxPromise = service.delete(123).subscribe(resp => expect(resp.ok));

                const req = httpMock.expectOne({ method: 'DELETE' });
                req.flush({ status: 200 });
            });
        });

        afterEach(() => {
            httpMock.verify();
        });
    });
});
