/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, fakeAsync, tick } from '@angular/core/testing';
import { HttpResponse } from '@angular/common/http';
import { Observable, of } from 'rxjs';

import { DatabuildJavaTestModule } from '../../../test.module';
import { NewSiteCreationUpdateComponent } from 'app/entities/new-site-creation/new-site-creation-update.component';
import { NewSiteCreationService } from 'app/entities/new-site-creation/new-site-creation.service';
import { NewSiteCreation } from 'app/shared/model/new-site-creation.model';

describe('Component Tests', () => {
    describe('NewSiteCreation Management Update Component', () => {
        let comp: NewSiteCreationUpdateComponent;
        let fixture: ComponentFixture<NewSiteCreationUpdateComponent>;
        let service: NewSiteCreationService;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [DatabuildJavaTestModule],
                declarations: [NewSiteCreationUpdateComponent]
            })
                .overrideTemplate(NewSiteCreationUpdateComponent, '')
                .compileComponents();

            fixture = TestBed.createComponent(NewSiteCreationUpdateComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(NewSiteCreationService);
        });

        describe('save', () => {
            it(
                'Should call update service on save for existing entity',
                fakeAsync(() => {
                    // GIVEN
                    const entity = new NewSiteCreation(123);
                    spyOn(service, 'update').and.returnValue(of(new HttpResponse({ body: entity })));
                    comp.newSiteCreation = entity;
                    // WHEN
                    comp.save();
                    tick(); // simulate async

                    // THEN
                    expect(service.update).toHaveBeenCalledWith(entity);
                    expect(comp.isSaving).toEqual(false);
                })
            );

            it(
                'Should call create service on save for new entity',
                fakeAsync(() => {
                    // GIVEN
                    const entity = new NewSiteCreation();
                    spyOn(service, 'create').and.returnValue(of(new HttpResponse({ body: entity })));
                    comp.newSiteCreation = entity;
                    // WHEN
                    comp.save();
                    tick(); // simulate async

                    // THEN
                    expect(service.create).toHaveBeenCalledWith(entity);
                    expect(comp.isSaving).toEqual(false);
                })
            );
        });
    });
});
