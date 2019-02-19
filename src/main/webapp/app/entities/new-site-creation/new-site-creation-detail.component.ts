import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { JhiDataUtils } from 'ng-jhipster';

import { INewSiteCreation } from 'app/shared/model/new-site-creation.model';

@Component({
    selector: 'jhi-new-site-creation-detail',
    templateUrl: './new-site-creation-detail.component.html'
})
export class NewSiteCreationDetailComponent implements OnInit {
    newSiteCreation: INewSiteCreation;

    constructor(private dataUtils: JhiDataUtils, private activatedRoute: ActivatedRoute) {}

    ngOnInit() {
        this.activatedRoute.data.subscribe(({ newSiteCreation }) => {
            this.newSiteCreation = newSiteCreation;
        });
    }

    byteSize(field) {
        return this.dataUtils.byteSize(field);
    }

    openFile(contentType, field) {
        return this.dataUtils.openFile(contentType, field);
    }
    previousState() {
        window.history.back();
    }
}
