import { Injectable } from '@angular/core';
import { HttpRequest, HttpHandler, HttpEvent, HttpInterceptor } from '@angular/common/http';
import { Observable } from 'rxjs';
import { StorageService } from '../services/storage.service';

@Injectable()
export class AuthInterceptor implements HttpInterceptor {

    constructor(
        private storageService: StorageService
    ) { }

    intercept(request: HttpRequest<unknown>, next: HttpHandler): Observable<HttpEvent<unknown>> {
        const token = this.storageService.getAuth()?.token;
        if (!token) {
            return next.handle(request);
        }

        return next.handle(request.clone({
            setHeaders: {
                Authorization: token
            }
        }));
    }
}
