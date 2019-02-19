import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

import { NgbActiveModal, NgbModal, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { INewSiteCreation } from 'app/shared/model/new-site-creation.model';
import { NewSiteCreationService } from './new-site-creation.service';

@Component({
    selector: 'jhi-new-site-creation-delete-dialog',
    templateUrl: './new-site-creation-delete-dialog.component.html'
})
export class NewSiteCreationDeleteDialogComponent {
    newSiteCreation: INewSiteCreation;

    constructor(
        private newSiteCreationService: NewSiteCreationService,
        public activeModal: NgbActiveModal,
        private eventManager: JhiEventManager
    ) {}

    clear() {
        this.activeModal.dismiss('cancel');
    }

    confirmDelete(id: number) {
        this.newSiteCreationService.delete(id).subscribe(response => {
            this.eventManager.broadcast({
                name: 'newSiteCreationListModification',
                content: 'Deleted an newSiteCreation'
            });
            this.activeModal.dismiss(true);
        });
    }
}

@Component({
    selector: 'jhi-new-site-creation-delete-popup',
    template: ''
})
export class NewSiteCreationDeletePopupComponent implements OnInit, OnDestroy {
    private ngbModalRef: NgbModalRef;

    constructor(private activatedRoute: ActivatedRoute, private router: Router, private modalService: NgbModal) {}

    ngOnInit() {
        this.activatedRoute.data.subscribe(({ newSiteCreation }) => {
            setTimeout(() => {
                this.ngbModalRef = this.modalService.open(NewSiteCreationDeleteDialogComponent as Component, {
                    size: 'lg',
                    backdrop: 'static'
                });
                this.ngbModalRef.componentInstance.newSiteCreation = newSiteCreation;
                this.ngbModalRef.result.then(
                    result => {
                        this.router.navigate([{ outlets: { popup: null } }], { replaceUrl: true, queryParamsHandling: 'merge' });
                        this.ngbModalRef = null;
                    },
                    reason => {
                        this.router.navigate([{ outlets: { popup: null } }], { replaceUrl: true, queryParamsHandling: 'merge' });
                        this.ngbModalRef = null;
                    }
                );
            }, 0);
        });
    }

    ngOnDestroy() {
        this.ngbModalRef = null;
    }
}
