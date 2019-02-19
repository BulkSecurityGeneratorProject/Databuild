import { Injectable } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { Resolve, ActivatedRouteSnapshot, RouterStateSnapshot, Routes } from '@angular/router';
import { JhiPaginationUtil, JhiResolvePagingParams } from 'ng-jhipster';
import { UserRouteAccessService } from 'app/core';
import { of } from 'rxjs';
import { map } from 'rxjs/operators';
import { NewSiteCreation } from 'app/shared/model/new-site-creation.model';
import { NewSiteCreationService } from './new-site-creation.service';
import { NewSiteCreationComponent } from './new-site-creation.component';
import { NewSiteCreationDetailComponent } from './new-site-creation-detail.component';
import { NewSiteCreationUpdateComponent } from './new-site-creation-update.component';
import { NewSiteCreationDeletePopupComponent } from './new-site-creation-delete-dialog.component';
import { INewSiteCreation } from 'app/shared/model/new-site-creation.model';

@Injectable({ providedIn: 'root' })
export class NewSiteCreationResolve implements Resolve<INewSiteCreation> {
    constructor(private service: NewSiteCreationService) {}

    resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
        const id = route.params['id'] ? route.params['id'] : null;
        if (id) {
            return this.service.find(id).pipe(map((newSiteCreation: HttpResponse<NewSiteCreation>) => newSiteCreation.body));
        }
        return of(new NewSiteCreation());
    }
}

export const newSiteCreationRoute: Routes = [
    {
        path: 'new-site-creation',
        component: NewSiteCreationComponent,
        resolve: {
            pagingParams: JhiResolvePagingParams
        },
        data: {
            authorities: ['ROLE_USER'],
            defaultSort: 'id,asc',
            pageTitle: 'NewSiteCreations'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: 'new-site-creation/:id/view',
        component: NewSiteCreationDetailComponent,
        resolve: {
            newSiteCreation: NewSiteCreationResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'NewSiteCreations'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: 'new-site-creation/new',
        component: NewSiteCreationUpdateComponent,
        resolve: {
            newSiteCreation: NewSiteCreationResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'NewSiteCreations'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: 'new-site-creation/:id/edit',
        component: NewSiteCreationUpdateComponent,
        resolve: {
            newSiteCreation: NewSiteCreationResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'NewSiteCreations'
        },
        canActivate: [UserRouteAccessService]
    }
];

export const newSiteCreationPopupRoute: Routes = [
    {
        path: 'new-site-creation/:id/delete',
        component: NewSiteCreationDeletePopupComponent,
        resolve: {
            newSiteCreation: NewSiteCreationResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'NewSiteCreations'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    }
];
