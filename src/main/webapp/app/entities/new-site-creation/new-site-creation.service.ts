import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';

import { SERVER_API_URL } from 'app/app.constants';
import { createRequestOption } from 'app/shared';
import { INewSiteCreation } from 'app/shared/model/new-site-creation.model';

type EntityResponseType = HttpResponse<INewSiteCreation>;
type EntityArrayResponseType = HttpResponse<INewSiteCreation[]>;

@Injectable({ providedIn: 'root' })
export class NewSiteCreationService {
    private resourceUrl = SERVER_API_URL + 'api/new-site-creations';

    constructor(private http: HttpClient) {}

    create(newSiteCreation: INewSiteCreation): Observable<EntityResponseType> {
        return this.http.post<INewSiteCreation>(this.resourceUrl, newSiteCreation, { observe: 'response' });
    }

    update(newSiteCreation: INewSiteCreation): Observable<EntityResponseType> {
        return this.http.put<INewSiteCreation>(this.resourceUrl, newSiteCreation, { observe: 'response' });
    }

    find(id: number): Observable<EntityResponseType> {
        return this.http.get<INewSiteCreation>(`${this.resourceUrl}/${id}`, { observe: 'response' });
    }

    query(req?: any): Observable<EntityArrayResponseType> {
        const options = createRequestOption(req);
        return this.http.get<INewSiteCreation[]>(this.resourceUrl, { params: options, observe: 'response' });
    }

    delete(id: number): Observable<HttpResponse<any>> {
        return this.http.delete<any>(`${this.resourceUrl}/${id}`, { observe: 'response' });
    }
}
