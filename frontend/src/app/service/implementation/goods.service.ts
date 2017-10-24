import {Injectable} from "@angular/core";
import {Headers, Http, RequestOptions, Response} from "@angular/http";
import "rxjs/add/operator/toPromise";
import {Observable} from "rxjs";
import {IGoodsService} from "../igoods.service";
import {Goods} from "../../model/goods";

const GOODS_PATH = 'api/goods';

@Injectable()
export class GoodsService implements IGoodsService {

    constructor(private http: Http) {
    }

    getAll(): Observable<Goods[]> {
        return this.http.get(GOODS_PATH)
            .map((response: Response) => {
                return response.json();
            })
            .catch((error: any) => Observable.throw(error));
    }

    getOne(id: number): Observable<Goods> {
        const url = `${GOODS_PATH}/${id}`;
        return this.http.get(url, this.getPlainRequestOptions())
            .map((response: Response) => {
                return response.json();
            })
            .catch((error: any) => Observable.throw(error));
    }

    save(goods: Goods): Observable<Goods> {
        return this.http.post(GOODS_PATH, JSON.stringify(goods), this.getAuthRequestOptions())
            .map((response: Response) => {
                response.json();
            })
            .catch((error: any) => Observable.throw(error));
    }

    findByCategory(id: number): Observable<Goods[]> {
        return this.http.get('api/goods/category/' + id, this.getPlainRequestOptions())
            .map((response: Response) => {
                return response.json();
            })
            .catch((error: any) => Observable.throw(error));
    }

    private getAuthRequestOptions(): RequestOptions {
        return new RequestOptions({
                headers: new Headers({
                    'Content-Type': 'application/json',
                    'Authorization': 'Bearer ' + JSON.parse(localStorage.getItem('token'))
                })
            }
        );
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