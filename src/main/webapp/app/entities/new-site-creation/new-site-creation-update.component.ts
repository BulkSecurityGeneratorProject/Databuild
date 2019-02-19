import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpResponse, HttpErrorResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { JhiDataUtils } from 'ng-jhipster';

import { INewSiteCreation } from 'app/shared/model/new-site-creation.model';
import { NewSiteCreationService } from './new-site-creation.service';

@Component({
    selector: 'jhi-new-site-creation-update',
    templateUrl: './new-site-creation-update.component.html'
})
export class NewSiteCreationUpdateComponent implements OnInit {
    newSiteCreation: INewSiteCreation;
    isSaving: boolean;

    constructor(
        private dataUtils: JhiDataUtils,
        private newSiteCreationService: NewSiteCreationService,
        private activatedRoute: ActivatedRoute
    ) {}

    ngOnInit() {
        this.isSaving = false;
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

    setFileData(event, entity, field, isImage) {
        this.dataUtils.setFileData(event, entity, field, isImage);
    }

    previousState() {
        window.history.back();
    }

    save() {
        this.isSaving = true;
        if (this.newSiteCreation.id !== undefined) {
            this.subscribeToSaveResponse(this.newSiteCreationService.update(this.newSiteCreation));
        } else {
            this.subscribeToSaveResponse(this.newSiteCreationService.create(this.newSiteCreation));
        }
    }

    private subscribeToSaveResponse(result: Observable<HttpResponse<INewSiteCreation>>) {
        result.subscribe((res: HttpResponse<INewSiteCreation>) => this.onSaveSuccess(), (res: HttpErrorResponse) => this.onSaveError());
    }

    private onSaveSuccess() {
        this.isSaving = false;
        this.previousState();
    }

    private onSaveError() {
        this.isSaving = false;
    }
}
