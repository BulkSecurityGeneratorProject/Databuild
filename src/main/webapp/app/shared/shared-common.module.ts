import { NgModule } from '@angular/core';

import { DatabuildJavaSharedLibsModule, JhiAlertComponent, JhiAlertErrorComponent } from './';

@NgModule({
    imports: [DatabuildJavaSharedLibsModule],
    declarations: [JhiAlertComponent, JhiAlertErrorComponent],
    exports: [DatabuildJavaSharedLibsModule, JhiAlertComponent, JhiAlertErrorComponent]
})
export class DatabuildJavaSharedCommonModule {}
