import {Injectable} from '@angular/core';
import {Http, Headers, Response, RequestOptions, URLSearchParams} from '@angular/http';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';
import 'rxjs/add/observable/throw';
import {Observable} from "rxjs/Observable";
import {IAuthenticationService} from "../iauthentication.service";
import Roles from "../../model/role";
import {Users} from "../../model/user";
import {BehaviorSubject} from "rxjs";

const AUTH_USER_PATH: string = 'api/auth';
const REGISTER_USER_PATH = 'api/register';

@Injectable()
export class AuthenticationService implements IAuthenticationService {

    constructor(private http: Http) {
    }

    login(username: string, password: string): Observable<boolean> {
        return this.http.post(AUTH_USER_PATH, JSON.stringify({username: username, password: password}),
            this.getPlainRequestOptions())
            .map((response: Response) => {
                let token: string = response.headers.get('Authorization').slice(7);
                let authorities: string[] = JSON.parse(response.text());
                console.log(authorities);
                if (token) {
                    localStorage.setItem('token', JSON.stringify(token));
                    localStorage.setItem('authorities', response.text());
                    return true;
                } else {
                    return false;
                }
            })
            .catch((error: any) => Observable.throw(error));
    }

    logout(): void {
        localStorage.removeItem('token');
        localStorage.removeItem('authorities');
    }

    register(user: Users): Observable<Users> {
        return this.http.post(REGISTER_USER_PATH, JSON.stringify(user), this.getPlainRequestOptions())
            .map((response: Response) => {
                response.json();
            })
            .catch((error: any) => Observable.throw(error));
    }

    isLoggedIn(): boolean {
        return !!localStorage.getItem('token');
    }

    private getPlainRequestOptions(): RequestOptions {
        return new RequestOptions({
                headers: new Headers({
                    'Content-Type': 'application/json'
                })
            }
        );
    }
}