/* tslint:disable max-line-length */
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { ActivatedRoute } from '@angular/router';
import { of } from 'rxjs';

import { DatabuildJavaTestModule } from '../../../test.module';
import { NewSiteCreationDetailComponent } from 'app/entities/new-site-creation/new-site-creation-detail.component';
import { NewSiteCreation } from 'app/shared/model/new-site-creation.model';

describe('Component Tests', () => {
    describe('NewSiteCreation Management Detail Component', () => {
        let comp: NewSiteCreationDetailComponent;
        let fixture: ComponentFixture<NewSiteCreationDetailComponent>;
        const route = ({ data: of({ newSiteCreation: new NewSiteCreation(123) }) } as any) as ActivatedRoute;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [DatabuildJavaTestModule],
                declarations: [NewSiteCreationDetailComponent],
                providers: [{ provide: ActivatedRoute, useValue: route }]
            })
                .overrideTemplate(NewSiteCreationDetailComponent, '')
                .compileComponents();
            fixture = TestBed.createComponent(NewSiteCreationDetailComponent);
            comp = fixture.componentInstance;
        });

        describe('OnInit', () => {
            it('Should call load all on init', () => {
                // GIVEN

                // WHEN
                comp.ngOnInit();

                // THEN
                expect(comp.newSiteCreation).toEqual(jasmine.objectContaining({ id: 123 }));
            });
        });
    });
});
