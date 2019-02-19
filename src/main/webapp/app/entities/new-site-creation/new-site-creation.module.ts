import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';

import { DatabuildJavaSharedModule } from 'app/shared';
import {
    NewSiteCreationComponent,
    NewSiteCreationDetailComponent,
    NewSiteCreationUpdateComponent,
    NewSiteCreationDeletePopupComponent,
    NewSiteCreationDeleteDialogComponent,
    newSiteCreationRoute,
    newSiteCreationPopupRoute
} from './';

const ENTITY_STATES = [...newSiteCreationRoute, ...newSiteCreationPopupRoute];

@NgModule({
    imports: [DatabuildJavaSharedModule, RouterModule.forChild(ENTITY_STATES)],
    declarations: [
        NewSiteCreationComponent,
        NewSiteCreationDetailComponent,
        NewSiteCreationUpdateComponent,
        NewSiteCreationDeleteDialogComponent,
        NewSiteCreationDeletePopupComponent
    ],
    entryComponents: [
        NewSiteCreationComponent,
        NewSiteCreationUpdateComponent,
        NewSiteCreationDeleteDialogComponent,
        NewSiteCreationDeletePopupComponent
    ],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class DatabuildJavaNewSiteCreationModule {}
