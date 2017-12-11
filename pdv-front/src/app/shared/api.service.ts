import {Injectable} from "@angular/core";
import {environment} from "../../environments/environment";
import {Headers, Http, Response, URLSearchParams} from "@angular/http";
import {Observable} from "rxjs/Observable";
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';

import { JwtService } from './jwt.service';

@Injectable()
export class ApiService {

  constructor(private http: Http, private jwtService: JwtService) {}

  private configHeaders(): Headers {
    const headersConfig = {
      'ContentType': 'application/json',
      'Accept': 'application/json'
    }

    if(this.jwtService.getToken()) {
      headersConfig['Authorization'] = 'Token ${this.jwtService.getToken()}';
    }

    return new Headers(headersConfig);
  }

  private formatErrors(error: any) {
    return Observable.throw(error.json());
  }

  get(path: string, params: URLSearchParams = new URLSearchParams()): Observable<any> {
    return this.http.get(`${environment.api_url}${path}`, { headers: this.configHeaders(), search: params })
      .catch(this.formatErrors)
      .map((res: Response) => res.json());
  }

  put(path: string, body: Object = {}): Observable<any> {
    return this.http.put(
      `${environment.api_url}${path}`,
      JSON.stringify(body),
      { headers: this.configHeaders() }
    )
      .catch(this.formatErrors)
      .map((res: Response) => res.json());
  }

  post(path: string, body: Object = {}): Observable<any> {
    return this.http.post(
      `${environment.api_url}${path}`,
      JSON.stringify(body),
      { headers: this.configHeaders() }
    )
      .catch(this.formatErrors)
      .map((res: Response) => res.json());
  }

  delete(path): Observable<any> {
    return this.http.delete(
      `${environment.api_url}${path}`,
      { headers: this.configHeaders() }
    )
      .catch(this.formatErrors)
      .map((res: Response) => res.json());
  }

}
